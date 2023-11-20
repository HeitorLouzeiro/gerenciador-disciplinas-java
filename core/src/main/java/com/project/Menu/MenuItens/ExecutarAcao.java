package com.project.Menu.MenuItens;

import java.io.IOException;
import java.sql.SQLException;

import com.project.Menu.ClearConsole;

public class ExecutarAcao {
    // Método que executa a ação de acordo com a opção escolhida pelo usuário e pelo
    // tipo de usuário
    public static void executarAcao(int opcao, String tipoUsuario, int codUsuario) throws IOException, SQLException {
        Listar listar = new Listar();
        Cadastrar cadastrar = new Cadastrar();

        // Executa a ação de acordo com a opção escolhida pelo usuário e pelo tipo de
        // usuário
        switch (opcao) {
            case 1:
                listar.disciplinasOfertadas();
                break;
            case 2:
                listar.listarDocentes();
                break;
            case 3:
                // O método equals compara o valor de duas Strings
                // Se o valor das Strings for igual, o método retorna true
                // Se o valor das Strings for diferente, o método retorna false
                if ("Secretario".equals(tipoUsuario) || "Coordenador".equals(tipoUsuario)) {
                    listar.listarAlunos();
                } else if ("Professor".equals(tipoUsuario)) {
                    System.out.println("Cadastrar Frequência...");
                } else if ("Aluno".equals(tipoUsuario)) {
                    System.out.println("Mostrar lista de frequência...");
                }
                break;
            case 4:
                if ("Secretario".equals(tipoUsuario)) {
                    cadastrar.cadastrarAluno();
                } else if ("Coordenador".equals(tipoUsuario)) {
                    System.out.println("Cadastrar Frequência...");
                } else if ("Professor".equals(tipoUsuario)) {
                    System.out.println("Cadastrar Notas...");
                } else if ("Aluno".equals(tipoUsuario)) {
                    System.out.println("Mostrar minhas notas...");
                }
                break;
            case 5:
                if ("Coordenador".equals(tipoUsuario)) {
                    System.out.println("Cadastrar Notas...");
                } else if ("Aluno".equals(tipoUsuario)) {
                    System.out.println("Mostrar suas disciplinas...");
                    listar.disciplinasAluno(codUsuario);
                } else if ("Professor".equals(tipoUsuario) || "Secretario".equals(tipoUsuario)) {
                    System.out.println("Opção inválida.");
                }
                break;
            case 6:
                if ("Coordenador".equals(tipoUsuario)) {
                    System.out.println("Criar Disciplina...");
                } else {
                    System.out.println("Opção inválida.");
                }
                break;
            case 7:
                if ("Coordenador".equals(tipoUsuario)) {
                    System.out.println("Cadastrar aluno em uma disciplina...");
                } else {
                    System.out.println("Opção inválida.");
                }
                break;
            case 9:
                ClearConsole.clearConsole();
                break;
            case 0:
                System.out.println("Saindo do menu...");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }
}
