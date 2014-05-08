/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebacreararchivotexto;

/**
 *
 * @author Super
 */
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

public class CrearArchivoTexto {

    private Formatter salida;

    public void abrirArchivo() {
        try {
            salida = new Formatter("clientes.txt");

        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al crear el fichero");
            System.exit(1);
        } catch (SecurityException securityException) {
            System.err.println("No tienes permisos de escritura");
            System.exit(1);
        }

    }

    public void agregarRegistro() {
        RegistroCuenta registro = new RegistroCuenta();
        String cuenta, nombre, apellidos, saldo;

        int respuesta = JOptionPane.YES_OPTION;

        try {
            while (respuesta == JOptionPane.YES_OPTION) {
                cuenta = JOptionPane.showInputDialog(null,
                        "Introducza el número de cuenta", "Petición de datos",
                        JOptionPane.QUESTION_MESSAGE);

                nombre = JOptionPane.showInputDialog(null,
                        "Introducza el nombre", "Petición de datos",
                        JOptionPane.QUESTION_MESSAGE);

                apellidos = JOptionPane.showInputDialog(null,
                        "Introducza los apellidos", "Petición de datos",
                        JOptionPane.QUESTION_MESSAGE);

                saldo = JOptionPane.showInputDialog(null,
                        "Introducza el saldo de cuenta", "Petición de datos",
                        JOptionPane.QUESTION_MESSAGE);

                registro.setCuenta(Integer.parseInt(cuenta));
                registro.setNombre(nombre);
                registro.setApellido(apellidos);
                registro.setSaldo(Double.parseDouble(saldo));

                salida.format("%d %s %s %.2f %n",
                        registro.getCuenta(),
                        registro.getNombre(),
                        registro.getApellido(),
                        registro.getSaldo());

                respuesta = JOptionPane.showConfirmDialog(null,
                        "¿Desea seguir introduciendo datos?",
                        "Continuar", JOptionPane.YES_OPTION);

            }

        } catch (FormatterClosedException formatterClosedException) {
            System.err.println("Error al escribir el fichero");
            System.exit(1);
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Error al crear el fichero");
            System.exit(1);
        }

    }

    public void cerrarArchivo() {
        if (salida != null) {
            salida.close();
        }

    }

}
