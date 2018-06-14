/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertp3.controller;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author mosde
 */
public class recibirMensaje extends Thread {
    private final Socket socket;
    private final Server server;    


public recibirMensaje(final Server server, final Socket socket) {
    this.server = server;
    this.socket = socket;
}

@Override
 public void run() {
        
        try(ObjectInputStream reader = new ObjectInputStream(socket.getInputStream())) {
           
            while (server.isRunning()) {
                try {
                    //Transforma el mensaje en el objeto
                    Mensaje miMensaje = (Mensaje)reader.readObject();
                    
                    //Este metodo interpretara el mensaje
                    server.manejarMensaje(miMensaje);
                
                    
                } catch (IOException | ClassNotFoundException e) {
                    server.stop();
                }
            }
        } catch (IOException ex) {
            System.out.println("ERROR No se pudo establecer una comunicacion con el servidor");
              
        }
    }

}