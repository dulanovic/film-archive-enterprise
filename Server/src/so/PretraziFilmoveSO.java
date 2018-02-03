package so;

import db.DatabaseBroker;
import domen.Film;
import domen.OpstiDomenskiObjekat;
import java.util.List;

public class PretraziFilmoveSO extends OpstaSO {

    private List<OpstiDomenskiObjekat> lista;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {

    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        lista = DatabaseBroker.getInstance().pretraziObjekte((String) obj, new Film());
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }

}
