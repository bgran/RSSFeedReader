package rssfr.rssfeedreader;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class provides general usable services for the rest of the source code
 * package.
 */
public class Cruft {

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

    /**
     * Reads file contents in a very inefficient manner.
     *
     * @param file_name The name of the file we want to read.
     * @return String The contents of a file.
     * @throws IOException In case of errors.
     */
    public static String read_file(String file_name) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(file_name)));
        return (content);
    }

    /**
     * Method expands the array provided with one cell.
     *
     * @param myval The String[] that is expanded.
     * @return A String[] that is a copy of the myval array plus one empty cell.
     */
    public static String[] expand_array_stream(String[] myval) {
        String[] newArray = new String[myval.length + 1];
        System.arraycopy(myval, 0, newArray, 0, myval.length);
        return newArray;
    }
}
