/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebaleerarchivotexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Super
 */
public class LeerArchivoTexto {
    
    private Scanner entrada;
    
    
    public void abrirArchivo()
    {
        try {
            
            entrada = new Scanner(new File("clientes.txt"));
       
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo");
            System.exit(1);
        }
    }
    
    public void leerRegistros()
    {
        RegistroCuenta registro = new RegistroCuenta();
        String salida;
        
        try {
            while (entrada.hasNext()) {                
                registro.setCuenta(entrada.nextInt());
                registro.setNombre(entrada.next());
                registro.setApellido(entrada.next());
                registro.setSaldo(entrada.nextDouble());

                salida = String.format("Nº Cuenta: %d%nNombre: %s%nApellidos: %s%nSaldo: %.2f", 
                        registro.getCuenta(), 
                        registro.getNombre(), 
                        registro.getApellido(), 
                        registro.getSaldo());
                
                JOptionPane.showMessageDialog(null, salida, "Registro", JOptionPane.INFORMATION_MESSAGE);
                
                
            }
            
            
        } catch (IllegalStateException illegalStateException) {
            System.err.println("No se ha podido leer el fichero");
            System.exit(1);
        }
        catch(NoSuchElementException noSuchElementException)
        {
            System.err.println("El archivo no está bien formado");
            System.exit(1);
        }
        
        
    
    
    }
    
    
    public void cerrarArchivo()
    {
        entrada.close();
        System.exit(0);
        
    }
    
    
}
