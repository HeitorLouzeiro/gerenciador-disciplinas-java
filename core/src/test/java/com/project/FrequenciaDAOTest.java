package com.project;

import java.io.IOException;

import com.project.Classes.Frequencia;
import com.project.Dao.FrequenciaDAO;

public class FrequenciaDAOTest {
    public static void main(String[] args) throws IOException {
        try {

            FrequenciaDAO frequenciaDAO = new FrequenciaDAO();

            System.out.println("Cadastrando frequencia do aluno");

            // Cria um objeto Frequencia e popula com os valores do BD
            Frequencia frequencia = new Frequencia();

            // Popula o objeto Frequencia com os valores do BD
            frequencia.setCodDisciplina(1);
            frequencia.setCodUsuario(7);
            frequencia.setPresenca(0);
            frequencia.setData("22-11-2022");

            frequenciaDAO.inserirFrequenciaAluno(frequencia);    
            
            Frequencia frequencia2 = new Frequencia();
 

            frequencia2.setCodDisciplina(6);
            frequencia2.setCodUsuario(7);
            frequencia2.setPresenca(0);
            frequencia2.setData("23-11-2022");

            frequenciaDAO.inserirFrequenciaAluno(frequencia2);



            System.out.println("----------------------------------------");

            System.out.println("Quantidade de faltas do aluno:");
            frequenciaDAO.quantidadeFaltas(7);

            System.out.println("----------------------------------------");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
