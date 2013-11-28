/*
 * Copyright (C) 2013 Luis Cabrerizo Gómez
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

package pruebalibrocalificaciones;

import java.util.Scanner;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class LibroCalificaciones 
{
    private String nombreCruso;

    public LibroCalificaciones(String nombre)
    {
        this.nombreCruso = nombre;
    }
    
    public void establecerNombreCurso(String nombre)
    {
        nombreCruso = nombre;
    }

    public String obtenerNombreCurso()
    {
        return nombreCruso;
    }
    
    public void mensajeDeSalida(String Curso)
    {
        System.out.printf("Bienvenido al libro de calificaciones para\n%s!\n", 
                obtenerNombreCurso());
    }    
    
    public void CalcularPromedios()
    {
        Scanner entrada = new Scanner(System.in);
        
        int total, contadorCalif, calificacion, suspensos, aprobados;
        double promedio;
        
        total = 0;
        suspensos = 0;
        aprobados = 0;
        contadorCalif = 1;
        
        
        System.out.print("Escribe la calificación: ");
        calificacion = entrada.nextInt();
        
        while (calificacion != -1) 
        {            
            total = total + calificacion;
            contadorCalif++;

            if(calificacion < 5)
            {
                suspensos++;
            }
            else
            {
                aprobados++;
            }
            
            
            System.out.print("Escribe la calificación: ");
            calificacion = entrada.nextInt();
        }

        
        if(contadorCalif!=0)
        {
            promedio = (double)total / 10;
        
            System.out.println("El total de las 10 calificaciones es: " + total);
            System.out.println("El promedio de las 10 calificaciones es: " + promedio);
            System.out.println("El número de aprobados es de: " + aprobados);
            System.out.println("El número de suspensos es de: " + suspensos);
        }
    }

    


}
