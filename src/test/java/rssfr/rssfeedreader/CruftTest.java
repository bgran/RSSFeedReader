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
public class CruftTest {
    
    public CruftTest() {
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
    public void testFileRead() {
        String file = new String("/etc/passwd");
        String result = "bogus";
        try {
            result = Cruft.read_file(file);
        } catch(Exception e) {
            //System.out.println("getUrl failed");
        }
        boolean e = result.equals("bogus");
        assertFalse(e);
        
    }
	@Test
	public void testExtractUrl() {
		String tester = "Foobar -> Spamni";
		String result = Cruft.extract_url(tester);
		if (result.equals("Spamni")) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
}
