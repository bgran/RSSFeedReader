package rssfr.Net;

/**
 * This class is an exception to signal error conditions in the Network class.
 *
 * @author bgran
 */
public class MalformedNetwork extends Exception {

    final static public long serialVersionUID = 123;

    public MalformedNetwork() {
        super();
    }

    public MalformedNetwork(String arg) {
        super(arg);
    }
}
