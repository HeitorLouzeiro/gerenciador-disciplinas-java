package com.project.DataBase;

import java.io.IOException; // É usada para tratar exceções de entrada e saída.
import java.sql.Connection; // É usada para estabelecer uma conexão com o banco de dados.
import java.sql.DriverManager; // É usada para carregar o driver do banco de dados.
import java.sql.SQLException; // É usada para tratar exceções de SQL.
import java.sql.Statement; // É usada para executar uma instrução SQL.

/**
 * Classe responsável por gerenciar a conexão com o banco de dados SQLite.
 * Implementa o padrão Singleton para garantir uma única instância da conexão durante a execução do programa.
 *
 * Exemplo de uso:
 * <pre>
 * {@code
 * DataBase database = DataBase.getInstance();
 * Connection connection = database.getConnection();
 * // ... realizar operações no banco de dados ...
 * database.closeConnection();
 * }
 * </pre>
 *
 * @see FileUltils
 * @see Connection
 * @see DriverManager
 * @see SQLException
 * @see Statement
 * @author Heitor Louzeiro
 */
public class DataBase {
    // Variável para armazenar a conexão com o banco de dados.
    private Connection connection = null;

    // Variável para armazenar a instância do banco de dados.
    private static DataBase INSTANCE = null;

    /**
     * Construtor privado da classe DataBase. Inicia a conexão com o banco de dados e executa uma instrução SQL.
     *
     * @throws IOException Se ocorrer um erro de leitura durante o carregamento do arquivo SQL.
     */
    private DataBase() throws IOException {
        try {
            // Estabelece uma conexão com o banco de dados e armazena em uma variavel.
            connection = DriverManager.getConnection("jdbc:sqlite:core/sample.db");

            // Cria uma instrução SQL que será executada.
            Statement statement = connection.createStatement();
            
            statement.setQueryTimeout(30); // Tempo limite de 30 segundos.

            // Ler o arquivo de texto e armazena em uma variável.
            String sql = FileUltils.loadTextFile("core/src/main/java/com/project/Resource/Description.sql");

            // Executa a instrução SQL.
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            // Em caso de erro, imprime o erro no console.
            System.err.println("Error connecting to the database");
            e.printStackTrace();
        }
    }

    
    /**
     * Obtém a conexão com o banco de dados.
     *
     * @return A conexão com o banco de dados.
     */
    public Connection getConnection() {
        // Permite que outras classes acessem a conexão com o banco de dados.
        return this.connection;
    }

    /**
     * Fecha a conexão com o banco de dados.
     */

    // Permite que outras classes fechem a conexão com o banco de dados.
    public void closeConnection() {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            System.err.println("Error closing database connection");
            e.printStackTrace();
        }
    }
    /**
     * Obtém a instância da classe DataBase. Implementa o padrão Singleton.
     *
     * Esse padrão garante que apenas uma instância da classe DataBase seja criada durante a execução do programa.
     * 
     * @return A instância única da classe DataBase.
     * @throws IOException Se ocorrer um erro de leitura durante o carregamento do arquivo SQL.
     */
    // Permite que outras classes acessem a instância do banco de dados.
    public static DataBase getInstance() throws IOException {
        // Se a instância for nula, cria uma nova instância.
        if (INSTANCE == null) {
            INSTANCE = new DataBase();
        }
        // Retorna a instância.
        return INSTANCE;
    }
}