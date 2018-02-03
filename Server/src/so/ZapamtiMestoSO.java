package so;

import db.DatabaseBroker;
import domen.Mesto;

public class ZapamtiMestoSO extends OpstaSO {

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        DatabaseBroker.getInstance().sacuvaj((Mesto) obj);
    }
    
    
}
