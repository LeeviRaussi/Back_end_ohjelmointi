CREATE TABLE category (
    category_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL
);

CREATE TABLE book (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    author VARCHAR(30) NOT NULL,
    publication_year BIGINT NOT NULL,
    isbn VARCHAR(15) NOT NULL,
    price VARCHAR(10) NOT NULL,
    category_id BIGINT REFERENCES category(category_id)
);

CREATE TABLE app_user (
	id BIGSERIAL PRIMARY KEY,
	username VARCHAR(150) NOT NULL,
	password VARCHAR(150) NOT NULL,
	role VARCHAR(15) NOT NULL
);