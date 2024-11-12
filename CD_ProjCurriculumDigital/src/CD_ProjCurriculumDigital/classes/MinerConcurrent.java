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
            //String of zeros
            String zeros = String.format("%0" + dificulty + "d", 0);
            //starting nonce

            while (truenonce.get() == 0) {
                //calculate hash of block
                int nonce = ticketNonce.getAndIncrement();
                String hash = Hash.getHash(nonce + data);
                //DEBUG .... DEBUG .... DEBUG .... DEBUG .... DEBUG .... DEBUG
                //System.out.println(nonce + " " + hash);
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
        AtomicInteger sharedNonce = new AtomicInteger(0);
        AtomicInteger truNonce = new AtomicInteger(0);
        
        int cores = Runtime.getRuntime().availableProcessors();
        Thr[] thr = new Thr[cores];
        
        for (int i = 0; i < thr.length; i++) {
            thr[i] = new Thr(sharedNonce, truNonce, data, dificulty);
            thr[i].start();
        }
        
        try {
            //esperar que a primeira termine == todas terminarem
            thr[0].join();
        } catch (InterruptedException ex) {
            Logger.getLogger(MinerConcurrent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return truNonce.get();
    }
   
}
