/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demostracionfile;

import java.io.File;

/**
 *
 * @author Super
 */
public class UsoClaseFile {

    public void analizarRuta(String ruta) {
        File nombre = new File(ruta);

        if(nombre.exists())
        {
            System.out.printf("Nombre: %s%n"
                    + "EsFichero: %s%n"
                    + "Es Directorio: %s%n"
                    + "Es Absoluta: %s%n"
                    + "Ultima Modificación: %s%n"
                    + "Longitud: %s%n"
                    + "Path: %s%n"
                    + "Path Absoluto: %s%n"
                    + "Padre: %s%n", 
                    nombre.getName(), 
                    nombre.isFile() ? "Si" : "No", 
                    nombre.isDirectory() ? "Si" : "No", 
                    nombre.isAbsolute() ? "Si" : "No",
                    nombre.lastModified(), 
                    nombre.length(), 
                    nombre.getPath(), 
                    nombre.getAbsolutePath(), 
                    nombre.getParent());
        }
        else
        {
            System.out.printf("La ruta %s no existe", ruta);
        }
        
    }

}
