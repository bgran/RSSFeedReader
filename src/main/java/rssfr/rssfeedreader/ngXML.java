package rssfr.rssfeedreader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import rssfr.rssfeedreader.ngXMLElement.*;
import rssfr.rssfeedreader.Cruft.*;

public class ngXML {
    public static List<ngXMLElement> parse2(String data) throws Exception {
        List<ngXMLElement> rv = new ArrayList<ngXMLElement>();
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        DocumentBuilder builder = factory.newDocumentBuilder();

        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(data));
        Document doc = builder.parse(is);
        Element rootElement = doc.getDocumentElement();
        NodeList children = rootElement.getChildNodes();
       
        NodeList thekeys = doc.getElementsByTagName("title");
        NodeList thevals = doc.getElementsByTagName("link");
        
        Node k1, k2;
        
        int parallel_len = thekeys.getLength();
        for (int i = 0; i < parallel_len ; i++) {
            k1 = thekeys.item(i);
            k2 = thevals.item(i);
            
            String key = k1.getTextContent();
            String val = k2.getTextContent();
            
            ngXMLElement elem = new ngXMLElement(key, val);
            rv.add(elem);
        }
        
        return rv;
    }
    
    
    public static List<ngXMLElement> do_parse(String data) throws Exception {
            List<ngXMLElement> tmp = new ArrayList<ngXMLElement>();
            //List<String> conversion = new ArrayList<String>();
            tmp = ngXML.parse2(data);
            return (tmp);
    }
}
