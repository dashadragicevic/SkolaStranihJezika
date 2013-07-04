/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabela.model;

import domen.Polaznik;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dasa
 */
public class ModelTabelePolaznik extends AbstractTableModel {
    
    private List<Polaznik> lista;

    public ModelTabelePolaznik(List<Polaznik> lista) {
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
        Polaznik p = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0 : return p.getPolaznikID();
            case 1 : return p.getIme();
            case 2 : return p.getPrezime();
            case 3 : return p.getJMBG();
            default: return "Greska!";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "Polaznik ID";
            case 1 : return "Ime";
            case 2 : return "Prezime";
            case 3 : return "JMBG";
            default: return "Greska!";
        }
    }
}
