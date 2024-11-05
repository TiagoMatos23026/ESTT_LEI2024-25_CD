/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CD_Ficha03;

import CD_ProjCurriculumDigital.classes.SecurityUtils;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

/**
 *
 * @author asus
 */
public class Zip_Unzip {
    public static void main(String[] args) throws Exception {
        String fileName = "src\\CD_Ficha03\\image.jpg";
        byte[] data = Files.readAllBytes(Path.of(fileName));
        //comprimir
        byte[] zip = SecurityUtils.zip(data);
        Files.write(Path.of(fileName+".zip"), zip);
        //converter para texto
        System.out.println("ZIP = " + Base64.getEncoder().encodeToString(zip));
        //expandir os dados
        byte[] original = SecurityUtils.unzip(zip);
        //guardar o original
        Files.write(Path.of("original_" + fileName), original);
    }
}
