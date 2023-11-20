package com.project.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.DataBase.DataBase;

public class LoginDAO {
    private Connection connection;

    private String tipoUsuario;
    private int codUsuario;

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public LoginDAO() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }

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
