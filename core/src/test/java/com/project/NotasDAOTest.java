package com.project;

import java.io.IOException;
import java.sql.SQLException;

import com.project.Classes.Notas;
import com.project.Dao.NotasDAO;

public class NotasDAOTest {
    public static void main(String[] args) throws IOException, SQLException {
        Notas notas = new Notas();
        notas.setCodDisciplina(1);
        notas.setCodUsuario(4);
        notas.setNota(10);

        NotasDAO notasDAO = new NotasDAO();
        notasDAO.cadastrarNota(notas);
        System.out.println("-----------------------------------");

        notas.setCodNota(7);
        notas.setNota(9);
        notasDAO.atualizarNota(notas);

        System.out.println("-----------------------------------");

        notasDAO.mostrarNotasAluno(10);

        System.out.println("-----------------------------------");

        System.out.println("Calculando média do aluno com 1 nota cadastrada.");
        notas.setCodDisciplina(1);
        notas.setCodUsuario(2);
        notasDAO.calcularMediaAluno(notas);

        System.out.println("-----------------------------------");
        
        System.out.println("Calculando média do aluno com 2 notas cadastradas.");
        notas.setCodDisciplina(6);
        notas.setCodUsuario(3);
        notasDAO.calcularMediaAluno(notas);
        
        System.out.println("-----------------------------------");        

        System.out.println("Calculando média do aluno com 3 notas cadastradas.");
        notas.setCodDisciplina(1);
        notas.setCodUsuario(10);
        notasDAO.calcularMediaAluno(notas);

        System.out.println("-----------------------------------");

        System.out.println("Calculando média do aluno com as duas maiores notas.");
        notas.setCodDisciplina(1);
        notas.setCodUsuario(10);

        notasDAO.calcularMediaDuasMaioresNotas(notas);
         
    }
    
    
}
