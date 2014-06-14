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
package utiles;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class Utiles {

    /**
     * Método para transformar una cadena en base 64 a una imagen
     *
     * @param base64String Cadena de texto en base 64
     * @return Imagen contenida en la cadena de texto base 64
     * @throws IOException Excepción para controlar errores en la creación de la
     * imagen
     */
    public static BufferedImage stringBase64ToImage(String base64String) throws IOException {

        // Decodificamos la información a un array de bytes desde
        // una cadena de texto en base64
        byte[] bytearray = Base64.decodeBase64(base64String);

        // Lo convertimos en un objeto BufferedImage y lo devolvemos
        return ImageIO.read(new ByteArrayInputStream(bytearray));

    }

    /**
     * Método para transformar un fichero a una cadena en base64
     *
     * @param file Fichero a transformar
     * @return El fichero transformado en una cadena en base64
     * @throws IOException Excepción para controlar errores en la creación de la
     * cadena
     */
    public static String fileToBase64String(File file) throws IOException {
        String base64String;

        ByteArrayOutputStream baos = new ByteArrayOutputStream(1000);

        BufferedImage img = ImageIO.read(file);
        ImageIO.write(img, "jpg", baos);
        baos.flush();
        base64String = Base64.encodeBase64String(baos.toByteArray());

        return base64String;
    }

    /**
     *
     * @param image La imagen a redimensionar
     * @param imageType El tipo de imagen a redimensionar
     * @param newWidth El ancho requerido
     * @param newHeight El alto requerido
     *
     * @return La imagen redimensionada
     */
    public static BufferedImage scaleImage(BufferedImage image, int imageType, int newWidth, int newHeight) {

        // Calculamos el radio de la imagen nueva para eviar distorsiones
        double thumbRatio = (double) newWidth / (double) newHeight;

        // Almacenamos el alto y ancho de la imagen a redimensionar
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);

        // Y calculamos el radio de la imagen
        double aspectRatio = (double) imageWidth / (double) imageHeight;

        // Comprobamos los radios de las las imagenes y ajustamos el alto o el
        // ancho para ajustarlos
        if (thumbRatio < aspectRatio) {
            newHeight = (int) (newWidth / aspectRatio);
        } else {
            newWidth = (int) (newHeight * aspectRatio);
        }

        // Creamos la imagen y la dibujamos
        BufferedImage newImage = new BufferedImage(newWidth, newHeight, imageType);
        Graphics2D graphics2D = newImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(image, 0, 0, newWidth, newHeight, null);

        //Devolvemos la imagen
        return newImage;
    }

    /**
     * Método para descargar un fichero desde una url y asociarlo a un objeto
     * file
     *
     * @param url url desde la que descargar el fichero
     * @return Un objeto file con el fichero descargado
     * @throws IOException Excepción en caso de errores al grabar el fichero
     */
    public static File downloadFile(URL url) throws IOException {

        // Creamos una conexión y la abrimos con la url proporcionada como 
        // parámetro
        URLConnection urlConn = url.openConnection();

        // Le ponemos como propiedad a la conexión una conexión desde un
        // navegador, en este caso Mozilla sobre un PowerPc para
        // que los servidores accedidos piensen que se hace desde un
        // navegador web y obviar en la medida de lo posible
        // restricciones, en este caso de Google Books
        urlConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.21; Mac_PowerPC)");

        // Conectamos y creamos un flujo de entrada con la conexión
        urlConn.connect();
        InputStream urlStream = urlConn.getInputStream();

        // Definimos un flujo de salida de datos
        OutputStream outputStream = null;

        try {
            // Definimos el flujo de salida sobre un fichero en local
            // sobre el que volcaremos los datos del flujo de entrada
            outputStream = new FileOutputStream(new File("cover.jpg"));

            int read;
            byte[] bytes = new byte[1024];

            // Leemos del flujo de entrada hasta que se vacíe
            // y vamos escribiendo los datos en el flujo de salida
            while ((read = urlStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

        } finally {
            // Para finalizar cerramos los dos flujos de datos
            if (urlStream != null) {
                urlStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }

        // Devolvemos un objeto File creado a partir del fichero que acabamos 
        // de crear
        return new File("cover.jpg");
    }

}
