/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.kurs;

import baza.DBKomunikacija;
import domen.Kurs;
import domen.OpstiDomenskiObjekat;
import so.OpstaSO;

/**
 *
 * @author Dasa
 */
public class NoviKursSO extends OpstaSO {

    OpstiDomenskiObjekat noviKurs;
    
    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        long id = DBKomunikacija.vratiObjekat().ubaciNovi((Kurs)o);
        noviKurs = (Kurs)o;
        ((Kurs)noviKurs).setKursID(id);
    }

    public OpstiDomenskiObjekat getNoviKurs() {
        return noviKurs;
    }

    public void setNoviKurs(OpstiDomenskiObjekat noviKurs) {
        this.noviKurs = noviKurs;
    }
 
}
