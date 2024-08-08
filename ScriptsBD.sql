create database db_invoicing;
use db_invoicing;

create table usuarios(
 	idUsuario int primary key,
	nomeCompleto varchar(200),
 	cpf char(11),
 	rg varchar(15),
 	email varchar(200)
)

select * from usuarios;

create table faturas(
	idFatura int primary key,
	valorFatura decimal,
	nomeFatura varchar(200),
	descricaoFatura varchar(2000),
	idUsuario int,
	vencimento varchar(200),
	foreign key (idUsuario) references usuarios (idUsuario)
)

select * from faturas;

select idUsuario from usuarios;

delete from faturas where idFatura = 1;

delete from usuarios where idUsuario = 1;