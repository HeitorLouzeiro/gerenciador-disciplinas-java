package com.project.Menu.MenuItens;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.project.Menu.MenuItens.Listar.Space;

public class ExibirMenu {
    private static Scanner scanner = new Scanner(System.in);

    // Método que exibe o menu de acordo com o tipo de usuário e as opções do menu
    public static void exibirMenu(String tipoUsuario, String[] opcoes, int codUsuario) throws IOException, SQLException {
        // Cria uma variável para armazenar a opção escolhida pelo usuário
        // Inicia com -1 para que entre no loop da primeira vez
        int opcao = -1;

        // Loop que exibe o menu enquanto o usuário não digitar 0 (sair)
        do {
            // Exibe o menu
            System.out.println("Opções do menu do " + tipoUsuario + ":");

            // Exibe as opções do menu que repetem em todos os tipos de usuário
            System.out.println("1. Listar Disciplinas.");
            System.out.println("2. Listar Docentes.");

            // Exibe as opções do menu específicas para cada tipo de usuário
            // De acordo com o array de Strings passado como parâmetro
            // Como o array começa com índice 0, soma-se 3 ao índice para exibir a opção
            // correta
            for (int i = 0; i < opcoes.length; i++) {
                System.out.println((i + 3) + ". " + opcoes[i]);
            }
            // Exibe as opções do menu que repetem em todos os tipos de usuário
            System.out.println("9. Limpar console.");
            System.out.println("0. Sair do menu");

            System.out.print("Escolha uma opção: ");

            // Lê a opção digitada pelo usuário
            // Se o usuário digitar um valor que não é um número inteiro,
            // o programa lança uma exceção
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro válido.");
                scanner.next(); // Limpa o buffer do scanner
                continue; // Volta ao início do loop sem executar o código abaixo
            }

            System.out.println(Space.space);

            // Chama o método executarAcao, passando a opção escolhida pelo usuário e o tipo
            // de usuário
            ExecutarAcao.executarAcao(opcao, tipoUsuario, codUsuario);

            // Enquanto a opção digitada pelo usuário for diferente de 0 (sair)
            // o programa exibe o menu novamente
        } while (opcao != 0);
    }
}
