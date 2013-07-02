/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.Date;

/**
 *
 * @author Dasa
 */
public class Ugovor {
    
    private Polaznik polaznik;
    private long ugovorID;
    private int brojRata;
    private double iznosRate;
    private Date rokZaSlRatu;
    private int ukupnoPlacenoRata;
    private double ukupnoPlaceno;
    private Kurs kurs;

    public Ugovor(Polaznik polaznik, long ugovorID, int brojRata, double iznosRate, Date rokZaSlRatu, int ukupnoPlacenoRata, double ukupnoPlaceno, Kurs kurs) {
        this.polaznik = polaznik;
        this.ugovorID = ugovorID;
        this.brojRata = brojRata;
        this.iznosRate = iznosRate;
        this.rokZaSlRatu = rokZaSlRatu;
        this.ukupnoPlacenoRata = ukupnoPlacenoRata;
        this.ukupnoPlaceno = ukupnoPlaceno;
        this.kurs = kurs;
    }

    public Ugovor() {
    }

    public Polaznik getPolaznik() {
        return polaznik;
    }

    public void setPolaznik(Polaznik polaznik) {
        this.polaznik = polaznik;
    }

    public long getUgovorID() {
        return ugovorID;
    }

    public void setUgovorID(long ugovorID) {
        this.ugovorID = ugovorID;
    }

    public int getBrojRata() {
        return brojRata;
    }

    public void setBrojRata(int brojRata) {
        this.brojRata = brojRata;
    }

    public double getIznosRate() {
        return iznosRate;
    }

    public void setIznosRate(double iznosRate) {
        this.iznosRate = iznosRate;
    }

    public Date getRokZaSlRatu() {
        return rokZaSlRatu;
    }

    public void setRokZaSlRatu(Date rokZaSlRatu) {
        this.rokZaSlRatu = rokZaSlRatu;
    }

    public int getUkupnoPlacenoRata() {
        return ukupnoPlacenoRata;
    }

    public void setUkupnoPlacenoRata(int ukupnoPlacenoRata) {
        this.ukupnoPlacenoRata = ukupnoPlacenoRata;
    }

    public double getUkupnoPlaceno() {
        return ukupnoPlaceno;
    }

    public void setUkupnoPlaceno(double ukupnoPlaceno) {
        this.ukupnoPlaceno = ukupnoPlaceno;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }
    
}
