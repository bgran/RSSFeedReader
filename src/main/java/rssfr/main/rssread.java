package rssfr.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import rssfr.rssfeedreader.Network;
import rssfr.GUI.GUI;
import rssfr.rssfeedreader.Cruft.*;
import rssfr.rssfeedreader.ngXML;

import javax.swing.*;

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
     * Description of main()
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        GUI.gui_hook();
    }

    /**
     * The ctor setups the interface to the program.
     */
    public rssread() {
        System.out.println("rssread initializing");
        initUi();
    }

}
