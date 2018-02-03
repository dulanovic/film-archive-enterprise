package so;

import db.DatabaseBroker;
import domen.Film;

public class KreirajNoviFilmSO extends OpstaSO {

    private int ID;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {

    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        ID = DatabaseBroker.getInstance().generisiID((Film) obj);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
