/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CD_ProjCurriculumDigital.menus;

import CD_ProjCurriculumDigital.classes.User;

/**
 *
 * @author asus
 */
public class TestUser {
    public static void main(String[] args) throws Exception {
        User u = new User();
        u.save("123qwe");
        u.load("123qwe");
    }
}
