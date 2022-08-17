package MenagerFiles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Bean.O_Seviye_Bean;

//import org.json.JSONObject;

import Bean.Personel_Bean;
import DB_Connection.Database_Connection;

public class PersonelBilgi {

	public static String[] PersonelSorgu(String sicil) {
		Database_Connection db = new Database_Connection();

		Connection con;
		String sql;
		Statement st;
		ResultSet rs;
		Personel_Bean personel_Bilgi;
		O_Seviye_Bean orgsev;
		String kontrol = "0";
		String OrgId = "0";

		orgsev = new O_Seviye_Bean();
		String dizi[] = new String[2];
		personel_Bilgi = new Personel_Bean();

		if (bosMuGiris(sicil) == false) {

			sql = "SELECT\r\n" + "    *\r\n"
					+ "FROM KAIZEN_PERSONEL_TBL P,KAIZEN_ORGANIZASYON_TBL O,KAIZEN_O_SEVIYE_TBL S WHERE\r\n"
					+ "(P.P_SICIL=" + sicil + ") AND (P.P_ORG_ID=O.O_ID) AND (O.O_SEVIYE_ID = S.S_ID)";

			try {
				con = db.getConnection_Kaizen_Db();
				st = con.createStatement();
				rs = st.executeQuery(sql);

				while (rs.next()) {

					personel_Bilgi.setId(rs.getString("P_ID"));
					personel_Bilgi.setSicil(rs.getString("P_SÝCÝL"));
					personel_Bilgi.setAdý(rs.getString("P_ADI"));
					personel_Bilgi.setSoyadý(rs.getString("P_SOYADI"));
					personel_Bilgi.setOrg_Id(rs.getString("P_ORG_ID"));

					orgsev.setSeviye_Ad(rs.getString("S_ID"));

				}
				if (!personel_Bilgi.getSicil().equals("")) {

					kontrol = orgsev.getSeviye_Ad();

					OrgId = personel_Bilgi.getOrg_Id();
					dizi[0] = kontrol;
					dizi[1] = OrgId;
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "lütfen geçerli bir sicil iriniz");

			}
		} else {
			JOptionPane.showMessageDialog(null, "sicil kýsmýný bos býrakmayýnýz");
		}

		return dizi;
	}

	public static boolean bosMuGiris(String sicil) {
		boolean sonuc = true;
		if (!sicil.equals("")) {
			sonuc = false;
		}
		return sonuc;
	}
}
