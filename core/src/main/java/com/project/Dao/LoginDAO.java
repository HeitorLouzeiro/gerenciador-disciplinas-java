package com.project.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.DataBase.DataBase;

/**
 * A classe LoginDAO fornece métodos para autenticar usuários no sistema por meio de login.
 * @autor @HeitorLouzeiro
 */
public class LoginDAO {
    private Connection connection;

    private String tipoUsuario;
    private int codUsuario;

    /**
     * Obtém o tipo de usuário associado ao login bem-sucedido.
     *
     * @return O tipo de usuário.
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * Define o tipo de usuário associado ao login bem-sucedido.
     *
     * @param tipoUsuario O tipo de usuário a ser definido.
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * Define o código de usuário associado ao login bem-sucedido.
     *
     * @param codUsuario O código de usuário a ser definido.
     */
    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    /**
     * Obtém o código de usuário associado ao login bem-sucedido.
     *
     * @return O código de usuário.
     */
    public int getCodUsuario() {
        return codUsuario;
    }

    /**
     * Construtor da classe LoginDAO.
     * Inicializa a conexão com o banco de dados através da instância da classe DataBase.
     *
     * @throws IOException Se houver um erro de E/S ao obter a conexão com o banco de dados.
     */
    public LoginDAO() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }

    /**
     * Verifica se as credenciais de login fornecidas correspondem a um usuário válido no sistema.
     *
     * @param cpf    O CPF do usuário.
     * @param senha  A senha do usuário.
     * @return true se o login for bem-sucedido, false caso contrário.
     */
    public boolean verificaLogin(String cpf, String senha) {
        String query = "SELECT * FROM usuario WHERE cpf = ? AND senha = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, cpf);
            preparedStatement.setString(2, senha);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                setTipoUsuario(resultSet.getString("tipoUsuario"));
                setCodUsuario(resultSet.getInt("codUsuario"));

                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Lida com exceções de SQL (por exemplo, problemas de conexão)
            return false;
        }
    }
}
