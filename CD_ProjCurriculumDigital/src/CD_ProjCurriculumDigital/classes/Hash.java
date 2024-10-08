/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CD_ProjCurriculumDigital.classes;

/**
 *
 * @author asus
 */
public class Hash {
    public static String toHexString(int n) {
        return Integer.toHexString(n).toUpperCase();
    }

    public static String getHash(String data) {
        return toHexString(Math.abs(data.hashCode()));
    }
}
