/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rssfr.rssfeedreader;

/**
 * This class doesn't do anything at the moment.
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

    public void add_stream(String url) {
        int i;
        for (i = 0; my_streams[i] != null; i++);
        my_streams[i] = url;
    }
    public void clean_streams() {
       	for (int i = 0; i < max_number_of_stream; i++) {
	    my_streams[i] = null;
	}
    }

}
