/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Plato;
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
    
    private static ServerSocket servidor;
    private static Socket socket ;
    private static AdministradorInformacion ADMI;
    private Thread miThread;
    

    public void start() throws IOException{
        servidor = new ServerSocket(4005);
        socket= servidor.accept();      
        miThread=new Thread(new recibirMensaje(this,socket));
        miThread.start();
        
    }
    
    public boolean isRunning() {
        if( socket!=null){
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
    

    /**
     * Esta funcion decide que hacer con respecto a los mensajes que le pueden llegar
     * @param mensaje 
     */
    public void manejarMensaje(Mensaje mensaje) {

          switch (mensaje.getType()) {
            
              case 0:
                  //Envia la lista de los platos
                  Mensaje mensajePlatos = new Mensaje(0,this.ADMI.getMisPlatos().getLista());
              case 1:
                  System.out.print("YEAHHH");
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
                this.ADMI.agregarPedido(mensaje.getPedidoNuevo());
                break;
                
                
                
          }
        
        
        
    }
  
    
}