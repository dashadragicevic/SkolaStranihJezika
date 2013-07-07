/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.polaznik;

import baza.DBKomunikacija;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.Polaznik;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Dasa
 */
public class VratiSvePolaznikeSO extends OpstaSO {
    
    List<OpstiDomenskiObjekat> lista;
    
    @Override
    protected void proveriPreduslov(Object o) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        lista = DBKomunikacija.vratiObjekat().vratiSveObjekte((Polaznik)o);
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
            OpstiDomenskiObjekat mesta = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Mesto)((Polaznik)opstiDomenskiObjekat).getMesto());
            ((Polaznik) opstiDomenskiObjekat).setMesto((Mesto) mesta);
        }
    }
    
    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }
    
}
