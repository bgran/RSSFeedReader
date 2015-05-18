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

/**
 * @author bgran
 *
 */
public class rssread extends GUI {
	//GUI gui;
	JButton b;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

            public void run() {
            	System.out.println("Kalaa----");
                rssread rss = new rssread();
                rss.setVisible(true);
            }
        });
		//System.exit((new rssread()).my_main());
	}

	public rssread() {
		System.out.println("rssread initializing");
		initUi();
	}
	public String join(Collection<String[]> collection) {
		StringBuffer buf = new StringBuffer();
		Iterator<String[]> i = collection.iterator();
		while (i.hasNext()) {
			buf.append(i.next());
		}
		return buf.toString();
	}
	public int my_main() {
		boolean running = true;
		
		Parser parser = new Parser();
		
		XMLElement absR = new XMLElement("r");
		/*
		SwingUtilities.invokeLater(new Runnable() {

            public void run() {
            	System.out.println("Kalaa----");
                 g = new rssread();
                g.setVisible(true);
            }
        });
		*/
		//this.gui = new GUI();
		//this.gui.setVisible(true);
		//this.gui.swap();
		
		int out = 0;
		while (out==0) {
			System.out.println("While loop --");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Haukikalaa intterupti tuli");
				out = 1;
			}
		}
		while (running) {
			FilePoll file = new FilePoll("/home/bgran/.rssread");
			String[] lines = file.getContents();
			FilePoll xml = new FilePoll("/home/bgran/kala.xml");
			String xmla = xml.getRaw();
			
			absR = parser.parseXML(xmla, absR);
			absR.print(0);
			
			System.exit(0);
			
			for (int i=0; i<lines.length; i++) {
				System.out.println("The line is: " + lines[i]);
				String xmlContent = Network.getUrl(lines[i]);
				System.out.println("xmlContent: " + xmlContent);
				// 
			}
			running = false;
		}
		
		return (0);
	}
}
