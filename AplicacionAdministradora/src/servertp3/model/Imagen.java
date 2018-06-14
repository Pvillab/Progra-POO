package servertp3.controller;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.imageio.ImageIO;

/**
 *
 * @author Paul Villafuerte
 */

class Imagen implements Serializable {
    private transient BufferedImage miImagen;
    
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        ImageIO.write(miImagen, "png", out);
        
    }

}