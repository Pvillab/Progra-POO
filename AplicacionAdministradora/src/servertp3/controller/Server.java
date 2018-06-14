/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertp3.controller;

import servertp3.model.Plato;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * The server that can be run both as a console application or a GUI
 */
public class Server {
    
    ServerSocket servidor;
    Socket socket ;
    AdministradorInformacion ADMI;
    

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
    
    private void enviarMensaje(Mensaje miMensaje){
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(miMensaje);
        } catch (IOException ex) {
            //Si el socket esta cerrado se debe verificar
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
    
    public void nuevoPlatillo(Plato miPlato){
        this.ADMI.agregarPlatillo(miPlato);
        //Se crea el mensaje por enviar
        Mensaje miMensaje = new Mensaje (1,miPlato);
        enviarMensaje(miMensaje);   
    }
    
    public void recibirPedido(Mensaje mensaje){
        
    }

    /**
     * Esta funcion decide que hacer con respecto a los mensajes que le pueden llegar
     * @param mensaje 
     */
    public void manejarMensaje(Mensaje mensaje) {
        
          switch (mensaje.getType()) {
            case 1:
                break;
            case 2:
                //Envair un mensaje del precio del paquete
                Mensaje mensajePaquete = new Mensaje(2,this.ADMI.getPreciopaquete());
                enviarMensaje(mensajePaquete);
                break;
                
            case 3:
                //Manda el precio del Express
                Mensaje mensajeExpres = new Mensaje(2,this.ADMI.getPrecioExpres());
                enviarMensaje(mensajeExpres);
                break;
                
            case 4:
                recibirPedido(mensaje);
                break;
                
                
                
          }
        
        
        
    }
  
    
}