/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.zaposleni;

import baza.DBKomunikacija;
import domen.OpstiDomenskiObjekat;
import domen.Zaposleni;
import so.OpstaSO;

/**
 *
 * @author Dasa
 */
public class NoviZaposleniSO extends OpstaSO {
    
    OpstiDomenskiObjekat zaposleni;

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        long id = DBKomunikacija.vratiObjekat().ubaciNovi((Zaposleni)o);
        zaposleni = (Zaposleni)o;
        ((Zaposleni)zaposleni).setZaposleniID(id);
    }

    public OpstiDomenskiObjekat getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(OpstiDomenskiObjekat zaposleni) {
        this.zaposleni = zaposleni;
    }
    
}
