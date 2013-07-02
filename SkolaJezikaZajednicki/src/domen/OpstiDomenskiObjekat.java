/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Dasa
 */
public interface OpstiDomenskiObjekat {
    
    String vratiImeTabele();
    
    String vratiKoloneZaInsert();
    
    String vratiVrednostZaInsert();
    
    List<OpstiDomenskiObjekat> vratiListuIzResultSeta(ResultSet rs);
    
    String vratiVrednostZaWhere();
    
    String vratiVrednostiZaUpdate();
    
    String vratiVrednostZaWhereZaPretragu();
    
}
