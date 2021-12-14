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
  Provincia int not null,
  Nacionalidad int not null,
  Email varchar(100) unique not null,
  Telefono varchar(50) not null,
  Estado bit not null default 1,
  CONSTRAINT FK_Nacionalidad2 FOREIGN KEY (Nacionalidad) REFERENCES Nacionalidades (ID),
  CONSTRAINT FK_Provincia FOREIGN KEY (Provincia) REFERENCES Provincias (ID)
);

INSERT INTO alumnos(Legajo, Dni, Nombre, Apellido, FechaNac, Direccion, Provincia, Nacionalidad, Email, Telefono)
VALUES('2222','87654321','Pepa','Merengada','1992-03-10','calle verdadera 123',1,1,'pepa_merenga@yahoo.com.ar','87654321');
INSERT INTO alumnos(Legajo, Dni, Nombre, Apellido, FechaNac, Direccion, Provincia, Nacionalidad, Email, Telefono)
VALUES('1111','12345678','Pepito','Oreo','1990-03-10','calle falsa 123',1,1,'pepito_oreo@yahoo.com.ar','12345678');
INSERT INTO alumnos(Legajo, Dni, Nombre, Apellido, FechaNac, Direccion, Provincia, Nacionalidad, Email, Telefono)
VALUES('3333','12345679','Pepito','Oreo','1990-03-10','calle falsa 123',1,1,'pepito_oreo1@yahoo.com.ar','12345678');
INSERT INTO alumnos(Legajo, Dni, Nombre, Apellido, FechaNac, Direccion, Provincia, Nacionalidad, Email, Telefono)
VALUES('3334','12345680','Pepito','Oreo','1990-03-10','calle falsa 123',1,1,'pepito_oreo2@yahoo.com.ar','12345678');
INSERT INTO alumnos(Legajo, Dni, Nombre, Apellido, FechaNac, Direccion, Provincia, Nacionalidad, Email, Telefono)
VALUES('3335','12345681','Pepito','Oreo','1990-03-10','calle falsa 123',1,1,'pepito_oreo3@yahoo.com.ar','12345678');
INSERT INTO alumnos(Legajo, Dni, Nombre, Apellido, FechaNac, Direccion, Provincia, Nacionalidad, Email, Telefono)
VALUES('3336','12345682','Pepito','Oreo','1990-03-10','calle falsa 123',1,1,'pepito_oreo4@yahoo.com.ar','12345678');
INSERT INTO alumnos(Legajo, Dni, Nombre, Apellido, FechaNac, Direccion, Provincia, Nacionalidad, Email, Telefono)
VALUES('3337','12345683','Pepito','Oreo','1990-03-10','calle falsa 123',1,1,'pepito_oreo5@yahoo.com.ar','12345678');

CREATE TABLE materias (
  ID int primary key not null auto_increment,
  Descripcion varchar(50) unique not null
);

INSERT INTO materias(Descripcion) VALUES('Matemática');
INSERT INTO materias(Descripcion) VALUES('Programación');
INSERT INTO materias(Descripcion) VALUES('Informática');
INSERT INTO materias(Descripcion) VALUES('Inglés');

CREATE TABLE docentes (
  ID int primary key not null auto_increment,
  Legajo varchar(10) unique not null,
  Dni varchar(8) unique not null,
  Nombre varchar(50) not null,
  Apellido varchar(50) not null,
  FechaNac date not null,
  Direccion varchar(100) not null,
  Localidad int not null,
  Nacionalidad int not null,
  Email varchar(100) not null,
  Telefono varchar(50) not null,
  Estado bit not null default 1,
  CONSTRAINT FK_Nacionalidad FOREIGN KEY (Nacionalidad) REFERENCES Nacionalidades (ID),
  CONSTRAINT FK_Localidad FOREIGN KEY (Localidad) REFERENCES Localidades (ID)
);

INSERT INTO docentes(Legajo, Dni, Nombre, Apellido, FechaNac, Direccion, Localidad, Nacionalidad, Email, Telefono)
VALUES ('1234','12345678','martita','maestra','1990-03-10','Rosario 1234',2,1,'martita123@yahoo.com.ar','12345678');
INSERT INTO docentes(Legajo, Dni, Nombre, Apellido, FechaNac, Direccion, Localidad, Nacionalidad, Email, Telefono)
VALUES ('4321','87654321','pedrito','maestrito','1992-03-10','Newells 4321',5,1,'pedrito123@yahoo.com.ar','87654321');

