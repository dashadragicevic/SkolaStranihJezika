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

    List<OpstiDomenskiObjekat> lista;

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        lista = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Polaznik) o);

        OpstiDomenskiObjekat p = lista.get(0);

        List<OpstiDomenskiObjekat> listaMesta = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Mesto) ((Polaznik)p).getMesto());
        ((Polaznik) p).setMesto((Mesto) listaMesta.get(0));

        Ugovor u = new Ugovor();
        u.setPolaznik((Polaznik) p);
        List<OpstiDomenskiObjekat> ugovori = DBKomunikacija.vratiObjekat().vratiObjektePretraga(u);

        List<Ugovor> praviUgovori = new ArrayList<>();
        for (OpstiDomenskiObjekat ugovor : ugovori) {
            Ugovor ug = (Ugovor) ugovor;

            ug.setPolaznik((Polaznik) p);

            List<OpstiDomenskiObjekat> listaKurseva = DBKomunikacija.vratiObjekat().vratiObjektePoIDu(ug.getKurs());
            OpstiDomenskiObjekat k = listaKurseva.get(0);
            List<OpstiDomenskiObjekat> listaJezika = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((StraniJezik)((Kurs)k).getJezik());
            ((Kurs) k).setJezik((StraniJezik) listaJezika.get(0));
            List<OpstiDomenskiObjekat> listaNivoa = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Nivo) ((Kurs)k).getNivo());
            ((Kurs) k).setNivo((Nivo) listaNivoa.get(0));
            List<OpstiDomenskiObjekat> listaZaposlenih = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Zaposleni) ((Kurs)k).getNastavnik());
            ((Kurs) k).setNastavnik((Zaposleni) listaZaposlenih.get(0));

            Kurs kurs = (Kurs) listaKurseva.get(0);
            ug.setKurs(kurs);

            praviUgovori.add(ug);
        }
        ((Polaznik) p).setUgovori(praviUgovori);
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }
}
