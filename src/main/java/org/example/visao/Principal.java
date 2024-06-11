package org.example.visao;

import org.example.escola.EscolaService;
import org.example.recursos.Input;

public class Principal {

    public static EscolaService service = new EscolaService();
    public static void main(String[] args) {

        System.out.println("\n#########DOJO 25-25###########");
        int op = menu();

        while (op != 8){
            switch (op){
                case 1:
                    service.adicionarAluno();
                    break;
                case 2:
                    service.listarAlunos();
                    break;
                case 3:
                    service.buscarAluno(true);
                    break;
                case 4:
                    service.listarTelefonesDeAluno();
                    break;
                case 5:
                    service.AdicionarNumeroAAluno();
                    break;
                case 6:
                    service.editarAluno();
                    break;
                case 7:
                    service.deletarAluno();
                    break;
            }
            op = menu();

        }
        for(int i =0; i<5;i++){
            try {
                Thread.sleep(100);
                System.out.print(".");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.print(" Finalizado com sucesso!!!");
    }

    public static int menu(){
        System.out.println("\n=======MENU-DE-CRUD======");
        System.out.println("[1]-Adicionar Aluno");
        System.out.println("[2]-Listar Alunos");
        System.out.println("[3]-Buscar Aluno");
        System.out.println("[4]-Buscar Telefones de um Aluno");
        System.out.println("[5]-Adicionar Número de Telefone à um Aluno");
        System.out.println("[6]-Editar Aluno");
        System.out.println("[7]-Deletar Aluno");
        System.out.println("[8]-Sair");

       int op = Input.input.nextInt();
       Input.input.nextLine();
       return op;
    }

}
