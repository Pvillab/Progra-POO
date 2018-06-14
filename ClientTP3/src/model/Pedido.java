/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mosde
 */
public abstract class Pedido implements Serializable  {
    private ArrayList <Plato> misPlatos;
    private ArrayList<Integer> numeroPorciones;
    private Date fechaRealizado;
    private static int numeroSerial;
    private String nombreRealizaPedido;

    public Pedido(ArrayList<Plato> misPlatos, ArrayList<Integer> numeroPorciones, Date fechaRealizado, String nombreRealizaPedido) {
        this.misPlatos = misPlatos;
        this.numeroPorciones = numeroPorciones;
        this.fechaRealizado = fechaRealizado;
        this.nombreRealizaPedido = nombreRealizaPedido;
    }

    public ArrayList<Plato> getMisPlatos() {
        return misPlatos;
    }

    public void setMisPlatos(ArrayList<Plato> misPlatos) {
        this.misPlatos = misPlatos;
    }

    public ArrayList<Integer> getNumeroPorciones() {
        return numeroPorciones;
    }

    public void setNumeroPorciones(ArrayList<Integer> numeroPorciones) {
        this.numeroPorciones = numeroPorciones;
    }

    public Date getFechaRealizado() {
        return fechaRealizado;
    }

    public void setFechaRealizado(Date fechaRealizado) {
        this.fechaRealizado = fechaRealizado;
    }

    public static int getNumeroSerial() {
        return numeroSerial;
    }

    public static void setNumeroSerial(int numeroSerial) {
        Pedido.numeroSerial = numeroSerial;
    }

    public String getNombreRealizaPedido() {
        return nombreRealizaPedido;
    }

    public void setNombreRealizaPedido(String nombreRealizaPedido) {
        this.nombreRealizaPedido = nombreRealizaPedido;
    }
    
    public abstract String tipoOrden();
    
    
}
