/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dasa
 */
public class Ugovor implements Serializable, OpstiDomenskiObjekat {
    
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

    @Override
    public String vratiImeTabele() {
        return "Ugovor";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "(PolaznikID, UgovorID, BrojRata, IznosRate, RokZaSlRatu, UkupnoPlacenoRata, UkupnoPlaceno, KursID)";
    }

    @Override
    public String vratiVrednostZaInsert() {
        return polaznik.getPolaznikID()+","+ugovorID+","+brojRata+","+iznosRate+",'"+new java.sql.Date(rokZaSlRatu.getTime())+"',"+ukupnoPlacenoRata+","+ukupnoPlaceno+","+kurs.getKursID();
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzResultSeta(ResultSet rs) {
        List<OpstiDomenskiObjekat> lu = new ArrayList<>();
        try {
            while (rs.next()) {
                long uid = rs.getLong("UgovorID");
                int brr = rs.getInt("BrojRata");
                double iznr = rs.getDouble("IznosRate");
                Date rok = rs.getDate("RokZaSlRatu");
                int upr = rs.getInt("UkupnoPlacenoRata");
                double up = rs.getDouble("UkupnoPlaceno");
                long kid = rs.getLong("KursID");

                Ugovor u = new Ugovor();
                u.setBrojRata(brr);
                u.setIznosRate(iznr);
                Kurs k = new Kurs();
                k.setKursID(kid);
                u.setKurs(k);
                u.setRokZaSlRatu(rok);
                u.setUgovorID(uid);
                u.setUkupnoPlaceno(up);
                u.setUkupnoPlacenoRata(upr);

                lu.add(u);
            }
        } catch (Exception e) {
            System.out.println("Sistem ne moze da nadje ugovor po zadatoj vrednosti!");
        }
        return lu;
    }

    @Override
    public String vratiVrednostZaWhere() {
        return "PolaznikID="+polaznik.getPolaznikID()+" AND UgovorID="+ugovorID;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "BrojRata="+brojRata+", IznosRate="+iznosRate+", RokZaSlRatu='"+new java.sql.Date(rokZaSlRatu.getTime())+"', UkupnoPlacenoRata="+ukupnoPlacenoRata+", UkupnoPlaceno="+ukupnoPlaceno+", KursID="+kurs.getKursID();
    }

    @Override
    public String vratiVrednostZaWhereZaPretragu() {
        return "PolaznikID="+polaznik.getPolaznikID();
    }
    
}
