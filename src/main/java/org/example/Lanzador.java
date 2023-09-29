package org.example;


public class Lanzador {
    public static void main(String[] args) {

        int numThreads = 2400; // Número total de hilos para todas las operaciones
        Thread[] threads = new Thread[numThreads];
        Cuenta cuenta = new Cuenta(10000);


        // Crear y arrancar hilos para depósitos de 100 euros (x400)
        for (int i = 0; i < 400; i++) {
            threads[i] = new Thread(new HiloCliente(cuenta, "depósito", 100));
            threads[i].start();
        }

        // Crear y arrancar hilos para depósitos de 50 euros (x200)
        for (int i = 400; i < 600; i++) {
            threads[i] = new Thread(new HiloCliente(cuenta, "depósito", 50));
            threads[i].start();
        }

        // Crear y arrancar hilos para depósitos de 20 euros (x600)
        for (int i = 600; i < 1200; i++) {
            threads[i] = new Thread(new HiloCliente(cuenta, "depósito", 20));
            threads[i].start();
        }

        // Crear y arrancar hilos para retiros de 100 euros (x400)
        for (int i = 1200; i < 1600; i++) {
            threads[i] = new Thread(new HiloCliente(cuenta, "retiro", 100));
            threads[i].start();
        }

        for (int i = 1600; i < 1800; i++) {
            threads[i] = new Thread(new HiloCliente(cuenta, "retiro", 50));
            threads[i].start();
        }
        for (int i = 1800; i < 2400; i++) {
            threads[i] = new Thread(new HiloCliente(cuenta, "retiro", 20));
            threads[i].start();
        }





        for (Thread thread : threads) {
            try {
                thread.join(); // Espera a que todos los hilos terminen
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        double saldoFinal = cuenta.getSaldo();
        System.out.println("Saldo final: " + saldoFinal);

        if (saldoFinal == 10000) {
            System.out.println("La simulación ha funcionado correctamente.");
        } else {
            System.out.println("La simulación ha fallado. El saldo final no es 10,000 euros.");
        }
    }
}