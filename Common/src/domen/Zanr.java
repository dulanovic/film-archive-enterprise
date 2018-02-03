package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Zanr implements OpstiDomenskiObjekat {

    private int zanrID;
    private String naziv;

    public Zanr() {
    }

    public Zanr(int zanrID, String naziv) {
        this.zanrID = zanrID;
        this.naziv = naziv;
    }

    public int getZanrID() {
        return zanrID;
    }

    public void setZanrID(int zanrID) {
        this.zanrID = zanrID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "Zanr";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return zanrID + ",'" + naziv + "'";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lista = new ArrayList<>();
            while (rs.next()) {
                int rs_zanrID = rs.getInt(1);
                String rs_naziv = rs.getString(2);
                
                Zanr z = new Zanr(rs_zanrID, rs_naziv);
                lista.add(z);
            }
            return lista;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String vratiVrednostPrimarnogKljuca() {
        return "ZanrID=" + zanrID;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "NazivZanra=" + naziv;
    }

    @Override
    public String vratiUpitZaVratiSveObjekte() {
        return "SELECT * FROM Zanr";
    }

    @Override
    public String vratiUslovZaPretragu(String kriterijumPretrage) {
        return "SELECT * FROM Zanr WHERE NazivZanra LIKE '%" + kriterijumPretrage + "%'";
    }

    @Override
    public String vratiNazivKolonePrimarniKljuc() {
        return "ZanrID";
    }

    @Override
    public String vratiUpitZaVratiObjekat() {
        return "";
    }

}
