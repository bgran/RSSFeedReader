package rssfr.Net;

/**
 * The ErrorNetwork exception used by the Network class to signal error states.
 *
 * @author bgran
 */
public class ErrorNetwork extends Exception {

    final static public long serialVersionUID = 123;

    public ErrorNetwork() {
        super();
    }

    public ErrorNetwork(String arg) {
        super(arg);
    }
}
