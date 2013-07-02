/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.kurs.ki;

import domen.StraniJezik;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Dasa
 */
public class KontrolorKIDajSveJezike {
    
    public static void dajSveJezike(JComboBox jcbStraniJezik){
         try {
            ServerTransferObjekat sto = Kontroler.vratiInstancu().dajSveJezike();
            List<StraniJezik> lista = null;
            if (sto.isSignal()) {
                lista = (List<StraniJezik>) sto.getPodaci();
                for (StraniJezik straniJezik : lista) {
                    jcbStraniJezik.addItem(straniJezik);
                }
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Greska pri ucitavanju stranih jezika!");
        }
    }
    
}
