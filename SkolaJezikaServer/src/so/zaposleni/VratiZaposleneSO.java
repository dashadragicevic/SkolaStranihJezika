/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.zaposleni;

import baza.DBKomunikacija;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.StraniJezik;
import domen.Zaposleni;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Dasa
 */
public class VratiZaposleneSO extends OpstaSO {
    
    List<OpstiDomenskiObjekat> lista;
    
    @Override
    protected void proveriPreduslov(Object o) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        lista = DBKomunikacija.vratiObjekat().vratiSveObjekte((Zaposleni)o);
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
            OpstiDomenskiObjekat listaMesta = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Mesto)((Zaposleni)opstiDomenskiObjekat).getMesto());
            ((Zaposleni) opstiDomenskiObjekat).setMesto((Mesto) listaMesta);

            OpstiDomenskiObjekat listaJezika = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((StraniJezik)((Zaposleni)opstiDomenskiObjekat).getJezik());
            ((Zaposleni) opstiDomenskiObjekat).setJezik((StraniJezik) listaJezika);
        }
    }
    
    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }
    
}
