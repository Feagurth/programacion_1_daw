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
package RelacionesDeEjercicios.Relacion5;

import Utiles.Mensajes;
import java.awt.Dimension;

/**
 * Completar el ejercicio de sistemas de cuentas por pagar visto en clase, 
 * teniendo en cuenta:
 *        a. La aplicación debe procesar un objeto de cada uno de las cuatro 
 *        subclases de Empleado.
 *        b. Si el objeto que se está procesando en un momento dado es 
 *        EmpleadoBaseMasComision, la aplicación debe incrementar el salario 
 *        base del Empleado por un 10%
 *        c. La aplicación debe de imprimir el monto del pago de cada objeto.
 *        d. Modifica las clases EmpleadoPorHoras y EmpleadoPorComision para 
 *        colocarlas en la jerarquía PorPagar. [Sugerencia: cambia el nombre 
 *        del método ingresos a obtenerMontoPago en cada subclase, de manera 
 *        que la clase cumpla con lo heredado de la interfaz PorPagar]
 *        e. Modifica la clase EmpleadoBaseMasComision, de tal forma que 
 *        extienda la clase EmpleadoPorComision
 *        f. Modifica PruebaInterfazPorPagar para procesar mediante polimorfismo
 *        dos objetos Factura, un EmpleadoAsalariado, un EmpleadoPorHoras, un 
 *        EmpleadoPorComision y un EmpleadoBaseMasComision. Primero imprime 
 *        una representación de cadena de cada objeto PorPagar. Después, si un 
 *        objeto es un EmpleadoBaseMasComision, aumenta su salario por un 10%. 
 *        Por último, imprime el monto del pago por cada objeto PorPagar
 * 
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio003 {

    /**
     * Interfaz para las clases empleado
     */
    public interface PorPagar {

        /**
         * Método para obtener el monto del pago de los empleados
         *
         * @return
         */
        double obtenerMontoPago();

    }

    /**
     * Clase abstracta empleado
     */
    public abstract class Empleado implements PorPagar {

        // Variables de clase
        private String primerNombre;
        private String apellidoPaterno;
        private String numeroSeguroSocial;

        /**
         * Método que nos permite recupera el nombre del empleado
         *
         * @return El nombre del empleado
         */
        public String getPrimerNombre() {
            return primerNombre;
        }

        /**
         * Método que nos permite asignar el nombre del empleado
         *
         * @param primerNombre
         */
        public void setPrimerNombre(String primerNombre) {
            this.primerNombre = primerNombre;
        }

        /**
         * Método que nos permite recuperar el primer apellido del empleado
         *
         * @return El primer apellido del empleado
         */
        public String getApellidoPaterno() {
            return apellidoPaterno;
        }

        /**
         * Método que nos permite asignar el primer apellido del empleado
         *
         * @param apellidoPaterno El primer apellido del empleado
         */
        public void setApellidoPaterno(String apellidoPaterno) {
            this.apellidoPaterno = apellidoPaterno;
        }

        /**
         * Método que nos permite recuperar el número de la Seguridad Social del
         * empleado
         *
         * @return El número de la Seguridad Social del empleado
         */
        public String getNumeroSeguroSocial() {
            return numeroSeguroSocial;
        }

        /**
         * Método que nos permite asignar el número de la seguridad social de un
         * empleado
         *
         * @param numeroSeguroSocial Número de la Seguridad Social de un
         * empleado
         */
        public void setNumeroSeguroSocial(String numeroSeguroSocial) {
            this.numeroSeguroSocial = numeroSeguroSocial;
        }

        /**
         * Constructor de la clase empleado
         *
         * @param primerNombre Nombre del empleado
         * @param apellidoPaterno Primer apellido del empleado
         * @param numeroSeguroSocial Número de la Seguridad Social del empleado
         */
        public Empleado(String primerNombre, String apellidoPaterno, String numeroSeguroSocial) {
            this.primerNombre = primerNombre;
            this.apellidoPaterno = apellidoPaterno;
            this.numeroSeguroSocial = numeroSeguroSocial;
        }

        /**
         * Método que nos permite obtener la cantidad a pagar del empleado
         *
         * @return
         */
        @Override
        public abstract double obtenerMontoPago();

        /**
         * Método que nos devuelve los valores contenidos dentro del objeto
         * Empleado
         *
         * @return Una cadena conteniendo los valores del objeto creado
         */
        @Override
        public String toString() {
            return String.format("Nombre: %s %s%nNúmero de Seguro Social: %s",
                    getPrimerNombre(), getApellidoPaterno(), getNumeroSeguroSocial());
        }
    }

    /**
     * Clase para definir un empleado asalariado
     */
    public class EmpleadoAsalariado extends Empleado {

        // Variables de instancia
        private double salarioSemanal;

        /**
         * Método que nos permite recuperar el salario semanal de un trabajador
         * asalariado
         *
         * @return El salario mensual del trabajador
         */
        public double getSalarioSemanal() {
            return salarioSemanal;
        }

        /**
         * Método que nos permite asignar un salario semanal a un trabajador
         *
         * @param salarioSemanal
         */
        public final void setSalarioSemanal(double salarioSemanal) {
            this.salarioSemanal = salarioSemanal < 0.0 ? 0 : salarioSemanal;
        }

        /**
         * Constructor de la clase EmpleadoAsalariado
         *
         * @param primerNombre Nombre del empleado
         * @param apellidoPaterno Primer apellido del empleado
         * @param numeroSeguroSocial Número de la Seguridad Social del empelado
         * @param salarioSemanal Salario semanal del empleado
         */
        public EmpleadoAsalariado(String primerNombre, String apellidoPaterno, String numeroSeguroSocial, double salarioSemanal) {
            super(primerNombre, apellidoPaterno, numeroSeguroSocial);
            setSalarioSemanal(salarioSemanal);
        }

        /**
         * Método que devuelve los valores de la clase como una cadena
         *
         * @return Los valores de la clase como una cadena
         */
        @Override
        public String toString() {
            return String.format("Empleado Asalariado%n%s\n%s: $%,.2f",
                    super.toString(), "Salario Semanal", getSalarioSemanal());
        }

        /**
         * Método que nos permite recuperar el valor a cobrar pagar al
         * trabajador
         *
         * @return La cantidad a cobrar por el trabajador
         */
        @Override
        public double obtenerMontoPago() {
            return getSalarioSemanal() * 4;
        }

    }

    /**
     * Clase para definir un empleado que cobra por horas
     */
    public class EmpleadoPorHoras extends Empleado {

        private double sueldo;
        private double horas;

        /**
         * Método que nos permite recuperar el sueldo por hora del empleado
         *
         * @return El sueldo por hora asignado a un trabajador
         */
        public double getSueldo() {
            return sueldo;
        }

        /**
         * Método que nos permite asignar un sueldo por hora a un empleado
         *
         * @param sueldo El sueldo del trabajador por hora
         */
        public final void setSueldo(double sueldo) {
            this.sueldo = (sueldo < 0.0) ? 0.0 : sueldo;
        }

        /**
         * Método que nos permite recuperar el número de horas asignadas a un
         * trabajador
         *
         * @return El número de horas asignadas al trabajador
         */
        public double getHoras() {
            return horas;
        }

        /**
         * Método que nos permite asignar el número de horas a un trabajador
         *
         * @param horas Número de horas asignadas al trabajador
         */
        public final void setHoras(double horas) {
            this.horas = (horas >= 0.0 && horas <= 168.0) ? horas : 0.0;
        }

        /**
         * Constructor de la clase EmpleadoPorHoras
         *
         * @param primerNombre Nombre del empleado
         * @param apellidoPaterno Apellido del empleado
         * @param numeroSeguroSocial Número de la Seguridad Social del empleado
         * @param sueldo Sueldo por hora del empleado
         * @param horas Número de horas de trabajo asignadas al trabajador
         */
        public EmpleadoPorHoras(String primerNombre, String apellidoPaterno, String numeroSeguroSocial, double sueldo, double horas) {
            super(primerNombre, apellidoPaterno, numeroSeguroSocial);
            setSueldo(sueldo);
            setHoras(horas);
        }

        /**
         * Método que devuelve el contenido de la clase como una cadena de texto
         *
         * @return Una cadena de texto representando el contenido de la clase
         */
        @Override
        public String toString() {
            return String.format("Empleado Por Horas%n%s%n%s: $%,.2f%n%s: %,.2f",
                    super.toString(), "Sueldo Por Horas", getSueldo(), "Horas Trabajadas", getHoras());
        }

        /**
         * Método que nos permite calcular la cantidad a abonar al trabajador
         *
         * @return La cantidad a abonar al trabajador
         */
        @Override
        public double obtenerMontoPago() {

            // Verficamos si el empleaod ha realizado horas extras
            if (getHoras() <= 40) {
                // Si no ha hecho horas, multiplicamos el sueldo base del empleado
                // por el número de horas mínimas permitidas (40)
                return getSueldo() * 40;
            } else {
                // Si ha realizado horas extras, las que excedan de 40 se pagan
                // a 1.5 sobre el sueldo base.
                return 40 * getSueldo() + (getHoras() - 40) * getSueldo() * 1.5;
            }
        }
    }

    /**
     * Clase para definir un empleado por comisión
     */
    public class EmpleadoPorComision extends Empleado {

        private double ventasBrutas;
        private double tarifaComision;

        /**
         * Método que nos permite recupera las ventas brutas del empleado
         *
         * @return Las ventas brutas del empleado
         */
        public double getVentasBrutas() {
            return ventasBrutas;
        }

        /**
         * Método que nos permite asignar al empleado unas ventas brutas
         *
         * @param ventasBrutas Valor de las ventas asignadas al empleado
         */
        public final void setVentasBrutas(double ventasBrutas) {
            this.ventasBrutas = (ventasBrutas > 0 ? ventasBrutas : 0);
        }

        /**
         * Método que nos permite recuperar la tarifa de comisión de un empleado
         *
         * @return La tarifa de comisión del empleado
         */
        public double getTarifaComision() {
            return tarifaComision;
        }

        /**
         * Método que nos permite asignar una tarifa de comisión a un empleado
         *
         * @param tarifaComision El valor de la tarifa de comisión de un
         * empleado
         */
        public final void setTarifaComision(double tarifaComision) {
            this.tarifaComision = (tarifaComision > 0.0 && tarifaComision < 1.0 ? tarifaComision : 0);
        }

        /**
         * Constructor de la clase Empleado por comisión
         *
         * @param primerNombre Nombre del empleado
         * @param apellidoPaterno Apellido del empleado
         * @param numeroSeguroSocial Número de la Seguridad Social del empleado
         * @param ventasBrutas Ventas brutas del empleado
         * @param tarifaComision Tarifa de comisión del empleado
         */
        public EmpleadoPorComision(String primerNombre, String apellidoPaterno, String numeroSeguroSocial, double ventasBrutas, double tarifaComision) {
            super(primerNombre, apellidoPaterno, numeroSeguroSocial);
            setVentasBrutas(ventasBrutas);
            setTarifaComision(tarifaComision);
        }

        /**
         * Método que devuelve el contenido de la clase como una cadena de texto
         *
         * @return Una cadena de texto representando el contenido de la clase
         */
        @Override
        public String toString() {
            return String.format("Empleado Por Comision%n%s%n%s: $%,.2f%n%s: %,.2f",
                    super.toString(), "Ventas Brutas", getVentasBrutas(), "Tarifa Comisión", getTarifaComision());
        }

        /**
         * Método que nos permite calcular la cantidad a abonar al trabajador
         *
         * @return La cantidad a abonar al trabajador
         */
        @Override
        public double obtenerMontoPago() {
            return getTarifaComision() * getVentasBrutas();
        }

    }

    /**
     * Clase para definir el empleado con sueldo base más comisión
     */
    public class EmpleadoBaseMasComision extends EmpleadoPorComision {

        private double salarioBase;

        /**
         * Método que nos permite recuperar el salario base del empleado
         *
         * @return El salario base del empleado
         */
        public double getSalarioBase() {
            return salarioBase;
        }

        /**
         * Método que nos permite asignar un salario base a un empleado
         *
         * @param salarioBase Salario base del empleado
         */
        public final void setSalarioBase(double salarioBase) {
            this.salarioBase = (salarioBase < 0.0 ? 0.0 : salarioBase);
        }

        /**
         * Constructor de la clase EmpleadoBaseMasComision
         *
         * @param primerNombre Nombre del empleado
         * @param apellidoPaterno Apellido del empleado
         * @param numeroSeguroSocial Número de la Seguridad Social del empleado
         * @param salarioBase Salario base del empleado
         * @param ventasBrutas Ventas brutas del empleado
         * @param tarifaComision Tarifa de comisión del empleado
         */
        public EmpleadoBaseMasComision(String primerNombre, String apellidoPaterno, String numeroSeguroSocial, double salarioBase, double ventasBrutas, double tarifaComision) {
            super(primerNombre, apellidoPaterno, numeroSeguroSocial, ventasBrutas, tarifaComision);
            setSalarioBase(salarioBase);
        }

        /**
         * Método que nos permite calcular la cantidad a abonar al trabajador
         *
         * @return La cantidad a abonar al trabajador
         */
        @Override
        public double obtenerMontoPago() {
            // Devolvemos la suma del salario base y el monto a pagar de la 
            // clase superior
            return getSalarioBase() + super.obtenerMontoPago();
        }

        /**
         * Método que devuelve el contenido de la clase como una cadena de texto
         *
         * @return La cantidad a abonar al trabajador
         */
        @Override
        public String toString() {
            return String.format("%s %s\n%s: %.2f",
                    "Con Sueldo Base",
                    super.toString(),
                    "Salario Base",
                    getSalarioBase());
        }

    }

    /**
     * Clase para definir facturas
     */
    public class Factura implements PorPagar {

        private String numeroArticulo;
        private String descripcionPieza;
        private int cantidad;
        private double precioPorArticulo;

        /**
         * Método para recuperar el número de artículo
         *
         * @return El número de artículo
         */
        public String getNumeroArticulo() {
            return numeroArticulo;
        }

        /**
         * Método para asignar el número de artículo
         *
         * @param numeroArticulo El número de artículo
         */
        public final void setNumeroArticulo(String numeroArticulo) {
            this.numeroArticulo = numeroArticulo;
        }

        /**
         * Método para recuperar la descripción de la pieza
         *
         * @return Descripción de la pieza
         */
        public String getDescripcionPieza() {
            return descripcionPieza;
        }

        /**
         * Método para asignar la descripción de una pieza
         *
         * @param descripcionPieza Descripción de la pieza
         */
        public final void setDescripcionPieza(String descripcionPieza) {
            this.descripcionPieza = descripcionPieza;
        }

        /**
         * Método para recuperar la cantidad de artículos de la factura
         *
         * @return Cantidad de artículos de la factura
         */
        public int getCantidad() {
            return cantidad;
        }

        /**
         * Método para asignar la cantidad de artículos de la factura
         *
         * @param cantidad Cantidad de artículos de la factura
         */
        public final void setCantidad(int cantidad) {
            this.cantidad = (cantidad < 0 ? 0 : cantidad);
        }

        /**
         * Método que nos permite recuperar el precio por artículo
         *
         * @return El precio por artículo
         */
        public double getPrecioPorArticulo() {
            return precioPorArticulo;
        }

        /**
         * Método para asignar el precio por artículo
         *
         * @param precioPorArticulo El precio por artículo
         */
        public final void setPrecioPorArticulo(double precioPorArticulo) {
            this.precioPorArticulo = precioPorArticulo;
        }

        /**
         * Constructor de la clase Factura
         *
         * @param numeroArticulo Número del articulo
         * @param descripcionPieza Descripción de la pieza
         * @param cantidad Cantidad de artículos
         * @param precioPorArticulo Precio por artículo
         */
        public Factura(String numeroArticulo, String descripcionPieza, int cantidad, double precioPorArticulo) {
            setNumeroArticulo(numeroArticulo);
            setDescripcionPieza(descripcionPieza);
            setCantidad(cantidad);
            setPrecioPorArticulo(precioPorArticulo);
        }

        /**
         * Método que nos permite recuperar el monto de la factura
         *
         * @return El monto de la factura
         */
        @Override
        public double obtenerMontoPago() {
            return (getCantidad() * getPrecioPorArticulo());
        }

        /**
         * Método que devuelve el contenido de la clase como una cadena de texto
         *
         * @return La cantidad a abonar al trabajador
         */
        @Override
        public String toString() {
            return String.format("Factura%nNumero Artículo: %s%n"
                    + "Descripción: %s%n"
                    + "Cantidad: %s%n"
                    + "Precio Por Artículo: %s",
                    getNumeroArticulo(),
                    getDescripcionPieza(),
                    getCantidad(),
                    getPrecioPorArticulo());
        }
    }

    /**
     * Módulo principal de la clase Ejercicio003
     */
    public void ejercicio() {

        // Creamos un array de objetos PorPagar
        PorPagar objetosPorPagar[] = new PorPagar[6];

        // Creamos una varible double para almacenar el salario base de los 
        // objetos de tipo EmpleadoBaseMasComision para hacer el incremento
        // del salario más legible
        double salarioBase;

        // Creamos los objetos especificados y rellenamos con ellos el array
        // Dos objetos factura
        objetosPorPagar[0] = new Factura("12345", "Asiento", 2, 375.00);
        objetosPorPagar[1] = new Factura("23648", "Llanta", 4, 79.95);

        // Un objeto EmpleadoAsalariado
        objetosPorPagar[2] = new EmpleadoAsalariado("Tomás", "Garcia", "111-11-1111", 800.00);

        // Un objeto EmpleadoPorHoras
        objetosPorPagar[3] = new EmpleadoPorHoras("Ana", "Torres", "222-22-2222", 1150.50, 50);

        // Un onjeto EmpleadoPorComision
        objetosPorPagar[4] = new EmpleadoPorComision("Antonio", "Gonzalez", "333-33-3333", 1000.50, 0.15);

        // Un objeto EmpleadoBaseMasComision
        objetosPorPagar[5] = new EmpleadoBaseMasComision("Maria", "Sanchez", "444-44-4444", 750.50, 800, 0.25);

        // Definimos un objeto StringBuilder para poder crear la salida de datos al usuario
        StringBuilder mensaje = new StringBuilder("Facturas y empleados procesados polilmórficamente\n");
        mensaje.append("---------------------------------------------------------------------------\n");

        // Iteramos por el array de objetos PorPagar con un for mejorado
        for (PorPagar porPagar : objetosPorPagar) {

            // Concatenamos la salida de su método ToString de los objetos por los
            // que iteramos y concatenemoas la cantidad a pagar a cada uno
            mensaje.append(String.format("%s%n%s: $%,.2f%n%n", porPagar.toString(), "Pago Vencido", porPagar.obtenerMontoPago()));
            mensaje.append("\n");

            // Verificamos si el objeto de la iteración es una instancia
            // de EmpleadoBaseMasComision
            if (porPagar instanceof EmpleadoBaseMasComision) {
                // Guardamos el salario base inicial en la variable que creamos
                // a tal efecto haciendo un casting del objeto PorPagar
                salarioBase = ((EmpleadoBaseMasComision) porPagar).getSalarioBase();

                // Aumentamos el sueldo en un 10%
                salarioBase *= 1.10;

                // Asignamos en nuevo salario base al objeto mediente un casting
                ((EmpleadoBaseMasComision) porPagar).setSalarioBase(salarioBase);

                // Concatenamos un mensaje de advertencia de que hemos aumentado
                // el sueldo y concatenamos la misma salida que usammos anteriormente
                mensaje.append("Empleado con sueldo base aumentado un 10%\n");
                mensaje.append("------------------------------------------------------------------\n");

                mensaje.append(String.format("%s%n%s: $%,.2f%n%n", porPagar.toString(), "Pago Vencido", porPagar.obtenerMontoPago()));
                mensaje.append("\n");
            }
        }

        // Mostramos la información resultante al usuario
        Mensajes.mostrarMensaje(mensaje.toString(), "Información", Mensajes.TipoMensaje.INFORMACION, true, new Dimension(60, 30));

    }

}
