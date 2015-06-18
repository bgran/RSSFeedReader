package rssfr.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import rssfr.Net.Network;
import rssfr.GUI.GUI;
import rssfr.rssfeedreader.Cruft.*;
import rssfr.rssfeedreader.ngXML;

import javax.swing.*;
import rssfr.GUI.UICruft;

/**
 * Description of rssread Main class for application. bgran1337
 *
 * @author bgran
 * @version 0.1
 */
public class rssread extends GUI {

    //GUI gui;
    JButton b;

    /**
     * main() method of the application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        //try {
        GUI.gui_hook();
	    //} catch (Throwable e) {
        //	    UICruft.info_box("Program failed: " + e.getMessage(),
        //			   "Error");
        //	    System.out.println("Program failed: " + e.getMessage());
        ////  }
    }
}
