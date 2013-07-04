/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent;

import forme.pocetna.FPocetna;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.Kontroler;

/**
 *
 * @author Dasa
 */
public class Klijent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 9876);
            Kontroler.vratiInstancu().setSocket(socket);
            
            FPocetna fPocetnaKurs = new FPocetna();
            fPocetnaKurs.setVisible(true);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
