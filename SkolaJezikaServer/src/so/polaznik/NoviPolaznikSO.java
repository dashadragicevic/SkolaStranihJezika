/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.polaznik;

import baza.DBKomunikacija;
import domen.OpstiDomenskiObjekat;
import domen.Polaznik;
import so.OpstaSO;

/**
 *
 * @author Dasa
 */
public class NoviPolaznikSO extends OpstaSO {
    
    OpstiDomenskiObjekat polaznik;

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        long id = DBKomunikacija.vratiObjekat().ubaciNovi((Polaznik)o);
        polaznik = (Polaznik)o;
        ((Polaznik)polaznik).setPolaznikID(id);
    }

    public OpstiDomenskiObjekat getPolaznik() {
        return polaznik;
    }

    public void setPolaznik(OpstiDomenskiObjekat polaznik) {
        this.polaznik = polaznik;
    }
    
}
