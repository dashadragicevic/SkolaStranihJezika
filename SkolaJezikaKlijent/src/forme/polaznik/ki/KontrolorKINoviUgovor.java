/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.polaznik.ki;

import domen.Kurs;
import domen.Polaznik;
import domen.Ugovor;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import kontroler.Kontroler;
import tabela.model.ModelTabeleUgovori;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Dasa
 */
public class KontrolorKINoviUgovor {

    public static void noviUgovor(JTable jtblUgovori) {
        try {
            ModelTabeleUgovori mtu = (ModelTabeleUgovori) jtblUgovori.getModel();
            Polaznik p = mtu.vratiPolaznika();
            Ugovor u = new Ugovor();
            u.setPolaznik(p);
            if (p.getUgovori().size() == 0) {
                u.setUgovorID(1);
            } else {
                u.setUgovorID(p.getUgovori().get(p.getUgovori().size() - 1).getUgovorID() + 1);
            }
            u.setBrojRata(0);
            u.setIznosRate(0);
            Kurs k = new Kurs();
            k.setKursID(1);
            u.setKurs(k);
            u.setRokZaSlRatu(new Date());
            u.setUkupnoPlaceno(0);
            u.setUkupnoPlacenoRata(0);
            ServerTransferObjekat sto = Kontroler.vratiInstancu().noviUgovor(u);
            if (sto.isSignal()) {
                JOptionPane.showMessageDialog(null, sto.getPoruka(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                mtu.dodajRed(u);
            } else {
                JOptionPane.showMessageDialog(null, sto.getPoruka(), "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
