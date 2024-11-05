/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CD_Ficha04;

/**
 *
 * @author asus
 */
public class Ex3_CalculoPi extends Thread{
    
    public void run(){
        
    }
    
    public static double PI_Machin() {
        return 4 * (4 * Math.atan(1.0/5) 
                - Math.atan(1.0/239));
    }
    
    public static double PI_Takano() {
        return 4 * (12 * Math.atan(1.0 / 49)
                + 32 * Math.atan(1.0 / 57)
                - 5 * Math.atan(1.0 / 239)
                + 12 * Math.atan(1.0 / 110443));
    }
    
    public static void main(String[] args) {
        //Criar duas threads
        for (int i = 0; i<=1; i++){
            Ex3_CalculoPi td = new Ex3_CalculoPi();
            //Iniciar ambas
            td.start();
        }
    }
}
