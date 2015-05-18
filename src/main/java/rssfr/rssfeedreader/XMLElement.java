package rssfr.rssfeedreader;

import java.util.*;
import rssfr.rssfeedreader.Parser;

public class XMLElement  {
	private String _elemName;
	private String _elemVal;
	public Stack<XMLElement> st;
	/*
	 * Forget for now about attributes to elements.
	 * FIXME: add support for XML document attributes
	 */
	
	public XMLElement (String name) {
		_elemName = name;
		_elemVal = new String("");
		st = new Stack<XMLElement>();
	}

	/**
	 * 
	 * @param data
	 */
	public void pushData(char d) {
		_elemVal += d;
	}
	public String join(Collection<String> collection) {
		StringBuffer buf = new StringBuffer();
		Iterator<String> i = collection.iterator();
		while (i.hasNext()) {
			buf.append(i.next());
		}
		return buf.toString();
	}
	
	public String elemName() {
		return (_elemName);
	}
	public String elemVal() {
		return (_elemVal);
	}
	
	protected void pushElem(XMLElement elem) {
		this.st.push(elem);
	}
	public XMLElement addNew(String name) {
		XMLElement tmp = new XMLElement(name);
		//System.out.println("Pushed: " + name + " hauki: " + this);
		this.st.push(tmp);
		return (tmp);
	}
	public void print(int indent) {
		//System.out.println("Call tracer: " + st.size());
		for (int j=0; j<indent; j++) {
			System.out.print(" ");
		}
		System.out.println(toString());
		
		Iterator<XMLElement> i = st.iterator();
		while (i.hasNext()) {
			XMLElement tmp = i.next();
			tmp.print(indent+4);
		}
	}

	public String toString() {
		return (elemName() + " <-> |" + elemVal()+"|");
	}
}
