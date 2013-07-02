/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Kurs;
import domen.Mesto;
import domen.Nivo;
import domen.OpstiDomenskiObjekat;
import domen.StraniJezik;
import domen.Zaposleni;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Konstante;
import kontroler.Kontroler;
import transfer.KlijentTransferObjekat;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Dasa
 */
public class NitKlijent extends Thread {

    private Socket s;

    public NitKlijent(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream inSoket;
            ObjectOutputStream outSoket;
            while (true) {
                inSoket = new ObjectInputStream(s.getInputStream());
                try {
                    Object obj = inSoket.readObject();

                    KlijentTransferObjekat kto = (KlijentTransferObjekat) obj;
                    int operacija = kto.getOperacija();
                    ServerTransferObjekat sto = new ServerTransferObjekat();

                    switch (operacija) {
                        case Konstante.DAJ_MESTA:
                            try {
                                List<OpstiDomenskiObjekat> lista = Kontroler.vratiInstancu().dajMesta();
                                sto.setSignal(true);
                                sto.setPodaci(lista);
                            } catch (Exception e) {
                                sto.setSignal(false);
                                sto.setPoruka(e.getMessage());
                            }
                            break;
                        case Konstante.DAJ_STRANE_JEZIKE:
                            try {
                                List<OpstiDomenskiObjekat> lista = Kontroler.vratiInstancu().dajStraneJezike();
                                sto.setSignal(true);
                                sto.setPodaci(lista);
                            } catch (Exception e) {
                                sto.setSignal(false);
                                sto.setPoruka(e.getMessage());
                            }
                            break;
                        case Konstante.DAJ_NIVOE:
                            try {
                                List<OpstiDomenskiObjekat> lista = Kontroler.vratiInstancu().dajNivoe();
                                sto.setSignal(true);
                                sto.setPodaci(lista);
                            } catch (Exception e) {
                                sto.setSignal(false);
                                sto.setPoruka(e.getMessage());
                            }
                            break;
                        case Konstante.DAJ_ZAPOSLENE:
                            try {
                                List<OpstiDomenskiObjekat> lista = Kontroler.vratiInstancu().dajZaposlene();
                                sto.setSignal(true);
                                sto.setPodaci(lista);
                            } catch (Exception e) {
                                sto.setSignal(false);
                                sto.setPoruka(e.getMessage());
                            }
                            break;
                        case Konstante.KREIRAJ_NOVI_KURS:
                            try {
                                OpstiDomenskiObjekat kurs = Kontroler.vratiInstancu().kreirajNoviKurs();
                                sto.setSignal(true);
                                sto.setPodaci(kurs);
                                sto.setPoruka("Sistem je kreirao novi kurs!");
                            } catch (Exception e) {
                                sto.setSignal(false);
                                sto.setPoruka(e.getMessage());
                            }
                            break;
                        case Konstante.ZAPAMTI_KURS:
                            try {
                                OpstiDomenskiObjekat kurs = (Kurs) kto.getPodaci();
                                Kontroler.vratiInstancu().zapamtiKurs(kurs);
                                sto.setSignal(true);
                                sto.setPoruka("Sistem je zapamtio podatke o kursu!");
                            } catch (Exception e) {
                                sto.setSignal(false);
                                sto.setPoruka(e.getMessage());
                            }
                            break;
                        case Konstante.PRETRAZI_KURSEVE:
                            try {
                                OpstiDomenskiObjekat kurs = (Kurs) kto.getPodaci();
                                List<OpstiDomenskiObjekat> lista = Kontroler.vratiInstancu().pretraziKurseve(kurs);
                                sto.setSignal(true);
                                sto.setPodaci(lista);
                                sto.setPoruka("Sistem je pronasao kurseve po zadatoj vrednosti!");
                            } catch (Exception e) {
                                sto.setSignal(false);
                                sto.setPoruka(e.getMessage());
                            }
                            break;
                        case Konstante.PRONADJI_KURS:
                            try {
                                OpstiDomenskiObjekat k = (Kurs) kto.getPodaci();
                                OpstiDomenskiObjekat kurs = Kontroler.vratiInstancu().pronadjiKurs(k);
                                sto.setSignal(true);
                                sto.setPodaci(kurs);
                                sto.setPoruka("Sistem je pronasao podatke o kursu!");
                            } catch (Exception e) {
                                sto.setSignal(false);
                                sto.setPoruka(e.getMessage());
                            }
                            break;
                        case Konstante.OBRISI_KURS:
                            try {
                                OpstiDomenskiObjekat kurs = (Kurs) kto.getPodaci();
                                Kontroler.vratiInstancu().obrisiKurs(kurs);
                                sto.setSignal(true);
                                sto.setPoruka("Sistem je obrisao kurs!");
                            } catch (Exception e) {
                                sto.setSignal(false);
                                sto.setPoruka(e.getMessage());
                            }
                            break;



                    }
                    outSoket = new ObjectOutputStream(s.getOutputStream());
                    outSoket.writeObject(sto);
                } catch (ClassNotFoundException ex) {
                    System.out.println("Greska: " + ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println("Greska: " + ex.getMessage());
        }
    }
}
