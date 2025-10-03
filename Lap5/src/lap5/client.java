package lap5;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 9999);

            tamgiac tamGiac = (tamgiac) reg.lookup("Tamgiac");

            System.out.println("===== CHƯƠNG TRÌNH CLIENT (RMI) =====");

            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập số a: ");
            int a = sc.nextInt();
            System.out.print("Nhập số b: ");
            int b = sc.nextInt();
            System.out.print("Nhập số c: ");
            int c = sc.nextInt();

            // Gọi hàm từ server
            String result = tamGiac.kiemTraTamGiac(a, b, c);

            // Hiển thị kết quả
            System.out.println("Kết quả: " + result);

            sc.close();

        } catch (RemoteException err) {
            System.out.println("Lỗi kết nối tới Server: " + err.getMessage());
        } catch (NotBoundException err) {
            System.out.println("Không tìm thấy đối tượng remote trên Server: " + err.getMessage());
        }
    }
}
