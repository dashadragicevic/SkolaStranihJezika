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
public class Polaznik implements Serializable, OpstiDomenskiObjekat {
    
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
        ime="";
        prezime="";
        JMBG="";
        brojLicneKarte="";
        brojTelefona="";
        nazivUlice="";
        brojUlice="";
        mesto = new Mesto();
        mesto.setPostanskiBroj(11000);
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

    @Override
    public String vratiImeTabele() {
        return "Polaznik";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "(Ime, Prezime, JMBG, BrojLicneKarte, BrojTelefona, NazivUlice, BrojUlice, PttBroj)";
    }

    @Override
    public String vratiVrednostZaInsert() {
        return "'"+ime+"','"+prezime+"','"+JMBG+"','"+brojLicneKarte+"','"+brojTelefona+"','"+nazivUlice+"','"+brojUlice+"',"+mesto.getPostanskiBroj();
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzResultSeta(ResultSet rs) {
        List<OpstiDomenskiObjekat> lp = new ArrayList<>();
        try {
            while (rs.next()) {
                long pid = rs.getLong("PolaznikID");
                String imep = rs.getString("Ime");
                String prezimep = rs.getString("Prezime");
                String jmbg = rs.getString("JMBG");
                String brlk = rs.getString("BrojLicneKarte");
                String tel = rs.getString("BrojTelefona");
                String nazul = rs.getString("NazivUlice");
                String brul = rs.getString("BrojUlice");
                long ptt = rs.getLong("PttBroj");

                Polaznik p = new Polaznik();
                p.setPolaznikID(pid);
                p.setIme(imep);
                p.setPrezime(prezimep);
                p.setJMBG(jmbg);
                p.setBrojLicneKarte(brlk);
                p.setBrojTelefona(tel);
                p.setNazivUlice(nazul);
                p.setBrojUlice(brul);
                Mesto m = new Mesto();
                m.setPostanskiBroj(ptt);

                lp.add(p);
            }
        } catch (Exception e) {
            System.out.println("Sistem ne moze da nadje polaznika po zadatoj vrednosti!");
        }
        return lp;
    }

    @Override
    public String vratiVrednostZaWhere() {
        return "PolaznikID="+polaznikID;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "Ime='"+ime+"', Prezime='"+prezime+"', JMBG='"+JMBG+"', BrojLicneKarte='"+brojLicneKarte+"', BrojTelefona='"+brojTelefona+"', NazivUlice='"+nazivUlice+"', BrojUlice='"+brojUlice+"', PttBroj="+mesto.getPostanskiBroj()+"";
    }

    @Override
    public String vratiVrednostZaWhereZaPretragu() {
        String s = "";
        if(!"".equals(ime)&&"".equals(prezime)&&"".equals(JMBG)){
            s = "Ime LIKE '%"+ime+"%'";
        }
        else if("".equals(ime)&&!"".equals(prezime)&&"".equals(JMBG)){
            s = "Prezime LIKE '%"+prezime+"%'";
        }
        else if("".equals(ime)&&"".equals(prezime)&&!"".equals(JMBG)){
            s = "JMBG LIKE '%"+JMBG+"%'";
        }
        else if(!"".equals(ime)&&!"".equals(prezime)&&"".equals(JMBG)){
            s = "Ime LIKE '%"+ime+"%' AND Prezime LIKE '%"+prezime+"%'";
        }
        else if(!"".equals(ime)&&"".equals(prezime)&&!"".equals(JMBG)){
            s = "Ime LIKE '%"+ime+"%' AND JMBG LIKE '%"+JMBG+"%'";
        }
        else if("".equals(ime)&&!"".equals(prezime)&&!"".equals(JMBG)){
            s = "Prezime LIKE '%"+prezime+"%' AND JMBG LIKE '%"+JMBG+"%'";
        }
        else if(!"".equals(ime)&&!"".equals(prezime)&&!"".equals(JMBG)){
            s = "Ime LIKE '%"+ime+"%' AND Prezime LIKE '%"+prezime+"%' AND JMBG LIKE '%"+JMBG+"%'";
        }
        return s;
    }

    @Override
    public String vratiVrednostZaDelete() {
        return "PolaznikID="+polaznikID;
    }
    
}
