/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import model.Pedido;
import model.Plato;

/**
 *
 * @author mosde
 */
public class Mensaje implements Serializable {

    protected static final long serialVersionUID = 1112122200L;

    //Tipos de Mensaje
    static final int ENVIARTODOSPLATOS =0 ,ENVIARPLATONUEVO = 1, PRECIOCAJA  = 2 , PRECIOEXPRES =3 ,  ENVIONUEVO = 4;
    private int type;

    //Posibles Contenidos de los mensajes
    private Plato platoEnviar =null;
    private Pedido pedidoNuevo = null;
    private double precio = 0.0;
    private ArrayList <Plato> misPlatos;

    /**
     * Mensaje que envia un plato.
     * @param type
     * @param miPlato 
     */
    public Mensaje(int type, Plato miPlato) {
        this.platoEnviar= miPlato;
        this.type = type;
    }
    
    /**
     * Mensaje que envia el precio.
     * @param type
     * @param precio 
     */
    public Mensaje(int type, double precio) {
        this.precio=precio;
        this.type = type;
    }

    /**
     * Mensaje que envia el pedido.
     * @param type
     * @param pedido 
     */
    public Mensaje(int type, Pedido pedido) {
        this.type = type;
        this.pedidoNuevo=pedido;
        
    }

    /**
     * Mensaje que envia el arreglo de platos.
     * @param type
     * @param misPlatos 
     */
    public Mensaje(int type, ArrayList<Plato> misPlatos) {
        this.type = type;
        this.misPlatos = misPlatos;
    }
    
    public int getType() {
        return type;
    }

    public Plato getPlatoEnviar() {
        return platoEnviar;
    }

    public Pedido getPedidoNuevo() {
        return pedidoNuevo;
    }

    public double getPrecio() {
        return precio;
    }

    public ArrayList<Plato> getMisPlatos() {
        return misPlatos;
    }

    public void setMisPlatos(ArrayList<Plato> misPlatos) {
        this.misPlatos = misPlatos;
    }
    
    
   
    
}
