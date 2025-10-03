package bai5ontap;
import java.io.*;
import java.net.*;

public class Server1 {
    public static void main(String[] args) {
        int port = 5000; // cổng Server1
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server1 đang chạy trên cổng " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                String data = in.readLine(); 
                String[] parts = data.split(";");
                int a = Integer.parseInt(parts[0].trim());
                int b = Integer.parseInt(parts[1].trim());

                int kq = 2 * a + 3 * b;
                out.println(kq);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
