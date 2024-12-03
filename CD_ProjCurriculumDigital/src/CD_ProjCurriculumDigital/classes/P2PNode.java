/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CD_ProjCurriculumDigital.classes;

/**
 *
 * @author asus
 */
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created on 27/11/2024, 18:04:02 
 * @author manso - computer
 */
public class P2PNode {
    static int port = 10_014;
    static String name = "P2P";

            
    public static void main(String[] args) throws Exception {
       //create object  to listen in the remote port
       
       
        //local adress of server
        String host = InetAddress.getLocalHost().getHostAddress();
        //create registry to object
        LocateRegistry.createRegistry(port);
        //create adress of remote object
        String address = String.format("//%s:%d/%s", host, port, name);
        ObjetoRemoto rmtObj = new ObjetoRemoto (address,null);
        //link adress to object 
        Naming.rebind(address, rmtObj);
        System.out.printf("Remote object ready at %s", address);
        
        //node 10
        InterfaceRemota node = (InterfaceRemota) RMI.getRemote("//10.10.208.35:10010/P2P");
        
        rmtObj.addNode(node);
        
////        
       
        
        
    }  
}
