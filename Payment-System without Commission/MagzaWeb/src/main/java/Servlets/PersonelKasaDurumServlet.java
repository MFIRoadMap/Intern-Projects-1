package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ManagerFiles.PersonelIslem;

/**
 * Servlet implementation class PersonelKasaDurumServlet
 */
@WebServlet("/PersonelKasaDurumServlet")
public class PersonelKasaDurumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonelKasaDurumServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersonelIslem pi = new PersonelIslem();
		String islem = request.getParameter("islem");
		PrintWriter pw = response.getWriter();

		// durum sayfas� i�in tan�mlamalar
		if (islem.equals("KasaHasilatListele")) {
			System.out.print("geldi buraya");
			String HasilatList;
			// burada sayfa y�klendi�inde bulunulan g�n�n tarihindeki kasa bilgilerini
			// �ekiyorum
			HasilatList = pi.KasaHas�latTable("GETDATE()");
			request.getSession().setAttribute("OzelTarihKasaDurum", "GETDATE()"); // default olarak bulunulan g�n�
																					// session a kaydediyorum ki belirli;
																					// bir tarih se�ilmezse o g�n�n
																					// bilgilerini kullanabileyim
			pw.print(HasilatList);
		}

		if (islem.equals("DetayTarihSecim")) {

			String TarihSeciliHasilatList;
			String OzelTarihKasaDurum = request.getParameter("OzelTarihKasaDurum");
			OzelTarihKasaDurum = "'" + OzelTarihKasaDurum + "'"; // sorguda hata olu�turmas�n diye burada tek t�rnak
																	// i�inde g�ncelliyorum
			request.getSession().setAttribute("OzelTarihKasaDurum", OzelTarihKasaDurum); // detay g�rmek istendi�inde
																							// kullanmak i�in burada
																							// tarihi g�ncvelliyorum
			TarihSeciliHasilatList = pi.KasaHas�latTable(OzelTarihKasaDurum);
			pw.print(TarihSeciliHasilatList);
		}

		if (islem.equals("KasaDetayListele")) {// burada sadece se�ilen kasa id de�erii session'a at�yorum ki detay
												// sayfas�nda kullanabileyim.

			String KasaDetayId = request.getParameter("KasaId");
			request.getSession().setAttribute("KasaDetayId", KasaDetayId);// kasa detay i�in kullanlacak
			System.out.print("kasaid " + KasaDetayId);

		}

		// detay sayfas� i�in tan�mlamalar

		if (islem.equals("KasaDetayListeleSatis")) {

			String KasaDetayId = request.getParameter("KasaDetayId");
			String OzelTarihKasaDurum = request.getParameter("OzelTarihKasaDurum"); // durum sayfas�nda se�ili tarihe //
																					// g�re g�ncelleme yapt���m i�in //
																					// burada sorgusuz kullan�yorum //
																					// tarih de�erini
			System.out.print("kasaid= " + KasaDetayId + " , tarih= " + OzelTarihKasaDurum);
			String result1 = pi.KasaDetayliHas�latSatisTable(KasaDetayId, OzelTarihKasaDurum);
			pw.print(result1);
		}

		if (islem.equals("KasaDetayListeleIade")) {

			String KasaDetayId = request.getParameter("KasaDetayId");
			String OzelTarihKasaDurum = request.getParameter("OzelTarihKasaDurum"); // durum sayfas�nda se�ili tarihe //
																					// g�re g�ncelleme yapt���m i�in //
																					// burada sorgusuz kullan�yorum //
																					// tarih de�erini
			System.out.print("kasaid= " + KasaDetayId + " , tarih= " + OzelTarihKasaDurum);
			String result2 = pi.KasaDetayliHas�latIadeTable(KasaDetayId, OzelTarihKasaDurum);
			pw.print(result2);
		}

		
		
		
		
		
		
		
		
		
		
		
		// Kasa Olu�turmak i�in

		if (islem.equals("KasaOlustur")) {

			String KasaType = request.getParameter("KasaType");
			String Personel_Id = request.getParameter("Personel_Id");

			String result3 = pi.KasaOlustur(Personel_Id, KasaType);
			pw.print(result3);
		}

		if (islem.equals("KasaGetir")) {

			String result3 = pi.PersonelKasaGetir();
			pw.print(result3);
		}

		if (islem.equals("KasaDurumListele")) {

			String result4 = pi.PersonelKasaDurumListele();
			pw.print(result4);
		}
		
		
		if (islem.equals("KasaDurumGuncelle")) {
			
			String KasaListele = request.getParameter("KasaListele");
			String DurumGuncelle = request.getParameter("DurumGuncelle");
			String result4 = pi.PersonelKasaDurumGuncelle(KasaListele, DurumGuncelle);
			pw.print(result4);
			
		}

	}
}
