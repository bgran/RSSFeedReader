package rssfr.rssfeedreader;

import java.io.IOException;
import java.util.ArrayList;
import rssfr.GUI.UICruft;

/**
 * This class is a holder of some stream related data.
 */
public class FileLocker {

    final int max_number_of_stream = 100;

    public ArrayList<String> my_streams2;

    /**
     * The constructor tries to load from a "config.ini" file the previously
     * used RSS feeds.
     * @param init_ To load feeds from config.ini or not.
     */
    public FileLocker(boolean init_) {
        my_streams2 = new ArrayList<String>();
        if (init_) {
            load_from_file();
        }
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
        load_to_file();
    }

    /**
     * Remove a RSS entry from the upper pane, by index.
     *
     * @param idx The index of the RSS feed in the upper pane to remove.
     */
    public void remove_index(int idx) {
        my_streams2.remove(idx);
        load_to_file();
    }

    /**
     * Tries to load from the "config.ini" file the previously used RSS feeds.
     */
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
            if (entries[i].isEmpty()) {
                continue;
            }
            add_stream(entries[i]);
        }
    }

    /**
     * Tries to load to the "config.ini" file the previously used RSS feeds.
     */
    private void load_to_file() {
        try {
            Cruft.write_file_spec("config.ini", my_streams2);
        } catch (IOException e) {
            System.out.println(
                    "Could not write config.ini:" + e.getMessage());
        }
    }
}
