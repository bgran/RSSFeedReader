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
	public static boolean write_file(String file_name, String [] data) throws IOException {
		PrintWriter writer = new PrintWriter(file_name, "UTF-8");
		for (int i = 0; i < data.length; i++) {
			writer.println(data[i]);
		}
		writer.close();
                return (true);
	}


	public static boolean write_file_spec(String file_name,
					      ArrayList<String> vals)
                    throws IOException {
		PrintWriter writer = new PrintWriter(file_name, "UTF-8");
		for (int i=0; i<vals.size(); i++) {
			writer.println(vals.get(i));
		}
		writer.close();
		return (true);
	}



    public static String extract_url (String entry) {
        String[] parts = entry.split(" -> ");
        String part2 = parts[1];
        return (part2);
    }
}
