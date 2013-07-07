/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.polaznik;

import baza.DBKomunikacija;
import domen.Kurs;
import domen.Mesto;
import domen.Nivo;
import domen.OpstiDomenskiObjekat;
import domen.Polaznik;
import domen.StraniJezik;
import domen.Ugovor;
import domen.Zaposleni;
import java.util.ArrayList;
import java.util.List;
import so.OpstaSO;
import so.kurs.PronadjiKursSO;

/**
 *
 * @author Dasa
 */
public class PronadjiPolaznikaSO extends OpstaSO {

    OpstiDomenskiObjekat polaznik;

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        polaznik = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Polaznik) o);

        OpstiDomenskiObjekat p = polaznik;

        OpstiDomenskiObjekat mesta = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Mesto) ((Polaznik)p).getMesto());
        ((Polaznik) p).setMesto((Mesto) mesta);

        Ugovor u = new Ugovor();
        u.setPolaznik((Polaznik) p);
        List<OpstiDomenskiObjekat> ugovori = DBKomunikacija.vratiObjekat().vratiObjektePretraga(u);

        List<Ugovor> praviUgovori = new ArrayList<>();
        for (OpstiDomenskiObjekat ugovor : ugovori) {
            Ugovor ug = (Ugovor) ugovor;

            ug.setPolaznik((Polaznik) p);

            OpstiDomenskiObjekat kurseva = DBKomunikacija.vratiObjekat().vratiObjektePoIDu(ug.getKurs());
            OpstiDomenskiObjekat k = kurseva;
            OpstiDomenskiObjekat jezika = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((StraniJezik)((Kurs)k).getJezik());
            ((Kurs) k).setJezik((StraniJezik) jezika);
            OpstiDomenskiObjekat nivoa = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Nivo) ((Kurs)k).getNivo());
            ((Kurs) k).setNivo((Nivo) nivoa);
            OpstiDomenskiObjekat zaposlenih = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Zaposleni) ((Kurs)k).getNastavnik());
            ((Kurs) k).setNastavnik((Zaposleni) zaposlenih);

            Kurs kurs = (Kurs) kurseva;
            ug.setKurs(kurs);

            praviUgovori.add(ug);
        }
        ((Polaznik) p).setUgovori(praviUgovori);
    }

    public OpstiDomenskiObjekat getPolaznik() {
        return polaznik;
    }

}
