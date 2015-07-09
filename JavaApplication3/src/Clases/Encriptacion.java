/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.security.MessageDigest;


public class Encriptacion {

    public static String encriptar(String texto) {
        StringBuilder sb = new StringBuilder();
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(texto.getBytes());
            byte byteData[] = md.digest();
            for(int i = 0; i < byteData.length; i++){
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }            
        }
        catch(Exception e){
                        
        }
        return sb.toString();
    }
    
    
}
