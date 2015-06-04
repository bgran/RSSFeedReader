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
public class StreamTest {
    
    public StreamTest() {
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
    public void testBorkenInterface() {
        Stream stream = new Stream("haukikala");
        int trueval = stream.borken_interface().compareTo("haukikala");
        if (trueval == 0) {
            assertTrue(true);
        } else {
            assertFalse(true);
        }
    }
    
    @Test
    public void testCtor() {
        Stream newstream = new Stream("Kuhakala");
        if (newstream.netw != null) {
            assertTrue(true);
        } else {
            assertFalse(true);
        }
    }
   /*@Test
    public void testSetupContent() {
        Stream st = new Stream("http://sulaco.havoc.fi/bgran/jl/rss.xml");
        st.setup_content();
        int len = st.vals.length;
        if (len == 4) {
            assertTrue(true);
        } else {
            assertFalse(true);
        }
    }*/
}
