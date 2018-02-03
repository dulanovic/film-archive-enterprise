package domen;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Zaduzenje implements OpstiDomenskiObjekat {

    private Korisnik korisnik;
    private int zaduzenjeID;
    private Date datumZaduzenja;
    private Date datumRazduzenja;
    private boolean vraceno;
    private double uplata;
    private Film film;
    private Arhivator arhivatorZaduzio;
    private Arhivator arhivatorRazduzio;

    public Zaduzenje() {
        this.korisnik = new Korisnik();
        this.film = new Film();
        this.arhivatorZaduzio = new Arhivator();
        this.arhivatorRazduzio = new Arhivator();
    }

    public Zaduzenje(Korisnik korisnik, int zaduzenjeID, Date datumZaduzenja, Date datumRazduzenja, boolean vraceno, double uplata, Film film, Arhivator arhivatorZaduzio, Arhivator arhivatorRazduzio) {
        this.korisnik = korisnik;
        this.zaduzenjeID = zaduzenjeID;
        this.datumZaduzenja = datumZaduzenja;
        this.datumRazduzenja = datumRazduzenja;
        this.vraceno = vraceno;
        this.uplata = uplata;
        this.film = film;
        this.arhivatorZaduzio = arhivatorZaduzio;
        this.arhivatorRazduzio = arhivatorRazduzio;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public int getZaduzenjeID() {
        return zaduzenjeID;
    }

    public void setZaduzenjeID(int zaduzenjeID) {
        this.zaduzenjeID = zaduzenjeID;
    }

    public Date getDatumZaduzenja() {
        return datumZaduzenja;
    }

    public void setDatumZaduzenja(Date datumZaduzenja) {
        this.datumZaduzenja = datumZaduzenja;
    }

    public Date getDatumRazduzenja() {
        return datumRazduzenja;
    }

    public void setDatumRazduzenja(Date datumRazduzenja) {
        this.datumRazduzenja = datumRazduzenja;
    }

    public boolean isVraceno() {
        return vraceno;
    }

    public void setVraceno(boolean vraceno) {
        this.vraceno = vraceno;
    }

    public double getUplata() {
        return uplata;
    }

    public void setUplata(double uplata) {
        this.uplata = uplata;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Arhivator getArhivatorZaduzio() {
        return arhivatorZaduzio;
    }

    public void setArhivatorZaduzio(Arhivator arhivatorZaduzio) {
        this.arhivatorZaduzio = arhivatorZaduzio;
    }

    public Arhivator getArhivatorRazduzio() {
        return arhivatorRazduzio;
    }

    public void setArhivatorRazduzio(Arhivator arhivatorRazduzio) {
        this.arhivatorRazduzio = arhivatorRazduzio;
    }

    @Override
    public String vratiNazivTabele() {
        return "Zaduzenje";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return korisnik.getKorisnikID() + "," + zaduzenjeID + ",'" + df.format(datumZaduzenja) + "',NULL, FALSE," + uplata + "," + film.getFilmID() + "," + arhivatorZaduzio.getArhivatorID() + ",NULL";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lista = new ArrayList<>();
            while (rs.next()) {
                int rs_korisnikID = rs.getInt(10);
                String rs_naziv = rs.getString(11);
                String rs_kontaktOsoba = rs.getString(12);
                int rs_pib = rs.getInt(13);
                String rs_email = rs.getString(14);
                String rs_website = rs.getString(15);
                String rs_adresa = rs.getString(16);
                int rs_ptt = rs.getInt(17);
                String rs_nazivM = rs.getString(18);

                Korisnik k = new Korisnik(rs_korisnikID, rs_naziv, rs_kontaktOsoba, rs_pib, rs_email, rs_website, rs_adresa, new Mesto(rs_ptt, rs_nazivM));

                int rs_filmID = rs.getInt(19);
                String rs_nazivF = rs.getString(20);
                String rs_reziser = rs.getString(21);
                int rs_trajanje = rs.getInt(22);
                int zanrID = rs.getInt(23);
                String nazivZ = rs.getString(24);

                Film f = new Film(rs_filmID, rs_nazivF, rs_reziser, rs_trajanje, new Zanr(zanrID, nazivZ));

                int rs_arhivatorID1 = rs.getInt(25);
                String rs_ime1 = rs.getString(26);
                String rs_prezime1 = rs.getString(27);
                String rs_korisnickoIme1 = rs.getString(28);
                String rs_korisnickaSifra1 = rs.getString(29);

                Arhivator aZ = new Arhivator(rs_arhivatorID1, rs_ime1, rs_prezime1, rs_korisnickoIme1, rs_korisnickaSifra1);

                int rs_arhivatorID2 = rs.getInt(30);
                if (rs.wasNull()) {
                    rs_arhivatorID2 = 1000;
                }
                String rs_ime2 = rs.getString(31);
                String rs_prezime2 = rs.getString(32);
                String rs_korisnickoIme2 = rs.getString(33);
                String rs_korisnickaSifra2 = rs.getString(34);

                Arhivator aR = new Arhivator(rs_arhivatorID2, rs_ime2, rs_prezime2, rs_korisnickoIme2, rs_korisnickaSifra2);

                int rs_zaduzenjeID = rs.getInt(2);
                Date rs_datumZaduzenja = new Date(rs.getDate(3).getTime());
                Date rs_datumRazduzenja;
                try {
                    rs_datumRazduzenja = new Date(rs.getDate(4).getTime());
                } catch (Exception ex) {
                    rs_datumRazduzenja = null;
                }
                boolean rs_vraceno = rs.getBoolean(5);
                double rs_uplata = rs.getDouble(6);

                Zaduzenje z = new Zaduzenje(k, rs_zaduzenjeID, rs_datumZaduzenja, rs_datumRazduzenja, rs_vraceno, rs_uplata, f, aZ, aR);
                lista.add(z);
            }
            return lista;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String vratiVrednostPrimarnogKljuca() {
        return "KorisnikID=" + korisnik.getKorisnikID() + " AND ZaduzenjeID=" + zaduzenjeID;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return "DatumZaduzenja='" + df.format(datumZaduzenja) + "',DatumRazduzenja='" + df.format(datumRazduzenja) + "',Vraceno=" + vraceno + ",Uplata=" + uplata + ",FilmID=" + film.getFilmID() + ",Zaduzio=" + arhivatorZaduzio.getArhivatorID() + ",Razduzio=" + arhivatorRazduzio.getArhivatorID();
    }

    @Override
    public String vratiUpitZaVratiSveObjekte() {
        return "SELECT z.*,km.*,fz.*,az.*,ar.* FROM Zaduzenje z INNER JOIN (SELECT k.*,m.nazivmesta FROM Korisnik k INNER JOIN Mesto m ON (k.ptt=m.ptt)) AS km ON (z.korisnikid=km.korisnikid) INNER JOIN Arhivator az ON (z.zaduzio=az.arhivatorid) INNER JOIN Arhivator ar ON (z.razduzio=ar.arhivatorid) INNER JOIN (SELECT f.*,za.nazivzanra FROM Film f INNER JOIN Zanr za ON (f.zanrid=za.zanrid)) AS fz ON (z.filmid=fz.filmid)";
    }

    @Override
    public String vratiUslovZaPretragu(String kriterijumPretrage) {
        return "SELECT z.*,km.*,fz.*,az.*,ar.* FROM Zaduzenje z INNER JOIN (SELECT k.*,m.nazivmesta FROM Korisnik k INNER JOIN Mesto m ON (k.ptt=m.ptt)) AS km ON (z.korisnikid=km.korisnikid) LEFT OUTER JOIN Arhivator az ON (z.zaduzio=az.arhivatorid) LEFT OUTER JOIN Arhivator ar ON (z.razduzio=ar.arhivatorid) INNER JOIN (SELECT f.*,za.nazivzanra FROM Film f INNER JOIN Zanr za ON (f.zanrid=za.zanrid)) AS fz ON (z.filmid=fz.filmid) WHERE z.korisnikid=" + Integer.parseInt(kriterijumPretrage);
    }

    @Override
    public String vratiNazivKolonePrimarniKljuc() {
        return "ZaduzenjeID";
    }

    @Override
    public String vratiUpitZaVratiObjekat() {
        return "";
    }
}
