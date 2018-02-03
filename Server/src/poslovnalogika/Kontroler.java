package poslovnalogika;

import db.DatabaseBroker;
import domen.Arhivator;
import domen.Film;
import domen.Korisnik;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.Zaduzenje;
import domen.Zanr;
import java.util.List;
import so.IzmeniKorisnikaSO;
import so.IzmeniZaduzenjeSO;
import so.KreirajNoviFilmSO;
import so.KreirajNovoZaduzenjeSO;
import so.KreirajNovogKorisnikaSO;
import so.NadjiArhivatoraSO;
import so.ObrisiKorisnikaSO;
import so.OpstaSO;
import so.PretraziFilmoveSO;
import so.PretraziKorisnikeSO;
import so.PretraziMestaSO;
import so.PretraziZaduzenjaSO;
import so.VratiFilmoveSO;
import so.VratiKorisnikeSO;
import so.VratiMestaSO;
import so.VratiZanroveSO;
import so.ZapamtiFilmSO;
import so.ZapamtiKorisnikaSO;
import so.ZapamtiMestoSO;
import so.ZapamtiZaduzenjaSO;
import so.ZapamtiZaduzenjeSO;

public class Kontroler {

    private DatabaseBroker db;
    private static Kontroler instance;

    private Kontroler() {
        db = DatabaseBroker.getInstance();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public int kreirajNovogKorisnika() throws Exception {
        OpstaSO kreirajNovogKorisnikaSO = new KreirajNovogKorisnikaSO();
        kreirajNovogKorisnikaSO.izvrsenjeSO(new Korisnik());
        return ((KreirajNovogKorisnikaSO) kreirajNovogKorisnikaSO).getID();
    }

    public int kreirajNovoZaduzenje() throws Exception {
        OpstaSO kreirajNovoZaduzenjeSO = new KreirajNovoZaduzenjeSO();
        kreirajNovoZaduzenjeSO.izvrsenjeSO(new Zaduzenje());
        return ((KreirajNovoZaduzenjeSO) kreirajNovoZaduzenjeSO).getID();
    }

    public int kreirajNoviFilm() throws Exception {
        OpstaSO kreirajNoviFilmSO = new KreirajNoviFilmSO();
        kreirajNoviFilmSO.izvrsenjeSO(new Film());
        return ((KreirajNoviFilmSO) kreirajNoviFilmSO).getID();
    }

    public void zapamtiKorisnika(Korisnik k) throws Exception {
        OpstaSO zapamtiKorisnikaSO = new ZapamtiKorisnikaSO();
        zapamtiKorisnikaSO.izvrsenjeSO(k);
    }

    public void zapamtiFilm(Film f) throws Exception {
        OpstaSO zapamtiFilmSO = new ZapamtiFilmSO();
        zapamtiFilmSO.izvrsenjeSO(f);
    }

    public void zapamtiZaduzenje(Zaduzenje z) throws Exception {
        OpstaSO zapamtiZaduzenjeSO = new ZapamtiZaduzenjeSO();
        zapamtiZaduzenjeSO.izvrsenjeSO(z);
    }

    public void zapamtiZaduzenja(List<Zaduzenje> lista) throws Exception {
        OpstaSO zapamtiZaduzenjaSO = new ZapamtiZaduzenjaSO();
        zapamtiZaduzenjaSO.izvrsenjeSO(lista);
    }

    public void zapamtiMesto(Mesto m) throws Exception {
        OpstaSO zapamtiMestoSO = new ZapamtiMestoSO();
        zapamtiMestoSO.izvrsenjeSO(m);
    }

    public Arhivator nadjiArhivatora(Arhivator a) throws Exception {
        OpstaSO nadjiArhivatoraSO = new NadjiArhivatoraSO();
        nadjiArhivatoraSO.izvrsenjeSO(a);
        return ((NadjiArhivatoraSO) nadjiArhivatoraSO).getA();
    }

    public List<OpstiDomenskiObjekat> pretraziKorisnike(String kriterijumPretrage) throws Exception {
        OpstaSO pretraziKorisnikeSO = new PretraziKorisnikeSO();
        pretraziKorisnikeSO.izvrsenjeSO(kriterijumPretrage);
        return ((PretraziKorisnikeSO) pretraziKorisnikeSO).getLista();
    }

    public List<OpstiDomenskiObjekat> pretraziFilmove(String kriterijumPretrage) throws Exception {
        OpstaSO pretraziFilmoveSO = new PretraziFilmoveSO();
        pretraziFilmoveSO.izvrsenjeSO(kriterijumPretrage);
        return ((PretraziFilmoveSO) pretraziFilmoveSO).getLista();
    }

    public List<OpstiDomenskiObjekat> pretraziMesta(String kriterijumPretrage) throws Exception {
        OpstaSO pretraziMestaSO = new PretraziMestaSO();
        pretraziMestaSO.izvrsenjeSO(kriterijumPretrage);
        return ((PretraziMestaSO) pretraziMestaSO).getLista();
    }

    public List<OpstiDomenskiObjekat> pretraziZaduzenja(String kriterijumPretrage) throws Exception {
        OpstaSO pretraziZaduzenjaSO = new PretraziZaduzenjaSO();
        pretraziZaduzenjaSO.izvrsenjeSO(kriterijumPretrage);
        return ((PretraziZaduzenjaSO) pretraziZaduzenjaSO).getLista();
    }

    public void izmeniKorisnika(Korisnik k) throws Exception {
        OpstaSO izmeniKorisnikaSO = new IzmeniKorisnikaSO();
        izmeniKorisnikaSO.izvrsenjeSO(k);
    }

    public void izmeniZaduzenje(Zaduzenje z) throws Exception {
        OpstaSO izmeniZaduzenjeSO = new IzmeniZaduzenjeSO();
        izmeniZaduzenjeSO.izvrsenjeSO(z);
    }

    public List<OpstiDomenskiObjekat> vratiMesta() throws Exception {
        OpstaSO vratiMestaSO = new VratiMestaSO();
        vratiMestaSO.izvrsenjeSO(new Mesto());
        return ((VratiMestaSO) vratiMestaSO).getLista();
    }

    public List<OpstiDomenskiObjekat> vratiKorisnike() throws Exception {
        OpstaSO vratiKorisnikeSO = new VratiKorisnikeSO();
        vratiKorisnikeSO.izvrsenjeSO(new Korisnik());
        return ((VratiKorisnikeSO) vratiKorisnikeSO).getLista();
    }

    public List<OpstiDomenskiObjekat> vratiFilmove() throws Exception {
        OpstaSO vratiFilmoveSO = new VratiFilmoveSO();
        vratiFilmoveSO.izvrsenjeSO(new Film());
        return ((VratiFilmoveSO) vratiFilmoveSO).getLista();
    }

    public List<OpstiDomenskiObjekat> vratiZanrove() throws Exception {
        OpstaSO vratiZanroveSO = new VratiZanroveSO();
        vratiZanroveSO.izvrsenjeSO(new Zanr());
        return ((VratiZanroveSO) vratiZanroveSO).getLista();
    }

    public void obrisiKorisnika(Korisnik k) throws Exception {
        OpstaSO obrisiKorisnikaSO = new ObrisiKorisnikaSO();
        obrisiKorisnikaSO.izvrsenjeSO(k);
    }
}
