package com.project.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException; // Importa a classe SQLException para tratamento de exceções

import com.project.Classes.Disciplinas; // Importa a classe Disciplinas
import com.project.DataBase.DataBase;

public class DisciplinasDAO {
    private Connection connection;

    public DisciplinasDAO() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }

    public void cadastrarDisciplina (Disciplinas disciplina) throws SQLException {
        System.out.println("Inserindo Disciplina...");

        PreparedStatement statement = connection.prepareStatement("INSERT INTO disciplinas (nome, codCurso, codUsuario) VALUES (?, ?, ?)");

        statement.setString(1, disciplina.getNomeDisciplina());
        statement.setInt(2, disciplina.getCodDisciplina());
        statement.setInt(3, disciplina.getCodUsuario());
    

        statement.executeUpdate();

        statement.close();
    }


    public void editarDisciplinaById (int codDisciplina) throws SQLException {

    }

    public static void InsertDisciplina(Disciplinas disciplinas) {
    }
}