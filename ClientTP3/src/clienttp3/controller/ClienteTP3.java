/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttp3.controller;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mosde
 */
public class ClienteTP3 {
    
    Socket socket;
    
    public void conectar() throws IOException{
      
        socket = new Socket("127.0.0.1", 4005);
        (new Thread(new recibirMensaje(this,socket))).start();
        
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
    
}
