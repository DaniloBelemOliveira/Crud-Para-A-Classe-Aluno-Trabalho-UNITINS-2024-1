package org.example.escola;

import org.example.modelo.Aluno;
import org.example.modelo.Graduacao;
import org.example.recursos.Input;

import java.util.HashSet;
import java.util.Set;

public class EscolaService {

    private static final Set<Aluno> alunos = new HashSet<>();

    public static Set<Aluno> getAlunos() {
        return alunos;
    }

    public void adicionarAluno() {
        System.out.println("==================");
        alunos.add(Aluno.lerAluno());
        System.out.println("==================");
        System.out.print("Aperte enter para continuar");
        Input.input.nextLine();
    }

    public void listarAlunos(){
        System.out.println("==================");
        alunos.forEach(System.out::println);
        System.out.println("==================");
        System.out.print("Aperte enter para continuar");
        Input.input.nextLine();
    }

    public Aluno buscarAluno(Boolean imprimir){
        int op = 0;
        while (op > 2 || op < 1){
            System.out.println("==========Buscar-Aluno===========");
            System.out.println("[1]-matricula");
            System.out.println("[2]-cpf");

            op = Input.input.nextInt();
            Input.input.nextLine();
        }
        if(op == 1){
            System.out.print("Numero da matricula: ");
            int matricula = Input.input.nextInt();
            Input.input.nextLine();
            boolean alunoExiste = alunos.stream().anyMatch(aluno -> aluno.getMatricula() == matricula);

            if(!alunoExiste){
                throw new RuntimeException("Aluno Não Existe");
            }

            Aluno aluno = alunos.stream()
                    .filter(aluno1 -> aluno1.getMatricula() == matricula).findFirst().get();

            if(imprimir){
                System.out.println(aluno);
            }

            System.out.println("=================================");

            System.out.print("Aperte enter para continuar");
            Input.input.nextLine();
            return aluno;
        }
        else{
            System.out.print("Numero do Cpf: ");
            String cpf = Input.input.next();
            Input.input.nextLine();
            boolean alunoExiste = alunos.stream().anyMatch(aluno -> aluno.getCpf().equalsIgnoreCase(cpf));

            if(!alunoExiste){
                throw new RuntimeException("Aluno Não Existe");
            }

            Aluno aluno = alunos.stream()
                    .filter(aluno1 -> aluno1.getCpf().equalsIgnoreCase(cpf)).findFirst().get();

            if(imprimir){
                System.out.println(aluno);
            }

            System.out.println("=================================");

            System.out.print("Aperte enter para continuar");
            Input.input.nextLine();
            return aluno;
        }
    }

    public void deletarAluno() {
        if(alunos.remove(buscarAluno(true))){
            System.out.println("Aluno Removido Com Sucesso!!!");
        }
        System.out.print("Aperte enter para continuar");
        Input.input.nextLine();
    }

    public void editarAluno() {
        int op = 0;
        while(op <1|| op > 3){
            System.out.println("====Editar-Aluno====");
            System.out.println("[1]-Graduação");
            System.out.println("[2]-Dados Pessoais");
            System.out.println("[3]-Sair");
            op = Input.input.nextInt();
            Input.input.nextLine();
        }
        if(op ==2){
            System.out.println("====Informações-pessoais====");
            System.out.println("[1]-Nome");
            System.out.println("[2]-Idade");

            int infOp = Input.input.nextInt();
            Input.input.nextLine();
            switch (infOp){
                case 1:
                    System.out.print("Novo nome: ");
                    String novoNome = Input.input.nextLine();
                    System.out.println("=================================");
                    System.out.println("Buscando aluno para receber nome....");
                    buscarAluno(true).setNome(novoNome);
                    System.out.println("Nome editado com sucesso!!!");
                    break;
                case 2:
                    System.out.print("Nova idade: ");
                    int novaIdade = Input.input.nextInt();
                    Input.input.nextLine();
                    System.out.println("=================================");
                    System.out.println("Buscando aluno para receber nome....");
                    buscarAluno(true).setIdade(novaIdade);
                    System.out.println("Idade editada com sucesso!!!");
                    break;
            }
        }
        else if(op == 3){
            System.out.println("....Ok....");
        }
        else {
            System.out.println("Nova Graduação");
            Graduacao graduacao = new Graduacao();
            System.out.println("Graduação Preparada com sucesso!");
            System.out.println("=================================");
            System.out.println(".....Busque o aluno para ela.....");
            buscarAluno(true).setGraduacao(graduacao);
            System.out.println("Faixa Atualizada com Sucesso!!!");
        }
    }

    public void listarTelefonesDeAluno(){

        Aluno aluno = buscarAluno(true);
        System.out.println("=================================");
        System.out.println("Telefones do aluno "+aluno.getNome());
        System.out.println("=================================");
        System.out.println(aluno.getTelefones());
        System.out.println("=================================");
        System.out.print("Aperte enter para continuar");
        Input.input.nextLine();
    }

    public void AdicionarNumeroAAluno() {
        buscarAluno(true).adicionarTelefone();
        System.out.print("Aperte enter para continuar");
        Input.input.nextLine();
    }

}
