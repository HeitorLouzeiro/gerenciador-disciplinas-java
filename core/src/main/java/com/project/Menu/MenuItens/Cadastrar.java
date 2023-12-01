package com.project.Menu.MenuItens;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.project.Classes.Aluno;
import com.project.Classes.Data;
import com.project.Classes.Frequencia;
import com.project.Classes.Notas;
import com.project.Dao.FrequenciaDAO;
import com.project.Dao.NotasDAO;
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

        int opcao = -1;
        do {
            try {
                // Implemente a lógica para verificar algo
                System.out.println("Cadastro de Aluno...");

                System.out.print("Digite o nome do aluno: ");
                aluno.setNome(scanner.nextLine());

                System.out.print("Digite o CPF do aluno: ");
                aluno.setCpf(scanner.nextLine());

                System.out.print("Coloque as datas no formato dd-mm-aaaa\n");

                System.out.print("Digite a data de nascimento do aluno: ");
                dataNascimento.setData(scanner.nextLine());
                aluno.setDataNascimento(dataNascimento);

                System.out.print("Digite a data de entrada do aluno: ");
                dataEntrada.setData(scanner.nextLine());
                aluno.setDataEntrada(dataEntrada);

                aluno.setSenha(aluno.getCpf());
                secretarioDAO.InsertAluno(aluno);

                System.out.println(Space.space);
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
            System.out.println("Deseja cadastrar outro aluno? 1 - Sim | 0 - Não");
            opcao = scanner.nextInt();
            scanner.nextLine();
        } while (opcao != 0);

    }

    public void cadastrarFrequencia(int codDisciplina) throws IOException {
        Frequencia frequencia = new Frequencia();
        FrequenciaDAO frequenciaDAO = new FrequenciaDAO();
        Listar listar = new Listar();
        Data data = new Data();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de frequencia do aluno...");

        System.out.print("Para continuar o cadastro da frequencia selecione a data da frequencia.\n");
        System.out.print("Deseja colocar a data de hoje? 1 - Sim | 0 - Não: ");
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            frequencia.setData(data.getDataAtual());
        } else {
            System.out.print("Coloque as datas no formato dd-mm-aaaa\n");
            System.out.print("Digite a data da aula: ");
            frequencia.setData(scanner.next());
        }

        List<Integer> codigosAlunos = listar.listarAlunosDisciplina(codDisciplina);
        try {
            // Mostra as disciplinas do professor
            frequencia.setCodDisciplina(codDisciplina);

            for (Integer codigo : codigosAlunos) {
                System.out.println("Código do aluno: " + codigo);
                frequencia.setCodUsuario(codigo);
                System.out.print("Digite a presença do aluno: 1 - Presente | 0 - Ausente: ");
                frequencia.setPresenca(scanner.nextInt());
    
                frequenciaDAO.inserirFrequenciaAluno(frequencia);
            }

            System.out.println(Space.space);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cadastrarNotas(int codDisciplina) throws IOException {
        Notas notas = new Notas();
        NotasDAO notasDAO = new NotasDAO();
        Listar listar = new Listar();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de notas do aluno...");

        List<Integer> codigosAlunos = listar.listarAlunosDisciplina(codDisciplina);

        try {
            notas.setCodDisciplina(codDisciplina);

            for (Integer codigo : codigosAlunos) {
                System.out.println("Código do aluno: " + codigo);
                notas.setCodUsuario(codigo);
                System.out.print("Digite a nota do aluno: ");
                double nota = scanner.nextDouble();
                notas.setNota(nota);
                notasDAO.cadastrarNota(notas);
            }
            System.out.println(Space.space);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cadastrarMediaAlunos(int codDisciplina) throws IOException {
        
        NotasDAO notasDAO = new NotasDAO();
        Listar listar = new Listar();

        Scanner scanner = new Scanner(System.in);

        
    }

}
