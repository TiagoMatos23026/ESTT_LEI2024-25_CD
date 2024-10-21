package CD_ProjCurriculumDigital.classes;

import CD_Ficha03.utils.SecurityUtils;
import java.io.Serializable;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import static javax.management.Query.value;

public class Evento implements Serializable {

    //nome da pessoa
    private String nome;
    private String cc;
    //chave publica da pessoa (pode ser o num cc)
    private String pubKey;
    //chave privada da pessoa (password)
    private String privKey;
    //evento a ser atribuido (tipo licenciatura)
    private String evento;
    //assinatura digital para garantir validade do evento
    private String signature;

    public Evento() {

    }

    public Evento(User user, String evento) throws Exception {
        //vai buscar o nome do user
        this.nome = user.getName();
        this.cc = user.getCC();
        //vai buscar a public key do user
        this.pubKey = Base64.getEncoder().encodeToString(user.getPub().getEncoded());
        //cria o evento consoante o que foi introduzido
        this.evento = evento;

        //validar o evento com a chave privada
        //gera uma nova signature consoante a privKey (password) que foi introduzida
        sign(user.getPriv());
    }

    public String getCC() {
        return cc;
    }

    public void setCC(String cc) {
        this.cc = cc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPubKey() {
        return pubKey;
    }

    public void setPubKey(String pubKey) {
        this.pubKey = pubKey;
    }

    public String getPrivKey() {
        return privKey;
    }

    public void setPrivKey(String privKey) {
        this.privKey = privKey;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, CC: %s, Evento: %s, Válido: %s",
                nome, cc, evento, isValid() ? "Sim" : "Não");
    }

    ///
    //Método para assinar
    ///
    public void sign(PrivateKey priv) throws Exception {
        //gera uma nova assinatura com a public key, o nome e a chave privada
        byte[] dataSign = SecurityUtils.sign((pubKey + nome).getBytes(), priv);
        this.signature = Base64.getEncoder().encodeToString(dataSign);
    }

    public boolean isValid() {
        try {
            PublicKey pub = SecurityUtils.getPublicKey(Base64.getDecoder().decode(pubKey));
            byte[] data = (pubKey + nome).getBytes();
            byte[] sign = Base64.getDecoder().decode(signature);
            return SecurityUtils.verifySign(data, sign, pub);
        } catch (Exception ex) {
            return false;
        }

    }

    public String listarEventos() {
        return null;
    }

}
