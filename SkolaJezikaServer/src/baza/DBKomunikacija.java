/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.OpstiDomenskiObjekat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Dasa
 */
public class DBKomunikacija {

    private Connection konekcija;
    private static DBKomunikacija objekat;

    public static DBKomunikacija vratiObjekat() throws FileNotFoundException, IOException {
        if (objekat == null) {
            objekat = new DBKomunikacija();
        }
        return objekat;
    }

    public void ucitajDriver() throws ClassNotFoundException {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    }

    public void otvoriKonekciju() throws SQLException {
        konekcija = DriverManager.getConnection("jdbc:odbc:Skola");
        konekcija.setAutoCommit(false);
    }

    public void zatvoriKonekciju() throws SQLException {
        konekcija.close();
    }

    public void commitTransakcije() throws Exception {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            throw new Exception("Greska pri potvrdi transakcije!");
        }
    }

    public void rollbackTransakcije() throws Exception {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            throw new Exception("Greska pri ponistenju transakcije!");
        }
    }

    public long ubaciNovi(OpstiDomenskiObjekat odo) throws Exception {
        String sql = "INSERT INTO " + odo.vratiImeTabele() + " " + odo.vratiKoloneZaInsert() + " VALUES " + "(" + odo.vratiVrednostZaInsert() + ")";
        Statement sqlNaredba = konekcija.createStatement();
        sqlNaredba.executeUpdate(sql);
        sql = "SELECT MAX("+odo.vratiImeTabele()+"ID) as id FROM "+odo.vratiImeTabele();
        ResultSet rs = sqlNaredba.executeQuery(sql);
        long broj = 0;
        if (rs.next()) {
            broj = rs.getLong("id");
        }
        sqlNaredba.close();
        return broj;
    }

    public void sacuvajIzmene(OpstiDomenskiObjekat odo) throws Exception {
        String sql = "UPDATE " + odo.vratiImeTabele() + " SET " + odo.vratiVrednostiZaUpdate() + " WHERE " + odo.vratiVrednostZaWhere() + "";
        Statement sqlNaredba = konekcija.createStatement();
        sqlNaredba.executeUpdate(sql);
        sqlNaredba.close();
    }

    public List<OpstiDomenskiObjekat> vratiSveObjekte(OpstiDomenskiObjekat odo) throws Exception {
        String sql = "SELECT * FROM " + odo.vratiImeTabele();
        Statement sqlNaredba = konekcija.createStatement();
        ResultSet rs = sqlNaredba.executeQuery(sql);
        return odo.vratiListuIzResultSeta(rs);
    }

    public OpstiDomenskiObjekat vratiObjektePoIDu(OpstiDomenskiObjekat odo) throws Exception {
        String sql = "SELECT * FROM " + odo.vratiImeTabele() + " WHERE " + odo.vratiVrednostZaWhere();
        Statement sqlNaredba = konekcija.createStatement();
        ResultSet rs = sqlNaredba.executeQuery(sql);
        return odo.vratiListuIzResultSeta(rs).get(0);
    }

    public List<OpstiDomenskiObjekat> vratiObjektePretraga(OpstiDomenskiObjekat odo) throws Exception {
        String sql = "SELECT * FROM " + odo.vratiImeTabele() + " WHERE " + odo.vratiVrednostZaWhereZaPretragu();
        Statement sqlNaredba = konekcija.createStatement();
        ResultSet rs = sqlNaredba.executeQuery(sql);
        return odo.vratiListuIzResultSeta(rs);
    }

    public void obrisiObjekat(OpstiDomenskiObjekat odo) throws Exception {
        String sql = "DELETE FROM " + odo.vratiImeTabele() + " WHERE " + odo.vratiVrednostZaDelete();
        Statement sqlNaredba = konekcija.createStatement();
        sqlNaredba.executeUpdate(sql);
        sqlNaredba.close();
    }

}