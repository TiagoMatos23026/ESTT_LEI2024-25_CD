/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CD_Ficha04;

/**
 *
 * @author asus
 */
public class Ex1_Runnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello Parallel World!");
        System.out.println("Esta thread está a correr um objeto.");
    }
    
    public void main(String[] args) {
        //Criar um objeto com a classe
        //O objeto vai ser runnable, pois a classe Ex1_Runnable implementa Runnable
        Ex1_Runnable runnableObj = new Ex1_Runnable();
        
        //Criar uma thread para correr o objeto
        Thread th = new Thread(runnableObj);
        
        //Começar a thread
        th.start();
    }
}
