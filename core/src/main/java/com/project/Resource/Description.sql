DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS cursos;
DROP TABLE IF EXISTS disciplinas;
DROP TABLE IF EXISTS alunosDisciplinas;
DROP TABLE IF EXISTS frequencia;
DROP TABLE IF EXISTS notas;
DROP TABLE IF EXISTS historico;

/* Criando tabela Aluno */
CREATE TABLE IF NOT EXISTS usuario(
  codUsuario INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
  nome STRING,
  cpf INTEGER UNIQUE NOT NULL,
  dataNascimento DATE,
  dataEntrada DATE,
  senha STRING NOT NULL,
  codCurso STRING,
  tipoUsuario STRING,
  titulacao STRING,
  areaAtuacao STRING
);

-- Inserindo dados na tabela Aluno
  INSERT INTO usuario (nome, cpf, dataNascimento, dataEntrada, senha, codCurso, tipoUsuario, titulacao, areaAtuacao) 
  VALUES
-- Alunos
('Jason Richardson', 89738810715, '21-09-1986', '09-11-2019', 'nO9K1@Bq_7', 1, 'Aluno', NULL, NULL),
('Natalie Lloyd', 22055277296, '14-01-1999', '03-01-2019', 'JY1&hSYa%6', 2, 'Aluno', NULL, NULL),
('Julie Solomon', 45156636062, '24-03-1991', '16-04-2021', '&2H19tTr*T', 3, 'Aluno', NULL, NULL),
('Joshua Rivera', 54830191835, '12-09-1971', '05-04-2022', '(7pIVfx_%6', 4, 'Aluno', NULL, NULL),
('Ashley Caldwell', 88114337054, '13-09-1973', '20-03-2021', 'p@vfyue7TM', 5, 'Aluno', NULL, NULL),
('Adrienne Brown', 87238832431, '07-06-1934', '21-04-2019', '#R1ZWTdj$f', 1, 'Aluno', NULL, NULL),
('Robert Elliott', 80255325866, '04-03-2002', '27-11-2018', '(5wf#3Ibeg', 2, 'Aluno', NULL, NULL),
('Mark Owens', 67902201169, '05-12-1989', '28-05-2021', 'nYR8eukoH!', 3, 'Aluno', NULL, NULL),
('Jennifer Arias', 34640302964, '20-08-1971', '18-05-2021', '#*1eQ!vzS*', 4, 'Aluno', NULL, NULL),
('Patrick Nichols', 69884762689, '25-04-1986', '12-05-2022', 'wQVc1KXol)', 5, 'Aluno', NULL, NULL),
('Nicholas Brown', 26306653837, '10-05-2002', '09-07-2023', '_!IKid2SY0', 1, 'Aluno', NULL, NULL),
('Ashley Nguyen', 22455301300, '24-10-1952', '15-02-2023', '#c8RPc5Yq)', 2, 'Aluno', NULL, NULL),
('Jacqueline Coleman', 23831122924, '09-11-1945', '28-10-2019', '^+1!XUrwmr', 3, 'Aluno', NULL, NULL),
('Sarah Huber', 12166681960, '13-06-1942', '19-02-2020', '(6R3nWn4q1', 4, 'Aluno', NULL, NULL),
('Mary Caldwell', 36644035622, '08-02-1977', '24-03-2022', '(&3WA_mM*s', 5, 'Aluno', NULL, NULL),
('Blake Page', 40219720951, '09-12-2002', '08-01-2020', 'vH_B6dSk@m', 1, 'Aluno', NULL, NULL),
('Austin Pollard', 73236399637, '07-02-1948', '13-02-2021', 'XskWYp(y@3', 2, 'Aluno', NULL, NULL),
('Michelle Rogers', 19523709558, '12-01-1984', '28-12-2018', 'f&2mKAVqSn', 3, 'Aluno', NULL, NULL),
('Julia Miles', 17146410794, '11-07-1967', '13-09-2019', 'D+6lY4Qgic', 4, 'Aluno', NULL, NULL),
('Meghan Ruiz', 30310139432, '03-04-1958', '18-10-2020', 'Q49kPQun!2', 5, 'Aluno', NULL, NULL),
('William Lambert', 83789567530, '29-07-1994', '15-10-2022', 'HwCi8qMqa_', 1, 'Aluno', NULL, NULL),
('William Rogers', 23776451807, '19-12-1978', '31-08-2022', '^#7ePubufH', 2, 'Aluno', NULL, NULL),
('Angelica Medina', 53666928534, '04-09-1960', '02-04-2020', 'mjIcP2YnO$', 3, 'Aluno', NULL, NULL),
('Christopher Adams', 32957953889, '28-11-1948', '20-09-2023', '1FdFckop#^', 4, 'Aluno', NULL, NULL),
('Christina Wilson', 80432726921, '08-02-1961', '02-12-2019', '$8d408Wkq4', 5, 'Aluno', NULL, NULL),
('Natalie Padilla', 11399673445, '13-07-1937', '30-03-2022', '$l57LWe2Du', 1, 'Aluno', NULL, NULL),
('Amanda Quinn MD', 67313496494, '06-06-1984', '11-03-2022', 'ht)$BZam$8', 2, 'Aluno', NULL, NULL),
('Dennis Anderson', 41109963237, '20-08-1952', '07-02-2023', '+9H&8ncDx1', 3, 'Aluno', NULL, NULL),
('Brittany Howard', 69284758133, '22-11-1996', '23-01-2019', '%748NGo!vE', 4, 'Aluno', NULL, NULL),
('Rachael Shah', 78529163224, '26-09-1934', '23-08-2019', '%Ux2C%Cpv@', 5, 'Aluno', NULL, NULL),


