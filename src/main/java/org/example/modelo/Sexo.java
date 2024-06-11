package org.example.modelo;

public enum Sexo {

    MASCULINO(1),
    FEMININO(2);

    private final int sexo;

    Sexo(int sexo){
        this.sexo = sexo;
    }

    public int getSexo(){ return sexo;}

}
