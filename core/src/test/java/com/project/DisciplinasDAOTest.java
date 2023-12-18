package com.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.project.Classes.Disciplinas;
import com.project.Dao.DisciplinasDAO;
import com.project.DataBase.DataBase;

public class DisciplinasDAOTest {

    public static void main(String[] args) throws IOException {

        Connection connection = null;

        try {
            // Obtém uma conexão com o banco de dados
            connection = DataBase.getInstance().getConnection();

            // Cria uma instância de DisciplinaDao
            DisciplinasDAO disciplinasDAO = new DisciplinasDAO();

            // Chame um metodo de cadastrar disciplina apartir daqui.
            Disciplinas disciplina = new Disciplinas();
            disciplina.setNomeDisciplina("Análise e Projeto de Sistemas");
            disciplina.setCodCurso(1);
            disciplina.setCodUsuario(38);
           
            // Inserindo Disciplinas
            disciplinasDAO.cadastrarDisciplina(disciplina);
            System.out.println("Disciplina inserido com sucesso.");

            System.out.println("---------------------------------");

            // Chame um metodo de autualizar disciplina apartir daqui.

            // Mostra uma disciplina pelo id
            Disciplinas disciplinasSearch = disciplinasDAO.getDisciplinasById(1);

            if (disciplinasSearch != null) {
                System.out.println("Código da disciplina: " + disciplinasSearch.getCodDisciplina() +
                        " - Nome da disciplina: " + disciplinasSearch.getNomeDisciplina());
            } else {
                System.out.println("Disciplina não encontrada.");
            }

            // Chame um metodo de listar disciplinas apartir daqui.
            disciplinasDAO.listarAlunosDisciplina(1);

            System.out.println("---------------------------------");

            // Mostrando os alunos que estão cadastrados em uma disciplina

            System.out.println("Alunos que não estão cadastrados em uma disciplina: ");

            disciplinasDAO.alunosNaoCadastradosEmDisciplina();

            // Cadastrar aluno em uma disciplina
            disciplinasDAO.alunoDisciplina(1, 30);

            System.out.println("Inserindo aluno na disciplina...");

            System.out.println("---------------------------------");

            disciplinasDAO.alunosNaoCadastradosEmDisciplina();


        } catch (SQLException e) {
            // Mensagem de erro caso não consiga conectar ao banco de dados.
            System.err.println("Erro durante o teste: " + e.getMessage());
        } finally {
            /**
             * Fecha a conexão com o banco de dados.
             * finalmente é executado mesmo se houver uma exceção.
             */
            DataBase.getInstance().closeConnection();
        }
    }

}
