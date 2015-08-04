DROP DATABASE IF EXISTS pizzauser;
CREATE DATABASE `pizzauser` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE pizzauser;

CREATE TABLE User (
  UserID INT NOT NULL AUTO_INCREMENT,
  LocationName VARCHAR(50),
  LocationAddress VARCHAR(50),
    
  PRIMARY KEY(UserID) 
);

INSERT INTO User 
  (LocationName, LocationAddress)

VALUES
('Pizza Place', '123 Street St.');

