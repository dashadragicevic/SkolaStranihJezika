/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.kurs.ki;

import domen.Kurs;
import domen.Nivo;
import domen.StraniJezik;
import domen.Zaposleni;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import kontroler.Kontroler;
import org.jdesktop.swingx.JXDatePicker;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Dasa
 */
public class KontrolorKISacuvajKurs {

    public static void sacuvajKurs(JLabel jlKursID, JComboBox jcbStraniJezik, JLabel jlStraniJezikGreska, JComboBox jcbNivo,
            JLabel jlNivoGreska, JComboBox jcbNastavnik, JLabel jlNastavnikGreska, JTextField jtxtFondCasova, JLabel jlFondCasovaGreska,
            JComboBox jcbTermin1Dan, JLabel jlTermin1Greska, JSpinner jspnTermin1Cas, JSpinner jspnTermin1Min, JComboBox jcbTermin2Dan,
            JLabel jlTermin2Greska, JSpinner jspnTermin2Cas, JSpinner jspnTermin2Min, JXDatePicker jdpDatumPocetka, JLabel jlDatumPocetkaGreska,
            JXDatePicker jdpDatumZavrsetka, JLabel jlDatumZavrsetkaGreska, JTextField jtxtNazivUdzbenika, JLabel jlNazivUdzbenikaGreska,
            JTextField jtxtCenaKursa, JLabel jlCenaKursaGreska) {

        try {
            long kursID = Long.parseLong(jlKursID.getText().trim());
            StraniJezik straniJezik = (StraniJezik) jcbStraniJezik.getSelectedItem();
            Nivo nivo = (Nivo) jcbNivo.getSelectedItem();
            Zaposleni nastavnik = (Zaposleni) jcbNastavnik.getSelectedItem();
            String sFondCasova = (String) jtxtFondCasova.getText().trim();
            int fondCasova = 10;
            String t1dan = (String) jcbTermin1Dan.getSelectedItem();
            String t1cas = jspnTermin1Cas.getValue().toString();
            String t1min = jspnTermin1Min.getValue().toString();
            String t2dan = (String) jcbTermin2Dan.getSelectedItem();
            String t2cas = jspnTermin2Cas.getValue().toString();
            String t2min = jspnTermin2Min.getValue().toString();
            Date datumOd = jdpDatumPocetka.getDate();
            Date datumDo = jdpDatumZavrsetka.getDate();
            String nazivUdzbenika = jtxtNazivUdzbenika.getText().trim();
            String sCenaKursa = jtxtCenaKursa.getText().trim();
            long cenaKursa = 0;

            boolean izuzetak = false;
            
            if (straniJezik == null) {
                jlStraniJezikGreska.setText("Strani jezik je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                jlStraniJezikGreska.setText("*");
            }
            if (nivo == null) {
                jlNivoGreska.setText("Nivo je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                jlNivoGreska.setText("*");
            }
            if (nastavnik == null) {
                jlNastavnikGreska.setText("Nastavnik je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                jlNastavnikGreska.setText("*");
            }
            if (sFondCasova.isEmpty()) {
                jlFondCasovaGreska.setText("Fond casova je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                try {
                    fondCasova = Integer.parseInt(sFondCasova);
                    if (fondCasova <= 10) {
                        jlFondCasovaGreska.setText("Fond casova mora biti veci od 10!");
                        izuzetak = (true || izuzetak);
                    } else {
                        jlFondCasovaGreska.setText("*");
                    }
                } catch (NumberFormatException e) {
                    jlFondCasovaGreska.setText("U ovo polje mozete uneti samo brojeve!");
                    izuzetak = (true || izuzetak);
                }
            }
            if (t1dan.isEmpty()) {
                jlTermin1Greska.setText("Dan prvog termina je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                jlTermin1Greska.setText("*");
            }
            if (t1cas.isEmpty()) {
                jlTermin1Greska.setText("Vreme prvog termina je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                jlTermin1Greska.setText("*");
            }
            if (t1min.isEmpty()) {
                jlTermin1Greska.setText("Vreme prvog termina je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                jlTermin1Greska.setText("*");
            }
            if (t2dan.isEmpty()) {
                jlTermin2Greska.setText("Dan drugog termina je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                jlTermin2Greska.setText("*");
            }
            if (t2cas.isEmpty()) {
                jlTermin2Greska.setText("Vreme drugog termina je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                jlTermin2Greska.setText("*");
            }
            if (t2min.isEmpty()) {
                jlTermin2Greska.setText("Vreme drugog termina je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                jlTermin2Greska.setText("*");
            }
            if (datumOd == null) {
                jlDatumPocetkaGreska.setText("Datum pocetka je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                jlDatumPocetkaGreska.setText("*");
            }
            if (datumDo == null) {
                jlDatumZavrsetkaGreska.setText("Datum zavrsetka je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                jlDatumZavrsetkaGreska.setText("*");
            }
            if (nazivUdzbenika.isEmpty()) {
                jlNazivUdzbenikaGreska.setText("Naziv udzbenika je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                jlNazivUdzbenikaGreska.setText("*");
            }
            if (sCenaKursa.isEmpty()) {
                jlCenaKursaGreska.setText("Cena kursa je obavezno polje!");
                izuzetak = (true || izuzetak);
            } else {
                try {
                    cenaKursa = Long.parseLong(sCenaKursa);
                    if (cenaKursa < 0) {
                        jlCenaKursaGreska.setText("Cena kursa je mora biti veca od 0!");
                        izuzetak = (true || izuzetak);
                    } else {
                        jlCenaKursaGreska.setText("*");
                    }
                } catch (NumberFormatException e) {
                    jlCenaKursaGreska.setText("U ovo polje mozete uneti samo brojeve!");
                    izuzetak = (true || izuzetak);
                }
            }

            if (izuzetak) {
                izuzetak = false;
                throw new Exception("Nisu ispravno uneti podaci!");
            }

            Kurs k = new Kurs();
            k.setKursID(kursID);
            k.setFondCasova(fondCasova);
            k.setCena(cenaKursa);
            k.setDatumOd(datumOd);
            k.setDatumDo(datumDo);
            k.setTermin1(t1dan + " " + t1cas + ":" + t1min);
            k.setTermin2(t2dan + " " + t2cas + ":" + t2min);
            k.setNazivUdzbenika(nazivUdzbenika);
            k.setJezik(straniJezik);
            k.setNivo(nivo);
            k.setNastavnik(nastavnik);

            ServerTransferObjekat sto = Kontroler.vratiInstancu().sacuvajKurs(k);

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
