package so;

import db.DatabaseBroker;
import domen.Zaduzenje;

public class IzmeniZaduzenjeSO extends OpstaSO {

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        DatabaseBroker.getInstance().izmeni((Zaduzenje) obj);
    }
    
}
