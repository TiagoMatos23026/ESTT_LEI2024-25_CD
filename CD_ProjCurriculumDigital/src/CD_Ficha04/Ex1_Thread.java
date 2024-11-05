/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CD_Ficha04;

/**
 *
 * @author asus
 */
public class Ex1_Thread extends Thread{
    @Override
    //este método é usado quando a Thread começa
    public void run(){
        System.out.println("Hello Parallel World!");
        System.out.println("Nome da Thread: " + Thread.currentThread().getName());
    }
    
    public static void main(String[] args) {       
        //Como a classe Ex1 extende a classe Thread, tem todos os métodos da classe Thread e o seu construtor também
        
        //Constroi a nova Thread
        Ex1_Thread td = new Ex1_Thread();
        
        //Começa a Thread de forma assíncrona
        td.start();
    }
}
