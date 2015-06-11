/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
