/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JOptionPane;

/**
 *
 * @author bgran
 */
public class UICruft {
      /**
       * Pushes up an JOptionPane modal (?) dialog to report about happpenings in
       * the appplication logic.
       *
       * @param info_msg string A messasge to show
       * @param title string A title to show.
       */
        public static void info_box(String info_msg, String title) {
        JOptionPane.showMessageDialog(null, info_msg,
                "InfoBox: " + title, JOptionPane.INFORMATION_MESSAGE);
    }
}
