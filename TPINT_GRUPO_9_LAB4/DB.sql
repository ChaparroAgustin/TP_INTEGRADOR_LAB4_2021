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
insert into Nacionalidades(Descripcion) values('Chile');
insert into Nacionalidades(Descripcion) values('Alemania');
insert into Nacionalidades(Descripcion) values('Francia');
insert into Nacionalidades(Descripcion) values('Inglaterra');
insert into Nacionalidades(Descripcion) values('China');
insert into Nacionalidades(Descripcion) values('Corea');
insert into Nacionalidades(Descripcion) values('Japón');
insert into Nacionalidades(Descripcion) values('España');
insert into Nacionalidades(Descripcion) values('Portugal');

CREATE TABLE Provincias(
	ID int primary key not null auto_increment,
    Descripcion varchar(50) not null unique    
);

insert into Provincias(Descripcion) values('Buenos Aires');
insert into Provincias(Descripcion) values('Córdoba');
insert into Provincias(Descripcion) values('Santa Fe');
insert into Provincias(Descripcion) values('San Juan');
insert into Provincias(Descripcion) values('La Pampa');
insert into Provincias(Descripcion) values('Santa Cruz');
insert into Provincias(Descripcion) values('Entre Ríos');
insert into Provincias(Descripcion) values('Jujuy');
insert into Provincias(Descripcion) values('Santiago del Estero');
insert into Provincias(Descripcion) values('Misiones');
insert into Provincias(Descripcion) values('Chaco');
insert into Provincias(Descripcion) values('Río Negro');
insert into Provincias(Descripcion) values('Salta');
insert into Provincias(Descripcion) values('Tierra del Fuego');
insert into Provincias(Descripcion) values('Chubut');

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
insert into Localidades(Descripcion) values('Pacheco');
insert into Localidades(Descripcion) values('Escobar');
insert into Localidades(Descripcion) values('Villa Adelina');
insert into Localidades(Descripcion) values('Villa Ballester');
insert into Localidades(Descripcion) values('Garín');
insert into Localidades(Descripcion) values('Pilar');
insert into Localidades(Descripcion) values('Castelar');
insert into Localidades(Descripcion) values('Caseros');
insert into Localidades(Descripcion) values('San Martín');

CREATE TABLE alumnos (
  ID int primary key not null AUTO_INCREMENT,
  Legajo varchar(8) unique NOT NULL,
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

CREATE TABLE materias (
  ID int primary key not null auto_increment,
  Descripcion varchar(50) unique not null
);

INSERT INTO materias(Descripcion) VALUES('Matemática I');
INSERT INTO materias(Descripcion) VALUES('Programación I');
INSERT INTO materias(Descripcion) VALUES('Laboratorio I');
INSERT INTO materias(Descripcion) VALUES('Estadística I');
INSERT INTO materias(Descripcion) VALUES('Matemática II');
INSERT INTO materias(Descripcion) VALUES('Programación II');
INSERT INTO materias(Descripcion) VALUES('Laboratorio II');
INSERT INTO materias(Descripcion) VALUES('Estadística II');
INSERT INTO materias(Descripcion) VALUES('Matemática III');
INSERT INTO materias(Descripcion) VALUES('Programación III');
INSERT INTO materias(Descripcion) VALUES('Laboratorio III');
INSERT INTO materias(Descripcion) VALUES('Estadística III');
INSERT INTO materias(Descripcion) VALUES('Matemática IV');
INSERT INTO materias(Descripcion) VALUES('Programación IV');
INSERT INTO materias(Descripcion) VALUES('Laboratorio IV');

CREATE TABLE docentes (
  ID int primary key not null auto_increment,
  Legajo varchar(8) unique not null,
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
  NotaUno int not null default 0,
  NotaDos int not null default 0,
  NotaTres int not null default 0,
  NotaCuatro int not null default 0,
  Estado bit not null default 1,
  CONSTRAINT FK_IdAlumno FOREIGN KEY (IdAlumno) REFERENCES alumnos (ID),
  CONSTRAINT FK_IdCurso FOREIGN KEY (IdCurso) REFERENCES cursos (ID)
);
/*
	Estados de alumnosxcurso: 1 - REGULAR
							  0 - LIBRE
*/

CREATE TABLE tiposusuario (
  ID int primary key not null auto_increment,
  Tipo varchar(25) unique not null
);

INSERT INTO tiposusuario(Tipo) VALUES ('Administrador');
INSERT INTO tiposusuario(Tipo) VALUES ('Docente');

CREATE TABLE usuarios (
  ID int primary key not null auto_increment,
  usuario varchar(13) unique not null,
  pass varchar(20) not null,
  idTipo int not null,
  dni varchar(8) unique not null,
  nombre varchar(50) not null,
  apellido varchar(50) not null,
  CONSTRAINT FK_idTipo FOREIGN KEY (idTipo) REFERENCES tiposusuario (ID)
);

INSERT INTO usuarios(usuario, pass, idTipo, dni, nombre, apellido) VALUES('admin','admin',1,'12345678','Administrador','Administrador');

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

CREATE VIEW `vw-cursos`
AS
select cursos.ID AS ID,
(select Descripcion from materias where ID = cursos.IdMateria) AS Materia,
cursos.Semestre AS Semestre,
cursos.Anio AS Anio,
(select concat(Nombre,' ',Apellido) from docentes where ID = cursos.IdDocente) AS Docente
from cursos;

CREATE VIEW `vw-alumnosxcurso`
AS
select alumnosxcurso.ID AS ID,
alumnosxcurso.IdCurso AS IdCurso,
alumnosxcurso.IdAlumno AS IdAlumno,
(select Legajo from alumnos where ID = alumnosxcurso.IdAlumno) AS Legajo,
(select Dni from alumnos where ID = alumnosxcurso.IdAlumno) AS Dni,
(select Nombre from alumnos where ID = alumnosxcurso.IdAlumno) AS Nombre,
(select Apellido from alumnos where ID = alumnosxcurso.IdAlumno) AS Apellido,
alumnosxcurso.NotaUno AS Nota1,
alumnosxcurso.NotaDos AS Nota2,
alumnosxcurso.NotaTres AS Nota3,
alumnosxcurso.NotaCuatro AS Nota4,
alumnosxcurso.Estado AS Estado
from alumnosxcurso;

DELIMITER $$
create TRIGGER TR_ACTUALIZAR_USUARIO
before update ON docentes
FOR EACH ROW
BEGIN
	set @EstadoNuevo = new.Estado;
	set @NombreDocente = new.Nombre;
    set @ApellidoDocente = new.Apellido;
    set @DniNuevoDocente = new.Dni;
    set @DniActualDocente = old.Dni;
    set @UsuarioActualDocente = (select concat(@DniActualDocente,'.frgp'));
    set @UsuarioNuevoDocente = (select concat(@DniNuevoDocente,'.frgp'));
    set @IdUsuario = (select ID from usuarios where usuario = @UsuarioActualDocente);
    
   IF @EstadoNuevo = 0 THEN
        delete from usuarios where ID = @IdUsuario;
	ELSE
		update usuarios
			set nombre = @NombreDocente,
				apellido = @ApellidoDocente,
				dni = @DniNuevoDocente,
				usuario = @UsuarioNuevoDocente
			where ID = @IdUsuario;
    END IF;
END$$
DELIMITER ;