/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CD_ProjCurriculumDigital.classes;

import java.util.ArrayList;
import java.util.List;
import CD_ProjCurriculumDigital.classes.Block;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author asus
 */
public class CurriculumDigital implements Serializable {

    private ArrayList<Evento> curriculos;
    CD_ProjCurriculumDigital.classes.Blockchain bc;
    public static int DIFICULTY = 4;

    public CurriculumDigital() throws Exception {
        curriculos = new ArrayList<>();

        bc = new Blockchain();
    }

    public List<Evento> getCurriculo() {
        return curriculos;
    }

    public String toString() {
        StringBuilder txt = new StringBuilder();
        for (Block b : bc.getChain()) {
            Evento e = (Evento) ObjectUtils.convertBase64ToObject(b.getData());
            txt.append("Hash Anterior: " + b.getPreviousHash() + " "
                    + "Evento: " + e.toString() + " "
                    + "Nonce: " + b.getNonce() + " "
                    + "Hash atual: " + b.getCurrentHash()
                    + "\n"
            );
        }

        return txt.toString();
    }

    public String getLastBlockHash() {
        return bc.getLastBlockHash();
    }

    public List<Block> getChain() {
        return bc.getChain();

    }

    public void save(String fileName) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            out.writeObject(this);
        }
    }

    public static CurriculumDigital load(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(fileName))) {
            return (CurriculumDigital) in.readObject();
        }
    }

    public List<Evento> getCurriculoWithUserCC(String userCC) {
        List<Evento> eventos = new ArrayList<>();

        // Iterar sobre os blocos da blockchain
        for (Block b : bc.getChain()) {
            Evento e = (Evento) ObjectUtils.convertBase64ToObject(b.getData());

            // Verificar se o CC do evento corresponde ao userCC
            if (e.getCC().equals(userCC)) {
                eventos.add(e);
            }
        }

        return eventos;
    }

    public List<String> getCurriculoAsStrings(String userCC) {
        List<String> eventosStrings = new ArrayList<>();

        // Iterar sobre os blocos da blockchain
        for (Block b : bc.getChain()) {
            Evento e = (Evento) ObjectUtils.convertBase64ToObject(b.getData());

            // Verificar se o CC do evento corresponde ao userCC
            if (e.getCC().equals(userCC)) {
                // Criar uma representação em string do evento
                String eventoString = String.format("%s",
                        e.getEvento());
                eventosStrings.add(eventoString);
            }
        }

        return eventosStrings;
    }

    public boolean isValid(Evento e) throws Exception {

        // Verifica se o nome existe e não está vazio
        if (e.getNome() == null || e.getNome().trim().isEmpty()) {
            throw new Exception("Nome do evento é inválido");
        }

        // Verifica se o cc (Cartão de Cidadão) existe e não está vazio
        if (e.getCC() == null || e.getCC().trim().isEmpty()) {
            throw new Exception("Cartão de Cidadão é inválido");
        }

        // Verifica se a descrição do evento existe e não está vazia
        if (e.getEvento() == null || e.getEvento().trim().isEmpty()) {
            throw new Exception("Descrição do evento é inválida");
        }

        // Se todas as validações passarem, retorna true (evento é válido)
        return true;
    }

    public void addEvento(Evento e) throws Exception {
        if (isValid(e)) {
            curriculos.add(e);
        } else {
            throw new Exception("Transaction not valid");
        }
    }

    public void add(String data, int difficulty) throws Exception {
        bc.add(data, difficulty);
    }

    public void addMkt() throws Exception {

    }

    public List<Evento> getEventoBlockchain() throws Exception {
        List<Evento> lst = new ArrayList<>();
        for (Block b : bc.getChain()) {
            Evento e = new Evento();
            e = (Evento) ObjectUtils.convertBase64ToObject(b.getData());
            lst.add(e);
        }
        return lst;
    }


}
