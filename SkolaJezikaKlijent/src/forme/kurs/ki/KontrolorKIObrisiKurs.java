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
public class KontrolorKIObrisiKurs {

    public static void obrisiKurs(JLabel jlKursID) {
        try {
            long kursID = Long.parseLong(jlKursID.getText().trim());
            Kurs kurs = new Kurs();
            kurs.setKursID(kursID);
            
            ServerTransferObjekat sto = Kontroler.vratiInstancu().obrisiKurs(kurs);
            if (sto.isSignal()) {
                JOptionPane.showMessageDialog(null, sto.getPoruka(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, sto.getPoruka(), "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
}
