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

	FileLocker() {
		my_streams = new String[100];
		for (int i=0; i< 100; i++) {
			my_streams[i] = null;
		}
	}

	public void add_stream(String url) {
		Cruft.info_box(
			"KAUIDIAD",
			"SODKOPSDKPPOKSD");
		int i;
		for (i=0; my_streams[i] != null ; i++);
		my_streams[i] = url;
	}
	public void repr() {
		for (int i=0; i<my_streams.length; i++) {
			System.out.println("" + i + " -> " + my_streams[i]);
			
		}
	}
}
