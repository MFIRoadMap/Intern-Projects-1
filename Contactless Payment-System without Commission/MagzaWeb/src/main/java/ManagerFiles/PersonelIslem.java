package ManagerFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Random;

import javax.swing.JOptionPane;
import org.apache.tomcat.util.codec.binary.Base64;
import DB_Connection.dbConn;




public class PersonelIslem {

	LocalDate d = LocalDate.now();
	static Connection con = null;
	static dbConn db_conn = new dbConn();

	public String[] PersonelGirisKontrol(String PersonelMail, String PersonelParola) {

		String[] result = new String[4];
		String Personel_Id = "", Personel__Isim = "", Personel_SoyIsim = "", Personel_Yetki = "";
		String query;
		System.out.print(PersonelMail);
		try {
			query = "SELECT * FROM Personel_Table WHERE Personel_Mail ='" + PersonelMail + "' and Personel_Sifre ='"
					+ PersonelParola + "'";

			con = dbConn.getConnection_Magza_DB();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Personel_Id = rs.getString("Personel_Id");
				Personel__Isim = rs.getString("Personel__Isim");
				Personel_SoyIsim = rs.getString("Personel_SoyIsim");
				Personel_Yetki = rs.getString("Personel_Yetki"); //sadece persoel anasayfada kýsýtlamalar için kullanacaðým
				
				System.out.print(Personel__Isim);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		result[0] = Personel_Id;
		result[1] = Personel__Isim;
		result[2] = Personel_SoyIsim;
		result[3] = Personel_Yetki;

		return result;
	}

	public String PersonelKayitOlustur(String Personel__Isim, String Personel_SoyIsim, String Personel_Cinsiyet,
			String Personel_Telefon, String Personel_Mail, String Personel_Adres, String Personel_Egitim_Duzey,
			String Personel_Sifre, String Personel_Sifre_Dogrula,
			String Personel_Yetki, String Personel_Maas, String Personel_Dogum_Tarih) {

		String query = "INSERT INTO  Personel_Table (Personel__Isim, Personel_SoyIsim, Personel_Cinsiyet, Personel_Telefon,\r\n"
				+ "Personel_Mail, Personel_Adres, Personel_Egitim_Duzey, Personel_Baslama_Tarih, Personel_Izýn_Hakký, Personel_Sifre,\r\n"
				+ "Personel_Yetki, Personel_Maas, Personel_Dogum_Tarih, Personel_Sifre_Degis_Parola) \r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, GETDATE(), ?, ?, ?, ?, ?, ?)";

		try {
			Connection con = null;
			con = dbConn.getConnection_Magza_DB();
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, Personel__Isim);
			ps.setString(2, Personel_SoyIsim);
			ps.setString(3, Personel_Cinsiyet);
			ps.setString(4, Personel_Telefon);
			ps.setString(5, Personel_Mail);
			ps.setString(6, Personel_Adres);
			ps.setString(7, Personel_Egitim_Duzey);
			ps.setString(8, "20");
			ps.setString(9, Personel_Sifre);
			ps.setString(10, Personel_Yetki);
			ps.setString(11, Personel_Maas);
			ps.setString(12, Personel_Dogum_Tarih);
			ps.setString(13, RandomPinUret());
			

			ps.executeUpdate();
			return "1";

		} catch (Exception ex) {
			return "0";
		}
	}

	public String RandomPinUret() {
        Random random = new Random();
        String setOfCharacters = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567";

        String Pin = "";
        for (int i = 0; i < 10; i++) {
        int randomInt = random.nextInt(setOfCharacters.length());
        Pin += setOfCharacters.charAt(randomInt);
        }
        System.out.println("Pin: " + Pin);
        return Pin;
    }
	
