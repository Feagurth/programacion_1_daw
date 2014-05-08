/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebaleerarchivotexto;

/**
 *
 * @author Super
 */
public class PruebaLeerArchivoTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LeerArchivoTexto leer = new LeerArchivoTexto();
        
        leer.abrirArchivo();
        leer.leerRegistros();
        leer.cerrarArchivo();
    }
    
}
