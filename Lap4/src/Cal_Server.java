import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Cal_Server extends UnicastRemoteObject implements Calculator {

    protected Cal_Server() throws RemoteException {
        super();
    }

    @Override
    public int sum(int a, int b, int c) throws RemoteException {
    if (a == 0) {
        if (b == 0) {
            return 0;
        } else {
            return -c / b; 
        }
    }

    int delta = b * b - 4 * a * c;

    if (delta < 0) {
        return 0;
    } else if (delta == 0) {
        return -b / (2 * a); 
    } else {
        int x1 = (int)((-b + Math.sqrt(delta)) / (2 * a));
        int x2 = (int)((-b - Math.sqrt(delta)) / (2 * a));
        return Math.min(x1, x2); 
    }
}

    public static void main(String[] args) {
        try {
            Cal_Server server = new Cal_Server();

            Registry reg = LocateRegistry.createRegistry(9999);

            reg.rebind("Calculator", server);

            System.out.println("Server đã sẵn sàng...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
