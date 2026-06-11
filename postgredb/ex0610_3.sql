SELECT current_database();

SELECT *
FROM customer;

SELECT c.customer_id, c.first_name, c.last_name, p.amount, p.payment_date
FROM customer c
INNER JOIN payment p
ON
p.customer_id = c.customer_id
ORDER BY p.payment_date;

SELECT *
FROM film;
-- self join
SELECT f1.title, f2.title, f1.length
FROM film f1
INNER JOIN film f2
	ON
f1.film_id <> f2.film_id
AND f1.length = f2.length;
-- 3개 join
SELECT c.customer_id, c.first_name || '-' || c.last_name customer_name, s.first_name || ' ' || s.last_name staff_name, p.amount, p.payment_date
FROM customer c
INNER JOIN payment p
	USING(customer_id)
INNER JOIN staff s
	USING(staff_id)
ORDER BY p.payment_date;
-- drop table
DROP TABLE IF EXISTS t1;

DROP TABLE IF EXISTS t2;

CREATE TABLE t1(LABEL char(1) PRIMARY KEY);

CREATE TABLE t2(score int PRIMARY KEY);

INSERT INTO T1 (LABEL)
VALUES('A'),('B');

INSERT INTO T2 (score)
VALUES(1),(2),(3);

SELECT *
FROM t1
CROSS JOIN t2
ORDER BY t1.label;

-- natural join
CREATE TABLE categories(
		category_id SERIAL PRIMARY KEY, category_name VARCHAR (255) NOT NULL
);

CREATE TABLE products(
		product_id serial PRIMARY KEY, product_name VARCHAR (255) NOT NULL, category_id INT NOT NULL, FOREIGN KEY (category_id) REFERENCES categories (category_id)
);

INSERT INTO categories(category_name)
VALUES('Smartphone'),('Laptop'),('Tablet'),('VR')
RETURNING *;

INSERT INTO products(product_name, category_id)
VALUES('iPhone', 1),('Samsung Galaxy', 1),('HP Elite', 2),('Lenovo Thinkpad', 2),('iPad', 3),('Kindle Fire', 3)
RETURNING *;

SELECT *
FROM products
NATURAL JOIN categories;

-- group by
SELECT customer_id
FROM payment
ORDER BY customer_id;

SELECT customer_id
FROM payment
GROUP BY customer_id
ORDER BY customer_id;

SELECT customer_id, sum(amount)
FROM payment
GROUP BY customer_id
ORDER BY customer_id;


SELECT customer_id, sum(amount)
FROM payment
GROUP BY customer_id
ORDER BY sum(amount) desc;

-- group by, join
SELECT first_name || ' ' || last_name full_name, SUM (amount) amount
FROM payment
	INNER JOIN customer using(customer_id)
GROUP BY full_name
ORDER BY amount DESC;

-- 날짜별(타입적용::) 결졔합계
SELECT payment_date::date payment_date, sum(amount) sum_amount
FROM payment
GROUP BY payment_date::date
ORDER BY payment_date DESC;

-- 날짜별(타입미적용) 결졔합계
SELECT payment_date payment_date, sum(amount) sum_amount
FROM payment
GROUP BY payment_date
ORDER BY payment_date DESC;

-- having (for group by)
SELECT customer_id, sum(amount) sum_amount
FROM payment
GROUP BY customer_id 
HAVING sum(amount) > 200
ORDER BY sum_amount DESC;

SELECT store_id, count(customer_id)
FROM customer
GROUP BY store_id 
HAVING count(customer_id) > 300;

-- group sets
DROP TABLE IF EXISTS sales;

CREATE TABLE sales (
    brand VARCHAR NOT NULL,
    segment VARCHAR NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (brand, segment)
);

INSERT INTO sales(brand, segment, quantity)
VALUES
    ('ABC', 'Premium', 100),
    ('ABC', 'Basic', 200),
    ('XYZ', 'Premium', 100),
    ('XYZ', 'Basic', 300)
RETURNING *;

SELECT brand, segment, sum(quantity)
FROM sales
GROUP BY brand, segment;

SELECT brand, sum(quantity)
FROM sales
GROUP BY brand;

SELECT segment, sum(quantity)
FROM sales
GROUP BY segment;

-- union all
SELECT brand, segment, SUM (quantity)
FROM sales
GROUP BY brand, segment
UNION ALL
SELECT brand, NULL, SUM (quantity)
FROM sales
GROUP BY brand
UNION ALL
SELECT NULL, segment, SUM (quantity)
FROM sales
GROUP BY segment
UNION ALL
SELECT NULL, NULL, SUM (quantity)
FROM sales;

-- grouping sets func
SELECT brand, segment, SUM (quantity)
FROM sales
GROUP BY
    GROUPING SETS (
        (brand, segment),
        (brand),
        (segment),
        ()
	);











