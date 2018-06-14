/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Plato;

/**
 *
 * @author mosde
 */
public class ClienteTP3 {
    
    Socket socket;
    double precioPaquete;
    double precioExpres;
    ArrayList <Plato> misPlatos;
    Thread miThread;
    
    public void conectar() throws IOException{
      
        socket = new Socket("127.0.0.1", 4005);
        miThread =new Thread(new recibirMensaje(this,socket));
        miThread.start();
        
        
    }

    boolean isRunning() {
        return socket.isConnected();
    }
    

    void stop() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClienteTP3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarMensaje(Mensaje miMensaje) throws InterruptedException{
       
        try {
            System.out.println("Queso");
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(miMensaje);
            System.out.println("Queso3");
            out.flush();
            out.reset();
        } catch (IOException ex) {
            //Si el socket esta cerrado se debe verificar
            Logger.getLogger(ClienteTP3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          
    }
    
    /**
     * Esta funcion decide que hacer con respecto a los mensajes que le pueden llegar
     * @param mensaje 
     */
    public void manejarMensaje(Mensaje mensaje) {
        
          switch (mensaje.getType()) {
            
                case 0:
                    //Recibe los platos 
                    this.misPlatos=mensaje.getMisPlatos();
                    break;
                case 1:
                    System.out.print("YEAHHH");
                    //Recibe un platillo
                    this.misPlatos.add(mensaje.getPlatoEnviar());
                    break;
                case 2:
                    //Recibe el precio del Paquete
                    this.precioPaquete = mensaje.getPrecio();
                break;
                
                case 3:
                    //Recibe el precio del Expres
                    this.precioExpres = mensaje.getPrecio();
                    break;
                
                case 4:
                    break;      
          }
        
        
        
    }
    
}
