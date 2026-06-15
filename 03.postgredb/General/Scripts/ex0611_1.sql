SELECT current_database();

CREATE TABLE courses(
  course_id serial PRIMARY KEY, course_name VARCHAR(255) NOT NULL, price DECIMAL(10, 2) NOT NULL, description VARCHAR(500), published_date date
);

INSERT INTO courses( course_name, price, description, published_date)
VALUES
('PostgreSQL for Developers', 299.99, 'A complete PostgreSQL for Developers', '2020-07-13'),('PostgreSQL Administration', 349.99, 'A PostgreSQL Guide for DBA', NULL),('PostgreSQL High Performance', 549.99, NULL, NULL),('PostgreSQL Bootcamp', 777.99, 'Learn PostgreSQL via Bootcamp', '2013-07-11'),('Mastering PostgreSQL', 999.98, 'Mastering PostgreSQL in 21 Days', '2012-06-30')
RETURNING *;

UPDATE courses
SET
published_date = '2020-08-01'
WHERE course_id = 3;

UPDATE courses
SET
price = price * 1.05;

CREATE TABLE product_segment (
    id SERIAL PRIMARY KEY, segment VARCHAR NOT NULL, discount NUMERIC (4, 2)
);

INSERT INTO
    product_segment (segment, discount)
VALUES
    ('Grand Luxury', 0.05),('Luxury', 0.06),('Mass', 0.1);

CREATE TABLE product(
    id SERIAL PRIMARY KEY, name VARCHAR NOT NULL, price NUMERIC(10, 2), net_price NUMERIC(10, 2), segment_id INT NOT NULL, FOREIGN KEY(segment_id) REFERENCES product_segment(id)
);

INSERT INTO product (name, price, segment_id)
VALUES
    ('diam', 804.89, 1),('vestibulum aliquet', 228.55, 3),('lacinia erat', 366.45, 2),('scelerisque quam turpis', 145.33, 3),('justo lacinia', 551.77, 2),('ultrices mattis odio', 261.58, 3),('hendrerit', 519.62, 2),('in hac habitasse', 843.31, 1),('orci eget orci', 254.18, 3),('pellentesque', 427.78, 2),('sit amet nunc', 936.29, 1),('sed vestibulum', 910.34, 1),('turpis eget', 208.33, 3),('cursus vestibulum', 985.45, 1),('orci nullam', 841.26, 1),('est quam pharetra', 896.38, 1),('posuere', 575.74, 2),('ligula', 530.64, 2),('convallis', 892.43, 1),('nulla elit ac', 161.71, 3);
-- update 테이블 set필드
UPDATE product
SET
net_price = price - price * discount
FROM product_segment
WHERE product.segment_id = product_segment.id;

UPDATE product p
SET
net_price = price - price * discount
FROM product_segment s
WHERE p.segment_id = s.id;
-- delete

CREATE TABLE todos (
    id SERIAL PRIMARY KEY, title VARCHAR(255) NOT NULL, completed BOOLEAN NOT NULL DEFAULT FALSE
);

INSERT INTO todos (title, completed)
VALUES
    ('Learn basic SQL syntax', TRUE),('Practice writing SELECT queries', FALSE),('Study PostgreSQL data types', TRUE),('Create and modify tables', FALSE),('Explore advanced SQL concepts', TRUE),('Understand indexes and optimization', FALSE),('Backup and restore databases', TRUE),('Implement transactions', FALSE),('Master PostgreSQL security features', TRUE),('Build a sample application with PostgreSQL', FALSE);

SELECT *
FROM todos;

DELETE
FROM todos
WHERE id = 2
RETURNING *;

DELETE
FROM todos
WHERE completed = TRUE
RETURNING *;

CREATE TABLE MEMBER(
   id SERIAL PRIMARY KEY, first_name VARCHAR(50) NOT NULL, last_name VARCHAR(50) NOT NULL, phone VARCHAR(15) NOT NULL
);

CREATE TABLE denylist(
    phone VARCHAR(15) PRIMARY KEY
);

INSERT INTO member(first_name, last_name, phone)
VALUES ('John', 'Doe', '(408)-523-9874'),('Jane', 'Doe', '(408)-511-9876'),('Lily', 'Bush', '(408)-124-9221');

INSERT INTO denylist(phone)
VALUES ('(408)-523-9874'),('(408)-511-9876');

SELECT * FROM MEMBER;

SELECT * FROM denylist;

-- delete using
DELETE FROM MEMBER
	USING denylist
WHERE member.phone = denylist.phone;

-- delete in() 서브쿼리 사용
DELETE FROM MEMBER
WHERE phone in(SELECT phone FROM denylist);

SELECT phone FROM denylist;

-- delete cascade
CREATE TABLE departments (
    id SERIAL PRIMARY KEY, name VARCHAR(100) NOT NULL
);

CREATE TABLE employees (
    id SERIAL PRIMARY KEY, name VARCHAR(100) NOT NULL, department_id INT NOT NULL, FOREIGN KEY(department_id)
       REFERENCES departments(id)
       ON DELETE CASCADE
);


-- delete dubplicate rows using subquery

CREATE TABLE basket(
    id SERIAL PRIMARY KEY, fruit VARCHAR(50) NOT NULL
);

INSERT INTO basket(fruit)
VALUES
  ('apple'),('apple'),('orange'),('orange'),('orange'),('banana');

DELETE
FROM basket
WHERE id IN
    (SELECT id
FROM(SELECT id, ROW_NUMBER() OVER( PARTITION BY fruit
        ORDER BY id ) AS row_num
FROM basket ) t
WHERE t.row_num > 1 
);

DELETE
FROM basket
WHERE id IN
    (SELECT id
FROM(SELECT id, ROW_NUMBER() OVER( PARTITION BY fruit
        ORDER BY id DESC ) AS row_num
FROM basket ) t
WHERE t.row_num > 1 );

SELECT * FROM basket;




















