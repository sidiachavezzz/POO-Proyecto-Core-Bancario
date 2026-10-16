package com.mycompany.poo.proyectobanco;

public class CuentaAhorro extends CuentaBancaria {
    public double tasaInteresAnual;
    private int retirosRealizadosMes;
    private double comisionPorExceso;

    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, double tasaInteresAnual) {
        super(numeroCuenta, titular, saldoInicial);
        this.tasaInteresAnual = tasaInteresAnual;
        this.retirosRealizadosMes = 0;
        this.comisionPorExceso = 20.0;
    }

    public boolean retirarConComision(double monto) {
        double montoTotal = monto;
        if (retirosRealizadosMes >= 3) {
            montoTotal += comisionPorExceso;
            System.out.println("Aviso: Supero los 3 retiros. Se aplica comision de L. " + comisionPorExceso);
        }
        
        boolean exito = super.retirar(montoTotal);
        if (exito) {
            retirosRealizadosMes++;
        }
        return exito;
    }

    public void aplicarInteresMensual() {
        double interes = (getSaldo() * (tasaInteresAnual / 100)) / 12;
        depositar(interes);
        System.out.println("Interes mensual aplicado: L. " + interes);
    }
}