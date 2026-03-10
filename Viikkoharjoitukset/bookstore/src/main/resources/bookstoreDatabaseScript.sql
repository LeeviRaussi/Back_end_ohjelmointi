-- Delete tables in correct order
DROP TABLE IF EXISTS app_user;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS category;

-- Create User-table
CREATE TABLE app_user (
	id BIGSERIAL PRIMARY KEY,
	username VARCHAR(150) NOT NULL,
	password VARCHAR(150) NOT NULL,
	role VARCHAR(15) NOT NULL
);

-- Insert users
INSERT INTO app_user (username, password, role)
VALUES ('user', '$2a$10$BJYjlTlBFff2HMI8bxOZj.1UsDYnta6V8cVxLmEutacc8rlzCAzi.', 'USER'),
        ('admin', '$2a$10$681R2/IWETdQpqSs2AdFM.xAcTlqj2uKZzK8JEPt.uomDejxHGzu2', 'ADMIN');

-- Create Category-table
CREATE TABLE category
(category_id BIGSERIAL PRIMARY KEY,
name VARCHAR(150) NOT NULL
);

-- Insert categories
INSERT INTO category (name)
VALUES ('Horror'),
		('Dystopia'),
		('Comedy');

-- Create Book-table
CREATE TABLE book
(id BIGSERIAL PRIMARY KEY,
title VARCHAR(50) NOT NULL,
author VARCHAR(30) NOT NULL,
publication_year BIGINT NOT NULL,
isbn VARCHAR(15) NOT NULL,
price VARCHAR(10) NOT NULL,
category_id BIGINT REFERENCES category(category_id)
);

-- Insert books
INSERT INTO book (title, author, publication_year, isbn, price, category_id)
VALUES ('A Farewell to Arms', 'Ernest Hemingway', 1929, '1232323-21', '21,99', 2),
		('Animal Farm', 'George Orwell', 1945, '2212343-5', '13,29', 1);