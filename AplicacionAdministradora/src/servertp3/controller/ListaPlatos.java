package servertp3.controller;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Paul Villafuerte
 */
@XmlRootElement
public class ListaPlatos {
    @XmlElementWrapper
    @XmlElement(name = "book")
    ArrayList<Plato> lista;
    
    public ArrayList<Plato> getLista(){
        return lista;
}
    
    public void setListaPlatillos(ArrayList<Plato> lista){
        this.lista = lista;
    }
}
