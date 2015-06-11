package rssfr.rssfeedreader;

/**
 * This class is a holder of some stream related data.
 */
public class FileLocker {

    final int max_number_of_stream = 100;

    public String[] my_streams;

    public FileLocker() {
        my_streams = new String[max_number_of_stream];
        for (int i = 0; i < max_number_of_stream; i++) {
            my_streams[i] = null;
        }
    }

    /**
     * add_stream adds a string to be shown in the upper pane.
     *
     * @param url The locator to be added.
     */
    public void add_stream(String url) {
        int i;
        for (i = 0; my_streams[i] != null; i++);
        my_streams[i] = url;
    }

    /**
     * Clears all streams from being shown in the ui.
     */
    public void clean_streams() {
        for (int i = 0; i < max_number_of_stream; i++) {
            my_streams[i] = null;
        }
    }

}
