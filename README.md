# DayCare
## Project Setup ##
### Database: MySQL 8.0.27 ###
<ul>
  <li>1. host: localhost</li>
  <li>2. database: daycare</li>
  <li>3. Use the dump file Dump20211212.sql to create tables for daycare</li>
  <li>4. Update user and password in data/DatabaseConnector.java if needed</li>
</ul>

## Project Structure ##
### Package: edu.neu.csye6200 ###
* __controller/__ 
* Helper functions for login credentials, ceating classroom and student registration

* __data/__ 
* Data Access Object (DAO) for each table

* __models/__ 
* Data models for each table

* __utils/__ 
* Utility function for reading and writing files

* __view/__ 
* The GUI of the application

* __Driver.java__ 
* The entry point of the application
