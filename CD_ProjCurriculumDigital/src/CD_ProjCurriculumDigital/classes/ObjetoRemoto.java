/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CD_ProjCurriculumDigital.classes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author asus
 */
public class ObjetoRemoto extends UnicastRemoteObject implements InterfaceRemota {

    String address;
    CopyOnWriteArrayList<InterfaceRemota> network;
    CopyOnWriteArraySet<String> transactions;
    P2Plistener listener;

    public static String fileCurriculumDigital = "curriculumDigital.obj";
    //cria um objeto do tipo CurriculumDigital
    CurriculumDigital curriculo;

    public ObjetoRemoto(String address, P2Plistener listener) throws RemoteException {
        super(RMI.getAdressPort(address));
        this.address = address;
        this.network = new CopyOnWriteArrayList<>();
        transactions = new CopyOnWriteArraySet<>();
        // addNode(this);
        this.listener = listener;
        listener.onStart("Object " + address + " listening");

        System.out.println("Object " + address + " listening");

    }

    @Override
    public String getAdress() throws RemoteException {
        return address;
    }

    private boolean isInNetwork(String adress) {
        for (int i = network.size() - 1; i >= 0; i--) {
            try {
                if (network.get(i).getAdress().equals(adress)) {
                    return true;
                }
            } catch (RemoteException ex) {
                network.remove(i);
            }
        }
        return false;
    }

    @Override
    public void addNode(InterfaceRemota node) throws RemoteException {
        //se já tiver o nó 
        // não faz nada
        if (isInNetwork(node.getAdress())) {
            System.out.println("Já tenho o endereço " + node.getAdress());
            return;
        }

        //adicionar o no
        network.add(node);
        listener.onConect(node.getAdress());
        System.out.println("Adicionei o " + node.getAdress());
        node.addNode(this);

        //propagar o no
        for (InterfaceRemota iremoteP2P : network) {
            iremoteP2P.addNode(node);

        }

        sinchronizeTransactions(node);
        System.out.println("Rede p2p");
        for (InterfaceRemota iremoteP2P : network) {
            System.out.println(iremoteP2P.getAdress());

        }

    }

    @Override
    public List<InterfaceRemota> getNetwork() throws RemoteException {
        return new ArrayList<>(network);
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    public void addTransaction(String data) throws RemoteException {
        if (transactions.contains(data)) {
            listener.onTransaction("Transaçao repetida " + data);
            System.out.println("Transaçao repetida " + data);
            return;
        }
        transactions.add(data);
        for (InterfaceRemota iremoteP2P : network) {
            iremoteP2P.addTransaction(data);
        }

        System.out.println("Transactions");
        for (String t : transactions) {
            System.out.println(t);
        }

    }

    public List<String> getTransactions() throws RemoteException {
        return new ArrayList<>(transactions);
    }

    public void removeTransaction(String data) throws RemoteException {
        if (!transactions.contains(data)) {
            System.out.println("Transaçao Não existe " + data);
            return;
        }
        transactions.remove(data);
        for (InterfaceRemota iremoteP2P : network) {
            iremoteP2P.removeTransaction(data);
        }
        System.out.println("Transactions");
        for (String t : transactions) {
            System.out.println(t);
        }
    }

    public boolean isListEqual(List<String> other) {
        for (String t : transactions) {
            if (!other.contains(t)) {
                return false;
            }
        }
        return true;
    }

    public boolean register(String nome, String cc, char[] pass) throws RemoteException {
        try {
            User u = new User(nome, cc);
            u.generateKeys();

            u.save(new String(pass));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean login(String nome, String cc, char[] pass) throws RemoteException {
        User u = new User(nome, cc);

        try {
            u.load(new String(pass));

        } catch (Exception ex) {
            Logger.getLogger(ObjetoRemoto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        String pub = Base64.getEncoder().encodeToString(u.getPub().getEncoded());

        return true;
    }

    public List<Evento> getCurriculos() throws RemoteException {
        try {
            curriculo = new CurriculumDigital();
            curriculo = CurriculumDigital.load(fileCurriculumDigital);

            List<Evento> curriculos = curriculo.getCurriculo();

            return curriculos;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void sinchronizeTransactions(InterfaceRemota node) throws RemoteException {
//         if( isListEqual(node.getTransactions()))
//             return;
//         //juntar as transações no set
//         transactions.addAll(node.getTransactions());
//         node.sinchronizeTransactions(this);
//         
//         for (IremoteP2P iremoteP2P : network) {
//             iremoteP2P.sinchronizeTransactions(node);        
//         }
//         
//          System.out.println("Transactions");
//        for (String t : transactions) {
//            System.out.println(t);
//        }
        this.transactions.addAll(node.getTransactions());
        listener.onTransaction(address);

    }
}
