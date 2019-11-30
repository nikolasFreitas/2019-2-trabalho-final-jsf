CREATE DATABASE trabalho_final_jsf;

CREATE TABLE usuario (
	id TINYINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	identificador Varchar(25) not NULL,
	senha VARCHAR(25) NOT NULL
);

CREATE TABLE imovel(
	id TINYINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	matricula bigint UNIQUE not null,
	endereco varchar(25) not NULL,
	valorVenda double not null
);

SELECT * from imovel;
INSERT INTO usuario (identificador, senha) VALUES ('flaninho', '123');
