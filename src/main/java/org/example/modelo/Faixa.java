package org.example.modelo;

import org.example.recursos.Input;

public enum Faixa {
    BRANCA(1),
    AZUL(2),
    ROXA(3),
    MARROM(4),
    PRETA(5);

    private int faixa = 0;

    Faixa(int faixa){
        this.faixa = faixa;
    }

    public static Faixa lerFaixa() {

        int faixaID = -1;
        while(faixaID > 5 || faixaID < 1){
            System.out.println("=====COR-DA-FAIXA=====");
            System.out.println("[1]-Branca");
            System.out.println("[2]-Azul");
            System.out.println("[3]-Roxa");
            System.out.println("[4]-Marrom");
            System.out.println("[5]-Preta");

            faixaID = Input.input.nextInt();
            Input.input.nextLine();
        }

        Faixa faixa = Faixa.BRANCA;

        for(Faixa fx: Faixa.values()){
            if(faixaID == fx.getFaixa()){
                faixa = fx;
            }
        }

        return faixa;
    }

    public int getFaixa() {
        return faixa;
    }

    @Override
    public String toString() {
        return switch (this.getFaixa()) {
            case 1 -> "branca";
            case 2 -> "azul";
            case 3 -> "roxa";
            case 4 -> "marrom";
            case 5 -> "preta";
            default -> null;
        };
    }

}
