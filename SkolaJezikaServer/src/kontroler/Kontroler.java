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
import domen.Zaposleni;
import java.util.List;
import so.kurs.KreirajNoviKursSO;
import so.kurs.ObrisiKursSO;
import so.kurs.PretraziKurseveSO;
import so.kurs.PronadjiKursSO;
import so.kurs.VratiSveKurseveSO;
import so.kurs.ZapamtiKursSO;
import so.mesto.VratiSvaMestaSO;
import so.nivo.VratiNivoeSO;
import so.polaznik.KreirajPolaznikaSO;
import so.polaznik.PretraziPolaznikeSO;
import so.polaznik.PronadjiPolaznikaSO;
import so.polaznik.VratiSvePolaznikeSO;
import so.polaznik.ZapamtiPolaznikaSO;
import so.stranijezici.VratiStraneJezikeSO;
import so.ugovor.NoviUgovorSO;
import so.zaposleni.KreirajZaposlenogSO;
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
        return vz.getLista();
    }

    public OpstiDomenskiObjekat kreirajNoviKurs() throws Exception {
        KreirajNoviKursSO nk = new KreirajNoviKursSO();
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
        return pk.getLista();
    }

    public OpstiDomenskiObjekat pronadjiKurs(OpstiDomenskiObjekat kurs) throws Exception {
        PronadjiKursSO pk = new PronadjiKursSO();
        pk.izvrsiOperaciju(kurs);
        return pk.getLista().get(0);
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
        KreirajPolaznikaSO np = new KreirajPolaznikaSO();
        np.izvrsiOperaciju(new Polaznik());
        return np.getPolaznik();
    }

    public void zapamtiPolaznika(OpstiDomenskiObjekat polaznik) throws Exception {
        ZapamtiPolaznikaSO zp = new ZapamtiPolaznikaSO();
        zp.izvrsiOperaciju(polaznik);
    }

    public List<OpstiDomenskiObjekat> pretraziPolaznike(OpstiDomenskiObjekat polaznik) throws Exception {
        PretraziPolaznikeSO pp = new PretraziPolaznikeSO();
        pp.izvrsiOperaciju(polaznik);
        return pp.getLista();
    }
    
    public List<OpstiDomenskiObjekat> dajPolaznike() throws Exception {
        VratiSvePolaznikeSO pp = new VratiSvePolaznikeSO();
        pp.izvrsiOperaciju(new Polaznik());
        return pp.getLista();
    }

    public OpstiDomenskiObjekat pronadjiPolaznika(OpstiDomenskiObjekat polaznik) throws Exception {
        PronadjiPolaznikaSO pp = new PronadjiPolaznikaSO();
        pp.izvrsiOperaciju(polaznik);
        return pp.getLista().get(0);
    }

    public void noviUgovor(OpstiDomenskiObjekat ugovor) throws Exception {
        NoviUgovorSO nu = new NoviUgovorSO();
        nu.izvrsiOperaciju(ugovor);
    }

    public List<OpstiDomenskiObjekat> dajKurseve() throws Exception {
        VratiSveKurseveSO vsk = new VratiSveKurseveSO();
        vsk.izvrsiOperaciju(new Kurs());
        return vsk.getLista();
    }

    public OpstiDomenskiObjekat kreirajNovogZaposlenog() throws Exception {
        KreirajZaposlenogSO nz = new KreirajZaposlenogSO();
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
        return pz.getLista();
    }

    public OpstiDomenskiObjekat pronadjiZaposlenog(OpstiDomenskiObjekat zaposleni) throws Exception {
        PronadjiZaposlenogSO pz = new PronadjiZaposlenogSO();
        pz.izvrsiOperaciju(zaposleni);
        return pz.getLista().get(0);
    }
}
