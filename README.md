# KungfuClub
	KungFu Martial Arts School Administrative website built in AngularJS and JAVA using Spring Boot

#Steps of Execution
	1. Import the project in Eclipse.
	2. Resolve all the dependencies by installing Spring Boot and Maven.
	3. Right click the project and select Run As ▸ Maven build.
	4. Enter install in the Goals: field in the dialog box and press the Run button.
	5. Create a Database instance in PostgreSQL.
	6. Update the DB credentials and DB instance in the application.properties file.
	7. Right click on the project and select Run As ▸ Spring Boot App.
	8. Project starts running on connecting to the localhost port 8080 and URL- localhost:8080/.

# System Architecture
	The framework design depends on the conventional example MVC – Model View Controller. 
	This example, when all around connected, separate the framework into three interconnected parts. 
	The MVC design gives low coupling among the UI, business standards and information layer. 
	It additionally permits code reuse and parallel advancement. 
	The User Interface (front-end) is coded basically utilizing HTML and JavaScript. 
	The AngularJS library was utilized to construct the HTML code, collaborate with the server and restore the reactions from the server. 
	The customer UI will make solicitations to the server and the information returned will be JSON records. 
	They will be powerfully parsed to be introduced to the client. 
	On the server-side, we embraced Java as the programming dialect. 
	The web server used to manufacture and run the framework is Open Source and broadly utilized, the Tomcat web server. 
	The web layer is coded on the highest point of the Java Spring Framework. 
	It is additionally Open Source and in our framework, it is in charge of getting the customer's solicitations by means of.
	HTTP and restore the information in JSON arrange back to the UI to be displayed. 
	The last critical framework layer is the information layer. The DBMS used to execute this framework was PostgreSQL. 
	The ORM (Object-social Mapping) API additionally gave by the Spring Framework was utilized to keep up the information.
	What's more, give all the essential access to the database to embed, refresh, expel and look.
