package com.project.Classes;

/**
 * Representa uma disciplina identificada por um código e um nome.
 * @author @HeitorLouzeiro
 */
public class Disciplinas {
    private int codDisciplinas; // Código da disciplina
    private String nomeDisciplina; // Nome da disciplina
    
    /**
     * Construtor padrão da classe Disciplinas.
     */
    public Disciplinas() {
        
    }

    /**
     * Obtém o código da disciplina.
     * 
     * @return O código da disciplina.
     */
    public int getCodDisciplinas() {
        return codDisciplinas;
    }
    
    /**
     * Define o código da disciplina.
     * 
     * @param codDisciplinas O código a ser atribuído à disciplina.
     */
    public void setCodDisciplinas(int codDisciplinas) {
        this.codDisciplinas = codDisciplinas;
    }
    
    /**
     * Obtém o nome da disciplina.
     * 
     * @return O nome da disciplina.
     */
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }
    
    /**
     * Define o nome da disciplina.
     * 
     * @param nomeDisciplina O nome a ser atribuído à disciplina.
     */
    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
}
