/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Kurs;
import domen.Polaznik;
import domen.Ugovor;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import konstante.Konstante;
import transfer.KlijentTransferObjekat;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Dasa
 */
public class Kontroler {

    private static Kontroler instanca;
    private Socket socket;
    private ObjectInputStream inSocket;
    private ObjectOutputStream outSocket;

    public static Kontroler vratiInstancu() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ServerTransferObjekat dajSveJezike() throws Exception {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.DAJ_STRANE_JEZIKE);

        outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(kto);

        inSocket = new ObjectInputStream(socket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) inSocket.readObject();
        return sto;
    }

    public ServerTransferObjekat dajSveNivoe() throws Exception {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.DAJ_NIVOE);

        outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(kto);

        inSocket = new ObjectInputStream(socket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) inSocket.readObject();
        return sto;
    }

    public ServerTransferObjekat dajSveNastavnike() throws Exception {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.DAJ_ZAPOSLENE);

        outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(kto);

        inSocket = new ObjectInputStream(socket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) inSocket.readObject();
        return sto;
    }

    public ServerTransferObjekat noviKurs() throws Exception {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.KREIRAJ_NOVI_KURS);

        outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(kto);

        inSocket = new ObjectInputStream(socket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) inSocket.readObject();
        return sto;
    }

    public ServerTransferObjekat sacuvajKurs(Kurs kurs) throws Exception {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.ZAPAMTI_KURS);
        kto.setPodaci(kurs);

        outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(kto);

        inSocket = new ObjectInputStream(socket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) inSocket.readObject();
        return sto;
    }

    public ServerTransferObjekat pretraziKurseve(Kurs kurs) throws Exception {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.PRETRAZI_KURSEVE);
        kto.setPodaci(kurs);

        outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(kto);

        inSocket = new ObjectInputStream(socket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) inSocket.readObject();
        return sto;
    }
    
    public ServerTransferObjekat pronadjiKurs(Kurs kurs) throws Exception {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.PRONADJI_KURS);
        kto.setPodaci(kurs);

        outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(kto);

        inSocket = new ObjectInputStream(socket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) inSocket.readObject();
        return sto;
    }

    public ServerTransferObjekat obrisiKurs(Kurs kurs) throws Exception {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.OBRISI_KURS);
        kto.setPodaci(kurs);

        outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(kto);

        inSocket = new ObjectInputStream(socket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) inSocket.readObject();
        return sto;
    }
    
    public ServerTransferObjekat dajSvaMesta() throws Exception {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.DAJ_MESTA);

        outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(kto);

        inSocket = new ObjectInputStream(socket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) inSocket.readObject();
        return sto;
    }
    
    public ServerTransferObjekat noviPolaznik() throws Exception {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.KREIRAJ_NOVOG_POLAZNIKA);

        outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(kto);

        inSocket = new ObjectInputStream(socket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) inSocket.readObject();
        return sto;
    }
    
    public ServerTransferObjekat sacuvajPolaznika(Polaznik polaznik) throws Exception {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.ZAPAMTI_POLAZNIKA);
        kto.setPodaci(polaznik);

        outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(kto);

        inSocket = new ObjectInputStream(socket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) inSocket.readObject();
        return sto;
    }
    
    public ServerTransferObjekat pretraziPolaznike(Polaznik polaznik) throws Exception {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.PRETRAZI_POLAZNIKE);
        kto.setPodaci(polaznik);

        outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(kto);

        inSocket = new ObjectInputStream(socket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) inSocket.readObject();
        return sto;
    }

    public ServerTransferObjekat pronadjiPolaznika(Polaznik polaznik) throws Exception {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.PRONADJI_POLAZNIKA);
        kto.setPodaci(polaznik);

        outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(kto);

        inSocket = new ObjectInputStream(socket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) inSocket.readObject();
        return sto;
    }
    
    public ServerTransferObjekat noviUgovor(Ugovor ugovor) throws Exception {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.KREIRAJ_NOVI_UGOVOR);
        kto.setPodaci(ugovor);

        outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(kto);

        inSocket = new ObjectInputStream(socket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) inSocket.readObject();
        return sto;
    }

    public ServerTransferObjekat dajSveKurseve() throws Exception {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.DAJ_KURSEVE);

        outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(kto);

        inSocket = new ObjectInputStream(socket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) inSocket.readObject();
        return sto;
    }
    
    
}
