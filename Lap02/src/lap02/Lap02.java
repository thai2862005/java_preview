/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lap02;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;
/**
 *
 * @author ACER
 */
public class Lap02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        System.out.println("nhập dữ liệu ");
//        Scanner sc = new Scanner(System.in);
//        String data = sc.nextLine();
        try {
//       InetAddress adr = InetAddress.getByName("www.dtu.edu.vn");
//       int port = 80;
//       Socket sk = new Socket(adr, port);
int port = 1234;
    ServerSocket sv = new ServerSocket(port);
    Socket sk = sv.accept();
    System.out.println("đã connect máy chủ ");
            BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            PrintWriter out = new PrintWriter(sk.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);
            while(true){
            String msgclient = in.readLine();
            if(msgclient == null || msgclient.equalsIgnoreCase("exit")){
                System.out.println("client out");
                break;
            }
             System.out.println("Client: " + msgclient);
            System.out.print("Sever : ");
            String response = sc.nextLine();
            out.println(response);
             if (response.equalsIgnoreCase("exit")) {
                    System.out.println("Server thoát!");
                    break;
                }
            }
    in.close();
    sk.close();
    sv.close();
            } catch (Exception e) {
            System.out.println("lỗi connect");
        }
    }
    
}
//model contact
//id int increment
//email string
//message string