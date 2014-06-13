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
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase para acceder a la base de datos usando las librerias jdbc
 *
 * @author Luis Cabrerizo Gómez
 */
class DBAccess {

    // Constante con el nombre del driver
    private static final String SQL_DRIVER = "com.mysql.jdbc.Driver";

    // Variables y objetos globales
    private static String usuario;
    private static String password;
    private static String db_path;
    private static String database;

    private static Connection conexion = null;
    private Statement instruccion;

    /**
     * Constructor de la clase DBAccess
     *
     * @param usuario Usuario de acceso a la base de datos
     * @param password Password del usuario en la base de datos
     * @param db_path Ruta de la base de datos
     * @param database Nombre de la base de datos a la que acceder
     * @throws ClassNotFoundException Lanza excepción si se produce un error al
     * referenciar el driver JDBC
     * @throws SQLException Lanza excepción si se produce un error en una
     * consulta SQL
     */
    protected DBAccess(String usuario, String password, String db_path, String database) throws ClassNotFoundException, SQLException {

        // Asginamos los parámetros de la función como valores de instancia
        DBAccess.usuario = usuario;
        DBAccess.password = password;
        DBAccess.db_path = "jdbc:mysql://" + db_path;
        DBAccess.database = database;

        // Comprobamos si la base de datos existe
        if (!checkDB()) {

            // Si no existe, la creamos completamente
            createDB();
        }

        // Creamos una conexión a partir de los pasados al método
        DBAccess.conexion = DriverManager.getConnection(DBAccess.db_path + "/" + DBAccess.database, DBAccess.usuario, DBAccess.password);
    }

    /**
     * Clase que comprueba si existe una base de datos
     *
     * @return Verdadero si la base de datos existe, falso si no es así
     * @throws ClassNotFoundException Lanza excepción si se produce un error al
     * referenciar el driver JDBC
     * @throws SQLException Lanza excepción si se produce un error en una
     * consulta SQL
     */
    private boolean checkDB() throws ClassNotFoundException, SQLException {

        // Registramos  el driver JDBC
        Class.forName(SQL_DRIVER);

        // Creamos una conexión a la base de datos ocn los valores que tenemos
        // las variables de instancia
        conexion = DriverManager.getConnection(DBAccess.db_path, DBAccess.usuario, DBAccess.password);

        // Recuperamos los catalogos disponibles en la base de datos, esto es,
        // las bases de datos que tiene
        try (ResultSet resultSet = conexion.getMetaData().getCatalogs()) {

            // Iteramos por el resultado
            while (resultSet.next()) {

                // Recuperamos el nombre de la base de datos
                String databaseName = resultSet.getString(1);

                // Lo comparamos con el nombre de nuestra base de datos                
                if (databaseName.equals(DBAccess.database)) {

                    // Si son iguales, cerramos la conexión y devolvemos verdadero
                    conexion.close();

                    return true;
                }
            }
        }

        // Si no hemos encontrado la base de datos cerramos la conexión y
        // devolvemos falso
        conexion.close();

        return false;
    }

