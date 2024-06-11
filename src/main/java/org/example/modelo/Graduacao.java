package org.example.modelo;

import org.example.recursos.Input;

public class Graduacao {
    private final Faixa faixa;
    private final int grau;

    public Graduacao(){
        this.faixa = Faixa.lerFaixa();
        int dan = -1;
        while(dan > 4 || dan < 0){
            System.out.println("=====DAN-DA-FAIXA=====");
            System.out.println("[0]-Sem DAN");
            System.out.println("[1]-Primeiro DAN");
            System.out.println("[2]-Segundo DAN");
            System.out.println("[3]-Terceiro DAN");
            System.out.println("[4]-Quarto DAN");

            dan = Input.input.nextInt();
            Input.input.nextLine();
        }
        this.grau = dan;
    }

    @Override
    public String toString() {
        return "Faixa = "+faixa+" "+grau+"° DAN";
    }
}
