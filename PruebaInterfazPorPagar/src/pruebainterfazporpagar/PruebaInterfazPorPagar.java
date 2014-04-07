/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebainterfazporpagar;

/**
 *
 * @author Super
 */
public class PruebaInterfazPorPagar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PorPagar objetosPorPagar[] = new PorPagar[4];

        objetosPorPagar[0] = new Factura("12345", "Asiento", 2, 375.00);
        objetosPorPagar[1] = new Factura("23648", "Llanta", 4, 79.95);
        objetosPorPagar[2] = new EmpleadoAsalariado("Tomás", "Garcia", "111-11-1111", 800.00);
        objetosPorPagar[3] = new EmpleadoAsalariado("Ana", "Torres", "222-22-2222", 1200.00);

        System.out.println("Facturas y empleados procesados polilmórficamente\n");

        for (PorPagar porPagar : objetosPorPagar) {
            System.out.printf("%s%n%s: $%,.2f%n%n", porPagar.toString(), "Pago Vencido", porPagar.obtenerMontoPago());
        }

    }

}
