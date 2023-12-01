package com.project;

import java.io.IOException;

import com.project.Dao.ProfessorDAO;

public class ProfessorDAOTest {
    public static void main(String[] args) throws IOException {
        ProfessorDAO professorDAO = new ProfessorDAO();
        try {
            professorDAO.mostrarDisciplinasProfessor(31);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        
    }
    
}
