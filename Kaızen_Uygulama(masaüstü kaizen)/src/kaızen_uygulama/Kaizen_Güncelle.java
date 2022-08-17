/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaızen_uygulama;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author MFİ
 */
public class Kaizen_Güncelle extends javax.swing.JFrame {

    String P_SICIL = "", P_ID = "", P_ADI = "", P_SOYADI = "", P_ORG_ID = "", P_O_SEVİYE = "";
    static String kaızId = "", ıslemGüncelleId = "";
    String K_ID = "";

    /**
     * Creates new form Kaizen_Güncelle
     */
    public Kaizen_Güncelle() {

    }

    public Kaizen_Güncelle(String K_ID, String P_SICIL, String P_ID, String P_ADI, String P_SOYADI, String P_ORG_ID, String P_O_SEVİYE) {

        initComponents();
        this.P_ID = P_ID;
        this.P_SICIL = P_SICIL;
        this.P_ADI = P_ADI;
        this.P_SOYADI = P_SOYADI;
        this.P_ORG_ID = P_ORG_ID;
        this.K_ID = K_ID;
        this.P_O_SEVİYE = P_O_SEVİYE;
    }
    //GÖNDERİRKEN DEĞİŞECEK OLANI DEĞİŞTİRİYORUM (ID DIŞINDA)DİĞERLERİ NULL GÖNDERİYORUM
    //son olarak ıslem tablosundaki saati d değiştireceğim

    public void KaızenUpdate(String K_ADI, String K_KONUSU, String K_ORG_ID, String K_ID, String K_ACIKLAMA) {

        Connection con;
        PreparedStatement ps;
        String sorguHepsi;

        con = Kaızen_Uygulama.getConnection_Kaizen_Db();
        //false döüyorsa girer
        

            try {
                sorguHepsi = "UPDATE KAIZEN_KAIZEN_TBL SET  K_ADI=?,K_KONU=?,K_Org_ID=?,K_AÇIKLAMA=? WHERE K_ID=?";

                ps = con.prepareStatement(sorguHepsi);
                ps.setString(1, K_ADI);
                ps.setString(2, K_KONUSU);
                ps.setString(3, K_ORG_ID);
                ps.setString(4, K_ACIKLAMA);
                ps.setString(5, K_ID);

                ps.executeUpdate();
                System.out.println("tamamlandı");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
       
        islemGüncelle(K_ID);

    }

    public static void islemGüncelle(String K_ID) {
        Connection con = null;
        kaızIdBulIslem(K_ID);//kaizen tablosundan ıd ve islem  ıd sini bulup gllobal atıyorum buluyor

        String sorguIslem;
        PreparedStatement ps;
        Date d;
        SimpleDateFormat ft2;

        con = Kaızen_Uygulama.getConnection_Kaizen_Db();

        d = new Date();
        ft2 = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        System.out.println("güncellenecek Id" + kaızId);
        sorguIslem = "UPDATE KAIZEN_ISLEM_TBL SET I_OPER_SAAT = TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS.FF') WHERE I_ID=?";

        try {
            ps = con.prepareStatement(sorguIslem);

            ps.setString(1, ft2.format(d));
            ps.setString(2, ıslemGüncelleId);

            ps.executeUpdate();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            // TODO: handle exception
        }
    }

    public static void kaızIdBulIslem(String K_ID) {
        Connection con = null;
        String sorguIdBulma;
        Statement st;
        ResultSet rs;
        System.out.println();
        con = Kaızen_Uygulama.getConnection_Kaizen_Db();
        //KAIZEN ADINI UNİQUE KOYDUM Kİ ID SINE ULAŞABİLMEK İÇİN
        sorguIdBulma = "SELECT * FROM KAIZEN_KAIZEN_TBL K,KAIZEN_ISLEM_TBL I WHERE  (K.K_ID="
                + K_ID + ") AND (K.K_ID=I.I_KAIZ_ID)";
        try {

            st = con.createStatement();
            rs = st.executeQuery(sorguIdBulma);
            while (rs.next()) {

                kaızId = rs.getString("K_ID");
                ıslemGüncelleId = rs.getString("I_ID");
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    //text kontrolü yapacam

    public boolean bosMuGüncelle() {
        boolean sonuc = true;
        String Adı = jTextField2.getText();
        String konu = jTextArea2.getText();
        String org = jTextField3.getText();
        String açıklama = jTextArea1.getText();
        if (!Adı.equals("") && !konu.equals("") && !org.equals("") && !açıklama.equals("")) {
            sonuc = false;
        }
        return sonuc;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        LABEL7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        LABEL10 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        LABEL8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        LABEL9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btonGüncelle = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));

        LABEL7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LABEL7.setText("KAİZEN AD");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        LABEL10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LABEL10.setText("KAİZEN UYGULANACAK ORGANİZASYON ID");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        LABEL8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LABEL8.setText("KAİZEN KONU");

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        LABEL9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LABEL9.setText("KAİZEN AÇIKLAMA");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        btonGüncelle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btonGüncelle.setText("Güncelle");
        btonGüncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btonGüncelleActionPerformed(evt);
            }
        });

        jButton2.setText("Anasayfa");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btonGüncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LABEL7, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LABEL8, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LABEL9, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LABEL10, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LABEL7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LABEL10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LABEL9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LABEL8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btonGüncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
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

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void btonGüncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonGüncelleActionPerformed
       Ana_Sayfa a = new Ana_Sayfa(P_ID, P_SICIL, P_ADI, P_SOYADI, P_ORG_ID, P_O_SEVİYE);
     
        String Adı = jTextField2.getText();
        String konu = jTextArea2.getText();
        String org = jTextField3.getText();
        String açıklama = jTextArea1.getText();

if (bosMuGüncelle() == false) {
        KaızenUpdate(Adı, konu, org, K_ID, açıklama);

          setVisible(false);
        a.setVisible(true);
         } else {
            JOptionPane.showMessageDialog(null, "lütfen bos bırakmayın");
        }
    }//GEN-LAST:event_btonGüncelleActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.out.println("p_ıd=" + P_ADI);
        Ana_Sayfa a = new Ana_Sayfa(P_ID, P_SICIL, P_ADI, P_SOYADI, P_ORG_ID, P_O_SEVİYE);
        setVisible(false);
        a.setVisible(true);


    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Kaizen_Güncelle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kaizen_Güncelle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kaizen_Güncelle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kaizen_Güncelle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kaizen_Güncelle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LABEL10;
    private javax.swing.JLabel LABEL7;
    private javax.swing.JLabel LABEL8;
    private javax.swing.JLabel LABEL9;
    private javax.swing.JButton btonGüncelle;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
