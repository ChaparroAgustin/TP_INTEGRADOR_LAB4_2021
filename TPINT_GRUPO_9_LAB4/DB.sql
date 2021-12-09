create database tpintegrador;

use tpintegrador;

CREATE TABLE Nacionalidades(
	ID int primary key not null auto_increment,
    Descripcion varchar(50) not null unique    
);

insert into Nacionalidades(Descripcion) values('Argentina');
insert into Nacionalidades(Descripcion) values('Brasil');
insert into Nacionalidades(Descripcion) values('USA');
insert into Nacionalidades(Descripcion) values('Uruguay');
insert into Nacionalidades(Descripcion) values('Paraguay');
insert into Nacionalidades(Descripcion) values('Bolivia');

CREATE TABLE Provincias(
	ID int primary key not null auto_increment,
    Descripcion varchar(50) not null unique    
);

insert into Provincias(Descripcion) values('Buenos Aires');
insert into Provincias(Descripcion) values('Córdoba');
insert into Provincias(Descripcion) values('Kentucky');
insert into Provincias(Descripcion) values('Santa Catarina');
insert into Provincias(Descripcion) values('Montevideo');
insert into Provincias(Descripcion) values('California');

CREATE TABLE Localidades(
	ID int primary key not null auto_increment,
    Descripcion varchar(50) not null unique    
);

insert into Localidades(Descripcion) values('Tigre');
insert into Localidades(Descripcion) values('CABA');
insert into Localidades(Descripcion) values('Ramos Mejía');
insert into Localidades(Descripcion) values('Martínez');
insert into Localidades(Descripcion) values('Olivos');
insert into Localidades(Descripcion) values('Jose C. Paz');

CREATE TABLE alumnos (
  ID int primary key not null AUTO_INCREMENT,
  Legajo varchar(10) unique NOT NULL,
  Dni varchar(8) unique not null,
  Nombre varchar(50) not null,
  Apellido varchar(50) not null,
  FechaNac date not null,
  Direccion varchar(100) not null,
  Provincia varchar(50) not null,
  Nacionalidad varchar(50) not null,
  Email varchar(100) unique not null,
  Telefono varchar(50) not null,
  Estado bit not null default 1,
  CONSTRAINT FK_Nacionalidad FOREIGN KEY (Nacionalidad) REFERENCES Nacionalidades (Descripcion),
  CONSTRAINT FK_Provincia FOREIGN KEY (Provincia) REFERENCES Provincias (Descripcion)
);

INSERT INTO alumnos(Legajo, Dni, Nombre, Apellido, FechaNac, Direccion, Provincia, Nacionalidad, Email, Telefono)
VALUES('2222','87654321','Pepa','Merengada','1992-03-10','calle verdadera 123','Buenos Aires','Argentina','pepa_merenga@yahoo.com.ar','87654321');
INSERT INTO alumnos(Legajo, Dni, Nombre, Apellido, FechaNac, Direccion, Provincia, Nacionalidad, Email, Telefono)
VALUES('1111','12345678','Pepito','Oreo','1990-03-10','calle falsa 123','Montevideo','Uruguay','pepito_oreo@yahoo.com.ar','12345678');

CREATE TABLE alumnosxcurso (
  ID int primary key not null auto_increment,
  IdAlumno int not null,
  NotaUno int null,
  NotaDos int null,
  NotaTres int null,
  NotaCuatro int null,
  CONSTRAINT FK_IdAlumno FOREIGN KEY (IdAlumno) REFERENCES alumnos (ID)
);

CREATE TABLE materias (
  ID int primary key not null auto_increment,
  Codigo varchar(10) unique not null,
  Descripcion varchar(50) unique not null
);

INSERT INTO materias(Codigo, Descripcion) VALUES('A001','Matemática');
INSERT INTO materias(Codigo, Descripcion) VALUES('A002','Programación');
INSERT INTO materias(Codigo, Descripcion) VALUES('A003','Informática');
INSERT INTO materias(Codigo, Descripcion) VALUES('A004','Inglés');

