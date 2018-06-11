/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertp3.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import servertp3.view.ServerGUI;

/*
 * The server that can be run both as a console application or a GUI
 */
public class Server {
    
    ServerSocket servidor;
    Socket socket ;
    

    public void start() throws IOException{
        servidor = new ServerSocket(4005);
        socket= servidor.accept();      
        (new Thread(new recibirMensaje(this,socket))).start();
    }
    
    public boolean isRunning() {
        if( socket==null){
            return true;
        }
        return false;      
    }

    public void stop() throws IOException {
        socket.close();
        this.socket = null;
    }
    
    public void prueba(){
        System.out.println("KOKO");
    }
  
    
}