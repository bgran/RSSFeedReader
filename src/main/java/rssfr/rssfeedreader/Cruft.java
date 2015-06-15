package rssfr.rssfeedreader;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * This class provides general usable services for the rest of the source code
 * package.
 */
public class Cruft {

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
     * Writes an array of String's to a file very inefficiently.
     *
     * @param file_name The name of the file we want to write to.
     * @param data The array of String's.
     * @return boolean this is not used for anything.
     * @throws IOException In case of errors.
     */
    public static boolean write_file(String file_name, String[] data) throws IOException {
        PrintWriter writer = new PrintWriter(file_name, "UTF-8");
        for (int i = 0; i < data.length; i++) {
            writer.println(data[i]);
        }
        writer.close();
        return (true);
    }

    /**
     * Writes an ArrayList<String> to a file very inefficiently.
     *
     * @param file_name The name of the file we want to write to.
     * @param data The ArrayList<String> to write to the file.
     * @return boolean this is not used for anything.
     * @throws IOException In case of errors.
     */
    public static boolean write_file_spec(String file_name,
            ArrayList<String> vals)
            throws IOException {
        PrintWriter writer = new PrintWriter(file_name, "UTF-8");
        for (int i = 0; i < vals.size(); i++) {
            writer.println(vals.get(i));
        }
        writer.close();
        return (true);
    }

    /**
     * Split a String by the " -> " marker. Used as an ugly hack.
     *
     * @param entry the String to split.
     * @return the second part, what's right of the marker.
     */
    public static String extract_url(String entry) {
        String[] parts = entry.split(" -> ");
        String part2 = parts[1];
        return (part2);
    }
}
