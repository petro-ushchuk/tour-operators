# Tour operators
How to run?

First of all, you need to have a JRE at least 11 version.

Secondly, download source code from origin/develop.

Use the following commands depending on your operating system:
 - Windows - gradlew.bat build bootRun
 - Linux - sh gradlew build bootRun

Or via using IDE instruments.

Implemented a web application with the following functionality:
1.	Created functionality for CRUD operations for every entity (User, Tour, TourOperator).
2.	Implemented endpoints with user's ability to join/undo to some tour.
3.	Implemented endpoint to find tours by type.
4.	Implement simple Spring Security auth. 


Additionaly, created error handler and springfox 3 as view layer. 


Additionally, implemented Swagger-UI to see and use API. By default, it is available on the http://localhost:8080/swagger-ui/.
