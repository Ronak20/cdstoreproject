cdstoreproject
==============

maven is used for build lifecycle management

in command line go to cdstore directory

type in command

mvn clean install -DskipTests=true

this command will build all source file and jar.jar is available in target folder of each individual project.

cdstore-restws
==============
To run web service

go to cdstore-restws folder

in com.cdstore.restws open Start.java file
right click on file run as Java application

this will start deploy jersey web service in grizzly container.
It can be accesed at http://localhost:9090

cdstore-webapp
==============

to run web application

take war file from target folder and deploy using tomcat manager tool

go to localhost:8080/cdstore-webapp/CdShowServlet

database setup
==============

database sql is in cdstore-dbagent's resources folder.

database configuration are in dbagent-context.xml from line 35 to 48.you can change database name and credential there.

test sql
==============

for testing test sql is available in cdstore-dbagent project in resources folder.

Execution of this sql will create cdstoretest database
