/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arayuzler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import sinifllar.Personel;
import sinifllar.izinler;
import sinifllar.listeleme;

/**
 *
 * @author furkan
 */
public class Sayfa2a extends javax.swing.JFrame {
private JPopupMenu menu = new JPopupMenu("Popup");
private JPopupMenu menu2 = new JPopupMenu("Popup");
    /**
     * Creates new form personel
     */
    public Sayfa2a() {
        initComponents();
        try {
          ObservableList<Personel> sonuc=new Personel(null, null, null, null, null, null, null).pListele();
            DefaultTableModel tab= (DefaultTableModel) personelTab.getModel();
                    tab.getDataVector().clear();
            personelTab.repaint();
        Vector [] v= new Vector[sonuc.size()];
        for (int i = 0; i < sonuc.size(); i++) {
            v[i]=new Vector();
            v[i].add(sonuc.get(i).getTcno());
            v[i].add(sonuc.get(i).getSicilno());
            v[i].add(sonuc.get(i).getAd());
            v[i].add(sonuc.get(i).getSoyad());
            v[i].add(sonuc.get(i).getCinsiyet());
            v[i].add(sonuc.get(i).getDogumtarihi());
            v[i].add(sonuc.get(i).getSehir());
            tab.insertRow(i, v[i]);
        }
        }catch (SQLException ex) {
            Logger.getLogger(Sayfa2a.class.getName()).log(Level.SEVERE, null, ex);
        }
        JMenuItem satirsil2=new JMenuItem("Sil");
        JMenuItem satirsil=new JMenuItem("Sil");
        menu.add(satirsil);
        menu2.add(satirsil2);
        satirsil.addActionListener(
			new ActionListener(){
                                @Override
				public void actionPerformed(ActionEvent e){
                                       try{
                                           boolean varmi=false;
                                             boolean silKontrol=false;
                                        Personel ms = new Personel(null, null, null, null, null, null, null);
                                        if(JOptionPane.showConfirmDialog(null, "Silmek İstediğinize emin misiniz?",
                                          "Dikkat", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                                        silKontrol = ms.pSil(personelTab.getValueAt(personelTab.getSelectedRow(), 0).toString());
                                             }else{
                                            varmi=true;
                                                }
                                                 if(silKontrol){
                                                    JOptionPane.showMessageDialog(null, "Silindi");
                                                     }if(!silKontrol&&!varmi){
                                                      JOptionPane.showMessageDialog(null, "Önce personelin tüm izinlerini silmelisiniz");
                                                       }
                                                      }catch(ArrayIndexOutOfBoundsException ex){
                                                         JOptionPane.showMessageDialog(null, "Önce personel seçiniz.!!");
                                                            }
                                    
                                                        	}
                                                                     });
                                                                        satirsil2.addActionListener( 
                                                            new ActionListener(){
                                                      @Override
                                                    public void actionPerformed(ActionEvent e)
                                                        {
                                                            try{
                                                                boolean silKontrol=false;
                                        izinler ms = new izinler(null, null, null, null, null, null, null, null);
                                         if(JOptionPane.showConfirmDialog(null, "Silmek İstediğinize emin misiniz?",
                                            "Dikkat", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                                            silKontrol = ms.iSil(izintab.getValueAt(izintab.getSelectedRow(), 0).toString());
                                            }
                                        if(silKontrol){
                                             JOptionPane.showMessageDialog(null, "Silindi");
                                                 }
                                                            }catch(ArrayIndexOutOfBoundsException ex){
                                                                   JOptionPane.showMessageDialog(null, "Önce izin Seçiniz!!");
                                                                 }
                                                            }
                                                });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        personelTab = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        izintab = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sayfa2 = new javax.swing.JButton();
        sayfa3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        yenile = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Personeller Ve Izinleri");

        personelTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "TC No", "Sicil No", "Ad", "Soyad", "Cinsiyet", "Dogum Tarihi", "Şehir"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        personelTab.setComponentPopupMenu(jMenu1.getComponentPopupMenu());
        personelTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                personelTabMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personelTabMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(personelTab);

        izintab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kayit No", "Birim", "Kalan", "Başlangıç Tarihi", "Bitiş Tarihi", "Kullanılan", "Izin Türü", "TC No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        izintab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                izintabMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(izintab);

        jLabel1.setBackground(new java.awt.Color(246, 26, 12));
        jLabel1.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(236, 41, 28));
        jLabel1.setLabelFor(izintab);
        jLabel1.setText("IZINLER");
        jLabel1.setToolTipText("");
        jLabel1.setNextFocusableComponent(izintab);

        jLabel2.setBackground(new java.awt.Color(235, 208, 206));
        jLabel2.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(236, 41, 28));
        jLabel2.setLabelFor(personelTab);
        jLabel2.setText("PERSONELLER");
        jLabel2.setToolTipText("");
        jLabel2.setNextFocusableComponent(personelTab);

        sayfa2.setText("Sayfa 2b ->");
        sayfa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sayfa2ActionPerformed(evt);
            }
        });

        sayfa3.setText("Sayfa 2c->");
        sayfa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sayfa3ActionPerformed(evt);
            }
        });

        jButton1.setText("<-Sayfa 1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        yenile.setText("Yenile");
        yenile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yenileActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(234, 17, 17));
        jLabel3.setText("Not: Silmek istediğiniz kişiyi seçip sağ tıklayın...");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(234, 17, 17));
        jLabel5.setText("Not: Silmek istediğiniz izini seçip sağ tıklayın...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(249, 249, 249)
                        .addComponent(yenile)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(327, 327, 327))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(sayfa2)
                                .addGap(18, 18, 18)
                                .addComponent(sayfa3)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(yenile)
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sayfa2)
                            .addComponent(sayfa3)
                            .addComponent(jButton1))))
                .addContainerGap())
        );

        jLabel1.getAccessibleContext().setAccessibleParent(izintab);
        jLabel2.getAccessibleContext().setAccessibleParent(personelTab);

        pack();
    }// </editor-fold>//GEN-END:initComponents

      
    
    private void personelTabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personelTabMousePressed
        
        try {
            String tc = personelTab.getValueAt(personelTab.getSelectedRow(), 0).toString();
        ObservableList<izinler> sonuc = new listeleme().listele(tc);
        DefaultTableModel tab= (DefaultTableModel) izintab.getModel();
        tab.getDataVector().clear();
        izintab.repaint();
        Vector [] v= new Vector[sonuc.size()];
        for (int i = 0; i < sonuc.size(); i++) {
            v[i]=new Vector();
            v[i].add(sonuc.get(i).getKayitNo());
            v[i].add(sonuc.get(i).getBirim());
            v[i].add(sonuc.get(i).getKalan());
            v[i].add(sonuc.get(i).getBaslangic());
            v[i].add(sonuc.get(i).getBitis());
            v[i].add(sonuc.get(i).getKullanılan());
            v[i].add(sonuc.get(i).getTuru());
            v[i].add(sonuc.get(i).getTcno());
            tab.insertRow(i, v[i]);
        }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_personelTabMousePressed

    private void sayfa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sayfa2ActionPerformed
       Sayfa2b ac=new Sayfa2b();
            ac.show();
            this.hide();
    }//GEN-LAST:event_sayfa2ActionPerformed

    private void sayfa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sayfa3ActionPerformed
        Sayfa2c ac=new Sayfa2c();
            ac.show();
            this.hide();
    }//GEN-LAST:event_sayfa3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Sayfa1 ac=new Sayfa1();
            ac.show();
            this.hide();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void yenileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yenileActionPerformed
        try {
          ObservableList<Personel> sonuc=new Personel(null, null, null, null, null, null, null).pListele();
            DefaultTableModel tab= (DefaultTableModel) personelTab.getModel();
                    tab.getDataVector().clear();
            personelTab.repaint();
        Vector [] v= new Vector[sonuc.size()];
        for (int i = 0; i < sonuc.size(); i++) {
            v[i]=new Vector();
            v[i].add(sonuc.get(i).getTcno());
            v[i].add(sonuc.get(i).getSicilno());
            v[i].add(sonuc.get(i).getAd());
            v[i].add(sonuc.get(i).getSoyad());
            v[i].add(sonuc.get(i).getCinsiyet());
            v[i].add(sonuc.get(i).getDogumtarihi());
            v[i].add(sonuc.get(i).getSehir());
            tab.insertRow(i, v[i]);
        }
        }catch (SQLException ex) {
            Logger.getLogger(Sayfa2a.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_yenileActionPerformed

    private void personelTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personelTabMouseClicked
        if(SwingUtilities.isRightMouseButton(evt)){
            menu.show(evt.getComponent(),evt.getX(),evt.getY());
        }
    }//GEN-LAST:event_personelTabMouseClicked

    private void izintabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_izintabMouseClicked
        if(SwingUtilities.isRightMouseButton(evt)){
            menu2.show(evt.getComponent(),evt.getX(),evt.getY());
        }
    }//GEN-LAST:event_izintabMouseClicked

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
            java.util.logging.Logger.getLogger(Sayfa2a.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sayfa2a.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sayfa2a.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sayfa2a.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sayfa2a().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable izintab;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable personelTab;
    private javax.swing.JButton sayfa2;
    private javax.swing.JButton sayfa3;
    private javax.swing.JButton yenile;
    // End of variables declaration//GEN-END:variables
}
