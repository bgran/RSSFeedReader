package rssfr.Net;

/**
 * This class is an exception to signal error conditions in the Network class.
 *
 * @author bgran
 */
public class IOExcNetwork extends Exception {

    final static public long serialVersionUID = 123;

    public IOExcNetwork() {
        super();
    }

    public IOExcNetwork(String arg) {
        super(arg);
    }
}
