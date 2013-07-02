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
        sql = "SELECT MAX(KursID) as id FROM Kurs";
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
        System.out.println(sql);
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

    public List<OpstiDomenskiObjekat> vratiObjektePoKriterijumu(OpstiDomenskiObjekat odo) throws Exception {
        String sql = "SELECT * FROM " + odo.vratiImeTabele() + " WHERE " + odo.vratiVrednostZaWhere();
        Statement sqlNaredba = konekcija.createStatement();
        ResultSet rs = sqlNaredba.executeQuery(sql);
        return odo.vratiListuIzResultSeta(rs);
    }

    public List<OpstiDomenskiObjekat> vratiObjektePretraga(OpstiDomenskiObjekat odo) throws Exception {
        String sql = "SELECT * FROM " + odo.vratiImeTabele() + " WHERE " + odo.vratiVrednostZaWhereZaPretragu();
        Statement sqlNaredba = konekcija.createStatement();
        ResultSet rs = sqlNaredba.executeQuery(sql);
        return odo.vratiListuIzResultSeta(rs);
    }

    public void obrisiObjekat(OpstiDomenskiObjekat odo) throws Exception {
        String sql = "DELETE FROM " + odo.vratiImeTabele() + " WHERE " + odo.vratiVrednostZaWhere();
        Statement sqlNaredba = konekcija.createStatement();
        sqlNaredba.executeUpdate(sql);
        sqlNaredba.close();
    }
    //negenericke
