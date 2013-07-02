/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.kurs;

import baza.DBKomunikacija;
import domen.Kurs;
import so.OpstaSO;

/**
 *
 * @author Dasa
 */
public class ZapamtiKursSO extends OpstaSO {

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        DBKomunikacija.vratiObjekat().sacuvajIzmene((Kurs)o);
    }
    
}
