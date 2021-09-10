DROP TABLE IF EXISTS editors;
CREATE TABLE editors (editor_id INT NOT NULL, editor_name CHAR(20) NOT NULL, editor_last_name CHAR(20) NOT NULL, editor_nationality CHAR(40) NOT NULL, PRIMARY KEY (editor_id));
INSERT INTO editors VALUES (1000, "Hayo", "Miyazaki", "japones");
INSERT INTO editors VALUES (1100, "Joss", "Whedon", "estadounidense");
INSERT INTO editors VALUES (1200, "Christopher", "Nolan", "estadounidense");
INSERT INTO editors VALUES (1300, "Bong", "Joon-ho", "coreano");
INSERT INTO editors VALUES (1400, "Vincent", "Ward", "neozelandes");