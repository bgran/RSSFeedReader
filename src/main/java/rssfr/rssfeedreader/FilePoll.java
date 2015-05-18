/**
 * 
 */
package rssfr.rssfeedreader;

import java.io.*;

/** Description of FilePoll
 * @author bgran
 * @version 0.1
 */
public class FilePoll {
	private String file;
	
        /* FIXME: JavaDoc */
	public FilePoll(String file) {
		this.file = file;
	}

	private int __countFileLines() {
		int lines = 0;
		try {
			BufferedReader r = new BufferedReader(new FileReader(this.file));
			while (r.readLine() != null) lines++;
			r.close();
		} catch (FileNotFoundException e) {
			System.out.println("Could not open " + file + " for reading");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("IOException happened: " + e.getMessage());
			System.exit(1);
		}
		return (lines);
	}
	
        /** Description of getContents()
         * 
         * @return A String array with contents of RSS file
         */
        /*
	public String[] getContents() {
		int fileLineCount = this.__countFileLines();
		String[] rv = new String[fileLineCount];
		System.out.println("fileLineCount: " + fileLineCount);
		try {
			FileReader fd = new FileReader(this.file);
			BufferedReader reader = new BufferedReader(fd);
			String line;
			int iter = 0;
			while ((line = reader.readLine()) != null) {
				System.out.println("iter: " + iter);
				rv[iter] = line;
				iter++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not open " + file + " for reading");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("IOException happened: " + e.getMessage());
			System.exit(1);
		}
		return (rv);
	}*/
        /*
	public String getRaw() {
		String rv = new String("");
		try {
			FileReader fd = new FileReader(this.file);
			BufferedReader reader = new BufferedReader(fd);
			String line;
			while ((line = reader.readLine()) != null) {
				rv += line;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not open " + file + " for reading");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("IOException happened: " + e.getMessage());
			System.exit(1);
		}
		return (rv);
	}*/
}
