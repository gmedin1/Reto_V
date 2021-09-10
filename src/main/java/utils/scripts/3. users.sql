DROP TABLE IF EXISTS users;
CREATE TABLE users (user_alias CHAR(20) NOT NULL, user_name CHAR(20) NOT NULL, user_last_name CHAR(20) NOT NULL, user_email CHAR(30) NOT NULL, user_phone_number CHAR(10) NOT NULL, user_password CHAR(20) NOT NULL, user_bird_date DATE NOT NULL, PRIMARY KEY(user_alias));
INSERT INTO users VALUES ("lucky", "Pedro", "Perez", "pedro.perez@domain.com", "3168210793", "Pedro123*!", "1999-03-29");
INSERT INTO users VALUES ("malopez", "Maria", "Lopez", "maria.lopez@domain.com", "3023095689", "Maria123*!", "1995-09-20");
INSERT INTO users VALUES ("diva", "Ana", "Diaz", "ana.diaz@domain.com", "3011992992", "Ana123*!", "1966-05-29");
INSERT INTO users VALUES ("dreamer", "Luis", "Rojas", "luis.rojas@domain.com", "3141367582", "Luis123*!", "1964-02-15");
INSERT INTO users VALUES ("ninja", "Andres", "Cruz", "andres.cruz@domain.com", "3136895995", "Andres123*!", "1996-07-14");
INSERT INTO users VALUES ("neon", "Nelson", "Ruiz", "nelson.ruiz@domain.com", "3209370920", "Nelson123*!", "1991-01-15");
INSERT INTO users VALUES ("rose", "Claudia", "Mendez", "claudia.mendez@domain.com", "3154865066", "Claudia123*!", "1953-06-23");
INSERT INTO users VALUES ("green", "Jorge", "Rodriguez", "jorge.rodriguez@domain.com", "3005602932", "Jorge123*!", "2000-12-12");