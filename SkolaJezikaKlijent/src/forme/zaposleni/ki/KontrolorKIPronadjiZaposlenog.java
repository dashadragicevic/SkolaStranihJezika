/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.zaposleni.ki;

import domen.Zaposleni;
import forme.zaposleni.FNoviZaposleni;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import kontroler.Kontroler;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Dasa
 */
public class KontrolorKIPronadjiZaposlenog {
    
    public static void pronadjiZaposlenog(JTable jtblZaposleni){
        try {
            int id = Integer.parseInt(jtblZaposleni.getValueAt(jtblZaposleni.getSelectedRow(), 0).toString());
            Zaposleni z = new Zaposleni();
            z.setZaposleniID(id);

            ServerTransferObjekat sto = Kontroler.vratiInstancu().pronadjiZaposlenog(z);
            
            if (sto.isSignal()) {
                //JOptionPane.showMessageDialog(null, sto.getPoruka(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                
                Zaposleni zap = (Zaposleni) sto.getPodaci();                
                FNoviZaposleni formaPrikaz = new FNoviZaposleni(null, true);
                formaPrikaz.popuniPodatke(zap);
                formaPrikaz.onemoguciUnos();
                //formaPrikaz.setAlwaysOnTop(true);
                formaPrikaz.setVisible(true);
            } else {
                //JOptionPane.showMessageDialog(null, sto.getPoruka(), "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Greska pri ucitavanju zaposlenog: " + ex.getMessage());
        }
    }
    
}
