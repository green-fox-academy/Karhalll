DROP DATABASE IF EXISTS movies0;
CREATE DATABASE movies0;

USE movies0;

CREATE TABLE movies (
    Id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Title VARCHAR(255),
    Director VARCHAR(255),
    Year INTEGER,
    Length_minutes INTEGER
);

CREATE TABLE boxoffice (
    Movie_id INTEGER NOT NULL,
    Rating FLOAT,
    Domestic_sales BIGINT,
    International_sales BIGINT,
    FOREIGN KEY (Movie_ID) REFERENCES movies(Id)
);

INSERT INTO movies (Title, Director, Year, Length_minutes) VALUES ('Toy Story', 'John Lasseter', 1995, 81);
INSERT INTO movies (Title, Director, Year, Length_minutes) VALUES ('A Bug''s Life', 'John Lasseter', 1998, 95);
INSERT INTO movies (Title, Director, Year, Length_minutes) VALUES ('Toy Story 2', 'John Lasseter', 1999, 93);
INSERT INTO movies (Title, Director, Year, Length_minutes) VALUES ('Monsters, Inc.', 'Pete Docter', 2001, 92);
INSERT INTO movies (Title, Director, Year, Length_minutes) VALUES ('Finding Nemo', 'Andrew Stanton', 2003, 107);
INSERT INTO movies (Title, Director, Year, Length_minutes) VALUES ('The Incredibles', 'Brad Bird', 2004, 116);
INSERT INTO movies (Title, Director, Year, Length_minutes) VALUES ('Cars', 'John Lasseter', 2006, 117);
INSERT INTO movies (Title, Director, Year, Length_minutes) VALUES ('Ratatouille', 'Brad Bird', 2007, 115);
INSERT INTO movies (Title, Director, Year, Length_minutes) VALUES ('WALL-E', 'Andrew Stanton', 2008, 104);
INSERT INTO movies (Title, Director, Year, Length_minutes) VALUES ('Up', 'Pete Docter', 2009, 101);
INSERT INTO movies (Title, Director, Year, Length_minutes) VALUES ('Toy Story 3', 'Lee Unkrich', 2010, 103);
INSERT INTO movies (Title, Director, Year, Length_minutes) VALUES ('Cars 2', 'John Lasseter', 2011, 120);
INSERT INTO movies (Title, Director, Year, Length_minutes) VALUES ('Brave', 'Brenda Chapman', 2012, 102);
INSERT INTO movies (Title, Director, Year, Length_minutes) VALUES ('Monsters', 'Dan Scanlon', 2013, 110);

INSERT INTO boxoffice (Movie_id, Rating, Domestic_sales, International_sales) VALUES (3, 7.9, 245852179, 239163000);
INSERT INTO boxoffice (Movie_id, Rating, Domestic_sales, International_sales) VALUES (1, 8.3, 191796233, 170162503);
INSERT INTO boxoffice (Movie_id, Rating, Domestic_sales, International_sales) VALUES (2, 7.2, 162798565, 200600000);

SELECT Title, Rating
FROM movies
         INNER JOIN boxoffice b ON movies.Id = b.Movie_id;

UPDATE boxoffice
SET Rating = 8.2
WHERE Movie_id = 3;

DELETE FROM movies
WHERE Id = 12;