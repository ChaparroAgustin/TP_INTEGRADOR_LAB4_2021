create database tpintegrador;

use tpintegrador;

CREATE TABLE alumnos (
  CodAlumno int NOT NULL AUTO_INCREMENT,
  LegajoAlumno varchar(25) NOT NULL,
  DniAlumno int DEFAULT NULL,
  NombreAlumno varchar(25) DEFAULT NULL,
  ApellidoAlumno varchar(25) DEFAULT NULL,
  FechaNacAlumno date DEFAULT NULL,
  DireccionAlumno varchar(50) DEFAULT NULL,
  ProvinciaAlumno varchar(25) DEFAULT NULL,
  NacionalidadAlumno varchar(25) DEFAULT NULL,
  EmailAlumno varchar(25) DEFAULT NULL,
  TelefonoAlumno int DEFAULT NULL,
  EstadoAlumno bit(1) DEFAULT NULL,
  PRIMARY KEY (CodAlumno),
  UNIQUE KEY CodAlumno (CodAlumno),
  UNIQUE KEY LegajoAlumno (LegajoAlumno),
  UNIQUE KEY DniAlumno (DniAlumno),
  UNIQUE KEY EmailAlumno (EmailAlumno),
  CONSTRAINT FK_NacionalidadAlumno FOREIGN KEY (NacionalidadAlumno) REFERENCES Nacionalidades (Descripcion),
  CONSTRAINT FK_ProvinciaAlumno FOREIGN KEY (ProvinciaAlumno) REFERENCES Provincias (Descripcion)
);

INSERT INTO alumnos VALUES (1,'2222',87654321,'Pepa','Merengada','1992-03-10','calle verdadera 123','La Pampa','Argentina','pepa_merenga@yahoo.com.ar',87654321,_binary '');
INSERT INTO alumnos VALUES (2,'1111',12345678,'Pepito','Oreo','1990-03-10','calle falsa 123','La Rioja','Argentina','pepito_oreo@yahoo.com.ar',12345678,_binary '');

CREATE TABLE Nacionalidades(
	ID int primary key not null auto_increment,
    Descripcion varchar(25) not null unique    
);

insert into Nacionalidades(Descripcion) values('Argentina');
insert into Nacionalidades(Descripcion) values('Brasil');
insert into Nacionalidades(Descripcion) values('USA');
insert into Nacionalidades(Descripcion) values('Uruguay');
insert into Nacionalidades(Descripcion) values('Paraguay');
insert into Nacionalidades(Descripcion) values('Bolivia');

CREATE TABLE Provincias(
	ID int primary key not null auto_increment,
    Descripcion varchar(25) not null unique    
);

insert into Provincias(Descripcion) values('Buenos Aires');
insert into Provincias(Descripcion) values('Córdoba');
insert into Provincias(Descripcion) values('Kentucky');
insert into Provincias(Descripcion) values('Santa Catarina');
insert into Provincias(Descripcion) values('Montevideo');
insert into Provincias(Descripcion) values('California');

CREATE TABLE Localidades(
	ID int primary key not null auto_increment,
    Descripcion varchar(25) not null unique    
);

insert into Localidades(Descripcion) values('Tigre');
insert into Localidades(Descripcion) values('CABA');
insert into Localidades(Descripcion) values('Ramos Mejía');
insert into Localidades(Descripcion) values('Martínez');
insert into Localidades(Descripcion) values('Olivos');
insert into Localidades(Descripcion) values('Jose C. Paz');

CREATE TABLE alumnosxcurso (
  CodCurso int NOT NULL,
  CodAlumno int NOT NULL,
  NotaUno int DEFAULT NULL,
  NotaDos int DEFAULT NULL,
  NotaTres int DEFAULT NULL,
  NotaCuatro int DEFAULT NULL,
  KEY PK_CodCurso (CodCurso),
  KEY FK_CodAlumno (CodAlumno),
  CONSTRAINT FK_CodAlumno FOREIGN KEY (CodAlumno) REFERENCES alumnos (CodAlumno),
  CONSTRAINT PK_CodCurso FOREIGN KEY (CodCurso) REFERENCES cursos (CodCurso)
);

CREATE TABLE cursos (
  CodCurso int NOT NULL AUTO_INCREMENT,
  CodMateria varchar(25) DEFAULT NULL,
  Semestre varchar(25) DEFAULT NULL,
  anio int DEFAULT NULL,
  CodDocente varchar(25) DEFAULT NULL,
  PRIMARY KEY (CodCurso),
  KEY FK_CodMateria (CodMateria),
  CONSTRAINT FK_CodMateria FOREIGN KEY (CodMateria) REFERENCES materias (CodMateria)
);

