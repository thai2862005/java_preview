package lap5;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class sever extends UnicastRemoteObject implements tamgiac {

    protected sever() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        try {
            sever server = new sever();
            Registry reg = LocateRegistry.createRegistry(9999);
            reg.rebind("Tamgiac", (Remote) server);
            System.out.println("Server đã sẵn sàng...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String kiemTraTamGiac(int a, int b, int c) throws RemoteException {
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "Không phải là tam giác";
        }

        if (a == b && b == c) {
            return "Tam giác đều";
        } else if (a == b || b == c || a == c) {
            return "Tam giác cân";
        } else if (a * a + b * b == c * c ||
                   a * a + c * c == b * b ||
                   b * b + c * c == a * a) {
            return "Tam giác vuông";
        } else {
            return "Tam giác thường";
        }
    }
}
