package bai05rmiontap;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HieuImd extends UnicastRemoteObject implements Hieu {

    public HieuImd() throws RemoteException {
        super();
    }

    @Override
    public double Hieu(double c, double d) throws RemoteException {
        return c - d;
    }
}
