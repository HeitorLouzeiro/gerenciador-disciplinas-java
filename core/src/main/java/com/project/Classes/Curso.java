package com.project.Classes;

/**
 * Representa um curso oferecido, identificado por um ID e um nome.
 * 
 * @author @HeitorLouzeiro
 */
public class Curso {
    private int codCurso; // ID do curso
    private String nomeCurso; // Nome do curso

    /**
     * Construtor padrão da classe Curso.
     */
    public Curso() {
        
    }

    /**
     * Obtém o ID do curso.
     * 
     * @return O ID do curso.
     */
    public int getcodCurso() {
        return codCurso;
    }

    /**
     * Define o COdigo do curso.
     * 
     * @param Curso O Codigo a ser atribuído ao curso.
     */
    public void setcodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    /**
     * Obtém o nome do curso.
     * 
     * @return O nome do curso.
     */
    public String getNomeCurso() {
        return nomeCurso;
    }

    /**
     * Define o nome do curso.
     * 
     * @param nomeCurso O nome a ser atribuído ao curso.
     */
    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
}