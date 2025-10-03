/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lap02;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Scanner;
/**
 *
 * @author ACER
 */
public class Lap02_client {
    public static void  main(String args[]){
     

        try {
            int port = 1234;
            Socket sk = new Socket("localhost", port);

            PrintWriter out = new PrintWriter(sk.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.print("Client: ");
                String data = sc.nextLine();
                out.println(data);

                if (data.equalsIgnoreCase("exit")) {
                    System.out.println("Thoát client!");
                    break;
                }

                // nhận phản hồi từ server
                String response = in.readLine();
                if (response == null || response.equalsIgnoreCase("exit")) {
                    System.out.println("Server đã thoát!");
                    break;
                }
                System.out.println("Server: " + response);
            }

            out.close();
            in.close();
            sk.close();
        } catch (Exception e) {
            System.out.println("Lỗi client: " + e.getMessage());
        }
    }
}

    
