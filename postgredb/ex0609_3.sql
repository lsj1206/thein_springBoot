SELECT current_database();

-- limit
SELECT film_id, title, release_year
FROM film
ORDER BY film_id
LIMIT 5;

SELECT film_id, title, release_year
FROM film
ORDER BY film_id
LIMIT 4 OFFSET 3;

SELECT film_id, title, rental_rate
FROM film
ORDER BY rental_rate DESC
LIMIT 10;

-- fetch
SELECT film_id, title
FROM film
ORDER BY title
FETCH FIRST ROW ONLY;

SELECT film_id, title
FROM film
ORDER BY title
FETCH FIRST 5 ROW ONLY;

SELECT film_id, title
FROM film
ORDER BY title
OFFSET 5 ROWS
FETCH FIRST 5 ROW ONLY;

-- in
SELECT film_id, title
FROM film
WHERE film_id IN (1, 2, 3);

SELECT film_id, title
FROM film
WHERE film_id = 1 OR film_id = 2 OR film_id = 3;

SELECT first_name, last_name
FROM actor
WHERE last_name IN ('Allen', 'Chase', 'Davis')
ORDER BY last_name;

-- date in
SELECT payment_id, amount, payment_date
FROM payment
WHERE payment_date::date IN ('2007-02-15', '2007-02-16');

-- count(필드) 전체 레코드수를 카운트
SELECT count(*)
FROM payment
WHERE payment_date::date IN ('2007-02-15', '2007-02-16');

-- not in
SELECT film_id, title
FROM film
WHERE film_id NOT IN (1, 2, 3)
ORDER BY film_id;

SELECT film_id, title
FROM film
WHERE film_id <> 1
AND film_id <> 2
AND film_id <> 3
ORDER BY film_id;

--between
SELECT payment_id, amount
FROM payment
WHERE payment_id BETWEEN 17503 AND 17505
ORDER BY payment_id;

-- not between
SELECT payment_id, amount
FROM payment
WHERE payment_id NOT BETWEEN 17503 AND 17505
ORDER BY payment_id;

-- between 날짜
SELECT customer_id, payment_id, amount, payment_date
FROM payment
WHERE payment_date BETWEEN '2007-02-15' AND '2007-02-20' AND amount > 10
ORDER BY payment_date;

-- like
SELECT first_name, last_name
FROM customer
WHERE first_name LIKE 'Jen%';

-- true/false using like
SELECT 'Apple' LIKE 'Apple' AS RESULT;
SELECT 'Apple' LIKE 'A%' AS RESULT;
SELECT 'Apple' LIKE 'a%' AS RESULT;

SELECT first_name, last_name
FROM customer
WHERE first_name LIKE '%her%'
ORDER BY first_name;

SELECT first_name, last_name
FROM customer
WHERE first_name LIKE '_her%'
ORDER BY first_name;

-- operater equivalent
-- ~~ LIKE
-- ~~* ILIKE
-- !~~ NOT LIKE
-- !~~* NOT ILIKE

SELECT first_name, last_name
FROM customer
WHERE first_name ~~ 'DAR%';

SELECT first_name, last_name
FROM customer
WHERE first_name ~~* 'DAR%';

SELECT first_name, last_name
FROM customer
WHERE first_name !~~ 'DAR%';

SELECT first_name, last_name
FROM customer
WHERE first_name !~~* 'DAR%';