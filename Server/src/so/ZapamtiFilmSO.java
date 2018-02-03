package so;

import db.DatabaseBroker;
import domen.Film;

public class ZapamtiFilmSO extends OpstaSO {

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        DatabaseBroker.getInstance().sacuvaj((Film) obj);
    }
    
}
