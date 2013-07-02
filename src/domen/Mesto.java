/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Dasa
 */
public class Mesto {
    
    private long pttBroj;
    private String nazivMesta;

    public Mesto(long pttBroj, String nazivMesta) {
        this.pttBroj = pttBroj;
        this.nazivMesta = nazivMesta;
    }

    /**
     * @return the pttBroj
     */
    public long getPostanskiBroj() {
        return pttBroj;
    }

    /**
     * @param pttBroj the pttBroj to set
     */
    public void setPostanskiBroj(long postanskiBroj) {
        this.pttBroj = postanskiBroj;
    }

    /**
     * @return the nazivMesta
     */
    public String getNazivMesta() {
        return nazivMesta;
    }

    /**
     * @param nazivMesta the nazivMesta to set
     */
    public void setNazivMesta(String nazivMesta) {
        this.nazivMesta = nazivMesta;
    }
    
}
