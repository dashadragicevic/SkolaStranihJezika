/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Kurs;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import konstante.Konstante;
import sesija.Sesija;
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
}
