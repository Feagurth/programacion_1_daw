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
package pruebatiempo2;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class Tiempo {

    private int hora;
    private int minuto;
    private int segundo;

    public Tiempo() {

        this(0, 0, 0);
    }

    public Tiempo(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public Tiempo(int hora) {
        this(hora, 0, 0);
    }

    public Tiempo(int hora, int minuto) {
        this(hora, minuto, 0);
    }

    public void establecerHora(int h) {
        this.hora = (h >= 0 && h <= 24) ? h : 0;
    }

    public void establecerMinutos(int m) {
        this.minuto = (m >= 0 && m < 60) ? m : 0;
    }

    public void setSegundo(int s) {
        this.segundo = (s >= 0 && s < 60) ? s : 0;
    }

    public int obtenerHora() {
        return this.hora;
    }

    public int obtenerMinuto() {
        return this.minuto;
    }

    public int obtenerSegundo() {
        return this.segundo;
    }

    public String aStringUniversal() {
        return String.format("%02d:%02d:%02d", obtenerHora(), obtenerMinuto(),
                obtenerSegundo());

    }

    @Override
    public String toString() {

        return String.format("%d:%02d:%02d %s",
                (((obtenerHora() == 0) || obtenerHora() == 12) ? 12 : obtenerHora() % 12), 
                obtenerMinuto(), obtenerSegundo(), 
                obtenerHora() < 12 ? "AM" : "PM"
        );
    }

}
