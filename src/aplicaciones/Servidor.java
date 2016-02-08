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
import java.util.StringTokenizer;

/**
 *
 * @author alberto
 */
public class Servidor {
    private static final String BIENVENIDA = "Bienvenido al juego de ahorcado";
    
    public static void main (String args[]){
        int clientes = 0;
        String nombre;
        String dificultad;
        String palabra;
        String respuesta;
        int numeroLetras;
        
        boolean isGameFinished;
        
        try(ServerSocket listener = new ServerSocket(5555)){
            System.out.println("Servidor listo en " + listener);
           try(Socket s = listener.accept()){
               
               System.out.println("Atendiendo al cliente no. " + (++clientes));
               
               PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
               BufferedReader bf;
                bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
                
               isGameFinished = false;
               pw.println(BIENVENIDA);
               
               //Leer nombre y dificultad
               StringTokenizer st = new StringTokenizer(bf.readLine(), ",");
               
               nombre = st.nextToken();
               dificultad = st.nextToken();
               
               pw.println("A ver si es cierto, " + nombre + ". Escogiste la dificultad " + dificultad);
               
               //Genera lista de palabras
               palabra = generaPalabra(dificultad);
               numeroLetras = palabra.length();
               
               //Enviar #letras
               pw.println(numeroLetras);
               
               
               while(!isGameFinished){
                   respuesta = bf.readLine();
                   
                   if("ERROR".equals(respuesta)){
                       System.out.println("El jugador no. " + clientes + " ya la cagó");
                       isGameFinished = true;
                   }
                   
                   //Si letra existe, enviar indices separados por comas
                   //Si letra no existe enviar mensaje de error
                   //Si letra repetida, no se quiera pasar de verga
                   
                   
                   
               }
                
           }
           catch(Exception e){
               System.out.println("No se pudo recibir al cliente");
           }
        }
        catch(Exception e){
            System.out.println("No se pudo inicializar el servidor :(");
        }
    }
    
    private static String generaPalabra(String dificultad){
        String palabra;
        
        switch(dificultad){
            case "1":
                return "popis";
            case "2":
                return "panochita";
            case "3":
                return "milosidad";
            default:
                return "please";
        }
        
    }
    
    
}
