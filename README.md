# Octo Events

## If you prefer to check the solution without going up:

<a href="https://octo-events-java.herokuapp.com/issues/2/events">Copy and cole in postman to start the games!</a>

## it's hardcore?! let's go!

### Requirements:

<ul>
	<li>Java 8</li>
	<li>Postgresql</li>
	<li>ngrok</li>
</ul>

### How to start?

<ol>
  <li>Clone the project  
		<blockquote>
      git clone https://github.com/karielly/octo-events.git
		</blockquote>
	</li>
  <li>Set JAVA_HOME to a Java 8 JDK</li>
  <li>Open the project folder in the terminal</li>
  <li>Execute
	  </br>
	  Linux
	  <ul>
		  <li>./mvnw clean install</li>
		  <li>./mvnw spring-boot: run</li>
	  </ul>
	  Windows
	  <ul>
		  <li>mvnw.cmd clean install</li>
		  <li>mvnw.cmd spring-boot:run</li>    
	  </ul>
  </li>
</ol>

<p>The project runs on the port 8080</p>

<p>The database configuration properties can be changed in: application.properties</p>

## About the project

<p>I'm using Static Factory Methods (Static initializer) for the Entities and DTO.</p>

**Routes:**

<p>POST / Listen to github webhook.</p>

<p>GET /issues/:number/events Lists all events of the issue.</p>

<p>To handle some exceptions or error json, the AppExceptionHandler was created.</p>

END..
