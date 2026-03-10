--tämä on testidataa, tiedot luodaan H2-kantaan

INSERT INTO category (name)
VALUES ('Horror'),
('Dystopia'),
('Comedy');

INSERT INTO book (title, author, publication_year, isbn, price, category_id)
VALUES ('A Farewell to Arms', 'Ernest Hemingway', 1929, '1232323-21', '21,99', 2),
		('Animal Farm', 'George Orwell', 1945, '2212343-5', '13,29', 1);

INSERT INTO app_user (username, password, role)
VALUES ('user', '$2a$10$BJYjlTlBFff2HMI8bxOZj.1UsDYnta6V8cVxLmEutacc8rlzCAzi.', 'USER'),
        ('admin', '$2a$10$681R2/IWETdQpqSs2AdFM.xAcTlqj2uKZzK8JEPt.uomDejxHGzu2', 'ADMIN');