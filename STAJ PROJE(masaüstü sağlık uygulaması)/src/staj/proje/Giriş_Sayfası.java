/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staj.proje;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Giriş_Sayfası extends javax.swing.JFrame {

    public String kayıtSicilNumarası = "";
    public boolean muayeneSayfasıGiris = false;

    //veritabanına 2 kere bağlanmaması için önce bağlantıyı kurup 
    //global bir değişkende sonucunu tutuyorum sistemin doğrulaması için
    public Giriş_Sayfası() {
        initComponents();
     

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        kontrolButon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setText("HOŞGELDİNİZ LÜTFEN");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setText("KARTINIZI OKUTUNUZ");

        kontrolButon.setText("GİRİŞ ");
        kontrolButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontrolButonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(kontrolButon, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(kontrolButon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kontrolButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontrolButonActionPerformed
     KART_DB_Id_Sicil_Eşleme();
        Muayene_Tipi mt = new Muayene_Tipi(kayıtSicilNumarası);
  
        if (muayeneSayfasıGiris == true) {
            mt.setVisible(true);
            setVisible(false);
        }
        else{
                        JOptionPane.showMessageDialog(null, "lütfen kartınızı okutunuz");

        }
    }//GEN-LAST:event_kontrolButonActionPerformed

    /*dosyadan okunan ıd numarasını kullanarak sicil numarasını alıp muayene sayfasının
    girişine yönlendiriyorum
     */
    public void KART_DB_Id_Sicil_Eşleme() {
     STAJPROJE sp = new STAJPROJE();

        boolean sonuç;
        String okunanIdNumarası;
        Connection con;
        String sicilNo;
        String sorguIdSicilEşleşmesi;
        Statement st;
        ResultSet rs;

        okunanIdNumarası = sp.dosyaIdOkuma();;//ıd sini alıyorum dosyadan
        sp.dosyaSilOlultur();
        sicilNo = null;//sicil numarasını bulmak için
        sonuç = false;
        sorguIdSicilEşleşmesi = "SELECT * FROM PERSONEL_KARTLARI_TBL WHERE PRSNL_İD=" + okunanIdNumarası;

     
        try {

            con = sp.getConnection_kart_db();
            st = con.createStatement();
            rs = st.executeQuery(sorguIdSicilEşleşmesi);

            while (rs.next()) {
                sicilNo = rs.getString("PRSNL_SİCİL");
            }
        } catch (Exception e) {
        }

        kayıtSicilNumarası = sicilNo;

        if (sicilNo.equals("")) {//eğer veritabanında karşılığı yoksa boş dönecek
            //girişi belirlediğim kısım
            sonuç = false;
        } else {
            sonuç = true;
        }

        System.out.println(sonuç);
        muayeneSayfasıGiris = sonuç;

    }

    public static void main(String args[]) {

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Giriş_Sayfası().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton kontrolButon;
    // End of variables declaration//GEN-END:variables
}
