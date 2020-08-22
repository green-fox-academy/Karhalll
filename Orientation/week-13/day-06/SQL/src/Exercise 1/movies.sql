/* Exercise 1 */
SELECT title
FROM movie
WHERE director
          LIKE 'Steven Spielberg';

/* Exercise 2 */
SELECT DISTINCT year
FROM movie
    INNER JOIN rating
        ON movie.mID = rating.mID
WHERE stars > 3
ORDER BY year;

/* Exercise 3 */
SELECT DISTINCT title
FROM movie
    NATURAL LEFT JOIN rating
WHERE rID IS NULL;

/* Exercise 4 */
SELECT DISTINCT name
FROM reviewer
    INNER JOIN rating r ON reviewer.rID = r.rID
WHERE ratingDate IS NULL;

/* Exercise 5 */
SELECT name, title, stars, ratingDate
FROM rating
    INNER JOIN reviewer r ON rating.rID = r.rID
    INNER JOIN movie m ON rating.mID = m.mID
ORDER BY name, title, stars;

/* Exercise 6 * - not completed */
SELECT name, title, stars, ratingDate
FROM rating
    INNER JOIN reviewer r on rating.rID = r.rID
    INNER JOIN movie m on rating.mID = m.mID
;

