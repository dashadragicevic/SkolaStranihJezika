/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.polaznik.ki;

import domen.Polaznik;
import forme.polaznik.FNoviPolaznik;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import kontroler.Kontroler;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Dasa
 */
public class KontrolorKIPronadjiPolaznika {
    
    public static void pronadjiPolaznika(JTable jtblPolaznik){
        try {
            int id = Integer.parseInt(jtblPolaznik.getValueAt(jtblPolaznik.getSelectedRow(), 0).toString());
            Polaznik p = new Polaznik();
            p.setPolaznikID(id);

            ServerTransferObjekat sto = Kontroler.vratiInstancu().pronadjiPolaznika(p);
            
            if (sto.isSignal()) {
                //JOptionPane.showMessageDialog(null, sto.getPoruka(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                
                Polaznik polaznik = (Polaznik) sto.getPodaci();                
                FNoviPolaznik formaPrikaz = new FNoviPolaznik();
                formaPrikaz.popuniPodatke(polaznik);
                formaPrikaz.onemoguciUnos();
                formaPrikaz.setAlwaysOnTop(true);
                formaPrikaz.setVisible(true);
            } else {
                //JOptionPane.showMessageDialog(null, sto.getPoruka(), "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Greska pri ucitavanju polaznika: " + ex.getMessage());
        }
    }
    
}
