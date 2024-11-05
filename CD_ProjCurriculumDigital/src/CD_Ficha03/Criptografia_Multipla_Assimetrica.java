/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CD_Ficha03;

import CD_ProjCurriculumDigital.classes.SecurityUtils;
import java.security.KeyPair;
import java.util.Base64;

/**
 *
 * @author asus
 */
public class Criptografia_Multipla_Assimetrica {

    public static void main(String[] args) throws Exception {
        String fileName = "image.jpg";
        //gerar um par de chaves
        KeyPair kp = SecurityUtils.generateRSAKeyPair(2048);
        //guardar as chaves
        SecurityUtils.saveKey(kp, fileName);
        String message = "hello secret world of RSA";
        byte[] secret = SecurityUtils.encrypt(message.getBytes(), kp.getPrivate());
        System.out.println("SECRET : " + Base64.getEncoder().encodeToString(secret));
        byte[] plain = SecurityUtils.decrypt(secret, kp.getPublic());
        System.out.println("Mensagem " + new String(plain));
    }
}
