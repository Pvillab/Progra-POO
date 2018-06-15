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
public class PedidoRecoger extends Pedido {
    
    private String nombreRecoger;
    private int numeroCelular;

    /**
     * Constructor
     * @param nombreRecoger
     * @param numeroCelular
     * @param misPlatos
     * @param numeroPorciones
     * @param fechaRealizado
     * @param nombreRealizaPedido 
     */
    public PedidoRecoger(String nombreRecoger, int numeroCelular, ArrayList<Plato> misPlatos, ArrayList<Integer> numeroPorciones, Date fechaRealizado, String nombreRealizaPedido) {
        super(misPlatos, numeroPorciones, fechaRealizado, nombreRealizaPedido);
        this.nombreRecoger = nombreRecoger;
        this.numeroCelular = numeroCelular;
    }

    public String getNombreRecoger() {
        return nombreRecoger;
    }

    public void setNombreRecoger(String nombreRecoger) {
        this.nombreRecoger = nombreRecoger;
    }

    public int getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(int numeroCelular) {
        this.numeroCelular = numeroCelular;
    }
    
    /**
     * Retorna el tipo de orden que tiene el pedido.
     * @return String 
     */
    @Override
    public String tipoOrden() {
        return "Recoger";
    }
}
