package com.project.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.DataBase.DataBase;

public class ProfessorDAO {
    private Connection connection;

    public ProfessorDAO() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }

    public void mostrarTodosProfessores() throws SQLException{
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM usuario WHERE tipoUsuario = 'Professor'";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("Código do professor: " + resultSet.getInt("codUsuario") + " - Nome do professor: " + resultSet.getString("nome"));
        }

        statement.close();
    }
    
    public void mostrarDisciplinasProfessor(int codUsuario) throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM disciplinas " +
             "WHERE codUsuario = " + codUsuario;

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("Código da disciplina: " + resultSet.getInt("codDisciplina") + " - Nome da disciplina: " + resultSet.getString("nome"));
        }

        statement.close();

    }

    public void cadastrarHistoricoAluno(int codUsuario, int codDisciplina, double media) throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO historico (codUsuario, codDisciplina, media) VALUES (?,?,?)";

        statement.executeUpdate(sql);

        statement.close();
    }
}
