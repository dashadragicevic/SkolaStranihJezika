/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

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
import so.kurs.NoviKursSO;
import so.kurs.ObrisiKursSO;
import so.kurs.PretraziKurseveSO;
import so.kurs.PronadjiKursSO;
import so.kurs.VratiSveKurseveSO;
import so.kurs.ZapamtiKursSO;
import so.mesto.NadjiMestaPoIduSO;
import so.mesto.VratiSvaMestaSO;
import so.nivo.NadjiNivoePoIduSO;
import so.nivo.VratiNivoeSO;
import so.polaznik.NoviPolaznikSO;
import so.polaznik.PretraziPolaznikeSO;
import so.polaznik.PronadjiPolaznikaSO;
import so.polaznik.ZapamtiPolaznikaSO;
import so.stranijezici.NadjiStaneJezikePoIduSO;
import so.stranijezici.VratiStraneJezikeSO;
import so.ugovor.NoviUgovorSO;
import so.ugovor.PretraziUgovoreSO;
import so.ugovor.ZapamtiUgovorSO;
import so.zaposleni.NadjiZaposlenePoIduSO;
import so.zaposleni.NoviZaposleniSO;
import so.zaposleni.PretraziZaposleneSO;
import so.zaposleni.PronadjiZaposlenogSO;
import so.zaposleni.VratiZaposleneSO;
import so.zaposleni.ZapamtiZaposlenogSO;

/**
 *
 * @author Dasa
 */
public class Kontroler {

    private DBKomunikacija db;
    private static Kontroler k;

    public Kontroler() {
        db = new DBKomunikacija();
    }

    public static Kontroler vratiInstancu() {
        if (k == null) {
            k = new Kontroler();
        }
        return k;
    }

    public List<OpstiDomenskiObjekat> dajStraneJezike() throws Exception {
        VratiStraneJezikeSO vsj = new VratiStraneJezikeSO();
        vsj.izvrsiOperaciju(new StraniJezik());
        return vsj.getLista();
    }

    public List<OpstiDomenskiObjekat> dajNivoe() throws Exception {
        VratiNivoeSO vn = new VratiNivoeSO();
        vn.izvrsiOperaciju(new Nivo());
        return vn.getLista();
    }

