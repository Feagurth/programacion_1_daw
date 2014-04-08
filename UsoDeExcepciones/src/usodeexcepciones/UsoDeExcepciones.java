/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usodeexcepciones;

/**
 *
 * @author Super
 */
public class UsoDeExcepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            lanzaExcepcion();
        } catch (Exception excepcion) {
            System.err.println("La excepción se maneja en el método main");
        }
        noLanzaExcepcion();
    }

    private static void lanzaExcepcion() throws Exception {
        try {
            System.out.println("Método lanzaExcepcion");

            throw new Exception();

        } catch (Exception excepcion) {
            System.err.println("La excepción se maneja en el método lanzaExcepción");
            throw excepcion;
        }
    }

    private static void noLanzaExcepcion() {
        try {
            System.out.println("Método noLanzaExcepcion");

            throw new Exception();

        } catch (Exception excepcion) {
            System.err.println("La excepción se maneja en el método noLanzaExcepcion");
        } finally {
            System.err.println("Se ejecutó finally en noLanzaExcepcion");
        }
        System.out.println("Fin del método noLanzaExcepcion");
    }

}
