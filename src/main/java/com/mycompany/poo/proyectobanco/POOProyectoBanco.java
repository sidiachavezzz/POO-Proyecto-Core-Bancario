package com.mycompany.poo.proyectobanco;

public class POOProyectoBanco {

    public static void main(String[] args) {
        System.out.println("=== INICIO DE PRUEBAS DEL SISTEMA BANCARIO ===");

        // Instancia para pruebas 1 y 2
        CuentaBancaria miCuenta = new CuentaBancaria("ACC-001", "Ana Perez", 5000.0);

        // 1. Prueba de Encapsulamiento:
        // (Si quitas las barras "//" de abajo, NetBeans marcará error porque 'saldo' es private)
        // miCuenta.saldo = 50000; 

        // 2. Acceso Directo a Atributos Públicos:
        System.out.println("\n--- Prueba Atributos Publicos ---");
        System.out.println("Titular (directo): " + miCuenta.titular);
        System.out.println("Numero de Cuenta (directo): " + miCuenta.numeroCuenta);

        // 3. Prueba de CuentaAhorro (4 retiros consecutivos para evidenciar comisión):
        System.out.println("\n--- Prueba Cuenta Ahorro (4 Retiros) ---");
        CuentaAhorro cuentaAhorro = new CuentaAhorro("AH-999", "Carlos Ruiz", 3000.0, 5.0);
        cuentaAhorro.retirarConComision(100.0); // Retiro 1
        cuentaAhorro.retirarConComision(100.0); // Retiro 2
        cuentaAhorro.retirarConComision(100.0); // Retiro 3
        cuentaAhorro.retirarConComision(100.0); // Retiro 4 (Aplica comisión de L. 20)

        // 4. Rendimiento de Ahorro:
        System.out.println("\n--- Prueba Rendimiento de Ahorro ---");
        cuentaAhorro.aplicarInteresMensual();

        // 5. Prueba de CuentaCorriente (Retirar usando saldo y sobregiro + 3%):
        System.out.println("\n--- Prueba Cuenta Corriente (Sobregiro) ---");
        CuentaCorriente cuentaCorriente = new CuentaCorriente("CC-777", "Empresa S.A.", 1000.0, "Tech Solutions", 5000.0);
        cuentaCorriente.retirarConSobregiro(3500.0);

        // 6. Amortización de Deuda:
        System.out.println("\n--- Prueba Amortizacion de Deuda ---");
        cuentaCorriente.pagarSobregiro(1500.0);
        cuentaCorriente.mostrarDatos();
        
        System.out.println("\n=== FIN DE LAS PRUEBAS ===");
    }
}