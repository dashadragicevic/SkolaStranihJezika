/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.polaznik.ki;

import domen.Mesto;
import domen.Polaznik;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import kontroler.Kontroler;
import tabela.model.ModelTabeleUgovori;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Dasa
 */
public class KontrolorKISacuvajPolaznika {

    public static void sacuvajPolaznika(JLabel jlPolaznikID, JTextField jtxtIme, JLabel jlGreskaIme,
            JTextField jtxtPrezime, JLabel jlGreskaPrezime, JTextField jtxtJMBG, JLabel jlGreskaJMBG,
            JTextField jtxtBrojLK, JLabel jlGreskaBrojLK, JTextField jtxtUlica, JTextField jtxtBrojUlice,
            JLabel jlGreskaUlicaIBroj, JComboBox jcbbMesto, JLabel jlGreskaMesto, JTextField jtxtTelefon,
            JLabel jlGreskaTelefon, JTable jtblUgovori) {
        try {
            long polaznikID = Long.parseLong(jlPolaznikID.getText().trim());
            String ime = jtxtIme.getText().trim();
            String prezime = jtxtPrezime.getText().trim();
            String jmbg = jtxtJMBG.getText().trim();
            String brlk = jtxtBrojLK.getText().trim();
            String ulica = jtxtUlica.getText().trim();
            String broj = jtxtBrojUlice.getText().trim();
            Mesto m = (Mesto) jcbbMesto.getSelectedItem();
            String tel = jtxtTelefon.getText().trim();

            boolean izuzetak = false;

            if (ime.isEmpty()) {
                jlGreskaIme.setText("Ime je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                jlGreskaIme.setText("*");
            }
            if (prezime.isEmpty()) {
                jlGreskaPrezime.setText("Prezime je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                jlGreskaPrezime.setText("*");
            }
            if (jmbg.isEmpty()) {
                jlGreskaJMBG.setText("JMBG je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                if (jmbg.length() < 13 || jmbg.length() > 13) {
                    jlGreskaJMBG.setText("JMBG mora da ima 13 cifara!");
                    izuzetak = (true || izuzetak);
                } else {
                    try {
                        String sdan = jmbg.substring(0, 2);
                        String smesec = jmbg.substring(2, 4);
                        String sgodina = jmbg.substring(4, 7);
                        String sostalo = jmbg.substring(7, 13);

                        int dan = Integer.parseInt(sdan);
                        int mesec = Integer.parseInt(smesec);
                        int godina = Integer.parseInt(sgodina);
                        long ostalo = Long.parseLong(sostalo);

                        if (dan > 31 || mesec > 12 || godina < 900) {
                            jlGreskaJMBG.setText("JMBG nije unet u ispravnom formatu!");
                            izuzetak = (true || izuzetak);
                        } else {
                            jlGreskaJMBG.setText("*");
                        }
                    } catch (NumberFormatException e) {
                        jlGreskaJMBG.setText("U ovo polje mozete uneti samo brojeve!");
                        izuzetak = (true || izuzetak);
                    }
                }
            }
            if (brlk.isEmpty()) {
                jlGreskaBrojLK.setText("Broj LK je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                jlGreskaBrojLK.setText("*");
            }
            if (ulica.isEmpty()) {
                jlGreskaUlicaIBroj.setText("Ulica je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                jlGreskaUlicaIBroj.setText("*");
            }
            if (broj.isEmpty()) {
                jlGreskaUlicaIBroj.setText("Broj ulice je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                jlGreskaUlicaIBroj.setText("*");
            }
            if (m == null) {
                jlGreskaMesto.setText("Mesto je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                jlGreskaMesto.setText("*");
            }
            if (tel.isEmpty()) {
                jlGreskaTelefon.setText("Telefon je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                Pattern pattern = Pattern.compile("\\+381\\d{9}");
                Matcher matcher = pattern.matcher(tel);

                if (matcher.matches()) {
                    jlGreskaTelefon.setText("*");
                } else {
                    jlGreskaTelefon.setText("Ispravan format: +381XXXXXXXXX");
                    izuzetak = (true || izuzetak);
                }
            }

            if (izuzetak) {
                izuzetak = false;
                throw new Exception("Nisu ispravno uneti podaci!");
            }

            Polaznik p = new Polaznik();
            p.setPolaznikID(polaznikID);
            p.setIme(ime);
            p.setPrezime(prezime);
            p.setJMBG(jmbg);
            p.setBrojLicneKarte(brlk);
            p.setNazivUlice(ulica);
            p.setBrojUlice(broj);
            p.setMesto(m);
            p.setBrojTelefona(tel);

            Polaznik p1 = ((ModelTabeleUgovori)jtblUgovori.getModel()).vratiPolaznika();
            p.setUgovori(p1.getUgovori());
            
            ServerTransferObjekat sto = Kontroler.vratiInstancu().sacuvajPolaznika(p);

            if (sto.isSignal()) {
                JOptionPane.showMessageDialog(null, sto.getPoruka(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, sto.getPoruka(), "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
}
