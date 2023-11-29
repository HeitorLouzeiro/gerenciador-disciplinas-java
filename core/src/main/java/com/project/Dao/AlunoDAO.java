package com.project.Dao;

import com.project.DataBase.DataBase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A classe AlunoDAO fornece métodos para acessar e manipular dados relacionados a alunos no banco de dados.
 * @autor @HeitorLouzeiro
 */
public class AlunoDAO {
    private Connection connection;

    /**
     * Construtor da classe AlunoDAO.
     * Inicializa a conexão com o banco de dados através da instância da classe DataBase.
     *
     * @throws IOException Se houver um erro de E/S ao obter a conexão com o banco de dados.
     */
    public AlunoDAO() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }

    /**
     * Recupera e exibe informações sobre disciplinas associadas a um aluno específico.
     *
     * @param codUsuario O código do usuário/aluno para o qual as disciplinas serão recuperadas.
     * @throws SQLException Se ocorrer um erro SQL durante a execução da consulta.
     */
    public void mostrarDisciplinasAluno(int codUsuario) throws SQLException {
        // Criação do objeto Statement para executar consultas SQL
        Statement statement = connection.createStatement();

        // Consulta SQL para recuperar informações sobre disciplinas associadas a um aluno específico
        String sql = "SELECT * FROM alunosDisciplinas INNER JOIN disciplinas ON alunosDisciplinas.codDisciplina = disciplinas.codDisciplina " +
                "WHERE alunosDisciplinas.codUsuario = " + codUsuario;

        // Execução da consulta SQL e obtenção do conjunto de resultados
        ResultSet resultSet = statement.executeQuery(sql);

        // Iteração pelos resultados e exibição das informações
        while (resultSet.next()) {
            System.out.println("Código da disciplina: " + resultSet.getInt("codDisciplina") +
                    " - Nome da disciplina: " + resultSet.getString("nome"));
        }
    }
}
