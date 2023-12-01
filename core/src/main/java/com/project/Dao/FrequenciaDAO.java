package com.project.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.project.Classes.Frequencia;
import com.project.DataBase.DataBase;

public class FrequenciaDAO {
    private Connection connection;

    public FrequenciaDAO() throws IOException {
       connection = DataBase.getInstance().getConnection();
    }

    public void quantidadeFaltas(int codUsuario) throws SQLException {
        Statement statement = connection.createStatement();

        // Selecionado o nome da disciplina e a quantidade de faltas do aluno
        String frequencia = "SELECT disciplinas.nome AS nomeDisciplina, COUNT(presente) AS totalFaltas " +
        // Selecionando a tabela frequencia
        "FROM frequencia " +
        // Fazendo o join com a tabela disciplinas para pegar o nome da disciplina.
        "INNER JOIN disciplinas ON disciplinas.codDisciplina = frequencia.codDisciplina " +
        // Selecionando apenas as faltas do aluno pelo código do usuário.
        "WHERE presente = 0 AND frequencia.codUsuario = " + codUsuario +
        // Agrupando por disciplina.
        " GROUP BY disciplinas.nome";

        ResultSet resultSet = statement.executeQuery(frequencia);

        while (resultSet.next()) {
            System.out.println("Curso: " + resultSet.getString("nomeDisciplina") + " - " + "Total de faltas: " + resultSet.getString("totalFaltas") + "\n");
        }

        statement.close();
    }
    
    
    public void inserirFrequenciaAluno(Frequencia frequencia) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
            "INSERT INTO frequencia (codDisciplina, codUsuario, presente, dataFrequencia) VALUES (?, ?, ?, ?)"
        );
        statement.setInt(1, frequencia.getCodDisciplina());
        statement.setInt(2, frequencia.getCodUsuario());
        statement.setInt(3, frequencia.getPresenca());
        statement.setString(4, frequencia.getData());

        statement.execute();

        System.out.println("Frequência cadastrada com sucesso!");
        statement.close();

    }
}
