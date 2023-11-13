package com.project.Dao;
   
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.DataBase.DataBase;
import com.project.Classes.Aluno;
/**
 * Classe que representa um DAO (Data Access Object) para operações relacionadas aos alunos no sistema.
 * Estende a funcionalidade da classe IFPIDAO.
 *
 * Esta classe fornece métodos para recuperar, inserir, atualizar e deletar informações sobre alunos no banco de dados.
 * Ela utiliza a classe DataBase para obter uma conexão com o banco de dados.
 *
 * Exemplo de uso:
 * <pre>
 * {@code
 * SecretarioDAO dao = new SecretarioDAO();
 * dao.getAlunos();
 * }
 * </pre>
 * 
 * @author @HeitorLouzeiro
 */
public class SecretarioDAO {
    private Connection connection;

    /**
     * Construtor da classe SecretarioDAO. Obtém uma conexão com o banco de dados utilizando a classe DataBase.
     *
     * @throws IOException Se ocorrer um erro de leitura durante a obtenção da conexão com o banco de dados.
     */

    public SecretarioDAO() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }

    /**
     * Recupera informações sobre os alunos do banco de dados e imprime na saída padrão.
     *
     * @throws SQLException Se ocorrer um erro durante a execução da consulta SQL.
     */

    public void getAlunos() throws SQLException {
        Statement statement = connection.createStatement();
        
        String sql = "SELECT * FROM usuario WHERE tipoUsuario = 'Aluno'";
    
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getString("codUsuario") + " " + resultSet.getString("nome") + " Usuario:" + resultSet.getString("tipoUsuario"));

        }
        statement.close();
    }
    /**
     * Seleciona um aluno do banco de dados com base no código do usuário.
     *
     * @param codUsuario O código do usuário do aluno a ser selecionado.
     * @throws IOException Se ocorrer um erro de leitura durante a obtenção da conexão com o banco de dados.
     * @throws SQLException Se ocorrer um erro durante a execução da consulta SQL.
     */

    public void SelectAlunoGetByCod(int codUsuario ) throws IOException, SQLException {
        System.out.println("Selecionando Aluno...");

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Usuario WHERE codUsuario = ?");

        statement.setInt(1, codUsuario);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println("Nome: " + resultSet.getString("nome") + " Usuario:" + resultSet.getString("tipoUsuario"));
        }


        statement.close();
    }
    /**
     * Insere um novo aluno no banco de dados.
     *
     * @param aluno O objeto Aluno a ser inserido no banco de dados.
     * @throws IOException Se ocorrer um erro de leitura durante a obtenção da conexão com o banco de dados.
     * @throws SQLException Se ocorrer um erro durante a execução da consulta SQL.
     */

    public void InsertAluno(Aluno aluno) throws IOException, SQLException {
        System.out.println("Inserindo Aluno...");

        PreparedStatement statement = connection.prepareStatement("INSERT INTO Usuario (codUsuario, nome, cpf, dataNascimento, dataEntrada, senha, tipoUsuario) VALUES (?, ?, ?, ?, ?, ?, ?)");

        statement.setInt(1, aluno.getCodUsuario());
        statement.setString(2, aluno.getNome());
        statement.setString(3, aluno.getCpf());
        statement.setString(4, aluno.getDataNascimento());
        statement.setString(5, aluno.getDataEntrada());
        statement.setString(6, aluno.getSenha());
        statement.setString(7, "Aluno");

        statement.executeUpdate();

        statement.close();
    }
    /**
     * Atualiza as informações de um aluno no banco de dados.
     *
     * @param aluno O objeto Aluno com as informações atualizadas.
     * @throws IOException Se ocorrer um erro de leitura durante a obtenção da conexão com o banco de dados.
     * @throws SQLException Se ocorrer um erro durante a execução da consulta SQL.
     */

    public void UpdateAluno(Aluno aluno) throws IOException, SQLException {
        System.out.println("Atualizando Aluno...");

        PreparedStatement statement = connection.prepareStatement("UPDATE Usuario SET nome = ?, cpf = ?, dataNascimento = ?, dataEntrada = ?, senha = ? WHERE codUsuario = ?");

        statement.setString(1, aluno.getNome());
        statement.setString(2, aluno.getCpf());
        statement.setString(3, aluno.getDataNascimento());
        statement.setString(4, aluno.getDataEntrada());
        statement.setString(5, aluno.getSenha());
        statement.setInt(6, aluno.getCodUsuario());

        statement.executeUpdate();

        System.out.println("Aluno Atualizado!");

        statement.close();
    }
    /**
     * Deleta um aluno do banco de dados com base no código do usuário.
     *
     * @param codUsuario O código do usuário do aluno a ser deletado.
     * @throws IOException Se ocorrer um erro de leitura durante a obtenção da conexão com o banco de dados.
     * @throws SQLException Se ocorrer um erro durante a execução da consulta SQL.
     */
    
    public void DeleteAluno(int codUsuario ) throws IOException, SQLException {
        System.out.println("Deletando Aluno...");

        PreparedStatement statement = connection.prepareStatement("DELETE FROM Usuario WHERE codUsuario = ?");

        statement.setInt(1, codUsuario);

        statement.executeUpdate();

        statement.close();

        System.out.println("Aluno Deletado!");
    }


}

