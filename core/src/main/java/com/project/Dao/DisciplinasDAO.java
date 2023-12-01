package com.project.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; // Importa a classe SQLException para tratamento de exceções
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.Classes.Disciplinas; // Importa a classe Disciplinas
import com.project.DataBase.DataBase;

public class DisciplinasDAO {
    private Connection connection;

    public DisciplinasDAO() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }

    public void cadastrarDisciplina(Disciplinas disciplina) throws SQLException {
        System.out.println("Inserindo Disciplina...");

        PreparedStatement statement = connection
                .prepareStatement("INSERT INTO disciplinas (nome, codCurso, codUsuario) VALUES (?, ?, ?)");

        statement.setString(1, disciplina.getNomeDisciplina());
        statement.setInt(2, disciplina.getCodCurso());
        statement.setInt(3, disciplina.getCodUsuario());

        statement.executeUpdate();

        statement.close();
    }

    public void editarDisciplinaById(int codDisciplina) throws SQLException {

    }

    public Disciplinas getDisciplinasById(int codDisciplina) throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM disciplinas " +
                "WHERE codDisciplina = " + codDisciplina;

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            // Cria um objeto disciplinas e popula com os valores do BD
            Disciplinas disciplinas = new Disciplinas();

            // Popula o objeto disciplinas com os valores do BD
            disciplinas.setCodDisciplina(resultSet.getInt("codDisciplina"));
            disciplinas.setNomeDisciplina(resultSet.getString("nome"));
            disciplinas.setCodUsuario(resultSet.getInt("codUsuario"));

            // Retorna o objeto disciplinas
            return disciplinas;
        }

        statement.close();
        return null;
    }

    public void alunoDisciplina(int codDisciplina, int codUsuario) throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO alunosDisciplinas (codDisciplina, codUsuario) " +
                "VALUES (" + codDisciplina + ", " + codUsuario + ")";

        statement.executeUpdate(sql);
        statement.close();
    }

    public List<Integer>  listarAlunosDisciplina(int codDisciplina) throws SQLException {
        List<Integer> codigosAlunos = new ArrayList<>();
        Statement statement = connection.createStatement();

        String sql = "SELECT alunosDisciplinas.*, usuario.nome FROM alunosDisciplinas " +
                "INNER JOIN usuario ON alunosDisciplinas.codUsuario = usuario.codUsuario " +
                "WHERE codDisciplina = " + codDisciplina;

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int codigoUsuario = resultSet.getInt("codUsuario");
            codigosAlunos.add(codigoUsuario);
            System.out.println("Código do aluno: " + resultSet.getInt("codUsuario") +
                    " - Nome do aluno: " + resultSet.getString("nome"));
        }

        statement.close();
        return codigosAlunos;
    }
}