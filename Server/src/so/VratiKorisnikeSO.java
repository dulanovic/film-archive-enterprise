package so;

import db.DatabaseBroker;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import java.util.List;

public class VratiKorisnikeSO extends OpstaSO {

    private List<OpstiDomenskiObjekat> lista;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        lista = DatabaseBroker.getInstance().vratiSveObjekte((Korisnik) obj);
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }

}
