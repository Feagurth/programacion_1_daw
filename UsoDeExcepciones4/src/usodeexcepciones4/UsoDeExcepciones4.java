/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usodeexcepciones4;

/**
 *
 * @author Super
 */
public class UsoDeExcepciones4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            metodo1();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private static void metodo1() throws Exception {

        try {
            metodo2();
        } catch (Exception e) {
            throw new Exception("La excepción se lanzó en el método 1", e);
        }
    }

    private static void metodo2() throws Exception {
        try {
            metodo3();
        } catch (Exception e) {
            throw new Exception("Excepción lanzada en el método 2", e);
        }
    }

    private static void metodo3() throws Exception {
        throw new Exception("La excepción se lanzo en el método 3");

    }

}
