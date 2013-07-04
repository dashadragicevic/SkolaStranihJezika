/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.polaznik.ki;

import domen.Mesto;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Dasa
 */
public class KontrolorKIDajSvaMesta {
    
    public static void dajSvaMesta(JComboBox jcbMesto){
         try {
            ServerTransferObjekat sto = Kontroler.vratiInstancu().dajSvaMesta();
            List<Mesto> lista = null;
            if (sto.isSignal()) {
                lista = (List<Mesto>) sto.getPodaci();
                for (Mesto mesto : lista) {
                    jcbMesto.addItem(mesto);
                }
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Greska pri ucitavanju mesta!");
        }
    }
    
}
