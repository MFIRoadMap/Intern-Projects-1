package ManagerFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;

import DB_Connection.dbConn;

public class IndexIslem {
	
	
	
	public String BizeUlasinTableOlustur(String BUT_Isim, String BUT_SoyIsým, String BUT_Mail,
			String BUT_Konu, String BUT_Icerik)  {

		String query = "INSERT INTO  Bize_Ulasin_Table (BUT_Isim, BUT_SoyIsým, BUT_Mail, BUT_Konu, BUT_Icerik, BUT_Tarih, BUT_Durum)"
				+ " VALUES (?, ?, ?, ?, ?, GETDATE(), ?)";

		try {
			Connection con = null;
			con = dbConn.getConnection_Magza_DB();
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, BUT_Isim);
			ps.setString(2, BUT_SoyIsým);
			ps.setString(3, BUT_Mail);
			ps.setString(4, BUT_Konu);
			ps.setString(5, BUT_Icerik);
			ps.setString(6, "Okunmadi");

			ps.executeUpdate();
			return "1";

		} catch (Exception ex) {
			return "0";
		}
		
	}

}
