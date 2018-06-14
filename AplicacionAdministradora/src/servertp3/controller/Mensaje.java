/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertp3.controller;

import java.io.Serializable;
import servertp3.model.Pedido;
import servertp3.model.Plato;

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
   
    
}
