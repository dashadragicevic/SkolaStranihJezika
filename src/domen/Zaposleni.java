/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Dasa
 */
public class Zaposleni {
    
    private long zaposleniID;
    private String ime;
    private String prezime;
    private String JMBG;
    private String brojLicneKarte;
    private String brojTelefona;
    private String brojRadneKnjizice;
    private String brojZiroRacuna;
    private String nazivUlice;
    private String brojUlice;
    private Mesto mesto;
    private StraniJezik jezik;
    
    /**
     * @return the zaposleniID
     */
    public long getZaposleniID() {
        return zaposleniID;
    }

    /**
     * @param zaposleniID the zaposleniID to set
     */
    public void setZaposleniID(long zaposleniID) {
        this.zaposleniID = zaposleniID;
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
     * @return the brojRadneKnjizice
     */
    public String getBrojRadneKnjizice() {
        return brojRadneKnjizice;
    }

    /**
     * @param brojRadneKnjizice the brojRadneKnjizice to set
     */
    public void setBrojRadneKnjizice(String brojRadneKnjizice) {
        this.brojRadneKnjizice = brojRadneKnjizice;
    }

    /**
     * @return the brojZiroRacuna
     */
    public String getBrojZiroRacuna() {
        return brojZiroRacuna;
    }

    /**
     * @param brojZiroRacuna the brojZiroRacuna to set
     */
    public void setBrojZiroRacuna(String brojZiroRacuna) {
        this.brojZiroRacuna = brojZiroRacuna;
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
     * @return the jezik
     */
    public StraniJezik getJezik() {
        return jezik;
    }

    /**
     * @param jezik the jezik to set
     */
    public void setJezik(StraniJezik jezik) {
        this.jezik = jezik;
    }

    @Override
    public String toString() {
        return getIme() + " " + getPrezime();
    }
    
}
