/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.zaposleni.ki;

import domen.Polaznik;
import domen.Zaposleni;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Dasa
 */
public class KontrolorKINoviZaposleni {
    
    public static void noviZaposleni(JLabel jlPolaznikID){
        try {
            ServerTransferObjekat sto = Kontroler.vratiInstancu().noviZaposleni();
            if (sto.isSignal()) {
                JOptionPane.showMessageDialog(null, sto.getPoruka(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                Zaposleni noviZaposleni = (Zaposleni) sto.getPodaci();
                jlPolaznikID.setText(noviZaposleni.getZaposleniID() + "");
            } else {
                JOptionPane.showMessageDialog(null, sto.getPoruka(), "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
}
