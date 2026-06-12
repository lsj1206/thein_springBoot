SELECT current_database();

CREATE TABLE departments(
		id serial PRIMARY KEY,
		name varchar(100) NOT NULL
);

CREATE TABLE employees(
		id serial PRIMARY KEY,
		name varchar(100) NOT NULL,
		department_id int NOT NULL,
		FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE CASCADE
);

