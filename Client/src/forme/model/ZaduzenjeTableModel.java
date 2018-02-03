package forme.model;

import domen.Film;
import domen.Zaduzenje;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ZaduzenjeTableModel extends AbstractTableModel {

    private List<Zaduzenje> lista;
    private String[] kolone = new String[]{"Datum zad.", "Datum razd.", "Status", "Uplata", "Film"};
    private DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

    public ZaduzenjeTableModel(List<Zaduzenje> lista) {
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
                if (z.getDatumZaduzenja() instanceof Date) {
                    return df.format(z.getDatumZaduzenja());
                } else {
                    return "";
                }
            case 1:
                if (z.getDatumRazduzenja() instanceof Date) {
                    return df.format(z.getDatumRazduzenja());
                } else {
                    return "";
                }
            case 2:
                if (z.isVraceno()) {
                    return "razduženo";
                } else {
                    return "nije razduženo";
                }
            case 3:
                return z.getUplata();
            case 4:
                return z.getFilm().getNaziv();
            default:
                return "N/A";
        }
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {
        Zaduzenje z = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: {
                try {
                    z.setDatumZaduzenja(df.parse(String.valueOf(o)));
                } catch (ParseException pex) {
                    pex.printStackTrace();
                }
            }
            break;
            case 1:
                try {
                    z.setDatumRazduzenja(df.parse(String.valueOf(o)));
                } catch (ParseException pex) {
                    pex.printStackTrace();
                }
                break;
            case 2:
                z.setVraceno(Boolean.parseBoolean((String) o));
                break;
            case 3:
                z.setUplata(Double.parseDouble((String) o));
            case 4:
                z.setFilm((Film) o);
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

    public void obrisiRed(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }

    public List<Zaduzenje> vratiListu() {
        return lista;
    }
}
