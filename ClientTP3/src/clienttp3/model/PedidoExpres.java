/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttp3.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mosde
 */
public class PedidoExpres extends Pedido {
    
    private String nnombreRecoger;
    private int numeroCelular;
    private String ubicacionExacta;

    public PedidoExpres(String nnombreRecoger, int numeroCelular, String ubicacionExacta, ArrayList<Plato> misPlatos, ArrayList<Integer> numeroPorciones, Date fechaRealizado, String nombreRealizaPedido) {
        super(misPlatos, numeroPorciones, fechaRealizado, nombreRealizaPedido);
        this.nnombreRecoger = nnombreRecoger;
        this.numeroCelular = numeroCelular;
        this.ubicacionExacta = ubicacionExacta;
    }

    public String getNnombreRecoger() {
        return nnombreRecoger;
    }

    public void setNnombreRecoger(String nnombreRecoger) {
        this.nnombreRecoger = nnombreRecoger;
    }

    public int getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(int numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getUbicacionExacta() {
        return ubicacionExacta;
    }

    public void setUbicacionExacta(String ubicacionExacta) {
        this.ubicacionExacta = ubicacionExacta;
    }

    @Override
    public String tipoOrden() {
        return "Expres";
    }
    
    
    
    
}
