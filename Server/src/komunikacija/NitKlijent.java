package komunikacija;

import domen.Arhivator;
import domen.Film;
import domen.Korisnik;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.Zaduzenje;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import poslovnalogika.Kontroler;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Konstante;
import util.Util;

public class NitKlijent extends Thread {

    private Socket socket;
    private boolean aktivna;

    public NitKlijent(Socket socket) {
        this.socket = socket;
        this.aktivna = true;
    }

    @Override
    public void run() {
        try {
            izvrsenjeOperacija();
        } catch (Exception ex) {
            ex.printStackTrace();
            aktivna = false;
        }
        System.out.println("Nit je regularno zavrsila rad.");
    }

    public void izvrsenjeOperacija() throws IOException, ClassNotFoundException {
        while (aktivna) {
            ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
            TransferObjekatZahtev toz = (TransferObjekatZahtev) inSocket.readObject();
            TransferObjekatOdgovor too = new TransferObjekatOdgovor();
            try {
                System.out.println("O: " + toz.getOperacija());
                Util.getInstance().povecajBrojPoziva();
                switch (toz.getOperacija()) {
                    case Konstante.KREIRAJ_KORISNIKA:
                        int korisnikID = Kontroler.getInstance().kreirajNovogKorisnika();
                        too.setRezultat(korisnikID);
                        too.setPoruka("ID uspešno izgenerisan");
                        break;
                    case Konstante.KREIRAJ_ZADUZENJE:
                        int zaduzenjeID = Kontroler.getInstance().kreirajNovoZaduzenje();
                        too.setRezultat(zaduzenjeID);
                        too.setPoruka("ID uspešno izgenerisan");
                        break;
                    case Konstante.KREIRAJ_FILM:
                        int filmID = Kontroler.getInstance().kreirajNoviFilm();
                        too.setRezultat(filmID);
                        too.setPoruka("ID uspešno izgenerisan");
                        break;
                    case Konstante.ZAPAMTI_KORISNIKA:
                        Korisnik k = (Korisnik) toz.getParametar();
                        Kontroler.getInstance().zapamtiKorisnika(k);
                        too.setPoruka("Korisnik je zapamćen u bazi.");
                        break;
                    case Konstante.ZAPAMTI_FILM:
                        Film f = (Film) toz.getParametar();
                        Kontroler.getInstance().zapamtiFilm(f);
                        too.setPoruka("Film je zapamćen u bazi.");
                        break;
                    case Konstante.ZAPAMTI_ZADUZENJE:
                        Zaduzenje z = (Zaduzenje) toz.getParametar();
                        Kontroler.getInstance().zapamtiZaduzenje(z);
                        too.setPoruka("Zaduženje je zapamćeno u bazi.");
                        break;
                    case Konstante.ZAPAMTI_ZADUZENJA:
                        List<Zaduzenje> listaZaduzenja = (List<Zaduzenje>) toz.getParametar();
                        Kontroler.getInstance().zapamtiZaduzenja(listaZaduzenja);
                        too.setPoruka("Zaduženja su zapamćena u bazi.");
                        break;
                    case Konstante.ZAPAMTI_MESTO:
                        Mesto m = (Mesto) toz.getParametar();
                        Kontroler.getInstance().zapamtiMesto(m);
                        too.setPoruka("Mesto je zapamćeno u bazi.");
                        break;
                    case Konstante.NADJI_ARHIVATORA:
                        Arhivator a = (Arhivator) toz.getParametar();
                        Arhivator a1 = Kontroler.getInstance().nadjiArhivatora(a);
                        a1.setVremeLogovanja(new Date());
                        Arhivator a2 = Util.getInstance().getArhivator();
                        if (a2 != null) {
                            if (a1.getArhivatorID() == a2.getArhivatorID()) {
                                too.setPoruka("Već ste ulogovani u sistem pod tim korisničkim imenom.");
                                break;
                            } else {
                                Util.getInstance().setArhivator(a1);
                                too.setRezultat(a1);
                                too.setPoruka("Arhivator je uspešno pronađen.");
                                break;
                            }
                        } else {
                            Util.getInstance().setArhivator(a1);
                            too.setRezultat(a1);
                            too.setPoruka("Arhivator je uspešno pronađen.");
                            break;
                        }
                    case Konstante.PRETRAZI_KORISNIKE:
                        String kriterijumPretrageKorisnik = (String) toz.getParametar();
                        List<OpstiDomenskiObjekat> listaKorisnikaPretraga = Kontroler.getInstance().pretraziKorisnike(kriterijumPretrageKorisnik);
                        too.setRezultat(listaKorisnikaPretraga);
                        too.setPoruka("Uspešna pretraga korisnika.");
                        break;
                    case Konstante.PRETRAZI_FILMOVE:
                        String kriterijumPretrageFilm = (String) toz.getParametar();
                        List<OpstiDomenskiObjekat> listaFilmovaPretraga = Kontroler.getInstance().pretraziFilmove(kriterijumPretrageFilm);
                        too.setRezultat(listaFilmovaPretraga);
                        too.setPoruka("Uspešna pretraga filmova.");
                        break;
                    case Konstante.PRETRAZI_MESTA:
                        String kriterijumPretrageMesto = (String) toz.getParametar();
                        List<OpstiDomenskiObjekat> listaMestaPretraga = Kontroler.getInstance().pretraziMesta(kriterijumPretrageMesto);
                        too.setRezultat(listaMestaPretraga);
                        too.setPoruka("Uspešna pretraga mesta.");
                        break;
                    case Konstante.PRETRAZI_ZADUZENJA:
                        String kriterijumPretrageZaduzenje = String.valueOf(toz.getParametar());
                        List<OpstiDomenskiObjekat> listaZaduzenjaPretraga = Kontroler.getInstance().pretraziZaduzenja(kriterijumPretrageZaduzenje);
                        too.setRezultat(listaZaduzenjaPretraga);
                        too.setPoruka("Uspešna pretraga zaduženja.");
                        break;
                    case Konstante.IZMENI_KORISNIKA:
                        Korisnik ko = (Korisnik) toz.getParametar();
                        Kontroler.getInstance().izmeniKorisnika(ko);
                        too.setPoruka("Podaci o korisniku su uspešno izmenjeni.");
                        break;
                    case Konstante.IZMENI_ZADUZENJE:
                        Zaduzenje za = (Zaduzenje) toz.getParametar();
                        Kontroler.getInstance().izmeniZaduzenje(za);
                        too.setPoruka("Podaci o zaduženju su uspešno izmenjeni.");
                        break;
                    case Konstante.VRATI_KORISNIKE:
                        List<OpstiDomenskiObjekat> listaKorisnika = Kontroler.getInstance().vratiKorisnike();
                        too.setRezultat(listaKorisnika);
                        too.setPoruka("Uspešno učitavanje korisnika iz baze.");
                        break;
                    case Konstante.VRATI_MESTA:
                        List<OpstiDomenskiObjekat> listaMesta = Kontroler.getInstance().vratiMesta();
                        too.setRezultat(listaMesta);
                        too.setPoruka("Uspešno učitavanje mesta iz baze.");
                        break;
                    case Konstante.VRATI_FILMOVE:
                        List<OpstiDomenskiObjekat> listaFilmova = Kontroler.getInstance().vratiFilmove();
                        too.setRezultat(listaFilmova);
                        too.setPoruka("Uspešno učitavanje filmova iz baze.");
                        break;
                    case Konstante.VRATI_ZANROVE:
                        List<OpstiDomenskiObjekat> listaZanrova = Kontroler.getInstance().vratiZanrove();
                        too.setRezultat(listaZanrova);
                        too.setPoruka("Uspešno učitavanje zanrova iz baze.");
                        break;
                    case Konstante.OBRISI_KORISNIKA:
                        Korisnik kor = (Korisnik) toz.getParametar();
                        Kontroler.getInstance().obrisiKorisnika(kor);
                        too.setPoruka("Korisnik uspešno obrisan.");
                        break;
                    case Konstante.IZLOGUJ_ARHIVATORA:
                        Util.getInstance().clearUtil();
                        break;
                    case Konstante.KRAJ_RADA:
                        Util.getInstance().clearUtil();
                        aktivna = false;
                        break;
                }
            } catch (Exception ex) {
                too.setIzuzetak(ex);
                too.setPoruka(ex.getMessage());
                ex.printStackTrace();
            }
            posaljiOdgovor(too);
        }
    }

    public void posaljiOdgovor(TransferObjekatOdgovor toOdgovor) throws IOException {
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(toOdgovor);
    }
}
