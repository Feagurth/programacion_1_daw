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
import org.apache.commons.codec.binary.Base64;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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

}
