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

/* Exercise 6 */
SELECT name, title
FROM movie
         INNER JOIN rating r1 USING(mId)
         INNER JOIN rating r2 USING(rId)
         INNER JOIN reviewer USING(rId)
WHERE r1.mId = r2.mId AND
      r1.ratingDate < r2.ratingDate AND
      r1.stars < r2.stars;



/* Exercise 7 */
SELECT title, MAX(stars) AS max
FROM rating
         INNER JOIN reviewer r USING (rID)
         INNER JOIN movie m USING (mID)
GROUP BY title
HAVING COUNT(title) > 1

ORDER BY title;

/* Exercise 8 */
SELECT title, (MAX(stars) - MIN(stars)) AS rating_spread
FROM movie
    INNER JOIN rating USING (mID)
GROUP BY mID
ORDER BY rating_spread DESC, title;

/* Exercise 9 */
SELECT AVG(before1980.avrerageStars) - AVG(after1980.averageStars) AS difference
FROM (
    SELECT AVG(stars) AS avrerageStars
    FROM movie
    INNER JOIN rating USING (mID)
    WHERE year < 1980
    GROUP BY mID
    ) AS before1980, (
    SELECT AVG(stars) AS averageStars
    FROM movie
    INNER JOIN rating USING (mID)
    WHERE year > 1980
    GROUP BY mID
    ) AS after1980;

