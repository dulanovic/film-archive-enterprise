package so;

import db.DatabaseBroker;
import domen.OpstiDomenskiObjekat;
import domen.Zaduzenje;
import java.util.List;

public class PretraziZaduzenjaSO extends OpstaSO {

    private List<OpstiDomenskiObjekat> lista;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {

    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        lista = DatabaseBroker.getInstance().pretraziObjekte((String) obj, new Zaduzenje());
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }

}
