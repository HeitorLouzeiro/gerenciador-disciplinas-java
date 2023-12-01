package com.project.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.DataBase.DataBase;

public class CoordenadorDAO {
    private Connection connection;

    public CoordenadorDAO() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }


    public void mostrarProfessor() throws SQLException {
        Statement statement = connection.createStatement();
        
        String sql = "SELECT * FROM usuario WHERE tipoUsuario = 'Professor'";
    
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getString("codUsuario") + " " + resultSet.getString("nome") + " Usuario:" + resultSet.getString("tipoUsuario"));

        }
        statement.close();
    }

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
