package com.project.Classes;

abstract class Funcionario extends Usuario{
    protected int codCargo;
    protected String cargo;

    public int getCodCargo() {
        return codCargo;
    }
    public void setCodCargo(int codCargo) {
        this.codCargo = codCargo;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
