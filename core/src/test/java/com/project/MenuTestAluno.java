package com.project;
import java.io.IOException;

import com.project.Dao.LoginDAO;
import com.project.Menu.Login;
import com.project.Menu.Menu;

public class MenuTestAluno {
    public static void main(String[] args) throws IOException {
        Login login = new Login();
        LoginDAO loginDAO = new LoginDAO();

        login.setCPF("89738810715");
        login.setSenha("nO9K1@Bq_7");

        boolean autenticate = loginDAO.verificaLogin(login.getCPF(), login.getSenha());

        if (autenticate) {
            String tipoUsuario = loginDAO.getTipoUsuario();
            int codUsuario = loginDAO.getCodUsuario();
            Menu.redirecionadorPagina(tipoUsuario, codUsuario);
        } else {
            System.out.println("CPF ou senha incorretos.");
            
        }
    }
    
}
