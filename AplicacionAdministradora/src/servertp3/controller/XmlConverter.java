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

public class XmlConverter {
    static void ObjectToXml(ListaPlatos lista){
        try {
            File file = new File("C:\\Users\\Paul Villafuerte\\Documents\\GitHub\\Progra-POO\\file.xml");
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
    
    static void XmlToObject(String nombreArchivo){
        try {
            File archivo = new File("C:\\Users\\Paul Villafuerte\\Documents\\GitHub\\Progra-POO\\"+nombreArchivo+".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(ListaPlatos.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ListaPlatos lista = (ListaPlatos) jaxbUnmarshaller.unmarshal(archivo);
            System.out.println(lista);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
