package rssfr.rssfeedreader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker.StateValue;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;

import rssfr.rssfeedreader.Cruft.*;
import rssfr.rssfeedreader.IOExcNetwork;
import rssfr.rssfeedreader.MalformedNetwork;
import rssfr.rssfeedreader.Network;

/**
 * GUI is the central class to handle graphics user interfaces.
 */
public class GUI extends JFrame implements ActionListener,
        ListSelectionListener {

    private Network network;
    private String text_content = "";

    private JFrame popup_window;

    private JTextArea rss_list;
    private JTextArea news_text;

    private static RSSApp my_app;

    private JButton search_button;
    private JTextField search_field;
    private JTextField bgran_hack_field;
    DefaultStyledDocument doc;
    private JMenuBar menuBar;
    private JMenu menu;
    private JLabel prompt;

    private JFileChooser directoryChooser;
    private JFrame popupWindow;
    private JProgressBar progressBar;
    private JButton searchButton, selectDirButton;
    private JTextField searchField;
    private JTextPane fileViewer;
    private JMenuItem menuItem;
    private JRadioButtonMenuItem rbMenuItem;
    private JCheckBoxMenuItem cbMenuItem;
    private DefaultListModel<String> listModel;
    //private Vector<FileSummary> tempList;
    private String searchWord;

    JList searchResults;

    private JSplitPane splitPane;
    //private String[] links =

    final DefaultListModel model = new DefaultListModel();

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int WINDOWWIDTH = (int) screenSize.getWidth();
    private final int WINDOWHEIGHT = (int) screenSize.getHeight() - 30;

	//private DefaultListModel<String> listModel;
    private FileLocker file_locker;

    final int W_WIDTH = 800;
    final int W_HEIGHT = 600;

    /**
     * The GUI konstruktor sets up the user interface and binds actions to the
     * event handler.
     */
    public GUI() {
        this.network = new Network();
		//this.network.init_url_connection();
        //this.network.init_io_connection();
        file_locker = new FileLocker();

        // JFramen tyyli ja koko
        this.setLayout(new FlowLayout());
        //this.setPreferredSize(new Dimension(WINDOWWIDTH, WINDOWHEIGHT));
        this.setPreferredSize(new Dimension(W_WIDTH, W_HEIGHT));

        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setPreferredSize(new Dimension(W_WIDTH - 30,
                (int) ((double) W_HEIGHT / 1.1)));

        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setPreferredSize(new Dimension(W_WIDTH - 30, 20));

        searchField = new JTextField("http://sulaco.havoc.fi/bgran/jl/rss.xml", 60);
        searchField.setActionCommand("GetRSS");
        searchField.addActionListener(this);
        searchButton = new JButton("Get RSS");
        searchButton.setActionCommand("GetRSS");
        searchButton.addActionListener(this);

        // Valikon määrittely
        menuBar = new JMenuBar();
        //Build the first menu.
        menu = new JMenu("A Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);

        menuItem = getMenuItem("Refresh feeds", "RefreshFeeds");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuItem = getMenuItem("Clear list", "ClearList");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menu.addSeparator();

        menuItem = getMenuItem("Exit", "Exit");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menu.addActionListener(this);

        menuBar.add(menu);
        menuBar.add(searchField);
        menuBar.add(searchButton, BorderLayout.EAST);

        this.setJMenuBar(menuBar);

        searchResults = new JList();
        searchResults.setBackground(Color.white);
        searchResults.setSize(new Dimension(W_WIDTH - 30,
                (int) ((double) W_HEIGHT / 2) - 30));
        searchResults.addListSelectionListener(this);

        fileViewer = new JTextPane();
        fileViewer.setEditable(false);
        fileViewer.setBackground(Color.white);
        fileViewer.setSize(new Dimension(W_WIDTH - 30,
                (int) ((double) W_HEIGHT / 2) - 30));

        panel2.add(new JScrollPane(searchResults), BorderLayout.NORTH);
        panel2.add(new JScrollPane(fileViewer), BorderLayout.CENTER);

        this.add(panel2);
        this.add(panel3);

        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String selectedItem
                            = (String) searchResults.getSelectedValue();
                    searchResults.setModel(listModel);
                    model.addElement(selectedItem);
					//Cruft.info_box("selectedItem: "+selectedItem,
                    //	       "FOokalaa");
                    populate_view(selectedItem);
                }
            }
        };
        searchResults.addMouseListener(mouseListener);

        factoryNewRSSApp();
        my_app.execute();
    }

    private void populate_view(String url) {
        Stream stream = new Stream(url);
        stream.setup_content();
        String data = stream.get_HTTP_content();
        fileViewer.setText(data);
    }

    public static void gui_hook() /* throws .. */ {
        GUI gui_h = new GUI();

        gui_h.setTitle("RSS Feed Reader");
        gui_h.pack();
        gui_h.setVisible(true);
        gui_h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void feed_xml(String datat) {
        Cruft.info_box("feed_xml", "Error: " + datat);
        List<ngXMLElement> vals = null;
        try {
            vals = ngXML.do_parse(datat);
        } catch (Exception err) {
            Cruft.info_box("XML data malformed: " + err.getMessage(), "Error");
            return;
        }
        if (vals == null) {
            Cruft.info_box("vals == null", "feed_xml");
            return;
        }
        int len = vals.size();

        String t2[] = new String[len];

        for (int i = 0; i < 1; i++) {
            ngXMLElement t = vals.get(i);
            String key = t.getKey();
            String val = t.getVal();
            t2[i] = key + " -> " + val + "\n";

            listModel.addElement(key + " -> " + val + "\n");
            Cruft.info_box("feed_xml: " + key + " " + val,
                    "Prkl");

        }
        //searchResults.removeAll();
        searchResults.setModel(listModel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()) {
            case "GetRSS":
                String search_word = searchField.getText();
                file_locker.add_stream(search_word);

                refresh_RSS_list();
                //listModel = new DefaultListModel();
                break;
            case "RefreshFeeds":
                        //
                //
                Cruft.info_box("RefreshFeeds", "Not implemented!");
                break;
            case "Exit":
                System.exit(0);
                break;
            case "ClearList":
                Cruft.info_box("Clears the feed list!", "Not implemented!");
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

    public void refresh_RSS_list() {
        listModel = new DefaultListModel();
        searchResults.setModel(listModel);
        String[] streams = file_locker.my_streams;
        //Cruft.info_box(""+streams.length, "HAKALAA");
        for (int i = 0; i < streams.length; i++) {
            if (streams[i] == null) {
                continue;
            }
            //Cruft.info_box(streams[i], "RSS_list");
            Stream stream = new Stream(streams[i]);

            listModel.addElement(
                    streams[i]);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        //Cruft.info_box("valueChanged: "+e.getSource(), "valueChanged");
        JList list = (JList) e.getSource();
        int index = list.getSelectedIndex();

        if (index == -1) {
        } else {
            this.repaint();
            try {
                System.out.println("Kuhakalaa");
                this.repaint();
            } catch (NullPointerException ex) {
            } finally {
                System.out.println("Finally...");
            }
            this.repaint();
        }
    }

    /**
     * Description of initUI.
     *
     */
    public void initUi() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        panel.add(new JButton("btn"));

        news_text = new JTextArea();
        news_text.setLineWrap(true);
        news_text.setWrapStyleWord(true);
        news_text.setBorder(BorderFactory.createEmptyBorder(
                8, 8, 5, 5));

        panel.add(news_text);

        add(panel);

        setTitle("RSS Feed Reader");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void factoryNewRSSApp() {
        my_app = new RSSApp();
    }

    //private Network Network() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    // }
    public JMenuItem getMenuItem(String text, String actionCommand) {

        JMenuItem menuItem = new JMenuItem(text);
        menuItem.setActionCommand(actionCommand);
        //Cruft.info_box("getMenuItem " + text + " " + actionCommand, text);

        return menuItem;
    }

}
