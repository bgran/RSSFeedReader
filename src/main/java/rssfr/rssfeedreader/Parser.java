package rssfr.rssfeedreader;

import java.util.*;
import rssfr.rssfeedreader.XMLElement.*;
import rssfr.rssfeedreader.XMLMalformedExc.*;

public class Parser {
	protected String input;
	private int pos;
	//private SortedSet<String> tree;
	private final char startTag = '<';
	private final char stopTag = '>';
	private final char endTag = '/';
	
	private XMLElement rootElem;
	
	public Parser(String i) {
		this.input = i;
		pos = 0;
	}
	public Parser() {
		pos = 0;
		
	}
	public void pushData(String i) {
		this.input = i;
	}

	/*
	 * <document>
	 *   <kala>
	 *     ateria
	 *     <hauki>
	 *        toinen ateria
	 *     </hauki>
	 *     srtrt
	 *   </kala>
	 * </document>
	 */
	
	public XMLElement parseXML(String xml, XMLElement root) {
		//Stack<XMLElement> st = new Stack<XMLElement>();
		Stack st = new Stack();
                
		int state = 0;
		String elemName = new String("");
		//String elemVal = new String("");
		XMLElement tmp = root;
		for(int i = 0 ; i < xml.length() ; i++) {
			char currChar = xml.charAt(i);
			//System.out.println("currChar: " + currChar);
			if (currChar == startTag) {
				state = 1; 
			} else if (currChar == stopTag) {
				if (state == 3) {
					state = 4;
				} else {
					st.push(tmp);
					tmp = tmp.addNew(elemName);
					elemName = "";
					state = 2;
				}
			} else if (currChar == endTag) {
				//System.out.println("currChar == endTag: " + currChar);
				tmp =(XMLElement) st.pop();
                                // PRKL!
				state = 3;
				System.out.println("currChar == endTag");
			} else {
				if (state == 1) {
					elemName += currChar;
				} else if (state == 2) {
					elemName = "";
					state = 4;
					tmp.pushData(currChar);
				} else if (state == 3) {
					System.out.println ("THE SMOKING GUN");
				} else if (state == 4) {
					//if (currChar != ' ') {<<<
						tmp.pushData(currChar);
					//}
				} else {
					System.out.println("stray shit: " + currChar);
				}
			}
		}
		return (root);
	}
	
	public void recParse(String buf, XMLElement root) {
		/*
		 * parseState gets the following values:
		 *  0) we are in this stack frame for the first loops.
		 *  1) we are inside a element start tag.
		 *  
		 */
		int parseState = 0;
		String elemN = new String("");
		
		for (int i=0; i<buf.length(); i++) {
			char currChar = buf.charAt(i);
			//System.out.println("currChar: " + currChar);
			if (parseState == 0) {
				if (currChar == startTag) {
					parseState = 1;
				}
				/* 
				 * Anything else is discarded at the beginning.
				 */
			} else {
				if (currChar == stopTag) {
					String rest = buf.substring(i+1);
					System.out.println("rest: " + rest);
					System.out.println("elemN: "+ elemN);
					recParse(rest, root.addNew(elemN));
				} else if (parseState == 1) {
					elemN += currChar;
				}
			}
		}
	}
}
