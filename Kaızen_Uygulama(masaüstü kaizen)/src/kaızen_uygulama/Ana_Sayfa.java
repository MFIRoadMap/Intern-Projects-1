/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaızen_uygulama;

/**
 *
 * @author MFİ
 */
public class Ana_Sayfa extends javax.swing.JFrame {

      String pSicil="",pId="",pAdı="",pSoyadı="",pOrgId="",pOSeviye="";
      
    public Ana_Sayfa() {
       
    }
      public Ana_Sayfa( String pId,String pSicil ,String pAdı ,String pSoyadı ,String pOrgId ,String pOSeviye) {
        
          this.pId=pId;
          this.pSicil=pSicil;
          this.pAdı=pAdı;
          this.pSoyadı=pSoyadı;
          this.pOrgId=pOrgId;
          this.pOSeviye=pOSeviye;
          initComponents();
          labelKısı();
          
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Kaızenlerım = new javax.swing.JButton();
        Kaızen_Istatıstık = new javax.swing.JButton();
        Unıtemdekı_Durum = new javax.swing.JButton();
        Kaızen_Ekle = new javax.swing.JButton();
        personelBilgi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        Kaızenlerım.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Kaızenlerım.setText("Kaizenlerim");
        Kaızenlerım.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KaızenlerımActionPerformed(evt);
            }
        });

        Kaızen_Istatıstık.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Kaızen_Istatıstık.setText("Kaizen İstatistik");
        Kaızen_Istatıstık.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Kaızen_IstatıstıkActionPerformed(evt);
            }
        });

        Unıtemdekı_Durum.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Unıtemdekı_Durum.setText("Ünitemdeki Durum");
        Unıtemdekı_Durum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Unıtemdekı_DurumActionPerformed(evt);
            }
        });

        Kaızen_Ekle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Kaızen_Ekle.setText("Kaizen Eke");
        Kaızen_Ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Kaızen_EkleActionPerformed(evt);
            }
        });

        personelBilgi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        personelBilgi.setText("Personel bilgi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Kaızen_Ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Kaızen_Istatıstık, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Unıtemdekı_Durum, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Kaızenlerım, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(personelBilgi, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(personelBilgi, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Kaızenlerım, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Kaızen_Istatıstık, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Kaızen_Ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unıtemdekı_Durum, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
        );

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
    private void KaızenlerımActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KaızenlerımActionPerformed
        Kaızenlerım k=new Kaızenlerım(pId, pSicil, pAdı , pSoyadı , pOrgId,pOSeviye);
        setVisible(false);
        k.setVisible(true);
    }//GEN-LAST:event_KaızenlerımActionPerformed
    private void Kaızen_IstatıstıkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Kaızen_IstatıstıkActionPerformed
        Kaızen_Istatıstık ıs=new Kaızen_Istatıstık(pId, pSicil, pAdı , pSoyadı , pOrgId,pOSeviye);
        System.out.println(pId);
           System.out.println(pOSeviye);
        setVisible(false);
        ıs.setVisible(true);
    }//GEN-LAST:event_Kaızen_IstatıstıkActionPerformed
    private void Unıtemdekı_DurumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Unıtemdekı_DurumActionPerformed
        Unıtemdekı_Durum u=new Unıtemdekı_Durum(pId, pSicil, pAdı , pSoyadı , pOrgId,pOSeviye);
        setVisible(false);
        u.setVisible(true);
    }//GEN-LAST:event_Unıtemdekı_DurumActionPerformed
    private void Kaızen_EkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Kaızen_EkleActionPerformed
        Kaızen_Ekel k=new Kaızen_Ekel(pId, pSicil, pAdı , pSoyadı , pOrgId,pOSeviye);
        setVisible(false);
        k.setVisible(true);
    }//GEN-LAST:event_Kaızen_EkleActionPerformed

   public void labelKısı(){
       personelBilgi.setText(pAdı +"  "+pSoyadı);
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
            java.util.logging.Logger.getLogger(Ana_Sayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ana_Sayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ana_Sayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ana_Sayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ana_Sayfa().setVisible(true);
            }
        });
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Kaızen_Ekle;
    private javax.swing.JButton Kaızen_Istatıstık;
    private javax.swing.JButton Kaızenlerım;
    private javax.swing.JButton Unıtemdekı_Durum;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel personelBilgi;
    // End of variables declaration//GEN-END:variables
}
