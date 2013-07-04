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

            if (ime.isEmpty() && prezime.isEmpty() && jmbg.isEmpty()) {
                throw new Exception("Morate uneti podatke u bar jedno polje za pretragu!");
            }

            if (!jmbg.isEmpty()) {
                if (jmbg.length() < 13 || jmbg.length() > 13) {
                    throw new Exception("JMBG mora imati 13 cifara!");
                } else {
                    String sdan = jmbg.substring(0, 2);
                    String smesec = jmbg.substring(2, 4);
                    String sgodina = jmbg.substring(4, 7);
                    String sostalo = jmbg.substring(7, 13);

                    try {
                        int dan = Integer.parseInt(sdan);
                        int mesec = Integer.parseInt(smesec);
                        int godina = Integer.parseInt(sgodina);
                        long ostalo = Long.parseLong(sostalo);

                        if (dan > 31 || mesec > 12 || godina < 900) {
                            throw new Exception("JMBG nije unet u ispravnom formatu!");
                        }
                    } catch (Exception e) {
                        throw new Exception("JMBG nije unet u ispravnom formatu!");
                    }
                }
            }

            Polaznik polaznik = new Polaznik();
            polaznik.setIme(ime);
            polaznik.setPrezime(prezime);
            polaznik.setJMBG(jmbg);

            ServerTransferObjekat sto = Kontroler.vratiInstancu().pretraziPolaznike(polaznik);

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
