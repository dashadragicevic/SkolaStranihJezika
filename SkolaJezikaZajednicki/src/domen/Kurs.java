/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dasa
 */
public class Kurs implements Serializable, OpstiDomenskiObjekat {

    private long kursID;
    private int fondCasova;
    private long cena;
    private Date datumOd;
    private Date datumDo;
    private String termin1;
    private String termin2;
    private String nazivUdzbenika;
    private StraniJezik jezik;
    private Nivo nivo;
    private Zaposleni nastavnik;

    public Kurs(long kursID, int fondCasova, long cena, Date datumOd, Date datumDo, String termin1, String termin2, String nazivUdzbenika, StraniJezik jezik, Nivo nivo, Zaposleni nastavnik) {
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
        fondCasova = 0;
        cena = 0;
        datumOd = new Date();
        datumDo = new Date();
        termin1 = "Ponedeljak 8:0";
        termin2 = "Ponedeljak 8:0";
        nazivUdzbenika = "Udzbenik";
        StraniJezik sj = new StraniJezik();
        sj.setJezikID(1);
        jezik = sj;
        Nivo n = new Nivo();
        n.setNivoID(1);
        nivo = n;
        Zaposleni z = new Zaposleni();
        z.setZaposleniID(1);
        nastavnik = z;
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
        return (long) cena;
    }

    public void setCena(long cena) {
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

    @Override
    public String vratiImeTabele() {
        return "Kurs";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "(FondCasova, Cena, DatumOd, DatumDo, Termin1, Termin2, NazivUdzbenika, JezikID, NivoID, ZaposleniID)";
    }

    @Override
    public String vratiVrednostZaInsert() {
        return fondCasova + "," + cena + ", '" + new java.sql.Date(datumOd.getTime()) + "' ," + new java.sql.Date(datumDo.getTime()) + "," + "'" + termin1 + "'" + "," + "'" + termin2 + "'" + "," + "'" + nazivUdzbenika + "'" + "," + jezik.getJezikID() + "," + nivo.getNivoID() + "," + nastavnik.getZaposleniID();
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzResultSeta(ResultSet rs) {
        List<OpstiDomenskiObjekat> lk = new ArrayList<>();
        try {
            while (rs.next()) {
                long kid = rs.getLong("KursID");
                int fond = rs.getInt("FondCasova");
                long cenal = rs.getLong("Cena");
                java.sql.Date datod = rs.getDate("DatumOd");
                java.sql.Date datdo = rs.getDate("DatumDo");
                String ter1 = rs.getString("Termin1");
                String ter2 = rs.getString("Termin2");
                String udz = rs.getString("NazivUdzbenika");
                long jezID = rs.getLong("JezikID");
                long nivID = rs.getLong("NivoID");
                long zapID = rs.getLong("ZaposleniID");

                Kurs k = new Kurs();
                k.setKursID(kid);
                k.setFondCasova(fond);
                k.setCena(cenal);
                k.setDatumOd(datod);
                k.setDatumDo(datdo);
                k.setTermin1(ter1);
                k.setTermin2(ter2);
                k.setNazivUdzbenika(udz);
                StraniJezik sj = new StraniJezik();
                sj.setJezikID(jezID);
                k.setJezik(sj);
                Nivo n = new Nivo();
                n.setNivoID(nivID);
                k.setNivo(n);
                Zaposleni z = new Zaposleni();
                z.setZaposleniID(zapID);
                k.setNastavnik(z);

                lk.add(k);
            }
        } catch (Exception e) {
            System.out.println("Sistem ne moze da nadje kurs po zadatoj vrednosti!");
        }
        return lk;
    }

    @Override
    public String vratiVrednostZaWhere() {
        return "KursID=" + kursID;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "FondCasova=" + fondCasova + ", Cena=" + cena + ", DatumOd='" + new java.sql.Date(datumOd.getTime()) + "', DatumDo='" + new java.sql.Date(datumDo.getTime()) + "', Termin1='" + termin1 + "', Termin2='" + termin2 + "', NazivUdzbenika='" + nazivUdzbenika + "', JezikID=" + jezik.getJezikID() + ", NivoID=" + nivo.getNivoID() + ", ZaposleniID=" + nastavnik.getZaposleniID() + "";
    }

    @Override
    public String vratiVrednostZaWhereZaPretragu() {
        return "JezikID=" + jezik.getJezikID() + " AND NivoID=" + nivo.getNivoID();
    }
}
