package rssfr.GUI;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 * This is a sub-class that extends the JPanel for some use later.
 *
 * @author bgran
 */
public class MyJPanel extends JPanel {

    public MyJPanel() {
        super();
    }

    /**
     * Ctor to class with LayoutManager.
     *
     * @param layt the new layout to use.
     */
    public MyJPanel(LayoutManager layt) {
        super(layt);
    }
}
