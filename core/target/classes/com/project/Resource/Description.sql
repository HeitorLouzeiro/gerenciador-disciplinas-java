DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS cursos;
DROP TABLE IF EXISTS disciplinas;
DROP TABLE IF EXISTS alunosDisciplinas;
DROP TABLE IF EXISTS frequencia;


/* Criando tabela Aluno */
CREATE TABLE IF NOT EXISTS usuario(
  codUsuario INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
  nome STRING,
  cpf INTEGER UNIQUE NOT NULL,
  dataNascimento DATE,
  dataEntrada DATE,
  senha STRING NOT NULL,
  tipoUsuario STRING,
  titulacao STRING,
  areaAtuacao STRING
);

-- Inserindo dados na tabela Aluno
INSERT INTO usuario (nome, cpf, dataNascimento, dataEntrada, senha, tipoUsuario, titulacao, areaAtuacao) 
VALUES
-- Alunos
('Jason Richardson', 89738810715, '21-09-1986', '09-11-2019', 'nO9K1@Bq_7', 'Aluno', NULL, NULL),
('Natalie Lloyd', 22055277296, '14-01-1999', '03-01-2019', 'JY1&hSYa%6', 'Aluno', NULL, NULL),
('Julie Solomon', 45156636062, '24-03-1991', '16-04-2021', '&2H19tTr*T', 'Aluno', NULL, NULL),
('Joshua Rivera', 54830191835, '12-09-1971', '05-04-2022', '(7pIVfx_%6', 'Aluno', NULL, NULL),
('Ashley Caldwell', 88114337054, '13-09-1973', '20-03-2021', 'p@vfyue7TM', 'Aluno', NULL, NULL),
('Adrienne Brown', 87238832431, '07-06-1934', '21-04-2019', '#R1ZWTdj$f', 'Aluno', NULL, NULL),
('Robert Elliott', 80255325866, '04-03-2002', '27-11-2018', '(5wf#3Ibeg', 'Aluno', NULL, NULL),
('Mark Owens', 67902201169, '05-12-1989', '28-05-2021', 'nYR8eukoH!', 'Aluno', NULL, NULL),
('Jennifer Arias', 34640302964, '20-08-1971', '18-05-2021', '#*1eQ!vzS*', 'Aluno', NULL, NULL),
('Patrick Nichols', 69884762689, '25-04-1986', '12-05-2022', 'wQVc1KXol)', 'Aluno', NULL, NULL),
('Nicholas Brown', 26306653837, '10-05-2002', '09-07-2023', '_!IKid2SY0', 'Aluno', NULL, NULL),
('Ashley Nguyen', 22455301300, '24-10-1952', '15-02-2023', '#c8RPc5Yq)', 'Aluno', NULL, NULL),
('Jacqueline Coleman', 23831122924, '09-11-1945', '28-10-2019', '^+1!XUrwmr', 'Aluno', NULL, NULL),
('Sarah Huber', 12166681960, '13-06-1942', '19-02-2020', '(6R3nWn4q1', 'Aluno', NULL, NULL),
('Mary Caldwell', 36644035622, '08-02-1977', '24-03-2022', '(&3WA_mM*s', 'Aluno', NULL, NULL),
('Blake Page', 40219720951, '09-12-2002', '08-01-2020', 'vH_B6dSk@m', 'Aluno', NULL, NULL),
('Austin Pollard', 73236399637, '07-02-1948', '13-02-2021', 'XskWYp(y@3', 'Aluno', NULL, NULL),
('Michelle Rogers', 19523709558, '12-01-1984', '28-12-2018', 'f&2mKAVqSn', 'Aluno', NULL, NULL),
('Julia Miles', 17146410794, '11-07-1967', '13-09-2019', 'D+6lY4Qgic', 'Aluno', NULL, NULL),
('Meghan Ruiz', 30310139432, '03-04-1958', '18-10-2020', 'Q49kPQun!2', 'Aluno', NULL, NULL),
('William Lambert', 83789567530, '29-07-1994', '15-10-2022', 'HwCi8qMqa_', 'Aluno', NULL, NULL),
('William Rogers', 23776451807, '19-12-1978', '31-08-2022', '^#7ePubufH', 'Aluno', NULL, NULL),
('Angelica Medina', 53666928534, '04-09-1960', '02-04-2020', 'mjIcP2YnO$', 'Aluno', NULL, NULL),
('Christopher Adams', 32957953889, '28-11-1948', '20-09-2023', '1FdFckop#^', 'Aluno', NULL, NULL),
('Christina Wilson', 80432726921, '08-02-1961', '02-12-2019', '$8d408Wkq4', 'Aluno', NULL, NULL),
('Natalie Padilla', 11399673445, '13-07-1937', '30-03-2022', '$l57LWe2Du', 'Aluno', NULL, NULL),
('Amanda Quinn MD', 67313496494, '06-06-1984', '11-03-2022', 'ht)$BZam$8', 'Aluno', NULL, NULL),
('Dennis Anderson', 41109963237, '20-08-1952', '07-02-2023', '+9H&8ncDx1', 'Aluno', NULL, NULL),
('Brittany Howard', 69284758133, '22-11-1996', '23-01-2019', '%748NGo!vE', 'Aluno', NULL, NULL),
('Rachael Shah', 78529163224, '26-09-1934', '23-08-2019', '%Ux2C%Cpv@', 'Aluno', NULL, NULL),

