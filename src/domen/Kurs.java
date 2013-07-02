/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Dasa
 */
public class Kurs {
    
    private long kursID;
    private int fondCasova;
    private double cena;
    private Date datumOd;
    private Date datumDo;
    private String termin1;
    private String termin2;
    private String nazivUdzbenika;
    private StraniJezik jezik;
    private Nivo nivo;
    private Zaposleni nastavnik;

    public Kurs(long kursID, int fondCasova, double cena, Date datumOd, Date datumDo, String termin1, String termin2, String nazivUdzbenika, StraniJezik jezik, Nivo nivo, Zaposleni nastavnik) {
        this.kursID = kursID;
        this.fondCasova = fondCasova;
        this.cena = cena;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.termin1 = termin1;
        this.termin2 = termin2;
        this.nazivUdzbenika = nazivUdzbenika;
        this.jezik = jezik;
        this.nivo = nivo;
        this.nastavnik = nastavnik;
    }

    public Kurs() {
    }

    public long getKursID() {
        return kursID;
    }

    public void setKursID(long kursID) {
        this.kursID = kursID;
    }

    public int getFondCasova() {
        return fondCasova;
    }

    public void setFondCasova(int fondCasova) {
        this.fondCasova = fondCasova;
    }

    public long getCena() {
        return (long)cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public String getTermin1() {
        return termin1;
    }

    public void setTermin1(String termin1) {
        this.termin1 = termin1;
    }

    public String getTermin2() {
        return termin2;
    }

    public void setTermin2(String termin2) {
        this.termin2 = termin2;
    }

    public String getNazivUdzbenika() {
        return nazivUdzbenika;
    }

    public void setNazivUdzbenika(String nazivUdzbenika) {
        this.nazivUdzbenika = nazivUdzbenika;
    }

    public StraniJezik getJezik() {
        return jezik;
    }

    public void setJezik(StraniJezik jezik) {
        this.jezik = jezik;
    }

    public Nivo getNivo() {
        return nivo;
    }

    public void setNivo(Nivo nivo) {
        this.nivo = nivo;
    }

    public Zaposleni getNastavnik() {
        return nastavnik;
    }

    public void setNastavnik(Zaposleni nastavnik) {
        this.nastavnik = nastavnik;
    }
    
    @Override
    public String toString() {
        return termin1 + ", " + termin2 + ", cena: " + cena;
    }
    
}
