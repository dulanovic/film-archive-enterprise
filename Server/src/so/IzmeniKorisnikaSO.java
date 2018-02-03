package so;

import db.DatabaseBroker;
import domen.Korisnik;

public class IzmeniKorisnikaSO extends OpstaSO {

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        DatabaseBroker.getInstance().izmeni((Korisnik) obj);
    }
    
    
}
