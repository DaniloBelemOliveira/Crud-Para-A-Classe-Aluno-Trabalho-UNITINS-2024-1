package org.example.modelo;

public abstract class Pessoa {

    private String nome;
    private final String cpf;
    private Integer idade;
    private final Sexo sexo;

    public Pessoa(String cpf, String nome, Integer idade,Sexo sexo) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public void setIdade(int novaIdade) {
        this.idade = novaIdade;
    }
}
