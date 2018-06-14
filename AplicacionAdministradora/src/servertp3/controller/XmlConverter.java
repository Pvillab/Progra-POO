/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertp3.controller;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Paul Villafuerte
 */

public class  XmlConverter {
    static void ObjectToXmlPlatos(ListaPlatos lista){
        try {
            File file = new File("C:\\Users\\mosde\\Desktop\\GitHub\\Progra-POO\\Platillos.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(ListaPlatos.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(lista, file);
            jaxbMarshaller.marshal(lista, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    
    static  ListaPlatos XmlToObjectPlatos(){
        try {
            File archivo = new File("C:\\Users\\mosde\\Desktop\\GitHub\\Progra-POO\\Platillos.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(ListaPlatos.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ListaPlatos lista = (ListaPlatos) jaxbUnmarshaller.unmarshal(archivo);
            System.out.println(lista);
            return lista;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        //Si no encuentra nada devuelve una lista vacia
        ListaPlatos listaVacia = new ListaPlatos();
        return listaVacia;
        }
    
    static void ObjectToXmlPedidos(ListaPedidos lista){
        try {
            File file = new File("C:\\Users\\mosde\\Desktop\\GitHub\\Progra-POO\\Pedidos.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(ListaPlatos.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(lista, file);
            jaxbMarshaller.marshal(lista, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    static ListaPedidos XmlToObjectPedidos() {
        try {
            File archivo = new File("C:\\Users\\mosde\\Desktop\\GitHub\\Progra-POO\\Pedidos.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(ListaPlatos.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ListaPedidos lista = (ListaPedidos) jaxbUnmarshaller.unmarshal(archivo);
            System.out.println(lista);
            return lista;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        //Si no encuentra nada devuelve una lista vacia
        ListaPedidos listaVacia = new ListaPedidos();
        return listaVacia;
        }
        
}
