/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bai05rmiontap;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author ACER
 */
public interface Hieu extends Remote{
       public double  Hieu(double c, double d) throws RemoteException;
}
