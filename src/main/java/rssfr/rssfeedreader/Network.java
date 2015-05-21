/**
 * 
 */
package rssfr.rssfeedreader;

import java.net.*;
import java.io.*;

import rssfr.rssfeedreader.ErrorNetwork;
/**
 * @author bgran
 * @version 0.1
 */
public class Network {
        /** Description of getUrl(String url)
         * 
         * @param url The URL we want to fetch.
         * @return Returns a String containing the RSS feed form.
         * @throws ErrorNetwork In case of errors.
         */
	public static String getUrl(String url) throws ErrorNetwork {
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
                        throw new ErrorNetwork("Malformed URL");
		} catch (IOException e) {
                        throw new ErrorNetwork("IO Exception");
		} catch (Throwable e) {
                        throw new ErrorNetwork("Generic error");
                }
	}
	
	
	
}
