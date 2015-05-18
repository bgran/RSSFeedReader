/**
 * 
 */
package rssfr.rssfeedreader;

import java.util.Collection;
import java.util.Iterator;

import rssfr.rssfeedreader.FilePoll;
import rssfr.rssfeedreader.Network;
import rssfr.rssfeedreader.XMLElement;
import rssfr.rssfeedreader.GUI;
import javax.swing.*;

/** Description of rssread
 * @author bgran
 * @vesion 0.1
 * @param
 */
public class rssread extends GUI {
	//GUI gui;
	JButton b;
	
	/** Description of main()
         * 
	 * @param args              Command-line arguments.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

                    public void run() {
                        System.out.println("Kalaa----");
                        rssread rss = new rssread();
                        rss.setVisible(true);
                    }
                }
            );
	}

        /** Description of rssread constructor.
         * 
         * 
         */
	public rssread() {
		System.out.println("rssread initializing");
		initUi();
	}
	/*public String join(Collection<String[]> collection) {
		StringBuffer buf = new StringBuffer();
		Iterator<String[]> i = collection.iterator();
		while (i.hasNext()) {
			buf.append(i.next());
		}
		return buf.toString();
	} */
        
}
