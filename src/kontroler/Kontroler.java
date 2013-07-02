/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import baza.DBKomunikacija;
import domen.Kurs;
import domen.Mesto;
import domen.Nivo;
import domen.StraniJezik;
import domen.Zaposleni;
import java.util.List;

/**
 *
 * @author Dasa
 */
public class Kontroler {
    
    private DBKomunikacija db;
    private static Kontroler k;

    public Kontroler() {
        db = new DBKomunikacija();        
    }
    
    public static Kontroler vratiInstancu(){
        if(k==null){
            k = new Kontroler();
        }
        return k;
    }
    
    public Kurs kreirajNoviKurs() throws Exception{
        Kurs kurs = new Kurs();
        db.ucitajDriver();
        db.otvoriKonekciju();
        try {
            long kursID = db.rezervisiKursID();
            kurs.setKursID(kursID);
        } catch (Exception e) {
            throw e;
        }
        db.zatvoriKonekciju();        
        return kurs;
    }
    
    public void zapamtiKurs(Kurs k) throws Exception{
        db.ucitajDriver();
        db.otvoriKonekciju();
        try {
            db.zapamtiKurs(k);
            db.commitTransakcije();
        } catch (Exception e){
            db.rollbackTransakcije();
            throw e;
        }        
        db.zatvoriKonekciju();
    }
    
    public void obrisiKurs(Kurs kurs) throws Exception {
        db.ucitajDriver();
        db.otvoriKonekciju();
        try {
            db.obrisiKurs(kurs);
            db.commitTransakcije();
        } catch (Exception e) {
            db.rollbackTransakcije();
            throw e;
        }        
        db.zatvoriKonekciju();
    }
    
    public Kurs pronadjiKurs(Kurs kurs) throws Exception{
        db.ucitajDriver();
        db.otvoriKonekciju();
        Kurs kk = null;
        try {
            kk = db.pronadjiKurs(kurs);
        } catch (Exception e) {
            throw e;
        }
        db.zatvoriKonekciju();
        return kk;
    }
    
    public List<Kurs> pretraziKurseve(Kurs kurs) throws Exception{
        db.ucitajDriver();
        db.otvoriKonekciju();
        List<Kurs> lk = null;
        try {
            lk = db.pretraziKurseve(kurs);
        } catch (Exception e) {
            throw e;
        }
        db.zatvoriKonekciju();
        return lk;
    }
    
    //za CBBove:
    public List<Mesto> dajMesta() throws Exception{
        db.ucitajDriver();
        db.otvoriKonekciju();
        List<Mesto> lm = null;
        try {
            lm = db.vratiMesta();
        } catch (Exception e) {
            throw e;
        }        
        db.zatvoriKonekciju();
        return lm;
    }
    
    public List<StraniJezik> dajStraneJezike() throws Exception{
        db.ucitajDriver();
        db.otvoriKonekciju();
        List<StraniJezik> lm = null;
        try {
            lm = db.vratiJezike();
        } catch (Exception e) {
            throw e;
        }
        db.zatvoriKonekciju();
        return lm;
    }
    
    public List<Nivo> dajNivoe() throws Exception{
        db.ucitajDriver();
        db.otvoriKonekciju();
        List<Nivo> lm = null;
        try {
            lm = db.vratiNivoe();
        } catch (Exception e) {
            throw e;
        }
        db.zatvoriKonekciju();
        return lm;
    }
    
    public List<Zaposleni> dajZaposlene() throws Exception{
        db.ucitajDriver();
        db.otvoriKonekciju();
        List<Zaposleni> lm = null;
        try {
            lm = db.vratiZaposlene();
        } catch (Exception e) {
            throw e;
        }
        db.zatvoriKonekciju();
        return lm;
    }
    
    /*
    public long dajKursID(Kurs k) throws Exception{
        db.ucitajDriver();
        db.otvoriKonekciju();
        //long id = db.nadjiKursID(k);
        db.zatvoriKonekciju();
        return id;
    }
    
    public Kurs dajKurs(int id) throws Exception{
        db.ucitajDriver();
        db.otvoriKonekciju();
        //Kurs k = db.nadjiKurs(id);
        db.zatvoriKonekciju();
        return k;
    }
    */
    
    
    public List<Kurs> dajSveKurseve(){
        return null;        
    }
}
