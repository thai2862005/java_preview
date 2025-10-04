package  bai5ontap;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Nhập a;b;c;d (hoặc gõ 2 để đọc file, quit để thoát): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Kết thúc chương trình.");
                break;
            }
            Socket s1 = new Socket("localhost", 5000);
            PrintWriter out1 = new PrintWriter(s1.getOutputStream(), true);
            BufferedReader in1 = new BufferedReader(new InputStreamReader(s1.getInputStream()));

            Socket s2 = new Socket("localhost", 6000);
            PrintWriter out2 = new PrintWriter(s2.getOutputStream(), true);
            BufferedReader in2 = new BufferedReader(new InputStreamReader(s2.getInputStream()));

            if (input.equalsIgnoreCase("2")) {
                out1.println("file");
                out2.println("file");

                String line1, line2;
                while ((line1 = in1.readLine()) != null && (line2 = in2.readLine()) != null) {
                    int kq1 = Integer.parseInt(line1);
                    int kq2 = Integer.parseInt(line2);
                    int kq3 =  56 * kq1 - 23 * kq2;
                    System.out.println("Kết quả = " + kq3);
                }

                s1.close();
                s2.close();
                continue;
            }

            try {
                String[] parts = input.split(";");
                int a = Integer.parseInt(parts[0].trim());
                int b = Integer.parseInt(parts[1].trim());
                int c = Integer.parseInt(parts[2].trim());
                int d = Integer.parseInt(parts[3].trim());

                out1.println(a + ";" + b);
                int kq1 = Integer.parseInt(in1.readLine());

                out2.println(c + ";" + d);
                int kq2 = Integer.parseInt(in2.readLine());

                int S = 56 * kq1 - 23 * kq2;
                System.out.println("Kết quả S = " + S);

            } catch (Exception e) {
                System.out.println("Lỗi nhập dữ liệu, vui lòng thử lại!");
            } finally {
                s1.close();
                s2.close();
            }
        }
    }
}
