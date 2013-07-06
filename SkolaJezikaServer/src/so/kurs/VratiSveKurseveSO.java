/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.kurs;

import baza.DBKomunikacija;
import domen.Kurs;
import domen.Mesto;
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
public class VratiSveKurseveSO extends OpstaSO {
    
    List<OpstiDomenskiObjekat> lista;
    
    @Override
    protected void proveriPreduslov(Object o) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        lista = DBKomunikacija.vratiObjekat().vratiSveObjekte((Kurs)o);
        
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
            List<OpstiDomenskiObjekat> listaJezika = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((StraniJezik)((Kurs)opstiDomenskiObjekat).getJezik());
            ((Kurs) opstiDomenskiObjekat).setJezik((StraniJezik) listaJezika.get(0));

            List<OpstiDomenskiObjekat> listaNivoa = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Nivo)((Kurs)opstiDomenskiObjekat).getNivo());
            ((Kurs) opstiDomenskiObjekat).setNivo((Nivo) listaNivoa.get(0));

            List<OpstiDomenskiObjekat> listaNastavnika = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Zaposleni)((Kurs)opstiDomenskiObjekat).getNastavnik());
            ((Kurs) opstiDomenskiObjekat).setNastavnik((Zaposleni) listaNastavnika.get(0));
        }
    }
    
    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }
    
}
