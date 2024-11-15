/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CD_Ficha04.testePi;

/**
 *
 * @author asus
 */
public class testePi {
    public static double PI(){
        int n = 10;
        double pi = 0.0;
        
        for (double i=0.0; i<n ; i++){
            pi = pi + ( (1.0/((4.0*i-1.0))) - 
                    ((1.0/(4.0*i+3.0))) );
        }
        
        return pi;
    }
    
    public static void main(String[] args) {
        System.out.println(PI());
    }
}
