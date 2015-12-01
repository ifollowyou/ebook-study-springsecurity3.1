USE jeefw;

INSERT INTO calendar_users (id, email, password, first_name, last_name)
VALUES (0, 'user1@example.com', 'user1', 'User', '1');
INSERT INTO calendar_users (id, email, password, first_name, last_name)
VALUES (1, 'admin1@example.com', 'admin1', 'Admin', '1');
INSERT INTO calendar_users (id, email, password, first_name, last_name)
VALUES (2, 'user2@example.com', 'user2', 'User', '2');

INSERT INTO events (id, time, summary, description, owner, attendee)
VALUES (100, '2013-10-04 20:30:00', 'Birthday Party', 'This is going to be a great birthday', 0, 1);
INSERT INTO events (id, time, summary, description, owner, attendee)
VALUES (101, '2013-12-23 13:00:00', 'Conference Call', 'Call with the client', 2, 0);
INSERT INTO events (id, time, summary, description, owner, attendee)
VALUES (102, '2014-01-23 11:30:00', 'Lunch', 'Eating lunch together', 1, 2);