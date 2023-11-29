package com.project.Classes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * A classe Data representa uma data e fornece métodos relacionados a manipulação de datas.
 * @autor @HeitorLouzeiro
 */
public class Data {
    private int dia;
    private int mes;
    private int ano;

    /**
     * Define a data com base na representação de string fornecida.
     *
     * @param dataString A representação de string da data no formato "dd-MM-yyyy".
     * @throws DateTimeParseException Se a string não puder ser convertida para uma data válida.
     */
    public void setData(String dataString) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate data = LocalDate.parse(dataString, formatter);

            // Verifica se o ano é válido (não é futuro)
            verificaAno(data.getYear());

            this.dia = data.getDayOfMonth();
            this.mes = data.getMonthValue();
            this.ano = data.getYear();
        } catch (DateTimeParseException e) {
            // Relança a exceção para que possa ser tratada no bloco catch externo
            throw e;
        }
    }

    /**
     * Verifica se o ano é válido (não é futuro).
     *
     * @param ano O ano a ser verificado.
     * @throws IllegalArgumentException Se o ano for futuro, lança uma exceção com mensagem apropriada.
     */
    public void verificaAno(int ano) {
        int anoAtual = LocalDate.now().getYear();
        if (ano > anoAtual) {
            throw new IllegalArgumentException("Ano inválido. Você não pode inserir uma data futura.");
        }
    }

    /**
     * Converte a instância Data para LocalDate.
     *
     * @return Um objeto LocalDate representando a data.
     */
    public LocalDate toLocalDate() {
        return LocalDate.of(this.ano, this.mes, this.dia);
    }

    /**
     * Obtém a representação de string da data no formato "dd-MM-yyyy".
     *
     * @return A representação de string da data.
     */
    public String getData() {
        return this.dia + "-" + this.mes + "-" + this.ano;
    }

    /**
     * Calcula o tempo total em anos desde uma data de entrada até a data atual.
     *
     * @param dataEntrada A data de entrada a ser considerada no cálculo.
     * @return O tempo total em anos.
     */
    public long calcularTempoTotal(LocalDate dataEntrada) {
        LocalDate dataAtual = LocalDate.now();

        // Calcula o tempo total em anos usando a diferença em dias e dividindo por 365
        long anosTrabalhados = Duration.between(dataEntrada.atStartOfDay(), dataAtual.atStartOfDay()).toDays() / 365;

        return anosTrabalhados;
    }

    /**
     * Calcula a idade com base na data de nascimento armazenada na instância.
     *
     * @return A idade calculada.
     */
    public int calcularIdade() {
        LocalDate dataNascimento = LocalDate.of(this.ano, this.mes, this.dia);
        LocalDate dataAtual = LocalDate.now();
        return dataAtual.getYear() - dataNascimento.getYear();
    }
}
