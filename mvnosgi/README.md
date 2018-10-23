# OSGi + POM, Plain Old Maven

This is a basic demonstration of a project which has fairly predictable structure reflecting a
common "layering" in system. Whole thing is built using maven and `maven-bundle-plugin`.

Regardless if your application is layered or not - it is good practice to separate these interfaces
in order to isolate dependencies and force proper testing patterns (ie. via interface mocking).

As shown in this example - there is no need for any major changes