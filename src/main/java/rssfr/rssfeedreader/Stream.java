/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rssfr.rssfeedreader;

import rssfr.Net.Network;
import rssfr.GUI.UICruft;
import java.util.List;

/**
 * This is a class that handels the high level view of setting and fetching
 * stream data from the network.
 *
 * @author bgran
 */
public class Stream {

    public Network netw = null;
    public String rss_url = null;

    String[] vals = null;

    /**
     * This is for the sake of tests. Doesn't do anything good.
     *
     * @return Nonsense
     */
    public String borken_interface() {
        return (rss_url);
    }

    /**
     * The ctor sets up networking with the Network class
     *
     * @param rss_url_ The locator of the rss stream.
     */
    public Stream(String rss_url_) {
        rss_url = rss_url_;

        netw = new Network();
    }

    /*public void refresh_content() {

     String new_data = get_HTTP_content();

     }*/
    /**
     * High level method to fetch data from an URL.
     */
    public void setup_content() {
        String data = get_HTTP_content();
        List<ngXMLElement> vals = null;

        try {
            vals = ngXML.do_parse(data);
        } catch (Exception err) {
            UICruft.info_box("XML p broke: " + err.getMessage(),
                    "XML error");
            return;
        }

    }

    /**
     * Sets up a HTTP connection and fetches the raw data.
     *
     * @return The URL content as String
     */
    public String get_HTTP_content() {
        this.netw.setUrlStr(rss_url);
        try {
            this.netw.init_url_connection();
            this.netw.init_io_connection();
            return this.netw.network_get_content();
        } catch (Exception e) {
            UICruft.info_box("Error fetching content: " + e.getMessage(), "ERROR");
            return (null);
        }
    }

}
