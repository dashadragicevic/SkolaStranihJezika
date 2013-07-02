/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.kurs.ki;

import domen.Nivo;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Dasa
 */
public class KontrolorKIDajSveNivoe {
    
    public static void dajSveNivoe(JComboBox jcbNivo){
        try {
            ServerTransferObjekat sto = Kontroler.vratiInstancu().dajSveNivoe();
            List<Nivo> lista = null;
            if (sto.isSignal()) {
                lista = (List<Nivo>) sto.getPodaci();
                for (Nivo nivo : lista) {
                    jcbNivo.addItem(nivo);
                }
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Greska pri ucitavanju nivoa!");
        }
    }
    
}
