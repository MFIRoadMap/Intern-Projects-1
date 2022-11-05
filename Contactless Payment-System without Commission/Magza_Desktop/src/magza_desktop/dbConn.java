/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magza_desktop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author furka
 */
 class dbConn {
      public Connection getConnection_Magza_DB() {
        Connection con = null;
        String url, kullanıcıAdı, şifre;
        url = "jdbc:sqlserver://DESKTOP-98GNKAF;databaseName=Magza_DB;encrypt=true;trustServerCertificate=true;";
        kullanıcıAdı = "sa";
        şifre = "123456";
        try {
            con = DriverManager.getConnection(url , kullanıcıAdı , şifre);
            System.out.println("bağlandı");
            return con;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getSQLState());
            return null;
        }
    }
}
