SELECT current_database();

CREATE TABLE colors(id serial PRIMARY KEY, bcolor varchar, fcolor varchar);

INSERT INTO
	colors(bcolor, fcolor)
VALUES ('red', 'red');

INSERT INTO
	colors(bcolor, fcolor)
VALUES ('yellow', 'yellow');

INSERT INTO
	colors(bcolor, fcolor)
VALUES ('blue', 'blue');

INSERT INTO
	colors(bcolor, fcolor)
VALUES ('green', 'green'),('green', NULL),('blue', NULL),('black', 'black');

SELECT *
FROM colors;

SELECT DISTINCT bcolor
FROM colors
ORDER BY bcolor;

CREATE TABLE student_scores(
	id serial PRIMARY KEY, name varchar(50) NOT NULL, subject varchar(50) NOT NULL, score integer NOT NULL);

SELECT * FROM student_scores;

INSERT INTO student_scores(name, subject, score)
VALUES ('Alice', 'Math', 90),('Bob', 'Math', 85),('Alice', 'Physics', 92),('Bob', 'Physics', 88),('Charlie', 'Math', 95),('Charlie', 'Physics', 90);

SELECT DISTINCT ON
(name) name, subject, score
FROM student_scores
ORDER BY
  name, score DESC;

-- Where 문법
SELECT last_name, first_name
FROM customer
WHERE first_name = 'Jamie';
-- AND 문법
SELECT last_name, first_name
FROM customer
WHERE first_name = 'Jamie'
AND last_name = 'Rice';
-- OR 문법
SELECT last_name, first_name
FROM customer
WHERE first_name = 'Jamie'
OR first_name = 'Adam';
-- IN 문법
SELECT last_name, first_name
FROM customer
WHERE first_name IN ('Ann', 'Anne', 'Annie');

-- LIKE 문법
SELECT first_name, last_name
FROM customer
WHERE first_name LIKE 'Ann%';

-- BETWEEN 문법
SELECT first_name, LENGTH(first_name) name_length
FROM customer
WHERE first_name LIKE 'A%'
AND LENGTH(first_name) BETWEEN 3
  AND 5
ORDER BY
  name_length;

-- WHERE AND
SELECT title, length, rental_rate
FROM film
WHERE length > 100
AND rental_rate < 1;

-- OR
SELECT 1 <> 1 AS RESULT;

SELECT TRUE
OR TRUE AS RESULT;

SELECT TRUE
OR FALSE AS RESULT;

SELECT TRUE
OR NULL AS RESULT;

SELECT FALSE
OR FALSE AS RESULT;

SELECT FALSE
OR NULL AS RESULT;

SELECT NULL
OR NULL AS RESULT;

-- WHERE OR
SELECT title, rental_rate
FROM film
WHERE rental_rate = 0.99
OR rental_rate = 2.99;


















