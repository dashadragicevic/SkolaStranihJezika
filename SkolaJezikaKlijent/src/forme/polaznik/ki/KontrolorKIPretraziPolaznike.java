/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.polaznik.ki;

import domen.Polaznik;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import kontroler.Kontroler;
import tabela.model.ModelTabelePolaznik;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Dasa
 */
public class KontrolorKIPretraziPolaznike {

    public static void pretraziPolaznike(JTextField jtxtIme, JTextField jtxtPrezime, JTextField jtxtJMBG, JTable jtblPolaznik) {
        try {
            String ime = jtxtIme.getText().trim();
            String prezime = jtxtPrezime.getText().trim();
            String jmbg = jtxtJMBG.getText().trim();

            ServerTransferObjekat sto = null;
            if (ime.isEmpty() && prezime.isEmpty() && jmbg.isEmpty()) {
                sto = Kontroler.vratiInstancu().dajSvePolaznike();
            } else {
                Polaznik polaznik = new Polaznik();
                polaznik.setIme(ime);
                polaznik.setPrezime(prezime);
                polaznik.setJMBG(jmbg);

                sto = Kontroler.vratiInstancu().pretraziPolaznike(polaznik);
            }
            List<Polaznik> lista = null;
            if (sto.isSignal()) {
                //JOptionPane.showMessageDialog(null, sto.getPoruka(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                lista = (List<Polaznik>) sto.getPodaci();
                ModelTabelePolaznik m = new ModelTabelePolaznik(lista);
                jtblPolaznik.setModel(m);
            } else {
                //JOptionPane.showMessageDialog(null, sto.getPoruka(), "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
