/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaconsultacredito;

import java.util.Scanner;

/**
 *
 * @author Super
 */
public class PruebaConsultaCredito {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int operacion;
        ConsultaCredito fichero = new ConsultaCredito();

        do {            
            operacion = menu();

            switch (operacion) {
                case 1: {
                    fichero.abrirArchivo();
                    System.out.println(fichero.leerRegistros(OpcionMenu.SALDO_CERO));
                    fichero.cerrarArchivo();
                    break;
                }
                case 2: {
                    fichero.abrirArchivo();
                    System.out.println(fichero.leerRegistros(OpcionMenu.SALDO_CREDITO));
                    fichero.cerrarArchivo();
                    break;
                }
                case 3: {
                    fichero.abrirArchivo();
                    System.out.println(fichero.leerRegistros(OpcionMenu.SALDO_DEBITO));
                    fichero.cerrarArchivo();
                    break;
                }
            }

        } while (operacion != 4);

    }

    private static int menu() {
        Scanner entrada = new Scanner(System.in);
        int seleccion;

        do {
            System.out.println("---------------------------------");
            System.out.println("- 1.- Cuentas con saldo cero    -");
            System.out.println("- 2.- Cuentas con saldo credito -");
            System.out.println("- 3.- Cuentas con saldo débito  -");
            System.out.println("- 4.- Salir -");
            System.out.println("---------------------------------");
            System.out.print("Selecione una opcion: ");
            seleccion = entrada.nextInt();

        } while (seleccion < 1 || seleccion > 4);

        return seleccion;
    }

}
