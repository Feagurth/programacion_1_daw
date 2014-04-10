/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package usodeexcepciones2;

/**
 *
 * @author Super
 */
public class UsoDeExcepciones2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            lanzaExcepcion();
        } catch (Exception e) {
            System.err.println("La excepción se manejó en main");
        }        
    }

    private static void lanzaExcepcion() throws Exception{
        try {
            System.out.println("Método lanzaExcepcion");
            throw new Exception();
        } catch (RuntimeException exception) {
            System.err.println("La excepción se maneja en lanzaExcepcion");
        }
        finally
        {
            System.err.println("Finally lanzaExcepcion");
        }        
    }    
}
