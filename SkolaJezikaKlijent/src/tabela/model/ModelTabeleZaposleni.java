/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabela.model;

import domen.Polaznik;
import domen.Zaposleni;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dasa
 */
public class ModelTabeleZaposleni extends AbstractTableModel {
    
    private List<Zaposleni> lista;

    public ModelTabeleZaposleni(List<Zaposleni> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        if(lista==null){
            return 0;
        } else {
            return lista.size();
        }
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zaposleni z = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0 : return z.getZaposleniID();
            case 1 : return z.getIme();
            case 2 : return z.getPrezime();
            case 3 : return z.getJMBG();
            default: return "Greska!";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "Zaposleni ID";
            case 1 : return "Ime";
            case 2 : return "Prezime";
            case 3 : return "JMBG";
            default: return "Greska!";
        }
    }
}
