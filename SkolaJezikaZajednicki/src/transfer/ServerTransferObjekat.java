/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Dasa
 */
public class ServerTransferObjekat implements Serializable {
    
    private boolean signal;
    private Object poruka;
    private Object podaci;

    public boolean isSignal() {
        return signal;
    }

    public Object getPodaci() {
        return podaci;
    }

    public Object getPoruka() {
        return poruka;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }

    public void setPoruka(Object poruka) {
        this.poruka = poruka;
    }

    public void setSignal(boolean signal) {
        this.signal = signal;
    }
    
}
