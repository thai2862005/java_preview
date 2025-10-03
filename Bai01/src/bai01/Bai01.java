package bai01;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Bai01 {
    public static void main(String[] args) {
        try {
            Socket sk = new Socket("localhost", 9999);
            PrintWriter out = new PrintWriter(sk.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.print("Client: ");
                String res = sc.nextLine();
                out.println(res);

                if (res.equalsIgnoreCase("stop")) break;

                String line = in.readLine();
                System.out.println("Server: " + line);
            }

            in.close();
            out.close();
            sk.close();

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
