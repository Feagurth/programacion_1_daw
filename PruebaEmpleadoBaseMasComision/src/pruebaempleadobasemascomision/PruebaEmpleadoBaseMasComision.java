/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebaempleadobasemascomision;

/**
 *
 * @author Super
 */
public class PruebaEmpleadoBaseMasComision {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmpleadoPorComision empleadoPorComision = 
                new EmpleadoPorComision("Jorge", "Lopez", "22222-2222", 10000, 0.6);
        
        EmpleadoBaseMasComision empleadoBaseMasComision = 
                new EmpleadoBaseMasComision("Marta", "Sanchez", "333-33-3333", 5000, .04, 300);
        
        System.out.printf("%s\n\n", empleadoPorComision.toString());
        
        System.out.printf("%s\n", empleadoBaseMasComision.toString());
        
        
    }
    
}
