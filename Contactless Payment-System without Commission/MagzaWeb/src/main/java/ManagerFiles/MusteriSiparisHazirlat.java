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
		ParseBarkod(Liste); // burada listeyi parse ederek barkodlarý ayýrýyorum ve arraylist'e atýyorum

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
			// müþterinin bakiyesi kontrol ediliyor önce
			if (Toplam_Hesap <= K_Bakiye) {
				System.out.println("satýn alýnabilir");
				// BU KISIMDAN SONRA SATINALMA ÝLEMLERÝ GERÇEKLEÞECEK

				// ÝLK OLARAK MÜLTERÝ BÝLGÝLERÝNÝ ALMAK GEREKÝYOR - AYRICA BURADA URUNLERÝN STOK
				// BÝLGÝLERÝNÝ DE GÜNCELLÝYORUM
				if (MusteriBilgiGetir(SatisKartId)) {
					// Burada satýs tablosuna giriþleri tamamladýkta sonra fis tablosuna giriþleri
					// tanýmlýyorum
					if (AlisverisFisTableOlustur()) {
						// Burada müþteri bilgileri sorunsuz çekildiyse satýþ tablosuna giriþleri
						// oluþturuyorum
						if (StisTableGirisler(SatisKartId)) {
							barcodes.clear();

							// Müþteri kartýndan para eksilt
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
				// "Bakiyeniz Bu Ürünleri Almaya Yetmemektedir. Ürün Çýkarýn Veya Bakiye
				// Yükleyin "

			}
		} else {
			result = "3"; // urun seçilmemiþ
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

	// Burada alýnan ürünler satýþ tablosuna kaydýný tamamladýktan sonra fiþ
	// tablosuna kaydýný tamamlýyorum
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
			System.out.println("satis ýd" + Satis_Fis_Id);
		} catch (Exception ex) {
			Durum = false;
			// TODO: handle exception
		}
		return Durum;
	}
	// fiþ tablosunu oluþturduktan sonra son oluþturukan son fiþ numarasýný alýyorum

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

	// Buradasatýþ tablosuna alýnan ürünlerin kaydýný ekliyorum
	public boolean StisTableGirisler(String Kart_Id) {
		boolean Durum = true;
		String query = "INSERT INTO  Satis_Table (Satis_Urun_Barkod, Satis_Musteri_Id, Satis_Fis_Id, Satis_Durum, Satis_Tarih, Satis_Kasa_Id)"
				+ " VALUES (?, ?, ?, ?, GETDATE(), ?)";
		for (int i = 0; i < barcodes.size(); i++) {
			// BÝR AKSÝLÝK DURUMUNDA DÝÐER TABLOLARIN DA KAYIT YAPMAMASINI SAÐLIYORUM
			// Burada alýnan her ürünün stok deðerini de güncelliyorum kasaya miktar
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

	// SATIÞ SONRASI ÜRÜNÜN STOK DEÐERÝ AZALTILIYOR
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

	// KULLANICININ BAKÝYESÝ AZALTILIYOR (SATIÞ SONRASINDA)
	public boolean Kart_Bakiye_Guncelleme() {
		boolean Durum = true;
		String query = "UPDATE  Kart_Table SET Kart_Bakiye = Kart_Bakiye - ? Where Kart_Id = ?";
		System.out.println("hesap " + Hesap_Toplami);
		System.out.println("ýd " + SatisKartId);
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
	// BURADA ÜRÜNLERÝN FÝYAT DEÐERLERÝNÝ HESAPLAYARAK KULLANICININ BAKÝYESÝNÝN
	// YETÝP YETMEYECEÐÝNE BAKIYORUZ
	public double Urun_Fiyat_Degeri() {

		// kart ýd uniq olduðu için sorun çýkmayacaktýr
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
		System.out.println("toplam fiyarý = " + Toplam);
		Hesap_Toplami = Toplam;
		HesapGoster = Toplam;
		return Toplam;
	}

	// ALINACAK ÜRÜNLE ÝÇÝN BAKÝYENÝN YETÝP YETMEYECEÝNÝ KONTROL EDÝYORUZ
	public double Bakiye_Sorgu(String Kart_Id) {

		// kart ýd uniq olduðu için sorun çýkmayacaktýr
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
		
		System.out.println("Teslim edilme zamaný "+date +" "+ saat);
		
		String query = "INSERT INTO  Siparis_Hazirlat_Table (SHT_MusteriId, SHT_AlimTime, SHT_Durum, SHT_Siparis_Tarih, SFT_FisId)"
				+ " VALUES (?, ?, ?, GETUTCDATE(), ?)";
		
			// BÝR AKSÝLÝK DURUMUNDA DÝÐER TABLOLARIN DA KAYIT YAPMAMASINI SAÐLIYORUM
			// Burada alýnan her ürünün stok deðerini de güncelliyorum kasaya miktar
			// ekleniyor

				try {

					PreparedStatement ps = con.prepareStatement(query);
					System.out.println();
					ps.setString(1, MusteriId);
					ps.setString(2, date +" "+ saat);
					ps.setString(3, "Hazýrlanýyor");
					ps.setString(4, Satis_Fis_Id);

					ps.executeUpdate();
					return true;
				} catch (Exception ex) {
					// TODO: handle exception
					return false;
				}
			}
		
	}