-- Professores
('Karen Bates', 94291501661, '25-12-1974', '12-03-2021', '$^@4mR0z+O', 1 , 'Professor', 'Mestre', 'Chartered public finance accountant'),
('Eduardo Sanders', 59788553265, '21-11-1969', '24-06-2020', '27$3oF&pZ%', 2 , 'Professor', 'Mestre', 'Contractor'),
('Sean Jones', 44085919125, '13-01-2000', '23-09-2021', 'D$65Fnlf(K', 3 , 'Professor', 'Mestre', 'Programme researcher, broadcasting/film/video'),
('Terri Thomas', 70527235203, '07-11-1960', '03-07-2019', '@qm2%G&#P8', 4 , 'Professor', 'Doutor', 'Armed forces technical officer'),
('Kevin Curry', 334333440, '08-11-1988', '09-08-2023', '$uU34Ddg(v', 5 , 'Professor', 'Doutor', 'Financial adviser'),
('Teresa Haley', 7002711396, '22-02-1988', '21-02-2019', '!)Sv0gSoZ9', 1 , 'Professor', 'Mestre', 'Musician'),
('Kim Hill', 22036563492, '05-03-1937', '03-03-2023', '$6KwQMu30+', 2 , 'Professor', 'Bacharel', 'Accounting technician'),
('William Taylor', 23523665003, '09-03-1985', '18-09-2023', 't_m9ByXNSP', 3 , 'Professor', 'Bacharel', 'Editor, magazine features'),
('Bianca Mills', 95921867109, '03-10-1943', '03-12-2022', 'w3JzXkZr_D', 4 , 'Professor', 'Mestre', 'Therapist, art'),
('Jay Castaneda', 44975700363, '16-09-1962', '23-02-2021', 'C*Ib7Q6mzC', 5 , 'Professor', 'Doutor', 'Development worker, international aid'),
('Shelby Burton', 95521706791, '19-04-1993', '03-11-2019', 'U@J08PkA5q', 1 , 'Professor', 'Mestre', 'Investment banker, operational'),
('Timothy Lewis', 54596796047, '24-11-1971', '12-06-2023', '@P37Jqcg0R', 2 , 'Professor', 'Doutor', 'Insurance account manager'),
('Alexander Johns', 74441544684, '05-01-1936', '05-02-2021', '2((oixKsO9', 3 , 'Professor', 'Bacharel', 'Engineer, drilling'),

-- Coordenadores
('Jonathan Armstrong', 71095983344, '31-12-1950', '25-02-2023', 'Sp1hH5Wl@F', NULL, 'Coordenador', 'Mestre', 'Clinical research associate'),
('Scott Stewart', 61337245308, '17-05-1990', '09-05-2020', '!t7#VrgSid', NULL, 'Coordenador', 'Mestre', 'Customer service manager'),
('David Perry', 63157393183, '08-03-1994', '07-04-2022', 'yFas!OM5^1', NULL, 'Coordenador', 'Bacharel', 'Commissioning editor'),
('Julie Krueger', 49031728988, '28-04-1996', '02-12-2021', ')G2QuI&nfI', NULL, 'Coordenador', 'Mestre', 'Clinical psychologist'),
('Mr. Jonathan Reilly', 70444705064, '04-04-1965', '30-05-2020', '@4&RQQnBiR', NULL, 'Coordenador', 'Mestre', 'Garment/textile technologist'),
('Richard Chung', 40887279198, '15-03-1972', '15-11-2018', '!)7TEGv53T', NULL, 'Coordenador', 'Mestre', 'Camera operator'),

-- Secretario
('Carla Cook', 73196937502, '17-08-1978', '18-09-2023', 'sEi7&jVdI+', NULL,'Secretario', NULL, NULL),
('Felicia Williams', 39101858193, '23-11-1937', '29-12-2018', '%ImFd*AxQ8', NULL,'Secretario', NULL, NULL),
('Mrs. Tammy Rosales', 89357766047, '29-06-1933', '05-12-2021', '#Xwe5Knuq0', NULL,'Secretario', NULL, NULL),
('Michael King', 92113150709, '07-03-2003', '30-12-2019', '#GKEEzja*6', NULL,'Secretario', NULL, NULL);

-- Criando tabela Curso
CREATE TABLE IF NOT EXISTS cursos(
  codCurso INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
  nome STRING,
  -- Coordenador
  codUsuario INTEGER,
  FOREIGN KEY(codUsuario) REFERENCES usuario(codUsuario)
);

