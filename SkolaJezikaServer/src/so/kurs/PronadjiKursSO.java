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

    OpstiDomenskiObjekat k;
    
    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        k = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Kurs)o);
        //OpstiDomenskiObjekat k = lista.get(0);

        OpstiDomenskiObjekat jezik = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((StraniJezik)((Kurs)k).getJezik());
        ((Kurs) k).setJezik((StraniJezik) jezik);

        OpstiDomenskiObjekat nivo = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Nivo)((Kurs)k).getNivo());
        ((Kurs) k).setNivo((Nivo) nivo);

        OpstiDomenskiObjekat zaposleni = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Zaposleni)((Kurs)k).getNastavnik());
        ((Kurs) k).setNastavnik((Zaposleni) zaposleni);
    }

    public OpstiDomenskiObjekat getKurs() {
        return k;
    }
    
}
