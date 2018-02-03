package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Arhivator implements OpstiDomenskiObjekat {

    private int arhivatorID;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String korisnickaSifra;

    public Arhivator(int arhivatorID, String ime, String prezime, String korisnickoIme, String korisnickaSifra) {
        this.arhivatorID = arhivatorID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.korisnickaSifra = korisnickaSifra;
    }

    public Arhivator(String korisnickoIme, String korisnickaSifra) {
        this.korisnickoIme = korisnickoIme;
        this.korisnickaSifra = korisnickaSifra;
    }

    public Arhivator() {
    }

    public int getArhivatorID() {
        return arhivatorID;
    }

    public void setArhivatorID(int arhivatorID) {
        this.arhivatorID = arhivatorID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getKorisnickaSifra() {
        return korisnickaSifra;
    }

    public void setKorisnickaSifra(String korisnickaSifra) {
        this.korisnickaSifra = korisnickaSifra;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiNazivTabele() {
        return "Arhivator";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return arhivatorID + ",'" + ime + "','" + prezime + "','" + korisnickoIme + "','" + korisnickaSifra + "'";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lista = new ArrayList<>();
            while (rs.next()) {
                int rs_arhivatorID = rs.getInt(1);
                String rs_ime = rs.getString(2);
                String rs_prezime = rs.getString(3);
                String rs_korisnickoIme = rs.getString(4);
                String rs_korisnickaSifra = rs.getString(5);

                Arhivator a = new Arhivator(rs_arhivatorID, rs_ime, rs_prezime, rs_korisnickoIme, rs_korisnickaSifra);
                lista.add(a);
            }
            return lista;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String vratiVrednostPrimarnogKljuca() {
        return "ArhivatorID=" + arhivatorID;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "Ime=" + ime + ",Prezime=" + prezime + ",KorisnickoIme=" + korisnickoIme + ",KorisnickaSifra=" + korisnickaSifra;
    }

    @Override
    public String vratiUpitZaVratiSveObjekte() {
        return "SELECT * FROM Arhivator";
    }

    @Override
    public String vratiUslovZaPretragu(String kriterijumPretrage) {
        return "SELECT * FROM Arhivator WHERE Ime LIKE '%" + kriterijumPretrage + "%' OR Prezime LIKE '%" + kriterijumPretrage + "%' LIMIT 1";
    }

    @Override
    public String vratiNazivKolonePrimarniKljuc() {
        return "ArhivatorID";
    }

    @Override
    public String vratiUpitZaVratiObjekat() {
        return "SELECT * FROM Arhivator WHERE korisnickoime='" + korisnickoIme + "' AND korisnickasifra='" + korisnickaSifra + "'";
    }

    private Date vremeLogovanja;

    public Date getVremeLogovanja() {
        return vremeLogovanja;
    }

    public void setVremeLogovanja(Date vremeLogovanja) {
        this.vremeLogovanja = vremeLogovanja;
    }

}
