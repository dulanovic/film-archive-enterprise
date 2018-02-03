package so;

import db.DatabaseBroker;
import domen.Arhivator;

public class NadjiArhivatoraSO extends OpstaSO {

    private Arhivator a;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {

    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        a = (Arhivator) DatabaseBroker.getInstance().vratiObjekat((Arhivator) obj);
    }

    public Arhivator getA() {
        return a;
    }

    public void setA(Arhivator a) {
        this.a = a;
    }

}
