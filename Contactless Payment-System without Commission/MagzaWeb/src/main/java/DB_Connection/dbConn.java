package DB_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;



public class dbConn {
	
    public static  Connection getConnection_Magza_DB() throws ClassNotFoundException {
    	 Connection con = null;
         String url, kullanýcýAdý, þifre;

    	 url = "jdbc:sqlserver://DESKTOP-98GNKAF;databaseName=Magza_DB;encrypt=true;trustServerCertificate=true;";
         kullanýcýAdý = "sa";
         þifre = "123456";
         try {
             
        	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             con = DriverManager.getConnection(url , kullanýcýAdý , þifre);
             System.out.println("baðlandý");
             return con;
             
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage());
             return con;
         }
    }
    
    
    public static Connection getConnection_XXXBank_DB() throws ClassNotFoundException {
   	 Connection con = null;
        String url, kullanýcýAdý, þifre;

   	 url = "jdbc:sqlserver://DESKTOP-98GNKAF;databaseName=XXXBank_DB;encrypt=true;trustServerCertificate=true;";
        kullanýcýAdý = "sa";
        þifre = "123456";
        try {
            
       	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url , kullanýcýAdý , þifre);
            System.out.println("baðlandý");
            return con;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
            return con;
        }
   }
}
