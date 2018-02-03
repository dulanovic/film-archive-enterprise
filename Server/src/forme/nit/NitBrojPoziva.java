package forme.nit;

import javax.swing.JLabel;
import util.Util;

public class NitBrojPoziva extends Thread {

    private boolean aktivna;
    private JLabel jlblBrojPoziva;

    public NitBrojPoziva(JLabel jlblBrojPoziva) {
        this.aktivna = true;
        this.jlblBrojPoziva = jlblBrojPoziva;
    }

    @Override
    public void run() {
        while (aktivna) {
            try {
                jlblBrojPoziva.setText(String.valueOf(Util.getInstance().getBrojPoziva()));
                
                Thread.sleep(3000);
            } catch (InterruptedException iex) {
                iex.printStackTrace();
            }
        } 
    }

}
