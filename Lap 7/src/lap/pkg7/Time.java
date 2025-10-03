/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lap.pkg7;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Time extends Remote {
    String getCurrentDate() throws RemoteException;
}

