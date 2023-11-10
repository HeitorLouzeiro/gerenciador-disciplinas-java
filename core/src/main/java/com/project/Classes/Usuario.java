package com.project.Classes;

/**
 * Classe abstrata que representa um usuário do sistema.
 * Esta classe serve como uma base para a criação de classes específicas de usuários.
 * Ela contém atributos comuns a todos os usuários, bem como métodos de acesso (getters e setters)
 * para manipulação desses atributos.
 * 
 * @author @HeitorLouzeiro
 */
abstract class Usuario {

    // Atributos
    /**
     * Código único associado a cada usuário. Protegido porque as classes filhas precisam acessar esse atributo.
     */
    protected int codUsuario;

    /**
     * Nome do usuário.
     */
    protected String nome;

    /**
     * Número de CPF (Cadastro de Pessoas Físicas) do usuário.
     */
    protected String cpf;

    /**
     * Data de nascimento do usuário no formato "dd/mm/aaaa".
     */
    protected String dataNascimento;

    /**
     * Data de entrada do usuário no sistema no formato "dd/mm/aaaa".
     */
    protected String dataEntrada;

    /**
     * Senha associada ao usuário para autenticação.
     */

    protected String senha;

    // Getters e Setters
// Getters servem para acessar os atributos
    // Setters servem para modificar ou adicionar os atributos

    /**
     * Obtém o código do usuário.
     * @return O código do usuário.
     */
    public int getCodUsuario() {
        return codUsuario;
    }

    /**
     * Define o código do usuário.
     * @param codUsuario O novo código do usuário.
     */
    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    /**
     * Obtém o nome do usuário.
     * @return O nome do usuário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuário.
     * @param nome O novo nome do usuário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o CPF do usuário.
     *
     * @return O CPF do usuário.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF do usuário.
     *
     * @param cpf O novo CPF do usuário.
     */

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Obtém a data de nascimento do usuário.
     *
     * @return A data de nascimento do usuário.
     */

    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Define a data de nascimento do usuário.
     *
     * @param dataNascimento A nova data de nascimento do usuário.
     */

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Obtém a data de entrada do usuário no sistema.
     *
     * @return A data de entrada do usuário no sistema.
     */

    public String getDataEntrada() {
        return dataEntrada;
    }

    /**
     * Define a data de entrada do usuário no sistema.
     *
     * @param dataEntrada A nova data de entrada do usuário no sistema.
     */

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    /**
     * Obtém a senha do usuário.
     *
     * @return A senha do usuário.
     */

    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do usuário.
     *
     * @param senha A nova senha do usuário.
     */

    public void setSenha(String senha) {
        this.senha = senha;
    }

}