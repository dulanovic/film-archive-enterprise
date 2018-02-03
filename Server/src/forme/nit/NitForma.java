package forme.nit;

import domen.Arhivator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import util.Util;

public class NitForma extends Thread {

    private boolean aktivna;
    private JLabel jlblIspis;
    private JLabel jlblSat;
//    private JLabel jlblBrojPoziva;
    private DateFormat df = new SimpleDateFormat("HH:mm:ss");

    public NitForma(JLabel jlblIspis, JLabel jlblSat) {
        this.aktivna = true;
        this.jlblIspis = jlblIspis;
        this.jlblSat = jlblSat;
//        this.jlblBrojPoziva = jlblBrojPoziva;
    }

    @Override
    public void run() {
        while (aktivna) {
            try {
                Arhivator a = Util.getInstance().getArhivator();

                if (a != null) {
                    jlblIspis.setText(a + ", vreme logovanja: " + df.format(a.getVremeLogovanja()));
                } else {
                    jlblIspis.setText("Trenutno nijedan arhivator nije ulogovan na sistem.");
                }
                
//                jlblBrojPoziva.setText(String.valueOf(Util.getInstance().getBrojPoziva()));
                jlblSat.setText(df.format(new Date()));
                
                Thread.sleep(1000);
            } catch (InterruptedException iex) {
                iex.printStackTrace();
            }
        }
    }

}
