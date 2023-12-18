package com.project.Menu.MenuItens;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.project.Classes.Aluno;
import com.project.Classes.Data;
import com.project.Classes.Disciplinas;
import com.project.Classes.Frequencia;
import com.project.Classes.Notas;
import com.project.Dao.DisciplinasDAO;
import com.project.Dao.FrequenciaDAO;
import com.project.Dao.NotasDAO;
import com.project.Dao.SecretarioDAO;
import com.project.Menu.MenuItens.Listar.Space;

/**
 * Classe que representa o menu de cadastro do sistema.
 * 
 * @Author @HeitorLouzeiro
 * 
 */

public class Cadastrar {
    /**
     * Realiza o cadastro de alunos no sistema.
     *
     * @throws IOException Se ocorrer um erro de I/O durante a execução.
     */

    public void cadastrarAluno() throws IOException {
        SecretarioDAO secretarioDAO = new SecretarioDAO();
        Aluno aluno = new Aluno();
        Data dataNascimento = new Data();
        Data dataEntrada = new Data();
        Scanner scanner = new Scanner(System.in);

        int opcao = -1;
        do {
            try {
                // Implemente a lógica para verificar algo
                System.out.println("Cadastro de Aluno...");

                System.out.print("Digite o nome do aluno: ");
                aluno.setNome(scanner.nextLine());

                System.out.print("Digite o CPF do aluno: ");
                aluno.setCpf(scanner.nextLine());

                System.out.print("Coloque as datas no formato dd-mm-aaaa\n");

                System.out.print("Digite a data de nascimento do aluno: ");
                dataNascimento.setData(scanner.nextLine());
                aluno.setDataNascimento(dataNascimento);

                System.out.print("Digite a data de entrada do aluno: ");
                dataEntrada.setData(scanner.nextLine());
                aluno.setDataEntrada(dataEntrada);

                aluno.setSenha(aluno.getCpf());
                secretarioDAO.InsertAluno(aluno);

                System.out.println(Space.space);
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
            System.out.println("Deseja cadastrar outro aluno? 1 - Sim | 0 - Não");
            opcao = scanner.nextInt();
            scanner.nextLine();
        } while (opcao != 0);

    }
    /**
     * Realiza o cadastro de frequência para uma disciplina específica.
     *
     * @param codDisciplina O código da disciplina para a qual a frequência será cadastrada.
     * @throws IOException Se ocorrer um erro de I/O durante a execução.
     */

    public void cadastrarFrequencia(int codDisciplina) throws IOException {
        Frequencia frequencia = new Frequencia();
        FrequenciaDAO frequenciaDAO = new FrequenciaDAO();
        Listar listar = new Listar();
        Data data = new Data();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de frequencia do aluno...");

        System.out.print("Para continuar o cadastro da frequencia selecione a data da frequencia.\n");
        System.out.print("Deseja colocar a data de hoje? 1 - Sim | 0 - Não: ");
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            frequencia.setData(data.getDataAtual());
        } else {
            System.out.print("Coloque as datas no formato dd-mm-aaaa\n");
            System.out.print("Digite a data da aula: ");
            frequencia.setData(scanner.next());
        }

        List<Integer> codigosAlunos = listar.listarAlunosDisciplina(codDisciplina);
        try {
            // Mostra as disciplinas do professor
            frequencia.setCodDisciplina(codDisciplina);

            for (Integer codigo : codigosAlunos) {
                System.out.println("Código do aluno: " + codigo);
                frequencia.setCodUsuario(codigo);
                System.out.print("Digite a presença do aluno: 1 - Presente | 0 - Ausente: ");
                frequencia.setPresenca(scanner.nextInt());
    
                frequenciaDAO.inserirFrequenciaAluno(frequencia);
            }

            System.out.println(Space.space);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        /**
     * Realiza o cadastro de notas para uma disciplina específica.
     *
     * @param codDisciplina O código da disciplina para a qual as notas serão cadastradas.
     * @throws IOException Se ocorrer um erro de I/O durante a execução.
     */
    public void cadastrarNotas(int codDisciplina) throws IOException {
        Notas notas = new Notas();
        NotasDAO notasDAO = new NotasDAO();
        Listar listar = new Listar();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de notas do aluno...");

        List<Integer> codigosAlunos = listar.listarAlunosDisciplina(codDisciplina);

        try {
            notas.setCodDisciplina(codDisciplina);

            for (Integer codigo : codigosAlunos) {
                System.out.println("Código do aluno: " + codigo);
                notas.setCodUsuario(codigo);
                System.out.print("Digite a nota do aluno: ");
                double nota = scanner.nextDouble();
                notas.setNota(nota);
                notasDAO.cadastrarNota(notas);
            }
            System.out.println(Space.space);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Realiza o cadastro das médias dos alunos em uma disciplina específica.
     *
     * @param codDisciplina O código da disciplina para a qual as médias serão cadastradas.
     * @throws IOException Se ocorrer um erro de I/O durante a execução.
     */

    public void cadastrarMediaAlunos(int codDisciplina) throws IOException {
        Listar listar = new Listar();
        Notas notas = new Notas();
        NotasDAO notasDAO = new NotasDAO();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione o método de calcular as notas.");
        System.out.println("1 - Média de todas as notas");
        System.out.println("2 - Média das duas maiores notas");
        System.out.print("Digite o tipo de média: ");
        int tipoMedia = scanner.nextInt();

        List<Integer> codigosAlunos = listar.listarAlunosDisciplina(codDisciplina);

        try {
            System.out.println("Média de todas as notas nessa disciplina...");
            for (Integer codigo : codigosAlunos) {
                System.out.println("Código do aluno: " + codigo);
                notas.setCodUsuario(codigo);
                notas.setCodDisciplina(codDisciplina);
                int codigoUsuario = notas.getCodUsuario();

                listar.mostrarNotasAluno(codigoUsuario);
            }

            System.out.println("Deseja cadastrar as médias desses alunos?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            System.out.print("Digite a opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                cadastrarMedias(notas, codigosAlunos, codDisciplina, tipoMedia, notasDAO);
            } else if (opcao == 2) {
                System.out.println("Voltando ao menu...");
            } else {
                System.out.println("Opção inválida.");
            }

            System.out.println(Space.space);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Cadastra as médias dos alunos em uma disciplina específica.
     *
     * @param notas         O objeto Notas contendo as informações necessárias.
     * @param codigosAlunos A lista de códigos dos alunos.
     * @param codDisciplina O código da disciplina.
     * @param tipoMedia     O tipo de média a ser calculado.
     * @param notasDAO      O objeto NotasDAO para acesso ao banco de dados.
     * @throws SQLException Se ocorrer um erro SQL durante a execução.
     */

    private void cadastrarMedias(Notas notas, List<Integer> codigosAlunos, int codDisciplina,
            int tipoMedia, NotasDAO notasDAO) throws SQLException {
        for (Integer codigo : codigosAlunos) {
            System.out.println("Código do aluno: " + codigo);
            notas.setCodUsuario(codigo);
            notas.setCodDisciplina(codDisciplina);

            if (tipoMedia == 1) {
                notasDAO.calcularMediaAluno(notas);
            } else if (tipoMedia == 2) {
                notasDAO.calcularMediaDuasMaioresNotas(notas);
            }
        }
    }
    /**
     * Realiza o cadastro de uma disciplina associada a um professor.
     *
     * @param codUsuario O código do usuário/professor associado à disciplina.
     * @throws IOException Se ocorrer um erro de I/O durante a execução.
     */
    public void cadastrarDisciplina(int codUsuario) throws IOException {
        Listar listar = new Listar();
        Disciplinas disciplina = new Disciplinas();
        DisciplinasDAO disciplinasDAO = new DisciplinasDAO();
        Scanner scanner = new Scanner(System.in);

        listar.listarCursos(codUsuario);

        System.out.print("Digite o código do curso: ");
        disciplina.setCodCurso(scanner.nextInt());

        // Limpar o buffer antes de ler o nome da disciplina
        scanner.nextLine();

        System.out.print("Digite o nome da disciplina: ");
        disciplina.setNomeDisciplina(scanner.nextLine());

        listar.mostrarTodosProfessores();

        System.out.print("O codigo do professor que irá ministrar a disciplina: ");
        disciplina.setCodUsuario(scanner.nextInt());

        try {
            disciplinasDAO.cadastrarDisciplina(disciplina);
            System.out.println(Space.space);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Cadastra um aluno em uma disciplina.
     *
     * @throws IOException Se ocorrer um erro de I/O durante a execução.
     */
    public void cadastrarAlunoDisciplina() throws IOException {
        Listar listar = new Listar();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de aluno em uma disciplina...");

        System.out.println("Selecione a disciplina que deseja cadastrar o aluno: ");
        listar.disciplinasOfertadas();

        System.out.print("Digite o código da disciplina: ");
        int codDisciplina = scanner.nextInt();

        System.out.println("Selecione o aluno que deseja cadastrar na disciplina: ");
        listar.mostrarAlunosNaoCadastradosEmDisciplina();

        System.out.print("Digite o código do aluno: ");

        int codAluno = scanner.nextInt();

        try {
            DisciplinasDAO disciplinasDAO = new DisciplinasDAO();
            disciplinasDAO.alunoDisciplina(codDisciplina, codAluno);
            System.out.println(Space.space);
            listar.mostrarAlunosNaoCadastradosEmDisciplina();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
