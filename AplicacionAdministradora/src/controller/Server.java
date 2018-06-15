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
    
    public static ServerSocket servidor;
    public static ServerSocket servidorRecibo;
    private static Socket socketRecibo ;
    public Socket socketEnvio;
    private AdministradorInformacion ADMI;
    private Thread miThread;
    

    public void start() throws IOException{
        
        servidor = new ServerSocket(4005);
        servidorRecibo = new ServerSocket(4006);
        socketEnvio= servidor.accept();
        socketRecibo= servidorRecibo.accept();           
        miThread=new Thread(new recibirMensaje(this,socketRecibo));
        miThread.start();
        ADMI= new AdministradorInformacion();
        
    }
    
    public boolean isRunning() {
        if( socketRecibo!=null){
            return true;
        }
        return false;      
    }

    public void stop() throws IOException {
        socketRecibo.close();
        this.socketRecibo = null;
    }
    
    public void enviarMensaje(Mensaje miMensaje){
        
        try{ 
            ObjectOutputStream out = new ObjectOutputStream (socketEnvio.getOutputStream());
            out.writeObject(miMensaje);
            out.close();
            socketEnvio= servidor.accept();
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
                  Mensaje mensajePlatos;
                  //Envia la lista de los platos si no esta vacio
                  System.out.println(this.ADMI.getMisPlatos().size());
                  if(!this.ADMI.getMisPlatos().isEmpty()){
                    mensajePlatos = new Mensaje(0,this.ADMI.getMisPlatos());
                    enviarMensaje(mensajePlatos);
                  }
                  break;
                  
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

    public static ServerSocket getServidor() {
        return servidor;
    }

    public static void setServidor(ServerSocket servidor) {
        Server.servidor = servidor;
    }

    public static ServerSocket getServidorRecibo() {
        return servidorRecibo;
    }

    public static void setServidorRecibo(ServerSocket servidorRecibo) {
        Server.servidorRecibo = servidorRecibo;
    }

    public static Socket getSocketRecibo() {
        return socketRecibo;
    }

    public static void setSocketRecibo(Socket socketRecibo) {
        Server.socketRecibo = socketRecibo;
    }

    public Socket getSocketEnvio() {
        return socketEnvio;
    }

    public void setSocketEnvio(Socket socketEnvio) {
        this.socketEnvio = socketEnvio;
    }

    public AdministradorInformacion getADMI() {
        return ADMI;
    }

    public void setADMI(AdministradorInformacion ADMI) {
        this.ADMI = ADMI;
    }

    public Thread getMiThread() {
        return miThread;
    }

    public void setMiThread(Thread miThread) {
        this.miThread = miThread;
    }
    
    
  
    
}