/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.net.ssl.SSLServerSocket;

/**
 *
 * @author ACER
 */
public class Server {
    public static void main(String[] args){
    int port =3000;
        System.out.println("Server chay...");
        try {
            ServerSocket svsk = new ServerSocket(port);
            Socket sk = svsk.accept();
            System.out.println("da connection");
            BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            PrintWriter out = new PrintWriter(sk.getOutputStream(),true);
            Scanner sc = new Scanner(System.in);
            System.out.println("server: ");
            String res = sc.nextLine();
             out.print(res);
            String dataCLient = in.readLine();
            System.out.println("data tu nguoi dung :"+dataCLient);
           
             out.close();
            in.close();
            sk.close();
            
        } catch (Exception e) {
            System.out.println("nem loi"+e.getMessage());
        }
    
    }
}
