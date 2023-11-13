package com.project.Classes;

/**
 * Representa uma disciplina identificada por um código e um nome.
 * @author @HeitorLouzeiro
 */
public class Disciplinas {
    private int codDisciplina; // Código da disciplina
    private String nomeDisciplina; // Nome da disciplina
    private int codUsuario; // Código do usuário que é o professor da disciplina
    
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
    public int getCodDisciplina() {
        return codDisciplina;
    }
    
    /**
     * Define o código da disciplina.
     * 
     * @param codDisciplina O código a ser atribuído à disciplina.
     */
    public void setCodDisciplina(int codDisciplina) {
        this.codDisciplina = codDisciplina;
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

    /**
     * Obtém o código do Professor.
     * 
     * @return O código do Professor.
     */
    public int getCodUsuario() {
        return codUsuario;
    }
    
    /**
     * Define o código do Professor.
     * 
     * @param codUsuario O código a ser atribuído ao usuário.
     */
    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }
}
