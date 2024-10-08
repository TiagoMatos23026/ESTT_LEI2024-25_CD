/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CD_Ficha03;

import CD_Ficha03.utils.SecurityUtils;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author asus
 */
public class Funcoes_Hash {
    public static void main(String[] args) throws Exception {
        String fileName = "image.jpg";
       // calculateHash(fileName);
        verifyHash(fileName);
    }
    public static void calculateHash(String fileName) throws Exception{
        byte[] data = Files.readAllBytes(Path.of(fileName));
        //calcular hash
        byte[] hash = SecurityUtils.calculateHash(data, "SHA3-256");
        Files.write(Path.of(fileName+".hash"), hash);
    }
     public static void verifyHash(String fileName) throws Exception{
        byte[] data = Files.readAllBytes(Path.of(fileName));
        //calcular hash
        byte[] hash = Files.readAllBytes(Path.of(fileName+".hash"));
        if( SecurityUtils.verifyHash(data, hash, "SHA3-256"))
             System.out.println("OK");
        else
             System.out.println("Corrupted");

    }
}
