/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lap.pkg7;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            Hanoi hanoi = new HanoiImpl();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Hanoi", hanoi);
            RateServer rateServer = new RateServerImpl(hanoi);
            registry.rebind("RateServer", rateServer);
            System.out.println("Server da san sang...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

