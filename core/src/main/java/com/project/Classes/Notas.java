package com.project.Classes;

import java.util.Scanner;

/**
 * A classe Notas representa as notas dos alunos em uma disciplina.
 */
public class Notas {
    
    /**
     * ID da nota.
     */
    private int codNota;
    
    /**
     * ID da disciplina.
     */
    private int codDisciplina;
    
    /**
     * ID do aluno.
     */
    private int codUsuario;
    
    /**
     * Nota do aluno.
     */
    private double nota;
    
    /**
     * Obtém o ID da nota.
     * @return O ID da nota.
     */
    public int getCodNota() {
        return codNota;
    }
    
    /**
     * Define o ID da nota.
     * @param codNota O novo ID da nota.
     */
    public void setCodNota(int codNota) {
        this.codNota = codNota;
    }
    
    /**
     * Obtém o ID da disciplina.
     * @return O ID da disciplina.
     */
    public int getCodDisciplina() {
        return codDisciplina;
    }
    
    /**
     * Define o ID da disciplina.
     * @param codDisciplina O novo ID da disciplina.
     */
    public void setCodDisciplina(int codDisciplina) {
        this.codDisciplina = codDisciplina;
    }
    
    /**
     * Obtém o ID do aluno.
     * @return O ID do aluno.
     */
    public int getCodUsuario() {
        return codUsuario;
    }
    
    /**
     * Define o ID do aluno.
     * @param codUsuario O novo ID do aluno.
     */
    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }
    
    /**
     * Obtém a nota do aluno.
     * @return A nota do aluno.
     */
    public double getNota() {
        return nota;
    }
    
    /**
     * Define a nota do aluno, verificando se está no intervalo de 0 a 10.
     * Se a nota fornecida estiver fora desse intervalo, solicita uma nova entrada.
     * @param nota A nova nota do aluno.
     */
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
    
    /**
     * Verifica se a nota está no intervalo de 0 a 10.
     * @param nota A nota a ser verificada.
     * @return true se a nota estiver no intervalo, false caso contrário.
     */
    private boolean verificarNota(double nota) {
        return nota >= 0 && nota <= 10;
    }
}
