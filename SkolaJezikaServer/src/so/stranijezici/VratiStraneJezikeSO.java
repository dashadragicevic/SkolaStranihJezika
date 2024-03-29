/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.stranijezici;

import baza.DBKomunikacija;
import domen.OpstiDomenskiObjekat;
import domen.StraniJezik;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Dasa
 */
public class VratiStraneJezikeSO extends OpstaSO {
    
    List<OpstiDomenskiObjekat> lista;
    
    @Override
    protected void proveriPreduslov(Object o) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        lista = DBKomunikacija.vratiObjekat().vratiSveObjekte((StraniJezik)o);
    }
    
    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }
    
}
