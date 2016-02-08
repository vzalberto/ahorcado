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
        try(Socket s = new Socket("localhost", 5555)){
            nombre = null;
            dificultad = null;
            BufferedReader bf;
            PrintWriter pw;
            
            bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
            pw = new PrintWriter(s.getOutputStream(), true);
            Scanner in = new Scanner(System.in);
            
            System.out.println(bf.readLine());
            
            System.out.println("¿Tu qué, quién te crees?");
            nombre = in.nextLine();
            
            System.out.println("¿Qué tan picud@ te sientes?");
            dificultad = in.nextLine();
            
            pw.println(nombre + "," + dificultad);
            
        }
        catch(Exception e){
            
        }
    }
    
}
