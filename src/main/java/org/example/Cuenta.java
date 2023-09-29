package org.example;

public class Cuenta {
    double saldo;
    public Cuenta(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized void ingresar(double cantidad){
        System.out.println("Ingresando "+cantidad);
        this.saldo+=cantidad;
    }
    public synchronized void retirar(double cantidad){
        if (saldo >= cantidad) {
            saldo -= cantidad;
            System.out.println("Retirando "+cantidad);
        } else {
            System.out.println("Saldo insuficiente para retirar " + cantidad + " euros.");
        }
    }
    public synchronized double getSaldo(){
        return this.saldo;
    }
}
