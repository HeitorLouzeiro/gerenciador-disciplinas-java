package com.project.Menu;

import java.io.IOException;
import java.sql.SQLException;

import com.project.Menu.MenuItens.ExibirMenu;

public class Menu {
    static class Space {
        static String space = "-----------------------------------------------------";
    }

    // Cria um objeto Scanner para obter entrada da janela de comando
    // É static para que possa ser acessado por todos os métodos dessa classe

    // Método principal que inicia o programa
    public static void redirecionadorPagina(String tipoUsuario, int codUsuario) {
        switch (tipoUsuario) {
            case "Secretario":
                System.out.println("Bem-vindo, Secretario");
                // tem um try catch aqui para tratar as exceções de SQL e IO
                try {
                    // chama o método exibirMenuSecretario
                    exibirMenuSecretario(codUsuario);
                } catch (SQLException | IOException e) {
                    e.printStackTrace(); // Trate as exceções de acordo com a lógica da sua aplicação
                }
                break;
            case "Coordenador":
                System.out.println("Bem-vindo, Coordenador");
                try {
                    // chama o método exibirMenuCoordenador
                    exibirMenuCoordenador(codUsuario);
                } catch (SQLException | IOException e) {
                    e.printStackTrace(); // Trate as exceções de acordo com a lógica da sua aplicação
                }
                break;
            case "Professor":
                System.out.println("Bem-vindo, Professor");
                try {
                    // chama o método exibirMenuProfessor
                    exibirMenuProfessor(codUsuario);
                } catch (SQLException | IOException e) {
                    e.printStackTrace(); // Trate as exceções de acordo com a lógica da sua aplicação
                }
                break;
            case "Aluno":
                System.out.println("Bem-vindo, Aluno");
                try {
                    // chama o método exibirMenuAluno
                    exibirMenuAluno(codUsuario);
                } catch (SQLException | IOException e) {
                    e.printStackTrace(); // Trate as exceções de acordo com a lógica da sua aplicação
                }
                break;
            default:
                System.out.println("Tipo de usuário inválido.");
        }
    }

    // Método que exibe o menu do secretário
    private static void exibirMenuProfessor(int codUsuario) throws SQLException, IOException {
        // Cria um array de Strings com as opções do menu
        String[] opcoes = { "Cadastrar Frequencia.", "Cadastrar Notas." };

        // Chama o método exibirMenu, passando o tipo de usuário e as opções do menu
        ExibirMenu.exibirMenu("Professor", opcoes, codUsuario);
    }

    // Método que exibe o menu do coordenador
    private static void exibirMenuCoordenador(int codUsuario) throws SQLException, IOException {
        // Cria um array de Strings com as opções do menu
        String[] opcoes = { "Listar todos os alunos.", "Cadastrar Frequencia.", "Cadastrar Notas.",
                "Cadastrar Disciplina.", "Cadastrar Aluno na Disciplina." };

        // Chama o método exibirMenu, passando o tipo de usuário e as opções do menu
        ExibirMenu.exibirMenu("Coordenador", opcoes, codUsuario);
    }

    private static void exibirMenuSecretario(int codUsuario) throws IOException, SQLException {
        // Cria um array de Strings com as opções do menu
        String[] opcoes = { "Listar todos os alunos.", "Cadastrar Aluno no Sistema." };

        // Chama o método exibirMenu, passando o tipo de usuário e as opções do menu
        ExibirMenu.exibirMenu("Secretario", opcoes, codUsuario);
    }

    private static void exibirMenuAluno(int codUsuario) throws SQLException, IOException {
        // Cria um array de Strings com as opções do menu
        String[] opcoes = { "Mostrar lista de Frequencia.", "Listar Notas.", "Listar que estou cadastrado Disciplinas." };

        // Chama o método exibirMenu, passando o tipo de usuário e as opções do menu
        ExibirMenu.exibirMenu("Aluno", opcoes, codUsuario);
    }
}
