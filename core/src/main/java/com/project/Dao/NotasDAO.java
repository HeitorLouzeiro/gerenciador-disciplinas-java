package com.project.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.Classes.Notas;
import com.project.DataBase.DataBase;

public class NotasDAO {
    private Connection connection;

    public NotasDAO() throws IOException {
       connection = DataBase.getInstance().getConnection();
    }

    public void cadastrarNota(Notas nota) throws SQLException {
        System.out.println("Cadastrando nota");

        PreparedStatement statement = connection.prepareStatement(
            "INSERT INTO notas (codDisciplina, codUsuario, nota) VALUES (?, ?, ?)");

        statement.setInt(1, nota.getCodDisciplina());
        statement.setInt(2, nota.getCodUsuario());
        statement.setDouble(3, nota.getNota());

        statement.executeUpdate();

        System.out.println("Nota cadastrada com sucesso!");

    }

    public void atualizarNota(Notas nota) throws SQLException {
        System.out.println("Atualizando nota");

        PreparedStatement statement = connection.prepareStatement(
            "UPDATE notas SET nota = ? WHERE codDisciplina = ? AND codUsuario = ? AND codNota = ?");

        statement.setDouble(1, nota.getNota());
        statement.setInt(2, nota.getCodDisciplina());
        statement.setInt(3, nota.getCodUsuario());
        statement.setInt(4, nota.getCodNota());

        statement.executeUpdate();

        System.out.println("Nota atualizada com sucesso!");
    }

    public void mostrarNotasAluno(int codUsuario) throws SQLException {
        Statement statement = connection.createStatement();

        System.out.println("Listando notas do aluno...");

        String sql = "SELECT notas.*, disciplinas.nome as disciplinaNome FROM notas " + 
        "INNER JOIN disciplinas ON notas.codDisciplina = disciplinas.codDisciplina " +
        "WHERE notas.codUsuario = " + codUsuario;

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("Código: " + resultSet.getInt("codDisciplina") + 
            " - Disciplina: " + resultSet.getString("disciplinaNome") +
            " - Nota: " + resultSet.getDouble("nota"));
        }
    }
    
    public double calcularMediaAluno(int codDisciplina, int codUsuario) throws SQLException {
        Statement statement = connection.createStatement();
    
        String sql = "SELECT * FROM notas WHERE codUsuario = " + codUsuario + 
        " AND codDisciplina = " + codDisciplina;
    
        ResultSet resultSet = statement.executeQuery(sql);
    
        double soma = 0;
        int quantidade = 0;
    
        while (resultSet.next()) {
            soma += resultSet.getDouble("nota");
            quantidade++;
        }

        if (quantidade < 2){
            System.out.println("O aluno não possui notas suficientes para calcular a média.");
            return 0;
        }

        double media = soma / quantidade;

        System.out.printf("A média do aluno é : %.2f ", media);

        situacaoAluno(media);

        return media;
    }

    public double calcularMediaDuasMaioresNotas(int codUsuario) throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM notas WHERE codUsuario = " + codUsuario;

        ResultSet resultSet = statement.executeQuery(sql);

        double maiorNota = 0;
        double segundaMaiorNota = 0;
        int quantidade = 0;

        while (resultSet.next()) {
            if (resultSet.getDouble("nota") > maiorNota) {
                segundaMaiorNota = maiorNota;
                maiorNota = resultSet.getDouble("nota");
            } else if (resultSet.getDouble("nota") > segundaMaiorNota) {
                segundaMaiorNota = resultSet.getDouble("nota");
            }
            quantidade++;
        }

        if (quantidade == 0) {
            System.out.println("O aluno não possui notas cadastradas");
            return 0;
        }

        if (quantidade < 3){
            System.out.println("O aluno não possui notas suficientes para calcular a média");
            return 0;
        }

        double media = (maiorNota + segundaMaiorNota) / 2;

        System.out.println("A maior nota do aluno é: " + maiorNota);
        System.out.println("A segunda maior nota do aluno é: " + segundaMaiorNota);

        System.out.printf("A média do aluno é : %.1f ", media);

        situacaoAluno(media);

        return media;
    }

    private double situacaoAluno(double media) {
        if (media >= 7) {
            System.out.println("Aprovado");
        } else {
            System.out.println("Reprovado!");
        }
        return media;
    }
}
