package com.project;

import java.io.IOException;
import java.util.Scanner;

import com.project.Dao.LoginDAO;
import com.project.Menu.Login;
import com.project.Menu.Menu;

/**
 * Classe principal que imprime "Hello World!".
 */
public class App {

    /**
     * Método principal que inicia a aplicação.
     *
     * @param args Argumentos da linha de comando. Não são usados neste exemplo.
     */
    public static void main(String[] args) throws IOException{
        Login login = new Login();
        LoginDAO loginDAO = new LoginDAO();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu CPF: ");
        login.setCPF(scanner.next());
        System.out.println("------------------------------------------");
        
        System.out.println("Digite sua senha: ");
        login.setSenha(scanner.next());
        
        System.out.println("------------------------------------------");
        
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
