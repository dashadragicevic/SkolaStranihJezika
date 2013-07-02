/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dasa
 */
public class Polaznik implements Serializable {
    
    private long polaznikID;
    private String ime;
    private String prezime;
    private String JMBG;
    private String brojLicneKarte;
    private String brojTelefona;
    private String nazivUlice;
    private String brojUlice;
    private Mesto mesto;
    private List<Ugovor> ugovori;

    public Polaznik(long polaznikID, String ime, String prezime, String JMBG, String brojLicneKarte, String brojTelefona, String nazivUlice, String brojUlice, Mesto mesto, List<Ugovor> ugovori) {
        this.polaznikID = polaznikID;
        this.ime = ime;
        this.prezime = prezime;
        this.JMBG = JMBG;
        this.brojLicneKarte = brojLicneKarte;
        this.brojTelefona = brojTelefona;
        this.nazivUlice = nazivUlice;
        this.brojUlice = brojUlice;
        this.mesto = mesto;
        this.ugovori = ugovori;
    }

    public Polaznik() {
        ugovori = new ArrayList<>();
    }

    /**
     * @return the polaznikID
     */
    public long getPolaznikID() {
        return polaznikID;
    }

    /**
     * @param polaznikID the polaznikID to set
     */
    public void setPolaznikID(long polaznikID) {
        this.polaznikID = polaznikID;
    }

    /**
     * @return the ime
     */
    public String getIme() {
        return ime;
    }

    /**
     * @param ime the ime to set
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * @return the prezime
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * @param prezime the prezime to set
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    /**
     * @return the JMBG
     */
    public String getJMBG() {
        return JMBG;
    }

    /**
     * @param JMBG the JMBG to set
     */
    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    /**
     * @return the brojLicneKarte
     */
    public String getBrojLicneKarte() {
        return brojLicneKarte;
    }

    /**
     * @param brojLicneKarte the brojLicneKarte to set
     */
    public void setBrojLicneKarte(String brojLicneKarte) {
        this.brojLicneKarte = brojLicneKarte;
    }

    /**
     * @return the brojTelefona
     */
    public String getBrojTelefona() {
        return brojTelefona;
    }

    /**
     * @param brojTelefona the brojTelefona to set
     */
    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    /**
     * @return the nazivUlice
     */
    public String getNazivUlice() {
        return nazivUlice;
    }

    /**
     * @param nazivUlice the nazivUlice to set
     */
    public void setNazivUlice(String nazivUlice) {
        this.nazivUlice = nazivUlice;
    }

    /**
     * @return the brojUlice
     */
    public String getBrojUlice() {
        return brojUlice;
    }

    /**
     * @param brojUlice the brojUlice to set
     */
    public void setBrojUlice(String brojUlice) {
        this.brojUlice = brojUlice;
    }

    /**
     * @return the mesto
     */
    public Mesto getMesto() {
        return mesto;
    }

    /**
     * @param mesto the mesto to set
     */
    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    /**
     * @return the ugovori
     */
    public List<Ugovor> getUgovori() {
        return ugovori;
    }

    /**
     * @param ugovori the ugovori to set
     */
    public void setUgovori(List<Ugovor> ugovori) {
        this.ugovori = ugovori;
    }
    
}
