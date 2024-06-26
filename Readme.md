# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.bus-booking-be.app' is invalid and this project uses 'com.busbookingbe.app' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.5/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/index.html#web.security)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/index.html#web)

### Guides
The following guides illustrate how to use some features concretely:
Overview
This project is a Spring Boot backend service designed to [briefly describe the purpose of the project]. It includes [mention any major features or functionalities].

### Prerequisites
Before you begin, ensure you have met the following requirements:

Java Development Kit (JDK) 17 or later
Apache Maven 3.6.0 or later
An IDE such as IntelliJ IDEA or Eclipse (optional but recommended)
## Git
## Installation
Follow these steps to get the project up and running on your local machine.

* git clone https://github.com/VengateshPrasad5/bus-booking-be.git
* clone the repository in your local
* go to maven and run the dependency
* cd bus-booking-be

##  Set Up Environment Variables
Create a file named application.properties in the root directory of the project and add the necessary environment variables. For example:

spring.application.name=bus-booking-app
spring.datasource.url=jdbc:mysql://<endpoint name>/<db name>
spring.datasource.username= <username>
spring.datasource.password= <password>

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

logging.level.org.springframework.security=DEBUG
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type=TRACE

###  POSTMAN API URL

* To execute the API URL
* http://localhost:8080/swagger-ui/index.html
* Use Postman tool to execute API get token from login USER and run URL
by adding the token to the Bearer Token and execute required methods

### Run the Application from My Application
* By Run button or use
* mvn spring-boot:run




