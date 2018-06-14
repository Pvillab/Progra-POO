package controller;
import java.io.Serializable;
import model.Plato;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Paul Villafuerte
 */
@XmlRootElement
public class ListaPlatos implements Serializable {
    @XmlElementWrapper
    @XmlElement(name = "book")
    ArrayList<Plato> lista;
    
    public ArrayList<Plato> getLista(){
        return lista;
}
    
    public void setListaPlatillos(ArrayList<Plato> lista){
        this.lista = lista;
    }
    
    public void addListaPlatillos(Plato plato){
        this.lista.add(plato);
    }
}
