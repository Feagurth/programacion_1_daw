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

package pruebaenum;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class Libro {
 
    public enum Libro{
        JHP6("Java How to Program 6e","2005"),
        CHTP4("C How to Program 4e","2004"),
        IW3HTP3("Internet & World Wide Web How to Program 3e","2004"),
        CPPHTP4("C++ How to Program 4e","2002"),
        VBHTP2("Visual Basic How to Program 2e","2002");    
        
        private final String titulo;
        private final String aCopyright;

        Libro(String titulo, String aCopyright) {
            this.titulo = titulo;
            this.aCopyright = aCopyright;
        }
        
        
        
        
    }
    
    
    
}
