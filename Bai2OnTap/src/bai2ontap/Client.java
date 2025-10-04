package bai2ontap;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 3000;

        try (Socket socket = new Socket(host, port)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập cách nhập dữ liệu:");
            System.out.println("1. Từ bàn phím");
            System.out.println("2. Từ file input.txt");
            int option = sc.nextInt();
            sc.nextLine(); 
            if (option == 1) {
                System.out.println("Nhập dãy số, cách nhau bởi ';' (gõ 'stop' để kết thúc):");
                while (true) {
                    String line = sc.nextLine();
                    out.println(line);
                    if (line.equalsIgnoreCase("stop")) break;
                    String response = in.readLine();
                    System.out.println("Server: " + response);
                }
            } else if (option == 2) {
                 out.println("file");
                 String response;
    while ((response = in.readLine()) != null) {
        System.out.println("Server: " + response);
                 }
                }
            socket.close();
        } catch (IOException e) {
            System.out.println("server không kết nối được ");
        }
    }
}
