/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import static controller.Server.servidorRecibo;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mosde
 */
public class recibirMensaje extends Thread {
    private Socket socket;
    private final Server server;    


public recibirMensaje(final Server server, final Socket socket) {
    this.server = server;
    this.socket = socket;
}

@Override
 public void run() {
        
    while (server.isRunning()) {
        try(ObjectInputStream reader = new ObjectInputStream(socket.getInputStream())) {
           
                try {
                    
                    //Transforma el mensaje en el objeto
                    Mensaje miMensaje = (Mensaje)reader.readObject();
                    //Este metodo interpretara el mensaje
                    server.manejarMensaje(miMensaje);
                    reader.close();
                
                    
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e);
                }
            
        } catch (IOException ex) {
            //System.out.println("ERROR No se pudo establecer una comunicacion con el servidor");
              
        }
        finally{
            ObjectInputStream reader=null;
            try {
                socket = server.getServidorRecibo().accept();
            } catch (IOException ex) {
                Logger.getLogger(recibirMensaje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    }
}