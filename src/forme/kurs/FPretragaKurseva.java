/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.kurs;

import domen.Kurs;
import domen.Nivo;
import domen.StraniJezik;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import kontekst.Kontekst;
import kontroler.Kontroler;

/**
 *
 * @author Dasa
 */
public class FPretragaKurseva extends javax.swing.JDialog {

    /**
     * Creates new form FPretragaKurseva
     */
    public FPretragaKurseva(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        jpFilteri = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbStraniJezik = new javax.swing.JComboBox();
        jcbNivo = new javax.swing.JComboBox();
        jbPretrazi = new javax.swing.JButton();
        jpRezultatiPretrage = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlistKursevi = new javax.swing.JList();
        jbPrikaziDetalje = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pretraga kurseva");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setText("Strani jezik:");

        jLabel2.setText("Nivo:");

        jbPretrazi.setText("Pretrazi");
        jbPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPretraziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpFilteriLayout = new javax.swing.GroupLayout(jpFilteri);
        jpFilteri.setLayout(jpFilteriLayout);
        jpFilteriLayout.setHorizontalGroup(
            jpFilteriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFilteriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFilteriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpFilteriLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbPretrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpFilteriLayout.createSequentialGroup()
                        .addGroup(jpFilteriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jpFilteriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbStraniJezik, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbNivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jpFilteriLayout.setVerticalGroup(
            jpFilteriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFilteriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFilteriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbStraniJezik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpFilteriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbNivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbPretrazi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jlistKursevi);

        jbPrikaziDetalje.setText("Prikazi detalje");
        jbPrikaziDetalje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPrikaziDetaljeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpRezultatiPretrageLayout = new javax.swing.GroupLayout(jpRezultatiPretrage);
        jpRezultatiPretrage.setLayout(jpRezultatiPretrageLayout);
        jpRezultatiPretrageLayout.setHorizontalGroup(
            jpRezultatiPretrageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRezultatiPretrageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpRezultatiPretrageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addGroup(jpRezultatiPretrageLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbPrikaziDetalje)))
                .addContainerGap())
        );
        jpRezultatiPretrageLayout.setVerticalGroup(
            jpRezultatiPretrageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRezultatiPretrageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbPrikaziDetalje)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpFilteri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpRezultatiPretrage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpFilteri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpRezultatiPretrage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPretraziActionPerformed
        // TODO add your handling code here:
        osveziPrikaz();
    }//GEN-LAST:event_jbPretraziActionPerformed

    private void jbPrikaziDetaljeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPrikaziDetaljeActionPerformed
        try {
            // TODO add your handling code here:
            Kurs kurs = (Kurs) jlistKursevi.getSelectedValue();

            if (kurs == null) {
                JOptionPane.showMessageDialog(this, "Niste izabrali nijedan kurs sa spiska!", "Greska", JOptionPane.ERROR_MESSAGE);
            } else {
                Kurs k = Kontroler.vratiInstancu().pronadjiKurs(kurs);
                JOptionPane.showMessageDialog(this, "Sistem je pronasao podatke o kursu!");
                FUnosKursa formaPrikaz = new FUnosKursa((JFrame) this.getParent(), true);
                formaPrikaz.popuniPodatke(k);
                formaPrikaz.onemoguciUnos();
                formaPrikaz.setVisible(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jbPrikaziDetaljeActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        //osveziPrikaz();
    }//GEN-LAST:event_formWindowGainedFocus

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FPretragaKurseva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPretragaKurseva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPretragaKurseva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPretragaKurseva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FPretragaKurseva dialog = new FPretragaKurseva(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbPretrazi;
    private javax.swing.JButton jbPrikaziDetalje;
    private javax.swing.JComboBox jcbNivo;
    private javax.swing.JComboBox jcbStraniJezik;
    private javax.swing.JList jlistKursevi;
    private javax.swing.JPanel jpFilteri;
    private javax.swing.JPanel jpRezultatiPretrage;
    // End of variables declaration//GEN-END:variables

    private void popuniCBStraniJezici() {
        try {
            List<StraniJezik> lista = Kontroler.vratiInstancu().dajStraneJezike();
            for (StraniJezik straniJezik : lista) {
                jcbStraniJezik.addItem(straniJezik);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Greska pri ucitavanju stranih jezika!");
        }
    }

    private void popuniCBNivo() {
        try {
            List<Nivo> lista = Kontroler.vratiInstancu().dajNivoe();
            for (Nivo nivo : lista) {
                jcbNivo.addItem(nivo);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Greska pri ucitavanju nivoa!");
        }
    }

    private void srediFormu() {
        popuniCBStraniJezici();
        popuniCBNivo();
    }

    private void osveziPrikaz() {
        try {
            DefaultListModel<Kurs> modelKurseva = new DefaultListModel<>();

            StraniJezik sj = (StraniJezik) jcbStraniJezik.getSelectedItem();
            Nivo n = (Nivo) jcbNivo.getSelectedItem();
            Kurs k = new Kurs();
            k.setJezik(sj);
            k.setNivo(n);
            List<Kurs> listaKurseva = Kontroler.vratiInstancu().pretraziKurseve(k);

            for (Kurs kurs : listaKurseva) {
                modelKurseva.addElement(kurs);
            }

            jlistKursevi.setModel(modelKurseva);
            JOptionPane.showMessageDialog(this, "Sistem je pronasao kurseve po zadatoj vrednosti!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}
