package com.project;

import java.io.IOException;

import com.project.Dao.AlunoDAO;

public class AlunoDAOTest {
    public static void main(String[] args) throws IOException {
        AlunoDAO alunoDAO = new AlunoDAO();
        try {
            alunoDAO.mostrarDisciplinasAluno(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
    }
    
}
