package org.example;

class HiloCliente implements Runnable {
    private Cuenta cuenta;
    private String tipoOperacion;
    private double cantidad;

    public HiloCliente(Cuenta cuenta, String tipoOperacion, double cantidad) {
        this.cuenta = cuenta;
        this.tipoOperacion = tipoOperacion;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        if (tipoOperacion.equals("depósito")) {
            cuenta.ingresar(cantidad);
        } else if (tipoOperacion.equals("retiro")) {
            cuenta.retirar(cantidad);
        }
    }
}