DROP TABLE IF EXISTS usuario;

/* Criando tabela Aluno */
CREATE TABLE IF NOT EXISTS usuario(
  codUsuario INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
  nome STRING,
  cpf INTEGER UNIQUE,
  dataNascimento DATE,
  dataEntrada DATE,
  senha STRING NOT NULL,
  tipoUsuario STRING
);

INSERT INTO usuario (nome, cpf, dataNascimento, dataEntrada, senha, tipoUsuario) 
VALUES 
('Joao', 123456789, '01-01-1990', '01-01-2018', '123', 'Coordenador'),
('Joao', 123456789900, '01-01-1990', '01-01-2018', '123', 'Aluno'),
('Carlos', 1234567890, '01-01-1999', '01-01-2020','123','Professor');