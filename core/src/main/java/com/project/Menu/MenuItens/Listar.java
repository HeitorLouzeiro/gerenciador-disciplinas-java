package com.project.Menu.MenuItens;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Dao.AlunoDAO;
import com.project.Dao.CursoDAO;
import com.project.Dao.DisciplinasDAO;
import com.project.Dao.FrequenciaDAO;
import com.project.Dao.IFPIDAO;
import com.project.Dao.NotasDAO;
import com.project.Dao.ProfessorDAO;
import com.project.Dao.SecretarioDAO;

public class Listar {
    static class Space {
        static String space = "-----------------------------------------------------";
    }

    public void listarCursos(int codUsuario) throws IOException{
        CursoDAO cursoDAO = new CursoDAO();
        try {
            System.out.println("Listando todos os cursos...");
            cursoDAO.mostrarCursos(codUsuario);
            System.out.println(Space.space);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public void quantidadeFaltas(int codUsuario) throws IOException {
        FrequenciaDAO frequenciaDAO = new FrequenciaDAO();
        try {
            System.out.println("Mostrando quantidade de faltas...");
            frequenciaDAO.quantidadeFaltas(codUsuario);
            System.out.println(Space.space);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarNotasAluno(int codUsuario) throws IOException {
        NotasDAO notasDAO = new NotasDAO();
        try {
            notasDAO.mostrarNotasAluno(codUsuario);
            System.out.println(Space.space);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarDisciplinasProfessor(int codUsuario) throws IOException {
        ProfessorDAO professorDAO = new ProfessorDAO();
        try {
            System.out.println("Listando todas as suas disciplinas...");
            professorDAO.mostrarDisciplinasProfessor(codUsuario);
            System.out.println(Space.space);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> listarAlunosDisciplina(int codDisciplina) throws IOException {
        List<Integer> codigosAlunos = new ArrayList<>();
        try {
            DisciplinasDAO disciplinasDAO = new DisciplinasDAO();
            codigosAlunos = disciplinasDAO.listarAlunosDisciplina(codDisciplina);
            System.out.println(Space.space);
        } catch (SQLException e) {
            System.out.println("Erro ao listar alunos da disciplina. Motivo: " + e.getMessage());
            // Log the exception or handle it as appropriate for your application
        }
        return codigosAlunos;
    }

    public void mostrarHistorico(int codUsuario) throws IOException {
        AlunoDAO alunoDAO = new AlunoDAO();
        try {
            alunoDAO.mostrarHistorico(codUsuario);
            System.out.println(Space.space);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarTodosProfessores() throws IOException {
        ProfessorDAO professorDAO = new ProfessorDAO();
        try {
            professorDAO.mostrarTodosProfessores();
            System.out.println(Space.space);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
