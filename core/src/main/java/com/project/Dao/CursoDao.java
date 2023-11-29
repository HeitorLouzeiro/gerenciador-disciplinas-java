package com.project.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.DataBase.DataBase;

public class CursoDAO {
    private Connection connection;

    public CursoDAO() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }

    public void mostrarCursos() throws IOException, SQLException {

        Statement statement = connection.createStatement();
        String sql = "SELECT codCurso, nome FROM cursos";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("Código: " + resultSet.getString("codCurso") +
                    " Curso : " + resultSet.getString("nome"));
        }
        statement.close();

    }
}
