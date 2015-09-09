CREATE DATABASE IF NOT EXISTS `springsecurity` DEFAULT CHARACTER SET utf8;
GRANT ALL PRIVILEGES ON springsecurity.* TO 'ifollowyou'@'%' IDENTIFIED BY 'ifollowyou';
flush privileges;

use springsecurity;

insert into calendar_users(email,password,first_name,last_name) values ('user1@example.com','user1','User','1');
insert into calendar_users(email,password,first_name,last_name) values ('admin1@example.com','admin1','Admin','1');
insert into calendar_users(email,password,first_name,last_name) values ('user2@example.com','user2','User','2');

insert into events (id,time,summary,description,owner,attendee) values (100,'2013-10-04 20:30:00','Birthday Party','This is going to be a great birthday',1,2);
insert into events (id,time,summary,description,owner,attendee) values (101,'2013-12-23 13:00:00','Conference Call','Call with the client',3,1);
insert into events (id,time,summary,description,owner,attendee) values (102,'2014-01-23 11:30:00','Lunch','Eating lunch together',2,3);