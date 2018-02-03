package db;

import domen.OpstiDomenskiObjekat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import util.FileUtil;

public class DatabaseBroker {

    private Connection connection;
    private static DatabaseBroker instance;

    private DatabaseBroker() {
    }

    public static DatabaseBroker getInstance() {
        if (instance == null) {
            instance = new DatabaseBroker();
        }
        return instance;
    }

    public void ucitajDriver() throws Exception {
        try {
            Class.forName(FileUtil.getInstance().get("driver"));
        } catch (ClassNotFoundException cnfex) {
            throw new Exception("Neuspešno učitavanje drajvera!", cnfex);
        }
    }

    public void otvoriKonekciju() throws Exception {
        try {
            connection = DriverManager.getConnection(FileUtil.getInstance().get("url"), FileUtil.getInstance().get("user"), FileUtil.getInstance().get("password"));
            connection.setAutoCommit(false);
        } catch (SQLException sqlex) {
            throw new Exception("Neuspešno otvaranje konekcije!", sqlex);
        }
    }

    public void zatvoriKonekciju() throws Exception {
        try {
            connection.close();
        } catch (SQLException sqlex) {
            throw new Exception("Neuspešno zatvaranje konekcije!", sqlex);
        }
    }

    public void commitTransakcije() throws Exception {
        try {
            connection.commit();
        } catch (SQLException sqlex) {
            throw new Exception("Neuspešan commit transakcije!", sqlex);
        }
    }

    public void rollbackTransakcije() throws Exception {
        try {
            connection.rollback();
        } catch (SQLException sqlex) {
            throw new Exception("Neuspešan rollback transakcije!", sqlex);
        }
    }

    public void sacuvaj(OpstiDomenskiObjekat odo) throws Exception {
        try {
            String upit = "INSERT INTO " + odo.vratiNazivTabele() + " VALUES (" + odo.vratiVrednostiZaInsert() + ")";
            System.out.println(upit);
            Statement sql = connection.createStatement();
            sql.executeUpdate(upit);
            sql.close();
        } catch (SQLException sqlex) {
            throw new Exception("Neuspešno čuvanje objekta!", sqlex);
        }
    }

    public void obrisi(OpstiDomenskiObjekat odo) throws Exception {
        try {
            String upit = "DELETE FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiVrednostPrimarnogKljuca();
            System.out.println(upit);
            Statement sql = connection.createStatement();
            sql.executeUpdate(upit);
            sql.close();
        } catch (SQLException sqlex) {
            throw new Exception("Neuspešno brisanje objekta!", sqlex);
        }
    }

    public void izmeni(OpstiDomenskiObjekat odo) throws Exception {
        try {
            String upit = "UPDATE " + odo.vratiNazivTabele() + " SET " + odo.vratiVrednostiZaUpdate() + " WHERE " + odo.vratiVrednostPrimarnogKljuca();
            System.out.println(upit);
            Statement sql = connection.createStatement();
            sql.executeUpdate(upit);
            sql.close();
        } catch (SQLException sqlex) {
            throw new Exception("Neuspešna izmena objekta!", sqlex);
        }
    }

    public List<OpstiDomenskiObjekat> vratiSveObjekte(OpstiDomenskiObjekat odo) throws Exception {
        try {
            String upit = odo.vratiUpitZaVratiSveObjekte();
            System.out.println(upit);
            Statement sql = connection.createStatement();
            ResultSet rs = sql.executeQuery(upit);
            return odo.ucitaj(rs);
        } catch (SQLException sqlex) {
            throw new Exception("Neuspešna izmena objekta!", sqlex);
        }

    }

    public OpstiDomenskiObjekat vratiObjekat(OpstiDomenskiObjekat odo) throws Exception {
        try {
            String upit = odo.vratiUpitZaVratiObjekat();
            System.out.println(upit);
            Statement sql = connection.createStatement();
            ResultSet rs = sql.executeQuery(upit);
            return odo.ucitaj(rs).get(0);
        } catch (SQLException sqlex) {
            throw new Exception("Neuspešna pretraga arhivatora!", sqlex);
        }

    }

    public List<OpstiDomenskiObjekat> pretraziObjekte(String kriterijumPretrage, OpstiDomenskiObjekat odo) throws Exception {
        try {
            String upit = odo.vratiUslovZaPretragu(kriterijumPretrage);
            System.out.println(upit);
            Statement sql = connection.createStatement();
            ResultSet rs = sql.executeQuery(upit);
            return odo.ucitaj(rs);
        } catch (SQLException sqlex) {
            throw new Exception("Neuspešna pretraga objekata!", sqlex);
        }
    }

    public int generisiID(OpstiDomenskiObjekat odo) throws Exception {
        try {
            String upit = "SELECT MAX(ID) FROM " + odo.vratiNazivTabele().toLowerCase() + "_pk";
            System.out.println(upit);
            int ID = 0;
            Statement sql = connection.createStatement();
            ResultSet rs = sql.executeQuery(upit);
            while (rs.next()) {
                ID = rs.getInt(1);
            }
            ID++;
            
            String upit2 = "INSERT INTO " + odo.vratiNazivTabele() + "_pk VALUES (" + ID + ")";
            System.out.println(upit2);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(upit2);
            return ID;
        } catch (SQLException sqlex) {
            throw new Exception("Neuspešno generisanje primarnog ključa objekta!", sqlex);
        }
    }
}
