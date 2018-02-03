package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Film implements OpstiDomenskiObjekat {

    private int filmID;
    private String naziv;
    private String reziser;
    private int trajanje;
    private Zanr zanr;

    public Film() {
        this.zanr = new Zanr();
    }

    public Film(int filmID, String naziv, String reziser, int trajanje, Zanr zanr) {
        this.filmID = filmID;
        this.naziv = naziv;
        this.reziser = reziser;
        this.trajanje = trajanje;
        this.zanr = zanr;
    }

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getReziser() {
        return reziser;
    }

    public void setReziser(String reziser) {
        this.reziser = reziser;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "Film";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return filmID + ",'" + naziv + "','" + reziser + "'," + trajanje + "," + zanr.getZanrID();
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lista = new ArrayList<>();
            while (rs.next()) {
                int rs_filmID = rs.getInt(1);
                String rs_naziv = rs.getString(2);
                String rs_reziser = rs.getString(3);
                int rs_trajanje = rs.getInt(4);
                int zanrID = rs.getInt(5);
                String nazivZ = rs.getString(6);

                Film f = new Film(rs_filmID, rs_naziv, rs_reziser, rs_trajanje, new Zanr(zanrID, nazivZ));
                lista.add(f);
            }
            return lista;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String vratiVrednostPrimarnogKljuca() {
        return "FilmID=" + filmID;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "NazivFilma=" + naziv + ",Reziser=" + reziser + ",Trajanje=" + trajanje + ",ZanrID=" + zanr.getZanrID();
    }

    @Override
    public String vratiUpitZaVratiSveObjekte() {
        return "SELECT f.*,z.nazivzanra FROM Film f INNER JOIN Zanr z ON (f.zanrid=z.zanrid)";
    }

    @Override
    public String vratiUslovZaPretragu(String kriterijumPretrage) {
        return "SELECT f.*,z.nazivzanra FROM Film f INNER JOIN Zanr z ON (f.zanrid=z.zanrid) WHERE nazivfilma LIKE '%" + kriterijumPretrage + "%' OR reziser LIKE '%" + kriterijumPretrage + "%'";
    }

    @Override
    public String vratiNazivKolonePrimarniKljuc() {
        return "FilmID";
    }

    @Override
    public String vratiUpitZaVratiObjekat() {
        return "";
    }

}
