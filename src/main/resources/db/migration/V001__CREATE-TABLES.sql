CREATE TABLE IF NOT EXISTS users (
   id SERIAL PRIMARY KEY,
   name VARCHAR(100) NOT NULL,
   username VARCHAR(25) NOT NULL,
   password VARCHAR(64) NOT NULL,
   email VARCHAR(100) NOT NULL,
   date_create VARCHAR(100) NOT NULL,
   enabled BOOLEAN NOT NULL DEFAULT FALSE,
   role VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS movie (
   id SERIAL PRIMARY KEY,
   title VARCHAR(255) NOT NULL,
   description VARCHAR(255),
   year INTEGER,
   fk_genre BIGINT,
   fk_director BIGINT
);

CREATE TABLE IF NOT EXISTS genre (
   id SERIAL PRIMARY KEY,
   name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS director (
   id SERIAL PRIMARY KEY,
   name VARCHAR(255) NOT NULL,
   email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS actor (
   id SERIAL PRIMARY KEY,
   name VARCHAR(255) NOT NULL,
   email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS movie_has_actor (
   id SERIAL PRIMARY KEY,
   fk_movie BIGINT,
   fk_actor BIGINT
);

CREATE TABLE IF NOT EXISTS classification (
   id SERIAL PRIMARY KEY,
   fk_user BIGINT,
   fk_movie BIGINT,
   classification INTEGER NOT NULL
);


ALTER TABLE movie ADD CONSTRAINT FK_951f0651_6fa7_4732_8ae8_3a488ba89878 FOREIGN KEY (fk_genre) REFERENCES genre(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE movie ADD CONSTRAINT FK_668693b0_b844_4d01_87c4_c3560298b2c5 FOREIGN KEY (fk_director) REFERENCES director(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE movie_has_actor ADD CONSTRAINT FK_8e8b0a31_1ad5_4200_905c_f07dbe80eab7 FOREIGN KEY (fk_movie) REFERENCES movie(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE movie_has_actor ADD CONSTRAINT FK_45b00436_8793_48a7_beec_e7a51d14d517 FOREIGN KEY (fk_actor) REFERENCES actor(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE classification ADD CONSTRAINT FK_fcf2da90_ddc6_4ccf_a0a8_f22af2b6f487 FOREIGN KEY (fk_user) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE classification ADD CONSTRAINT FK_5122ee12_8e54_4f35_9752_0c31421f38e5 FOREIGN KEY (fk_movie) REFERENCES movie(id) ON DELETE CASCADE ON UPDATE CASCADE;

