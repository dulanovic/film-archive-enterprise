package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Korisnik implements OpstiDomenskiObjekat {

    private int korisnikID;
    private String naziv;
    private String kontaktOsoba;
    private int pib;
    private String email;
    private String website;
    private String adresa;
    private Mesto mesto;
    private List<Zaduzenje> listaZaduzenja;

    public Korisnik() {
        this.mesto = new Mesto();
        listaZaduzenja = new ArrayList<>();
    }

    public Korisnik(int korisnikID, String naziv, String kontaktOsoba, int pib, String email, String website, String adresa, Mesto mesto) {
        this.korisnikID = korisnikID;
        this.naziv = naziv;
        this.kontaktOsoba = kontaktOsoba;
        this.pib = pib;
        this.email = email;
        this.website = website;
        this.adresa = adresa;
        this.mesto = mesto;
        this.listaZaduzenja = new ArrayList<>();
    }

    public int getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(int korisnikID) {
        this.korisnikID = korisnikID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getKontaktOsoba() {
        return kontaktOsoba;
    }

    public void setKontaktOsoba(String kontaktOsoba) {
        this.kontaktOsoba = kontaktOsoba;
    }

    public int getPib() {
        return pib;
    }

    public void setPib(int pib) {
        this.pib = pib;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public List<Zaduzenje> getListaZaduzenja() {
        return listaZaduzenja;
    }

    public void setListaZaduzenja(List<Zaduzenje> listaZaduzenja) {
        this.listaZaduzenja = listaZaduzenja;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "Korisnik";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return korisnikID + ",'" + naziv + "','" + kontaktOsoba + "'," + pib + ",'" + email + "','" + website + "','" + adresa + "'," + mesto.getPtt();
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lista = new ArrayList<>();
            while (rs.next()) {
                int rs_korisnikID = rs.getInt(1);
                String rs_naziv = rs.getString(2);
                String rs_kontaktOsoba = rs.getString(3);
                int rs_pib = rs.getInt(4);
                String rs_email = rs.getString(5);
                String rs_website = rs.getString(6);
                String rs_adresa = rs.getString(7);
                int rs_ptt = rs.getInt(8);
                String rs_nazivM = rs.getString(9);

                Korisnik k = new Korisnik(rs_korisnikID, rs_naziv, rs_kontaktOsoba, rs_pib, rs_email, rs_website, rs_adresa, new Mesto(rs_ptt, rs_nazivM));
                lista.add(k);
            }
            return lista;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String vratiVrednostPrimarnogKljuca() {
        return "KorisnikID=" + korisnikID;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "NazivKorisnika='" + naziv + "',KontaktOsoba='" + kontaktOsoba + "',PIB=" + pib + ",EMail='" + email + "',WebSite='" + website + "',Adresa='" + adresa + "',Ptt=" + mesto.getPtt();
    }

    @Override
    public String vratiUpitZaVratiSveObjekte() {
        return "SELECT k.*,m.nazivmesta FROM Korisnik k INNER JOIN Mesto m ON (k.ptt=m.ptt)";
    }

    @Override
    public String vratiUslovZaPretragu(String kriterijumPretrage) {
        return "SELECT k.*,m.nazivmesta FROM Korisnik k INNER JOIN Mesto m ON (k.ptt=m.ptt) WHERE nazivkorisnika LIKE '%" + kriterijumPretrage + "%' OR kontaktosoba LIKE '%" + kriterijumPretrage + "%'";
    }

    @Override
    public String vratiNazivKolonePrimarniKljuc() {
        return "KorisnikID";
    }

    @Override
    public String vratiUpitZaVratiObjekat() {
        return "";
    }

}
