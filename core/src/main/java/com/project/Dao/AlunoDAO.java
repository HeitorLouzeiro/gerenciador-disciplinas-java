package com.project.Dao;

import com.project.DataBase.DataBase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlunoDAO {
    private Connection connection;

    public AlunoDAO() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }

    public void mostrarDisciplinasAluno(int codUsuario) throws SQLException {
        Statement statement = connection.createStatement();
/* 
        String sql = "SELECT * FROM alunosDisciplinas " +
             "WHERE codUsuario = " + codUsuario; */
        
        String sql = "SELECT * FROM alunosDisciplinas INNER JOIN disciplinas ON alunosDisciplinas.codDisciplina = disciplinas.codDisciplina " +
             "WHERE alunosDisciplinas.codUsuario = " + codUsuario;

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("Código da disciplina: " + resultSet.getInt("codDisciplina") + " - Nome da disciplina: " + resultSet.getString("nome"));
        }
    }
}
