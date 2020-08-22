CREATE DATABASE todoapp;

USE todoapp;

CREATE TABLE users (
    ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE tasks (
    ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    userID INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL,
    done BOOLEAN DEFAULT false,
    FOREIGN KEY (userID) REFERENCES users(ID)
);

INSERT INTO users (name) VALUES ('Martin');
INSERT INTO users (name) VALUES ('Matěj');
INSERT INTO users (name) VALUES ('Marek');
INSERT INTO users (name) VALUES ('Andrea');
INSERT INTO users (name) VALUES ('Tomáš');
INSERT INTO users (name) VALUES ('Mike');
INSERT INTO users (name) VALUES ('Jiřinka');
INSERT INTO users (name) VALUES ('Jakub');

INSERT INTO tasks (userID, name) VALUES (1, 'Buy Milk');
INSERT INTO tasks (userID, name) VALUES (1, 'Walk a dog');
INSERT INTO tasks (userID, name) VALUES (1, 'Fix floor');
INSERT INTO tasks (userID, name) VALUES (2, 'Buy Milk');
INSERT INTO tasks (userID, name) VALUES (2, 'Walk a dog');
INSERT INTO tasks (userID, name) VALUES (5, 'Buy Milk');
INSERT INTO tasks (userID, name) VALUES (5, 'Walk a dog');
INSERT INTO tasks (userID, name) VALUES (5, 'Fix floor');
INSERT INTO tasks (userID, name) VALUES (5, 'Trim grass');
INSERT INTO tasks (userID, name) VALUES (7, 'Buy Milk');
INSERT INTO tasks (userID, name) VALUES (7, 'Walk a dog');
INSERT INTO tasks (userID, name) VALUES (7, 'Fix floor');

SELECT users.name, tasks.name, done
FROM tasks
    INNER JOIN users ON tasks.userID = users.ID;

UPDATE users
SET name = 'Karhal'
WHERE ID = 1;

DELETE FROM tasks
WHERE name = 'Trim grass';


