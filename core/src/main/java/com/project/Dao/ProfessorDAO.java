package com.project.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.DataBase.DataBase;

/**
 * A classe ProfessorDAO fornece métodos para acessar e manipular dados relacionados a professores no banco de dados.
 * @author @HeitorLouzeiro
 */
public class ProfessorDAO {
    private Connection connection;

    /**
     * Construtor da classe ProfessorDAO.
     * Inicializa a conexão com o banco de dados através da instância da classe DataBase.
     *
     * @throws IOException Se houver um erro de E/S ao obter a conexão com o banco de dados.
     */
    public ProfessorDAO() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }

    /**
     * Exibe informações sobre todos os professores cadastrados no sistema.
     *
     * @throws SQLException Se ocorrer um erro SQL durante a execução da consulta.
     */
    public void mostrarTodosProfessores() throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM usuario WHERE tipoUsuario = 'Professor'";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("Código do professor: " + resultSet.getInt("codUsuario") +
                    " - Nome do professor: " + resultSet.getString("nome"));
        }

        statement.close();
    }

    /**
     * Exibe as disciplinas associadas a um professor específico.
     *
     * @param codUsuario O código do usuário/professor para o qual as disciplinas serão recuperadas.
     * @throws SQLException Se ocorrer um erro SQL durante a execução da consulta.
     */
    public void mostrarDisciplinasProfessor(int codUsuario) throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM disciplinas " +
                "WHERE codUsuario = " + codUsuario;

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("Código da disciplina: " + resultSet.getInt("codDisciplina") +
                    " - Nome da disciplina: " + resultSet.getString("nome"));
        }

        statement.close();
    }

    /**
     * Cadastra o histórico de um aluno para uma disciplina específica.
     *
     * @param codUsuario    O código do usuário/aluno.
     * @param codDisciplina O código da disciplina.
     * @param media         A média do aluno na disciplina.
     * @throws SQLException Se ocorrer um erro SQL durante a execução da consulta.
     */
    public void cadastrarHistoricoAluno(int codUsuario, int codDisciplina, double media) throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO historico (codUsuario, codDisciplina, media) VALUES (" + codUsuario + "," + codDisciplina + "," + media + ")";

        statement.executeUpdate(sql);

        statement.close();
    }
}
