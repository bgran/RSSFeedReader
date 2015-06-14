package rssfr.rssfeedreader;

import java.io.IOException;
import java.util.ArrayList;
import rssfr.GUI.UICruft;

/**
 * This class is a holder of some stream related data.
 */
public class FileLocker {

    final int max_number_of_stream = 100;

    //public String[] my_streams;
    public ArrayList<String> my_streams2;

    public FileLocker() {
        my_streams2 = new ArrayList<String>();
        //my_streams = new String[max_number_of_stream];
        //for (int i = 0; i < max_number_of_stream; i++) {
        //    my_streams[i] = null;
        //}
        load_from_file();
    }

    /**
     * add_stream adds a string to be shown in the upper pane.
     *
     * @param url The locator to be added.
     */
    public void add_stream(String url) {

        my_streams2.add(url);
        load_to_file();
        //UICruft.info_box("add_stream: " + url, "Fii");
        //UICruft.info_box("kala: " + my_streams2.get(0), "HUOH");
        //int i;
        //for (i = 0; my_streams[i] != null; i++);
        //my_streams[i] = url;
    }

    /**
     * Clears all streams from being shown in the ui.
     */
    public void clean_streams() {
        my_streams2.clear();
        //for (int i = 0; i < max_number_of_stream; i++) {
        //    my_streams[i] = null;
        //}
    }

    public void remove_index(int idx) {
        my_streams2.remove(idx);
    }

    private void load_from_file() {
        String data;
        try {
            data = Cruft.read_file("config.ini");
        } catch (IOException e) {
            System.out.println("Could not load init file");
            return;
        }
        String[] entries = data.split("\n");
        for (int i = 0; i < entries.length; i++) {
            add_stream(entries[i]);
        }
    }

    private void load_to_file() {
        try {
            Cruft.write_file_spec("config.ini", my_streams2);
        } catch (IOException e) {
            System.out.println(
                    "Could not write config.ini:" + e.getMessage());
        }
    }
}
