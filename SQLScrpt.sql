CREATE DATABASE IF NOT EXISTS ALUNOS;

USE ALUNOS;
CREATE TABLE IF NOT EXISTS DADOS(
	RGM INT(10) NOT NULL,
	NOME VARCHAR(255),
	NOTA1 FLOAT,
	NOTA2 FLOAT,
	PRIMARY KEY(RGM));