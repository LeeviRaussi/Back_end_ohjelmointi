-- PostgreSQL-testidata

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