	public String PersonelDurumListele() {

		Connection con;
		String query, icerik = "";
		Statement st;
		ResultSet rs;

		query = "Select * From Personel_Table";
		icerik += "<table><th>Id</th><th>Isim</th><th>Soyisim</th><th>Cinsiyet</th><th>Telefon</th><th>Adres</th><th>Egitim</th><th>Maas</th><th>Yetki</th><th>Mail</th>";
		try {
			con = dbConn.getConnection_Magza_DB();
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
	
				icerik +="<tr>"
						+ "<td>" + rs.getString("Personel_Id") + "</td>" + 
						"<td>" + rs.getString("Personel__Isim") + "</td>" +
						"<td>" + rs.getString("Personel_SoyIsim") + "</td>" +
						"<td>" + rs.getString("Personel_Cinsiyet") + "</td>" +
						"<td>" + rs.getString("Personel_Telefon") + "</td>" +
						"<td>" + rs.getString("Personel_Adres") + "</td>" +
						"<td>" + rs.getString("Personel_Egitim_Duzey") + "</td>" +
						"<td>" + rs.getString("Personel_Maas") + "</td>" +
						"<td>" + rs.getString("Personel_Yetki") + "</td>" +
						"<td>" + rs.getString("Personel_Mail") + "</td>"
								+ "</tr>";

			}
			icerik += "</table>";

		} catch (Exception e) {
		}
		return icerik;
	}
	
	
	public String PersonelSiteMesajListele() {

		Connection con;
		String query, icerik = "";
		Statement st;
		ResultSet rs;

		query = "Select TOP 10 * From Bize_Ulasin_Table where BUT_Durum = 'Okunmadi' order by BUT_Id desc";
		icerik += "<table><tr><th>Id</th><th>Isim</th><th>SoyIsim</th><th>Mail</th><th>Konu</th><th>Aciklama</th><th>Tarih</th><th>Durum</th>";
		try {
			con = dbConn.getConnection_Magza_DB();
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
	
				icerik +="<tr>"
						+ "<td>" + rs.getString("BUT_Id") + "</td>" + 
						"<td>" + rs.getString("BUT_Isim") + "</td>" +
						"<td>" + rs.getString("BUT_SoyIsým") + "</td>" +
						"<td>" + rs.getString("BUT_Mail") + "</td>" +
						"<td>" + rs.getString("BUT_Konu") + "</td>" +
						"<td>" + rs.getString("BUT_Icerik") + "</td>" +
						"<td>" + rs.getString("BUT_Tarih") + "</td>" +
						"<td>" + rs.getString("BUT_Durum") + "</td>" +
						"</tr>";

			}
			icerik += "</table>";

		} catch (Exception e) {
		}
		return icerik;
	}
	
	

	public String PersonelSiteMesajListeleOkunanlar() {

		Connection con;
		String query, icerik = "";
		Statement st;
		ResultSet rs;

		query = "Select TOP 10 * From Bize_Ulasin_Table where BUT_Durum = 'Okundu' order by BUT_Id desc";
		icerik += "<table><tr><th>Id</th><th>Isim</th><th>SoyIsim</th><th>Mail</th><th>Konu</th><th>Aciklama</th><th>Tarih</th><th>Durum</th>";
		try {
			con = dbConn.getConnection_Magza_DB();
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
	
				icerik +="<tr>"
						+ "<td>" + rs.getString("BUT_Id") + "</td>" + 
						"<td>" + rs.getString("BUT_Isim") + "</td>" +
						"<td>" + rs.getString("BUT_SoyIsým") + "</td>" +
						"<td>" + rs.getString("BUT_Mail") + "</td>" +
						"<td>" + rs.getString("BUT_Konu") + "</td>" +
						"<td>" + rs.getString("BUT_Icerik") + "</td>" +
						"<td>" + rs.getString("BUT_Tarih") + "</td>" +
						"<td>" + rs.getString("BUT_Durum") + "</td>" +
						"</tr>";

			}
			icerik += "</table>";

		} catch (Exception e) {
		}
		return icerik;
	}
	
	public String SiteMesajIdListele() {

		Connection con;
		String query, icerik = "";
		Statement st;
		ResultSet rs;
		
		query = "Select * From Bize_Ulasin_Table where BUT_Durum = 'Okunmadi'";
		try {
			con = dbConn.getConnection_Magza_DB();
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
	
				icerik += "<option value=\" "+ rs.getString("BUT_Id") + " \">"+ rs.getString("BUT_Id") +"</option>";

			}
		} catch (Exception e) {
		}
		return icerik;
	}
	
	public String SiteMesajDurumGuncelle (String MesajId) {
		
		String query = "UPDATE Bize_Ulasin_Table SET BUT_Durum = 'Okundu'   WHERE BUT_Id = ?";

		try {
			Connection con = null;
			con = dbConn.getConnection_Magza_DB();
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, MesajId);
			ps.executeUpdate();
			return "1";
		} catch (Exception ex) {
			return "2";
		}
	}
	
	
	
	
	
	
	
	public String UrunDurumListele() {

		Connection con;
		String query, icerik = "";
		Statement st;
		ResultSet rs;

		query = "Select * From Urun_Table";

		try {
			con = dbConn.getConnection_Magza_DB();
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				byte[] image = rs.getBytes("Urun_Gorsel");
				String base64Encoded = new String(Base64.encodeBase64(image), "UTF-8");//base64 ile kadlama nedni sanýrým geçersi karakterleri bypass etmek
		        
				icerik += "<div class = \"col-lg-4 container d-flex align-items-center justify-content-center\"   > "
						+ "<div style = \" padding: 10px; \">"
						+ "<div class=\"card none d-lg-block \" style=\" width: 20rem; padding-top:3%; border-radius:15px; \"> \n"
							+"<img src=\"data:image/png;base64, " + base64Encoded + "\" class=\"card-img-top \" style = \" height:13rem; \"/>"+
							"<div class = \"card-body \" style = \" background-color:#D4E6E9; \">"+
									"<h4 class = \"card-title\">"+" Marka: " + rs.getString("Urun_Marka") + "</h4>"+
									"<h6 class = \"card-title\">"+" Isim: " + rs.getString("Urun_Isim") + "</h6>"+
									"<p class = \"card-subtitle text-muted\">" +" Stok: "+ rs.getString("Urun_Stok") + "</p>"+
									"<p class = \"card-subtitle text-muted\">"+" Fiyat: "+ rs.getString("Urun_Fiyat") + "</p>"+
								"</div>"
							+"</div>"
							+"</div>"
							+"</div>";

			}

		} catch (Exception e) {
		}
		return icerik;
	}

	// HENÜZ DENENMEDÝ
	public String KasaHasýlatTable(String date) {

		String query, icerik = "";
		icerik += "<table><tr><th>Kasa Id</th><th>Kasa Durum</th><th>Kasa Tip</th><th>Acilis Tarih</th><th>Kapanis Tarih</th><th>Gunlukk Satis</th><th>Gunluk Iade</th><th>Total</th><th>Personel Isim</th><th>PersonelSoyisim</th>";
		int i = 0;
		double satis, iade, total;

		
		if(date.equals("GETDATE()")){
			date = "'"+ d.toString()+"'";
		}
		try {
			Statement st = con.createStatement();
			query = "select * from Kasa_Table, Personel_Table where Kasa_Personel_Id = Personel_Id";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				satis = KasaHasýlatSatisTable(rs.getString("Kasa_Id"), date);
				iade = KasaHasýlatIadeTable(rs.getString("Kasa_Id"), date);
				total = satis - iade;
				
				icerik += "<tr id='GunlukHasilat" + i + "' onclick='KasaDetayGoster(" + i + ")'>  " + 
						"<td id='Kasa_Id" + i + "'>" + rs.getString("Kasa_Id") + "</td>" + 
						"<td id='Kasa_Durum" + i + "'>" + rs.getString("Kasa_Durum") + "</td>" +
						"<td id='Kasa_Tip" + i + "'>" + rs.getString("Kasa_Tip") + "</td>" + 
						"<td id='Kasa_Acilis_Tarih" + i + "'>" + rs.getString("Kasa_Acilis_Tarih") + "</td>" + 
						"<td id='Kasa_Kapanis_Tarih" + i + "'>" + rs.getString("Kasa_Kapanis_Tarih") + "</td>" + 
						"<td id='Kasa_Satis" + i + "'>" + satis + "</td>" + 
						"<td id='Kasa_Iade" + i + "'>" + iade + "</td>" + 
						"<td id='Kasa_Total" + i + "'>" + total + "</td>" + 
						"<td id='Personel__Isim" + i + "'>" + rs.getString("Personel__Isim") + "</td>" +
						"<td id='Personel_SoyIsim" + i + "'>" + rs.getString("Personel_SoyIsim") + "</td>" + "</tr>";

				i++;
			}
			icerik += "</table>";
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return icerik;
	}

	public double KasaHasýlatSatisTable(String kasaId, String date) {

		System.out.print("date = "+date);
		String query, Urunbarkod = "";
		double SatisHesap = 0;
		try {
			Statement st = con.createStatement();
			query = "select * from Kasa_Table kt, Satis_Table st where Kasa_Id = "+kasaId+" and st.Satis_Durum = 'S' and Kasa_Id =st.Satis_Kasa_Id and Satis_Tarih = "+date;
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Urunbarkod = rs.getString("Satis_Urun_Barkod");
				SatisHesap += Double.valueOf(FiyatBul(Urunbarkod));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "hatakodu 2");
		}
		return SatisHesap;
	}

	public double KasaHasýlatIadeTable(String kasaId, String date) {

		String query, Urunbarkod = "";
		double IadeHesap = 0;
		try {
			Statement st = con.createStatement();
			query = "select * from Iade_Table where Iade_Tarih = "+ date +" and Iade_Kasa_Id = " + kasaId;
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				Urunbarkod = rs.getString("Iade_Urun_Barkod");
				IadeHesap += Double.valueOf(FiyatBul(Urunbarkod));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "harakodu 3");
		}
		return IadeHesap;
	}

	public String FiyatBul(String Barkod) {
		
		String Fiyat = "", query;

		try {
			Statement st = con.createStatement();
			query = "select * from Urun_Table where Urun_Barkod = '"+ Barkod +"'";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Fiyat = rs.getString("Urun_Fiyat");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ürünün fiyat deðeri buolunamadý");
		}
		return Fiyat;
	}
	
	
	
	
	
	
	
	
	
	public String KasaDetayliHasýlatSatisTable(String kasaId, String date) {

		System.out.print("date = "+date);
		String query, icerik = "";
		if(date.equals("GETDATE()")){
			date = "'"+ d.toString()+"'";
		}
		icerik += "<table><tr><th>Satis Id</th><th>Urun Barkod</th><th>Musteri Id</th><th>Fis  Id</th><th>Durum</th><th>Tarih</th><th>Kasa Id</th>";
		try {
			Statement st = con.createStatement();
			query = "select * from Kasa_Table kt, Satis_Table st where Kasa_Id = "+kasaId+" and st.Satis_Durum = 'S' and Kasa_Id =st.Satis_Kasa_Id and Satis_Tarih = "+date;
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				icerik += "<tr>" + 
						"<td>" + rs.getString("Satis_Id") + "</td>" + 
						"<td>" + rs.getString("Satis_Urun_Barkod") + "</td>" +
						"<td>" + rs.getString("Satis_Musteri_Id") + "</td>" +
						"<td>" + rs.getString("Satis_Fis_Id") + "</td>" +
						"<td>" + rs.getString("Satis_Durum") + "</td>" +
						"<td>" + rs.getString("Satis_Tarih") + "</td>" +
						"<td>" + rs.getString("Satis_Kasa_Id") + "</td>" +
						 "</tr>";

			}
			icerik += "</table>";

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "hatakodu 2");
		}
		return icerik;
	}

	public String KasaDetayliHasýlatIadeTable(String kasaId, String date) {

		String query, icerik = "";
		icerik += "<table><th>Iade Id</th><th>Urun Barkod</th><th>Kasa Id</th><th>Fis Id</th><th>Tarih</th><th>Musteri Id</th>";
		if(date.equals("GETDATE()")){
			date = "'"+ d.toString()+"'";
		}
		try {
			Statement st = con.createStatement();
			query = "select * from Iade_Table where Iade_Tarih = "+ date +" and Iade_Kasa_Id = " + kasaId;
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				icerik += "<tr>" + 
						"<td>" + rs.getString("Iade_Id") + "</td>" + 
						"<td>" + rs.getString("Iade_Urun_Barkod") + "</td>" +
						"<td>" + rs.getString("Iade_Kasa_Id") + "</td>" +
						"<td>" + rs.getString("Iade_Fis_No") + "</td>" +
						"<td>" + rs.getString("Iade_Tarih") + "</td>" +
						"<td>" + rs.getString("Iade_Musteri_Id") + "</td>" +
						 "</tr>";
			}
			icerik += "</table>";
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "harakodu 3");
		}
		return icerik;
	}

	
	
	public String KasaOlustur (String Personel_Id, String KasaType) {

		String query = "INSERT INTO  Kasa_Table (Kasa_Durum, Kasa_Personel_Id, Kasa_Tip, Kasa_Acilis_Tarih,\r\n"
				+ "Kasa_Kapanis_Tarih, Kasa_Port_Barkod, Kasa_Port_KartOkuyucu) \r\n"
				+ "VALUES (?, ?, ?, GETUTCDATE(), GETUTCDATE(), ?, ?)";
  
		try {
			Connection con = null;
			con = dbConn.getConnection_Magza_DB();
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, "Pasif");
			ps.setString(2, Personel_Id);
			ps.setString(3, KasaType);
			ps.setString(4, "COM4");
			ps.setString(5, "COM5");

			ps.executeUpdate();
			return "1";

		} catch (Exception ex) {
			return "0";
		}
	}
	
	
	
	public String PersonelKasaGetir() {

		Connection con;
		String query, icerik = "";
		Statement st;
		ResultSet rs;

		query = "select * from Kasa_Table";

		try {
			con = dbConn.getConnection_Magza_DB();
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {

				icerik += "<option value=\" "+ rs.getString("Kasa_Id") + " \">"+ rs.getString("Kasa_Id") +"</option>";

			}
			
		} catch (Exception e) {
		}
		return icerik;
	}
	
	public String PersonelKasaDurumListele() {

		Connection con;
		String query, icerik = "";
		Statement st;
		ResultSet rs;
		icerik += "<table><th>Kasa ID</th><th>Durum</th><th>Tip</th>";
		query = "select * from Kasa_Table";

		try {
			con = dbConn.getConnection_Magza_DB();
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {

				icerik += "<tr>" + 
						"<td>" + rs.getString("Kasa_Id") + "</td>" + 
						"<td>" + rs.getString("Kasa_Durum") + "</td>" +
						"<td>" + rs.getString("Kasa_Tip") + "</td>" + 
						 "</tr>";

			}
			icerik += "</table>";
		} catch (Exception e) {
		}
		return icerik;
	}
	
	public String PersonelKasaDurumGuncelle (String KasaId, String Durum) {
		
		String query = "UPDATE Kasa_Table SET Kasa_Durum = ?   WHERE Kasa_Id = ?";

		try {
			Connection con = null;
			con = dbConn.getConnection_Magza_DB();
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, Durum);
			ps.setString(2, KasaId);
			ps.executeUpdate();
			return "1";
		} catch (Exception ex) {
			return "0";
		}
	}
	
	
	
	public String[]PersoneliBilgiGetir(String Personel_Id) {

		String[] result = new String[9];
		String query;

		try {
			query = "SELECT * FROM Personel_Table WHERE Personel_Id = " + Personel_Id;

			Connection con = null;
			con = dbConn.getConnection_Magza_DB();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				result [0] = rs.getString("Personel_Id");
				result [1] = rs.getString("Personel__Isim");
				result [2] = rs.getString("Personel_SoyIsim");
				result [3] = rs.getString("Personel_Cinsiyet");
				result [4] = rs.getString("Personel_Telefon");
				result [5] = rs.getString("Personel_Adres");
				result [6] = rs.getString("Personel_Egitim_Duzey");
				result [7] = rs.getString("Personel_Mail");
				result [8] = rs.getString("Personel_Sifre_Degis_Parola");
				

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return result;
	}
	
	
	public String PersonelBilgiGuncelle(String Personel_Id, String Personel__Isim, String Personel_SoyIsim, String Personel_Cinsiyet,
			String Personel_Telefon, String Personel_Adres, String Personel_Egitim_Duzey, String Personel_Mail, String Personel_Sifre_Degis_Parola) {
		
		String query = "UPDATE Personel_Table SET Personel__Isim = ? , Personel_SoyIsim = ? , Personel_Cinsiyet = ? , \r\n"
				+ "Personel_Telefon = ? , Personel_Adres = ? , Personel_Egitim_Duzey = ? , \r\n"
				+ "Personel_Mail = ? , Personel_Sifre_Degis_Parola = ? WHERE Personel_Id = ?";
		System.out.print(Personel_Id);
		System.out.print(Personel__Isim);
		System.out.print(Personel_SoyIsim);
		System.out.print(Personel_Cinsiyet);
		System.out.print(Personel_Telefon);
		System.out.print(Personel_Adres);
		System.out.print(Personel_Egitim_Duzey);
		System.out.print(Personel_Mail);
		try {
			Connection con = null;
			con = dbConn.getConnection_Magza_DB();
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, Personel__Isim);
			ps.setString(2, Personel_SoyIsim);
			ps.setString(3, Personel_Cinsiyet);
			ps.setString(4, Personel_Telefon);
			ps.setString(5, Personel_Adres);
			ps.setString(6, Personel_Egitim_Duzey);
			ps.setString(7, Personel_Mail);
			ps.setString(8, Personel_Sifre_Degis_Parola);
			ps.setString(9, Personel_Id);
			

			ps.executeUpdate();
			return "1";

		} catch (Exception ex) {
			return "0";
		}
	}

	

	public String PersonelParolaGuncelle (String GuncelParola, String YeniParola, String Personel_Id) {

		String result = "0";
		String query, Personel_Sifre = "";

		try {
			query = "SELECT * FROM Personel_Table WHERE Personel_Id = "+ Personel_Id;

			Connection con = null;
			con = dbConn.getConnection_Magza_DB();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Personel_Sifre = rs.getString("Personel_Sifre");
			}
			if(GuncelParola.equals(Personel_Sifre)) {
				if(PersonelParolaGuncelleTable(YeniParola, Personel_Id)) {
				result = "1";
			}}
			
			else {
				result = "0";// dopru þifre girilmemiþ demektir -  bunu frontend kýsmýnda da kontrol ediyorum zaten
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			result = "0";
		}

		return result;
	}
	
	public boolean PersonelParolaGuncelleTable (String YeniParola, String Personel_Id) {
		
		String query = "UPDATE Personel_Table SET Personel_Sifre = ?   WHERE Personel_Id = ?";

		try {
			Connection con = null;
			con = dbConn.getConnection_Magza_DB();
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, YeniParola);
			ps.setString(2, Personel_Id);
			ps.executeUpdate();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
		
	public String PersonelIletisimListele() {

		String query, icerik = "";
		int i = 0;
		icerik += "<table><tr><th>Id</th><th>Tipi</th><th>Onem Seviyesi</th><th>Konu</th><th>Personel Id</th><th>Tarih</th>";
		try {
			Statement st = con.createStatement();
			query = "select TOP 10 * from Iletisim_Table where Iletisim_Durum = 'Deðerlendiriliyor'";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				
				icerik += "<tr id='Iletisim" + i + "' onclick='IletisimDetayGoster(" + i + ")'>" + 
						"<td id='Iletisim_Id" + i + "'>" + rs.getString("Iletisim_Id") + "</td>" + 
						"<td id='Iletisim_Tur" + i + "'>" + rs.getString("Iletisim_Tur") + "</td>" +
						"<td id='Iletisim_Onem" + i + "'>" + rs.getString("Iletisim_Onem") + "</td>" +
						"<td id='Iletisim_Konu" + i + "'>" + rs.getString("Iletisim_Konu") + "</td>" +
						"<td id='Iletisim_Persone_Id" + i + "'>" + rs.getString("Iletisim_Persone_Id") + "</td>" +
						"<td id='Iletisim_Tarih" + i + "'>" + rs.getString("Iletisim_Tarih") + "</td>" +
						 "</tr>";
				i++;
			}
			icerik += "</table>";
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "harakodu 3");
		}
		return icerik;
	}
	
	
	
	public String PersonelIletisimDetayListele(String IletisimId) {

		String query, icerik = "";
		System.out.append(IletisimId);
		icerik += "<table>";
		try {
			Statement st = con.createStatement();
			query = "select * from Iletisim_Table where Iletisim_Id = "+ IletisimId ;
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				byte[] image = rs.getBytes("Iletisim_Gorsel");
				String base64Encoded = new String(Base64.encodeBase64(image), "UTF-8");
				
				icerik += "<tr style = \" padding-top:2%;\">"
						+ "	<td><label>Id :</label></td>\r\n"
						+ "	<td><label id = \" Iletisim_Id \">" + rs.getString("Iletisim_Id") + "</label></td> \r\n"
						+ "</tr>"
						+ "<tr style = \" padding-top:2%;\">"
						+ "	<td><label>Onem Seviyesi:</label></td>\r\n"
						+ "	<td><label id = \" Iletisim_Onem \">" + rs.getString("Iletisim_Onem") + "</label></td> \r\n"
						+ "</tr>"
						+ "<tr style = \" padding-top:2%;\">"
						+ "	<td><label>Tip:</label></td>\r\n"
						+ "	<td><label id = \" Iletisim_Tur \">" + rs.getString("Iletisim_Tur") + "</label></td> \r\n"
						+ "</tr>"
						+ "<tr style = \" padding-top:2%;\">"
						+ "	<td><label>Durum:</label></td>\r\n"
						+ "	<td><label id = \" Iletisim_Durum \">" + rs.getString("Iletisim_Durum") + "</label></td> \r\n"
						+ "</tr>"
						+ "<tr style = \" padding-top:2%;\">"
						+ "	<td><label>Konu:</label></td>\r\n"
						+ "	<td><label id = \" Iletisim_Konu \">" + rs.getString("Iletisim_Konu") + "</label></td> \r\n"
						+ "</tr>"
						+ "<tr style = \" padding-top:2%;\">"
						+ "	<td><label>Tanim:</label></td>\r\n"
						+ "	<td><label id = \" Iletisim_Icerik \">" + rs.getString("Iletisim_Icerik") + "</label></td> \r\n"
						+ "</tr>" 
						+ "<tr>"
						+ "	<td><label>Gorsel:</label></td>\r\n"
						+"<td> <img src=\"data:image/png;base64, " + base64Encoded + "\" height=\"250px\" width=\"250px\" /> </td>" +
						 "</tr>";
			}
			icerik += "</table>";
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "harakodu 3");
		}
		return icerik;
	}
	
	public String IletisimDurumGuncelle (String IletisimId) {
		
		String query = "UPDATE Iletisim_Table SET Iletisim_Durum = 'Duzeltildi'   WHERE Iletisim_Id = ?";

		try {
			Connection con = null;
			con = dbConn.getConnection_Magza_DB();
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, IletisimId);
			ps.executeUpdate();
			return "1";
		} catch (Exception ex) {
			return "0";
		}
	}
	
	
	
	
	
	public String PersonelSifremiUnuttumDogrulama(String Personel_Mail, String SifreDegisimPin, String Id) {
		
		String MusteriId = "", result;
		try {
			String query = "SELECT * FROM Personel_Table WHERE Personel_Id = " + Id + " and Personel_Mail = '"+Personel_Mail+"' and Personel_Sifre_Degis_Parola = '"+SifreDegisimPin+"'";
			
			Connection con = null;
			con = dbConn.getConnection_Magza_DB();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				MusteriId = rs.getString("Personel_Id");

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		if(!MusteriId.equals("")) {
			result = "1";
		}
		else {
			result = "0";
		}
		return result;
	}
	
	public String PersonelParolaUnuttumGuncelle(String Id, String YeniParola) {

		String query = "UPDATE Personel_Table SET Personel_Sifre = ?   WHERE Personel_Id = ?";

		try {
			Connection con = null;
			con = dbConn.getConnection_Magza_DB();
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, YeniParola);
			ps.setString(2, Id);
			ps.executeUpdate();
			return "1";
		} catch (Exception ex) {
			return "0";
		}
	}
	
	
}