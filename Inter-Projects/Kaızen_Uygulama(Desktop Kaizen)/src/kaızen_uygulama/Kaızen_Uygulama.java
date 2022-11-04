/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaızen_uygulama;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MFİ
 */
public class Kaızen_Uygulama {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
        public static Connection getConnection_Kaizen_Db() {
	        Connection con = null;
	        String url, kullanıcıAdı, şifre;
	        url = "jdbc:oracle:thin:@localhost:1521:xe";
	        kullanıcıAdı = "system";
	        şifre = "123";
	        try {

	            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
	            con = DriverManager.getConnection(url, kullanıcıAdı, şifre);

	            

	            return con;
	        } catch (SQLException ex) {

	            JOptionPane.showMessageDialog(null, "Not Connected");
	            return null;
	        }
	    }
}
