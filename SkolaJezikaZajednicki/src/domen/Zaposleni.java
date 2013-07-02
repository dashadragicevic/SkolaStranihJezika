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
public class Zaposleni implements Serializable, OpstiDomenskiObjekat {
    
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

    @Override
    public String vratiImeTabele() {
        return "Zaposleni";
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
        List<OpstiDomenskiObjekat> lz = new ArrayList<>();
        try {
            while (rs.next()) {
                long zapID = rs.getLong("ZaposleniID");
                String imez = rs.getString("Ime");
                String prezimez = rs.getString("Prezime");
                String JMBGz = rs.getString("JMBG");
                String brlk = rs.getString("BrojLicneKarte");
                String brtel = rs.getString("BrojTelefona");
                String brrk = rs.getString("BrojRadneKnjizice");
                String brzr = rs.getString("BrojZiroRacuna");
                String ul = rs.getString("NazivUlice");
                String brul = rs.getString("BrojUlice");
                long ptt = rs.getLong("PttBroj");
                long jezikID = rs.getLong("JezikID");

                Zaposleni zap = new Zaposleni();
                zap.setZaposleniID(zapID);
                zap.setIme(imez);
                zap.setPrezime(prezimez);
                zap.setJMBG(JMBGz);
                zap.setBrojLicneKarte(brlk);
                zap.setBrojTelefona(brtel);
                zap.setBrojRadneKnjizice(brrk);
                zap.setBrojZiroRacuna(brzr);
                zap.setNazivUlice(ul);
                zap.setBrojUlice(brul);
                Mesto m = new Mesto();
                m.setPostanskiBroj(ptt);
                zap.setMesto(m);
                StraniJezik sj = new StraniJezik();
                sj.setJezikID(jezikID);
                zap.setJezik(sj);

                lz.add(zap);
            }
        } catch (Exception e) {
            System.out.println("Greska pri ucitavanju spiska zaposlenih!");
        }
        return lz;
    }

    @Override
    public String vratiVrednostZaWhere() {
        return "ZaposleniID = "+zaposleniID;
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
