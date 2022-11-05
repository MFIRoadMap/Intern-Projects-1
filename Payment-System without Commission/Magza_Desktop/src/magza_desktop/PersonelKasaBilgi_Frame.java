/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package magza_desktop;

import Beans.KasaBeans;
import Beans.MusteriBeans;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author furka
 */
public class PersonelKasaBilgi_Frame extends javax.swing.JFrame {

    dbConn DB_Con = new dbConn();
    Connection con = null;
    LocalDate d = LocalDate.now();
    String date = d.toString();
    String PersonelId = null, PersonelIsım = null, PersonelSoyisim = null;
    ArrayList<KasaBeans> KasaDurumSorguList = new ArrayList<>();
    ArrayList<KasaBeans> KasaHsilatSorguList = new ArrayList<>();
    String Kasa_Durum_Id = "", Kasa_Durum_Durum = "", Kasa_Durum_Personel_Id = "", Kasa_Durum_Tip = "", Kasa_Durum_Persoenl_Isim = "", Kasa_Durum_Personel_SoyIsim = "";
    String Kasa_Hasilat_Id = "", Kasa_Hasilat_Durum = "", Kasa_Hasilat_Personel_Id = "", Kasa_Hasilat_Tip = "", Kasa_Hasilat_Persoenl_Isim = "", Kasa_Hasilat_Personel_SoyIsim = "";
    double Kasa_Hasilat_Satis = 0, Kasa_Hasilat_Iade = 0;
    
    public PersonelKasaBilgi_Frame() {
        initComponents();
    }

