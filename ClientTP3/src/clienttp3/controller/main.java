package clienttp3.controller;


import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mosde
 */
public class main {
    
    public static void main(String[] args) throws IOException {
        ClienteTP3 miServer = new ClienteTP3();
        miServer.start();
        
        while(true){
            System.out.println(miServer.prueba());
        }
        
        // TODO code application logic here
    }
    
}


