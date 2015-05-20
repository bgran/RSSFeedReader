/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rssfr.rssfeedreader;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import rssfr.rssfeedreader.Network;

/**
 *
 * @author bgranlun
 */
public class NetworkTest {
    
    public NetworkTest() {
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
    @Test
    public void hello() {}
    
    @Test
    public void testNetwork() {
        String urli = new String("http://sulaco.havoc.fi/bgran/jl/assertti.html");
        String result = "bogus";
        try {
            result = Network.getUrl(urli);
        } catch(Exception e) {
            System.out.println("getUrl failed");
        }
        //String result = "Salainen viesti";
        boolean e = result.equals("Salainen viesti");
        assertTrue(e);
    }
}
