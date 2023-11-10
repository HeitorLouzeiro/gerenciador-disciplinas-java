package com.project.DataBase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe utilitária para operações relacionadas a arquivos.
 *
 * Fornece métodos para realizar operações com arquivos, como carregar o conteúdo de um arquivo de texto.
 *
 * Exemplo de uso:
 * <pre>
 * {@code
 * String content = FileUltils.loadTextFile("example.txt");
 * System.out.println(content);
 * }
 * </pre>
 *
 * @see BufferedReader
 * @see FileReader
 * @see IOException
 * @author @HeitorLouzeiro
 */

public class FileUltils {
    
    /**
     * Construtor padrão da classe FileUltils.
     */
    public FileUltils() {
    }

    /**
     * Carrega o conteúdo de um arquivo de texto.
     *
     * @param filename O nome do arquivo a ser lido.
     * @return O conteúdo do arquivo como uma String.
     * @throws IOException Se ocorrer um erro de leitura durante a operação com o
     *                     arquivo.
     * 
     */
    public static String loadTextFile(final String filename) throws IOException {
        // Variável para medir o tempo de execução.
        long time = System.currentTimeMillis();

        // Variável para ler o arquivo.
        BufferedReader br = new BufferedReader(new FileReader(filename));

        // Variável para armazenar o texto.
        StringBuilder sb = new StringBuilder();

        // Variável para armazenar a linha.
        String line;

        // Enquanto a linha não for nula, adicione a linha ao texto.
        while ((line = br.readLine()) != null) {
            // Adiciona a linha ao texto.
            sb.append(line);
            sb.append("\n");
        }
        // Fecha o arquivo.
        br.close();

        // Calcula o tempo de execução.
        time = System.currentTimeMillis() - time;

        // Imprime o tempo de execução.
        System.out.println("Read file: " + filename + " in " + time + "ms");

        // Retorna o texto.
        return sb.toString();
    }

}