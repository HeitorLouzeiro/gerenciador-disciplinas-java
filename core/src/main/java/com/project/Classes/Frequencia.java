package com.project.Classes;

/**
 * Representa a frequência de um usuário em uma turma em uma data específica, identificada por códigos e uma data.
 * 
 * @author @HeitorLouzeiro
 */
public class Frequencia {
    private int codFrequencia; // Código da frequência
    private int codUsuario; // Código do usuário
    private int codDisciplina; // Código da Disciplina
    private int presenca; // Presença do usuário na turma
    private String data; // Data da frequência


    /**
     * Construtor padrão da classe Frequencia.
     */
    public Frequencia() {
    
    }


    /**
     * Obtém o código da frequência.
     * 
     * @return O código da frequência.
     */
    public int getCodFrequencia() {
        return codFrequencia;
    }

    /**
     * Define o código da frequência.
     * 
     * @param codFrequencia O código a ser atribuído à frequência.
     */
    public void setCodFrequencia(int codFrequencia) {
        this.codFrequencia = codFrequencia;
    }

    /**
     * Obtém o código do usuário associado à frequência.
     * 
     * @return O código do usuário.
     */
    public int getCodUsuario() {
        return codUsuario;
    }

    /**
     * Define o código do usuário associado à frequência.
     * 
     * @param codUsuario O código do usuário a ser associado à frequência.
     */
    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }
    
    /**
     * Obtém o código da turma associada à frequência.
     * 
     * @return O código da Turma.
     */
    public int getCodDisciplina() {
        return codDisciplina;
    }

    /**
     * Define o código da Disciplina associada à frequência.
     * 
     * @param codDisciplina O código da Disciplina a ser associada à frequência.
     */
    public void setCodDisciplina(int codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    /**
     * Obtém a presença do usuário na turma.
     * 
     * @return A presença do usuário na turma.
     */
    public int getPresenca() {
        return presenca;
    }

    /**
     * Define a presença do usuário na turma.
     * 0 - Ausente
     * 1 ou mais sendo contando a quantidade de presente.
     * 
     * @param presenca A presença a ser atribuída à frequência.
     */
    public void setPresenca(int presenca) {
        this.presenca = presenca;
    }

    /**
     * Obtém a data da frequência.
     * 
     * @return A data da frequência.
     */
    public String getData() {
        return data;
    }

    /**
     * Define a data da frequência.
     * 
     * @param data A data a ser atribuída à frequência.
     */
    public void setData(String data) {
        this.data = data;
    }

}
