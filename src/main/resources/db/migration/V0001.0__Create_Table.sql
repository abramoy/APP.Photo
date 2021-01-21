CREATE TABLE customer(
	customer_id serial PRIMARY KEY,
	name varchar(30),
	email varchar(60),
	subject varchar(60),
	message varchar(500)
);