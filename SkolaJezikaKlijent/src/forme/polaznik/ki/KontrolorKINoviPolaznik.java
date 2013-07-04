/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.polaznik.ki;

import domen.Polaznik;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import kontroler.Kontroler;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Dasa
 */
public class KontrolorKINoviPolaznik {
    
    public static void noviPolaznik(JLabel jlPolaznikID){
        try {
            ServerTransferObjekat sto = Kontroler.vratiInstancu().noviPolaznik();
            if (sto.isSignal()) {
                JOptionPane.showMessageDialog(null, sto.getPoruka(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                Polaznik noviPolaznik = (Polaznik) sto.getPodaci();
                jlPolaznikID.setText(noviPolaznik.getPolaznikID() + "");
            } else {
                JOptionPane.showMessageDialog(null, sto.getPoruka(), "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
}
