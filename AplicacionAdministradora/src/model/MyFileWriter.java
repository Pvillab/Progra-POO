/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *Clase para el envio de imagenes
 * @author mosde
 */
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyFileWriter {
    
    /**
     * Convierte el archivo en los bytes que seran leidos por el cliente.
     * @param fileName
     * @param inputStream
     * @return
     * @throws IOException 
     */
    public int writeFile(String fileName, InputStream inputStream) throws IOException {
        File f = new File(fileName);
        int bytesWritten;
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f))) {
            bytesWritten = 0;
            int b;
            while ((b = inputStream.read()) != -1) {
                bos.write(b);
                bytesWritten++;
            }
        }
        
        return bytesWritten;
    }
}