/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cd_ficha01.classes;

/**
 *
 * @author asus
 */
class Miner {
    //maximum number of Nonce
    public static int MAX_NONCE = (int)1E9;

    public static int getNonce(String data, int dificulty) {
        //String of zeros
        String zeros = String.format("%0" + dificulty + "d", 0);
       //starting nonce
        int nonce = 0;
        while (nonce < MAX_NONCE) {
            //calculate hash of block
            String hash = Hash.getHash(nonce + data);
            //DEBUG .... DEBUG .... DEBUG .... DEBUG .... DEBUG .... DEBUG
            //System.out.println(nonce + " " + hash);
            //Nounce found
            if (hash.endsWith(zeros)) {
                return nonce;
            }
            //next nounce
            nonce++;
        }
        return nonce;
    }
}
