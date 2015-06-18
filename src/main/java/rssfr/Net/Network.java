/**
 *
 */
package rssfr.Net;

import java.awt.Desktop;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import rssfr.GUI.UICruft;

/**
 * This class implements network related functionality.
 *
 * @author bgran
 * @version 0.1
 */
public class Network {

    private String urli = "http://sulaco.havoc.fi/bgran/jl/rss.xml";
    private String rss_content = "";
    private URL url;
    private BufferedReader input_reader;

    public Network() {
    }

    public void setUrlStr(String url) {
        this.urli = url;
    }

    public String getUrlStr() {
        return (this.urli);
    }

    /**
     * Setup a URL connection.
     *
     * @throws MalformedNetwork URL malformed
     */
    public void init_url_connection() throws MalformedNetwork {
        try {
            this.url = new URL(this.urli);
        } catch (MalformedURLException e) {
            throw new MalformedNetwork("Err: " + e.getMessage());
        }
    }

    /**
     * Initialize I/O functionality.
     *
     * @throws IOExcNetwork I/O Exception
     */
    public void init_io_connection() throws IOExcNetwork {
        try {
            URLConnection req = this.url.openConnection();
            input_reader = new BufferedReader(
                    new InputStreamReader(req.getInputStream()));
        } catch (IOException e) {
            throw new IOExcNetwork(e.toString());
        }
    }

    /**
     * Fetch the data from the server and return it.
     *
     * @throws IOExcNetwork I/O Exception.
     * @return The XML document.
     */
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

    private static void open_browser(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void open_browser(URL url) {
        try {
            open_browser(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /**
     * Open a browser window with the _url locator.
     *
     * @param _url The address to open the browser with.
     */
    public static void open_browser(String _url) {
        try {
            URL tmpURL = new URL(_url);
            open_browser(tmpURL);
        } catch (MalformedURLException e) {
            UICruft.info_box("Bogus url: " + _url, "ERROR");
        }
    }
}
