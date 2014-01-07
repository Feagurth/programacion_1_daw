/*
 * Copyright (C) 2014 Luis Cabrerizo Gómez
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package tirardado;

import java.util.Random;

/**
 * Clase para simular una tirada de dado y contabilizar estadísticas
 *
 * @author Luis Cabrerizo Gómez
 */
public class TirarDado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Objeto para generar números aleatorios
        Random numerosAleatorios = new Random();

        // Variables para almacenar los resultados
        int uno = 0;
        int dos = 0;
        int tres = 0;
        int cuatro = 0;
        int cinco = 0;
        int seis = 0;

        // Resultado de la tirada de dado
        int cara;

        for (int i = 0; i < 6000; i++) {

            cara = numerosAleatorios.nextInt(6) + 1;

            switch (cara) {
                case 1: {
                    uno++;
                    break;
                }
                case 2: {
                    dos++;
                    break;                    
                }
                case 3: {
                    tres++;
                    break;                    
                }
                case 4: {
                    cuatro++;
                    break;                    
                }
                case 5: {
                    cinco++;
                    break;                    
                }
                case 6: {
                    seis++;
                    break;                    
                }
            }
        }
        
        System.out.println("El número uno ha salido: " + (uno == 1 ? uno +" vez" : uno + " veces" ));
        System.out.println("El número dos ha salido: " + (dos == 1 ? dos +" vez" : dos + " veces" ));
        System.out.println("El número tres ha salido: " + (tres == 1 ? tres +" vez" : tres + " veces" ));
        System.out.println("El número cuatro ha salido: " + (cuatro == 1 ? cuatro +" vez" : cuatro + " veces" ));
        System.out.println("El número cinco ha salido: " + (cinco == 1 ? cinco +" vez" : cinco + " veces" ));
        System.out.println("El número seis ha salido: " + (seis == 1 ? seis +" vez" : seis + " veces" ));
        
        System.out.println("Cara\tFrecuencia");
        System.out.printf("1\t%d\n" + 
                "2\t%d\n" + 
                "3\t%d\n" + 
                "4\t%d\n" + 
                "5\t%d\n" + 
                "6\t%d\n",
                uno, dos, tres, cuatro, cinco, seis);
        
    }
}