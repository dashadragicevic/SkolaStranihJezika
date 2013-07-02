/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Dasa
 */
public class StraniJezik {
    
    private long jezikID;
    private String nazivJezika;

    public StraniJezik(long jezikID, String nazivJezika) {
        this.jezikID = jezikID;
        this.nazivJezika = nazivJezika;
    }

    public StraniJezik() {
    }

    public long getJezikID() {
        return jezikID;
    }

    public void setJezikID(long jezikID) {
        this.jezikID = jezikID;
    }

    public String getNazivJezika() {
        return nazivJezika;
    }

    public void setNazivJezika(String nazivJezika) {
        this.nazivJezika = nazivJezika;
    }
    
    @Override
    public String toString() {
        return nazivJezika;
    }
}