CREATE TABLE cursos (
  ID int primary key not null auto_increment,
  CodigoMateria varchar(10) not null,
  Semestre varchar(7) check (Semestre = 'Primero' or Semestre = 'Segundo'),
  Anio int,
  IdDocente int,
  CONSTRAINT FK_CodigoMateria FOREIGN KEY (CodigoMateria) REFERENCES materias (Codigo)
);

CREATE TABLE docentes (
  ID int primary key not null auto_increment,
  Legajo varchar(10) unique not null,
  Dni varchar(8) unique not null,
  Nombre varchar(50) not null,
  Apellido varchar(50) not null,
  FechaNac date not null,
  Direccion varchar(100) not null,
  Localidad varchar(50) not null,
  Nacionalidad varchar(50) not null,
  Email varchar(100) not null,
  Telefono varchar(50) not null,
  Estado bit not null default(1),
  CONSTRAINT FK_Nacionalidad2 FOREIGN KEY (Nacionalidad) REFERENCES Nacionalidades (Descripcion),
  CONSTRAINT FK_Localidad FOREIGN KEY (Localidad) REFERENCES Localidades (Descripcion)
);

INSERT INTO docentes(Legajo, Dni, Nombre, Apellido, FechaNac, Direccion, Localidad, Nacionalidad, Email, Telefono)
VALUES ('1234','12345678','martita','maestra','1990-03-10','Rosario 1234','Tigre','Argentina','martita123@yahoo.com.ar','12345678');
INSERT INTO docentes(Legajo, Dni, Nombre, Apellido, FechaNac, Direccion, Localidad, Nacionalidad, Email, Telefono)
VALUES ('4321','87654321','pedrito','maestrito','1992-03-10','Newells 4321','CABA','Argentina','pedrito123@yahoo.com.ar','87654321');

CREATE TABLE tiposusuario (
  ID int primary key not null auto_increment,
  Tipo varchar(25) unique not null
);

INSERT INTO tiposusuario(Tipo) VALUES ('Administrador');
INSERT INTO tiposusuario(Tipo) VALUES ('Docente');

CREATE TABLE usuarios (
  ID int primary key not null auto_increment,
  usuario varchar(20) unique not null,
  pass varchar(20) not null,
  tipo varchar(25) not null,
  dni varchar(8) unique not null,
  nombre varchar(50) not null,
  apellido varchar(50) not null,
  CONSTRAINT FK_tipo FOREIGN KEY (tipo) REFERENCES tiposusuario (Tipo)
);

INSERT INTO usuarios(usuario, pass, tipo, dni, nombre, apellido) VALUES('admin','admin','Administrador','11111111','Gladys','Fernandez');
INSERT INTO usuarios(usuario, pass, tipo, dni, nombre, apellido) VALUES('docente','docente','Docente','22222222','Tamara','Herrera');

CREATE VIEW `vw-alumnos` 
AS 
select alumnos.ID AS ID,
alumnos.Legajo AS Legajo,
alumnos.Dni AS Dni,
alumnos.Nombre AS Nombre,
alumnos.Apellido AS Apellido,
alumnos.FechaNac AS FechaNac,
alumnos.Direccion AS Direccion,
alumnos.Provincia AS Provincia,
alumnos.Nacionalidad AS Nacionalidad,
alumnos.Email AS Email,
alumnos.Telefono AS Telefono 
from alumnos;

CREATE VIEW `vw-listar-docentes`
AS
select docentes.ID AS ID,
docentes.Legajo AS Legajo,
docentes.Dni AS Dni,
docentes.Nombre AS Nombre,
docentes.Apellido AS Apellido,
docentes.FechaNac AS FechaNac,
docentes.Direccion AS Direccion,
docentes.Localidad AS Localidad,
docentes.Nacionalidad AS Nacionalidad,
docentes.Email AS Email,
docentes.Telefono AS Telefono
from docentes;