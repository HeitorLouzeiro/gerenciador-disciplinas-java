package com.project.Classes;

/**
 * Classe abstrata que representa um funcionário no sistema, estendendo a classe Usuario.
 *
 * Esta classe adiciona atributos específicos de funcionários, como código de cargo e descrição do cargo.
 * Também fornece métodos de acesso (getters e setters) para manipulação desses atributos.
 *
 * @author @HeitorLouzeiro
 */
abstract class Funcionario extends Usuario {

    /**
     * Código único associado ao cargo do funcionário.
     */
    protected int codCargo;

    /**
     * Descrição do cargo do funcionário.
     */
    protected String cargo;

    /**
     * Obtém o código do cargo do funcionário.
     *
     * @return O código do cargo do funcionário.
     */
    public int getCodCargo() {
        return codCargo;
    }

    /**
     * Define o código do cargo do funcionário.
     *
     * @param codCargo O novo código do cargo do funcionário.
     */
    public void setCodCargo(int codCargo) {
        this.codCargo = codCargo;
    }

    /**
     * Obtém a descrição do cargo do funcionário.
     *
     * @return A descrição do cargo do funcionário.
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Define a descrição do cargo do funcionário.
     *
     * @param cargo A nova descrição do cargo do funcionário.
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
