/**
 * 
 */
package rssfr.rssfeedreader;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/** Descirption of GUI
 * 
 * @author bgran
 * @version 0.1
 */
public class GUI extends JFrame {
	private JLabel label;
	private JList rss_list;
	private JTextArea news_text;
	private int state = 0;
	private JScrollPane pane;
	
	//public GUI () {
	//	initUi();
	//}
	private void swap() {
		if (state == 0) {
			// We should hide the JList and show the JTextArea
			System.out.println("Showing news_text");
			this.rss_list.setVisible(false);
			this.news_text.setVisible(true);
		} else {
			System.out.println("Showing rss_list");
			this.rss_list.setVisible(true);
			this.news_text.setVisible(false);
		}
		state = (state + 1) % 2;
	}
	/** Description of initUI.
         * 
         */
        public void initUi() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		panel.setLayout(new GridLayout(/* 2 */5, 4, 5, 5));
	
		panel.add(new JButton("kalaa"));
		
		news_text = new JTextArea();
		news_text.setLineWrap(true);
		news_text.setWrapStyleWord(true);
		news_text.setBorder(BorderFactory.createEmptyBorder(8, 8, 5, 5));
		//news_text.append("AKALAAAAAAA\nasdufhiuhewrhu32hriu");
		
		panel.add(news_text);
	
		add(panel);
		
		setTitle("RSS Feed Reader");
		setSize(350, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
	}
	
}
