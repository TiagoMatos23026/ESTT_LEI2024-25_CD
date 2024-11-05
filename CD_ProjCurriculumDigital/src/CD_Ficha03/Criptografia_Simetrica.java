/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CD_Ficha03;

import CD_ProjCurriculumDigital.classes.SecurityUtils;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Key;

/**
 *
 * @author asus
 */
public class Criptografia_Simetrica {
    public static void main(String[] args) throws Exception {
        String fileName = "image.jpg";
        //::::::::::::::::::  encriptar ::::::::::::::::::::::::
        //gerar uma chave
        Key k = SecurityUtils.generateAESKey(256);
        //guardar a chave
        SecurityUtils.saveKey(k, fileName + ".key");
        encryptFile(fileName, k);
        //::::::::::::::::::  desencriptar ::::::::::::::::::::::::
        //ler a chave
        Key fileKey = SecurityUtils.loadAESKey(fileName + ".key");
        decryptFile(fileName, fileKey);
    }
    public static void encryptFile(String fileName, Key k) throws Exception {
        byte[] data = Files.readAllBytes(Path.of(fileName));
        //encriptar
        byte[] secret = SecurityUtils.encrypt(data, k);
        //guardar o segredo
        Files.write(Path.of(fileName + ".crypt"), secret);
        System.out.println(fileName + " Encripted");
    }
    public static void decryptFile(String fileName, Key k) throws Exception {
        byte[] secret = Files.readAllBytes(Path.of(fileName + ".crypt"));
        //encriptar
        byte[] plain = SecurityUtils.decrypt(secret, k);
        //guardar o segredo
        Files.write(Path.of("plain_" + fileName), plain);
        System.out.println(fileName + " decrypted");
    }
}
