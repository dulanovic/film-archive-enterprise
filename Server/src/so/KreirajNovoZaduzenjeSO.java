package so;

import db.DatabaseBroker;
import domen.Zaduzenje;

public class KreirajNovoZaduzenjeSO extends OpstaSO {

    private int ID;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        ID = DatabaseBroker.getInstance().generisiID((Zaduzenje) obj);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
