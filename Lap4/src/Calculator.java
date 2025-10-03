import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    int sum(int a ,int b ,int c) throws RemoteException;
}
