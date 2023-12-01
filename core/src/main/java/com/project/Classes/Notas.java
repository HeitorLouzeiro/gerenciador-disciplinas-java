package com.project.Classes;

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
        this.nota = nota;
    }
}
