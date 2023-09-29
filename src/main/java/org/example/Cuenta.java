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

            saldo -= cantidad;
            System.out.println("Retirando "+cantidad);

    }
    public synchronized double getSaldo(){
        return this.saldo;
    }
}
