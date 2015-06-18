Testing document for the RSS Feed Reader
========================================

The purpose of this document is to shed light on why testing of the application is a hard case.

First off, the application in built from ground up with user interface design as the primary mean of operaton. The application is simply a wrapper on top of a fwe HTTP and parsing functionality. There's not that much internal state involved. The states that the application can be in are depicted:
* Pristine state, where no feeds are subscribed.
* Default state, only subscribed feed are shown, and no content is fetched.
* Display state, where one feed is shown.
These are not easy to test. There's no internal logic apart from fetching, parsing and showing of the fetched data. The conscious decision to not implement artificial logic was made.

The rule of thumb is that UI related code is not tested. Also the code is transparent, and doesn't take into account testing. The reason is that things are wrapped together. For instance, one problematic case is the FileLocker.java class, which does automatically save state.

The following classes are tested in the rssfr.rssfeedreader:

FileLocker.java
---------------

Testing this is highly difficult, because it changes potentially state every tme you instantiate a ne FileLocker object.

Stream.java
-----------

Does work interactively, and is dependent upon the Network class, which is also highly difficult to test. The logic par of Stream is tested, but the network part is too volatile to be tested in any case.

ngXML.java
----------

This method _IS NOT_ tested, because it does only parsing of XML documents, and it's not subject to heavy testing. The basic use case is tested, but apart from that, the logic doesn't bode well to testing.

ngXMLElement.java
-----------------

This is only a container object of state. Not much any logic to test.

Cruft.java
----------

Cruft contains utility functions declared static. Only the file reading functionality is tested.

