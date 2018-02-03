package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

public interface OpstiDomenskiObjekat extends Serializable {

    public String vratiNazivTabele();

    public String vratiVrednostiZaInsert();

    public String vratiVrednostiZaUpdate();

    public String vratiVrednostPrimarnogKljuca();

    public String vratiUpitZaVratiSveObjekte();
    
    public String vratiUslovZaPretragu(String kriterijumPretrage);
    
    public String vratiNazivKolonePrimarniKljuc();
    
    public String vratiUpitZaVratiObjekat();

    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception;
}
