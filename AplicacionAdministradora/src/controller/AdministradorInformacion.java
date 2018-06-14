/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Pedido;
import model.Plato;

/**
 *Esta clase mantendra el orden en la informacion que tiene el servidor
 * @author mosde
 */
public class AdministradorInformacion {
    
    private ListaPlatos misPlatos;
    private ListaPedidos misPedidos;
    private double precioExpres;
    private double preciopaquete;

    /**
     * Al llamar a este contructor, se llamara a los metodos de lectura al XML
     */
    public AdministradorInformacion() {
        this.misPlatos = XmlConverter.XmlToObjectPlatos();
        this.misPedidos = XmlConverter.XmlToObjectPedidos();
        
    }
    
    

    public ListaPlatos getMisPlatos() {
        return misPlatos;
    }

    public void setMisPlatos(ListaPlatos misPlatos) {
        this.misPlatos = misPlatos;
    }

    public ListaPedidos getMisPedidos() {
        return misPedidos;
    }

    public void setMisPedidos(ListaPedidos misOrdenes) {
        this.misPedidos = misOrdenes;
    }

    public double getPrecioExpres() {
        return precioExpres;
    }

    public void setPrecioExpres(double precioExpres) {
        this.precioExpres = precioExpres;
    }

    public double getPreciopaquete() {
        return preciopaquete;
    }

    public void setPreciopaquete(double preciopaquete) {
        this.preciopaquete = preciopaquete;
    }
    
    //Agrega el platillo y lo salva en la memoria
    public void agregarPlatillo(Plato agrePlato){
        this.misPlatos.addListaPlatillos(agrePlato);
        XmlConverter.ObjectToXmlPlatos(misPlatos);
       
    }

    void agregarPedido(Pedido ENVIONUEVO ) {
        this.misPedidos.lista.add(ENVIONUEVO);
    }
      
    
}
