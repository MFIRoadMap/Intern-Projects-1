/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaızen_uygulama;

import java.awt.Graphics;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import kaızen_uygulama.Beans.Kaızen_Bean;
import kaızen_uygulama.Beans.ıstatistik_Bean;

/**
 *
 * @author MFİ
 */
public class Kaızen_Istatıstık extends javax.swing.JFrame {

    String P_SICIL = "", P_ID = "", P_ADI = "", P_SOYADI = "", P_ORG_ID = "", P_O_SEVİYE = "";
    String  listeleP_SICIL,listeieP_ADI,listeleP_SOYADI; //tabloda listeleme için kullanıyorum
    String K_ID, K_ADI, K_KONU, K_BASV_TARH, K_TAMAM_TARH, K_SON_HARK_TARH, K_AÇIKLAMA, D_ADI;
    int Oluştu = 0, ilkAmirOnayı = 0, MüdürOnayı = 0, RehberOnay = 0, KaizenMüdür = 0, Reddedild = 0, KabulEdildi = 0, d1;

    /**
     * Creates new form Kaızen_Istatıstık
     */
    public Kaızen_Istatıstık() {

    }

    public Kaızen_Istatıstık(String P_ID, String P_SICIL, String P_ADI, String P_SOYADI, String P_ORG_ID, String P_O_SEVİYE) {
        initComponents();
       
        this.P_ID = P_ID;
        System.out.println(P_ID);
        this.P_SICIL = P_SICIL;
        this.P_ADI = P_ADI;
        this.P_SOYADI = P_SOYADI;
        this.P_ORG_ID = P_ORG_ID;
        this.P_O_SEVİYE = P_O_SEVİYE;
        secimcombobox();
        show_Istatistik_Bean_List();

    }

