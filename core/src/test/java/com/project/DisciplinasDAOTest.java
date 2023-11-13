package com.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.project.DataBase.DataBase;

public class DisciplinasDAOTest {

    public static void main(String[] args) throws IOException {

        Connection connection = null;

        try {
            // Obtém uma conexão com o banco de dados
            connection = DataBase.getInstance().getConnection();

            // Crie um metodo de cadastrar disciplina apartir daqui.




            
           // Crie um metodo de autualizar disciplina apartir daqui.

           

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
