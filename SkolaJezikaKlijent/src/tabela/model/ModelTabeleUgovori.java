/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabela.model;

import domen.Kurs;
import domen.Polaznik;
import domen.Ugovor;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dasa
 */
public class ModelTabeleUgovori extends AbstractTableModel {

    private static Polaznik polaznik;

    public ModelTabeleUgovori(Polaznik polaznik) {
        this.polaznik = polaznik;
    }

    @Override
    public int getRowCount() {
        if (polaznik == null) {
            return 0;
        }
        if (polaznik.getUgovori() == null) {
            return 0;
        }
        return polaznik.getUgovori().size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        List<Ugovor> lista = polaznik.getUgovori();
        Ugovor u = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return u.getUgovorID();
            case 1:
                return u.getKurs();
            case 2:
                return u.getBrojRata();
            case 3:
                return u.getIznosRate();
            case 4:
                return u.getUkupnoPlacenoRata();
            case 5:
                return u.getUkupnoPlaceno();
            case 6:
                return u.getRokZaSlRatu();

            default:
                return "Greska!";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Kurs";
            case 2:
                return "Rate";
            case 3:
                return "Iznos rate";
            case 4:
                return "Placeno rata";
            case 5:
                return "Ukupno placeno";
            case 6:
                return "Rok za ratu";
            default:
                return "Greska!";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return false;
        }
        if (columnIndex == 3) {
            return false;
        }
        if (columnIndex == 5) {
            return false;
        }
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Ugovor u = polaznik.getUgovori().get(rowIndex);

        switch (columnIndex) {
            case 0:
                break;
            case 1:
                u.setKurs((Kurs)aValue);
                u.setBrojRata(1);
                u.setIznosRate(u.getKurs().getCena());
                break;
            case 2:
                u.setBrojRata(Integer.parseInt(aValue.toString()));
                u.setIznosRate(u.getKurs().getCena()/u.getBrojRata());
                u.setUkupnoPlaceno(u.getUkupnoPlacenoRata()*u.getIznosRate());
                break;
            case 3:
                break;
            case 4:
                u.setUkupnoPlacenoRata(Integer.parseInt(aValue.toString()));
                u.setUkupnoPlaceno(u.getUkupnoPlacenoRata()*u.getIznosRate());
                break;
            case 5:
                break;
            case 6:
                u.setRokZaSlRatu((Date)aValue);
                break;
        }
    }

    public Polaznik vratiPolaznika() {
        return polaznik;
    }

    public void dodajRed(Ugovor ugovor) {
        polaznik.getUgovori().add(ugovor);
        fireTableDataChanged();
    }

    public void obrisiRed(int id) {
        polaznik.getUgovori().remove(id);
        fireTableDataChanged();
    }

    public void setPolaznik(Polaznik polaznik) {
        this.polaznik = polaznik;
        fireTableDataChanged();
    }
    
}
