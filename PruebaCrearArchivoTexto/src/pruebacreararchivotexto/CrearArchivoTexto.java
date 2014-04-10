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
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CrearArchivoTexto {

    private Formatter salida;

    public void abrirArchivo() {
        try {
            salida = new Formatter("clientes.txt");

        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al crear el fichero");
            System.exit(1);
        }

    }

}
