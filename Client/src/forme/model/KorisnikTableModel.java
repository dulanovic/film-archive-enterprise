package forme.model;

import domen.Korisnik;
import domen.Mesto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class KorisnikTableModel extends AbstractTableModel {

    private List<Korisnik> lista;
    private String[] kolone = new String[]{"Naziv", "Kontakt", "Mesto"};

    public KorisnikTableModel(List<Korisnik> lista) {
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
        Korisnik k = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getNaziv();
            case 1:
                return k.getKontaktOsoba();
            case 2:
                return k.getMesto().getNaziv();
            default:
                return "N/A";
        }
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {
        Korisnik k = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                k.setNaziv((String) o);
                break;
            case 1:
                k.setKontaktOsoba((String) o);
                break;
            case 2:
                k.setMesto((Mesto) o);
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

    public Korisnik vratiKorisnika(int red) {
        return lista.get(red);
    }

    public void obrisiRed(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }

    public List<Korisnik> vratiListu() {
        return lista;
    }
}