CREATE TABLE cursos (
  ID int primary key not null auto_increment,
  IdMateria int not null,
  Semestre int check (Semestre = 1 or Semestre = 2),
  Anio int,
  IdDocente int,
  CONSTRAINT FK_IdMateria FOREIGN KEY (IdMateria) REFERENCES materias (ID),
  CONSTRAINT FK_IdDocente FOREIGN KEY (IdDocente) REFERENCES docentes (ID)
);

CREATE TABLE alumnosxcurso (
  ID int primary key not null auto_increment,
  IdCurso int not null,
  IdAlumno int not null,
  NotaUno int null,
  NotaDos int null,
  NotaTres int null,
  NotaCuatro int null,
  CONSTRAINT FK_IdAlumno FOREIGN KEY (IdAlumno) REFERENCES alumnos (ID),
  CONSTRAINT FK_IdCurso FOREIGN KEY (IdCurso) REFERENCES cursos (ID)
);

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
  idTipo int not null,
  dni varchar(8) unique not null,
  nombre varchar(50) not null,
  apellido varchar(50) not null,
  CONSTRAINT FK_idTipo FOREIGN KEY (idTipo) REFERENCES tiposusuario (ID)
);

INSERT INTO usuarios(usuario, pass, idTipo, dni, nombre, apellido) VALUES('admin','admin',1,'11111111','Gladys','Fernandez');
INSERT INTO usuarios(usuario, pass, idTipo, dni, nombre, apellido) VALUES('docente','docente',2,'22222222','Tamara','Herrera');

CREATE VIEW `vw-alumnos` 
AS 
select alumnos.ID AS ID,
alumnos.Legajo AS Legajo,
alumnos.Dni AS Dni,
alumnos.Nombre AS Nombre,
alumnos.Apellido AS Apellido,
alumnos.FechaNac AS FechaNac,
alumnos.Direccion AS Direccion,
alumnos.Provincia AS IdProvincia,
(select Provincias.Descripcion from Provincias where Provincias.ID = alumnos.Provincia) AS Provincia,
alumnos.Nacionalidad AS IdNacionalidad,
(select Nacionalidades.Descripcion from Nacionalidades where Nacionalidades.ID = alumnos.Nacionalidad) AS Nacionalidad,
alumnos.Email AS Email,
alumnos.Telefono AS Telefono, 
alumnos.Estado AS Estado
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
docentes.Localidad AS IdLocalidad,
(select Localidades.Descripcion from Localidades where Localidades.ID = docentes.Localidad) AS Localidad,
docentes.Nacionalidad AS IdNacionalidad,
(select Nacionalidades.Descripcion from Nacionalidades where Nacionalidades.ID = docentes.Nacionalidad) AS Nacionalidad,
docentes.Email AS Email,
docentes.Telefono AS Telefono,
docentes.Estado AS Estado
from docentes;

CREATE VIEW `vw-usuarios`
AS
select usuarios.ID AS ID,
usuarios.usuario AS usuario,
usuarios.pass AS pass,
usuarios.idTipo AS idTipo,
(select Tipo from tiposusuario where ID = usuarios.idTipo) AS tipo,
usuarios.dni AS dni,
usuarios.nombre AS nombre,
usuarios.apellido AS apellido
from usuarios;

DELIMITER $$
create TRIGGER TR_ACTUALIZAR_USUARIO
before update ON docentes
FOR EACH ROW
BEGIN
	set @NombreDocente = new.Nombre;
    set @ApellidoDocente = new.Apellido;
    set @DniNuevoDocente = new.Dni;
    set @DniActualDocente = old.Dni;
    set @UsuarioActualDocente = (select concat(@DniActualDocente,'.frgp'));
    set @UsuarioNuevoDocente = (select concat(@DniNuevoDocente,'.frgp'));
    set @IdUsuario = (select ID from usuarios where usuario = @UsuarioActualDocente);
    
    update usuarios
	set nombre = @NombreDocente,
    apellido = @ApellidoDocente,
    dni = @DniNuevoDocente,
    usuario = @UsuarioNuevoDocente
    where ID = @IdUsuario;
    
END$$
DELIMITER ;