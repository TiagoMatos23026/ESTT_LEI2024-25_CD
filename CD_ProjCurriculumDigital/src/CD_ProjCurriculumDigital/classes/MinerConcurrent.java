package CD_ProjCurriculumDigital.classes;

import CD_ProjCurriculumDigital.classes.Hash;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created on 28/09/2022, 11:13:39
 *
 * @author IPT - computer
 * @version 1.0
 */
public class MinerConcurrent {

    private static class Thr extends Thread {

        AtomicInteger ticketNonce;
        AtomicInteger truenonce;
        String data;
        int dificulty;

        public Thr(AtomicInteger nonce, AtomicInteger truenonce, String data, int dificulty) {
            this.ticketNonce = nonce;
            this.truenonce = truenonce;
            this.data = data;
            this.dificulty = dificulty;
        }

        public void run() {
            //String de zeros
            String zeros = String.format("%0" + dificulty + "d", 0);
            //nonce inicial (tudo zeros)

            //na primeira passagem do algoritmo
            while (truenonce.get() == 0) {
                //calcula hash do bloco
                //ticketNonce = ticketNonce + 1
                int nonce = ticketNonce.getAndIncrement();
                
                String hash = Hash.getHash(nonce + data);

                //Nounce found
                if (hash.endsWith(zeros)) {
                    truenonce.set(nonce);
                }
            }
        }

    }
    //maximum number of Nonce
    public static int MAX_NONCE = (int) 1E9;

    public static int getNonce(String data, int dificulty) {
        //nonce a ser partilhado por todas as threads
        AtomicInteger sharedNonce = new AtomicInteger(0);
        
        //nonce verdadeiro para ser retornado
        AtomicInteger truNonce = new AtomicInteger(0);
        
        //número de cores do processador
        int cores = Runtime.getRuntime().availableProcessors();
        
        //criar um array de threads com o número de threads = número de cores
        Thr[] thr = new Thr[cores];
        
        //ciclo de inicialização das threads
        for (int i = 0; i < thr.length; i++) {
            thr[i] = new Thr(sharedNonce, truNonce, data, dificulty);
            thr[i].start();
        }
        
        
        try {
            //quando a primeira terminar, todas terminam
            thr[0].join();
        } catch (InterruptedException ex) {
            Logger.getLogger(MinerConcurrent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //retornar o nonce calculado
        return truNonce.get();
    }
   
}
