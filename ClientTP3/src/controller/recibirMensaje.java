/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author mosde
 */
 public class recibirMensaje extends Thread {
    
     
    private final Socket socket;
    private final ClienteTP3 ClienteTP3;    

    /**
     *
     * @param ClienteTP3
     * @param socket
     */
    public recibirMensaje(final ClienteTP3 ClienteTP3, final Socket socket) {
       this.ClienteTP3 = ClienteTP3;
       this.socket = socket;
   }

   @Override
    public void run() {
        while (ClienteTP3.isRunning()) {
           try(ObjectInputStream reader = new ObjectInputStream(socket.getInputStream())) {
               
                   try {
                    // The thread will wait here until the ClienteTP3 sends data.
                    Mensaje miMensaje = (Mensaje)reader.readObject();
                    
                    //Este metodo interpretara el mensaje
                    ClienteTP3.manejarMensaje(miMensaje);
                       
                   } catch (IOException | ClassNotFoundException e) {
                       ClienteTP3.stop();
                   }
      
           } catch (IOException ex) {
               System.out.println("ERROR Abort reading. Could not establish InputStream from Socket."+ex);
               
           } finally {

               ObjectInputStream reader=null;
           }
        }
    }
}

