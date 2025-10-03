package bai01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        System.out.println("Server đang chạy ...");
        try (ServerSocket svsk = new ServerSocket(9999)) {
            Socket sk = svsk.accept();
            Scanner sc = new Scanner(System.in);
            System.out.println("Server đã kết nối với client");

            BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            PrintWriter out = new PrintWriter(sk.getOutputStream(), true);

            while (true) {
                String input = in.readLine();
                if (input == null || input.equalsIgnoreCase("stop")) break;

                System.out.println("Client: " + input);

                System.out.print("Server: ");
                String dataServer = sc.nextLine();
                out.println(dataServer);
            }

            in.close();
            out.close();
            sk.close();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
