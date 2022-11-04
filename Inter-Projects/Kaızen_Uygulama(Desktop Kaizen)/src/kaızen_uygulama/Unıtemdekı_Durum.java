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
import kaızen_uygulama.Beans.Org_Bean;

/**
 *
 * @author MFİ
 */
public class Unıtemdekı_Durum extends javax.swing.JFrame {

    String P_SICIL = "", P_ID = "", P_ADI = "", P_SOYADI = "", P_ORG_ID = "",P_O_SEVİYE="";
    String O_P_ADI, O_P_SOYADI, O_K_ADI, O_K_KONU, O_K_BAŞV_TARH, O_K_TAMAM_TAR,
            O_K_RED_TRH, O_ADI, O_SEVİYE, O_K_SON_HARK_TAR;

    /**
     * Creates new form Unıtemdekı_Durum
     */
    public Unıtemdekı_Durum() {

    }

    public Unıtemdekı_Durum(String P_ID, String P_SICIL, String P_ADI, String P_SOYADI, String P_ORG_ID,String P_O_SEVİYE) {
    
        this.P_ID = P_ID;
        this.P_SICIL = P_SICIL;
        this.P_ADI = P_ADI;
        this.P_SOYADI = P_SOYADI;
        this.P_ORG_ID = P_ORG_ID;
        this.P_O_SEVİYE=P_O_SEVİYE;
   
        initComponents();
        show_Org_Bean_List();
 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablo = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Anasayfa = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));

        Tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kaiz Adı", "Kaiz Konu", "Kaiz Başv Trh", "Kaiz Tama Trh", "Kaiz Son Hrkt", "Org Id", "Seviye"
            }
        ));
        Tablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabloMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tablo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AnasayfaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnasayfaActionPerformed
     System.out.println("p_ıd="+P_ADI);
        Ana_Sayfa a=new Ana_Sayfa(P_ID, P_SICIL, P_ADI, P_SOYADI, P_ORG_ID, P_O_SEVİYE);
       setVisible(false);
        a.setVisible(true);    }//GEN-LAST:event_AnasayfaActionPerformed

    private void TabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabloMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TabloMouseClicked
//buraya seviye tablosundan kaç o organizasyon aralığını alabilmek için  ikoşul yaılacak
    //simdi sadece kendi seviyesindeki personellerin kaizenlerini görüyor
    //DİKKAT ET SUNUMDA
    public ArrayList<Org_Bean> Kaizen_Organizasyon() {

        ArrayList<Org_Bean> Org_Bean;
        Kaızen_Uygulama k = new Kaızen_Uygulama();
        Connection con;
        String sorguOrgBılg="";
        Statement st;
        ResultSet rs;
        Org_Bean ob;

        Org_Bean = new ArrayList<Org_Bean>();
        
        if(P_ORG_ID.equals("1") || P_ORG_ID.equals("2") || P_ORG_ID.equals("3") || P_ORG_ID.equals("4") ) {
		    		   sorguOrgBılg ="SELECT *  FROM KAIZEN_ORGANIZASYON_TBL O , KAIZEN_KAIZEN_TBL K  WHERE\r\n" + 
		    		   		"(O.O_ID=K.K_ORG_ID) AND( (O.O_ID=1)OR (O.O_ID=2)OR (O.O_ID=3)OR (O.O_ID=4)) ";
		    		
		    	}
		 
        else if(P_ORG_ID.equals("5") || P_ORG_ID.equals("6") || P_ORG_ID.equals("7") || P_ORG_ID.equals("8")) {
		        sorguOrgBılg ="SELECT *  FROM KAIZEN_ORGANIZASYON_TBL O , KAIZEN_KAIZEN_TBL K  WHERE\r\n" + 
		    		   		"(O.O_ID=K.K_ORG_ID) AND( (O.O_ID=5)OR (O.O_ID=6)OR (O.O_ID=7)OR (O.O_ID=8)) ";
		    		
		    	}
        try {
            con = k.getConnection_Kaizen_Db();
            st = con.createStatement();
            rs = st.executeQuery(sorguOrgBılg);
            while (rs.next()) {
                //organizason bilgileri 
                rs.getString("O_ID");
                O_ADI = rs.getString("O_ADI");
                O_SEVİYE = rs.getString("O_SEVIYE_ID");

                //kişilerin kaizen bilgileri
                rs.getString("K_ID");
                O_K_ADI = rs.getString("K_ADI");
                O_K_KONU = rs.getString("K_KONU");
                O_K_BAŞV_TARH = rs.getString("K_BASV_TARH");
                O_K_TAMAM_TAR = rs.getString("K_TAMAM_TARH");
                O_K_SON_HARK_TAR = rs.getString("K_SON_HARK_TARH");

                ob = new Org_Bean(O_P_ADI, O_P_SOYADI, O_ADI, O_SEVİYE, O_K_ADI,
                        O_K_KONU, O_K_BAŞV_TARH, O_K_TAMAM_TAR, O_K_SON_HARK_TAR);
                Org_Bean.add(ob);
            }

        } catch (Exception e) {
        }

        return Org_Bean;
    }

    private void show_Org_Bean_List() {
        
        ArrayList<Org_Bean> list = new ArrayList<>();
        list = Kaizen_Organizasyon();
        //burada depoladığım kaizen bilgilerini atadım
        DefaultTableModel model;
        model = (DefaultTableModel) Tablo.getModel();
        Object[] row = new Object[7];
        //kolon sayısını belirledim

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getO_K_ADI();
            row[1] = list.get(i).getO_K_KONU();
            row[2] = list.get(i).getO_K_BAŞV_TARH();
            row[3] = list.get(i).getO_K_TAMAM_TAR();
            row[4] = list.get(i).getO_K_SON_HARK_TAR();
            row[5] = list.get(i).getO_ADI();
            row[6] = list.get(i).getO_SEVİYE();

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
            java.util.logging.Logger.getLogger(Unıtemdekı_Durum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Unıtemdekı_Durum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Unıtemdekı_Durum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Unıtemdekı_Durum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Unıtemdekı_Durum().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Anasayfa;
    private javax.swing.JTable Tablo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
