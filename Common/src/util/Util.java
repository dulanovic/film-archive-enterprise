package util;

import domen.Arhivator;
import domen.Film;
import domen.Korisnik;
import domen.Zaduzenje;
import java.util.HashMap;
import java.util.Map;

public class Util {

    private Map<String, Korisnik> mapaKorisnika;
    private Map<String, Film> mapaFilmova;
    private Map<String, Zaduzenje> mapaZaduzenja;
    private Korisnik korisnik;
    private Arhivator arhivator;
    private int brojPoziva;
    private static Util instance;

    private Util() {
        mapaKorisnika = new HashMap<>();
        mapaFilmova = new HashMap<>();
        mapaZaduzenja = new HashMap<>();
        this.brojPoziva = 0;
    }

    public static Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }

    public Korisnik getKorisnik(String key) {
        return mapaKorisnika.get(key);
    }

    public void putKorisnik(String key, Korisnik value) {
        mapaKorisnika.put(key, value);
    }

    public void removeKorisnik(String key) {
        mapaKorisnika.remove(key);
    }

    public Film getFilm(String key) {
        return mapaFilmova.get(key);
    }

    public void putFilm(String key, Film value) {
        mapaFilmova.put(key, value);
    }

    public void removeFilm(String key) {
        mapaFilmova.remove(key);
    }

    public Zaduzenje getZaduzenje(String key) {
        return mapaZaduzenja.get(key);
    }

    public void putZaduzenje(String key, Zaduzenje value) {
        mapaZaduzenja.put(key, value);
    }

    public void removeZaduzenje(String key) {
        mapaZaduzenja.remove(key);
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Arhivator getArhivator() {
        return arhivator;
    }

    public void setArhivator(Arhivator arhivator) {
        this.arhivator = arhivator;
    }

    public void clearUtil() {
        mapaKorisnika.clear();
        mapaFilmova.clear();
        mapaZaduzenja.clear();
        this.korisnik = null;
        this.arhivator = null;
    }

    public int getBrojPoziva() {
        return brojPoziva;
    }

    public void povecajBrojPoziva() {
        this.brojPoziva++;
    }
}
