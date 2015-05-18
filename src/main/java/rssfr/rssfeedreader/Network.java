/**
 * 
 */
package rssfr.rssfeedreader;

import java.net.*;
import java.io.*;

/**
 * @author bgran
 *
 */
public class Network {

	public static String getUrl(String url) {
		try {
			URL u = new URL(url);
			URLConnection req = u.openConnection();
			BufferedReader i = new BufferedReader(
					new InputStreamReader(req.getInputStream()));
			String rv = new String("");
			String line;
			while ((line = i.readLine()) != null) {
				rv += line;
			}
			i.close();
			return (rv);
		} catch (MalformedURLException e) { 
			System.out.println("MalformedURLException raised: " + e.getMessage());
			System.exit(1);
		} catch (IOException e) {
			System.out.println("IOException raised: " + e.getMessage());
			System.exit(1);		
		}
		
		return("");
	}
	
	
	
}
