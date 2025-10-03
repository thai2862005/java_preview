import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CaLclient {
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 9999);

            Calculator cal = (Calculator) reg.lookup("Calculator");

            System.out.println("===== CHƯƠNG TRÌNH CLIENT (RMI) =====");

            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập số a: ");
            int a = sc.nextInt();
            System.out.print("Nhập số b: ");
            int b = sc.nextInt();
            System.out.print("Nhập số c: ");
            int c = sc.nextInt();

            int result = cal.sum(a, b, c);
            if (result == 0) {
                System.out.println("Phương trình vô nghiệm (hoặc vô số nghiệm).");
            } else {
                System.out.println("Nghiệm tìm được = " + result);
            }

            sc.close();

        } catch (RemoteException err) {
            System.out.println("Lỗi kết nối tới Server: " + err.getMessage());
        } catch (NotBoundException err) {
            System.out.println("Không tìm thấy đối tượng remote trên Server: " + err.getMessage());
        }
    }
}
