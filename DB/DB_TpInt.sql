create schema tpintegrador;

use tpintegrador;

create table tiposUsuario(
	ID int not null primary key auto_increment,
    tipo varchar(25) not null
);

insert into tiposUsuario(tipo) values('Administrador');
insert into tiposUsuario(tipo) values('Docente');

create table usuarios(
	usuario VARCHAR(25) NOT NULL PRIMARY KEY,
	pass VARCHAR(25),
	tipo INT,
	dni VARCHAR(10),
	nombre VARCHAR(50),
	apellido VARCHAR(50)
);

insert into usuarios(usuario, pass, tipo, dni, nombre, apellido) values('admin', 'admin', 1, '11111111', 'Gladys', 'Fernandez');
insert into usuarios(usuario, pass, tipo, dni, nombre, apellido) values('docente', 'docente', 2, '22222222', 'Tamara', 'Herrera');
