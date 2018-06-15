/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mosde
 */
public class PedidoLocal extends Pedido{
    
    private int numMesa;

    /**
     * Constructor
     * @param numMesa
     * @param misPlatos
     * @param numeroPorciones
     * @param fechaRealizado
     * @param nombreRealizaPedido 
     */
    public PedidoLocal(int numMesa, ArrayList<Plato> misPlatos, ArrayList<Integer> numeroPorciones, Date fechaRealizado, String nombreRealizaPedido) {
        super(misPlatos, numeroPorciones, fechaRealizado, nombreRealizaPedido);
        this.numMesa = numMesa;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    @Override
    public String tipoOrden() {
        return "Local";
    }
    
    
    
}
