/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.zaposleni;

import baza.DBKomunikacija;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.StraniJezik;
import domen.Zaposleni;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Dasa
 */
public class PronadjiZaposlenogSO extends OpstaSO {
    
    OpstiDomenskiObjekat zaposleni;
    
    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        zaposleni = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Zaposleni)o);
        
        OpstiDomenskiObjekat z = zaposleni;

        OpstiDomenskiObjekat listaMesta = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Mesto)((Zaposleni)z).getMesto());
        ((Zaposleni) z).setMesto((Mesto) listaMesta);

        OpstiDomenskiObjekat listaJezika = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((StraniJezik)((Zaposleni)z).getJezik());
        ((Zaposleni) z).setJezik((StraniJezik) listaJezika);
    }

    public OpstiDomenskiObjekat getZaposleni() {
        return zaposleni;
    }
    
}
