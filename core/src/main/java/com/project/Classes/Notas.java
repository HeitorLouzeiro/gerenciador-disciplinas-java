package com.project.Classes;

import java.util.Scanner;

public class Notas {
    private int codNota; // ID da nota
    private int codDisciplina; // ID da disciplina
    private int codUsuario; // ID do aluno
    private double nota; // Nota do aluno
    
    public int getCodNota() {
        return codNota;
    }
    public void setCodNota(int codNota) {
        this.codNota = codNota;
    }
    
    public int getCodDisciplina() {
        return codDisciplina;
    }
    public void setCodDisciplina(int codDisciplina) {
        this.codDisciplina = codDisciplina;
    }
    public int getCodUsuario() {
        return codUsuario;
    }
    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }
    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        while (!verificarNota(nota)) {
            System.out.println("Nota inválida. A nota deve estar no intervalo de 0 a 10.");
            System.out.println("Digite a nota novamente: ");
            Scanner scanner = new Scanner(System.in);
            nota = scanner.nextDouble();
        }
        verificarNota(nota);
        this.nota = nota;

    }
    /*
     * Verifica se a nota está no intervalo de 0 a 10.
     * se a nota estiver no intervalo, retorna true.
     */
    private boolean verificarNota(double nota) {
        return nota >= 0 && nota <= 10;
    }
}

