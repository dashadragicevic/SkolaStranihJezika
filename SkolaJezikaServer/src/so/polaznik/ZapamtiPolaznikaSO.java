/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.polaznik;

import baza.DBKomunikacija;
import domen.Polaznik;
import so.OpstaSO;

/**
 *
 * @author Dasa
 */
public class ZapamtiPolaznikaSO extends OpstaSO {

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        DBKomunikacija.vratiObjekat().sacuvajIzmene((Polaznik)o);
    }
    
}