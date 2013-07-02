/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import baza.DBKomunikacija;

/**
 *
 * @author Dasa
 */
public abstract class OpstaSO {
    
    public final void izvrsiOperaciju(Object o) throws Exception {
        try {
            DBKomunikacija.vratiObjekat().ucitajDriver();
            DBKomunikacija.vratiObjekat().otvoriKonekciju();
            
            proveriPreduslov(o);
            izvrsiKonkretnuOperaciju(o);
            
            DBKomunikacija.vratiObjekat().commitTransakcije();
        } catch (Exception e) {
            DBKomunikacija.vratiObjekat().rollbackTransakcije();
            throw e;
        } finally {
            DBKomunikacija.vratiObjekat().zatvoriKonekciju();
        }
    }
    
    protected abstract void proveriPreduslov(Object o) throws Exception;

    protected abstract void izvrsiKonkretnuOperaciju(Object o) throws Exception;

}
