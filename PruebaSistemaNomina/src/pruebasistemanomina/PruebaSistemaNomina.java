/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasistemanomina;

/**
 *
 * @author Super
 */
public class PruebaSistemaNomina {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmpleadoAsalariado asalariado = new EmpleadoAsalariado(
                "Rudy", "Mentario", "111-11-1111", 800.00);

        EmpleadoPorHoras horas = new EmpleadoPorHoras(
                "Carmelo", "Cotón", "222-22-2222", 16.75, 40);

        EmpleadoPorComision comision = new EmpleadoPorComision(
                "Carmen", "Opausia", "333-33-3333", 10000, 0.06);

        EmpleadoBaseMasComision base = new EmpleadoBaseMasComision(
                "Josechu", "Letón", "444-44-4444", 300, 5000, 0.04);

        System.out.println(asalariado.toString());
        System.out.println("Ingresos: " + asalariado.ingresos());
        System.out.println("");

        System.out.println(horas.toString());
        System.out.println("Ingresos: " + horas.ingresos());
        System.out.println("");

        System.out.println(comision.toString());
        System.out.println("Ingresos: " + comision.ingresos());
        System.out.println("");

        System.out.println(base.toString());
        System.out.println("Ingresos: " + base.ingresos());
        System.out.println("");

        System.out.println("---------------------");
        System.out.println("---------------------");
        System.out.println("---------------------");
        System.out.println("");

        Empleado empleados[] = new Empleado[4];

        empleados[0] = asalariado;
        empleados[1] = horas;
        empleados[2] = comision;
        empleados[3] = base;

        for (Empleado empleadoActual : empleados) {
            if (empleadoActual instanceof EmpleadoBaseMasComision) {
                EmpleadoBaseMasComision empleado = (EmpleadoBaseMasComision) empleadoActual;
                double salarioBaseAnterior = empleado.getSalarioBase();
                empleado.setSalarioBase(salarioBaseAnterior * 1.10);
                System.out.println("Salario Base Anterior: " + salarioBaseAnterior);
                System.out.println("Salario Base Actual: " + empleado.getSalarioBase());
            }
            System.out.println("Ingresos: " + empleadoActual.ingresos());
        }

        for (int i = 0; i < empleados.length; i++) {
            System.out.printf("El empleado %d es un %s%n",
                    (i + 1), empleados[i].getClass().getName());

        }

    }
}
