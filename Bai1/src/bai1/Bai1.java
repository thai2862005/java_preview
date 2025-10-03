/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.print.attribute.standard.Severity;

/**
 *
 * @author ACER
 */
public class Bai1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int port = 3000;
        Socket sk = new Socket("localhost", port);
        PrintWriter out = new PrintWriter(sk.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            Scanner sc = new Scanner(System.in);
            System.out.print("Client: ");
            String data = sc.nextLine();
            out.println(data);
            String res = in.readLine();
            System.out.println("data tu server : "+res);
             out.close();
            in.close();
            sk.close();
    }
    
}
