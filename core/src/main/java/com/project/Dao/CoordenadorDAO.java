package com.project.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.DataBase.DataBase;

/**
 * A classe CoordenadorDAO fornece métodos para acessar e manipular dados relacionados a coordenadores no banco de dados.
 * @author @HeitorLouzeiro
 */
public class CoordenadorDAO {
    /**
     * Conexão com o banco de dados.
     */
    private Connection connection;

    /**
     * Construtor da classe CoordenadorDAO.
     * Inicializa a conexão com o banco de dados através da instância da classe DataBase.
     *
     * @throws IOException Se houver um erro de E/S ao obter a conexão com o banco de dados.
     */
    public CoordenadorDAO() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }

    /**
     * Mostra a lista de professores no sistema.
     *
     * @throws SQLException Se ocorrer um erro SQL durante a execução da consulta.
     */
    public void mostrarProfessor() throws SQLException {
        Statement statement = connection.createStatement();
        
        String sql = "SELECT * FROM usuario WHERE tipoUsuario = 'Professor'";
    
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getString("codUsuario") + " " + resultSet.getString("nome") + " Usuario:" + resultSet.getString("tipoUsuario"));
        }
        statement.close();
    }

    /**
     * Mostra a lista de professores associados a um curso específico.
     *
     * @param codCurso O código do curso para o qual os professores serão exibidos.
     * @throws SQLException Se ocorrer um erro SQL durante a execução da consulta.
     */
    public void mostrarProfessoresCursos(int codCurso) throws SQLException {
        Statement statement = connection.createStatement();
        
        String sql = "SELECT * FROM usuario WHERE tipoUsuario = 'Professor' AND codCurso = " + codCurso;
    
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("Lista de Professores do Curso:");
        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getString("codUsuario") + " " + resultSet.getString("nome") + " Usuario:" + resultSet.getString("tipoUsuario"));
        }
        statement.close();
    }

    /**
     * Mostra a lista de alunos associados a um curso específico.
     *
     * @param codCurso O código do curso para o qual os alunos serão exibidos.
     * @throws SQLException Se ocorrer um erro SQL durante a execução da consulta.
     */
    public void mostrarAlunosCursos(int codCurso) throws SQLException {
        Statement statement = connection.createStatement();
        
        String sql = "SELECT * FROM usuario WHERE tipoUsuario = 'Aluno' AND codCurso = " + codCurso;
    
        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Lista de Alunos do Curso:");
        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getString("codUsuario") + " " + resultSet.getString("nome") + " Usuario:" + resultSet.getString("tipoUsuario"));
        }
        statement.close();
    }

    /**
     * Mostra a lista de disciplinas associadas a um curso específico.
     *
     * @param codCurso O código do curso para o qual as disciplinas serão exibidas.
     * @throws SQLException Se ocorrer um erro SQL durante a execução da consulta.
     */
    public void mostrarCursosDisciplinas(int codCurso) throws SQLException {
        Statement statement = connection.createStatement();
        
        String sql = "SELECT * FROM disciplinas WHERE codCurso = " + codCurso;

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Lista de Disciplinas do Curso:");

        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getString("codDisciplina") + " " + resultSet.getString("nome"));
        }
        statement.close();
    }
}
