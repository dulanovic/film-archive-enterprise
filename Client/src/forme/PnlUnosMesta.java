package forme;

import domen.Mesto;
import java.awt.Color;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Konstante;

/**
 *
 * @author Korisnik
 */
public class PnlUnosMesta extends javax.swing.JPanel {

    /**
     * Creates new form PnlUnosMesta
     */
    public PnlUnosMesta() {
        initComponents();
        jbtnSacuvaj.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtxtPtt = new javax.swing.JTextField();
        jbtnProveri = new javax.swing.JButton();
        jtxtNaziv = new javax.swing.JTextField();
        jbtnSacuvaj = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Podaci o mestu"));

        jLabel2.setText("Naziv:");

        jLabel1.setText("Ptt:");

        jbtnProveri.setText("Proveri");
        jbtnProveri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnProveriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(jtxtPtt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnProveri))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtPtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnProveri))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jbtnSacuvaj.setText("Sačuvaj mesto");
        jbtnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jbtnSacuvaj))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnSacuvaj)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnProveriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnProveriActionPerformed
        try {
            if (!izvrsiValidacijuPtt()) {
                return;
            }

            String ptt = jtxtPtt.getText();
            TransferObjekatZahtev toz = new TransferObjekatZahtev();
            toz.setParametar(ptt);
            toz.setOperacija(Konstante.PRETRAZI_MESTA);
            Komunikacija.getInstance().posaljiZahtev(toz);
            TransferObjekatOdgovor too = Komunikacija.getInstance().primiOdgovor();
            List<Mesto> lista = (List<Mesto>) too.getRezultat();

            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(this, "U bazi podataka ne postoji mesto sa tim poštanskim brojem.", "Sistemska poruka", JOptionPane.INFORMATION_MESSAGE);
                jbtnSacuvaj.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "U bazi podataka postoji mesto sa tim poštanskim brojem: " + lista.get(0).getNaziv(), "Sistemska poruka", JOptionPane.ERROR_MESSAGE);
                jtxtPtt.setText("");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da izvrši proveru poštanskog broja.", "Sistemska poruka", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jbtnProveriActionPerformed

    private void jbtnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSacuvajActionPerformed
        try {
            if (!izvrsiValidacijuPtt()) {
                return;
            }
            if (!izvrsiValidacijuNaziv()) {
                return;
            }

            int ptt = Integer.parseInt(jtxtPtt.getText());
            String naziv = jtxtNaziv.getText();

            Mesto m = new Mesto(ptt, naziv);

            TransferObjekatZahtev toz = new TransferObjekatZahtev();
            toz.setParametar(m);
            toz.setOperacija(Konstante.ZAPAMTI_MESTO);
            Komunikacija.getInstance().posaljiZahtev(toz);
            TransferObjekatOdgovor too = Komunikacija.getInstance().primiOdgovor();

            JOptionPane.showMessageDialog(this, "Sistem je zapamtio novo mesto.", "Sistemska poruka", JOptionPane.INFORMATION_MESSAGE);
            jtxtPtt.setText("");
            jtxtNaziv.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti novo mesto.", "Sistemska poruka", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnSacuvajActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnProveri;
    private javax.swing.JButton jbtnSacuvaj;
    private javax.swing.JTextField jtxtNaziv;
    private javax.swing.JTextField jtxtPtt;
    // End of variables declaration//GEN-END:variables

    private boolean izvrsiValidacijuNaziv() {

        if (jtxtNaziv.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Niste uneli naziv mesta!", "Sistemska poruka", JOptionPane.ERROR_MESSAGE);
            jtxtNaziv.requestFocusInWindow();
            jtxtNaziv.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            return false;
        }

        return true;
    }

    private boolean izvrsiValidacijuPtt() {
        if (jtxtPtt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Niste uneli Ptt!", "Sistemska poruka", JOptionPane.ERROR_MESSAGE);
            jtxtPtt.requestFocusInWindow();
            jtxtPtt.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            return false;
        }

        try {
            int ptt = Integer.parseInt(jtxtPtt.getText());
        } catch (NumberFormatException nfex) {
            JOptionPane.showMessageDialog(this, "Niste uneli Ptt u korektnom formatu! Potrebno je da unesete broj.", "Sistemska poruka", JOptionPane.ERROR_MESSAGE);
            jtxtPtt.requestFocusInWindow();
            jtxtPtt.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            return false;
        }

        if (jtxtPtt.getText().length() != 5) {
            JOptionPane.showMessageDialog(this, "Niste uneli Ptt u korektnom formatu! Potrebno je da unesete broj od tačno 5 cifara.", "Sistemska poruka", JOptionPane.ERROR_MESSAGE);
            jtxtPtt.requestFocusInWindow();
            jtxtPtt.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            return false;
        }

        return true;
    }
}
