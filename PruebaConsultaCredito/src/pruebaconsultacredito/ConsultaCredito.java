/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaconsultacredito;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Super
 */
public class ConsultaCredito {

    private Scanner entrada;

    public void abrirArchivo() {
        try {

            entrada = new Scanner(new File("clientes.txt"));

        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo");
            System.exit(1);
        }
    }

    public String leerRegistros(OpcionMenu tipoLectura) {
        RegistroCuenta registro = new RegistroCuenta();
        String cadena = "";
        boolean concatena;

        try {
            while (entrada.hasNext()) {

                concatena = false;

                registro.setCuenta(entrada.nextInt());
                registro.setNombre(entrada.next());
                registro.setApellido(entrada.next());
                registro.setSaldo(entrada.nextDouble());

                switch (tipoLectura) {
                    case SALDO_CERO: {
                        if (registro.getSaldo() == 0) {
                            concatena = true;
                        }
                        break;
                    }
                    case SALDO_CREDITO: {
                        if (registro.getSaldo() < 0) {
                            concatena = true;
                        }
                        break;
                    }
                    case SALDO_DEBITO: {
                        if (registro.getSaldo() > 0) {
                            concatena = true;
                        }
                        break;
                    }
                }

                if (concatena) {
                    cadena = cadena.concat(String.format("Nº Cuenta: %d%nNombre: %s%nApellidos: %s%nSaldo: %.2f",
                            registro.getCuenta(),
                            registro.getNombre(),
                            registro.getApellido(),
                            registro.getSaldo()));

                    cadena = cadena.concat("\n");
                }
            }

        } catch (IllegalStateException illegalStateException) {
            System.err.println("No se ha podido leer el fichero");
            System.exit(1);
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("El archivo no está bien formado");
            System.exit(1);
        }

        return cadena;
    }

    public void cerrarArchivo() {
        entrada.close();

    }

}
