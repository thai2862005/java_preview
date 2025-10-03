package bai05rmiontap;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TongImd extends UnicastRemoteObject implements Tong {

    public TongImd() throws RemoteException {
        super();
    }

    @Override
    public double tong(double a, double b) throws RemoteException {
        return a + b;
    }
}
