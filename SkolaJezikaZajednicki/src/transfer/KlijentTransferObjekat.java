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
public class KlijentTransferObjekat implements Serializable {
    
    private int operacija;
    private Object podaci;

    public int getOperacija() {
        return operacija;
    }

    public Object getPodaci() {
        return podaci;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }
       
}
