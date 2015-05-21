package rssfr.rssfeedreader;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker.StateValue;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;

import rssfr.rssfeedreader.Cruft.*;


/** Descirption of GUI
 * 
 * @author bgran
 * @version 0.1
 */
public class GUI extends JFrame implements ActionListener,
		ListSelectionListener {
        private String text_content = "";
    
    
	
	private JTextArea rss_list;
	private JTextArea news_text;
	
        private static RSSApp my_app;

        private JButton search_button;
     	private JTextField search_field;
        DefaultStyledDocument doc;
	private JMenuBar menuBar;
    	private JMenu menu;
    	private JLabel prompt;
        
        public GUI() {
	        this.setLayout(new FlowLayout());
        	this.setPreferredSize(new Dimension(800, 600));

	 	JPanel panel2 = new JPanel(new BorderLayout());
                panel2.setPreferredSize(
                        new Dimension(800 - 30,
                            (int) ((double) 600)));

                search_field = new JTextField(
                        "http://sulaco.havoc.fi/bgran/jl/rss.xml", 60);
                search_field.setActionCommand("SearchCommand");
                search_field.addActionListener(this);
                search_button = new JButton("Search");
                search_button.setActionCommand("SearchCommand");
                search_button.addActionListener(this);

                menuBar = new JMenuBar();
                menu = new JMenu("RSS URL:");
                
                //menuBar.add(menu);
                
                prompt = new JLabel("RSS Feed:");
                menuBar.add(prompt);
                menuBar.add(search_field);
                menuBar.add(search_button, BorderLayout.EAST);

                this.setJMenuBar(menuBar);

                String [] my_init = {
                    "This is my RSS Feed reader.",
                    "I hope you like your stay.",
                    "Bo Granlund made this."
                };
                
                rss_list = new JTextArea();
                rss_list.setBackground(Color.LIGHT_GRAY);
                rss_list.setSize(new Dimension(800 - 30,
                    (int) ((double) 600) - 60));
        
                panel2.add(new JScrollPane(rss_list), BorderLayout.CENTER);
        
                this.add(panel2);
        
                factoryNewRSSApp();
                my_app.execute();
	}
	
	public static void gui_hook() /* throws .. */ {
		GUI gui_h = new GUI();

		gui_h.setTitle("RSS Feed Reader");
		gui_h.pack();
		gui_h.setVisible(true);
		gui_h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        private void feed_xml(String datat) {
            List<ngXMLElement> vals = null;
            try {
                vals = ngXML.do_parse(datat);
            } catch(Exception err) {
                Cruft.info_box("XML data malformed", "Error");
                return;
            }
            if (vals == null) {
                return;
            }
            int len = vals.size();
            
            String t2[] = new String[len];
            
            rss_list.setText("");
            for (int i=0; i< len; i++) {
                ngXMLElement t = vals.get(i);
                String key = t.getKey();
                String val = t.getVal();
                t2[i] = key + " -> " + val + "\n";
                rss_list.append(t2[i]);
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
            switch (e.getActionCommand()) {
            case "SearchCommand":
                String search_word = search_field.getText();
                //archList();
                String datat = "";
                try {
                    datat = Network.getUrl(search_word);
                } catch(Exception err) {
                    Cruft.info_box(err.getMessage(), "Network error");
                    return;
                }
                if (datat == null) {
                    Cruft.info_box("Data received is null", "Error");
                    return;
                }
                try {
                    feed_xml(datat);
                } catch (Exception err) {
                    Cruft.info_box("XML related problem", "Error");
                }
                break;
            case "OpenHelp":
                about_window();
                break;
            }
            this.repaint();
        }

        private void about_window() {
            Cruft.info_box("RSS Reader by Bo Granlund", "About");
        }
    
        @Override
        public void valueChanged(ListSelectionEvent e) {

            JList list = (JList) e.getSource();
            int index = list.getSelectedIndex();

            if (index == -1) {
            } else {
                this.repaint();
                try {
                    System.out.println("Kuhakalaa");
                    //fileWorker.cancel(true);
                } catch (NullPointerException ex) {
                } finally {
                    System.out.println("Finally...");
                }
                this.repaint();
            }
        }


	/** Description of initUI.
         * 
         */
        public void initUi() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		panel.setLayout(new GridLayout(5, 4, 5, 5));
                
		panel.add(new JButton("btn"));
		
		news_text = new JTextArea();
		news_text.setLineWrap(true);
		news_text.setWrapStyleWord(true);
		news_text.setBorder(BorderFactory.createEmptyBorder(8, 8, 5, 5));
		
		panel.add(news_text);
	
		add(panel);
		
		setTitle("RSS Feed Reader");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        private void factoryNewRSSApp() {
                my_app = new RSSApp();
        }

}
