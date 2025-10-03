/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lap.pkg7;

/**
 *
 * @author ACER
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RateServer extends Remote {
    String getHanoiInfo() throws RemoteException;
}

