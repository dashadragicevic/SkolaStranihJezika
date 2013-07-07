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
public class PretraziKurseveSO extends OpstaSO {

    List<OpstiDomenskiObjekat> lista;
    
    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        lista = DBKomunikacija.vratiObjekat().vratiObjektePretraga((Kurs)o);
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
            OpstiDomenskiObjekat jezik = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((StraniJezik)((Kurs)opstiDomenskiObjekat).getJezik());
            ((Kurs) opstiDomenskiObjekat).setJezik((StraniJezik) jezik);

            OpstiDomenskiObjekat nivo = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Nivo)((Kurs)opstiDomenskiObjekat).getNivo());
            ((Kurs) opstiDomenskiObjekat).setNivo((Nivo) nivo);

            OpstiDomenskiObjekat zaposleni = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Zaposleni)((Kurs)opstiDomenskiObjekat).getNastavnik());
            ((Kurs) opstiDomenskiObjekat).setNastavnik((Zaposleni) zaposleni);
        }
    }
    
    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }
    
}
