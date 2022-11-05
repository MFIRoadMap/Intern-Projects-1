package ManagerFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DB_Connection.dbConn;

public class MusteriSiparisHazirlat {

	dbConn db_conn = new dbConn();
	Connection con = null;

	ArrayList<String> barcodes = new ArrayList<>();
	String MusteriId = "", MusteriIsim = "", MusteriSoyIsim = "", MusteriSifre = "";
	String SatisKartId = "", Satis_Fis_Id, TeslimTime = "";
	double Hesap_Toplami, HesapGoster;

	public String OdemeBaslat(String Kart_Id, String Liste, String TeslimTime, String MusteriId)
			throws ClassNotFoundException {

		con = dbConn.getConnection_Magza_DB();
		SatisKartId = Kart_Id;
		this.TeslimTime = TeslimTime;
		this.MusteriId = MusteriId;

		System.out.println("Liste" + Liste);
		System.out.println("Kart Id" + SatisKartId);
		System.out.println("Time" + TeslimTime);
		System.out.println("Musteri Id" + MusteriId);
		ParseBarkod(Liste); // burada listeyi parse ederek barkodlar� ay�r�yorum ve arraylist'e at�yorum

		String result = OdemeyeYap();
		return result;
	}

	public void ParseBarkod(String Liste) {
		String Barkod = "";
		for (int i = 0; i < Liste.length(); i++) {

			if (Liste.charAt(i) == '-') {

				i++;
				while (Character.isDigit(Liste.charAt(i))) {
					Barkod += Liste.charAt(i);
					i++;
				}
				barcodes.add(Barkod);
				Barkod = "";
			}
		}
	}

	public String OdemeyeYap() {

		double Toplam_Hesap = Urun_Fiyat_Degeri();
		double K_Bakiye = Bakiye_Sorgu(SatisKartId);
		String result = "5";

		System.out.println("hesap" + Toplam_Hesap);
		System.out.println("bakiye" + K_Bakiye);

		if (!barcodes.isEmpty()) {
			// m��terinin bakiyesi kontrol ediliyor �nce
			if (Toplam_Hesap <= K_Bakiye) {
				System.out.println("sat�n al�nabilir");
				// BU KISIMDAN SONRA SATINALMA �LEMLER� GER�EKLE�ECEK

				// �LK OLARAK M�LTER� B�LG�LER�N� ALMAK GEREK�YOR - AYRICA BURADA URUNLER�N STOK
				// B�LG�LER�N� DE G�NCELL�YORUM
				if (MusteriBilgiGetir(SatisKartId)) {
					// Burada sat�s tablosuna giri�leri tamamlad�kta sonra fis tablosuna giri�leri
					// tan�ml�yorum
					if (AlisverisFisTableOlustur()) {
						// Burada m��teri bilgileri sorunsuz �ekildiyse sat�� tablosuna giri�leri
						// olu�turuyorum
						if (StisTableGirisler(SatisKartId)) {
							barcodes.clear();

							// M��teri kart�ndan para eksilt
							if (Kart_Bakiye_Guncelleme()) {
								
								if(SiparisTableOlustur()) {
									
								result = "1";
								}
							}
						}
					}
				}
			} else {
				result = "2";
				// "Bakiyeniz Bu �r�nleri Almaya Yetmemektedir. �r�n ��kar�n Veya Bakiye
				// Y�kleyin "

			}
		} else {
			result = "3"; // urun se�ilmemi�
		}
		return result;
	}