-- Professores
('Karen Bates', 94291501661, '25-12-1974', '12-03-2021', '$^@4mR0z+O', 'Professor', 'Mestre', 'Chartered public finance accountant'),
('Eduardo Sanders', 59788553265, '21-11-1969', '24-06-2020', '27$3oF&pZ%', 'Professor', 'Mestre', 'Contractor'),
('Sean Jones', 44085919125, '13-01-2000', '23-09-2021', 'D$65Fnlf(K', 'Professor', 'Mestre', 'Programme researcher, broadcasting/film/video'),
('Terri Thomas', 70527235203, '07-11-1960', '03-07-2019', '@qm2%G&#P8', 'Professor', 'Doutor', 'Armed forces technical officer'),
('Kevin Curry', 334333440, '08-11-1988', '09-08-2023', '$uU34Ddg(v', 'Professor', 'Doutor', 'Financial adviser'),
('Teresa Haley', 7002711396, '22-02-1988', '21-02-2019', '!)Sv0gSoZ9', 'Professor', 'Mestre', 'Musician'),
('Kim Hill', 22036563492, '05-03-1937', '03-03-2023', '$6KwQMu30+', 'Professor', 'Bacharel', 'Accounting technician'),
('William Taylor', 23523665003, '09-03-1985', '18-09-2023', 't_m9ByXNSP', 'Professor', 'Bacharel', 'Editor, magazine features'),
('Bianca Mills', 95921867109, '03-10-1943', '03-12-2022', 'w3JzXkZr_D', 'Professor', 'Mestre', 'Therapist, art'),
('Jay Castaneda', 44975700363, '16-09-1962', '23-02-2021', 'C*Ib7Q6mzC', 'Professor', 'Doutor', 'Development worker, international aid'),
('Shelby Burton', 95521706791, '19-04-1993', '03-11-2019', 'U@J08PkA5q', 'Professor', 'Mestre', 'Investment banker, operational'),
('Timothy Lewis', 54596796047, '24-11-1971', '12-06-2023', '@P37Jqcg0R', 'Professor', 'Doutor', 'Insurance account manager'),
('Alexander Johns', 74441544684, '05-01-1936', '05-02-2021', '2((oixKsO9', 'Professor', 'Bacharel', 'Engineer, drilling'),

