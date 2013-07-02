/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Dasa
 */
public class Nivo {
    
    private long nivoID;
    private String oznakaNivoa;
    private String nazivNivoa;

    public Nivo(long nivoID, String oznakaNivoa, String nazivNivoa) {
        this.nivoID = nivoID;
        this.oznakaNivoa = oznakaNivoa;
        this.nazivNivoa = nazivNivoa;
    }

    public Nivo() {
    }

    public long getNivoID() {
        return nivoID;
    }

    public void setNivoID(long nivoID) {
        this.nivoID = nivoID;
    }

    public String getOznakaNivoa() {
        return oznakaNivoa;
    }

    public void setOznakaNivoa(String oznakaNivoa) {
        this.oznakaNivoa = oznakaNivoa;
    }

    public String getNazivNivoa() {
        return nazivNivoa;
    }

    public void setNazivNivoa(String nazivNivoa) {
        this.nazivNivoa = nazivNivoa;
    }
    
    @Override
    public String toString() {
        return oznakaNivoa + " - " + nazivNivoa;
    }
    
}
