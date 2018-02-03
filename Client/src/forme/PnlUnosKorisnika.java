package forme;

import domen.Korisnik;
import domen.Mesto;
import domen.Zaduzenje;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import komunikacija.Komunikacija;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Konstante;
import util.Util;

public class PnlUnosKorisnika extends javax.swing.JPanel {

    /**
     * Creates new form JPUnosKorisnika
     */
    public PnlUnosKorisnika() {
        initComponents();
        srediFormu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlCeo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbtnKreirajKorisnika = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jcbMesto = new javax.swing.JComboBox<>();
        jtxtUlicaBroj = new javax.swing.JTextField();
        jbtnDodajMesto = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxtNaziv = new javax.swing.JTextField();
        jtxtWebsajt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtKontaktOsoba = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtxtPIB = new javax.swing.JTextField();
        jtxtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbtnSacuvajKorisnika = new javax.swing.JButton();
        jbtnIzmeni = new javax.swing.JButton();
        jtxtKorisnikID = new javax.swing.JTextField();

        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jpnlCeo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jpnlCeoFocusGained(evt);
            }
        });
        jpnlCeo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID korisnika:");
        jpnlCeo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 15, -1, -1));

        jbtnKreirajKorisnika.setText("Kreiraj korisnika");
        jbtnKreirajKorisnika.setFocusable(false);
        jbtnKreirajKorisnika.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnKreirajKorisnika.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnKreirajKorisnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnKreirajKorisnikaActionPerformed(evt);
            }
        });
        jpnlCeo.add(jbtnKreirajKorisnika, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 11, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Podaci"));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Adresa"));

        jtxtUlicaBroj.setEditable(false);

        jbtnDodajMesto.setText("Dodaj mesto");
        jbtnDodajMesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDodajMestoActionPerformed(evt);
            }
        });

        jLabel7.setText("Ulica i broj:");

        jLabel8.setText("Mesto:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxtUlicaBroj)
                    .addComponent(jcbMesto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtnDodajMesto)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtUlicaBroj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbMesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnDodajMesto)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jtxtNaziv.setEditable(false);

        jtxtWebsajt.setEditable(false);

        jLabel2.setText("Naziv:");

        jLabel3.setText("PIB:");

        jtxtKontaktOsoba.setEditable(false);

        jLabel6.setText("Web-sajt:");

        jtxtPIB.setEditable(false);

        jtxtEmail.setEditable(false);

        jLabel4.setText("Kontakt osoba:");

        jLabel5.setText("E-mail:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxtWebsajt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(71, 71, 71)
                        .addComponent(jtxtPIB))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(61, 61, 61)
                        .addComponent(jtxtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtKontaktOsoba, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtPIB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtKontaktOsoba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxtWebsajt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jpnlCeo.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 45, -1, -1));

        jbtnSacuvajKorisnika.setText("Sačuvaj korisnika");
        jbtnSacuvajKorisnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSacuvajKorisnikaActionPerformed(evt);
            }
        });
        jpnlCeo.add(jbtnSacuvajKorisnika, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jbtnIzmeni.setText("Izmeni");
        jbtnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIzmeniActionPerformed(evt);
            }
        });
        jpnlCeo.add(jbtnIzmeni, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, -1));

        jtxtKorisnikID.setEditable(false);
        jpnlCeo.add(jtxtKorisnikID, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 12, 124, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jpnlCeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jpnlCeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnKreirajKorisnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnKreirajKorisnikaActionPerformed
        try {
            TransferObjekatZahtev toz = new TransferObjekatZahtev();
            toz.setOperacija(Konstante.KREIRAJ_KORISNIKA);
            Komunikacija.getInstance().posaljiZahtev(toz);
            TransferObjekatOdgovor too = Komunikacija.getInstance().primiOdgovor();
            int id = (int) too.getRezultat();

            jtxtKorisnikID.setText(String.valueOf(id));
            jtxtEmail.setEditable(true);
            jtxtKontaktOsoba.setEditable(true);
            jtxtNaziv.setEditable(true);
            jtxtPIB.setEditable(true);
            jtxtUlicaBroj.setEditable(true);
            jtxtWebsajt.setEditable(true);

            JOptionPane.showMessageDialog(this, "Sistem je kreirao novog korisnika.", "Sistemska poruka", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da kreira novog korisnika.", "Sistemska poruka", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnKreirajKorisnikaActionPerformed

    private void jbtnSacuvajKorisnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSacuvajKorisnikaActionPerformed
        try {
            if (!izvrsiValidaciju()) {
                return;
            }

            int korisnikID = Integer.parseInt(jtxtKorisnikID.getText());
            String naziv = jtxtNaziv.getText();
            String kontaktOsoba = jtxtKontaktOsoba.getText();
            int pib = Integer.parseInt(jtxtPIB.getText());
            String email = jtxtEmail.getText();
            String website = jtxtWebsajt.getText();
            String adresa = jtxtUlicaBroj.getText();
            Mesto m = (Mesto) jcbMesto.getSelectedItem();
            Korisnik k = new Korisnik(korisnikID, naziv, kontaktOsoba, pib, email, website, adresa, m);

            TransferObjekatZahtev toz = new TransferObjekatZahtev();
            toz.setOperacija(Konstante.ZAPAMTI_KORISNIKA);
            toz.setParametar(k);
            Komunikacija.getInstance().posaljiZahtev(toz);
            TransferObjekatOdgovor too = Komunikacija.getInstance().primiOdgovor();
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio novog korisnika.", "Sistemska poruka", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti novog korisnika.", "Sistemska poruka", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnSacuvajKorisnikaActionPerformed

    private void jbtnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIzmeniActionPerformed
        try {
            if (!izvrsiValidaciju()) {
                return;
            }

            int korisnikID = Integer.parseInt(jtxtKorisnikID.getText());
            String naziv = jtxtNaziv.getText();
            String kontaktOsoba = jtxtKontaktOsoba.getText();
            int pib = Integer.parseInt(jtxtPIB.getText());
            String email = jtxtEmail.getText();
            String website = jtxtWebsajt.getText();
            String adresa = jtxtUlicaBroj.getText();
            Mesto m = (Mesto) jcbMesto.getSelectedItem();
            Korisnik k = new Korisnik(korisnikID, naziv, kontaktOsoba, pib, email, website, adresa, m);

            TransferObjekatZahtev toz = new TransferObjekatZahtev();
            toz.setOperacija(Konstante.IZMENI_KORISNIKA);
            toz.setParametar(k);
            Komunikacija.getInstance().posaljiZahtev(toz);
            TransferObjekatOdgovor too = Komunikacija.getInstance().primiOdgovor();
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio korisnika.", "Sistemska poruka", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti korisnika.", "Sistemska poruka", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnIzmeniActionPerformed

    private void jbtnDodajMestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDodajMestoActionPerformed
        PnlUnosMesta panel = new PnlUnosMesta();
        JDialog d1 = (JDialog) SwingUtilities.getWindowAncestor(this);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(d1);
        JDialog d = new JDialog(frame, "Unos mesta", true);
        d.setLayout(new BorderLayout());
        d.add(panel, BorderLayout.CENTER);
        d.pack();
        d.setVisible(true);
    }//GEN-LAST:event_jbtnDodajMestoActionPerformed

    private void jpnlCeoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpnlCeoFocusGained

    }//GEN-LAST:event_jpnlCeoFocusGained

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        srediFormu();
    }//GEN-LAST:event_formFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jbtnDodajMesto;
    private javax.swing.JButton jbtnIzmeni;
    private javax.swing.JButton jbtnKreirajKorisnika;
    private javax.swing.JButton jbtnSacuvajKorisnika;
    private javax.swing.JComboBox<Mesto> jcbMesto;
    private javax.swing.JPanel jpnlCeo;
    private javax.swing.JTextField jtxtEmail;
    private javax.swing.JTextField jtxtKontaktOsoba;
    private javax.swing.JTextField jtxtKorisnikID;
    private javax.swing.JTextField jtxtNaziv;
    private javax.swing.JTextField jtxtPIB;
    private javax.swing.JTextField jtxtUlicaBroj;
    private javax.swing.JTextField jtxtWebsajt;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        try {
            jcbMesto.removeAllItems();
            TransferObjekatZahtev toz1 = new TransferObjekatZahtev();
            toz1.setOperacija(Konstante.VRATI_MESTA);
            Komunikacija.getInstance().posaljiZahtev(toz1);
            TransferObjekatOdgovor too1 = Komunikacija.getInstance().primiOdgovor();
            List<Mesto> listaMesta = (List<Mesto>) too1.getRezultat();
            for (Mesto m : listaMesta) {
                jcbMesto.addItem(m);
            }

            Korisnik k = Util.getInstance().getKorisnik("izabrani_korisnik");

            if (k != null) {

                TransferObjekatZahtev toz2 = new TransferObjekatZahtev();
                toz2.setOperacija(Konstante.PRETRAZI_ZADUZENJA);
                toz2.setParametar(k.getKorisnikID());
                Komunikacija.getInstance().posaljiZahtev(toz2);
                TransferObjekatOdgovor too2 = Komunikacija.getInstance().primiOdgovor();
                List<Zaduzenje> listaZaduzenja = (List<Zaduzenje>) too2.getRezultat();
                k.setListaZaduzenja(listaZaduzenja);

                jbtnSacuvajKorisnika.setVisible(false);
                jbtnKreirajKorisnika.setEnabled(false);
                jtxtNaziv.setEditable(true);
                jtxtKontaktOsoba.setEditable(true);
                jtxtPIB.setEditable(true);
                jtxtEmail.setEditable(true);
                jtxtWebsajt.setEditable(true);
                jtxtUlicaBroj.setEditable(true);

                jtxtKorisnikID.setText(String.valueOf(k.getKorisnikID()));
                jtxtNaziv.setText(String.valueOf(k.getNaziv()));
                jtxtPIB.setText(String.valueOf(k.getPib()));
                jtxtKontaktOsoba.setText(String.valueOf(k.getKontaktOsoba()));
                jtxtEmail.setText(String.valueOf(k.getEmail()));
                jtxtWebsajt.setText(String.valueOf(k.getWebsite()));
                jtxtUlicaBroj.setText(String.valueOf(k.getAdresa()));
                jcbMesto.setSelectedItem(k.getMesto());
                Util.getInstance().removeKorisnik("izabrani_korisnik");
            } else {
                jbtnIzmeni.setVisible(false);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da učita listu mesta", "Sistemska poruka", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean izvrsiValidaciju() {
        if (jtxtNaziv.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Niste uneli naziv pravnog lica!", "Sistemska poruka", JOptionPane.ERROR_MESSAGE);
            jtxtNaziv.requestFocusInWindow();
            jtxtNaziv.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            return false;
        }

        if (jtxtPIB.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Niste uneli PIB!", "Sistemska poruka", JOptionPane.ERROR_MESSAGE);
            jtxtPIB.requestFocusInWindow();
            jtxtPIB.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            return false;
        }

        try {
            int pib = Integer.parseInt(jtxtPIB.getText());
        } catch (NumberFormatException nfex) {
            JOptionPane.showMessageDialog(this, "Niste uneli PIB u korektnom formatu! Potrebno je da unesete broj.", "Sistemska poruka", JOptionPane.ERROR_MESSAGE);
            jtxtPIB.requestFocusInWindow();
            jtxtPIB.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            return false;
        }

        if (jtxtPIB.getText().length() != 9) {
            JOptionPane.showMessageDialog(this, "Niste uneli PIB u korektnom formatu! Potrebno je da unesete broj od tačno 9 cifara.", "Sistemska poruka", JOptionPane.ERROR_MESSAGE);
            jtxtPIB.requestFocusInWindow();
            jtxtPIB.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            return false;
        }

        if (jtxtKontaktOsoba.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Niste uneli kontakt osobu!", "Sistemska poruka", JOptionPane.ERROR_MESSAGE);
            jtxtKontaktOsoba.requestFocusInWindow();
            jtxtKontaktOsoba.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            return false;
        }

        if (jtxtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Niste uneli e-mail!", "Sistemska poruka", JOptionPane.ERROR_MESSAGE);
            jtxtEmail.requestFocusInWindow();
            jtxtEmail.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            return false;
        }

        Pattern p_email = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher m_email = p_email.matcher(jtxtEmail.getText());

        if (!m_email.matches()) {
            JOptionPane.showMessageDialog(this, "Niste uneli e-mail u korektnom formatu!", "Sistemska poruka", JOptionPane.ERROR_MESSAGE);
            jtxtEmail.requestFocusInWindow();
            jtxtEmail.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            return false;
        }

        if (jtxtWebsajt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Niste uneli web-sajt!", "Sistemska poruka", JOptionPane.ERROR_MESSAGE);
            jtxtWebsajt.requestFocusInWindow();
            jtxtWebsajt.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            return false;
        }

        Pattern p_websajt = Pattern.compile("(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?");
        Matcher m_websajt = p_websajt.matcher(jtxtWebsajt.getText());
        if (!m_websajt.matches()) {
            JOptionPane.showMessageDialog(this, "Niste uneli websajt u korektnom formatu!", "Sistemska poruka", JOptionPane.ERROR_MESSAGE);
            jtxtWebsajt.requestFocusInWindow();
            jtxtWebsajt.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            return false;
        }

        if (jtxtUlicaBroj.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Niste uneli ulicu i broj!", "Sistemska poruka", JOptionPane.ERROR_MESSAGE);
            jtxtUlicaBroj.requestFocusInWindow();
            jtxtUlicaBroj.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            return false;
        }

        return true;
    }
}
