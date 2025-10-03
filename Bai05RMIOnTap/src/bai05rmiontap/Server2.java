package bai05rmiontap;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server2 {
    public static void main(String[] args) {
        System.out.println("Máy chủ 2 (Hiệu) đang chạy...");
        try {
            Registry reg = LocateRegistry.createRegistry(9998);
            HieuImd hieu = new HieuImd();
            reg.bind("server2", hieu);
            System.out.println("Đã bind server2 tại cổng 9998");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
