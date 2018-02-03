package forme.model;

import domen.Arhivator;
import domen.Film;
import domen.Korisnik;
import domen.Zaduzenje;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ZaduzenjeNovoTableModel extends AbstractTableModel {
    
    private List<Zaduzenje> lista;
    private String[] kolone = new String[]{"Korisnik", "Datum zad.", "Film", "Zadužio"};
    private DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
    
    public ZaduzenjeNovoTableModel(List<Zaduzenje> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        if (lista == null) {
            return 0;
        }
        return lista.size();
    }
    
    @Override
    public int getColumnCount() {
        return kolone.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zaduzenje z = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return z.getKorisnik();
            case 1:
                if (z.getDatumZaduzenja() instanceof Date) {
                    return df.format(z.getDatumZaduzenja());
                } else {
                    return "";
                }
            case 2:
                return z.getFilm();
            case 3:
                return z.getArhivatorZaduzio();
            default:
                return "N/A";
        }
    }
    
    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {
        Zaduzenje z = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                z.setKorisnik((Korisnik) o);
                break;
            case 1: {
                try {
                    z.setDatumZaduzenja(df.parse((String) o));
                } catch (ParseException pex) {
                    pex.printStackTrace();
                }
                break;
            }
            case 2:
                z.setFilm((Film) o);
                break;
            case 3:
                z.setArhivatorZaduzio((Arhivator) o);
                break;
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }
    
    public Zaduzenje vratiZaduzenje(int red) {
        return lista.get(red);
    }
    
    public void dodajRed(Zaduzenje z) {
        lista.add(z);
        fireTableDataChanged();
    }
    
    public void obrisiRed(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }
    
    public List<Zaduzenje> vratiListu() {
        return lista;
    }
    
    public void obrisiListu() {
        lista.clear();
        fireTableDataChanged();
    }
}
