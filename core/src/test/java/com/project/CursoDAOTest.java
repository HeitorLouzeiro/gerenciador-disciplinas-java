package com.project;

import java.io.IOException;
import java.sql.SQLException;

import com.project.Dao.CursoDAO;

public class CursoDAOTest {
    public static void main(String[] args) throws IOException {
        try {
            CursoDAO cursoDAO = new CursoDAO();
            System.out.println("Lista de Cursos :");
            cursoDAO.mostrarCursos();

            System.out.println("------------------------------------------");

        } catch (SQLException e) {
            // Mensagem de erro caso não consiga conectar ao banco de dados.
            System.err.println("Erro durante o teste: " + e.getMessage());
        }
    }
}
