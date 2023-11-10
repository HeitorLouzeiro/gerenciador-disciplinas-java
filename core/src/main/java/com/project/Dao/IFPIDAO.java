package com.project.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.project.DataBase.DataBase;

/**
 * Classe que representa um DAO (Data Access Object) para operações relacionadas aos usuários no sistema.
 *
 * Esta classe fornece métodos para recuperar informações sobre usuários do banco de dados.
 * Ela utiliza a classe DataBase para obter uma conexão com o banco de dados.
 *
 * Exemplo de uso:
 * <pre>
 * {@code
 * IFPIDAO dao = new IFPIDAO();
 * dao.getUsuarios();
 * }
 * </pre>
 * 
 * @author @HeitorLouzeiro
 */
public class IFPIDAO {
    private Connection connection;

    /**
     * Construtor da classe IFPIDAO. Obtém uma conexão com o banco de dados utilizando a classe DataBase.
     *
     * @throws IOException Se ocorrer um erro de leitura durante a obtenção da conexão com o banco de dados.
     */
    public IFPIDAO() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }
    
    /**
     * Recupera informações sobre os usuários do banco de dados e imprime na saída padrão.
     *
     * @throws SQLException Se ocorrer um erro durante a execução da consulta SQL.
     */
    public void getUsuarios() throws SQLException {
        Statement statement = connection.createStatement();
        
        String sql = "SELECT * FROM usuario";
    
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("nome") + " Usuario:" + resultSet.getString("tipoUsuario"));
        }
    }
}
