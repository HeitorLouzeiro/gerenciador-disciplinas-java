package com.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.project.Classes.Aluno;
import com.project.Dao.SecretarioDAO;
import com.project.DataBase.DataBase;

/**
 * Classe de teste para as operações CRUD na classe SecretarioDAO para a
 * entidade Aluno.
 * 
 * Este código é destinado apenas para fins de teste e não faz parte do projeto
 * principal.
 * 
 * @author Heitor Louzeiro
 */
public class SecretarioDAOTest {

    /**
     * Método principal para execução do teste.
     * 
     * @param args Argumentos de linha de comando (não utilizados neste exemplo).
     * @throws IOException Se ocorrer um erro de leitura durante a execução do
     *                     teste.
     */
    public static void main(String[] args) throws IOException {

        Connection connection = null;

        try {
            // Obtém uma conexão com o banco de dados
            connection = DataBase.getInstance().getConnection();

            // Cria um objeto Aluno para teste
            Aluno aluno = new Aluno();
            aluno.setCodUsuario(4);
            aluno.setNome("Lucas");
            aluno.setCpf("12345678910");
            aluno.setDataNascimento("01/01/2000");
            aluno.setDataEntrada("01/01/2020");
            aluno.setSenha("123456");

            // Cria uma instância de SecretarioDAO
            SecretarioDAO secretarioDAO = new SecretarioDAO();

            // Inserindo Aluno
            secretarioDAO.InsertAluno(aluno);
            System.out.println("Aluno inserido com sucesso.");

            System.out.println("---------------------------------");

            // Listando TODOS os Alunos
            System.out.println("Lista de Alunos:");
            secretarioDAO.getAlunos();

            System.out.println("---------------------------------");

            // Selecionando Aluno pelo Código
            System.out.println("Selecionando Aluno pelo Código:");
            secretarioDAO.SelectAlunoGetByCod(3);

            System.out.println("---------------------------------");

            // Atualizando Aluno
            aluno.setNome("Moises");
            aluno.setCpf("12345671111");
            secretarioDAO.UpdateAluno(aluno);
            System.out.println("Aluno atualizado com sucesso.");

            System.out.println("---------------------------------");

            // Deletando Aluno
            secretarioDAO.DeleteAluno(3);
            System.out.println("Aluno deletado com sucesso.");

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
