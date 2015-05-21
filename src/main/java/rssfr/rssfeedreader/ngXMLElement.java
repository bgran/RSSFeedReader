package rssfr.rssfeedreader;

import rssfr.rssfeedreader.ngXML.*;

public class ngXMLElement {
    private String key;
    private String val;
    
    public ngXMLElement(String key_, String val_) {
        this.key = key_;
        this.val = val_;
    }
    
    public String getVal() {
        return this.val;
    }
    public String getKey() {
        return this.key;
    }
}
