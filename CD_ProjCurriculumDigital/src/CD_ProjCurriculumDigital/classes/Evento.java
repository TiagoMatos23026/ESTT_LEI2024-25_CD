package CD_ProjCurriculumDigital.classes;


public class Evento {

    public Evento(String nomePessoa, String nomeEvento, String dataEvento) {
        this.nomePessoa = nomePessoa;
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
    }
    
    private String nomePessoa;
    private String nomeEvento;
    private String dataEvento;
    
    @Override
    public String toString(){
        return nomeEvento + " - " + dataEvento;
    }
}
