package com.project.Classes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Data{
    private int dia;
    private int mes;
    private int ano;
    
    public void setData(String dataString) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate data = LocalDate.parse(dataString, formatter);

            verificaAno(data.getYear());

            this.dia = data.getDayOfMonth();
            this.mes = data.getMonthValue();
            this.ano = data.getYear();
        } catch (DateTimeParseException e) {
            // Relança a exceção para que possa ser tratada no bloco catch externo
            throw e;
        }
    }

    public void verificaAno(int ano) {
        int anoAtual = LocalDate.now().getYear();
        if (ano > anoAtual) {
            throw new IllegalArgumentException("Ano inválido. Você não pode inserir uma data futura.");
        }
    }

    public LocalDate toLocalDate(){
        return LocalDate.of(this.ano, this.mes, this.dia);
    }

    public String getData(){
        return this.dia + "-" + this.mes + "-" + this.ano;
    }



    public long calcularTempoTotal(LocalDate dataEntrada){
        LocalDate dataAtual = LocalDate.now();
        
        long anosTrabalhados = Duration.between(dataEntrada.atStartOfDay(), dataAtual.atStartOfDay()).toDays() / 365;

        return anosTrabalhados;
    }

    
    public int calcularIdade() {
        LocalDate dataNascimento = LocalDate.of(this.ano, this.mes, this.dia);
        LocalDate dataAtual = LocalDate.now();
        return dataAtual.getYear() - dataNascimento.getYear();
    }
    
}
