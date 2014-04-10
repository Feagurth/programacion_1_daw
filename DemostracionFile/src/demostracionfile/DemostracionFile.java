/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demostracionfile;

import java.util.Scanner;

/**
 * 
 * @author Super
 */
public class DemostracionFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String ruta;
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Introduzca la ruta a analizar: ");
        ruta = entrada.nextLine();
        
        
        UsoClaseFile fichero = new UsoClaseFile();
        fichero.analizarRuta(ruta);
    }
    
}
