/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ugovor;

import baza.DBKomunikacija;
import domen.Ugovor;
import so.OpstaSO;

/**
 *
 * @author Dasa
 */
public class ZapamtiUgovorSO extends OpstaSO {
    
    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        DBKomunikacija.vratiObjekat().sacuvajIzmene((Ugovor)o);
    }
    
}
