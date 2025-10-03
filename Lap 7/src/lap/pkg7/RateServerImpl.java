/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lap.pkg7;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class RateServerImpl extends UnicastRemoteObject implements RateServer {
    private Hanoi hanoi;

    public RateServerImpl(Hanoi hanoi) throws RemoteException {
        super();
        this.hanoi = hanoi;
    }

    @Override
    public String getHanoiInfo() throws RemoteException {
        return hanoi.getName() + " | Ngay: " + hanoi.getDate() + " | Gio: " 
               + hanoi.getTime() + " | Index: " + hanoi.getIndex();
    }
}

