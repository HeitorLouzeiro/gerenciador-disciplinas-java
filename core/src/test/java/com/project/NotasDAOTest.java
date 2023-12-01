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
        notas.setNota(9.5);

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
        notasDAO.calcularMediaAluno(1, 2);

        System.out.println("-----------------------------------");
        
        System.out.println("Calculando média do aluno com 2 notas cadastradas.");
        notasDAO.calcularMediaAluno(6, 3);
        
        System.out.println("-----------------------------------");        

        System.out.println("Calculando média do aluno com 3 notas cadastradas.");
        notasDAO.calcularMediaAluno(1, 10);

        System.out.println("-----------------------------------");

        System.out.println("Calculando média do aluno com as duas maiores notas.");
        //TODO Adicionar codigo da disciplina para calcular a media do aluno na disciplina.
        notasDAO.calcularMediaDuasMaioresNotas(10);
         
    }
    
    
}
