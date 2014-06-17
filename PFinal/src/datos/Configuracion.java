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
package datos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Clase singleton para almacenar y gestionar la configuración de la aplicación
 *
 * @author Luis Cabrerizo Gómez
 */
public class Configuracion {

    private static Configuracion configuracion;

    private String direccion;
    private String puerto;
    private String nombre;
    private String usuario;
    private String password;

    /**
     * Constructor de la aplicación Diseñada sin parámetros para que no
     * modifique los valores de clase durante la creación del objeto
     */
    public Configuracion() {
    }

    /**
     * Método que devuelve una instancia de la clase Configuración, creando un
     * objeto si este no existiese anteriormente
     *
     * @return Una instancia del objeto Configuración
     * @throws java.io.IOException Excepción para errores con el fichero de
     * configuración
     *
     */
    public static synchronized Configuracion getConfiguracion() throws IOException {

        // Comprobamos si ya hay un objeto creado en la clase
        if (configuracion == null) {

            // De no ser así lo creamos
            configuracion = new Configuracion();
        }

        // Devolvemos la instanciá del objeto Configurcións
        return configuracion;
    }

    /**
     * Método que nos permite recuperar el valor de la dirección de la base de
     * datos con la que trabajará la aplicación
     *
     * @return La dirección de la base de datos con la que trabajará la
     * aplicación
     */
    public String getDireccion() {
        return this.direccion;
    }

    /**
     * Método que nos permite asignar la dirección de la base de datos con la
     * que trabajará la aplicación
     *
     * @param direccion La dirección de la base de datos con la que trabajará la
     * aplicación
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método que nos permite recuperar el puerto de la base de datos con la que
     * trabajará la aplicación
     *
     * @return El puerto de la base de datos con la que trabajará la aplicación
     */
    public String getPuerto() {
        return this.puerto;
    }

    /**
     * Método que nos permite asignar el puerto de la base de datos con la que
     * trabajará la aplicación
     *
     * @param puerto El puerto de la base de datos con la que trabajará la
     * aplicación
     */
    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    /**
     * Método que nos permite recuperar el valor del nombre de la base de datos
     * con la que trabajará la aplicación
     *
     * @return El nombre de la base de datos con la que trabajará la aplicación
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Método que nos permite asignar el nombre de la base de datos con la que
     * trabajará la aplicación
     *
     * @param nombre El nombre de la base de datos con la que trabajará la
     * aplicación
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que nos permite recuperar el usuario de la base de datos con la
     * que trabajará la aplicación
     *
     * @return El usuario de la base de datos con la que trabajará la aplicación
     */
    public String getUsuario() {
        return this.usuario;
    }

    /**
     * Método que nos permite asignar el usuario de la base de datos con la que
     * trabajará la aplicación
     *
     * @param usuario El usuario de la base de datos con la que trabajará la
     * aplicación
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Método que nos permite asignar la contraseña de la base de datos con la
     * que trabajará la aplicación
     *
     * @return La contraseña de la base de datos con la que trabajará la
     * aplicación
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Método que nos permite asignar la contraseña de la base de datos con la
     * que trabajará la aplicación
     *
     * @param password La contraseña de la base de datos con la que trabajará la
     * aplicación
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Método para cargar la configuración desde el fichero de configuración
     *
     * @throws IOException Excepción por si hay errores de lectura con el
     * fichero de configuración
     */
    public void cargarConfiguracion() throws IOException {

        // Creamos un nuevo objeto Properties que usaremos para leer la 
        // configuración de la aplicación
        Properties prop = new Properties();

        // Creamos un flujo de datos con el fichero de configuracion
        InputStream input = new FileInputStream("config.properties");

        // Leemos las propiedades del fichero
        prop.load(input);

        // Asignamos las propiedades a las variables de clase
        this.direccion = prop.getProperty("direccion");
        this.nombre = prop.getProperty("nombre");
        this.puerto = prop.getProperty("puerto");
        this.usuario = prop.getProperty("usuario");
        this.password = prop.getProperty("password");

    }

    /**
     * Método para almacenar la configuración de la aplicación a un fichero
     *
     * @throws IOException Excepción por si hay errores de escritura con el
     * fichero de configuración
     */
    public void guardarConfiguracion() throws IOException {

        // Creamos un nuevo objeto Properties que usaremos para leer la 
        // configuración de la aplicación        
        Properties prop = new Properties();

        // Definimos un flujo de salida
        OutputStream output = null;

        try {

            // Creamos un flujo de salida sobre un ficher
            output = new FileOutputStream("config.properties");

            // Asignamos los valores a almacenar al objeto Properties
            prop.setProperty("direccion", direccion);
            prop.setProperty("nombre", nombre);
            prop.setProperty("puerto", puerto);
            prop.setProperty("usuario", usuario);
            prop.setProperty("password", password);

            // Grabamos el fichero en el direcctorio raíz de la aplicacion
            prop.store(output, null);

        } finally {
            // Si el objeto todavia existe, intentamos cerrarlo
            if (output != null) {
                try {
                    output.close();
                } finally {
                }
            }
        }

    }
}
