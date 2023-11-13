package com.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.project.DataBase.DataBase;

public class CursoDAOTest {
    public static void main(String[] args) throws IOException {

        Connection connection = null;

        try {
            // Obtém uma conexão com o banco de dados
            connection = DataBase.getInstance().getConnection();

            // Mostre todos os cursos cadastrados no banco de dados aqui.
           

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
