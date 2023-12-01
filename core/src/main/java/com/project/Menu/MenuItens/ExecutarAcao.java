package com.project.Menu.MenuItens;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

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
                if ("Secretario".equals(tipoUsuario)) {
                    listar.listarAlunos();
                } else if ("Professor".equals(tipoUsuario) || "Coordenador".equals(tipoUsuario)) {
                    listar.mostrarDisciplinasProfessor(codUsuario);
                    
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Digite o código da disciplina: ");
                    int codDisciplina = scanner.nextInt();

                    cadastrar.cadastrarFrequencia(codDisciplina);
                    /* listar.listarTurmasProfessor(codUsuario); */
                } else if ("Aluno".equals(tipoUsuario)) {
                    listar.quantidadeFaltas(codUsuario);
                }
                break;
            case 4:
                if ("Secretario".equals(tipoUsuario)) {
                    cadastrar.cadastrarAluno();
                } else if ("Professor".equals(tipoUsuario) || "Coordenador".equals(tipoUsuario)) {
                    listar.mostrarDisciplinasProfessor(codUsuario);

                    Scanner scanner = new Scanner(System.in);
                    
                    System.out.print("Digite o código da disciplina: ");
                    int codDisciplina = scanner.nextInt();

                    cadastrar.cadastrarNotas(codDisciplina);
                    
                } else if ("Aluno".equals(tipoUsuario)) {
                    listar.mostrarNotasAluno(codUsuario);
                }
                break;
            case 5:
                if ("Coordenador".equals(tipoUsuario)) {
                     listar.listarAlunos();
                } else if ("Aluno".equals(tipoUsuario)) {
                    System.out.println("Mostrando suas disciplinas...");
                    listar.disciplinasAluno(codUsuario);
                } else if ("Professor".equals(tipoUsuario)) {                    
                    Scanner scanner = new Scanner(System.in);
                    listar.mostrarDisciplinasProfessor(codUsuario);
                    
                    System.out.print("Digite o código da disciplina: ");
                    int codDisciplina = scanner.nextInt();

                    
/* 
                    System.out.printf("Selecione o tipo de média: \n1 - Média de todas as notas \n" + 
                    "2 - Média das duas maiores notas \n");

                    System.out.print("Digite o tipo de média: ");
                    int tipoMedia = scanner.nextInt();

 */
                }else if ("Secretario".equals(tipoUsuario)) {
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
