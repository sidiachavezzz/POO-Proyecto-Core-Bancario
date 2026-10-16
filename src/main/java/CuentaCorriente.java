package com.mycompany.poo.proyectobanco;

public class CuentaCorriente extends CuentaBancaria {
    public String nombreEmpresa;
    private double limiteSobregiro;
    private double sobregiroUtilizado;

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial, String nombreEmpresa, double limiteSobregiro) {
        super(numeroCuenta, titular, saldoInicial);
        this.nombreEmpresa = nombreEmpresa;
        this.limiteSobregiro = limiteSobregiro;
        this.sobregiroUtilizado = 0.0;
    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public double getSobregiroUtilizado() {
        return sobregiroUtilizado;
    }

    public boolean retirarConSobregiro(double monto) {
        if (monto <= 0) {
            System.out.println("Monto invalido.");
            return false;
        }

        if (getSaldo() >= monto) {
            return super.retirar(monto);
        } else {
            double creditoDisponible = limiteSobregiro - sobregiroUtilizado;
            double saldoDisponibleTotal = getSaldo() + creditoDisponible;

            if (monto <= saldoDisponibleTotal) {
                double falta = monto - getSaldo();
                if (getSaldo() > 0) {
                    super.retirar(getSaldo());
                }
                double cargoServicio = falta * 0.03;
                sobregiroUtilizado += (falta + cargoServicio);
                System.out.println("Retiro con sobregiro exitoso. Cargo del 3% aplicado.");
                return true;
            } else {
                System.out.println("Error: Excede el limite de sobregiro.");
                return false;
            }
        }
    }

    public void pagarSobregiro(double monto) {
        if (monto <= 0) {
            System.out.println("Monto invalido.");
            return;
        }

        if (sobregiroUtilizado > 0) {
            if (monto >= sobregiroUtilizado) {
                double sobrante = monto - sobregiroUtilizado;
                sobregiroUtilizado = 0.0;
                if (sobrante > 0) {
                    depositar(sobrante);
                }
                System.out.println("Sobregiro pagado por completo.");
            } else {
                sobregiroUtilizado -= monto;
                System.out.println("Abono aplicado. Deuda restante: L. " + sobregiroUtilizado);
            }
        } else {
            depositar(monto);
        }
    }
}