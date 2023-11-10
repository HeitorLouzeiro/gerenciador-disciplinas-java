package com.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.DataBase.DataBase;

/**
 * Classe de teste para leitura de arquivo e consulta ao banco de dados.
 * Este código é apenas para fins de teste e não faz parte do projeto principal.
 * Ele lê um arquivo de texto e executa uma instrução SQL, imprimindo os resultados no console.
 * 
 * @author Heitor Louzeiro
 */
public class LerArquivo {
    
    /**
     * Método principal para execução do teste.
     * 
     * @param args Argumentos de linha de comando (não utilizados neste exemplo).
     * @throws IOException Se ocorrer um erro de leitura durante a execução do teste.
     */
    public static void main(String[] args) throws IOException {
        Connection connection = null;
        
        try {
            // Obtém uma conexão com o banco de dados
            connection = DataBase.getInstance().getConnection();
            Statement statement = connection.createStatement(); // Cria uma instrução SQL

            // Executa uma consulta SQL
            ResultSet rs = statement.executeQuery("SELECT * FROM usuario");

            // Imprime os resultados
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("nome"));
                // Adicione mais campos conforme necessário
            }
        } catch (SQLException e) {
            // Mensagem de erro caso não consiga conectar ao banco de dados.
            System.err.println("Error executing SQL query: " + e.getMessage());
        } finally {
            // Fecha a conexão com o banco de dados, mesmo se ocorrer uma exceção.
            DataBase.getInstance().closeConnection();
        }
    }
}
