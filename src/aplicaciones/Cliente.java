/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciones;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


/**
 *
 * @author alberto
 */
public class Cliente {
    
    
    public static void main(String args[]){
        String nombre;
        String dificultad;
        String palabra;
        
        int letras;
        
        try(Socket s = new Socket("localhost", 5555)){
            nombre = null;
            dificultad = null;
            palabra = null;
            BufferedReader bf;
            PrintWriter pw;
            
            bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
            pw = new PrintWriter(s.getOutputStream(), true);
            Scanner in = new Scanner(System.in);
            
            System.out.println(bf.readLine());
            
            System.out.println("¿Tu qué, quién te crees?");
            nombre = in.nextLine();
            
            System.out.println("¿Qué tan chipotlud@ te sientes?");
            dificultad = in.nextLine();
            
            pw.println(nombre + "," + dificultad);
            
            System.out.println(bf.readLine());
            
            letras = Integer.parseInt(bf.readLine());
            palabra = inicializaPalabra(letras);
            
        }
        catch(Exception e){
            System.out.println("No se pudo establecer la conexión :(");
        }
    }
    
    private static String inicializaPalabra(int length){
        StringBuilder output = new StringBuilder(length);
        
        for(int i = 0; i < length; i++){
            output.append("_");
        }
        
        return output.toString();
    }
    
    
}