//    public long rezervisiKursID() throws Exception {
//        long id = 1;
//        try {
//            String sql = "SELECT TOP 1 KursID FROM Kurs ORDER BY KursID DESC";
//            Statement s = konekcija.createStatement();
//            ResultSet rs = s.executeQuery(sql);
//            if (rs.next()) {
//                id = rs.getLong("KursID") + 1;
//            }
//            rs.close();
//            s.close();
//        } catch (SQLException ex) {
//            throw new Exception("Sistem ne moze da kreira novi kurs!");
//        }
//        return id;
//    }
/*
     public void zapamtiKurs(Kurs kurs) throws Exception {
     try {
     String pronadjiSql = "SELECT KursID FROM Kurs WHERE KursID=" + kurs.getKursID();
     Statement s = konekcija.createStatement();
     ResultSet rs = s.executeQuery(pronadjiSql);
     if (rs.next()) {
     String sql = "UPDATE Kurs SET FondCasova=?, Cena=?, DatumOd=?, DatumDo=?, Termin1=?, Termin2=?, NazivUdzbenika=?, JezikID=?, NivoID=?, ZaposleniID=? WHERE KursID=?";
     PreparedStatement ps = konekcija.prepareStatement(sql);
     ps.setInt(1, kurs.getFondCasova());
     ps.setDouble(2, kurs.getCena());
     ps.setDate(3, new Date(kurs.getDatumOd().getTime()));
     ps.setDate(4, new Date(kurs.getDatumDo().getTime()));
     ps.setString(5, kurs.getTermin1());
     ps.setString(6, kurs.getTermin2());
     ps.setString(7, kurs.getNazivUdzbenika());
     ps.setBigDecimal(8, new BigDecimal(kurs.getJezik().getJezikID()));
     ps.setBigDecimal(9, new BigDecimal(kurs.getNivo().getNivoID()));
     ps.setBigDecimal(10, new BigDecimal(kurs.getNastavnik().getZaposleniID()));
     ps.setBigDecimal(11, new BigDecimal(kurs.getKursID()));
     ps.executeUpdate();
     ps.close();
     } else {
     String sql = "INSERT INTO Kurs VALUES (?,?,?,?,?,?,?,?,?,?,?)";
     PreparedStatement ps = konekcija.prepareStatement(sql);
     ps.setBigDecimal(1, new BigDecimal(kurs.getKursID()));
     ps.setInt(2, kurs.getFondCasova());
     ps.setDouble(3, kurs.getCena());
     ps.setDate(4, new Date(kurs.getDatumOd().getTime()));
     ps.setDate(5, new Date(kurs.getDatumDo().getTime()));
     ps.setString(6, kurs.getTermin1());
     ps.setString(7, kurs.getTermin2());
     ps.setString(8, kurs.getNazivUdzbenika());
     ps.setBigDecimal(9, new BigDecimal(kurs.getJezik().getJezikID()));
     ps.setBigDecimal(10, new BigDecimal(kurs.getNivo().getNivoID()));
     ps.setBigDecimal(11, new BigDecimal(kurs.getNastavnik().getZaposleniID()));
     ps.executeUpdate();
     ps.close();
     }
     rs.close();
     s.close();
     } catch (Exception e) {
     throw new Exception("Sistem ne moze da zapamti podatke o kursu!");
     }
     }
    
     public void obrisiKurs(Kurs kurs) throws Exception {
     try {
     String sql = "DELETE FROM Kurs WHERE KursID=" + kurs.getKursID();
     Statement s = konekcija.createStatement();
     s.executeUpdate(sql);
     s.close();
     } catch (Exception ex) {
     throw new Exception("Sistem ne moze da obrise kurs!");
     }
     }
   
     public Kurs pronadjiKurs(Kurs kurs) throws Exception {
     Kurs k = new Kurs();
     try {
     String sql = "SELECT * FROM Kurs WHERE KursID=" + kurs.getKursID();
     Statement s = konekcija.createStatement();
     ResultSet rs = s.executeQuery(sql);
     if (rs.next()) {
     long kid = rs.getLong("KursID");
     int fond = rs.getInt("FondCasova");
     double cena = rs.getDouble("Cena");
     Date datod = rs.getDate("DatumOd");
     Date datdo = rs.getDate("DatumDo");
     String ter1 = rs.getString("Termin1");
     String ter2 = rs.getString("Termin2");
     String udz = rs.getString("NazivUdzbenika");
     long jezID = rs.getLong("JezikID");
     long nivID = rs.getLong("NivoID");
     long zapID = rs.getLong("ZaposleniID");

     k.setKursID(kid);
     k.setFondCasova(fond);
     //k.setCena(cena);
     k.setDatumOd(datod);
     k.setDatumDo(datdo);
     k.setTermin1(ter1);
     k.setTermin2(ter2);
     k.setNazivUdzbenika(udz);
     //StraniJezik sj = nadjiStraniJezik(jezID);
     //k.setJezik(sj);
     Nivo n = nadjiNivo(nivID);
     k.setNivo(n);
     Zaposleni z = nadjiZaposlenog(zapID);
     k.setNastavnik(z);
     }
     rs.close();
     s.close();
     } catch (Exception e) {
     throw new Exception("Sistem ne moze da pronadje podatke o kursu!");
     }
     return k;
     }
    
     public List<Kurs> pretraziKurseve(Kurs kurs) throws Exception {
     List<Kurs> lk = new ArrayList<>();
     try {
     String sql = "SELECT * FROM Kurs WHERE JezikID=" + kurs.getJezik().getJezikID() + " AND NivoID =" + kurs.getNivo().getNivoID();
     Statement s = konekcija.createStatement();
     ResultSet rs = s.executeQuery(sql);
     while (rs.next()) {
     long kid = rs.getLong("KursID");
     int fond = rs.getInt("FondCasova");
     double cena = rs.getDouble("Cena");
     Date datod = rs.getDate("DatumOd");
     Date datdo = rs.getDate("DatumDo");
     String ter1 = rs.getString("Termin1");
     String ter2 = rs.getString("Termin2");
     String udz = rs.getString("NazivUdzbenika");
     long jezID = rs.getLong("JezikID");
     long nivID = rs.getLong("NivoID");
     long zapID = rs.getLong("ZaposleniID");

     Kurs k = new Kurs();
     k.setKursID(kid);
     k.setFondCasova(fond);
     //k.setCena(cena);
     k.setDatumOd(datod);
     k.setDatumDo(datdo);
     k.setTermin1(ter1);
     k.setTermin2(ter2);
     k.setNazivUdzbenika(udz);
     //StraniJezik sj = nadjiStraniJezik(jezID);
     //k.setJezik(sj);
     Nivo n = nadjiNivo(nivID);
     k.setNivo(n);
     Zaposleni z = nadjiZaposlenog(zapID);
     k.setNastavnik(z);

     lk.add(k);
     }
     rs.close();
     s.close();
     } catch (Exception e) {
     throw new Exception("Sistem ne moze da nadje kurs po zadatoj vrednosti!");
     }
     return lk;
     }
 
     //za CBBove:
     public List<Mesto> vratiMesta() throws Exception {
     List<Mesto> lm = new ArrayList<>();
     try {
     String sql = "SELECT * FROM Mesto";
     Statement s = konekcija.createStatement();
     ResultSet mesta = s.executeQuery(sql);
     while (mesta.next()) {
     long ptt = mesta.getLong("PttBroj");
     String naziv = mesta.getString("NazivMesta");
     Mesto m = new Mesto(ptt, naziv);
     lm.add(m);
     }
     mesta.close();
     s.close();
     } catch (Exception e) {
     throw new Exception("Greska pri ucitavanju spiska mesta!");
     }
     return lm;
     }
    
     public List<Nivo> vratiNivoe() throws Exception {
     List<Nivo> ln = new ArrayList<>();
     try {
     String sql = "SELECT * FROM Nivo";
     Statement s = konekcija.createStatement();
     ResultSet nivoi = s.executeQuery(sql);
     while (nivoi.next()) {
     long nivoID = nivoi.getLong("NivoID");
     String oznaka = nivoi.getString("OznakaNivoa");
     String naziv = nivoi.getString("NazivNivoa");
     Nivo n = new Nivo(nivoID, oznaka, naziv);
     ln.add(n);
     }
     nivoi.close();
     s.close();
     } catch (Exception e) {
     throw new Exception("Greska pri ucitavanju spiska nivoa!");
     }
     return ln;
     }
   
     public List<StraniJezik> vratiJezike() throws Exception {
     List<StraniJezik> lj = new ArrayList<>();
     try {
     String sql = "SELECT * FROM Jezik";
     Statement s = konekcija.createStatement();
     ResultSet jezici = s.executeQuery(sql);
     while (jezici.next()) {
     long jezikID = jezici.getLong("JezikID");
     String naziv = jezici.getString("NazivJezika");
     StraniJezik sj = new StraniJezik(jezikID, naziv);
     lj.add(sj);
     }
     jezici.close();
     s.close();
     } catch (Exception e) {
     throw new Exception("Greska pri ucitavanju spiska jezika!");
     }
     return lj;
     }
   
     public List<Zaposleni> vratiZaposlene() throws Exception {
     List<Zaposleni> lz = new ArrayList<>();
     try {
     String sql = "SELECT * FROM Zaposleni";
     Statement s = konekcija.createStatement();
     ResultSet z = s.executeQuery(sql);
     while (z.next()) {
     long zapID = z.getLong("ZaposleniID");
     String ime = z.getString("Ime");
     String prezime = z.getString("Prezime");
     String JMBG = z.getString("JMBG");
     String brlk = z.getString("BrojLicneKarte");
     String brtel = z.getString("BrojTelefona");
     String brrk = z.getString("BrojRadneKnjizice");
     String brzr = z.getString("BrojZiroRacuna");
     String ul = z.getString("NazivUlice");
     String brul = z.getString("BrojUlice");
     long ptt = z.getLong("PttBroj");
     long jezikID = z.getLong("JezikID");

     Zaposleni zap = new Zaposleni();
     zap.setZaposleniID(zapID);
     zap.setIme(ime);
     zap.setPrezime(prezime);
     zap.setJMBG(JMBG);
     zap.setBrojLicneKarte(brlk);
     zap.setBrojTelefona(brtel);
     zap.setBrojRadneKnjizice(brrk);
     zap.setBrojZiroRacuna(brzr);
     zap.setNazivUlice(ul);
     zap.setBrojUlice(brul);
     Mesto m = nadjiMesto(ptt);
     zap.setMesto(m);
     StraniJezik sj = nadjiStraniJezik(jezikID);
     zap.setJezik(sj);

     lz.add(zap);
     }
     z.close();
     s.close();
     } catch (Exception e) {
     throw new Exception("Greska pri ucitavanju spiska zaposlenih!");
     }
     return lz;
     }
   
    //pronadji po spoljnom kjucu: 
  
     public Mesto nadjiMesto(long ptt) throws Exception {
     Mesto m = null;
     try {
     String sql = "SELECT * FROM Mesto WHERE PttBroj=" + ptt;
     Statement s = konekcija.createStatement();
     ResultSet rs = s.executeQuery(sql);
     if (rs.next()) {
     String naziv = rs.getString("NazivMesta");
     m = new Mesto(ptt, naziv);
     }
     rs.close();
     s.close();
     } catch (Exception e) {
     throw new Exception("Greska pri pronalasku mesta na osnovu PTTa!");
     }
     return m;
     }

     public Nivo nadjiNivo(long id) throws Exception {
     Nivo n = null;
     try {
     String sql = "SELECT * FROM Nivo WHERE NivoID=" + id;
     Statement s = konekcija.createStatement();
     ResultSet rs = s.executeQuery(sql);
     if (rs.next()) {
     String ozn = rs.getString("OznakaNivoa");
     String naz = rs.getString("NazivNivoa");

     n = new Nivo(id, ozn, naz);
     }
     rs.close();
     s.close();
     } catch (Exception e) {
     throw new Exception("Greska pri pronalasku nivoa na osnovu IDa!");
     }
     return n;
     }
    
     public StraniJezik nadjiStraniJezik(long id) throws Exception {
     StraniJezik sj = null;
     try {
     String sql = "SELECT * FROM Jezik WHERE JezikID=" + id;
     Statement s = konekcija.createStatement();
     ResultSet rs = s.executeQuery(sql);
     if (rs.next()) {
     String naziv = rs.getString("NazivJezika");
     sj = new StraniJezik(id, naziv);
     }
     rs.close();
     s.close();
     } catch (Exception e) {
     throw new Exception("Greska pri pronalasku stranog jezika na osnovu IDa!");
     }
     return sj;
     }
     
     public Zaposleni nadjiZaposlenog(long id) throws Exception {
     Zaposleni zap = new Zaposleni();
     try {
     String sql = "SELECT * FROM Zaposleni WHERE ZaposleniID=" + id;
     Statement s = konekcija.createStatement();
     ResultSet rs = s.executeQuery(sql);
     if (rs.next()) {
     String ime = rs.getString("Ime");
     String prezime = rs.getString("Prezime");
     String JMBG = rs.getString("JMBG");
     String brlk = rs.getString("BrojLicneKarte");
     String brtel = rs.getString("BrojTelefona");
     String brrk = rs.getString("BrojRadneKnjizice");
     String brzr = rs.getString("BrojZiroRacuna");
     String ul = rs.getString("NazivUlice");
     String brul = rs.getString("BrojUlice");
     long ptt = rs.getLong("PttBroj");
     long jezikID = rs.getLong("JezikID");

     zap.setZaposleniID(id);
     zap.setIme(ime);
     zap.setPrezime(prezime);
     zap.setJMBG(JMBG);
     zap.setBrojLicneKarte(brlk);
     zap.setBrojTelefona(brtel);
     zap.setBrojRadneKnjizice(brrk);
     zap.setBrojZiroRacuna(brzr);
     zap.setNazivUlice(ul);
     zap.setBrojUlice(brul);
     //Mesto m = nadjiMesto(ptt);
     //zap.setMesto(m);
     //StraniJezik sj = nadjiStraniJezik(jezikID);
     //zap.setJezik(sj);
     }
     rs.close();
     s.close();
     } catch (Exception e) {
     throw new Exception("Greska pri pronalasku zaposlenog na osnovu IDa!");
     }
     return zap;
     }
     }
     */
}