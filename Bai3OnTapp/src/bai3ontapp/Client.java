package bai3ontapp;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 4000;

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("===== WELCOME TO LOGIN SYSTEM =====");

            int attempts = 0;
            while (attempts < 3) {
                System.out.print("Nhập User Name: ");
                String username = sc.nextLine();
                System.out.print("Nhập Password: ");
                String password = sc.nextLine();
                out.println(username);
                out.println(password);
                String phanhoi = in.readLine();
                if (phanhoi.equals("OK")) {
                    System.out.println("✅ Đăng nhập thành công!");
                    break;
                } else if (phanhoi.equals("FAIL")) {
                    attempts++;
                    System.out.println("❌ Sai tài khoản hoặc mật khẩu. Thử lại (" + attempts + "/3)");
                } else if (phanhoi.equals("BLOCK")) {
                    System.out.println("⛔ Sai quá 3 lần. Ngắt kết nối.");
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Lỗi Client: " + e.getMessage());
        }
    }
}
