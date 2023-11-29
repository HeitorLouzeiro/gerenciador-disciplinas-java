package com.project.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.DataBase.DataBase;

/**
 * A classe CursoDAO fornece métodos para acessar e manipular dados relacionados a cursos no banco de dados.
 * @author @igorsilvar
 */
public class CursoDAO {

    /**
     * A conexão com o banco de dados.
     */
    private Connection connection;

    /**
     * Construtor da classe CursoDAO.
     * Inicializa a conexão com o banco de dados através da instância da classe DataBase.
     *
     * @throws IOException Se houver um erro de E/S ao obter a conexão com o banco de dados.
     */
    public CursoDAO() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }

    /**
     * Recupera e exibe informações sobre todos os cursos do banco de dados.
     *
     * @throws IOException Se houver um erro de E/S durante a execução da consulta.
     * @throws SQLException Se ocorrer um erro SQL durante a execução da consulta.
     */
    public void mostrarCursos() throws IOException, SQLException {
        // Criação do objeto Statement para executar consultas SQL
        Statement statement = connection.createStatement();

        // Definição da consulta SQL para recuperar códigos e nomes dos cursos
        String sql = "SELECT codCurso, nome FROM cursos";

        // Execução da consulta SQL e obtenção do conjunto de resultados
        ResultSet resultSet = statement.executeQuery(sql);

        // Iteração pelos resultados e exibição das informações
        while (resultSet.next()) {
            System.out.println("Código: " + resultSet.getString("codCurso") +
                    " Curso : " + resultSet.getString("nome"));
        }

        // Fechamento do Statement para liberar recursos
        statement.close();
    }
}
