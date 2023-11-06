package com.project.Classes;

abstract class Usuario {
    // Atributos

    // É protected porque as classes filhas precisam acessar
    protected int codUsuario;
    protected String nome;
    protected String cpf;
    protected String dataNascimento;
    protected String dataEntrada;
    protected String senha;
    
    // Getters e Setters
    // Getters servem para acessar os atributos
    // Setters servem para modificar ou adicionar os atributos

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}