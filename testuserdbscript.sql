DROP DATABASE IF EXISTS userdb;
CREATE DATABASE `userdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE userdb;

CREATE TABLE user (
 UserID INT NOT NULL AUTO_INCREMENT,
 LocationName VARCHAR(45) NULL COMMENT '',
 LocationAddress VARCHAR(45) NULL COMMENT '',
 
 PRIMARY KEY (`UserID`) 
 );
 
 INSERT INTO user 
  (LocationName, LocationAddress)
  
  VALUES
('Slices', '123 street st.');
