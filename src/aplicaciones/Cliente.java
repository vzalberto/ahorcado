/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciones;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author alberto
 */
public class Cliente {
    
    public static void main(String args[]){
        try(Socket s = new Socket("localhost", 5555)){
            BufferedReader bf;
            bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
            
            System.out.println(bf.readLine());
        }
        catch(Exception e){
            
        }
    }
    
}
