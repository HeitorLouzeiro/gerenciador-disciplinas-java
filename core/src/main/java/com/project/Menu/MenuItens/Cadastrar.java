package com.project.Menu.MenuItens;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.project.Classes.Aluno;
import com.project.Classes.Data;
import com.project.Dao.SecretarioDAO;
import com.project.Menu.MenuItens.Listar.Space;

public class Cadastrar {
    // Cadastrar Aluno
    public void cadastrarAluno() throws IOException {
        SecretarioDAO secretarioDAO = new SecretarioDAO();
        Aluno aluno = new Aluno();
        Data dataNascimento = new Data();
        Data dataEntrada = new Data();
        Scanner scanner = new Scanner(System.in);

        try {
            // Implemente a lógica para verificar algo
            System.out.println("Cadastro de Aluno...");

            System.out.print("Digite o nome do aluno: ");
            aluno.setNome(scanner.nextLine());

            System.out.print("Digite o CPF do aluno: ");
            aluno.setCpf(scanner.nextLine());

            System.out.print("Coloque as datas no formato dd/mm/aaaa\n");
            
            System.out.print("Digite a data de nascimento do aluno: ");
            dataNascimento.setData(scanner.nextLine());
            aluno.setDataNascimento(dataNascimento);

            System.out.print("Digite a data de entrada do aluno: ");
            dataEntrada.setData(scanner.nextLine());
            aluno.setDataEntrada(dataEntrada);

            System.out.print("Digite a senha do aluno: ");
            aluno.setSenha(scanner.nextLine());

            secretarioDAO.InsertAluno(aluno);

            System.out.println(Space.space);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

}
