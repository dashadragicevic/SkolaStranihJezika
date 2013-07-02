/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.kurs;

import domen.Kurs;
import domen.Nivo;
import domen.StraniJezik;
import forme.kurs.ki.KontrolorKIDajSveJezike;
import forme.kurs.ki.KontrolorKIDajSveNivoe;
import forme.kurs.ki.KontrolorKIPretraziKurseve;
import forme.kurs.ki.KontrolorKIPronadjiKurs;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import konstante.Konstante;
import sesija.Sesija;
import tabela.model.ModelTabeleKurs;
import transfer.KlijentTransferObjekat;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Dasa
 */
public class FPretragaKursevaTabela extends javax.swing.JDialog {

    /**
     * Creates new form FPretragaKursevaTabela
     */
    public FPretragaKursevaTabela(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        srediFormu();
        popuniTabeluKurs();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblKurs = new javax.swing.JTable();
        jbtnDetalji = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setText("Strani jezik:");

        jLabel2.setText("Nivo:");

        jcbStraniJezik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbStraniJezikActionPerformed(evt);
            }
        });

        jcbNivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbNivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpFilteriLayout = new javax.swing.GroupLayout(jpFilteri);
        jpFilteri.setLayout(jpFilteriLayout);
        jpFilteriLayout.setHorizontalGroup(
            jpFilteriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFilteriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFilteriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jpFilteriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbStraniJezik, 0, 769, Short.MAX_VALUE)
                    .addComponent(jcbNivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtblKurs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtblKurs);

        jbtnDetalji.setText("Prikazi detalje");
        jbtnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDetaljiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpFilteri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnDetalji)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpFilteri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnDetalji)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDetaljiActionPerformed
        int i = jtblKurs.getSelectedRow();
        if(i==-1){
            JOptionPane.showMessageDialog(this, "Niste odarali nijedan kurs sa spiska!", "Greska", JOptionPane.ERROR_MESSAGE);
        } else {
            this.dispose();
            KontrolorKIPronadjiKurs.pronadjiKurs(jtblKurs);
        }
    }//GEN-LAST:event_jbtnDetaljiActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        KontrolorKIPretraziKurseve.pretraziKurseve(jcbStraniJezik, jcbNivo, jtblKurs);
    }//GEN-LAST:event_formWindowGainedFocus

    private void jcbStraniJezikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbStraniJezikActionPerformed
        // TODO add your handling code here:
        KontrolorKIPretraziKurseve.pretraziKurseve(jcbStraniJezik, jcbNivo, jtblKurs);
    }//GEN-LAST:event_jcbStraniJezikActionPerformed

    private void jcbNivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNivoActionPerformed
        // TODO add your handling code here:
        KontrolorKIPretraziKurseve.pretraziKurseve(jcbStraniJezik, jcbNivo, jtblKurs);
    }//GEN-LAST:event_jcbNivoActionPerformed

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
            java.util.logging.Logger.getLogger(FPretragaKursevaTabela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPretragaKursevaTabela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPretragaKursevaTabela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPretragaKursevaTabela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FPretragaKursevaTabela dialog = new FPretragaKursevaTabela(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jbtnDetalji;
    private javax.swing.JComboBox jcbNivo;
    private javax.swing.JComboBox jcbStraniJezik;
    private javax.swing.JPanel jpFilteri;
    private javax.swing.JTable jtblKurs;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        KontrolorKIDajSveJezike.dajSveJezike(jcbStraniJezik);
        KontrolorKIDajSveNivoe.dajSveNivoe(jcbNivo);
    }

    private void popuniTabeluKurs() {
        List<Kurs> k = new ArrayList<>();
        ModelTabeleKurs m = new ModelTabeleKurs(k);
        jtblKurs.setModel(m);
    }
    
}
