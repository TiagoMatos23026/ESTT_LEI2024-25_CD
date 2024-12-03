/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CD_ProjCurriculumDigital.classes;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author asus
 */
public interface InterfaceRemota extends Remote {
    //:::: N E T WO R K  :::::::::::
    public String getAdress() throws RemoteException;
    public void addNode(InterfaceRemota node) throws RemoteException;
    public List<InterfaceRemota> getNetwork() throws  RemoteException;
    //::::::::::: T R A NS A C T IO N S  :::::::::::
    public void addTransaction(String data) throws RemoteException;
    public List<String> getTransactions() throws RemoteException;
    public void removeTransaction(String data )throws RemoteException;
    public void sinchronizeTransactions(InterfaceRemota node) throws RemoteException;

}
