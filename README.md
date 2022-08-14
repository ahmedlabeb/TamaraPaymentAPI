# Payment Service 
# Instruction to run the project
  - Install JDK 8 or higher on your machine 
  - Install Maven on your machine
  - Install any IDE Tool ( IntelliJ) 
  - Install MySql DB and MySql workbench to view table 
 
 # Steps to run the service 
  - create schema with name (paymentApi) on your local mysql 
  - change username and password of the datasource by your Mysql username and password
  - apply command (maven clean install)
  - Start the server from the IDE , Server will be up and running on port 9090  , you can view the swagger through this URL http://localhost:8282/swagger-ui.html#/
              
  # What is Purpose of This service 
  This service is mockup service for how we can create a service that support create, retrieve order API with basic Auth applied on selected APIs for order and pay
    Also there a register API that will allow user to register them self, so they can use credentials later on to access order and pay APIs  
  # Technology used 
  
  - Spring Boot version 2.3.7.RELEASE
  - Swagger Documentation 
  - Spring Data JPA 
  - Mysql Connector
  - Lombok
  - spring cloud openfiegn for client integration 
