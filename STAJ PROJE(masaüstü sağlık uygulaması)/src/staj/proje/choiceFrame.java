package staj.proje;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class choiceFrame extends javax.swing.JFrame {

    String kayıtSicilNo = "", kayıtIsmı = "", kayıtSoyısmı = "", kayıtSeçimi = "";
    String drIdNo = "";

    public choiceFrame() {

    }

    public choiceFrame(String sicil, String adı, String soyadı, String seçim) {

        initComponents();

        kayıtSicilNo = sicil;
        kayıtIsmı = adı;
        kayıtSoyısmı = soyadı;
        kayıtSeçimi = seçim;
        SAĞLIK_DB_Bekleyen_Show();
        Hasta_Bilgileri();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        DR2Chck = new javax.swing.JCheckBox();
        DR1Chck = new javax.swing.JCheckBox();
        DR4Chck = new javax.swing.JCheckBox();
        DR3Chck = new javax.swing.JCheckBox();
        DR_1_Adı = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DR_2_Adı = new javax.swing.JLabel();
        DR_3_Adı = new javax.swing.JLabel();
        DR_4_Adı = new javax.swing.JLabel();
        DR_2_BEKLEYEN = new javax.swing.JLabel();
        DR_3_BEKLEYEN = new javax.swing.JLabel();
        DR_4_BEKLEYEN = new javax.swing.JLabel();
        DR_1_BEKLEYEN = new javax.swing.JLabel();
        seçimMuayene = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Hasta_bilgi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel3.setPreferredSize(new java.awt.Dimension(500, 400));

        DR2Chck.setText("DR_2");
        DR2Chck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DR2ChckActionPerformed(evt);
            }
        });

        DR1Chck.setText("DR_1");
        DR1Chck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DR1ChckActionPerformed(evt);
            }
        });

        DR4Chck.setText("DR_4");
        DR4Chck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DR4ChckActionPerformed(evt);
            }
        });

        DR3Chck.setText("DR_3");
        DR3Chck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DR3ChckActionPerformed(evt);
            }
        });

        DR_1_Adı.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("BEKLEYEN SAYISI");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("DOKTOR ADI");

        DR_2_Adı.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        DR_3_Adı.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        DR_4_Adı.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        DR_2_BEKLEYEN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        DR_3_BEKLEYEN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        DR_4_BEKLEYEN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        DR_1_BEKLEYEN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(DR3Chck, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                .addComponent(DR_3_Adı, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(DR4Chck, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DR_4_Adı, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(DR1Chck, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DR_1_Adı, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(DR2Chck, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DR_2_Adı, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 88, 88)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DR_2_BEKLEYEN, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DR_3_BEKLEYEN, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DR_1_BEKLEYEN, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DR_4_BEKLEYEN, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DR1Chck, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DR_1_Adı, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DR_1_BEKLEYEN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(DR2Chck, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DR_2_Adı, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(DR_2_BEKLEYEN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(DR3Chck, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DR_3_Adı, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(DR_3_BEKLEYEN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DR4Chck, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DR_4_Adı, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(DR_4_BEKLEYEN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        seçimMuayene.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        seçimMuayene.setText("Seçilen muayene tipi gelcek");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Hasta_bilgi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Hasta_bilgi.setText("isim-sicil bilgisi gelecek");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(seçimMuayene, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(429, 429, 429))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(597, 597, 597)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(Hasta_bilgi, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(Hasta_bilgi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(seçimMuayene, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void DR3ChckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DR3ChckActionPerformed

            DR2Chck.setSelected(false);
            DR1Chck.setSelected(false);
            DR4Chck.setSelected(false);

    }//GEN-LAST:event_DR3ChckActionPerformed
    private void DR2ChckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DR2ChckActionPerformed

                    DR1Chck.setSelected(false);
            DR3Chck.setSelected(false);
            DR4Chck.setSelected(false);


    }//GEN-LAST:event_DR2ChckActionPerformed
    private void DR1ChckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DR1ChckActionPerformed

            DR2Chck.setSelected(false);
            DR3Chck.setSelected(false);
            DR4Chck.setSelected(false);
    }//GEN-LAST:event_DR1ChckActionPerformed
    private void DR4ChckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DR4ChckActionPerformed

            DR3Chck.setSelected(false);
            DR1Chck.setSelected(false);
              DR2Chck.setSelected(false);

    }//GEN-LAST:event_DR4ChckActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //dr seçilip seçilmediğine bakıyorum

        if (DR1Chck.isSelected() || DR2Chck.isSelected() || DR3Chck.isSelected() || DR4Chck.isSelected()) {
            seçilenDr();
            SAĞLIK_DB_DR_Seçilen_Doktor_Yazma();//seçilirse veritabanına bağlantı kuruyorum
            Giriş_Sayfası g = new Giriş_Sayfası();
            setVisible(false);
            g.setVisible(true);

        } else {

            JOptionPane.showMessageDialog(null, "seçim yapılmadı");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

//buraad seçilen dotora göre sicil numarasını belirliyorum
    //doktor için combobox yapılabilirdi doktor sayısına göre combobox a 
    //item eklenir seçilen iteme (doktora)göre  doktorun ıdsine  kayıt eklenebilinir
    //not burada doktor seçimi için birden çok seçimin kontrolünü yapacaksın
    //aynı anda sadece bir doktor seçebilmeli yine birii seçiyor ama son seçilen dokrota kayıt alıyor
    public void seçilenDr() {
        String seçilenDoktor;
        String seçilenDrId;

        seçilenDoktor = "";
        seçilenDrId = "";

        if (DR1Chck.isSelected()) {
            seçilenDrId = "1";
            seçilenDoktor = "1.doktor";

        }
        if (DR2Chck.isSelected()) {
            seçilenDrId = "2";
            seçilenDoktor = "2.doktor";

        }
        if (DR3Chck.isSelected()) {
            seçilenDrId = "3";
            seçilenDoktor = "3.doktor";


        }
        if (DR4Chck.isSelected()) {
            seçilenDrId = "4";
            seçilenDoktor = "4.doktor";


        }

        drIdNo = seçilenDrId;

        JOptionPane.showMessageDialog(null, seçilenDoktor + " isimli doktora kaydınız alınmıştır");

    }

//seçilen doktorun bekleyen sayısını ve muayenetablosunu burada oluşturuyorum
    public void SAĞLIK_DB_Bekleyen_Show() {
        STAJPROJE sp = new STAJPROJE();

        Connection con;
        String id, sicil, bekleyen, doktorAd, doktorSoyad;
        String sorgu_doktorBilgi;
        String[] bekleyenler;
        String[] doktorIsımler;
        int i;

        sorgu_doktorBilgi = "SELECT * FROM SĞLK_DOKTOR_YOĞUNLUĞU_TBL  ORDER BY  DR_İD   ASC";
        id = "";
        sicil = "";
        bekleyen = "";
        doktorAd = "";
        doktorSoyad = "";
        bekleyenler = new String[4];//doktorları sırasıyla diziye atıp yerlerine yazıyorum
        doktorIsımler = new String[4];
        i = 0;

        Statement stB;
        ResultSet rsB;

        try {

            con = sp.getConnection_sağlık_db();
            stB = con.createStatement();
            rsB = stB.executeQuery(sorgu_doktorBilgi);

            while (rsB.next()) {

                id = rsB.getString("DR_İD");
                sicil = rsB.getString("DR_SİCİL");
                bekleyen = rsB.getString("DR_BEKLEYEN");
                doktorAd = rsB.getString("DR_AD");
                doktorSoyad = rsB.getString("DR_SOYAD");

                doktorIsımler[i] = doktorAd + "_" + doktorSoyad;
                bekleyenler[i] = bekleyen;
                i++;

            }
        } catch (Exception e) {
        }

        DR_1_BEKLEYEN.setText(bekleyenler[0]);
        DR_2_BEKLEYEN.setText(bekleyenler[1]);
        DR_3_BEKLEYEN.setText(bekleyenler[2]);
        DR_4_BEKLEYEN.setText(bekleyenler[3]);

        DR_1_Adı.setText(doktorIsımler[0]);
        DR_2_Adı.setText(doktorIsımler[1]);
        DR_3_Adı.setText(doktorIsımler[2]);
        DR_4_Adı.setText(doktorIsımler[3]);

    }

    public void SAĞLIK_DB_DR_Seçilen_Doktor_Yazma() {
        STAJPROJE sp = new STAJPROJE();

        Connection con;
        String sorgu_doktorBekleyenYazma;
        int pol_per;
        String sorgu_muayeneTabloBilgileriYazma;
        //String SQL_UPDATE_SGLK_DR_YOGUNLUGU;
        //doktor seçimini gönderiyorum seçim sonuuc doktorun id bilgisini butona tıklanma kısmındaki sçeillen_dr metodundan alıyorum

        //sql injection güvenlik acıgı 
        //pol-per olduğunu burada belirliyorum
        pol_per = 0;

        if (kayıtSeçimi.equals("Poliklinik")) {
            pol_per = 1;
        } else {
            pol_per = 2;
        }

        sorgu_doktorBekleyenYazma = "UPDATE SĞLK_DOKTOR_YOĞUNLUĞU_TBL SET"
                + " DR_BEKLEYEN  =DR_BEKLEYEN +1  WHERE  DR_İD= ?";
        System.out.println(kayıtSicilNo);
        System.out.println(pol_per);
        String sayi1 = String.valueOf(pol_per);
        System.out.println(drIdNo);
        sorgu_muayeneTabloBilgileriYazma = "INSERT INTO SĞLK_MUAYENE_TBL (MUAYENE_SİCİL,MUAYENE_TİP_İD,MUAYENE_DR_İD)VALUES( ? , ? , ? )";

        try {//burada doktor tablosuna kayıt yapıyorum
            con = sp.getConnection_sağlık_db();
            PreparedStatement psD = con.prepareStatement(sorgu_doktorBekleyenYazma);
            PreparedStatement psM = con.prepareStatement(sorgu_muayeneTabloBilgileriYazma);
            psD.setString(1, drIdNo);

            psM.setString(1, kayıtSicilNo);
            psM.setString(2, sayi1);
            psM.setString(3, drIdNo);

            psD.executeUpdate();
            psM.executeUpdate();
        } catch (Exception e) {
        }

    }

    private void Hasta_Bilgileri() {
        Hasta_bilgi.setText(kayıtSicilNo + "_" + kayıtIsmı + "_" + kayıtSoyısmı);
        seçimMuayene.setText(kayıtSeçimi);

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new choiceFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox DR1Chck;
    private javax.swing.JCheckBox DR2Chck;
    private javax.swing.JCheckBox DR3Chck;
    private javax.swing.JCheckBox DR4Chck;
    private javax.swing.JLabel DR_1_Adı;
    private javax.swing.JLabel DR_1_BEKLEYEN;
    private javax.swing.JLabel DR_2_Adı;
    private javax.swing.JLabel DR_2_BEKLEYEN;
    private javax.swing.JLabel DR_3_Adı;
    private javax.swing.JLabel DR_3_BEKLEYEN;
    private javax.swing.JLabel DR_4_Adı;
    private javax.swing.JLabel DR_4_BEKLEYEN;
    private javax.swing.JLabel Hasta_bilgi;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel seçimMuayene;
    // End of variables declaration//GEN-END:variables
}
