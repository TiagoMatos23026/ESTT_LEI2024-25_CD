/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CD_ProjCurriculumDigital.classes;

/**
 *
 * @author asus
 */
public interface P2Plistener {
    public void onStart(String message);
    public void onConect(String address);
    public void onTransaction(String transaction);
    public void onException(Exception e, String title);

}
