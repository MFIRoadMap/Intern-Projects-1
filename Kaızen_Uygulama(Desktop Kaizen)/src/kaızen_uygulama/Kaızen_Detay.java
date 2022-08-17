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
import javax.swing.JOptionPane;

/**
 *
 * @author MFİ
 */
public class Kaızen_Detay extends javax.swing.JFrame {

    public String Id;
    public static String ıslemDeleteId = "", kaızId = "";
    String P_SICIL = "", P_ID = "", P_ADI = "", P_SOYADI = "", P_ORG_ID = "", P_O_SEVİYE = "";
    String K_Id = "", K_Adı = "", K_Konu = "", K_Bas_Tarh = "", K_Tamam_Tar = "", K_Red_Tar = "", K_Son_Hrk_Tarh = "", K_Son_Hrkt_Id = "",
            K_Org_Id = "", D_Adı = "", K_Açıklama = "";

    public Kaızen_Detay() {

    }

    public Kaızen_Detay(String P_SICIL, String Id, String P_ID, String P_ADI, String P_SOYADI, String P_ORG_ID, String P_O_SEVİYE) {
        initComponents();
        this.P_SICIL = P_SICIL;
        this.K_Id = Id;
        this.P_ID = P_ID;
        this.P_ADI = P_ADI;
        this.P_SOYADI = P_SOYADI;
        this.P_ORG_ID = P_ORG_ID;
        this.P_O_SEVİYE = P_O_SEVİYE;

        Kaızen_Detay_Goster(P_SICIL, Id);

        System.out.println(Id);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LABEL1 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        LABEL5 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label8 = new javax.swing.JLabel();
        label11 = new javax.swing.JLabel();
        label12 = new javax.swing.JLabel();
        label14 = new javax.swing.JLabel();
        LABEL2 = new javax.swing.JLabel();
        label16 = new javax.swing.JLabel();
        label17 = new javax.swing.JLabel();
        LABEL3 = new javax.swing.JLabel();
        LABEL6 = new javax.swing.JLabel();
        LABEL7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        btn_Sil = new javax.swing.JButton();
        btn_Güncelle = new javax.swing.JButton();
        LABEL4 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        LABEL11 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        LABEL1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        label3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label3.setText("TAMAMLANMA TARHİ");

        LABEL5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        label2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label2.setText("KAİZEN ADI");

        label6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label6.setText("RED TARİHİ");

        label5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label5.setText("ORGANİZASYON ID");

        label8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        label11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label11.setText("BAŞVURU TARİHİ");

        label12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label12.setText("KAİZEN ID");

        label14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label14.setText("SON HAREKET TARİHİ");

        LABEL2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        label16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label16.setText("KAİZEN AÇIKLAMA");

        label17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label17.setText("KAİZEN KONU");

        LABEL3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        LABEL6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        LABEL7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        btn_Sil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Sil.setText("Sil");
        btn_Sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SilActionPerformed(evt);
            }
        });

        btn_Güncelle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Güncelle.setText("Güncelle");
        btn_Güncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GüncelleActionPerformed(evt);
            }
        });

        LABEL4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        label7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label7.setText("Son İşlem Saati");

        LABEL11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LABEL1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LABEL2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(LABEL6, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(LABEL7, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label17, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LABEL11, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label16, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(LABEL4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_Sil, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_Güncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LABEL3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(77, 77, 77)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(LABEL5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(297, 297, 297)
                .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LABEL2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LABEL1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LABEL3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LABEL5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btn_Güncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_Sil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LABEL6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LABEL7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(LABEL11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(LABEL4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addGap(30, 30, 30))
        );

        jMenu1.setText("Seçenekler");

        jMenuItem1.setText("Kaizenlerim");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_GüncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GüncelleActionPerformed
        Kaizen_Güncelle g = new Kaizen_Güncelle(K_Id, P_SICIL, P_ID, P_ADI, P_SOYADI, P_ORG_ID, P_O_SEVİYE);
        setVisible(false);
        g.setVisible(true);
     }//GEN-LAST:event_btn_GüncelleActionPerformed

    private void btn_SilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SilActionPerformed
        Ana_Sayfa a = new Ana_Sayfa(P_ID, P_SICIL, P_ADI, P_SOYADI, P_ORG_ID, P_O_SEVİYE);
        Kaızen_Delete(K_Id);
        setVisible(false);
        a.setVisible(true);
    }//GEN-LAST:event_btn_SilActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    System.out.println("p_ıd=" + P_ADI);
        Kaızenlerım k = new Kaızenlerım( P_ID, P_SICIL,P_ADI, P_SOYADI, P_ORG_ID, P_O_SEVİYE);
        setVisible(false);
        k.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void Kaızen_Delete(String K_ID) {

        KaızIdbULDelte(K_ID);
        Connection con = null;
        PreparedStatement ps1, ps2;
        String sorguKaızen, sorguIslem;

        System.out.println("çalışıyor1");
        con = Kaızen_Uygulama.getConnection_Kaizen_Db();
        sorguKaızen = "DELETE FROM KAIZEN_KAIZEN_TBL WHERE K_ID=?";
        sorguIslem = "DELETE FROM KAIZEN_ISLEM_TBL WHERE I_ID=?";

        try {
            //önce islemi sildm ki fk ile bağlantısı sıkıntı çıkarmısın diye
            ps1 = con.prepareStatement(sorguIslem);
            ps2 = con.prepareStatement(sorguKaızen);
            ps1.setString(1, ıslemDeleteId);
            ps2.setString(1, kaızId);
            ps1.executeUpdate();
            ps2.executeUpdate();

            JOptionPane.showMessageDialog(null, "kaizen silindi");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            // TODO: handle exception
        }
    }

    public static void KaızIdbULDelte(String K_ID) {
        Connection con = null;
        con = Kaızen_Uygulama.getConnection_Kaizen_Db();

        String sorguIdBulma;
        Statement st;
        ResultSet rs;
        System.out.println("kaiz ıd" + K_ID);
        //KAIZEN ADINI UNİQUE KOYDUM Kİ ID SINE ULAŞABİLMEK İÇİN
        sorguIdBulma = "SELECT * FROM KAIZEN_KAIZEN_TBL K, KAIZEN_ISLEM_TBL I WHERE \r\n"
                + "(K.K_ID='" + K_ID + "') AND (K.K_ID=I.I_KAIZ_ID)";
        System.out.println("çalışıyor3");
        try {

            st = con.createStatement();
            rs = st.executeQuery(sorguIdBulma);
            System.out.println("çalışıyor2");
            while (rs.next()) {
                //kaiz ve islem tablosundaki ıd sini alıp globale atıyorum
                System.out.println("kaiz ıd" + rs.getString("K_ID"));
                System.out.println("islem ıd" + rs.getString("I_ID"));
                kaızId = rs.getString("K_ID");
                ıslemDeleteId = rs.getString("I_ID");
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void Kaızen_Detay_Goster(String P_SİCİL, String K_ID) {

        Kaızen_Uygulama k = new Kaızen_Uygulama();
        Connection con;
        String sorguKaizen;
        Statement st;
        ResultSet rs;

        sorguKaizen = "SELECT * FROM KAIZEN_KAIZEN_TBL K, KAIZEN_PERSONEL_TBL P,KAIZEN_ISLEM_TBL I,KAIZEN_DURUM_TBL D\r\n"
                + "WHERE (P.P_SICIL=" + P_SİCİL + ") AND (I.I_SICIL_ID=P.P_SICIL) AND (I_KAIZ_ID=K.K_ID)AND (D.D_ID=I_DURUM_ID)\r\n"
                + "AND (K.K_ID=" + K_ID + ")";

        try {
            con = k.getConnection_Kaizen_Db();
            st = con.createStatement();
            rs = st.executeQuery(sorguKaizen);
            System.out.println(K_ID);
            while (rs.next()) {

                K_Id = rs.getString("K_ID");
                K_Adı = rs.getString("K_ADI");
                K_Konu = rs.getString("K_KONU");

                LABEL1.setText(rs.getString("K_ID"));
                LABEL2.setText(rs.getString("K_ADI"));
                jTextArea2.setText(rs.getString("K_KONU"));
                LABEL3.setText(rs.getString("K_BASV_TARH"));
                LABEL4.setText(rs.getString("K_TAMAM_TARH"));
                LABEL5.setText(rs.getString("K_SON_HARK_TARH"));
                LABEL6.setText(rs.getString("K_ORG_ID"));
                LABEL7.setText(rs.getString("K_RED_TARH"));
                jTextArea1.setText(rs.getString("K_AÇIKLAMA"));
                LABEL11.setText(rs.getString("I_OPER_SAAT"));
                D_Adı = rs.getString("D_ADI");
            }
        } catch (Exception e) {
            // TODO: handle exception
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
            java.util.logging.Logger.getLogger(Kaızen_Detay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kaızen_Detay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kaızen_Detay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kaızen_Detay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kaızen_Detay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LABEL1;
    private javax.swing.JLabel LABEL11;
    private javax.swing.JLabel LABEL2;
    private javax.swing.JLabel LABEL3;
    private javax.swing.JLabel LABEL4;
    private javax.swing.JLabel LABEL5;
    private javax.swing.JLabel LABEL6;
    private javax.swing.JLabel LABEL7;
    private javax.swing.JButton btn_Güncelle;
    private javax.swing.JButton btn_Sil;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel label11;
    private javax.swing.JLabel label12;
    private javax.swing.JLabel label14;
    private javax.swing.JLabel label16;
    private javax.swing.JLabel label17;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    // End of variables declaration//GEN-END:variables
}
