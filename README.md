cdstoreproject
==============

maven is used for build lifecycle management

in command line go to cdstore directory

type in command

mvn clean install -DskipTests=true

this command will build all source file and jar


To run web service

go to cdstore-restws folder

in com.cdstore.restws open Start.java file
right click on file run as Java application

this will start deploy jersey web service in grizzly container.
It can be accesed at http://localhost:9090

to run web application

take war file from target folder and deploy using tomcat manager tool
