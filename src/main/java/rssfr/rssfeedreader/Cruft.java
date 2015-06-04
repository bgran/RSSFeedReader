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

}
