import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Nhập a;b;c;d (hoặc gõ quit để thoát): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Kết thúc chương trình.");
                break;
            }

            try {
                // Tách input
                String[] parts = input.split(";");
                int a = Integer.parseInt(parts[0].trim());
                int b = Integer.parseInt(parts[1].trim());
                int c = Integer.parseInt(parts[2].trim());
                int d = Integer.parseInt(parts[3].trim());
                Socket s1 = new Socket("localhost", 5000);
                PrintWriter out1 = new PrintWriter(s1.getOutputStream(), true);
                BufferedReader in1 = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                out1.println(a + ";" + b);
                int kq1 = Integer.parseInt(in1.readLine());
                s1.close();
                Socket s2 = new Socket("localhost", 6000);
                PrintWriter out2 = new PrintWriter(s2.getOutputStream(), true);
                BufferedReader in2 = new BufferedReader(new InputStreamReader(s2.getInputStream()));
                out2.println(c + ";" + d);
                int kq2 = Integer.parseInt(in2.readLine());
                s2.close();

                int S = 56 * kq1 - 23 * kq2;
                System.out.println("Kết quả S = " + S);

            } catch (Exception e) {
                System.out.println("Lỗi nhập dữ liệu, vui lòng thử lại!");
            }
        }
    }
}
