/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class MyFileReader {
    
    /**
     * Convierte el archivo en los bytes que seran leidos por el cliente.
     * @param fileName
     * @return Byte
     * @throws IOException 
     */
    public byte[] readFile(String fileName) throws IOException {
        File file = new File(fileName);
        byte[] fileData = new byte[(int)file.length()];
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(file)); 
        
        int bytesRead = 0;
        int b;
        while ((b = br.read()) != -1) {
            fileData[bytesRead++] = (byte)b;
        }
        
        br.close();
        return fileData;
    }
    
}