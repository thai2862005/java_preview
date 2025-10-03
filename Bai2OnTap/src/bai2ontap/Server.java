package bai2ontap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 3000;
        System.out.println("Server đang chạy...");
        try (ServerSocket svsk = new ServerSocket(port)) {
            Socket sk = svsk.accept();
            System.out.println("Đã kết nối với Client");

            BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            PrintWriter out = new PrintWriter(sk.getOutputStream(), true);

            String input;
            while ((input = in.readLine()) != null && !input.equalsIgnoreCase("stop")) {
                try {
                    if (input.equalsIgnoreCase("file")) {
                        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                String[] parts = line.split(";");
                                if (parts.length == 3) {
                                    double a = Double.parseDouble(parts[0].trim());
                                    double b = Double.parseDouble(parts[1].trim());
                                    double c = Double.parseDouble(parts[2].trim());

                                    String kq = giaiPTBac2(a, b, c);
                                    out.println(kq);
                                } else {
                                    out.println("Sai định dạng trong file: " + line);
                                }
                            }
                        }
                    } else {
                        String[] parts = input.split(";");
                        if (parts.length == 3) {
                            double a = Double.parseDouble(parts[0].trim());
                            double b = Double.parseDouble(parts[1].trim());
                            double c = Double.parseDouble(parts[2].trim());

                            String kq = giaiPTBac2(a, b, c);
                            out.println(kq);
                        } else {
                            out.println("Sai định dạng dữ liệu nhập!");
                        }
                    }
                } catch (Exception e) {
                    out.println("Lỗi xử lý: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi kết nối: " + e.getMessage());
        }
    }

    public static String giaiPTBac2(double a, double b, double c) {
        if (a == 0) {
            if (b == 0) {
                return (c == 0) ? "Phương trình vô số nghiệm" : "Phương trình vô nghiệm";
            }
            return "Phương trình có nghiệm: x = " + (-c / b);
        }

        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            return "Phương trình vô nghiệm";
        } else if (delta == 0) {
            return "Phương trình có nghiệm kép: x = " + (-b / (2 * a));
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            return "Phương trình có 2 nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2;
        }
    }
}