-- Coordenadores
('Jonathan Armstrong', 71095983344, '31-12-1950', '25-02-2023', 'Sp1hH5Wl@F', 'Coordenador', 'Mestre', 'Clinical research associate'),
('Scott Stewart', 61337245308, '17-05-1990', '09-05-2020', '!t7#VrgSid', 'Coordenador', 'Mestre', 'Customer service manager'),
('David Perry', 63157393183, '08-03-1994', '07-04-2022', 'yFas!OM5^1', 'Coordenador', 'Bacharel', 'Commissioning editor'),
('Julie Krueger', 49031728988, '28-04-1996', '02-12-2021', ')G2QuI&nfI', 'Coordenador', 'Mestre', 'Clinical psychologist'),
('Mr. Jonathan Reilly', 70444705064, '04-04-1965', '30-05-2020', '@4&RQQnBiR', 'Coordenador', 'Mestre', 'Garment/textile technologist'),
('Richard Chung', 40887279198, '15-03-1972', '15-11-2018', '!)7TEGv53T', 'Coordenador', 'Mestre', 'Camera operator'),

-- Secretario
('Carla Cook', 73196937502, '17-08-1978', '18-09-2023', 'sEi7&jVdI+', 'Secretario', NULL, NULL),
('Felicia Williams', 39101858193, '23-11-1937', '29-12-2018', '%ImFd*AxQ8', 'Secretario', NULL, NULL),
('Mrs. Tammy Rosales', 89357766047, '29-06-1933', '05-12-2021', '#Xwe5Knuq0', 'Secretario', NULL, NULL),
('Michael King', 92113150709, '07-03-2003', '30-12-2019', '#GKEEzja*6', 'Secretario', NULL, NULL);

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
('Ciencia da Computacao', 1),
('Engenharia de Software', 2),
('Sistemas de Informacao', 1),
('Engenharia de Computacao', NULL),
('Engenharia Eletrica', Null);

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
INSERT INTO disciplinas (nome,codCurso, codUsuario)
VALUES
-- (Disciplina, Curso, Professor dessa disciplina)
('Programacao Orientada a Objetos', 1, 4),
('Programacao Estruturada', 2, NULL),
('Programacao Funcional', 3, 5),
('Programacao Logica', 3, NULL),
('Programacao Web', 1, NULL);

-- Criando tabela AlunosDisciplinas
CREATE TABLE IF NOT EXISTS alunosDisciplinas(
  idAlunoDisciplina INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
  codUsuario INTEGER,
  codDisciplina INTEGER,
  -- Aluno irá cursar a disciplina
  FOREIGN KEY(codUsuario) REFERENCES usuario(codUsuario),

  -- Disciplina que o aluno irá cursar
  FOREIGN KEY(codDisciplina) REFERENCES disciplinas(codDisciplina)
);

INSERT INTO alunosDisciplinas (codUsuario, codDisciplina)
VALUES
-- (Aluno, Discipplina)
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 1),
(7, 2),
(8, 3),
(9, 4),
(10, 5),
(11, 1),
(12, 2),
(13, 3),
(14, 4),
(15, 5),
(16, 1),
(17, 2),
(18, 3),
(19, 4),
(20, 5),
(21, 1),
(22, 2),
(23, 3),
(24, 4),
(25, 5),
(26, 1),
(27, 2),
(28, 3),
(29, 4);

CREATE TABLE IF NOT EXISTS frequencia (
  idFrequencia INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
  codUsuario INTEGER,
  codDisciplina INTEGER,
  datafrequencia DATE,
  -- Frequencia do aluno
  FOREIGN KEY(codUsuario) REFERENCES usuario(codUsuario),
  -- Frequencia da disciplina
  FOREIGN KEY(codDisciplina) REFERENCES disciplinas(codDisciplina)
);

INSERT INTO frequencia (codUsuario, codDisciplina, datafrequencia)
VALUES
--(Aluno, Disciplina, Data da frequencia)
(1,1,'10-11-2023'),
(2,2, '10-11-2023'),
(3,3, '10-11-2023'),
(4,4, '10-11-2023'),
(5,5, '10-11-2023');
