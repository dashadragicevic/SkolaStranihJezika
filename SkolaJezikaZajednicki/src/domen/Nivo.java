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
public class Nivo implements Serializable, OpstiDomenskiObjekat {
    
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

    @Override
    public String vratiImeTabele() {
        return "Nivo";
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
    public List<OpstiDomenskiObjekat> vratiListuIzResultSeta(ResultSet rs){
        List<OpstiDomenskiObjekat> ln = new ArrayList<>();
        try {
            while (rs.next()) {
                long nID = rs.getLong("NivoID");
                String oznaka = rs.getString("OznakaNivoa");
                String naziv = rs.getString("NazivNivoa");
                Nivo n = new Nivo(nID, oznaka, naziv);
                ln.add(n);
            }
        } catch (Exception e) {
            System.out.println("Greska pri ucitavanju spiska nivoa!");
        }
        return ln;
    }

    @Override
    public String vratiVrednostZaWhere() {
        return "NivoID = "+nivoID;
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
        return "NivoID = "+nivoID;
    }

}
