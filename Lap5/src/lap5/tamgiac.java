/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lap5;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author ACER
 */
public interface tamgiac extends Remote{
            String kiemTraTamGiac(int a ,int b ,int c)throws RemoteException;
}
