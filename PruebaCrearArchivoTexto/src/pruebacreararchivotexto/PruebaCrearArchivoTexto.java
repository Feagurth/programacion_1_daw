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
public class PruebaCrearArchivoTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CrearArchivoTexto aplicacion = new CrearArchivoTexto();
        
        aplicacion.abrirArchivo();
        
        aplicacion.agregarRegistro();
        
        aplicacion.cerrarArchivo();
        
        

    }

}
