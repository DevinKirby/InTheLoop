DROP DATABASE IF EXISTS userdb;
CREATE DATABASE `userdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE userdb;

CREATE TABLE User (
 UserID INT NOT NULL AUTO_INCREMENT,
 LocationName VARCHAR(45),
 LocationAddress VARCHAR(45),
 
 PRIMARY KEY (`UserID`) 
 );
 
 INSERT INTO User 
  (LocationName, LocationAddress)
  
  VALUES
('Slices', '123 street st.');
