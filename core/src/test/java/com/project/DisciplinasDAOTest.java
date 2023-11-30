package com.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import com.project.Classes.Disciplinas;
import com.project.Dao.DisciplinasDAO;
import com.project.DataBase.DataBase;

public class DisciplinasDAOTest {

    public static void main(String[] args) throws IOException {

        Connection connection = null;

        try {
            // Obtém uma conexão com o banco de dados
            connection = DataBase.getInstance().getConnection();

            // Chame um metodo de cadastrar disciplina apartir daqui.

            Disciplinas disciplina = new Disciplinas();
            disciplina.setNomeDisciplina("matematica");
            disciplina.setCodDisciplina(14);
            disciplina.setCodUsuario(2);
           
             // Cria uma instância de DisciplinaDao
            DisciplinasDAO disciplinasDAO = new DisciplinasDAO();

            // Inserindo Disciplinas
            disciplinasDAO.cadastrarDisciplina(disciplina);
            System.out.println("Disciplina inserido com sucesso.");

            System.out.println("---------------------------------");


            
           // Chame um metodo de autualizar disciplina apartir daqui.

           

        } catch (SQLException e) {
            // Mensagem de erro caso não consiga conectar ao banco de dados.
            System.err.println("Erro durante o teste: " + e.getMessage());
        } finally {
            /**
             * Fecha a conexão com o banco de dados.
             * finalmente é executado mesmo se houver uma exceção.
             */
            DataBase.getInstance().closeConnection();
        }
    }
    
}
