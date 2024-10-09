package CD_ProjCurriculumDigital.classes;

import CD_Ficha03.utils.SecurityUtils;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import static javax.management.Query.value;

public class Evento {

    public Evento(String nomePessoa, String nomeEvento, String dataEvento) {
        this.nomePessoa = nomePessoa;
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
    }

    private String nomePessoa;
    private String nomeEvento;
    private String dataEvento;

    //chave pública da pessoa que criou o evento
    private String pubKey;

    private double value;

    //confirmação de que foi o user correto que criou este evento
    //validação do evento
    private String signature;

    @Override
    public String toString() {
        return nomeEvento + " - " + dataEvento;
    }

    public void sign(PrivateKey priv) throws Exception {
        byte[] dataSign = SecurityUtils.sign((pubKey + value).getBytes(), priv);
        this.signature = Base64.getEncoder().encodeToString(dataSign);
    }

    public boolean isValid() throws Exception {
        try {
            PublicKey pub = SecurityUtils.getPublicKey(Base64.getDecoder().decode(pubKey));
            byte[] data = (pubKey + value).getBytes();
            byte[] sign = Base64.getDecoder().decode(signature);
            return SecurityUtils.verifySign(data, sign, pub);
        } catch (Exception ex) {
            return false;
        }

    }

}
