package rssfr.rssfeedreader;

public class ErrorNetwork extends Exception {

    final static public long serialVersionUID = 123;

    public ErrorNetwork() {
        super();
    }

    public ErrorNetwork(String arg) {
        super(arg);
    }
}
