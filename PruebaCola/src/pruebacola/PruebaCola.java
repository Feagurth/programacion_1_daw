/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebacola;

/**
 *
 * @author Super
 */
public class PruebaCola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cola miCola = new Cola();
        
        miCola.insertar(5);
        miCola.insertar(10);
        miCola.insertar(3);
        miCola.insertar(25);
        
        miCola.imprimir();
        
        System.out.printf("%nNúmero de Elementos: %d%n", miCola.cantidad());
        
        System.out.printf("%nElemento extraido: %d%n", miCola.extraer());
        
        miCola.imprimir();
        
        System.out.printf("%nNúmero de Elementos: %d%n", miCola.cantidad());
                               
    }
    
}
