package so;

import db.DatabaseBroker;
import domen.Zaduzenje;
import java.util.List;

public class ZapamtiZaduzenjaSO extends OpstaSO {

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {

    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        List<Zaduzenje> lista = (List<Zaduzenje>) obj;
        for (Zaduzenje z : lista) {
            DatabaseBroker.getInstance().sacuvaj(z);
        }
    }

}
