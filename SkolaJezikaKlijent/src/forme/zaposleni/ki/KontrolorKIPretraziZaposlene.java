/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.zaposleni.ki;

import forme.polaznik.ki.*;
import domen.Polaznik;
import domen.Zaposleni;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import kontroler.Kontroler;
import tabela.model.ModelTabelePolaznik;
import tabela.model.ModelTabeleZaposleni;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Dasa
 */
public class KontrolorKIPretraziZaposlene {

    public static void pretraziZaposlene(JTextField jtxtIme, JTextField jtxtPrezime, JTextField jtxtJMBG, JTable jtblZaposleni) {
        try {
            String ime = jtxtIme.getText().trim();
            String prezime = jtxtPrezime.getText().trim();
            String jmbg = jtxtJMBG.getText().trim();

            ServerTransferObjekat sto = null;
            if (ime.isEmpty() && prezime.isEmpty() && jmbg.isEmpty()) {
                sto = Kontroler.vratiInstancu().dajSveZaposlene();
            } else {
                Zaposleni zap = new Zaposleni();
                zap.setIme(ime);
                zap.setPrezime(prezime);
                zap.setJMBG(jmbg);

                sto = Kontroler.vratiInstancu().pretraziZaposlene(zap);
            }
            List<Zaposleni> lista = null;
            if (sto.isSignal()) {
                //JOptionPane.showMessageDialog(null, sto.getPoruka(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                lista = (List<Zaposleni>) sto.getPodaci();
                ModelTabeleZaposleni m = new ModelTabeleZaposleni(lista);
                jtblZaposleni.setModel(m);
            } else {
                //JOptionPane.showMessageDialog(null, sto.getPoruka(), "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