    public PersonelKasaBilgi_Frame(String PersonelId, String PersonelIsım, String PersonelSoyisim) {
        initComponents();
        this.PersonelId = PersonelId;
        this.PersonelIsım = PersonelIsım;
        this.PersonelSoyisim = PersonelSoyisim;
        con = DB_Con.getConnection_Magza_DB();
        Tarih_jLabel.setText(date);
        KasaDurumTable();
        KasaHasılatTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Kasa_Hasilat_Table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Kasa_Durum_Table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Tarih_jLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        AnaSayfa_jMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Kasa_Hasilat_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kasa Id", "KasaTip", "Satışlar", "İadeler", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Kasa_Hasilat_Table);

        Kasa_Durum_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kasa Id", "Durum", "Personel Id", "Kasa Tip", "P Isim", "P Soyisim"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Kasa_Durum_Table);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("KASA DURUM");
        jLabel3.setPreferredSize(new java.awt.Dimension(50, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("KASA HASILAT");
        jLabel4.setPreferredSize(new java.awt.Dimension(50, 20));

        Tarih_jLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Tarih_jLabel.setPreferredSize(new java.awt.Dimension(50, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Tarih_jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tarih_jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(83, 83, 83))
        );

        jMenu1.setText("Seçenekler");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        AnaSayfa_jMenuItem.setText("Ana Sayfa");
        AnaSayfa_jMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnaSayfa_jMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(AnaSayfa_jMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AnaSayfa_jMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnaSayfa_jMenuItemActionPerformed

        PersonelAnaSayfa_Frame paf = new PersonelAnaSayfa_Frame(PersonelId, PersonelIsım, PersonelSoyisim);
        setVisible(false);
        paf.setVisible(true);

    }//GEN-LAST:event_AnaSayfa_jMenuItemActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

     public void KasaDurumTable() {
        KasaBeans kb;
        String query;

        try {
            Statement st = con.createStatement();
            query = "select * from Kasa_Table, Personel_Table where Kasa_Personel_Id = Personel_Id";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Kasa_Durum_Id = rs.getString("Kasa_Id");
                Kasa_Durum_Durum = rs.getString("Kasa_Durum");
                Kasa_Durum_Personel_Id = rs.getString("Kasa_Personel_Id");
                Kasa_Durum_Tip = rs.getString("Kasa_Tip");
                Kasa_Durum_Persoenl_Isim = rs.getString("Personel__Isim");
                Kasa_Durum_Personel_SoyIsim = rs.getString("Personel_SoyIsim");

                kb = new KasaBeans(Kasa_Durum_Id, Kasa_Durum_Durum, Kasa_Durum_Personel_Id, Kasa_Durum_Tip, Kasa_Durum_Persoenl_Isim, Kasa_Durum_Personel_SoyIsim);
                KasaDurumSorguList.add(kb);
            }

            KasaDurumListele();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bu Id değerine sahip müşteri bilgisi bulunamadı");
        }
    }

    //TABLO VE ARRAYLİST İŞLEMLERİ VAR ------------------------------------------------------------------------------
    public void KasaDurumListele() {

        DefaultTableModel model = (DefaultTableModel) Kasa_Durum_Table.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < KasaDurumSorguList.size(); i++) {
            row[0] = KasaDurumSorguList.get(i).getKasa_Id();
            row[1] = KasaDurumSorguList.get(i).getKasa_Durum();
            row[2] = KasaDurumSorguList.get(i).getKasa_Personel_Id();
            row[3] = KasaDurumSorguList.get(i).getKasa_Tip();
            row[4] = KasaDurumSorguList.get(i).getKasa_Persoenl_Isim();
            row[5] = KasaDurumSorguList.get(i).getKasa_Personel_SoyIsim();

            model.addRow(row);
        }
    }

    
    
    
    public void KasaHasılatTable() {
        KasaBeans kb;
        String query;

        try {
            Statement st = con.createStatement();
            query = "select * from Kasa_Table, Personel_Table where Kasa_Personel_Id = Personel_Id";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Kasa_Hasilat_Id = rs.getString("Kasa_Id");
                Kasa_Hasilat_Durum = rs.getString("Kasa_Durum");
                Kasa_Hasilat_Personel_Id = rs.getString("Kasa_Personel_Id");
                Kasa_Hasilat_Tip = rs.getString("Kasa_Tip");
                Kasa_Hasilat_Persoenl_Isim = rs.getString("Personel__Isim");
                Kasa_Hasilat_Personel_SoyIsim = rs.getString("Personel_SoyIsim");

                kb = new KasaBeans(Kasa_Hasilat_Id, Kasa_Hasilat_Durum, Kasa_Hasilat_Personel_Id, Kasa_Hasilat_Tip, Kasa_Hasilat_Persoenl_Isim, Kasa_Hasilat_Personel_SoyIsim);
                KasaHsilatSorguList.add(kb);
            }
            KasaHasılatListele();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "hatakodu 1");
        }
    }

    //TABLO VE ARRAYLİST İŞLEMLERİ VAR ------------------------------------------------------------------------------
    public void KasaHasılatListele() {

        DefaultTableModel model = (DefaultTableModel) Kasa_Hasilat_Table.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < KasaHsilatSorguList.size(); i++) {
            row[0] = KasaHsilatSorguList.get(i).getKasa_Id();
            row[1] = KasaHsilatSorguList.get(i).getKasa_Tip();
            row[2] = KasaHasılatSatisTable(KasaHsilatSorguList.get(i).getKasa_Id());
            row[3] = KasaHasılatIadeTable(KasaHsilatSorguList.get(i).getKasa_Id());
            row[4] = Kasa_Hasilat_Satis - Kasa_Hasilat_Iade;

            model.addRow(row);
        }
    }

    
    
    public double KasaHasılatSatisTable(String kasaId) {
        KasaBeans kb;
        String query, Urunbarkod = "";
        double SatisHesap = 0;
        try {
            Statement st = con.createStatement();
            query = "select * from Kasa_Table kt, Satis_Table st where Kasa_Id = "+kasaId+" and st.Satis_Durum = 'S' and Kasa_Id =st.Satis_Kasa_Id and Satis_Tarih = '"+date+"'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Urunbarkod = rs.getString("Satis_Urun_Barkod");
                SatisHesap += Double.valueOf(FiyatBul(Urunbarkod));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "hatakodu 2");
        }
        Kasa_Hasilat_Satis = SatisHesap;
        return SatisHesap;
    }

        public double KasaHasılatIadeTable(String kasaId) {
        KasaBeans kb;
        String query, Urunbarkod = "";
        double IadeHesap = 0;
        try {
            Statement st = con.createStatement();
            query = "select * from Iade_Table where Iade_Tarih = '"+ date +"' and Iade_Kasa_Id = "+kasaId;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Urunbarkod = rs.getString("Iade_Urun_Barkod");
                IadeHesap += Double.valueOf(FiyatBul(Urunbarkod));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "harakodu 3");
        }
        Kasa_Hasilat_Iade = IadeHesap;
        return IadeHesap;
    }
    
    
    public String FiyatBul(String Barkod) {
        String Fiyat = "", query;

        try {
            Statement st = con.createStatement();
            query = "select * from Urun_Table where Urun_Barkod = '" + Barkod +"'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Fiyat = rs.getString("Urun_Fiyat");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ürünün fiyat değeri buolunamadı");
        }
        return Fiyat;
    }

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
            java.util.logging.Logger.getLogger(PersonelKasaBilgi_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonelKasaBilgi_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonelKasaBilgi_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonelKasaBilgi_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonelKasaBilgi_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AnaSayfa_jMenuItem;
    private javax.swing.JTable Kasa_Durum_Table;
    private javax.swing.JTable Kasa_Hasilat_Table;
    private javax.swing.JLabel Tarih_jLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
