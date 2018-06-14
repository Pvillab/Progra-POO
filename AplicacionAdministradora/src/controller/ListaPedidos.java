/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import model.Pedido;

/**
 *
 * @author mosde
 */
class ListaPedidos implements Serializable {
    
    @XmlElementWrapper
    @XmlElement(name = "book")
    ArrayList<Pedido> lista;
    
    public ArrayList<Pedido> getLista(){
        return lista;
}
    
    public void setListaPlatillos(ArrayList<Pedido> lista){
        this.lista = lista;
    }
    
}