	public boolean MusteriBilgiGetir(String Kart_Id) {
		String query;
		boolean Durum = true;
		try {
			Statement st = con.createStatement();
			query = "select * from Musteri_Table MT, Musteri_Kart_Table MKT where MKT.MKT_Kart_Id = '" + Kart_Id
					+ "' and MKT.MKT_Musteri_Id = MT.Musteri_Id";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				MusteriId = rs.getString("Musteri_Id");
				MusteriIsim = rs.getString("Musteri_Isim");
				MusteriSoyIsim = rs.getString("Musteri_SoyIsim");
				MusteriSifre = rs.getString("Musteri_Sifre");

			}
		} catch (Exception e) {
			Durum = false;
		}
		return Durum;
	}

	// Burada al�nan �r�nler sat�� tablosuna kayd�n� tamamlad�ktan sonra fi�
	// tablosuna kayd�n� tamaml�yorum
	public boolean AlisverisFisTableOlustur() {
		boolean Durum = true;
		String query = "INSERT INTO  Satis_Fis_Table (Satis_Musteri_Id, Satis_Kart_Id, Satis_Toplam_Tutar, Satis_Tarih)"
				+ " VALUES (?, ?, ?, GETDATE())";

		try {

			PreparedStatement ps = con.prepareStatement(query);
			System.out.println();
			ps.setString(1, MusteriId);
			ps.setString(2, SatisKartId);
			ps.setDouble(3, HesapGoster);

			ps.executeUpdate();

			SatisFisNoBulma();
			System.out.println("satis �d" + Satis_Fis_Id);
		} catch (Exception ex) {
			Durum = false;
			// TODO: handle exception
		}
		return Durum;
	}
	// fi� tablosunu olu�turduktan sonra son olu�turukan son fi� numaras�n� al�yorum

	public boolean SatisFisNoBulma() {
		String query;
		boolean Durum = true;
		try {

			Statement st = con.createStatement();
			query = "select top 1 Satis_Fis_Id from Satis_Fis_Table , Musteri_Table  where Musteri_Id =" + MusteriId
					+ " and Musteri_Id = Satis_Musteri_Id order by Satis_Fis_Id DESC";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Satis_Fis_Id = rs.getString("Satis_Fis_Id");

			}
		} catch (Exception e) {
			Durum = false;
		}
		return Durum;
	}

	// Buradasat�� tablosuna al�nan �r�nlerin kayd�n� ekliyorum
	public boolean StisTableGirisler(String Kart_Id) {
		boolean Durum = true;
		String query = "INSERT INTO  Satis_Table (Satis_Urun_Barkod, Satis_Musteri_Id, Satis_Fis_Id, Satis_Durum, Satis_Tarih, Satis_Kasa_Id)"
				+ " VALUES (?, ?, ?, ?, GETDATE(), ?)";
		for (int i = 0; i < barcodes.size(); i++) {
			// B�R AKS�L�K DURUMUNDA D��ER TABLOLARIN DA KAYIT YAPMAMASINI SA�LIYORUM
			// Burada al�nan her �r�n�n stok de�erini de g�ncelliyorum kasaya miktar
			// ekleniyor

			if (UrunTableStok_Guncelle(barcodes.get(i))) {
				try {

					PreparedStatement ps = con.prepareStatement(query);
					System.out.println();
					ps.setString(1, barcodes.get(i));
					ps.setString(2, MusteriId);
					ps.setString(3, Satis_Fis_Id);
					ps.setString(4, "S");
					ps.setString(5, "13");

					ps.executeUpdate();

				} catch (Exception ex) {
					// TODO: handle exception
				}
			} else {
				Durum = false;
			}
		}
		return Durum;
	}

	// SATI� SONRASI �R�N�N STOK DE�ER� AZALTILIYOR
	public boolean UrunTableStok_Guncelle(String Urun_Barkod) {
		String query = "UPDATE  Urun_Table SET Urun_Stok = Urun_Stok - 1 Where Urun_Barkod = ?";
		boolean result = false;
		try {

			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, Urun_Barkod);

			ps.executeUpdate();
			result = true;
		} catch (Exception ex) {
			// TODO: handle exception
		}
		return result;
	}

	// KULLANICININ BAK�YES� AZALTILIYOR (SATI� SONRASINDA)
	public boolean Kart_Bakiye_Guncelleme() {
		boolean Durum = true;
		String query = "UPDATE  Kart_Table SET Kart_Bakiye = Kart_Bakiye - ? Where Kart_Id = ?";
		System.out.println("hesap " + Hesap_Toplami);
		System.out.println("�d " + SatisKartId);
		try {

			PreparedStatement ps = con.prepareStatement(query);
			ps.setDouble(1, Hesap_Toplami);
			ps.setString(2, SatisKartId);

			ps.executeUpdate();

		} catch (Exception ex) {
			Durum = false;
			// TODO: handle exception
		}
		return Durum;
	}

	// -------------------------------------------------------------------------------------------------
	// BURADA �R�NLER�N F�YAT DE�ERLER�N� HESAPLAYARAK KULLANICININ BAK�YES�N�N
	// YET�P YETMEYECE��NE BAKIYORUZ
	public double Urun_Fiyat_Degeri() {

		// kart �d uniq oldu�u i�in sorun ��kmayacakt�r
		String query;
		double Toplam = 0;
		for (int i = 0; i < barcodes.size(); i++) {

			try {

				Statement st = con.createStatement();
				query = "SELECT * FROM Urun_Table WHERE Urun_Barkod = '" + barcodes.get(i) + "'";
				ResultSet rs = st.executeQuery(query);
				while (rs.next()) {
					Toplam += Double.valueOf(rs.getString("Urun_Fiyat"));
				}
			} catch (Exception e) {
			}
		}
		System.out.println("toplam fiyar� = " + Toplam);
		Hesap_Toplami = Toplam;
		HesapGoster = Toplam;
		return Toplam;
	}

	// ALINACAK �R�NLE ���N BAK�YEN�N YET�P YETMEYECE�N� KONTROL ED�YORUZ
	public double Bakiye_Sorgu(String Kart_Id) {

		// kart �d uniq oldu�u i�in sorun ��kmayacakt�r
		String query;
		double K_Bakiye = 0;

		try {

			Statement st = con.createStatement();
			query = "SELECT * FROM Kart_Table WHERE Kart_Id = '" + Kart_Id + "'";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				K_Bakiye = Double.valueOf(rs.getString("Kart_Bakiye"));
			}
		} catch (Exception e) {
		}
		return K_Bakiye;
	}
	
	
	
	public boolean SiparisTableOlustur() {
		
		String date = TeslimTime.substring(0,9);
		String saat = TeslimTime.substring(TeslimTime.length()-5,TeslimTime.length());
		
		System.out.println("Teslim edilme zaman� "+date +" "+ saat);
		
		String query = "INSERT INTO  Siparis_Hazirlat_Table (SHT_MusteriId, SHT_AlimTime, SHT_Durum, SHT_Siparis_Tarih, SFT_FisId)"
				+ " VALUES (?, ?, ?, GETUTCDATE(), ?)";
		
			// B�R AKS�L�K DURUMUNDA D��ER TABLOLARIN DA KAYIT YAPMAMASINI SA�LIYORUM
			// Burada al�nan her �r�n�n stok de�erini de g�ncelliyorum kasaya miktar
			// ekleniyor

				try {

					PreparedStatement ps = con.prepareStatement(query);
					System.out.println();
					ps.setString(1, MusteriId);
					ps.setString(2, date +" "+ saat);
					ps.setString(3, "Haz�rlan�yor");
					ps.setString(4, Satis_Fis_Id);

					ps.executeUpdate();
					return true;
				} catch (Exception ex) {
					// TODO: handle exception
					return false;
				}
			}
		
	}

