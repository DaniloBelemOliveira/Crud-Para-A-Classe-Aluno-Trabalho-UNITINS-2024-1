package org.example.modelo;

import org.example.recursos.Input;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;

import org.example.escola.EscolaService;

public class Aluno extends Pessoa{

    private final int matricula;
    private Graduacao graduacao;
    private static int matriculaAtual = 0;
    private final HashSet<Telefone> telefones = new HashSet<>();

    public HashSet<Telefone> getTelefones() {
        return telefones;
    }

    public Aluno(String cpf, String nome, Integer idade, Sexo sexo, Graduacao graduacao) {
        super(cpf, nome, idade,sexo);
        this.graduacao = graduacao;
        this.matricula = matriculaAtual;
        matriculaAtual++;
    }

    public static Aluno lerAluno() {
        System.out.print("Nome: ");
        String nome = Input.input.nextLine();
        String cpf = "";
        boolean again = true;
        while(again){
            System.out.print("Cpf: ");
            cpf = Input.input.nextLine();
            String finalCpf = cpf;
            if(EscolaService.getAlunos()
                    .stream().noneMatch(aluno -> aluno.getCpf().equalsIgnoreCase(finalCpf))){
                again = false;
            }
        }

        System.out.print("Idade: ");
        int idade = Input.input.nextInt();
        Input.input.nextLine();
        int sexoID = -1;
        while(sexoID > 2 || sexoID < 1){
            System.out.print("Sexo=[1]Masculino|[2]Feminino: ");
            sexoID= Input.input.nextInt();
            Input.input.nextLine();
        }

        Sexo sexo = Sexo.MASCULINO;

        for(Sexo sx: Sexo.values()){
            if(sx.getSexo() == sexoID){
                sexo = sx;
            }
        }

        Graduacao graduacao1 = new Graduacao();
        return new Aluno(cpf,nome,idade,sexo,graduacao1);
    }

    public int getMatricula() {
        return matricula;
    }

    public void setGraduacao(Graduacao graduacao){
        this.graduacao = graduacao;
    }

    public void adicionarTelefone(){
        Telefone telefone = Telefone.lerTelefone();
        telefones.add(telefone);
        System.out.println("Telefone Adicionado com Sucesso!!!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno aluno)) return false;
        return matricula == aluno.matricula;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matricula);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + super.getNome() + '\'' +
                ", cpf='" + super.getCpf() + '\'' +
                ", idade=" + super.getIdade() +
                ", sexo=" + super.getSexo() +
                ", matricula=" + matricula +
                ", telefone principal="+ getPrimeiroTelefone()+
                ", " + this.graduacao +
                '}';
    }

    private String getPrimeiroTelefone() {
        if(!telefones.isEmpty()){
            Telefone telefone = telefones.stream().toList().getFirst();
            return telefone.toString();
        }
        return  "Não definido";
    }


}
