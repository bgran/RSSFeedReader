The RSS feed reader is a Java application utilizing basic Java structure and Swing classes for UI definition. The program is a RSS Feed Reader application, that fetches the Rich Site Summary, or Really Simple Syndication. The data fetced is a discrete XML document that contains frequently updated information, such as blogs, news headlines, audio, video. The RSS document is called informally a "feed".

RSS is XML markup language, that is a complete XML document.

The users for such an application is the web user who want's to stay up to date with current happenings on the Internet.

The application fetches the desired feeds form the URL entered in the URL text field. Nothing is stored in any filesystem or similar. The URL is entered in a widget in the GUI section of the system. The request is pushed forward to the Network section. It then makes a HTTP connection to the feed provider, and fetches the current RSS feed. This data is forwarded to the ngXML XML parsing logic in the application, which splices and splits, joins, the XML data to a data structure that can be passed back to the GUI, which will show the new RSS feed in place.

Error cases are handled  with exceptions. This is due to the Network or ngXML parts not having any reason to use UI logic.

The nature of the application is highly difficult to do tests for. Artificial means of adding getters and setters my provide with more tests being applied, but is not done due to professional integrity of not making code any more harder to read than it already is.