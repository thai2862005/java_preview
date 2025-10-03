package bai4ontap;

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

            System.out.println("Chọn cách nhập dữ liệu:");
            System.out.println("1. Nhập từ bàn phím");
            System.out.println("2. Yêu cầu server đọc từ file input.txt");
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

        } catch (IOException e) {
            System.out.println("Không kết nối được tới server!");
        }
    }
}
