/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rssfr.rssfeedreader;

import java.util.List;

/**
 *
 * @author bgran
 */
public class Stream {

    public Network netw = null;
    public String rss_url = null;

    String[] vals = null;

    public String borken_interface() {
        return (rss_url);
    }

    public Stream(String rss_url_) {
        rss_url = rss_url_;

        netw = new Network();
    }

    public void refresh_content() {

        String new_data = get_HTTP_content();

    }

    public void setup_content() {
        String data = get_HTTP_content();
        List<ngXMLElement> vals = null;

        try {
            vals = ngXML.do_parse(data);
        } catch (Exception err) {
            Cruft.info_box("XML p broke: " + err.getMessage(),
                    "XML error");
            return;
        }

    }

    public String get_HTTP_content() {
        this.netw.setUrlStr(rss_url);
        try {
            this.netw.init_url_connection();
            this.netw.init_io_connection();
            return this.netw.network_get_content();
        } catch (Exception e) {
            Cruft.info_box("Uhuhuh", rss_url);
            return (null);
        }
    }

}
