package com.project.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.Classes.Disciplinas;
import com.project.DataBase.DataBase;

/**
 * A classe DisciplinasDAO fornece métodos para acessar e manipular dados relacionados a disciplinas no banco de dados.
 * @author @Kauanyr06 @HeitorLouzeiro
 * 
 */
public class DisciplinasDAO {
    /**
     * Conexão com o banco de dados.
     */
    private Connection connection;

    /**
     * Construtor da classe DisciplinasDAO.
     * Inicializa a conexão com o banco de dados através da instância da classe DataBase.
     *
     * @throws IOException Se houver um erro de E/S ao obter a conexão com o banco de dados.
     */
    public DisciplinasDAO() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }

    /**
     * Cadastra uma nova disciplina no banco de dados.
     *
     * @param disciplina A disciplina a ser cadastrada.
     * @throws SQLException Se ocorrer um erro SQL durante a execução da consulta.
     */
    public void cadastrarDisciplina(Disciplinas disciplina) throws SQLException {
        System.out.println("Inserindo Disciplina...");

        PreparedStatement statement = connection
                .prepareStatement("INSERT INTO disciplinas (nome, codCurso, codUsuario) VALUES (?, ?, ?)");

        statement.setString(1, disciplina.getNomeDisciplina());
        statement.setInt(2, disciplina.getCodCurso());
        statement.setInt(3, disciplina.getCodUsuario());

        statement.executeUpdate();

        statement.close();
    }

    /**
     * Edita uma disciplina com base no ID da disciplina.
     *
     * @param codDisciplina O ID da disciplina a ser editada.
     * @throws SQLException Se ocorrer um erro SQL durante a execução da consulta.
     */
    public void editarDisciplinaById(int codDisciplina) throws SQLException {
        // Implementação da edição da disciplina por ID
    }

    /**
     * Obtém uma disciplina com base no ID da disciplina.
     *
     * @param codDisciplina O ID da disciplina a ser obtida.
     * @return A disciplina correspondente ao ID fornecido.
     * @throws SQLException Se ocorrer um erro SQL durante a execução da consulta.
     */
    public Disciplinas getDisciplinasById(int codDisciplina) throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM disciplinas " +
                "WHERE codDisciplina = " + codDisciplina;

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Disciplinas disciplinas = new Disciplinas();
            disciplinas.setCodDisciplina(resultSet.getInt("codDisciplina"));
            disciplinas.setNomeDisciplina(resultSet.getString("nome"));
            disciplinas.setCodUsuario(resultSet.getInt("codUsuario"));
            return disciplinas;
        }

        statement.close();
        return null;
    }

    /**
     * Associa um aluno a uma disciplina no banco de dados.
     *
     * @param codDisciplina O ID da disciplina.
     * @param codUsuario    O ID do aluno.
     * @throws SQLException Se ocorrer um erro SQL durante a execução da consulta.
     */
    public void alunoDisciplina(int codDisciplina, int codUsuario) throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO alunosDisciplinas (codDisciplina, codUsuario) " +
                "VALUES (" + codDisciplina + ", " + codUsuario + ")";

        statement.executeUpdate(sql);
        statement.close();
    }

    /**
     * Lista alunos que não estão cadastrados em nenhuma disciplina.
     *
     * @throws SQLException Se ocorrer um erro SQL durante a execução da consulta.
     */
    public void alunosNaoCadastradosEmDisciplina() throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM usuario " +
                "WHERE tipoUsuario = 'Aluno' AND codUsuario NOT IN (SELECT codUsuario FROM alunosDisciplinas)";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("Código do aluno: " + resultSet.getInt("codUsuario") +
                    " - Nome do aluno: " + resultSet.getString("nome"));
        }

        statement.close();
    }

    /**
     * Lista os códigos dos alunos associados a uma disciplina.
     *
     * @param codDisciplina O ID da disciplina.
     * @return Uma lista de códigos de alunos associados à disciplina.
     * @throws SQLException Se ocorrer um erro SQL durante a execução da consulta.
     */
    public List<Integer> listarAlunosDisciplina(int codDisciplina) throws SQLException {
        List<Integer> codigosAlunos = new ArrayList<>();
        Statement statement = connection.createStatement();

        String sql = "SELECT alunosDisciplinas.*, usuario.nome FROM alunosDisciplinas " +
                "INNER JOIN usuario ON alunosDisciplinas.codUsuario = usuario.codUsuario " +
                "WHERE codDisciplina = " + codDisciplina;

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int codigoUsuario = resultSet.getInt("codUsuario");
            codigosAlunos.add(codigoUsuario);
            System.out.println("Código do aluno: " + resultSet.getInt("codUsuario") +
                    " - Nome do aluno: " + resultSet.getString("nome"));
        }

        statement.close();
        return codigosAlunos;
    }
}
