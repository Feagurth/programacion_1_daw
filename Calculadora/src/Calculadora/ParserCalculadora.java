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
package Calculadora;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class ParserCalculadora {

    public static String parser(String cadena) {

        BigDecimal numero1 = BigDecimal.ZERO;

        int pos1;
        int pos2 = 0;
        int pos3 = 0;

        String operaciones[] = {"(", ")", "S", "C", "T", "*", "/", "+", "-"};

        cadena = cadena.replace(" ", "");

        cadena = transformarFunciones(cadena);

        ArrayList valor = cadenaALista(cadena, operaciones);

        do {
            for (String operacion : operaciones) {

                do {
                    if (valor.contains(operacion)) {

                        switch (operacion) {
                            case "(": {

                                pos1 = valor.lastIndexOf(operacion);
                                pos2 = pos1;
                                pos3 = pos1 + 1 + buscarOperacion(valor.subList(pos1 + 1, valor.size()), new String[]{")"}, true);

                                numero1 = new BigDecimal(parser(listaACadena(valor.subList(pos2 + 1, pos3))));

                                break;
                            }
                            case "T":
                            case "C":
                            case "S": {
                                pos1 = valor.indexOf(operacion);
                                pos2 = pos1;
                                pos3 = pos1 + buscarOperacion(valor.subList(pos1 + 1, valor.size()), operaciones, true);

                                double numero = Double.valueOf(valor.get(pos3).toString());

                                switch (operacion) {
                                    case "S": {
                                        numero = Math.sin(Math.toRadians(numero));
                                        break;
                                    }
                                    case "C": {
                                        numero = Math.cos(Math.toRadians(numero));
                                        break;
                                    }
                                    case "T":
                                    {
                                        numero = Math.tan(Math.toRadians(numero));
                                        break;
                                    
                                    }

                                }
                                numero1 = new BigDecimal(numero);

                                break;
                            }
                            case "+": {
                                pos1 = valor.indexOf(operacion);
                                pos2 = buscarOperacion(valor.subList(0, pos1), operaciones, false) + 1;
                                pos3 = pos1 + buscarOperacion(valor.subList(pos1 + 1, valor.size()), operaciones, true);

                                numero1 = new BigDecimal(valor.get(pos2).toString());
                                numero1 = numero1.add(new BigDecimal(valor.get(pos3).toString()));
                                break;
                            }
                            case "-": {
                                pos1 = valor.indexOf(operacion);
                                pos2 = buscarOperacion(valor.subList(0, pos1), operaciones, false) + 1;
                                pos3 = pos1 + buscarOperacion(valor.subList(pos1 + 1, valor.size()), operaciones, true);

                                numero1 = new BigDecimal(valor.get(pos2).toString());
                                numero1 = numero1.subtract(new BigDecimal(valor.get(pos3).toString()));
                                break;
                            }
                            case "*": {
                                pos1 = valor.indexOf(operacion);
                                pos2 = buscarOperacion(valor.subList(0, pos1), operaciones, false) + 1;
                                pos3 = pos1 + buscarOperacion(valor.subList(pos1 + 1, valor.size()), operaciones, true);

                                numero1 = new BigDecimal(valor.get(pos2).toString());
                                numero1 = numero1.multiply(new BigDecimal(valor.get(pos3).toString()));
                                break;
                            }
                            case "/": {
                                pos1 = valor.indexOf(operacion);
                                pos2 = buscarOperacion(valor.subList(0, pos1), operaciones, false) + 1;
                                pos3 = pos1 + buscarOperacion(valor.subList(pos1 + 1, valor.size()), operaciones, true);

                                numero1 = new BigDecimal(valor.get(pos2).toString());
                                numero1 = numero1.divide(new BigDecimal(valor.get(pos3).toString()), 10, RoundingMode.HALF_DOWN);
                                break;
                            }
                        }

                        valor.set(pos2, numero1.stripTrailingZeros().toString());
                        valor.subList(pos2 + 1, pos3 + 1).clear();
                        valor.trimToSize();

                    }
                } while (valor.contains(operacion));
            }
        } while (!Collections.disjoint(valor, Arrays.asList(operaciones)));

        numero1 = new BigDecimal(valor.get(0).toString());
        numero1 = numero1.divide(BigDecimal.ONE, 10, RoundingMode.DOWN);

        return numero1.stripTrailingZeros().toPlainString();
    }

    private static String listaACadena(List lista) {
        String cadena = "";

        for (Object object : lista) {
            cadena = cadena.concat(object + "");
        }

        return cadena;
    }

    private static ArrayList cadenaALista(String valor, String[] operaciones) {
        ArrayList<String> chars = new ArrayList<>();
        String cadena = "";
        for (char c : valor.toCharArray()) {
            if (Arrays.asList(operaciones).contains(c + "")) {

                if (!cadena.equals("")) {
                    chars.add(cadena);
                }

                cadena = "";
                chars.add(c + "");
            } else {
                cadena = cadena.concat(c + "");
            }
        }
        if (!cadena.equals("")) {
            chars.add(cadena);
        }
        return chars;
    }

    private static int buscarOperacion(List valores, String[] operaciones, boolean izqDer) {
        int salida = (izqDer ? valores.size() : 0);

        for (String operacion : operaciones) {

            if (!izqDer) {
                if (salida < valores.lastIndexOf(operacion)) {
                    salida = valores.lastIndexOf(operacion);
                }
            } else {
                if (valores.indexOf(operacion) != -1) {
                    if (salida > valores.indexOf(operacion)) {

                        salida = valores.indexOf(operacion);
                    }
                }
            }

        }

        return (salida == 0 ? -1 : salida);
    }

    private static String transformarFunciones(String cadena) {
        String salida = cadena;

        salida = salida.replace("Sin", "S");
        salida = salida.replace("Cos", "C");
        salida = salida.replace("Tan", "T");

        return salida;
    }

}
