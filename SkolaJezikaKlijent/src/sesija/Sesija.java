/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesija;

import java.net.Socket;

/**
 *
 * @author Dasa
 */
public class Sesija {
    
    private static Sesija sesija;
    private Socket socket;

    public Sesija() {
    }

    public static Sesija dajObjekat(){   
        if (sesija==null)
            sesija = new Sesija();
        return sesija;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
}
