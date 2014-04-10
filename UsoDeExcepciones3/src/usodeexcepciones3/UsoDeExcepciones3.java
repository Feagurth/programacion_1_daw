/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usodeexcepciones3;

/**
 *
 * @author Super
 */
public class UsoDeExcepciones3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            metodo1();
        } catch (Exception e) {
            System.out.printf("%s%n", e.getMessage());

            e.printStackTrace();
            
            System.out.println("\nRastreo de la pila de getStackTrace:");
            System.out.println("Archivo\tClase\tMétodo\tLinea");
            StackTraceElement[] elementosRastreo = e.getStackTrace();
            
            
            for (StackTraceElement elemento : elementosRastreo) {
                System.out.printf("%s\t", elemento.getFileName());
                        System.out.printf("%s\t", elemento.getClass());
                        System.out.printf("%s\t", elemento.getMethodName());
                        System.out.printf("%s\t%n", elemento.getFileName());
                        
                        
            }
        }
    }

    private static void metodo1() throws Exception {
        metodo2();
    }

    private static void metodo2() throws Exception {

        metodo3();

    }

    private static void metodo3() throws Exception {
        throw new Exception("La excepción se lanzó en el método 3");
    }

}
