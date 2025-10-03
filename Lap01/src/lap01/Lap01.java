/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lap01;

import java.io.*;
/**
 *
 * @author ACER
 */
public class Lap01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        try{
        byte data[] = new byte[100];
         System.out.println("nhap ky tu ");
        System.in.read(data);
        System.out.print(" Cac ky tu cua ban da nhap: "); 
        for(int i=0; i < data.length; i++) {
        System.out.print((char) data[i]); 
        }
        }catch(Exception e){
            System.out.println("failth"
                    + "1");
            
        }
        
    }
    
}
