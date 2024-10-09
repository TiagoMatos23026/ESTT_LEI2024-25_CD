/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CD_ProjCurriculumDigital.classes;

import CD_Ficha03.utils.SecurityUtils;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 *
 * @author asus
 */
public class User {
    String name;
    
    //chave pública
    PublicKey pub;
    
    //chave privada
    PrivateKey priv;
    
    //chave simétrica
    Key sim;
    
    public User(String name){
        this.name = name;
        this.pub = null;
        this.priv = null;
        this.sim = null;
    }
    
    public User(){
        this.name="noName";
        this.pub = null;
        this.priv = null;
        this.sim = null;
    }
    
    public void generateKeys() throws Exception{
        //gera uma chave simétrica com AES
        sim = SecurityUtils.generateAESKey(256);
        
        //gera um par de chaves pública e privada
        KeyPair kp = SecurityUtils.generateECKeyPair(256);
        
        this.pub = kp.getPublic();
        this.priv = kp.getPrivate();
    }
    
    public void save(String password) throws Exception{
        //encriptar a chave privada
        byte[] privData = SecurityUtils.encrypt(priv.getEncoded(), password);
        
        //guardar a chave privada
        Files.write(Path.of(this.name + ".priv"), privData);
        
        //encriptar a chave simétrica
        byte[] simData = SecurityUtils.encrypt(sim.getEncoded(), password);
        
        //guardar a chave privada
        Files.write(Path.of(this.name + ".sim"), simData);
        
        
        Files.write(Path.of(this.name + ".pub"), pub.getEncoded());
    }
    
    public void load(String password) throws Exception{
        //desencriptar a privada
        byte[] privData = Files.readAllBytes(Path.of(this.name + ".priv"));
        privData = SecurityUtils.decrypt(privData, password);
        
        //desencriptar a simétrica
        byte[] simData = Files.readAllBytes(Path.of(this.name + ".sim"));
        privData = SecurityUtils.decrypt(simData, password);
        
        //ler a pública
        byte[] pubData = Files.readAllBytes(Path.of(this.name + ".pub"));
        
        this.priv = SecurityUtils.getPrivateKey(privData);
        this.pub = SecurityUtils.getPublicKey(pubData);
        this.sim = SecurityUtils.getAESKey(simData);
    }
            
    
    
}
