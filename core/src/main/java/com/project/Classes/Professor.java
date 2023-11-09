package com.project.Classes;

class Professor extends Funcionario{
    protected String titulacao;
    protected String areaAtuacao;

    public Professor(String titulacao, String areaAtuacao){

    }


    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }
}