/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.kurs.ki;

import domen.Kurs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Dasa
 */
public class KontrolorKINoviKurs {
    
    public static void noviKurs(JLabel jlKursID){
        try {
            ServerTransferObjekat sto = Kontroler.vratiInstancu().noviKurs();
            if (sto.isSignal()) {
                JOptionPane.showMessageDialog(null, sto.getPoruka(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                Kurs noviKurs = (Kurs) sto.getPodaci();
                jlKursID.setText(noviKurs.getKursID() + "");
            } else {
                JOptionPane.showMessageDialog(null, sto.getPoruka(), "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
}
