/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dasa
 */
public class StraniJezik implements Serializable, OpstiDomenskiObjekat {
    
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

    @Override
    public String vratiImeTabele() {
        return "Jezik";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "";
    }
    
    @Override
    public String vratiVrednostZaInsert() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzResultSeta(ResultSet rs) {
        List<OpstiDomenskiObjekat> lj = new ArrayList<>();
        try {
            while (rs.next()) {
                long jID = rs.getLong("JezikID");
                String naziv = rs.getString("NazivJezika");
                StraniJezik sj = new StraniJezik(jID, naziv);
                lj.add(sj);
            }
        } catch (Exception e) {
            System.out.println("Greska pri ucitavanju spiska jezika!");
        }
        return lj;
    }

    @Override
    public String vratiVrednostZaWhere() {
        return "JezikID = "+jezikID;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "";
    }

    @Override
    public String vratiVrednostZaWhereZaPretragu() {
        return "";
    }

}
