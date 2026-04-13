-- PostgreSQL-testitaulut
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