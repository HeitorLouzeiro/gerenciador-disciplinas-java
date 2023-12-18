package com.project.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.Classes.Notas;
import com.project.DataBase.DataBase;
/**
 * A classe NotasDAO fornece métodos para acessar e manipular dados relacionados a notas de alunos no banco de dados.
 * @Author @HeitorLouzeiro
 */
public class NotasDAO {
    /**
     * Conexão com o banco de dados.
     */
    private Connection connection;

    /**
     * Construtor da classe NotasDAO.
     * Inicializa a conexão com o banco de dados através da instância da classe DataBase.
     *
     * @throws IOException Se houver um erro de E/S ao obter a conexão com o banco de dados.
     */

    public NotasDAO() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }

    /**
     * Cadastra uma nova nota no banco de dados.
     *
     * @param nota A nota a ser cadastrada.
     * @throws SQLException Se ocorrer um erro SQL durante a execução da consulta.
     */

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

    /**
     * Atualiza uma nota com base no ID da nota.
     *
     * @param nota A nota a ser atualizada.
     * @throws SQLException Se ocorrer um erro SQL durante a execução da consulta.
     */

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

    /**
     * Obtém uma nota com base no ID da nota.
     *
     * @param codNota O ID da nota a ser obtida.
     * @return A nota correspondente ao ID fornecido.
     * @throws SQLException Se ocorrer um erro SQL durante a execução da consulta.
     */

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
    /**
     * Calcula a média de um aluno com base em suas notas.
     *
     * @param notas O objeto Notas contendo as notas do aluno.
     * @return A média do aluno.
     * @throws SQLException Se ocorrer um erro SQL durante a execução da consulta.
     */
    public double calcularMediaAluno(Notas notas) throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM notas WHERE codUsuario = " + notas.getCodUsuario() +
                " AND codDisciplina = " + notas.getCodDisciplina();

        ResultSet resultSet = statement.executeQuery(sql);

        double soma = 0;
        int quantidade = 0;
        boolean situacaoCadastrado = true;

        while (resultSet.next()) {
            soma += resultSet.getDouble("nota");
            quantidade++;
        }

        if (quantidade < 2) {
            System.out.println("O aluno não possui notas suficientes para calcular a média.");
            situacaoCadastrado = false;
            return 0;
        }

        double media = soma / quantidade;

        System.out.printf("A média do aluno é : %.2f ", media);

        situacaoAluno(media);

        if (situacaoCadastrado) {
            cadastrarMediaAlunos(media, notas.getCodUsuario(), notas.getCodDisciplina());
        }

        return media;
    }

    /**
     * Calcula a média de um aluno com base em suas duas maiores notas.
     *
     * @param notas O objeto Notas contendo as notas do aluno.
     * @return A média do aluno.
     * @throws SQLException Se ocorrer um erro SQL durante a execução da consulta.
     */
    public double calcularMediaDuasMaioresNotas(Notas notas) throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM notas WHERE codUsuario = " + notas.getCodUsuario() +
                " AND codDisciplina = " + notas.getCodDisciplina() + " ORDER BY nota DESC";

        ResultSet resultSet = statement.executeQuery(sql);

        double maiorNota = 0;
        double segundaMaiorNota = 0;
        int quantidade = 0;
        boolean situacaoCadastrado = true;

        while (resultSet.next()) {
            if (resultSet.getDouble("nota") > maiorNota) {
                segundaMaiorNota = maiorNota;
                maiorNota = resultSet.getDouble("nota");
            } else if (resultSet.getDouble("nota") > segundaMaiorNota) {
                segundaMaiorNota = resultSet.getDouble("nota");
            }
            quantidade++;
        }

        if (quantidade < 3) {
            System.out.println("O aluno não possui notas suficientes para calcular a média");
            situacaoCadastrado = false;
            return 0;
        }

        double media = (maiorNota + segundaMaiorNota) / 2;

        System.out.println("A maior nota do aluno é: " + maiorNota);
        System.out.println("A segunda maior nota do aluno é: " + segundaMaiorNota);

        System.out.printf("A média do aluno é : %.1f ", media);

        situacaoAluno(media);

        if (situacaoCadastrado) {
            cadastrarMediaAlunos(media, notas.getCodUsuario(), notas.getCodDisciplina());
        }

        return media;
    }

    /**
     * Determina a situação do aluno com base na média.
     *
     * @param media A média do aluno.
     * @return A média do aluno.
     */
    private double situacaoAluno(double media) {
        if (media >= 7) {
            System.out.println("Aprovado");
        } else {
            System.out.println("Reprovado!");
        }
        return media;
    }

    /**
     * Cadastra a média de um aluno no banco de dados.
     *
     * @param media       A média do aluno.
     * @param codDisciplina O ID da disciplina.
     * @param codUsuario    O ID do aluno.
     * @throws SQLException Se ocorrer um erro SQL durante a execução da consulta.
     */

    private void cadastrarMediaAlunos(double media, int codDisciplina, int codUsuario) throws SQLException {
        Statement statement = connection.createStatement();
            String sql = "INSERT INTO historico (codDisciplina, codUsuario, media) " +
                    "VALUES (" + codDisciplina + ", " + codUsuario + ", " + media + ")";
            int linhasAfetadas = statement.executeUpdate(sql);

            if (linhasAfetadas > 0) {
                System.out.println("Média cadastrada com sucesso!");
            } else {
                System.out.println("Erro ao cadastrar média");
            }
    }

}
