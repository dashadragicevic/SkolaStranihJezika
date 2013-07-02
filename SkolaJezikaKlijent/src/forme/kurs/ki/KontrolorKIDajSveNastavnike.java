/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.kurs.ki;

import domen.Zaposleni;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Dasa
 */
public class KontrolorKIDajSveNastavnike {
    
    public static void dajSveNastavnike(JComboBox jcbNastavnik){
        try {
            ServerTransferObjekat sto = Kontroler.vratiInstancu().dajSveNastavnike();
            List<Zaposleni> lista = null;
            if (sto.isSignal()) {
                lista = (List<Zaposleni>) sto.getPodaci();
                for (Zaposleni nastavnik : lista) {
                    jcbNastavnik.addItem(nastavnik);
                }
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Greska pri ucitavanju nastavnika!");
        }
    }
    
}
