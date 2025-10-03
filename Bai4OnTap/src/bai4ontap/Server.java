package bai4ontap;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String[] args) {
        int port = 3000;
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server đang chạy...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client đã kết nối!");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String input;
                while ((input = in.readLine()) != null) {
                    if (input.equalsIgnoreCase("stop")) break;

                    if (input.equalsIgnoreCase("file")) {
                        try (BufferedReader fr = new BufferedReader(new FileReader("input.txt"))) {
                            String line;
                            while ((line = fr.readLine()) != null) {
                                out.println(xuly(line));
                            }
                        } catch (IOException e) {
                            out.println("Không đọc được file!");
                        }
                    } else {
                        out.println(xuly(input));
                    }
                }

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hàm xử lý dãy số
    private static String xuly(String input) {
        String[] parts = input.split(";");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String p : parts) {
            try {
                numbers.add(Integer.parseInt(p.trim()));
            } catch (Exception ignored) {}
        }

        boolean tangdan = true;
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < numbers.get(i - 1)) {
                tangdan = false;
                break;
            }
        }

        Collections.sort(numbers);
        return (tangdan ? "Dãy tăng dần: " : "Dãy không tăng dần, sau khi sắp xếp: ") + numbers;
    }
}
