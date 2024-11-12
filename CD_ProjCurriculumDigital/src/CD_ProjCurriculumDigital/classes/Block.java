
package CD_ProjCurriculumDigital.classes;

import java.io.Serializable;


public class Block implements Serializable{
    String previousHash; // link to previous block
    String data;         // data in the block
    int nonce;           // proof of work 
    String currentHash;  // Hash of block
    int diff;

    public Block(String previousHash, String data, int nonce, int diff) {
        this.previousHash = previousHash;
        this.data = data;
        this.nonce = nonce;
        this.currentHash = calculateHash();
        this.diff = diff;
    }

    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }
    
    public Block(){
        
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    } 

    public String calculateHash() {
        return Hash.getHash(nonce + previousHash + data);
    }
    
    public String getCurrentHash(){
        return currentHash;
    }

    public String toString() {
        return // (isValid() ? "OK\t" : "ERROR\t")+
                 String.format("[Prev. Hash: %8s", previousHash) + " <- " + 
                   String.format("Block Data:%-10s", data) +  String.format(" Nonce: %7d] = ", nonce) + 
                String.format("Curr. Hash: %8s",currentHash);

    }

    public boolean isValid() {
        return currentHash.equals(calculateHash());
    }
}
