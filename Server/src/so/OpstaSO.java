package so;

import db.DatabaseBroker;

public abstract class OpstaSO {

    public final void izvrsenjeSO(Object obj) throws Exception {
        try {
            ucitajDriver();
            otvoriKonekciju();
            proveriPreduslov(obj);
            izvrsiKonkretnuOperaciju(obj);
            commitTransakcije();
        } catch (Exception ex) {
            rollbackTransakcije();
        } finally {
            zatvoriKonekciju();
        }

    }

    public void ucitajDriver() throws Exception {
        DatabaseBroker.getInstance().ucitajDriver();
    }

    public void otvoriKonekciju() throws Exception {
        DatabaseBroker.getInstance().otvoriKonekciju();
    }

    public void zatvoriKonekciju() throws Exception {
        DatabaseBroker.getInstance().zatvoriKonekciju();
    }

    public void commitTransakcije() throws Exception {
        DatabaseBroker.getInstance().commitTransakcije();
    }

    public void rollbackTransakcije() throws Exception {
        DatabaseBroker.getInstance().rollbackTransakcije();
    }

    protected abstract void proveriPreduslov(Object obj) throws Exception;

    protected abstract void izvrsiKonkretnuOperaciju(Object obj) throws Exception;
}
