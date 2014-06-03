/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebapila;

/**
 *
 * @author Super
 */
public class PruebaPila {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pila miPila = new Pila();

        System.out.printf("Estado de la pila: %s%n", (miPila.vacia()? "Vacia": "Con elementos"));
        
        miPila.insertar(10);
        miPila.insertar(100);
        miPila.insertar(50);
        miPila.insertar(678);

        miPila.imprimir();

        System.out.printf("Primer registro: %d%n", miPila.retornar());
        System.out.printf("Número de elementos de la pila: %d%n", miPila.cantidad());
        System.out.printf("Elemento extraido: %d%n", miPila.extraer());
        miPila.imprimir();
      
        System.out.printf("Número de elementos de la pila: %d%n", miPila.cantidad());
        
        System.out.printf("Primer registro: %d%n", miPila.retornar());
        
        System.out.printf("Número de elementos de la pila: %d%n", miPila.cantidad());

    }

}
