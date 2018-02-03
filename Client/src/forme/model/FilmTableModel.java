package forme.model;

import domen.Film;
import domen.Zanr;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class FilmTableModel extends AbstractTableModel {

    private List<Film> lista;
    private String[] kolone = new String[]{"Naziv", "Režiser", "[min]", "Žanr"};

    public FilmTableModel(List<Film> lista) {
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
        Film f = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return f.getNaziv();
            case 1:
                return f.getReziser();
            case 2:
                return f.getTrajanje();
            case 3:
                return f.getZanr().getNaziv();
            default:
                return "N/A";
        }
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {
        Film f = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                f.setNaziv((String) o);
                break;
            case 1:
                f.setReziser((String) o);
                break;
            case 2:
                f.setTrajanje(Integer.parseInt((String) o));
                break;
            case 3:
                f.setZanr((Zanr) o);
                break;
        }
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    public Film vratiFilm(int red) {
        return lista.get(red);
    }

    public void obrisiRed(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }

    public List<Film> vratiListu() {
        return lista;
    }

}
