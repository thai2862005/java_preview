package bai05rmiontap;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("Máy khách đang chạy...");

        try {
            Registry reg1 = LocateRegistry.getRegistry("localhost", 9999);
            Tong tong = (Tong) reg1.lookup("server1");
            System.out.println("Kết nối thành công với Server1 (Tổng)");

            Registry reg2 = LocateRegistry.getRegistry("localhost", 9998);
            Hieu hieu = (Hieu) reg2.lookup("server2");
            System.out.println("Kết nối thành công với Server2 (Hiệu)");

            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập 4 số a, b, c, d:");

            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double c = sc.nextDouble();
            double d = sc.nextDouble();

            double kqTong = tong.tong(a, b);
            double kqHieu = hieu.Hieu(c, d);
            double kq = 56*kqTong -23*kqHieu;
//            System.out.println("Kết quả Tổng (a+b): " + kqTong);
//            System.out.println("Kết quả Hiệu (c-d): " + kqHieu);
            System.out.println("Kết quả cuối cùng : "+kq);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
