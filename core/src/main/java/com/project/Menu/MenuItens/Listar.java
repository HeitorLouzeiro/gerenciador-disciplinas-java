package com.project.Menu.MenuItens;

import java.io.IOException;
import java.sql.SQLException;

import com.project.Dao.AlunoDAO;
import com.project.Dao.IFPIDAO;
import com.project.Dao.SecretarioDAO;

public class Listar {
    static class Space {
        static String space = "-----------------------------------------------------";
    }
        // Listar todos os alunos
    public void listarAlunos() throws IOException {
        SecretarioDAO secretarioDAO = new SecretarioDAO();
        try {
            System.out.println("Listando todos os alunos...");
            secretarioDAO.getAlunos();
            System.out.println(Space.space);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar todos os docentes
    public void listarDocentes() throws IOException {
        IFPIDAO ifpiDAO = new IFPIDAO();
        try {
            System.out.println("Listando todos os docentes...");
            ifpiDAO.listarDocentes();
            System.out.println(Space.space);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar todos os cursos
    public void disciplinasOfertadas() throws IOException {
        IFPIDAO alunoDAO = new IFPIDAO();
        try {
            System.out.println("Listando todas as disciplinas ofertadas...");
            alunoDAO.disciplinasOfertadas();
            System.out.println(Space.space);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar todas as disciplinas de um aluno
    public void disciplinasAluno(int codUsuario) throws IOException {
        AlunoDAO alunodao = new AlunoDAO();
        try {
            System.out.println("Listando todas as disciplinas do aluno...");
            alunodao.mostrarDisciplinasAluno(codUsuario);
            System.out.println(Space.space);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
