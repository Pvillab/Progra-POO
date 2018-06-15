/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.Serializable;

/**
 * 
 * @author mosde
 */
public final class  Plato implements Serializable {
    
    private String codigo;
    private String tipo;
    private String nombre;
    private String descripcion;
    private int racionRecomendada;
    private double precio;
    private int caloriasPorcion;
    private double piezasPorPorcion;
    private double pesoporPorcion;
    private boolean habilitado;
    private Imagen miImagen;

    /**
     * Constructor sin imagen
     * @param codigo
     * @param tipo
     * @param nombre
     * @param descripcion
     * @param racionRecomendada
     * @param caloriasPorcion
     * @param piezasPorPorcion
     * @param pesoporPorcion
     * @param habilitado 
     */
    public Plato(String codigo, String tipo, String nombre, String descripcion, int racionRecomendada, int caloriasPorcion, double piezasPorPorcion, double pesoporPorcion, boolean habilitado) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.racionRecomendada = racionRecomendada;
        this.caloriasPorcion = caloriasPorcion;
        this.piezasPorPorcion = piezasPorPorcion;
        this.pesoporPorcion = pesoporPorcion;
        this.habilitado = habilitado;
        this.miImagen=null;
    }

    /**
     * Constructor con imagen
     * @param codigo
     * @param tipo
     * @param nombre
     * @param descripcion
     * @param racionRecomendada
     * @param caloriasPorcion
     * @param piezasPorPorcion
     * @param pesoporPorcion
     * @param habilitado
     * @param miImagen 
     */
    public Plato(String codigo, String tipo, String nombre, String descripcion, int racionRecomendada, int caloriasPorcion, double piezasPorPorcion, double pesoporPorcion, boolean habilitado, Imagen miImagen) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.racionRecomendada = racionRecomendada;
        this.caloriasPorcion = caloriasPorcion;
        this.piezasPorPorcion = piezasPorPorcion;
        this.pesoporPorcion = pesoporPorcion;
        this.habilitado = habilitado;
        this.miImagen = miImagen;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getRacionRecomendada() {
        return racionRecomendada;
    }

    public void setRacionRecomendada(int racionRecomendada) {
        this.racionRecomendada = racionRecomendada;
    }

    public int getCaloriasPorcion() {
        return caloriasPorcion;
    }

    public void setCaloriasPorcion(int caloriasPorcion) {
        this.caloriasPorcion = caloriasPorcion;
    }

    public double getPiezasPorPorcion() {
        return piezasPorPorcion;
    }

    public void setPiezasPorPorcion(double piezasPorPorcion) {
        this.piezasPorPorcion = piezasPorPorcion;
    }

    public double getPesoporPorcion() {
        return pesoporPorcion;
    }

    public void setPesoporPorcion(double pesoporPorcion) {
        this.pesoporPorcion = pesoporPorcion;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Imagen getMiImagen() {
        return miImagen;
    }

    public void setMiImagen(Imagen miImagen) {
        this.miImagen = miImagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
