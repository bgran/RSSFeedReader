/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rssfr.rssfeedreader;

import java.net.MalformedURLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import rssfr.rssfeedreader.Network;

/**
 *
 * @author bgranlun
 */
public class NetworkTest {
    
    public NetworkTest() {
    }
    //@Rule
    public ExpectedException exception = ExpectedException.none();
    
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
    
    /*@Test
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
    }*/
    /*@Test
    public void testNetworkFalse() {
        String urli = new String("http://devnull.local/asdf");
        String result = "bogus";
        try {
            result = Network.getUrl(urli);
        } catch(Exception e) {
            //System.out.println("getUrl failed");
        }
        boolean e = result.equals("bogus");
        assertTrue(e);
    }*/
    @Test(expected=MalformedNetwork.class)
    public void testNetworkMalformed()  {
        //String urli = "http://sulaco.havoc.fi/bgran/jl/malformed.xml";
        exception.expect(MalformedNetwork.class);
        String urli = "dsdfadfad";
        Network netw = new Network();
        netw.init_url_connection();
        //netw.init_url_connection();
        //netw.network_get_content();
    }
}
