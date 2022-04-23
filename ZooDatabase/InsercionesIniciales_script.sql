USE zoo;

INSERT INTO genero (id, descripcion) VALUES ('1', 'Macho');
INSERT INTO genero (id, descripcion) VALUES ('2', 'Hembra');
-- Continente
INSERT INTO continente (descripcion) VALUES ('Norteamerica');
INSERT INTO continente (descripcion) VALUES ('Sudeamerica');
INSERT INTO continente (descripcion) VALUES ('África');
INSERT INTO continente (descripcion) VALUES ('Antártida');
INSERT INTO continente (descripcion) VALUES ('Asia');
INSERT INTO continente (descripcion) VALUES ('Oceanía');
INSERT INTO continente (descripcion) VALUES ('Europa');
-- País
INSERT INTO pais (descripcion, continente_id) VALUES ('México', '1');
-- Estado
INSERT INTO estado (descripcion, pais_id) VALUES ('Morelos', '1');
-- Ciudad
INSERT INTO zoo.ciudad(descripcion,estado_id) VALUES ('Cuernavaca', 1);
INSERT INTO zoo.ciudad(descripcion,estado_id) VALUES ('Emiliano Zapata', 1);