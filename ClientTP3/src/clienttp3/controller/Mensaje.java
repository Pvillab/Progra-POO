/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttp3.controller;

import clienttp3.model.Pedido;
import clienttp3.model.Plato;
import java.io.Serializable;

/**
 *
 * @author mosde
 */
public class Mensaje implements Serializable {

    protected static final long serialVersionUID = 1112122200L;

    //Tipos de Mensaje
    static final int ENVIARPLATONUEVO = 1, PRECIOCAJA  = 2 , PRECIOEXPRES =3 ,  ENVIONUEVO = 4;
    private int type;

    //Posibles Contenidos de los mensajes
    private Plato platoEnviar =null;
    private Pedido pedidoNuevo = null;
    private double precio = 0.0;

    public Mensaje(int type, Plato miPlato) {
        this.platoEnviar= miPlato;
        this.type = type;
    }
    
    public Mensaje(int type, double precio) {
        this.precio=precio;
        this.type = type;
    }

    public Mensaje(int type, Pedido pedido) {
        this.type = type;
        this.pedidoNuevo=pedido;
        
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

    boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
