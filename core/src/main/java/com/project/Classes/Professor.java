package com.project.Classes;

/**
 * Classe que representa um Professor no sistema, estendendo a classe Funcionario.
 * Esta classe herda atributos e comportamentos da classe Funcionario e representa
 * um tipo específico de funcionário, neste caso, um Professor.
 * 
 * @author @Claudemiro-Nogueira
 */
public class Professor extends Funcionario {

    /**
     * Construtor padrão da classe Professor.
     */
    public Professor() {
    }

    /**
     * Titulação do professor.
     */
    protected String titulacao;

    /**
     * Área de atuação do professor.
     */
    protected String areaAtuacao;

    /**
     * Obtém a titulação do professor.
     * 
     * @return A titulação do professor.
     */
    public String getTitulacao() {
        return titulacao;
    }

    /**
     * Define a titulação do professor.
     * 
     * @param titulacao A titulação a ser atribuída ao professor.
     */
    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    /**
     * Obtém a área de atuação do professor.
     * 
     * @return A área de atuação do professor.
     */
    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    /**
     * Define a área de atuação do professor.
     * 
     * @param areaAtuacao A área de atuação a ser atribuída ao professor.
     */
    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }
}