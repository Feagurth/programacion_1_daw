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
package pruebastiempo;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class Tiempo {

    private int hora;
    private int minuto;
    private int segundo;

    public void establecerTiempo(int h, int m, int s) {
        this.hora = ((h > 0 & h < 24) ? h : 0);
        this.minuto = ((m > 0 & m < 60) ? m : 0);
        this.segundo = ((s > 0 & s < 60) ? s : 0);
    }

    public String aStringUniversal() {
        return String.format("%02d:%02d:%02d", this.hora,
                this.minuto, this.segundo);
    }

    @Override
    public String toString() {
        return String.format("%d:%02d:%02d %s",
                ((this.hora == 0 || this.hora == 12 ? 12 : this.hora % 12)),
                this.minuto,
                this.segundo,
                (this.hora < 12 ? "AM" : "PM"));
    }

}
