package com.project;

import java.io.IOException;

import com.project.Dao.CoordenadorDAO;


public class CoordenadorDAOTest {
    public static void main(String[] args) throws IOException {
        try {
            // Mostre todos os professores cadastrados no banco de dados aqui.
            CoordenadorDAO coordenadorDAO = new CoordenadorDAO();
            System.out.println("Lista de Professores :");
            coordenadorDAO.mostrarProfessor();

            System.out.println("------------------------------------------");

            
            System.out.println("Lista Curso de Ciencia da Computacao:");
            coordenadorDAO.mostrarProfessoresCursos(1);
            System.out.println("------------------------------------------");
            
            coordenadorDAO.mostrarAlunosCursos(1);

            System.out.println("------------------------------------------");
            
            coordenadorDAO.mostrarCursosDisciplinas(1);
            System.out.println("------------------------------------------");

            System.out.println("Lista Curso de Engenharia de Software:");
            coordenadorDAO.mostrarProfessoresCursos(2);
            System.out.println("------------------------------------------");
            
            coordenadorDAO.mostrarAlunosCursos(2);
            System.out.println("------------------------------------------");
            
            coordenadorDAO.mostrarCursosDisciplinas(2);
            System.out.println("------------------------------------------");

            System.out.println("Lista Curso de Sistemas de Informacao:");
            coordenadorDAO.mostrarProfessoresCursos(3);
            System.out.println("------------------------------------------");
            
            coordenadorDAO.mostrarAlunosCursos(3);
            System.out.println("------------------------------------------");

            coordenadorDAO.mostrarCursosDisciplinas(3);
            System.out.println("------------------------------------------");
            

            System.out.println("Lista Curso de Engenharia de Computacao:");
            coordenadorDAO.mostrarProfessoresCursos(4);
            System.out.println("------------------------------------------");

            coordenadorDAO.mostrarAlunosCursos(4);
            System.out.println("------------------------------------------");

            coordenadorDAO.mostrarCursosDisciplinas(4);
            System.out.println("------------------------------------------");

            System.out.println("Lista Curso de Engenharia Eletrica:");
            coordenadorDAO.mostrarProfessoresCursos(5);
            System.out.println("------------------------------------------");

            coordenadorDAO.mostrarAlunosCursos(5);
            System.out.println("------------------------------------------");

            coordenadorDAO.mostrarCursosDisciplinas(5);
            System.out.println("------------------------------------------");

            
        } catch (Exception e) {
            // Mensagem de erro caso não consiga conectar ao banco de dados.
            System.err.println("Erro durante o teste: " + e.getMessage());
        }
    }
}
