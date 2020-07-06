create database matrix;

use matrix;

create table matrix.productor(
	id int AUTO_INCREMENT primary key,
	descripcion varchar(200) not  null
)

create table matrix.plataforma(
	id int AUTO_INCREMENT primary key,
	descripcion varchar(200) not  null
)

create table matrix.cliente(
	id int AUTO_INCREMENT primary key,
	documento VARCHAr(100) not null UNIQUE,
	apellidos varchar(200) not  null,
	nombres varchar(200) not null,
	telefono varchar(50) not null,
	email varchar(50) not null,
	direccion varchar(50) not null,
	fecha_nacimiento date not null	
);

create table matrix.titulo(
	id int AUTO_INCREMENT primary key,
	nombre VARCHAR(200) not null UNIQUE,
	year int not  null,
	protagonista varchar(200) not null,
	director varchar(50) not null,
	productor_id int not null,
	plataforma_id int not null,
	inventario int not null default 0,
	disponible int not null default 0,
	valor_alquiler double not null default 0.0,
	constraint fk_productor  foreign key (productor_id) REFERENCES productor(id),
	constraint fk_plataforma  foreign key (plataforma_id) REFERENCES plataforma(id)	
);

create table matrix.alquiler(
	id int AUTO_INCREMENT primary key,
	cliente_id int not null,
	titulo_id int not null,
	fecha_alquiler datetime not null default CURRENT_TIMESTAMP,
	dias_alquiler int not null default 1,
	valor_dia double not null,
	estado int not null,
	observacion varchar(100),
	constraint fk_alq_cliente  foreign key (cliente_id) REFERENCES cliente(id),
	constraint fk_alq_titulo foreign key (titulo_id) REFERENCES titulo(id)
);


create or REPLACE view matrix.vista_alquiler as
SELECT al.id, al.cliente_id, c.documento, c.apellidos, c.nombres,
YEAR(al.fecha_alquiler) as fecha_year,
timestampdiff(YEAR,c.fecha_nacimiento,CURRENT_DATE) as edad,
al.titulo_id, t.nombre, al.fecha_alquiler, al.dias_alquiler,DATE_ADD(al.fecha_alquiler, INTERVAL al.dias_alquiler DAY) as fecha_entrega, al.valor_dia, al.estado, al.observacion,
p.descripcion
FROM matrix.alquiler al
JOIN matrix.cliente c on c.id = al.cliente_id
JOIN matrix.titulo t on t.id = al.titulo_id
JOIN matrix.plataforma p on p.id = t.plataforma_id order by al.fecha_alquiler desc;

create or REPLACE view matrix.vista_cliente as
select va.documento,va.apellidos,va.nombres,count(*) as freq from matrix.vista_alquiler va
group by va.documento,va.apellidos,va.nombres
order by va.apellidos,va.nombres;

create or REPLACE view matrix.vista_titulo as
select va.titulo_id,va.nombre,count(*) as freq from matrix.vista_alquiler va
group by va.titulo_id,va.nombre
order by va.nombre;