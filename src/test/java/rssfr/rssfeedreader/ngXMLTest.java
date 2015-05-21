/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rssfr.rssfeedreader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bgran
 */
public class ngXMLTest {
    
    public ngXMLTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testCorrect() {
        String content = "";
        try {
            content = Cruft.read_file("test.xml");
        } catch (IOException ex) {
            assertTrue(false);
        }
        
        List<ngXMLElement> k = new ArrayList<ngXMLElement>();
        try {
            k = ngXML.do_parse(content);
        } catch(Exception err) {
                assertTrue(false);
        }
        
        if (k != null) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
        
    }
    @Test
    public void testFalse() {
        String content = "";
        try {
            content = Cruft.read_file("broken.xml");
        } catch (IOException ex) {
            assertTrue(false);
        }
        List<ngXMLElement> k = new ArrayList<ngXMLElement>();
        try {
            k = ngXML.do_parse(content);
        } catch (Exception e) {
            assertTrue(true);
    
        }
        
    }
}
