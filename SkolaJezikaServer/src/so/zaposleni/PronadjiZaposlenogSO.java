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
public class PronadjiZaposlenogSO extends OpstaSO {
    
    List<OpstiDomenskiObjekat> lista;
    
    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        lista = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Zaposleni)o);
        
        OpstiDomenskiObjekat z = lista.get(0);

        List<OpstiDomenskiObjekat> listaMesta = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((Mesto)((Zaposleni)z).getMesto());
        ((Zaposleni) z).setMesto((Mesto) listaMesta.get(0));

        List<OpstiDomenskiObjekat> listaJezika = DBKomunikacija.vratiObjekat().vratiObjektePoIDu((StraniJezik)((Zaposleni)z).getJezik());
        ((Zaposleni) z).setJezik((StraniJezik) listaJezika.get(0));
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }
    
}
