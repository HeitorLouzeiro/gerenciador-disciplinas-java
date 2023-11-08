/* 
  Esses arquivos são apenas para testes, não fazem parte do projeto.
  Esse arquivo lê o arquivo de texto e imprime no console.
  Depois ele executa uma instrução SQL e imprime no console.
 */

package com.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.project.DataBase.DataBase;

public class LerArquivo {
    public static void main(String[] args) throws IOException{
        
        Connection connection = null;
        try {
            connection = DataBase.getInstance().getConnection();
            Statement statement = connection.createStatement(); // Cria uma instrução SQL

            // Get the results

            ResultSet rs = statement.executeQuery("SELECT * FROM aluno");
            while (rs.next()) {
                // read the result set
                System.out.println("name = " + rs.getString("nome"));
            }
        } catch (SQLException e) {
            // Mensagem de erro caso não consiga conectar ao banco de dados.
            System.err.println(e.getMessage());
        } finally {
            /* 
              Fecha a conexão com o banco de dados.
              finalmente é executado mesmo se houver uma exceção.
            */
            
            DataBase.getInstance().closeConnection();
        }
    }
}
