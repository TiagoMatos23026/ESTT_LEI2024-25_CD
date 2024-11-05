/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CD_Ficha04;

/**
 *
 * @author asus
 */
public class Ex2 extends Thread {
    @Override
    public void run() {
        //imprime números de 0 a 10 e diz qual a thread que está a correr
        for(int i = 0; i<=10; i++){
            System.out.println(Thread.currentThread().getName()+ "");
            System.out.println(i);
        }
    }
    
    public static void main(String[] args) {
        //criar 3 threads
        for(int i = 0; i <= 3; i++){
            Ex2 td = new Ex2();
            
            //dar run de cada uma das threads
            td.start();     
        }
        System.out.println("Terminou.");
    }
}
