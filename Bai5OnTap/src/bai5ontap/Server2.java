package bai5ontap;
import java.io.*;
import java.net.*;

public class Server2 {
    public static void main(String[] args) {
        int port = 6000; // cổng Server2
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server2 đang chạy trên cổng " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String data = in.readLine(); 
                String[] parts = data.split(";");
                int c = Integer.parseInt(parts[0].trim());
                int d = Integer.parseInt(parts[1].trim());

                int kq = 3 * c - 6 * d;
                out.println(kq);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
