drop database if exists userDB;

create database userDB;

use userDB;

create table users (
    UserID int not null auto_increment,
    UserEmail varchar(50),
    UserName varchar(50),
    
    KEY (UserID),
    
	primary key (UserID)
);

insert into users 
	(UserEmail, UserName)
values
	('markbann44@gmail.com', 'Mark'),
    ('johnsemail@cool.guy', 'John');
    
create table favorite (
    PlaceID varchar(50),
    UserID varchar(50),
    
    primary key(PlaceID),
    foreign key(UserID) references users (UserID)
);

insert into favorite
	(PlaceID, UserID)
values
	('ChIJjyoOJzAtO4gRIKkURbTxBII', 1),
    ('ChIJaWy-rTEtO4gRXzdj5_C53K8', 1),
    ('ChIJjyoOJzAtO4gRIKkURbTxBII', 2),
    ('ChIJ8y3XmzMtO4gRO03DznspBDU', 2);
    
create table stations (
	StationID int not null auto_increment,
    StationName varchar(50),
    
    primary key (StationID)
);

insert into stations
	(StationName)
values
	('Times Square'),
    ('Grand Circus Park'),
    ('Broadway'),
    ('Cadillac Center'),
    ('Greektown'),
    ('Bricktown'),
    ('Renaissance Center'),
    ('Millender Center'),
    ('Financial District'),
    ('Joe Louis Arena'),
    ('Cobo Center'),
    ('Fort/Cass'),
    ('Michigan Ave.');
    
/*create table places (
	PlaceID varchar(100),
    PlaceName varchar(100),
    PlaceVicinity varchar(100),
    
    primary key (PlaceID)
    
);

insert into places 
	(PlaceID, PlaceName, PlaceVicinity)
values
	('ChIJjyoOJzAtO4gRIKkURbTxBII', 'Slices Pizza', '1043 Woodward Avenue, Detroit'); */


    