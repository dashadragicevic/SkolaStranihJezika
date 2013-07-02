/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.kurs.ki;

import domen.Kurs;
import forme.kurs.FPretragaKursevaTabela;
import forme.kurs.FUnosKursa;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import kontroler.Kontroler;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Dasa
 */
public class KontrolorKIPronadjiKurs {
    
    public static void pronadjiKurs(JTable jtblKurs){
        try {
            int id = Integer.parseInt(jtblKurs.getValueAt(jtblKurs.getSelectedRow(), 0).toString());
            Kurs k = new Kurs();
            k.setKursID(id);

            ServerTransferObjekat sto = Kontroler.vratiInstancu().pronadjiKurs(k);
            
            if (sto.isSignal()) {
                //JOptionPane.showMessageDialog(null, sto.getPoruka(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                
                Kurs kurs = (Kurs) sto.getPodaci();                
                FUnosKursa formaPrikaz = new FUnosKursa(null, true);
                formaPrikaz.popuniPodatke(kurs);
                formaPrikaz.onemoguciUnos();
                
                formaPrikaz.setVisible(true);
            } else {
                //JOptionPane.showMessageDialog(null, sto.getPoruka(), "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Greska pri ucitavanju kursa: " + ex.getMessage());
        }
    }
    
}
