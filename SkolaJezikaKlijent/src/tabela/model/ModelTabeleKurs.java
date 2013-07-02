/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabela.model;

import domen.Kurs;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dasa
 */
public class ModelTabeleKurs extends AbstractTableModel {
    
    private List<Kurs> kursevi;

    public ModelTabeleKurs(List<Kurs> kursevi) {
        this.kursevi = kursevi;
    }
    
    @Override
    public int getRowCount() {
        if(kursevi==null){
            return 0;
        } else {
            return kursevi.size();
        }
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kurs k = kursevi.get(rowIndex);
        
        switch(columnIndex){
            case 0 : return k.getKursID();
            case 1 : return k.getTermin1();
            case 2 : return k.getTermin2();
            case 3 : return new SimpleDateFormat("dd.MM.yyyy.").format(k.getDatumOd());
            case 4 : return new SimpleDateFormat("dd.MM.yyyy.").format(k.getDatumDo());
            case 5 : return k.getFondCasova();
            case 6 : return k.getCena();
            case 7 : return k.getNazivUdzbenika();
            case 8 : return k.getNastavnik();
            default: return "Greska!";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "Kurs ID";
            case 1 : return "Termin 1";
            case 2 : return "Termin 2";
            case 3 : return "Datum od";
            case 4 : return "Datum do";
            case 5 : return "Fond";
            case 6 : return "Cena";
            case 7 : return "Udzbenik";
            case 8 : return "Nastavnik";
            default: return "Greska!";
        }
    }
    
}
