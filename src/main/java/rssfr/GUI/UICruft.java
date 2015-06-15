package rssfr.GUI;

import javax.swing.JOptionPane;

/**
 *
 * @author bgran
 */
public class UICruft {

    /**
     * Pushes up an JOptionPane modal (?) dialog to report about happpenings in
     * the application logic.
     *
     * @param info_msg string A message to show
     * @param title string A title to show.
     */
    public static void info_box(String info_msg, String title) {
        JOptionPane.showMessageDialog(null, info_msg,
                "InfoBox: " + title, JOptionPane.INFORMATION_MESSAGE);
    }
}