    /**
     * Método para crear una base de datos específica mediante comandos SQL
     *
     * @return 0 si ha habido un error y otro entero en caso contrario
     * @throws SQLException Si se produce un error de SQL
     */
    private int createDB() throws SQLException {

        // Iniciamos la variable de salida
        int resultado = 0;

        // Creamos un array de cadenas con las sentencias que se van a ajecutar
        String[] sql = {
            "CREATE DATABASE libros;",
            "USE libros;",
            "CREATE TABLE autores(idAutor int NOT NULL AUTO_INCREMENT PRIMARY KEY, primerNombre varchar(30) NOT NULL, apellidoPaterno varchar(30) NOT NULL);",
            "CREATE TABLE titulos(isbn varchar(20) NOT NULL PRIMARY KEY, titulo varchar(100) NOT NULL, numeroEdicion int NOT NULL, editorial varchar(50) NOT NULL, copyright varchar(4) NOT NULL, resumen varchar(1000));",
            "CREATE TABLE isbnAutor(idAutor int NOT NULL, isbn varchar(20) NOT NULL, FOREIGN KEY (idAutor) REFERENCES autores(idAutor) ON DELETE CASCADE ON UPDATE CASCADE, FOREIGN KEY (isbn) References titulos(isbn) ON DELETE CASCADE ON UPDATE CASCADE);",
            "INSERT INTO autores (primerNombre,apellidoPaterno) VALUES ('Harvey','Deitel');",
            "INSERT INTO autores (primerNombre,apellidoPaterno) VALUES ('Paul','Deitel');",
            "INSERT INTO autores (primerNombre,apellidoPaterno) VALUES ('Andrew','Goldberg');",
            "INSERT INTO autores (primerNombre,apellidoPaterno) VALUES ('David','Choffnes');",
            "INSERT INTO titulos (isbn,titulo,numeroEdicion, editorial, copyright, resumen) VALUES ('0131869000','Visual Basic 2005 How to Program',3, 'Minotauro', '2006', 'Learn Visual Basic.NET hands-on, through thousands of lines of live code in hundreds of complete working programs, explained with exceptional clarity by the renowned programming trainers of Deitel & Associates. An accompanying CD-ROM contains all of the book''s source code, up-to-date Visual Studio 2005 development tools, plus links to the Web''s best Visual Basic.NET demos and resources.');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (1,'0131869000');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (2,'0131869000');",
            "INSERT INTO titulos (isbn,titulo,numeroEdicion, editorial, copyright, resumen) VALUES ('0131525239','Visual C# 2005 How to Program',2,'Minotauro', '2006', 'Learn how to build winning C# applications, start to finish, using the Deitels'' proven methodology and signature Live-Code(tm) Approach! This new edition includes extensive use of Visual Studio 2005''s new visual programming tools that tremendously reduce the amount of code programmers need to write in ADO.NET and ASP.NET applications. With these new tools, programmers can develop powerful ADO.NET and ASP.NET applications quickly and easily. You''ll start with an introduction to C# and Visual C# 2005 Express. After examining methods and arrays, the Deitels present an in-depth introduction to object-oriented programming. They introduce powerful exception handling techniques for building mission critical software; followed by in-depth coverage of C#-based GUI development. Coverage also includes: multithreading; strings, characters; regular expressions; graphics; files and streams; and more.');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (1,'0131525239');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (2,'0131525239');",
            "INSERT INTO titulos (isbn,titulo,numeroEdicion, editorial, copyright, resumen) VALUES ('0132222205','Java How to Program',7,'Minotauro', '2007', 'The Deitels'' groundbreaking How to Program series offers unparalleled breadth and depth of object-oriented programming concepts and intermediate-level topics for further study. The Seventh Edition has been extensively fine-tuned and is completely up-to-date with Sun Microsystems, Inc.''s latest Java release Java Standard Edition 6 (\\\\\\\"Mustang\\\\\\\") and several Java Enterprise Edition 5 topics. Contains an extensive OOD/UML 2 case study on developing an automated teller machine. Takes a new tools-based approach to Web application development that uses Netbeans 5.5 and Java Studio Creator 2 to create and consume Web Services. Features new AJAX-enabled, Web applications built with JavaServer Faces (JSF), Java Studio Creator 2 and the Java Blueprints AJAX Components. Includes new topics throughout, such as JDBC 4, SwingWorker for multithreaded GUIs, GroupLayout, Java Desktop Integration Components (JDIC), and much more.');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (1,'0132222205');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (2,'0132222205');",
            "INSERT INTO titulos (isbn,titulo,numeroEdicion, editorial, copyright, resumen) VALUES ('0131857576','C++ How to Program',5,'Minotauro', '2005', 'Deitels'' ''C++ How to Program'', fifth edition, has hundreds of hands-on exercises, roughly 250 complete programs written and documented for easy learning, and exceptional insight into good programming practices, maximizing performance, avoiding errors, debugging, and testing.');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (1,'0131857576');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (2,'0131857576');",
            "INSERT INTO titulos (isbn,titulo,numeroEdicion, editorial, copyright, resumen) VALUES ('0132404168','C How to Program',5,'Alfaguara', '2007', 'The Deitels'' groundbreaking \\\\\\\"How to Program\\\\\\\" series offers unparalleled breadth and depth of programming concepts and intermediate-level topics for further study. The books in this series feature hundreds of complete, working programs with thousands of lines of code. Includes strong treatment of structured algorithm and program development in ANSI/ISO C with 150 working C programs. New chapters added for C99 and game programming with the Allegro C Library. Includes rich, 300-page treatment of object-oriented programming in C++. Presents each new concept in the context of a complete, working program, immediately followed by one or more windows showing the program''s input/output dialog. Enhances the \\\\\\\"Live-Code Approach\\\\\\\" with syntax coloring.');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (1,'0132404168');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (2,'0132404168');",
            "INSERT INTO titulos (isbn,titulo,numeroEdicion, editorial, copyright, resumen) VALUES ('0131450913','Internet & World Wide Web How to Program',3,'Alfaguara', '2004', 'This comprehensive book with accompanying CD-ROM teaches the fundamentals needed to program on the Internet. Readers will be well-prepared to build real-world, industrial-strength, Web-based applications.');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (1,'0131450913');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (2,'0131450913');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (3,'0131450913');",
            "INSERT INTO titulos (isbn,titulo,numeroEdicion, editorial, copyright, resumen) VALUES ('0131828274','Operating Systems',3,'Alfaguara', '2004', 'The third edition of Operating Systemshas been entirely updated to reflect current core operating system concepts and design considerations. To complement the discussion of operating system concepts, the book features two in-depth case studies on Linux and Windows XP. The case studies follow the outline of the book, so readers working through the chapter material can refer to each case study to see how a particular topic is handled in either Linux or Windows XP. Using Java code to illustrate key points, Operating Systemsintroduces processes, concurrent programming, deadlock and indefinite postponement, mutual exclusion, physical and virtual memory, file systems, disk performance, distributed systems, security and more. New to this edition are a chapter on multithreading and extensive treatments of distributed computing, multiprocessing, performance, and computer security. An ideal up-to-date book for beginner operating systems readers.');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (1,'0131828274');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (2,'0131828274');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (4,'0131828274');"};

        // Creamos una conexión a la base de datos ocn los valores que tenemos
        // las variables de instancia        
        conexion = DriverManager.getConnection(DBAccess.db_path, DBAccess.usuario, DBAccess.password);
        
        // Iteramos por el array de sentecias
        for (String cadena : sql) {
            try {
                // Creamos una instrucción
                instruccion = DBAccess.conexion.createStatement();

                // Y la ejecutamos guardando el resultado
                resultado = instruccion.executeUpdate(cadena);
            } catch (SQLException e) {

                // Si se produce una excepción, reseteamos el resultado y lanzamos
                // una excepción
                resultado = 0;
                throw e;
            } finally {

                // Finalmente cerramos la conexión
                instruccion.close();
            }
        }

        // Devolvemos el resultado
        return resultado;

    }

