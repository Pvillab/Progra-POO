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
import model.Pedido;


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
    

    /**
     * Inicia el servidor.
     * @throws IOException 
     */
    public void start() throws IOException{
        
        servidor = new ServerSocket(4005);
        servidorRecibo = new ServerSocket(4006);
        socketEnvio= servidor.accept();
        socketRecibo= servidorRecibo.accept();           
        miThread=new Thread(new recibirMensaje(this,socketRecibo));
        miThread.start();
        ADMI= new AdministradorInformacion();
        
    }
    
    /**
     * Comprueba que el servidor este inicializado.
     * @return boolean
     */
    public boolean isRunning() {
        if( socketRecibo!=null){
            return true;
        }
        return false;      
    }

    /**
     * Detiene el servidor.
     * @throws IOException 
     */
    public void stop() throws IOException {
        socketRecibo.close();
        this.socketRecibo = null;
    }
    
    /**
     * Envia un mensaje al cliente.
     * @param miMensaje 
     */
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
    
    /**
     * Envia un platillo.
     * @param miPlato 
     */
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
    
    /**
     * Retornar un arreglo con los platillos de entrada.
     * @return ArrayList
     */
    public ArrayList<Plato> listaEntradas(){
        ArrayList<Plato> lista = null;
        for(int i = 0; i<this.ADMI.getMisPlatos().size(); i++){
            if(this.ADMI.getMisPlatos().get(i).getTipo() == "ENT"){
                lista.add(this.ADMI.getMisPlatos().get(i));
            }
        }
        return lista;
    }
  
    /**
     * Retornar un arreglo con los postres.
     * @return ArrayList
     */
    public ArrayList<Plato> listaPostres(){
        ArrayList<Plato> lista = null;
        for(int i = 0; i<this.ADMI.getMisPlatos().size(); i++){
            if(this.ADMI.getMisPlatos().get(i).getTipo() == "PTR"){
                lista.add(this.ADMI.getMisPlatos().get(i));
            }
        }
        return lista;
    }
    
    /**
     * Retornar un arreglo con los platos principales.
     * @return ArrayList
     */
    public ArrayList<Plato> listaPrincipal(){
        ArrayList<Plato> lista = null;
        for(int i = 0; i<this.ADMI.getMisPlatos().size(); i++){
            if(this.ADMI.getMisPlatos().get(i).getTipo() == "PRN"){
                lista.add(this.ADMI.getMisPlatos().get(i));
            }
        }
        return lista;
    }
    
    /**
     * Retornar un arreglo con las bebidas.
     * @return ArrayList
     */
    public ArrayList<Plato> listaBebidas(){
        ArrayList<Plato> lista = null;
        for(int i = 0; i<this.ADMI.getMisPlatos().size(); i++){
            if(this.ADMI.getMisPlatos().get(i).getTipo() == "BEB"){
                lista.add(this.ADMI.getMisPlatos().get(i));
            }
        }
        return lista;
    }
    
    /**
     * Retorna arreglo de platos que se encuentren habilitados.
     * @param lista
     * @return 
     */
    public ArrayList<Plato> listaHabilitados(ArrayList<Plato> lista){
        ArrayList<Plato> arreglo = null;
        for(int i = 0; i<lista.size(); i++){
            if(lista.get(i).isHabilitado()){
                lista.add(lista.get(i));
            }
        }
        return arreglo;
    }
}