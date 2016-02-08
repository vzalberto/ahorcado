/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author alberto
 */
public class Servidor {
    private static final String BIENVENIDA = "Bienvenido al juego de ahorcado";
    
    public static void main (String args[]){
        int clientes = 0;
        try(ServerSocket listener = new ServerSocket(5555)){
            System.out.println("Servidor listo en " + listener);
           try(Socket s = listener.accept()){
               System.out.println("Atendiendo al cliente no. " + (++clientes));
               
               PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
               BufferedReader bf;
                bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
                
                pw.println(BIENVENIDA);
               // bienvenida(pw);
                
           }
           catch(Exception e){
               System.out.println("No se pudo recibir al cliente");
           }
        }
        catch(Exception e){
            System.out.println("No se pudo inicializar el servidor :(");
        }
    }
    
    
}
