DROP TABLE IF EXISTS aluno;

/* Criando tabela Aluno */
CREATE TABLE IF NOT EXISTS aluno(
  codUsuario INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
  nome STRING,
  cpf INTEGER UNIQUE,
  dataNascimento DATE,
  dataEntrada DATE,
  senha STRING NOT NULL 
);

INSERT INTO aluno (nome, cpf, dataNascimento, dataEntrada, senha) 
VALUES 
('Joao', 123456789, '01-01-1990', '01-01-2018', '123'),
('Carlos', 1234567890, '01-01-1999', '01-01-2020','123');