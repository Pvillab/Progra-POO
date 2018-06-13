/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttp3.controller;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author mosde
 */
class ClienteTP3 {
    
    Socket socket;
    
    public void start() throws IOException{
        socket = new Socket("127.0.0.1", 4005);
        (new Thread(new recibirMensaje(this,socket))).start();
        
    }

    boolean isRunning() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String prueba(){
       return "JJJ";
    }

    void stop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
