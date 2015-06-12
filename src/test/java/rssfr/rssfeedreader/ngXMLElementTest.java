/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rssfr.rssfeedreader;

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
public class ngXMLElementTest {
    
    public ngXMLElementTest() {
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
    public void testElement() {
        ngXMLElement k = new ngXMLElement("foo", "bar");
        if ((k.getKey().compareTo("foo")) == 0 &&
                (k.getVal().compareTo("bar") == 0)) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
        
    }


}
