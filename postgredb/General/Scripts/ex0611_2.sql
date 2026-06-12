-- Create the main products table
CREATE TABLE products (
    product_id SERIAL PRIMARY KEY, name TEXT UNIQUE, price DECIMAL(10, 2), stock INTEGER, status TEXT, last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- Insert some initial data
INSERT INTO products (name, price, stock, status)
VALUES
    ('Laptop', 999.99, 50, 'active'),('Keyboard', 79.99, 100, 'active'),('Mouse', 29.99, 200, 'active');
-- Create a table for our updates
CREATE TABLE product_updates (
    name TEXT, price DECIMAL(10, 2), stock INTEGER, status TEXT
);
-- Insert mixed update data (new products, updates, and discontinuations)
INSERT INTO product_updates
VALUES
    ('Laptop', 1099.99, 75, 'active'),('Monitor', 299.99, 30, 'active'),('Keyboard', NULL, 0, 'discontinued'),('Headphones', 89.99, 50, 'active');

MERGE INTO products p
	USING product_updates u ON
p.name = u.name
WHEN MATCHED
AND u.status = 'discontinued' THEN DELETE
WHEN MATCHED
AND u.status = 'active' THEN
    UPDATE
SET price = COALESCE(u.price, p.price), stock = u.stock, status = u.status, last_updated = CURRENT_TIMESTAMP
WHEN NOT MATCHED
AND u.status = 'active' THEN INSERT(name, price, stock, status)
VALUES (u.name, u.price, u.stock, u.status);

SELECT *
FROM products
ORDER BY product_id;
-- alater table
CREATE TABLE shape(
		shape_id int NOT NULL, shape_name varchar NOT NULL
);

CREATE TABLE customers(
		id serial PRIMARY KEY,
		customer_name varchar(255) NOT NULL
);

ALTER TABLE customers
ADD COLUMN phone varchar(25);

ALTER TABLE customers
ADD COLUMN fax varchar(25),
ADD COLUMN email varchar(400);

INSERT INTO customers(customer_name)
VALUES ('Apple'),('Samsung'),('Sony')
RETURNING *;

ALTER TABLE customers
ADD COLUMN contact_name varchar(255);

--
UPDATE customers
SET contact_name = 'John Doe'
WHERE id=1;

UPDATE customers
SET contact_name = 'Mary Doe'
WHERE id=2;


UPDATE customers
SET contact_name = 'Lily Bush'
WHERE id=3;

SELECT * FROM customers;

-- drop column

CREATE TABLE publishers (
    publisher_id SERIAL PRIMARY KEY, name VARCHAR(255) NOT NULL
);

CREATE TABLE categories (
    category_id SERIAL PRIMARY KEY, name VARCHAR(255) NOT NULL
);

CREATE TABLE books (
    book_id SERIAL PRIMARY KEY, title VARCHAR(255) NOT NULL, isbn VARCHAR(255) NOT NULL, published_date DATE NOT NULL, description VARCHAR, category_id INT NOT NULL, publisher_id INT NOT NULL, FOREIGN KEY (publisher_id)
       REFERENCES publishers (publisher_id), FOREIGN KEY (category_id)
       REFERENCES categories (category_id)
);

-- view
CREATE VIEW book_info
AS SELECT book_id, title, isbn, published_date, name
FROM books b
INNER JOIN publishers
	USING(publisher_id)
ORDER BY title;

-- alter table ~ drop column
ALTER TABLE books DROP COLUMN category_id;

ALTER TABLE books
DROP COLUMN publisher_id CASCADE;

-- change column type

CREATE TABLE assets (
    id serial PRIMARY KEY, name TEXT NOT NULL, asset_no VARCHAR NOT NULL, description TEXT, LOCATION TEXT, acquired_date DATE NOT NULL
);

INSERT INTO assets(name, asset_no, LOCATION, acquired_date)
VALUES('Server', '10001', 'Server room', '2017-01-01'),('UPS', '10002', 'Server room', '2017-01-01')
RETURNING *;

ALTER TABLE assets
ALTER COLUMN name TYPE VARCHAR(255);

--ALTER TABLE assets
--ALTER COLUMN asset_no TYPE INT;

ALTER TABLE assets
ALTER COLUMN asset_no TYPE INT
	USING asset_no::integer;

SELECT * FROM assets;














