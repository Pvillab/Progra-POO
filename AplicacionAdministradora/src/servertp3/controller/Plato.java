
package servertp3.controller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author Paul Villafuerte
 */

@XmlRootElement
public final class  Plato implements Serializable {
    
    private String codigo;
    private String tipo;
    private String nombre;
    private String descripcion;
    private int racionRecomendada;
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
    public Plato(){};
    
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
    
    @XmlElement
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }
    
    @XmlElement
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }
    
    @XmlElement
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    @XmlElement
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getRacionRecomendada() {
        return racionRecomendada;
    }
    
    @XmlElement
    public void setRacionRecomendada(int racionRecomendada) {
        this.racionRecomendada = racionRecomendada;
    }

    public int getCaloriasPorcion() {
        return caloriasPorcion;
    }

    @XmlElement
    public void setCaloriasPorcion(int caloriasPorcion) {
        this.caloriasPorcion = caloriasPorcion;
    }

    public double getPiezasPorPorcion() {
        return piezasPorPorcion;
    }

    @XmlElement
    public void setPiezasPorPorcion(double piezasPorPorcion) {
        this.piezasPorPorcion = piezasPorPorcion;
    }

    public double getPesoporPorcion() {
        return pesoporPorcion;
    }

    @XmlElement
    public void setPesoporPorcion(double pesoporPorcion) {
        this.pesoporPorcion = pesoporPorcion;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    @XmlElement
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Imagen getMiImagen() {
        return miImagen;
    }

    @XmlElement
    public void setMiImagen(Imagen miImagen) {
        this.miImagen = miImagen;
    }

}
