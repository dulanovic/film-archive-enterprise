package so;

import db.DatabaseBroker;
import domen.Korisnik;

public class KreirajNovogKorisnikaSO extends OpstaSO {

    private int ID;

    @Override
    protected void proveriPreduslov(Object obj) {

    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        ID = DatabaseBroker.getInstance().generisiID((Korisnik) obj);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