    public List<OpstiDomenskiObjekat> dajZaposlene() throws Exception {
        VratiZaposleneSO vz = new VratiZaposleneSO();
        vz.izvrsiOperaciju(new Zaposleni());
        List<OpstiDomenskiObjekat> lista = vz.getLista();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
            NadjiMestaPoIduSO nmpidu = new NadjiMestaPoIduSO();
            nmpidu.izvrsiOperaciju(((Zaposleni) opstiDomenskiObjekat).getMesto());
            ((Zaposleni) opstiDomenskiObjekat).setMesto((Mesto) nmpidu.getLista().get(0));

            NadjiStaneJezikePoIduSO nsjpidu = new NadjiStaneJezikePoIduSO();
            nsjpidu.izvrsiOperaciju(((Zaposleni) opstiDomenskiObjekat).getJezik());
            ((Zaposleni) opstiDomenskiObjekat).setJezik((StraniJezik) nsjpidu.getLista().get(0));
        }
        return lista;
    }

    public OpstiDomenskiObjekat kreirajNoviKurs() throws Exception {
        NoviKursSO nk = new NoviKursSO();
        nk.izvrsiOperaciju(new Kurs());
        return nk.getNoviKurs();
    }

    public void zapamtiKurs(OpstiDomenskiObjekat kurs) throws Exception {
        ZapamtiKursSO zk = new ZapamtiKursSO();
        zk.izvrsiOperaciju(kurs);
    }

    public List<OpstiDomenskiObjekat> pretraziKurseve(OpstiDomenskiObjekat kurs) throws Exception {
        PretraziKurseveSO pk = new PretraziKurseveSO();
        pk.izvrsiOperaciju(kurs);
        List<OpstiDomenskiObjekat> lista = pk.getLista();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
            NadjiStaneJezikePoIduSO nsjpidu = new NadjiStaneJezikePoIduSO();
            nsjpidu.izvrsiOperaciju(((Kurs) opstiDomenskiObjekat).getJezik());
            ((Kurs) opstiDomenskiObjekat).setJezik((StraniJezik) nsjpidu.getLista().get(0));

            NadjiNivoePoIduSO nnpidu = new NadjiNivoePoIduSO();
            nnpidu.izvrsiOperaciju(((Kurs) opstiDomenskiObjekat).getNivo());
            ((Kurs) opstiDomenskiObjekat).setNivo((Nivo) nnpidu.getLista().get(0));

            NadjiZaposlenePoIduSO nzpidu = new NadjiZaposlenePoIduSO();
            nzpidu.izvrsiOperaciju(((Kurs) opstiDomenskiObjekat).getNastavnik());
            ((Kurs) opstiDomenskiObjekat).setNastavnik((Zaposleni) nzpidu.getLista().get(0));
        }
        return lista;
    }

    public OpstiDomenskiObjekat pronadjiKurs(OpstiDomenskiObjekat kurs) throws Exception {
        PronadjiKursSO pk = new PronadjiKursSO();
        pk.izvrsiOperaciju(kurs);
        List<OpstiDomenskiObjekat> lista = pk.getLista();
        OpstiDomenskiObjekat k = lista.get(0);

        NadjiStaneJezikePoIduSO nsjpidu = new NadjiStaneJezikePoIduSO();
        nsjpidu.izvrsiOperaciju(((Kurs) k).getJezik());
        ((Kurs) k).setJezik((StraniJezik) nsjpidu.getLista().get(0));

        NadjiNivoePoIduSO nnpidu = new NadjiNivoePoIduSO();
        nnpidu.izvrsiOperaciju(((Kurs) k).getNivo());
        ((Kurs) k).setNivo((Nivo) nnpidu.getLista().get(0));

        NadjiZaposlenePoIduSO nzpidu = new NadjiZaposlenePoIduSO();
        nzpidu.izvrsiOperaciju(((Kurs) k).getNastavnik());
        ((Kurs) k).setNastavnik((Zaposleni) nzpidu.getLista().get(0));

        return k;
    }

    public void obrisiKurs(OpstiDomenskiObjekat kurs) throws Exception {
        ObrisiKursSO ok = new ObrisiKursSO();
        ok.izvrsiOperaciju(kurs);
    }

    public List<OpstiDomenskiObjekat> dajMesta() throws Exception {
        VratiSvaMestaSO vm = new VratiSvaMestaSO();
        vm.izvrsiOperaciju(new Mesto());
        return vm.getLista();
    }

    public OpstiDomenskiObjekat kreirajNovogPolaznika() throws Exception {
        NoviPolaznikSO np = new NoviPolaznikSO();
        np.izvrsiOperaciju(new Polaznik());
        return np.getPolaznik();
    }

    public void zapamtiPolaznika(OpstiDomenskiObjekat polaznik) throws Exception {
        ZapamtiPolaznikaSO zp = new ZapamtiPolaznikaSO();
        zp.izvrsiOperaciju(polaznik);

        for (Ugovor ugovor : ((Polaznik) polaznik).getUgovori()) {
            ZapamtiUgovorSO zu = new ZapamtiUgovorSO();
            zu.izvrsiOperaciju(ugovor);
        }
    }

    public List<OpstiDomenskiObjekat> pretraziPolaznike(OpstiDomenskiObjekat polaznik) throws Exception {
        PretraziPolaznikeSO pp = new PretraziPolaznikeSO();
        pp.izvrsiOperaciju(polaznik);
        List<OpstiDomenskiObjekat> lista = pp.getLista();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
            NadjiMestaPoIduSO nmpidu = new NadjiMestaPoIduSO();
            nmpidu.izvrsiOperaciju(((Polaznik) opstiDomenskiObjekat).getMesto());
            ((Polaznik) opstiDomenskiObjekat).setMesto((Mesto) nmpidu.getLista().get(0));
        }
        return lista;
    }

    public OpstiDomenskiObjekat pronadjiPolaznika(OpstiDomenskiObjekat polaznik) throws Exception {
        PronadjiPolaznikaSO pp = new PronadjiPolaznikaSO();
        pp.izvrsiOperaciju(polaznik);
        List<OpstiDomenskiObjekat> lista = pp.getLista();
        OpstiDomenskiObjekat p = lista.get(0);

        NadjiMestaPoIduSO nmpidu = new NadjiMestaPoIduSO();
        nmpidu.izvrsiOperaciju(((Polaznik) p).getMesto());
        ((Polaznik) p).setMesto((Mesto) nmpidu.getLista().get(0));

        PretraziUgovoreSO ppu = new PretraziUgovoreSO();
        Ugovor u = new Ugovor();
        u.setPolaznik((Polaznik) p);
        ppu.izvrsiOperaciju(u);
        List<OpstiDomenskiObjekat> ugovori = ppu.getLista();

        List<Ugovor> praviUgovori = new ArrayList<>();
        for (OpstiDomenskiObjekat ugovor : ugovori) {
            Ugovor ug = (Ugovor) ugovor;

            PronadjiPolaznikaSO ppso = new PronadjiPolaznikaSO();
            ppso.izvrsiOperaciju((Polaznik) p);
            Polaznik polaz = (Polaznik) ppso.getLista().get(0);
            ug.setPolaznik(polaz);

            PronadjiKursSO pkso = new PronadjiKursSO();
            pkso.izvrsiOperaciju(ug.getKurs());
            Kurs kurs = (Kurs) pkso.getLista().get(0);
            ug.setKurs(kurs);

            praviUgovori.add(ug);
        }
        ((Polaznik) p).setUgovori(praviUgovori);

        return p;
    }

    public void noviUgovor(OpstiDomenskiObjekat ugovor) throws Exception {
        NoviUgovorSO nu = new NoviUgovorSO();
        nu.izvrsiOperaciju(ugovor);
    }

    public List<OpstiDomenskiObjekat> dajKurseve() throws Exception {
        VratiSveKurseveSO vsk = new VratiSveKurseveSO();
        vsk.izvrsiOperaciju(new Kurs());
        List<OpstiDomenskiObjekat> lista = vsk.getLista();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
            NadjiStaneJezikePoIduSO nsjpidu = new NadjiStaneJezikePoIduSO();
            nsjpidu.izvrsiOperaciju(((Kurs) opstiDomenskiObjekat).getJezik());
            ((Kurs) opstiDomenskiObjekat).setJezik((StraniJezik) nsjpidu.getLista().get(0));

            NadjiNivoePoIduSO nnpidu = new NadjiNivoePoIduSO();
            nnpidu.izvrsiOperaciju(((Kurs) opstiDomenskiObjekat).getNivo());
            ((Kurs) opstiDomenskiObjekat).setNivo((Nivo) nnpidu.getLista().get(0));

            NadjiZaposlenePoIduSO nzpidu = new NadjiZaposlenePoIduSO();
            nzpidu.izvrsiOperaciju(((Kurs) opstiDomenskiObjekat).getNastavnik());
            ((Kurs) opstiDomenskiObjekat).setNastavnik((Zaposleni) nzpidu.getLista().get(0));
        }
        return lista;
    }

    public OpstiDomenskiObjekat kreirajNovogZaposlenog() throws Exception {
        NoviZaposleniSO nz = new NoviZaposleniSO();
        nz.izvrsiOperaciju(new Zaposleni());
        return nz.getZaposleni();
    }

    public void zapamtiZaposlenog(OpstiDomenskiObjekat zaposleni) throws Exception {
        ZapamtiZaposlenogSO zz = new ZapamtiZaposlenogSO();
        zz.izvrsiOperaciju(zaposleni);
    }

    public List<OpstiDomenskiObjekat> pretraziZaposlene(OpstiDomenskiObjekat zaposleni) throws Exception {
        PretraziZaposleneSO pz = new PretraziZaposleneSO();
        pz.izvrsiOperaciju(zaposleni);
        List<OpstiDomenskiObjekat> lista = pz.getLista();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
            NadjiMestaPoIduSO nmpidu = new NadjiMestaPoIduSO();
            nmpidu.izvrsiOperaciju(((Zaposleni) opstiDomenskiObjekat).getMesto());
            ((Zaposleni) opstiDomenskiObjekat).setMesto((Mesto) nmpidu.getLista().get(0));

            NadjiStaneJezikePoIduSO nsjpidu = new NadjiStaneJezikePoIduSO();
            nsjpidu.izvrsiOperaciju(((Zaposleni) opstiDomenskiObjekat).getJezik());
            ((Zaposleni) opstiDomenskiObjekat).setJezik((StraniJezik) nsjpidu.getLista().get(0));
        }
        return lista;
    }

    public OpstiDomenskiObjekat pronadjiZaposlenog(OpstiDomenskiObjekat zaposleni) throws Exception {
        PronadjiZaposlenogSO pz = new PronadjiZaposlenogSO();
        pz.izvrsiOperaciju(zaposleni);
        List<OpstiDomenskiObjekat> lista = pz.getLista();
        OpstiDomenskiObjekat z = lista.get(0);

        NadjiMestaPoIduSO nmpidu = new NadjiMestaPoIduSO();
        nmpidu.izvrsiOperaciju(((Zaposleni) z).getMesto());
        ((Zaposleni) z).setMesto((Mesto) nmpidu.getLista().get(0));

        NadjiStaneJezikePoIduSO nsjpidu = new NadjiStaneJezikePoIduSO();
        nsjpidu.izvrsiOperaciju(((Zaposleni) z).getJezik());
        ((Zaposleni) z).setJezik((StraniJezik) nsjpidu.getLista().get(0));


        return z;
    }
}