CREATE TABLE materias (
  CodMateria varchar(25) NOT NULL,
  Descripcion varchar(25) DEFAULT NULL,
  PRIMARY KEY (CodMateria),
  UNIQUE KEY Descripcion (Descripcion)
);

INSERT INTO materias VALUES ('A001','Matemática');
INSERT INTO materias VALUES ('A002','Programación');
INSERT INTO materias VALUES ('A003','Informática');
INSERT INTO materias VALUES ('A004','Inglés');

CREATE TABLE profesores (
  CodProfesor int NOT NULL AUTO_INCREMENT,
  LegajoProfesor varchar(25) NOT NULL,
  DniProfesor int DEFAULT NULL,
  NombreProfesor varchar(25) DEFAULT NULL,
  ApellidoProfesor varchar(25) DEFAULT NULL,
  FechaNacProfesor date DEFAULT NULL,
  DireccionProfesor varchar(50) DEFAULT NULL,
  LocalidadProfesor varchar(25) DEFAULT NULL,
  NacionalidadProfesor varchar(25) DEFAULT NULL,
  EmailProfesor varchar(25) DEFAULT NULL,
  TelefonoProfesor varchar(25) DEFAULT NULL,
  PRIMARY KEY (CodProfesor),
  CONSTRAINT FK_NacionalidadProfesor FOREIGN KEY (NacionalidadProfesor) REFERENCES Nacionalidades (Descripcion),
  CONSTRAINT FK_LocalidadProfesor FOREIGN KEY (LocalidadProfesor) REFERENCES Localidades (Descripcion)
);

INSERT INTO profesores VALUES (1,'1234',12345678,'martita','maestra','1990-03-10','Rosario 1234','Belgrano','Argentina','martita123@yahoo.com.ar','12345678');
INSERT INTO profesores VALUES (2,'1234',12345678,'pedrito','maestrito','1992-03-10','Newells 4321','Parque Independencia','Argentina','pedrito123@yahoo.com.ar','87654321');

CREATE TABLE tiposusuario (
  ID int NOT NULL AUTO_INCREMENT,
  tipo varchar(25) NOT NULL,
  PRIMARY KEY (ID)
);

INSERT INTO tiposusuario VALUES (1,'Administrador');
INSERT INTO tiposusuario VALUES (2,'Docente');

CREATE TABLE usuarios (
  usuario varchar(25) NOT NULL,
  pass varchar(25) DEFAULT NULL,
  tipo int DEFAULT NULL,
  dni varchar(10) DEFAULT NULL,
  nombre varchar(50) DEFAULT NULL,
  apellido varchar(50) DEFAULT NULL,
  PRIMARY KEY (usuario)
);

INSERT INTO usuarios VALUES ('admin','admin',1,'11111111','Gladys','Fernandez');
INSERT INTO usuarios VALUES ('docente','docente',2,'22222222','Tamara','Herrera');

CREATE VIEW `vw-alumnos` 
AS 
select 
alumnos.LegajoAlumno AS LegajoAlumno,
alumnos.DniAlumno AS DniAlumno,
alumnos.NombreAlumno AS NombreAlumno,
alumnos.ApellidoAlumno AS ApellidoAlumno,
alumnos.FechaNacAlumno AS FechaNacAlumno,
alumnos.DireccionAlumno AS DireccionAlumno,
alumnos.ProvinciaAlumno AS ProvinciaAlumno,
alumnos.NacionalidadAlumno AS NacionalidadAlumno,
alumnos.EmailAlumno AS EmailAlumno,
alumnos.TelefonoAlumno AS TelefonoAlumno 
from alumnos;

CREATE VIEW `vw-listar-docentes`
AS
select profesores.CodProfesor AS CodProfesor,
profesores.LegajoProfesor AS LegajoProfesor,
profesores.DniProfesor AS DniProfesor,
profesores.NombreProfesor AS NombreProfesor,
profesores.ApellidoProfesor AS ApellidoProfesor,
profesores.FechaNacProfesor AS FechaNacProfesor,
profesores.DireccionProfesor AS DireccionProfesor,
profesores.LocalidadProfesor AS LocalidadProfesor,
profesores.NacionalidadProfesor AS NacionalidadProfesor,
profesores.EmailProfesor AS EmailProfesor,
profesores.TelefonoProfesor AS TelefonoProfesor
from profesores;