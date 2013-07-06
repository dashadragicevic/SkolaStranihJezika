/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dasa
 */
public class Mesto implements Serializable, OpstiDomenskiObjekat {
    
    private long pttBroj;
    private String nazivMesta;

    public Mesto() {
    }

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

    @Override
    public String toString() {
        return nazivMesta;
    }

    @Override
    public String vratiImeTabele() {
        return "Mesto";
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
        List<OpstiDomenskiObjekat> lm = new ArrayList<>();
        try {
            while (rs.next()) {
                long ptt = rs.getLong("PttBroj");
                String naziv = rs.getString("NazivMesta");
                Mesto m = new Mesto(ptt, naziv);
                lm.add(m);
            }
        } catch (Exception e) {
            System.out.println("Greska pri ucitavanju spiska mesta!");
        }
        return lm;
    }

    @Override
    public String vratiVrednostZaWhere() {
        return "PttBroj = "+pttBroj;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "";
    }

    @Override
    public String vratiVrednostZaWhereZaPretragu() {
        return "";
    }

    @Override
    public String vratiVrednostZaDelete() {
        return "PttBroj = "+pttBroj;
    }

}
