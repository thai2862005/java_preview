package bai05rmiontap;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server1 {
    public static void main(String[] args) {
        System.out.println("Máy chủ 1 (Tổng) đang chạy...");
        try {
            Registry reg = LocateRegistry.createRegistry(9999);
            TongImd tong = new TongImd();
            reg.bind("server1", tong);
            System.out.println("Đã bind server1 tại cổng 9999");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
