package com.project.DataBase;

import java.io.BufferedReader; // É usada para ler o texto linha por linha.
import java.io.FileReader; // É usada para abrir o arquivo.
import java.io.IOException; // É usada para tratar exceções de entrada e saída.

public class FileUltils {
    /* Método para carregar um arquivo de texto. */
    public static String loadTextFile(final String filename) throws IOException{
        // Variável para medir o tempo de execução.
        long time = System.currentTimeMillis();
        
        // Variável para ler o arquivo.
        BufferedReader br = new BufferedReader(new FileReader(filename));
        
        // Variável para armazenar o texto.
        StringBuilder sb = new StringBuilder();

        // Variável para armazenar a linha.
        String line;

        // Enquanto a linha não for nula, adicione a linha ao texto.
        while((line = br.readLine()) != null){
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