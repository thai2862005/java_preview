/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lap.pkg7;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hanoi extends Remote {
    String getName() throws RemoteException;
    String getDate() throws RemoteException;
    String getTime() throws RemoteException;
    double getIndex() throws RemoteException;
}

