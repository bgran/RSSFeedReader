/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rssfr.rssfeedreader;

public class MalformedNetwork extends Exception {

    final static public long serialVersionUID = 123;

    public MalformedNetwork() {
        super();
    }

    public MalformedNetwork(String arg) {
        super(arg);
    }
}
