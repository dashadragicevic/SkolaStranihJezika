/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.kurs.ki;

import domen.Kurs;
import domen.Nivo;
import domen.StraniJezik;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import konstante.Konstante;
import kontroler.Kontroler;
import sesija.Sesija;
import tabela.model.ModelTabeleKurs;
import transfer.KlijentTransferObjekat;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Dasa
 */
public class KontrolorKIPretraziKurseve {

    public static void pretraziKurseve(JComboBox jcbStraniJezik, JComboBox jcbNivo, JTable jtblKurs) {
        try {
            StraniJezik sj = (StraniJezik) jcbStraniJezik.getSelectedItem();
            Nivo n = (Nivo) jcbNivo.getSelectedItem();
            
            Kurs kurs = new Kurs();
            kurs.setJezik(sj);
            kurs.setNivo(n);

            ServerTransferObjekat sto = Kontroler.vratiInstancu().pretraziKurseve(kurs);
            
            List<Kurs> listaKurseva = null;
            if (sto.isSignal()) {
                //JOptionPane.showMessageDialog(null, sto.getPoruka(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                listaKurseva = (List<Kurs>) sto.getPodaci();                
                ModelTabeleKurs m = new ModelTabeleKurs(listaKurseva);
                jtblKurs.setModel(m);
            } else {
                //JOptionPane.showMessageDialog(null, sto.getPoruka(), "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
