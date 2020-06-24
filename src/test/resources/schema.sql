/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  DELL
 * Created: 22/06/2020
 */

DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS titulo;
 
CREATE TABLE cliente (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    documento VARCHAr(100) not null UNIQUE,
    apellidos varchar(200) not  null,
    nombres varchar(200) not null,
    telefono varchar(50) not null,
    email varchar(50) not null,
    direccion varchar(50) not null,
    fecha_nacimiento date not null
);

create table titulo(
    id int AUTO_INCREMENT primary key,
    nombre VARCHAR(200) not null UNIQUE,
    year int not  null,
    protagonista varchar(200) not null,
    director varchar(50) not null,
    productor_id int not null,
    plataforma_id int not null,
    inventario int not null default 0,
    disponible int not null default 0,
    valor_alquiler double not null default 0.0
);

create table plataforma(
	id int AUTO_INCREMENT primary key,
	descripcion varchar(200) not  null
);