    public void secimcombobox() {
        System.out.println("organizasyon seviye"+P_O_SEVİYE);
        if(P_O_SEVİYE.equals("1")){
                    SeviyeSec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Stajyer"}));

        }
        else if(P_O_SEVİYE.equals("2")){
                    SeviyeSec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Stajyer", "Mühendis"}));

        }
        else if(P_O_SEVİYE.equals("3")){
                    SeviyeSec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Stajyer", "Mühendis", "Baş Mühendis"}));

        }
        else if(P_O_SEVİYE.equals("4")){
                    SeviyeSec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Stajyer",
                        "Mühendis", "Baş Mühendis", "Müdür"}));

        }
    }

  
    //BURADA PERSONELİN ORG IS SİNİ GİRİS YAPTIĞINCDA ÇEKİYORUM ZATEN
    public ArrayList<ıstatistik_Bean> Kaizen_İstatistik(String P_ORG_SEV) {

        Connection con;
        String sorguOrgBilg = "";
        Statement st;
        ResultSet rs;
        String döndür;
        
        String seviye1 = "", seviye2 = "", seviye3 = "", seviye4 = "";
        ıstatistik_Bean bean = null;
        ArrayList<ıstatistik_Bean> ıstatistik_Bean;
        //seveiyelerine göre altında çalışanların kaizenlerini görmesini sağlıyorum

        ıstatistik_Bean = new ArrayList<ıstatistik_Bean>();
        

        if (P_ORG_SEV.equals("1") || P_ORG_SEV.equals("2") || P_ORG_SEV.equals("3") || P_ORG_SEV.equals("4")) {

            if (P_ORG_SEV.equals("1")) {
                seviye1 = "1";
                seviye2 = "1";
                seviye3 = "1";
                seviye4 = "1";
            } else if (P_ORG_SEV.equals("2")) {
                seviye1 = "1";
                seviye2 = "1";
                seviye3 = "2";
                seviye4 = "2";

            } else if (P_ORG_SEV.equals("3")) {
                seviye1 = "1";
                seviye2 = "1";
                seviye3 = "2";
                seviye4 = "3";
            } else if (P_ORG_SEV.equals("4")) {
                seviye1 = "1";
                seviye2 = "2";
                seviye3 = "3";
                seviye4 = "4";
            }
            //DURUMUNA GÖRE BÜYÜKTEN KÜÇÜĞE SIRALIYORUM
            sorguOrgBilg = "SELECT *  FROM KAIZEN_KAIZEN_TBL K  ,KAIZEN_PERSONEL_TBL P,KAIZEN_ISLEM_TBL I ,KAIZEN_DURUM_TBL D  WHERE\r\n"
                    + "( (P.P_ORG_ID=" + seviye1 + ")OR (P.P_ORG_ID=" + seviye2 + ")OR (P.P_ORG_ID=" + seviye3 + ")OR (P.P_ORG_ID=" + seviye4 + ")) AND (P.P_SICIL=I.I_SICIL_ID)\r\n"
                    + "AND (I.I_KAIZ_ID=K.K_ID)  AND(D.D_ID=I.I_DURUM_ID)  ORDER BY P.P_ORG_ID DESC";
        } else if (P_ORG_SEV.equals("5") || P_ORG_SEV.equals("6") || P_ORG_SEV.equals("7") || P_ORG_SEV.equals("8")) {

            if (P_ORG_SEV.equals("5")) {
                seviye1 = "5";
                seviye2 = "5";
                seviye3 = "5";
                seviye4 = "5";
            } else if (P_ORG_SEV.equals("6")) {
                seviye1 = "5";
                seviye2 = "5";
                seviye3 = "6";
                seviye4 = "6";

            } else if (P_ORG_SEV.equals("7")) {
                seviye1 = "5";
                seviye2 = "6";
                seviye3 = "7";
                seviye4 = "7";
            } else if (P_ORG_SEV.equals("8")) {
                seviye1 = "5";
                seviye2 = "6";
                seviye3 = "7";
                seviye4 = "8";
            }

            sorguOrgBilg = "SELECT *  FROM KAIZEN_KAIZEN_TBL K  ,KAIZEN_PERSONEL_TBL P,KAIZEN_ISLEM_TBL I,KAIZEN_DURUM_TBL D  WHERE\r\n"
                    + "( (P.P_ORG_ID=" + seviye1 + ")OR (P.P_ORG_ID=" + seviye2 + ")OR (P.P_ORG_ID=" + seviye3 + ")OR (P.P_ORG_ID=" + seviye4 + ")) AND (P.P_SICIL=I.I_SICIL_ID)\r\n"
                    + "AND (I.I_KAIZ_ID=K.K_ID)  AND(D.D_ID=I.I_DURUM_ID) ORDER BY P.P_ORG_ID DESC";
        }
        System.out.println("çalıştı2");
        try {
            con = Kaızen_Uygulama.getConnection_Kaizen_Db();
            st = con.createStatement();
            rs = st.executeQuery(sorguOrgBilg);
            System.out.println("çalıştı3");
            while (rs.next()) {

                listeleP_SICIL = rs.getString("P_SICIL");
                listeieP_ADI = rs.getString("P_ADI");
                listeleP_SOYADI = rs.getString("P_SOYADI");
                K_ID = rs.getString("K_ID");
                K_ADI = rs.getString("K_ADI");
                K_KONU = rs.getString("K_KONU");
                K_BASV_TARH = rs.getString("K_BASV_TARH");
                K_TAMAM_TARH = rs.getString("K_TAMAM_TARH");
                K_SON_HARK_TARH = rs.getString("K_SON_HARK_TARH");
                K_AÇIKLAMA = rs.getString("K_AÇIKLAMA");
                D_ADI = rs.getString("D_ADI");
                bean = new ıstatistik_Bean(listeleP_SICIL, listeieP_ADI, listeleP_SOYADI, K_ID, 
                    K_ADI, K_KONU, K_BASV_TARH, K_TAMAM_TARH, K_SON_HARK_TARH, K_AÇIKLAMA, D_ADI);
                ıstatistik_Bean.add(bean);
            }
            //beanlara atayarak tabloda geri alacam

        } catch (Exception e) {
            // TODO: handle exception
        }//arraylist i döndürdüm
        return ıstatistik_Bean;

    }

    public void show_Istatistik_Bean_List() {
        ArrayList<ıstatistik_Bean> list = new ArrayList<>();
        //çalıştırıyorum zaten istatistik sayfasını
        list = Kaizen_İstatistik(P_O_SEVİYE);
        //burada depoladığım kaizen bilgilerini atadım
        DefaultTableModel model = (DefaultTableModel) Tablo_Görünüm2.getModel();
        Object[] row = new Object[11];
        //kolon sayısını belirledim

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getP_SICIL();
            row[1] = list.get(i).getP_ADI();
            row[2] = list.get(i).getP_SOYADI();
            row[3] = list.get(i).getK_ID();
            row[4] = list.get(i).getK_ADI();
            row[5] = list.get(i).getK_KONU();
            row[6] = list.get(i).getK_BASV_TARH();
            row[7] = list.get(i).getK_TAMAM_TARH();
            row[8] = list.get(i).getK_SON_HARK_TARH();
            row[9] = list.get(i).getK_AÇIKLAMA();
            row[10] = list.get(i).getD_ADI();

            model.addRow(row);

        }
    }

    
    
    

    //EKRANA GRAFİK OLARAK VERMEK İÇİN APLET İLE BAĞLANTI KURARAK YAPMAYI PLANLIYORUM 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tablo_Görünüm2 = new javax.swing.JTable();
        SeviyeSec = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Anasayfa = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        Tablo_Görünüm2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "P SİCİL", "P ADI  ", "P SOYADI", "K ID", "K ADI", "K KONU", "K BASV TARH", "K TAMAM TARİH", "K SON HARKT TARH", "K AÇIKLAMA", "K DURUM"
            }
        ));
        Tablo_Görünüm2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tablo_Görünüm2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Tablo_Görünüm2);

        SeviyeSec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        SeviyeSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeviyeSecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(SeviyeSec, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(SeviyeSec, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        jMenu1.setText("Seçenekler");

        Anasayfa.setText("Anasayfa");
        Anasayfa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnasayfaActionPerformed(evt);
            }
        });
        jMenu1.add(Anasayfa);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Tablo_Görünüm2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tablo_Görünüm2MouseClicked

    }//GEN-LAST:event_Tablo_Görünüm2MouseClicked

    private void SeviyeSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeviyeSecActionPerformed
        String secim=(String) SeviyeSec.getSelectedItem();
        ıstatıstık_tablo_detay itd=new ıstatıstık_tablo_detay(secim,P_SICIL, P_ID, P_ADI , P_SOYADI , P_ORG_ID,P_O_SEVİYE);
        setVisible(false);
        itd.setVisible(true);
    }//GEN-LAST:event_SeviyeSecActionPerformed

    private void AnasayfaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnasayfaActionPerformed
      System.out.println("p_ıd="+P_ADI);
        System.out.println(P_ID);
        Ana_Sayfa a=new Ana_Sayfa(P_ID, P_SICIL, P_ADI, P_SOYADI, P_ORG_ID, P_O_SEVİYE);
        setVisible(false);
        a.setVisible(true);
    }//GEN-LAST:event_AnasayfaActionPerformed

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
            java.util.logging.Logger.getLogger(Kaızen_Istatıstık.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kaızen_Istatıstık.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kaızen_Istatıstık.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kaızen_Istatıstık.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kaızen_Istatıstık().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Anasayfa;
    private javax.swing.JComboBox<String> SeviyeSec;
    private javax.swing.JTable Tablo_Görünüm2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
