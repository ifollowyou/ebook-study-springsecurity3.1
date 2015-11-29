USE jeefw;
DROP TABLE IF EXISTS events;
DROP TABLE IF EXISTS calendar_users;

CREATE TABLE IF NOT EXISTS calendar_users (
  id         INT PRIMARY KEY,
  email      VARCHAR(32) NOT NULL UNIQUE,
  password   VARCHAR(32) NOT NULL,
  first_name VARCHAR(32) NOT NULL,
  last_name  VARCHAR(32) NOT NULL
);

CREATE TABLE IF NOT EXISTS events (
  id          INT PRIMARY KEY,
  time        TIMESTAMP    NOT NULL,
  summary     VARCHAR(256) NOT NULL,
  description VARCHAR(256) NOT NULL,
  owner       INT          NOT NULL,
  attendee    INT          NOT NULL,

  CONSTRAINT `fk_owner` FOREIGN KEY (owner) REFERENCES calendar_users (id)
    ON DELETE CASCADE,
  CONSTRAINT `fk_attendee` FOREIGN KEY (attendee) REFERENCES calendar_users (id)
    ON DELETE CASCADE
);