    /**
     * Método que nos permite realizar actualizaciones en la base de datos
     * mediante sentencias sql
     *
     * @param sql Sentencia sql a ejecutarse
     * @return Devuelve 0 en caso de error y otro entero en caso contrario
     * @throws SQLException Si se produce un error de SQL
     */
    protected int update(String sql) throws SQLException {
        int salida;

        try {

            // Creamos una instrucción
            instruccion = DBAccess.conexion.createStatement();

            // Y la ejecutamos guardando el resultado
            salida = instruccion.executeUpdate(sql);
        } catch (SQLException e) {

            // Si se produce una excepción, reseteamos el resultado y lanzamos
            // una excepción
            salida = 0;
            throw e;
        } finally {

            // Definimos que la instrucción se cierre automaticamente cuando
            // se cierren el ResulSet asociado a ella
            instruccion.closeOnCompletion();
        }

        // Finalmente devolvemos el resultado
        return salida;
    }

    /**
     * Método que nos permite realizar una consultra a la base de datos mediante
     * una consulta sql
     *
     * @param sql Consulta sql
     * @return El resultado de la consuta en un ResulSet
     * @throws SQLException Si se produce un error de SQL
     */
    protected ResultSet query(String sql) throws SQLException {

        ResultSet salida;

        try {
            // Creamos una instrucción
            instruccion = DBAccess.conexion.createStatement();

            // Y la ejecutamos guardando el resultado
            salida = instruccion.executeQuery(sql);
        } catch (SQLException e) {

            // Si se produce una excepción, reseteamos el resultado y lanzamos
            // una excepción          
            salida = null;
            throw e;
        } finally {

            // Definimos que la instrucción se cierre automaticamente cuando
            // se cierren el ResulSet asociado a ella
            instruccion.closeOnCompletion();
        }

        // Devolvemos el resultado
        return salida;
    }
}
