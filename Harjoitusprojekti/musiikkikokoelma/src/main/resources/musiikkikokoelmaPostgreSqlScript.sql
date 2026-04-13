/* Taulujen luonti */

DROP TABLE IF EXISTS song;
DROP TABLE IF EXISTS album;
DROP TABLE IF EXISTS artist;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS app_user;

CREATE TABLE genre (
    genre_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE artist (
    artist_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    founding_year BIGINT
);

CREATE TABLE album (
    album_id BIGSERIAL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    release_year BIGINT,
    artist_id BIGINT REFERENCES artist(artist_id) NOT NULL
);

CREATE TABLE song (
    song_id BIGSERIAL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    artist_id BIGINT REFERENCES artist(artist_id) NOT NULL,
    release_year BIGINT,
    album_id BIGINT REFERENCES album(album_id),
    length VARCHAR(8),
    genre_id BIGINT REFERENCES genre(genre_id)
);

CREATE TABLE app_user (
    user_id BIGSERIAL PRIMARY KEY,
    username VARCHAR(20) NOT NULL,
    password_hash VARCHAR(150) NOT NULL,
    role VARCHAR(15) NOT NULL
);

/* Datan lisäys */

INSERT INTO genre (name)
VALUES ('Heavy metal'),
        ('Folk'),
        ('Rock');

INSERT INTO artist (name, founding_year)
VALUES ('Iron Maiden', 1975),
        ('Neil Young', 1968),
        ('Pearl Jam', 1990);

INSERT INTO album (title, release_year, artist_id)
VALUES ('Brave New World', 2000, 1),
        ('Harvest', 1972, 2),
        ('Fear of the Dark', 1992, 1),
        ('Freedom', 1989, 2);

INSERT INTO song (title, artist_id, release_year, album_id, length, genre_id)
VALUES ('Out of the Silent Planet', 1, 2000, 1, '6:25', 1),
        ('Heart of Gold', 2, 1972, 2, '3:08', 2),
        ('Song X', 2, 1995, null, '4:40', 3),
        ('Fear of the Dark', 1, 1992, 3, null, 1),
        ('Wickerman', 1, 2000, 1, '4:05', 1),
        ('Moonchild', 1, null, null, null, null);
        
INSERT INTO app_user (username, password_hash, role)
VALUES ('user', '$2a$10$BJYjlTlBFff2HMI8bxOZj.1UsDYnta6V8cVxLmEutacc8rlzCAzi.', 'USER'),
        ('admin', '$2a$10$681R2/IWETdQpqSs2AdFM.xAcTlqj2uKZzK8JEPt.uomDejxHGzu2', 'ADMIN');