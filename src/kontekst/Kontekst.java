/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontekst;

import domen.Kurs;
import domen.Nivo;
import domen.StraniJezik;
import domen.Zaposleni;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dasa
 */
public class Kontekst {
    
    private static List<Kurs> listaKurseva = new ArrayList<>();
    private static int kursID = 0;
    
    /*
    public static List<StraniJezik> dajListuStranihJezika(){
        List<StraniJezik> listaStranihJezika = new ArrayList<>();
        
        StraniJezik j1 = new StraniJezik(1, "Engleski jezik");
        StraniJezik j2 = new StraniJezik(2, "Nemacki jezik");
        StraniJezik j3 = new StraniJezik(3, "Spanski jezik");
        StraniJezik j4 = new StraniJezik(4, "Italijanski jezik");
        StraniJezik j5 = new StraniJezik(5, "Ruski jezik");
        StraniJezik j6 = new StraniJezik(6, "Norveski jezik");
        StraniJezik j7 = new StraniJezik(7, "Grcki jezik");
        StraniJezik j8 = new StraniJezik(8, "Poslovni engleski");
        StraniJezik j9 = new StraniJezik(9, "Poslovni nemacki");
                
        listaStranihJezika.add(j1);
        listaStranihJezika.add(j2);
        listaStranihJezika.add(j3);
        listaStranihJezika.add(j4);
        listaStranihJezika.add(j5);
        listaStranihJezika.add(j6);
        listaStranihJezika.add(j7);
        listaStranihJezika.add(j8);
        listaStranihJezika.add(j9);
        
        return listaStranihJezika;
    }
    
    public static List<Nivo> dajListuNivoa(){
        List<Nivo> listaNivoa = new ArrayList<>();
        
        Nivo n1 = new Nivo("A1", "Breakthrough or beginner");
        Nivo n2 = new Nivo("A2", "Waystage or elementary");
        Nivo n3 = new Nivo("B1", "Threshold or intermediate");
        Nivo n4 = new Nivo("B2", "Vantage or upper intermediate");
        Nivo n5 = new Nivo("C1", "Effective Operational Proficiency or advanced");
        Nivo n6 = new Nivo("C2", "Mastery or proficiency");
        
        listaNivoa.add(n1);
        listaNivoa.add(n2);
        listaNivoa.add(n3);
        listaNivoa.add(n4);
        listaNivoa.add(n5);
        listaNivoa.add(n6);
                
        return listaNivoa;
    }
    
    public static List<Zaposleni> dajListuNastavnika(){
        List<Zaposleni> listaNastavnika = new ArrayList<>();
        
        Zaposleni n1 = new Zaposleni();
        ((Zaposleni)n1).setIme("Marko");
        ((Zaposleni)n1).setPrezime("Petrovic");
        Zaposleni n2 = new Zaposleni();
        ((Zaposleni)n2).setIme("Dusan");
        ((Zaposleni)n2).setPrezime("Nikolic");
        
        listaNastavnika.add(n1);
        listaNastavnika.add(n2);
                
        return listaNastavnika;
    }
    */
    
    /*
    public static int dajIDZaKurs(){
        kursID = kursID + 1;
        return kursID;
    }
    
    public static void dodajKurs(Kurs k){
        listaKurseva.add(k);
    }
    
    public static void izbaciKurs(Kurs k){
        listaKurseva.remove(k);
    }
    
    public static List<Kurs> dajListuKurseva(){
        return listaKurseva;
    }
    
    public static Kurs pronadjiKurs(int id){
        for (Kurs kurs : listaKurseva) {
            if(kurs.getKursId()==id){
                return kurs;
            }
        }
        return null;
    }*/
}
