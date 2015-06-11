/**
 *
 */
package rssfr.rssfeedreader;

import java.awt.Desktop;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import rssfr.GUI.UICruft;

import rssfr.rssfeedreader.ErrorNetwork;

/**
 * @author bgran
 * @version 0.1
 */
public class Network {

    private String urli = "http://sulaco.havoc.fi/bgran/jl/rss.xml";
    private String rss_content = "";
    private URL url;
    private BufferedReader input_reader;

    /**
     * Description of getUrl(String url)
     *
     * @param url The URL we want to fetch.
     * @return Returns a String containing the RSS feed form.
     * @throws ErrorNetwork In case of errors.
     */
    public Network() {
    }

    public void setUrlStr(String url) {
        this.urli = url;
    }

    public String getUrlStr() {
        return (this.urli);
    }

    public void init_url_connection() throws MalformedNetwork {
        try {
            this.url = new URL(this.urli);
        } catch (MalformedURLException e) {
            throw new MalformedNetwork("");
        }
    }

    public void init_io_connection() throws IOExcNetwork {
        try {
            URLConnection req = this.url.openConnection();
            input_reader = new BufferedReader(
                    new InputStreamReader(req.getInputStream()));
        } catch (IOException e) {
            throw new IOExcNetwork(e.toString());
        }
    }

    public String network_get_content() throws IOExcNetwork {
        try {
            String rv = "";
            String line;
            while ((line = input_reader.readLine()) != null) {
                rv += line;
            }
            input_reader.close();
            return (rv);
        } catch (IOException e) {
            throw new IOExcNetwork(e.toString());
        }
    }
    
    public static void open_browser(URI uri) {
       Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void open_browser(URL url) {
        try {
            open_browser(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    public static void open_browser(String _url) {
        try {
            URL tmpURL = new URL(_url);
            open_browser(tmpURL);
        } catch (MalformedURLException e) {
            UICruft.info_box("Bogus url: " + _url, "ERROR");
        }
    }
}
