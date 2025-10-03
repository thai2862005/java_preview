/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lap.pkg7;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            RateServer rateServer = (RateServer) registry.lookup("RateServer");
            System.out.println(rateServer.getHanoiInfo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
