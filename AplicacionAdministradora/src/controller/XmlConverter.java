/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
    /**
     * Genera un xml a partir de una lista de platos.
     * @param lista 
     */
    static void ObjectToXmlPlatos(ListaPlatos lista){
        
        File file = new File("C:\\Users\\mosde\\Desktop\\GitHub\\Progra-POO\\Platillos.xml"); 
            try {
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
    
    /**
     * Generea un arreglo de platos a partir de un Xml.
     * @return 
     */
    static ListaPlatos XmlToObjectPlatos(){
        File file = new File("C:\\Users\\mosde\\Desktop\\GitHub\\Progra-POO\\Platillos.xml");
        if(file.exists() && !file.isDirectory()) {
            
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(ListaPlatos.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                ListaPlatos lista = (ListaPlatos) jaxbUnmarshaller.unmarshal(file);
                System.out.println(lista);
                return lista;

            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        //Si no encuentra nada devuelve una lista vacia
        ListaPlatos listaVacia = new ListaPlatos();
        return listaVacia;
        }
    
    /**
     * Genera un Xml a partir de un arreglo de pedidos.
     * @param lista 
     */
    static void ObjectToXmlPedidos(ListaPedidos lista){
        File file = new File("C:\\Users\\mosde\\Desktop\\GitHub\\Progra-POO\\Platillos.xml");
        
            try {
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

    /**
     * Genera un xml a partir de una lista de pedidos.
     * @return 
     */
    static ListaPedidos XmlToObjectPedidos() {
        File file = new File("C:\\Users\\mosde\\Desktop\\GitHub\\Progra-POO\\Platillos.xml");
        if(file.exists() && !file.isDirectory()) { 
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
        }
        //Si no encuentra nada devuelve una lista vacia
        ListaPedidos listaVacia = new ListaPedidos();
        return listaVacia;
        }
        
}
