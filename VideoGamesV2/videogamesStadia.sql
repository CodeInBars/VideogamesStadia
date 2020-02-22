Drop database if exists videogames;
Create database videogames;
use videogames;
create table games(
	
    codigo int primary key AUTO_INCREMENT,
    nombre varchar(50) not null,
    sinopsis varchar(100)
);

create table socios(
	
	dni varchar(10) primary key,
    nombre varchar(20) not null,
    apellidos varchar(40) not null,
    tarjetaBancaria varchar(30) not null
);

create table prestamos(

	dni varchar(10),
    codigo int,
    fechaPrestamo Date,
    fechaDevolucion Date,
    PRIMARY KEY (codigo,dni,fechaPrestamo),
    Foreign key(codigo) References games(codigo),
    Foreign key(dni) References socios(dni) on delete cascade
);


insert into socios values
	('41587766L', 'Paco','Jimenez','6555-8888-4444-5621'),
    ('41587763P', 'Alejandro', 'Talavan','6555-8888-4444-5211'),
    ('41581263P', 'Maria', 'Garcia','6555-8888-4423-5211');

insert into games values
	(default, 'Call of duty', 'Disparos'),
    (default, 'Warcraft 3', 'Estrategia');