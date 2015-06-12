RSS Feed Reader
===============

The RSS Feed Reader is a Java application for fetching and reading RSS feeds. The user interface is made with Java Swing classes to achieve a widely supportd UI definition. The program should work equally on any platform that has a Java runtime.

The RSS is an acronym for Rich Site Summary or Really Simple Syndication. It can be used to used to fetch information about new blog entries, news items, new audio, video. The method is asyncrhonic. The RSS Feed Reader is responsible for fetching the XML data that represents the stream. The RSS document is called informally a "feed".

The RSS feed is XML markup language. It's a static file that contains entries. The entires are defined with the RSS standard. This version is based on the 0.9 version of the RSS specification.

There's potentially nothing else to do with the application, than to fetch given RSS feeds upon user interaction. It's advicable to fetch new entries every now and then. The automatic updating of such stuff is a good idea, but that's outside the scope of this project.

The transport channel is a TCP based HTTP(S) stream that is the XML document. The application needs a XML parsing framework. It's faily easy to parse the correctly structured RSS feed data. The XML handling code will reject broken document. There's basically the news item, and the URL to more information.


RSS Feed Reader architecture
----------------------------

There's basically the following sections of the application:
* GUI component, that handles all stuff related to the graphical user interface. This the biggest part of the code.
* Network component handles the Network (HTTP) and Stream basic operations.
* ngXML which parses the RSS feed data.
* File system interaction component (not implemented yet).

The GUI component is the hardest part. It's written basically in pure swing, extending a JPanel in the beginning. It then has tree parts:
* Menu bar for inserting feeds and clearing feed data.
* The upper pane that shows the "subscribed" feeds.
* The lower pane supports a JList of RSS feed entries.

The Network component is responsible to handle all network handling functionality. There's methods for fetching data by URL. The solution is behind a class called Stream. It's semantically the Stream data in usage for a single stream.

ngXML is a relatively small piece of code that does the highly difficult parsing of the received data. The XML document is not a contxt free grammar, so bascially portable versions of the parser cannot be a DFA (Deterministic Finite Automata, or better known as regular expressions). This makes the ngXML very difficult to get working right.

The file system component is for storing subscribed feeds, but it's not yet implemented yet.


RSS Feed Reader operation
-------------------------

The roughs steps to getting a RSS Feed Reader up and running:
* Instantite a RSSApp object, which is capable of executing an event receiving and dispatching mechanism.
* There's then the GUI component loaded, and it's populated with the previously subscribed RSS Feeds.
* Stop waiting for user input.
* Enter a new stream.
* Fetch the data for the stream, and store it in virtual memory.
* iterate

Since there's only synchronous events happening, the logic beneath is also synchronic. The user interaction is seriously difficult to automate. You would almost have to use tools like xnee to simulate some operation. The interfaces are highly specific to how the software would operate in real life terms, not like a toy program where the datastructures are redundant and the logic is based on preset modus operandi. It's highly difficult to test because of these issues automatically the software. When in real life software products there's different types of means of Quality Assurance.

