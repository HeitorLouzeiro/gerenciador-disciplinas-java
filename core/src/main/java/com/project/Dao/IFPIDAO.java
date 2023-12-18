package com.project.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.project.Classes.Data;
import com.project.DataBase.DataBase;

/**
 * Classe que representa um DAO (Data Access Object) para operações relacionadas aos usuários no sistema.
 *
 * Esta classe fornece métodos para recuperar informações sobre usuários do banco de dados.
 * Ela utiliza a classe DataBase para obter uma conexão com o banco de dados.
 * 
 * @author Heitor Louzeiro
 */
public class IFPIDAO {
    /**
     * Conexão com o banco de dados.
     */
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
        
        String sql = "SELECT * FROM usuario ORDER BY tipoUsuario ASC";
    
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("nome") + " Usuario:" + resultSet.getString("tipoUsuario"));
        }
        
        statement.close();
    }

    /**
     * Lista docentes, incluindo informações sobre titulação, disciplina e tempo de trabalho.
     *
     * @throws SQLException Se ocorrer um erro durante a execução da consulta SQL.
     */
    public void listarDocentes() throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "SELECT usuario.*, disciplinas.nome AS disciplina_nome " +
             "FROM usuario " +
             "INNER JOIN disciplinas ON usuario.codUsuario = disciplinas.codUsuario ";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String dataEntradaStr = resultSet.getString("dataEntrada");
    
            LocalDate dataEntrada = LocalDate.parse(dataEntradaStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            
            Data data = new Data();
    
            long tempoTotal = data.calcularTempoTotal(dataEntrada);
            
            System.out.println(resultSet.getString("nome") + 
            "\t|Titulação:" + resultSet.getString("titulacao") + 
            "\t|Disciplina: " + resultSet.getString("disciplina_nome") + 
            "\t|Trabalha: " + tempoTotal + " anos"
            );
        }
        
        statement.close();
    }

    /**
     * Lista disciplinas oferecidas.
     *
     * @throws SQLException Se ocorrer um erro durante a execução da consulta SQL.
     */
    public void disciplinasOfertadas() throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM disciplinas";
        
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("Codigo do curso: " + resultSet.getInt("codDisciplina")  +  
            (" Disciplina: ")+ resultSet.getString("nome")
            );
        }
        
        statement.close();
    }
}
