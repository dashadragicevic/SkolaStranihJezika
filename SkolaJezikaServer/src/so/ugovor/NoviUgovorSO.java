/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ugovor;

import baza.DBKomunikacija;
import domen.OpstiDomenskiObjekat;
import domen.Ugovor;
import so.OpstaSO;

/**
 *
 * @author Dasa
 */
public class NoviUgovorSO extends OpstaSO {

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        DBKomunikacija.vratiObjekat().ubaciNovi((Ugovor)o);
    }
    
}
