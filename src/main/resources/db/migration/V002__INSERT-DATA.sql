

INSERT INTO actor (id, name, email) VALUES (1, 'Magan Fox', 'foxmegan@gmail.com');
INSERT INTO actor (id, name, email) VALUES (2, 'Noel Fisher', 'fisher@gmail.com');
INSERT INTO actor (id, name, email) VALUES (3, 'Will Arnett', 'arnett@gmail.com');
INSERT INTO actor (id, name, email) VALUES (4, 'Will Smith', 'smith@gmail.com');
INSERT INTO actor (id, name, email) VALUES (5, 'Tommy Lee Jones', 'leetommy@gmail.com');
INSERT INTO actor (id, name, email) VALUES (6, 'Emma Thompson', 'thompsonemma@gmail.com');

INSERT INTO director (id, name, email) VALUES (1, 'Jonathan Liebesman', 'liebesman@gmail.com');
INSERT INTO director (id, name, email) VALUES (3, 'Barry Sonnenfeld', 'sonnenfeld@gmail.com');

INSERT INTO genre (id, name) VALUES (1, 'AÇÃO');
INSERT INTO genre (id, name) VALUES (2, 'TERROR');
INSERT INTO genre (id, name) VALUES (3, 'ROMANCE');
INSERT INTO genre (id, name) VALUES (4, 'FICÇÃO');

INSERT INTO movie (id, title, description, year, fk_genre, fk_director) VALUES (1, 'As Tartarugas Ninja', 'Tartarugas Lutadoras', 2014, 1, 1);
INSERT INTO movie (id, title, description, year, fk_genre, fk_director) VALUES (2, 'MIB - Homens de Preto', 'Caçadores de Aliens', 1997, 4, 3);

INSERT INTO movie_has_actor (id, fk_movie, fk_actor) VALUES (1, 1, 1);
INSERT INTO movie_has_actor (id, fk_movie, fk_actor) VALUES (2, 1, 2);
INSERT INTO movie_has_actor (id, fk_movie, fk_actor) VALUES (3, 1, 3);
INSERT INTO movie_has_actor (id, fk_movie, fk_actor) VALUES (4, 2, 4);
INSERT INTO movie_has_actor (id, fk_movie, fk_actor) VALUES (5, 2, 5);
INSERT INTO movie_has_actor (id, fk_movie, fk_actor) VALUES (6, 2, 6);

INSERT INTO users(
	id, name, username, email, date_create, enabled, password, role)
	VALUES (1, 'Super Usuario','superuser', 'super@mail.com', '2021-11-14', TRUE, '$2a$10$YCLLzr0Sv.jFDslcnqT25uDa3aUkt6RUs26V7ppUwXtNg5uwOy6Vq', 'ROLE_ADMIN'),
	(2, 'Usuario Comum','user','user@gmail.com', '2021-11-23', TRUE, '$2a$10$VpPt/RRo0In9uQCR/TSWlexHnkhuNM44ZOkT4KJjOG/ZwKbsNc9d2','ROLE_USER')
;

INSERT INTO classification (id, fk_user, fk_movie, grade) VALUES (1, 2, 1, 4);
INSERT INTO classification (id, fk_user, fk_movie, grade) VALUES (2, 2, 2, 3);



    