/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lap.pkg7;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class HanoiImpl extends UnicastRemoteObject implements Hanoi {
    private String name = "San giao dich Ha Noi";
    private Random random = new Random();

    public HanoiImpl() throws RemoteException {
        super();
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }

    @Override
    public String getDate() throws RemoteException {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }

    @Override
    public String getTime() throws RemoteException {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    @Override
    public double getIndex() throws RemoteException {
        return 1000 + random.nextDouble() * 100;
    }
}

