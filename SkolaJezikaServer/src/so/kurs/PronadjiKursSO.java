/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.kurs;

import baza.DBKomunikacija;
import domen.Kurs;
import domen.Nivo;
import domen.OpstiDomenskiObjekat;
import domen.StraniJezik;
import domen.Zaposleni;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Dasa
 */
public class PronadjiKursSO extends OpstaSO {

    List<OpstiDomenskiObjekat> lista;
    
    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        lista = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Kurs)o);
        OpstiDomenskiObjekat k = lista.get(0);

        List<OpstiDomenskiObjekat> listaJezika = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((StraniJezik)((Kurs)k).getJezik());
        ((Kurs) k).setJezik((StraniJezik) listaJezika.get(0));

        List<OpstiDomenskiObjekat> listaNivoa = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Nivo)((Kurs)k).getNivo());
        ((Kurs) k).setNivo((Nivo) listaNivoa.get(0));

        List<OpstiDomenskiObjekat> listaZaposlenih = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Zaposleni)((Kurs)k).getNastavnik());
        ((Kurs) k).setNastavnik((Zaposleni) listaZaposlenih.get(0));
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }
    
}
