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
import domen.StraniJezik;
import domen.Zaposleni;
import java.util.List;
import so.kurs.NoviKursSO;
import so.kurs.PretraziKurseveSO;
import so.kurs.PronadjiKursSO;
import so.kurs.ZapamtiKursSO;
import so.mesto.NadjiMestaPoIduSO;
import so.mesto.VratiSvaMestaSO;
import so.nivo.NadjiNivoePoIduSO;
import so.nivo.VratiNivoeSO;
import so.stranijezici.NadjiStaneJezikePoIduSO;
import so.stranijezici.VratiStraneJezikeSO;
import so.zaposleni.NadjiZaposlenePoIduSO;
import so.zaposleni.VratiZaposleneSO;

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

    //za CBBove:
    public List<OpstiDomenskiObjekat> dajMesta() throws Exception {
//        db.ucitajDriver();
//        db.otvoriKonekciju();
//        List<Mesto> lm = null;
//        try {
//            lm = db.vratiMesta();
//        } catch (Exception e) {
//            throw e;
//        }        
//        db.zatvoriKonekciju();
//        return lm;
        VratiSvaMestaSO vm = new VratiSvaMestaSO();
        vm.izvrsiOperaciju(new Mesto());
        return vm.getLista();
    }

    public List<OpstiDomenskiObjekat> dajStraneJezike() throws Exception {
//        db.ucitajDriver();
//        db.otvoriKonekciju();
//        List<StraniJezik> lm = null;
//        try {
//            lm = db.vratiJezike();
//        } catch (Exception e) {
//            throw e;
//        }
//        db.zatvoriKonekciju();
//        return lm;
        VratiStraneJezikeSO vsj = new VratiStraneJezikeSO();
        vsj.izvrsiOperaciju(new StraniJezik());
        return vsj.getLista();
    }

    public List<OpstiDomenskiObjekat> dajNivoe() throws Exception {
//        db.ucitajDriver();
//        db.otvoriKonekciju();
//        List<Nivo> lm = null;
//        try {
//            lm = db.vratiNivoe();
//        } catch (Exception e) {
//            throw e;
//        }
//        db.zatvoriKonekciju();
//        return lm;
        VratiNivoeSO vn = new VratiNivoeSO();
        vn.izvrsiOperaciju(new Nivo());
        return vn.getLista();
    }

    public List<OpstiDomenskiObjekat> dajZaposlene() throws Exception {
//        db.ucitajDriver();
//        db.otvoriKonekciju();
//        List<Zaposleni> lm = null;
//        try {
//            lm = db.vratiZaposlene();
//        } catch (Exception e) {
//            throw e;
//        }
//        db.zatvoriKonekciju();
//        return lm;
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
//        Kurs kurs = new Kurs();
//        db.ucitajDriver();
//        db.otvoriKonekciju();
//        try {
//            long kursID = db.rezervisiKursID();
//            kurs.setKursID(kursID);
//        } catch (Exception e) {
//            throw e;
//        }
//        db.zatvoriKonekciju();        
//        return kurs;
        NoviKursSO nk = new NoviKursSO();
        nk.izvrsiOperaciju(new Kurs());
        return nk.getNoviKurs();
    }

    public void zapamtiKurs(OpstiDomenskiObjekat k) throws Exception {
//        db.ucitajDriver();
//        db.otvoriKonekciju();
//        try {
//            db.zapamtiKurs(k);
//            db.commitTransakcije();
//        } catch (Exception e){
//            db.rollbackTransakcije();
//            throw e;
//        }        
//        db.zatvoriKonekciju();
        ZapamtiKursSO zk = new ZapamtiKursSO();
        zk.izvrsiOperaciju(k);
    }

    public List<OpstiDomenskiObjekat> pretraziKurseve(OpstiDomenskiObjekat kurs) throws Exception {
//        db.ucitajDriver();
//        db.otvoriKonekciju();
//        List<Kurs> lk = null;
//        try {
//            lk = db.pretraziKurseve(kurs);
//        } catch (Exception e) {
//            throw e;
//        }
//        db.zatvoriKonekciju();
//        return lk;
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
//        db.ucitajDriver();
//        db.otvoriKonekciju();
//        Kurs kk = null;
//        try {
//            kk = db.pronadjiKurs(kurs);
//        } catch (Exception e) {
//            throw e;
//        }
//        db.zatvoriKonekciju();
//        return kk;
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
//        db.ucitajDriver();
//        db.otvoriKonekciju();
//        try {
//            db.obrisiKurs(kurs);
//            db.commitTransakcije();
//        } catch (Exception e) {
//            db.rollbackTransakcije();
//            throw e;
//        }
//        db.zatvoriKonekciju();
        
    }

    /*
     public long dajKursID(Kurs k) throws Exception{
     db.ucitajDriver();
     db.otvoriKonekciju();
     //long id = db.nadjiKursID(k);
     db.zatvoriKonekciju();
     return id;
     }
    
     public Kurs dajKurs(int id) throws Exception{
     db.ucitajDriver();
     db.otvoriKonekciju();
     //Kurs k = db.nadjiKurs(id);
     db.zatvoriKonekciju();
     return k;
     }
     *//*
    public List<Kurs> dajSveKurseve() {
        return null;
    }*/
}
