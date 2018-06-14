/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.imageio.ImageIO;


/**
 *
 * @author mosde
 */
class Imagen implements Serializable {
    private transient BufferedImage miImagen;
    
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        ImageIO.write(miImagen, "png", out);
        
    }
    
    
}
    