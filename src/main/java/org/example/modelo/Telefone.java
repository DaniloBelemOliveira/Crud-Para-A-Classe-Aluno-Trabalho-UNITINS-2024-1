package org.example.modelo;

import org.example.recursos.Input;

public class Telefone {

    private final String codigoDeArea;
    private final String numero;

    public Telefone(String codigoDeArea, String numero) {
        this.codigoDeArea = codigoDeArea;
        this.numero = numero;
    }

    public static Telefone lerTelefone() {
        System.out.println("====Criando-Telefone====");
        System.out.print("Codígo de Área: ");
        String numeroDeArea = Input.input.next();
        Input.input.nextLine();
        System.out.print("Número:");
        String numero = Input.input.next();
        Input.input.nextLine();
        return new Telefone(numeroDeArea,numero);
    }

    public String getCodigoDeArea() {
        return codigoDeArea;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "+"+codigoDeArea +"-" + numero;
    }
}
