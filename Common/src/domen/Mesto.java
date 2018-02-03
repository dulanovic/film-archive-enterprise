package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Mesto implements OpstiDomenskiObjekat {

    private int ptt;
    private String naziv;

    public Mesto() {
    }

    public Mesto(int ptt, String naziv) {
        this.ptt = ptt;
        this.naziv = naziv;
    }

    public int getPtt() {
        return ptt;
    }

    public void setPtt(int ptt) {
        this.ptt = ptt;
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
        return "Mesto";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return ptt + ",'" + naziv + "'";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lista = new ArrayList<>();
            while (rs.next()) {
                int rs_ptt = rs.getInt(1);
                String rs_naziv = rs.getString(2);

                Mesto m = new Mesto(rs_ptt, rs_naziv);
                lista.add(m);
            }
            return lista;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String vratiVrednostPrimarnogKljuca() {
        return "Ptt=" + ptt;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "NazivMesta=" + naziv;
    }

    @Override
    public String vratiUpitZaVratiSveObjekte() {
        return "SELECT * FROM Mesto";
    }

    @Override
    public String vratiUslovZaPretragu(String kriterijumPretrage) {
        return "SELECT * FROM Mesto WHERE Ptt=" + kriterijumPretrage;
    }

    @Override
    public String vratiNazivKolonePrimarniKljuc() {
        return "Ptt";
    }

    @Override
    public String vratiUpitZaVratiObjekat() {
        return "";
    }

    @Override
    public boolean equals(Object o) {
        Mesto m = (Mesto) o;
        if (this.ptt == m.ptt) {
            return true;
        } else {
            return false;
        }
    }

}
