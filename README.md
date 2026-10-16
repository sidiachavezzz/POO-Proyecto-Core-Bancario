# Proyecto: Sistema Bancario en Java

Este proyecto corresponde a la tarea de Programación Orientada a Objetos. Es un sistema de gestión bancaria desarrollado en NetBeans con Maven, usando herencia, encapsulamiento y la lógica.

## Estructura del Código

El código se encuentra organizado bajo el paquete `com.mycompany.poo.proyectobanco` y se compone de las siguientes clases:

1. *CuentaBancaria.java (Clase Base)*
   - Administra los datos generales de la cuenta, tales como el número y el titular.
   - Protege el saldo mediante encapsulamiento estricto (private) para evitar modificaciones indebidas.
   - Contiene los métodos fundamentales para realizar depósitos, retiros y visualización de datos.

2. *CuentaAhorro.java (Subclase)*
   - Extiende de la clase CuentaBancaria.
   - Controla el registro de retiros mensuales y aplica de forma automática la comisión correspondiente al exceder el límite permitido.
   - Calcula el rendimiento por intereses mensuales.

3. *CuentaCorriente.java (Subclase)*
   - Extiende de la clase CuentaBancaria.
   - Gestiona el límite de sobregiro y calcula el cargo por servicio sobre los montos utilizados.
   - Permite efectuar pagos y abonos para la amortización de la deuda de sobregiro.

4. *POOProyectoBanco.java (Clase Principal / Main)*
   - Contiene el método principal donde se ejecutan las pruebas prácticas para comprobar el funcionamiento correcto de las transacciones y validaciones por consola.

---

## Pasos para la Ejecución

1. **Paso 1:** Descargar o clonar este repositorio en el equipo local.
2. **Paso 2:** Abrir el entorno *NetBeans IDE*.
3. **Paso 3:** Importar el proyecto dentro del espacio de trabajo.
4. **Paso 4:** Localizar el archivo principal denominado `POOProyectoBanco.java` dentro del paquete `com.mycompany.poo.proyectobanco`.
5. **Paso 5:** Hacer clic derecho sobre el archivo y seleccionar Run File para visualizar los resultados de las pruebas en la consola.
