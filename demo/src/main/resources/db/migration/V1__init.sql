CREATE TABLE recompensa
(
    id         INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    categoria             VARCHAR(100),
    descripcion           VARCHAR(100),
    nombre          VARCHAR(100),
    puntos_requeridos int default null
);


CREATE TABLE cliente (
      id         INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
      nombre             VARCHAR(100),
      puntos int default null
);

CREATE TABLE transaccion (
  id         INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  id_cliente int NOT NULL,
  id_recompensa int NOT NULL,
);

