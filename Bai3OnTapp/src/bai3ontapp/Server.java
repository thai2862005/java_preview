package bai3ontapp;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 4000;
        String usernameFile = "";
        String passwordFile = "";
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\\\Users\\\\ACER\\\\Documents\\\\NetBean(\"C:\\\\\\\\Users\\\\\\\\ACERsProjects\\\\Bai3OnTapp\\\\src\\\\bai3ontapp\\\\user.txt"))) {
            String line = br.readLine();
            if (line != null) {
                String[] parts = line.split(";");
                usernameFile = parts[0].trim();
                passwordFile = parts[1].trim();
            }
        } catch (IOException e) {
            System.out.println("Không đọc được file user.txt");
            return;
        }

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server đang chạy...");

            Socket client = serverSocket.accept();
            System.out.println("Client đã kết nối!");

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            int attempts = 0;
            while (attempts < 3) {
                String user = in.readLine();
                String pass = in.readLine();

                if (user.equals(usernameFile) && pass.equals(passwordFile)) {
                    out.println("OK");
                    break;
                } else {
                    attempts++;
                    out.println("Lỗi");
                }
            }

            if (attempts >= 3) {
                out.println("BLOCK");
            }

            client.close();
        } catch (IOException e) {
            System.out.println("Lỗi server: " + e.getMessage());
        }
    }
}
