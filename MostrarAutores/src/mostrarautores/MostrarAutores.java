/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mostrarautores;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * 
 * @author Super
 */
public class MostrarAutores {

    private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String URL_BASEDATOS = "jdbc:mysql://127.0.0.1:3306/libros";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Connection conexion = null;
        Statement instruccion = null;
        ResultSet registros = null;
        ResultSetMetaData metaDatos;
        int numeroColumnas;

        try {
            Class.forName(CONTROLADOR);

            conexion = DriverManager.getConnection(URL_BASEDATOS, "root", "");
            instruccion = conexion.createStatement();
            registros = instruccion.executeQuery("Select * from Autores");
            metaDatos = registros.getMetaData();
            numeroColumnas = metaDatos.getColumnCount();

            System.out.println("Tabla de autores de la base de datos de libros\n");

            for (int i = 1; i <= numeroColumnas; i++) {
                System.out.printf("%-8s\t", metaDatos.getColumnName(i));
            }
            System.out.println("");

            while (registros.next()) {
                for (int i = 1; i <= numeroColumnas; i++) {
                    System.out.printf("%-8s\t", registros.getObject(i));
                }
                System.out.println("");
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
        finally
        {
            try {
                registros.close();
                instruccion.close();
                conexion.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de cierre de la base de datos", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
