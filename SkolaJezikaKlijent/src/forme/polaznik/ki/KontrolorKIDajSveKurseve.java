/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.polaznik.ki;

import domen.Kurs;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Dasa
 */
public class KontrolorKIDajSveKurseve {

    public static void dajSveKurseve(JComboBox jcbbKurs) {
        try {
            ServerTransferObjekat sto = Kontroler.vratiInstancu().dajSveKurseve();
            List<Kurs> lista = null;
            if (sto.isSignal()) {
                lista = (List<Kurs>) sto.getPodaci();
                for (Kurs k : lista) {
                    jcbbKurs.addItem(k);
                }
                jcbbKurs.setSelectedItem(lista.get(0));
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Greska pri ucitavanju kurseva!");
        }
    }
}
