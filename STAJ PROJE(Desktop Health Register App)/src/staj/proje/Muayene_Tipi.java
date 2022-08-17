package staj.proje;


import java.sql.*;

public class Muayene_Tipi extends javax.swing.JFrame {

    public String sicilNo = "";
    public String ad = "";
    public String soyad = "";

    public Muayene_Tipi() {

    }

    public Muayene_Tipi(String kayıtSicilNo) {
        sicilNo = kayıtSicilNo;
        initComponents();

        SAĞLIK_DB_Kişi_Bilgisi_Bul();
        Label_Bilgi_Yazma();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        seçimMuayenePer = new javax.swing.JButton();
        seçimMuayenePol = new javax.swing.JButton();
        general_İnformation_Sicil = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        general_İnformation_Adı = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setText("Muayene Tipini Seçiniz");

        seçimMuayenePer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        seçimMuayenePer.setText("Periyodik");
        seçimMuayenePer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seçimMuayenePerActionPerformed(evt);
            }
        });

        seçimMuayenePol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        seçimMuayenePol.setText("Polikilinik");
        seçimMuayenePol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seçimMuayenePolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(seçimMuayenePer, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(seçimMuayenePol, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seçimMuayenePer, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seçimMuayenePol, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        general_İnformation_Sicil.setBackground(new java.awt.Color(255, 255, 255));
        general_İnformation_Sicil.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        general_İnformation_Sicil.setText("kişi bilgisi girilecek");

        label2.setBackground(new java.awt.Color(255, 255, 255));
        label2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label2.setText("ADI_SOYADI");

        label1.setBackground(new java.awt.Color(255, 255, 255));
        label1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label1.setText("SİCİL NUMARASI");

        general_İnformation_Adı.setBackground(new java.awt.Color(255, 255, 255));
        general_İnformation_Adı.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        general_İnformation_Adı.setText("kişi bilgisi girilecek");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(general_İnformation_Sicil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(general_İnformation_Adı, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(general_İnformation_Adı, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(general_İnformation_Sicil, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seçimMuayenePerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seçimMuayenePerActionPerformed
        choiceFrame cf1 = new choiceFrame(sicilNo, ad, soyad, "Periyodik");
        cf1.setVisible(true);
        setVisible(false);

    }//GEN-LAST:event_seçimMuayenePerActionPerformed

    private void seçimMuayenePolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seçimMuayenePolActionPerformed

        choiceFrame cf1 = new choiceFrame(sicilNo, ad, soyad, "Poliklinik");
        cf1.setVisible(true);
        setVisible(false);

    }//GEN-LAST:event_seçimMuayenePolActionPerformed
    /*label a kişi bilgilerini yazabilmek için adını ve soyadını alıyorum*/
    public void SAĞLIK_DB_Kişi_Bilgisi_Bul() {
        STAJPROJE sp = new STAJPROJE();

        Connection con;
        String scl;
        String name, surname;
        Statement st2;
        ResultSet rs2;
        String sorguKişiAdSoyadBilgisi;

        scl = sicilNo;//global değişkenle aldım çünkü nesenyle çağırığımda bağlantı old için sicil numarasını alamıyorum
        sorguKişiAdSoyadBilgisi = "SELECT * FROM SĞLK_PERSONEL_TBL WHERE PRSNL_SİCİL=" + sicilNo;
        name = "";
        surname = "";

        try {
            con = sp.getConnection_sağlık_db();
            st2 = con.createStatement();
            rs2 = st2.executeQuery(sorguKişiAdSoyadBilgisi);

            while (rs2.next()) {

                name = rs2.getString("PRSLN_AD");
                surname = rs2.getString("PRSNL_SOYAD");

                ad = name;
                soyad = surname;
            }
        } catch (Exception e) {
        }

    }

    private void Label_Bilgi_Yazma() {
        general_İnformation_Adı.setText(ad + "_" + soyad);
        general_İnformation_Sicil.setText(sicilNo);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Muayene_Tipi().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel general_İnformation_Adı;
    private javax.swing.JLabel general_İnformation_Sicil;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JButton seçimMuayenePer;
    private javax.swing.JButton seçimMuayenePol;
    // End of variables declaration//GEN-END:variables

}
