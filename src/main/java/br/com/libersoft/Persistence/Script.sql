drop database if exists libersoft;

create database liberSoft;

use libersoft;

create table administrador(
	id_administrador int not null auto_increment,
	usuario varchar (30),
	senha varchar (8),
	primary key (id)
);

create table bibliotecario(
	id_bibliotecario int not null auto_increment,
	nome varchar (70) not null,
	email varchar (100) not null unique,
	senha varchar (8) not null,
	telefone varchar (14) not null,
	cpf varchar (11) not null unique,
	primary key (id),
	fk_endereco int,
	fk_administrador int
);

create table livro(
	id_livro int not null auto_increment,
	categoria varchar (50),
	titulo varchar (50),
	volume smallint,
	autor varchar (60),
	quantidade smallint,
	resumo varchar (300),
	primary key (id),
	fk_bibliotecario int
);

create table aluno(
	id_aluno int not null auto_increment,
	nome varchar (70) not null,
	email varchar (100) not null unique,
	senha varchar (8) not null,
	telefone varchar (14) not null,
	cpf varchar (11) not null unique,
	primary key (id),
	fk_endereco int,
	fk_bibliotecario int
);

create table endereco(
	id_endereco int not null auto_increment,
	cep varchar (9),
	logradouro varchar (50),
	numero smallint,
	estado varchar (30),
	cidade varchar (30),
	complemento varchar (40),
	primary key (id)
);

create table emprestimo(
	id_emprestimo int not null auto_increment,
	data_emprestimo date not null,
	renovacoes date ,
	data_devolucao date,
	situacao varchar (20),
	primary key (id),
	fk_aluno int,
	fk_livro int
);