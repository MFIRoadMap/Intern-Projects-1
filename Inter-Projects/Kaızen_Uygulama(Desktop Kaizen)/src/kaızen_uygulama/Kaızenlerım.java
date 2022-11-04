/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaızen_uygulama;

import kaızen_uygulama.Beans.Kaızen_Bean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MFİ
 */
public class Kaızenlerım extends javax.swing.JFrame {

    String P_SICIL = "", P_ID = "", P_ADI = "", P_SOYADI = "", P_ORG_ID = "", P_O_SEVİYE = "";
    String K_Id, K_Adı, K_Konu, K_Bas_Tarh, ıçerık;

    /**
     * Creates new form Kaızenlerım
     */
    public Kaızenlerım() {

    }

    public Kaızenlerım( String P_ID, String P_SICIL,String P_ADI, String P_SOYADI, String P_ORG_ID, String P_O_SEVİYE) {
        this.P_ID = P_ID;
        this.P_SICIL = P_SICIL;
        this.P_ADI = P_ADI;
        this.P_SOYADI = P_SOYADI;
        this.P_ORG_ID = P_ORG_ID;
        this.P_O_SEVİYE = P_O_SEVİYE;
        initComponents();
        show_Kaızen_Bean_List();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablo_Görünüm = new javax.swing.JTable();
        kaizenDetay = new javax.swing.JButton();
        detayKaizen = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        Tablo_Görünüm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Adı", "Konu", "Oluşt_Tarihi"
            }
        ));
        Tablo_Görünüm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tablo_GörünümMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tablo_Görünüm);

        kaizenDetay.setText("DETAY");
        kaizenDetay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kaizenDetayActionPerformed(evt);
            }
        });

        detayKaizen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detayKaizenActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("DETAYLARI İÇİN KAIZEN ID GİRİNİZ");

        jButton2.setText("GERİ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(detayKaizen, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(kaizenDetay, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(detayKaizen, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kaizenDetay, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.out.println("p_ıd=" + P_ADI);
        Ana_Sayfa a = new Ana_Sayfa(P_ID, P_SICIL, P_ADI, P_SOYADI, P_ORG_ID, P_O_SEVİYE);
        setVisible(false);
        a.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void detayKaizenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detayKaizenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detayKaizenActionPerformed

    private void kaizenDetayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kaizenDetayActionPerformed
        ıçerık = detayKaizen.getText();
        if (!detayKaizen.getText().equals("")) {
            Kaızen_Detay k = new Kaızen_Detay(P_SICIL, ıçerık, P_ID, P_ADI, P_SOYADI, P_ORG_ID, P_O_SEVİYE);
            setVisible(false);
            k.setVisible(true);
        }
    }//GEN-LAST:event_kaizenDetayActionPerformed

    private void Tablo_GörünümMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tablo_GörünümMouseClicked

    }//GEN-LAST:event_Tablo_GörünümMouseClicked

    public ArrayList<Kaızen_Bean> Kaızen_Sergile() {

        ArrayList<Kaızen_Bean> Kaızen_Bean;
        Kaızen_Uygulama k = new Kaızen_Uygulama();
        Connection con;
        String sorguKaizen;
        Statement st;
        ResultSet rs;
        Kaızen_Bean kb;

        sorguKaizen = "SELECT *  FROM  KAIZEN_KAIZEN_TBL K ,KAIZEN_PERSONEL_TBL P ,KAIZEN_ISLEM_TBL I ,KAIZEN_DURUM_TBL D WHERE "
                + "(P.P_SICIL=" + P_SICIL + ") AND (I.I_SICIL_ID=P.P_SICIL) AND (I.I_KAIZ_ID=K.K_ID)  AND (D.D_ID=I.I_DURUM_ID)";
        Kaızen_Bean = new ArrayList<Kaızen_Bean>();

        try {
            con = k.getConnection_Kaizen_Db();
            st = con.createStatement();
            rs = st.executeQuery(sorguKaizen);

            while (rs.next()) {
                K_Id = rs.getString("K_ID");
                K_Adı = rs.getString("K_ADI");
                K_Konu = rs.getString("K_KONU");
                K_Bas_Tarh = rs.getString("K_BASV_TARH");

                kb = new Kaızen_Bean(K_Id, K_Adı, K_Konu, K_Bas_Tarh);
                Kaızen_Bean.add(kb);
            }
        } catch (Exception e) {
        }
        return Kaızen_Bean;
    }

    public void show_Kaızen_Bean_List() {
        ArrayList<Kaızen_Bean> list = new ArrayList<>();
        list = Kaızen_Sergile();
        //burada depoladığım kaizen bilgilerini atadım
        DefaultTableModel model = (DefaultTableModel) Tablo_Görünüm.getModel();
        Object[] row = new Object[4];
        //kolon sayısını belirledim

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getK_Id();
            row[1] = list.get(i).getK_Adı();
            row[2] = list.get(i).getK_Konu();
            row[3] = list.get(i).getK_Bas_Tarh();
            model.addRow(row);
        }
    }

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
            java.util.logging.Logger.getLogger(Kaızenlerım.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kaızenlerım.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kaızenlerım.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kaızenlerım.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kaızenlerım().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tablo_Görünüm;
    private javax.swing.JTextField detayKaizen;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kaizenDetay;
    // End of variables declaration//GEN-END:variables
}