INSERT INTO cursos (nome, codUsuario)
VALUES
--( Curso, Coordenador desse Curso)
('Ciencia da Computacao', 44),
('Engenharia de Software', 45),
('Sistemas de Informacao', 46),
('Engenharia de Computacao', 47),
('Engenharia Eletrica', 48);

-- Criando tabela Disciplina
CREATE TABLE IF NOT EXISTS disciplinas(
  codDisciplina INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
  nome STRING,
  codCurso INTEGER,
  codUsuario INTEGER,
  -- Curso
  FOREIGN KEY(codCurso) REFERENCES cursos(codCurso),
  -- Professor Responsalvel
  FOREIGN KEY(codUsuario) REFERENCES usuario(codUsuario)
);

-- Inserindo dados na tabela Disciplina
INSERT INTO disciplinas (nome, codCurso, codUsuario)
VALUES
-- (Disciplina, Curso, Professor dessa disciplina)
('Programacao Orientada a Objetos', 1, 31),
('Programacao Estruturada', 2, 32),
('Programacao Funcional', 3, 33),
('Programacao Logica', 3, 34),
('Design', 4, NULL),
('Arquitetura de computadores', 1, 36),
('Programacao Web', 1, 31);

-- Criando tabela AlunosDisciplinas
CREATE TABLE IF NOT EXISTS alunosDisciplinas(
  codAlunoDisciplina INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
  codDisciplina INTEGER,
  codUsuario INTEGER,
  -- Disciplina que o aluno irá cursar
  FOREIGN KEY(codDisciplina) REFERENCES disciplinas(codDisciplina),

  -- Aluno irá cursar a disciplina
  FOREIGN KEY(codUsuario) REFERENCES usuario(codUsuario)

);

INSERT INTO alunosDisciplinas (codDisciplina, codUsuario)
VALUES
-- (Disciplina, Aluno)

(1, 1),
(1, 2),
(6, 3),
(5, 4),
(6, 7),
(1, 7),
(1, 9),
(6, 10);

CREATE TABLE IF NOT EXISTS frequencia (
  codFrequencia INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
  codDisciplina INTEGER,
  codUsuario INTEGER,
  presente char(1),
  dataFrequencia DATE,
  -- Frequencia da Disciplina
  FOREIGN KEY(codDisciplina) REFERENCES disciplinas(codDisciplina),
  -- Frequencia do aluno
  FOREIGN KEY(codUsuario) REFERENCES usuario(codUsuario)
);

INSERT INTO frequencia (codDisciplina, codUsuario, presente, dataFrequencia)
VALUES
--(Disciplina, Aluno, Data da frequencia)
-- data do dia 01-11-2023
(1, 1, 1, '01-11-2023'),
(1, 2, 0, '01-11-2023'),
(6, 3, 1, '01-11-2023'),
(5, 4, 0, '01-11-2023'),
(1, 7, 0, '01-11-2023'),
(1, 10, 1, '01-11-2023'),
-- data do dia 02-11-2023
(1, 1, 0, '02-11-2023'),
(1, 2, 1, '02-11-2023'),
(6, 3, 0, '02-11-2023'),
(5, 4, 1, '02-11-2023'),
(1, 7, 0, '02-11-2023'),
(1, 10, 1, '02-11-2023'),
-- data do dia 03-11-2023
(1, 1, 1, '03-11-2023'),
(1, 2, 0, '03-11-2023'),
(6, 3, 1, '03-11-2023'),
(5, 4, 1, '03-11-2023'),
(1, 7, 1, '03-11-2023'),
(1, 10, 1, '03-11-2023');

CREATE TABLE IF NOT EXISTS notas (
  codNota INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
  codDisciplina INTEGER,
  codUsuario INTEGER,
  nota Decimal(10,2),
  -- Nota da Disciplina
  FOREIGN KEY(codDisciplina) REFERENCES disciplinas(codDisciplina),
  -- Nota do aluno
  FOREIGN KEY(codUsuario) REFERENCES usuario(codUsuario)
);

INSERT INTO notas (codDisciplina, codUsuario, nota)
VALUES
--(Disciplina, Aluno, Nota)
(1, 1, 10),
(1, 1, 10),
(1, 1, 10),
(1, 2, 9),
(6, 3, 8),
(6, 3, 10),
(5, 4, 7),
(1, 7, 6),
(1, 10, 9),
(1, 10, 6),
(1, 10, 5),
(2, 10, 5);

CREATE TABLE IF NOT EXISTS historico (
  codHistorico INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
  codUsuario INTEGER,
  codDisciplina INTEGER,
  media Decimal(10,2),
  -- Historico do aluno
  FOREIGN KEY(codUsuario) REFERENCES usuario(codUsuario),
  -- Historico da disciplina
  FOREIGN KEY(codDisciplina) REFERENCES disciplinas(codDisciplina)
);

INSERT INTO historico (codUsuario, codDisciplina, media)
VALUES
--(Aluno, Disciplina, Media)
(1, 1, 10),
(1, 2, 9);