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

		// durum sayfasý için tanýmlamalar
		if (islem.equals("KasaHasilatListele")) {
			System.out.print("geldi buraya");
			String HasilatList;
			// burada sayfa yüklendiðinde bulunulan günün tarihindeki kasa bilgilerini
			// çekiyorum
			HasilatList = pi.KasaHasýlatTable("GETDATE()");
			request.getSession().setAttribute("OzelTarihKasaDurum", "GETDATE()"); // default olarak bulunulan günü
																					// session a kaydediyorum ki belirli;
																					// bir tarih seçilmezse o günün
																					// bilgilerini kullanabileyim
			pw.print(HasilatList);
		}

		if (islem.equals("DetayTarihSecim")) {

			String TarihSeciliHasilatList;
			String OzelTarihKasaDurum = request.getParameter("OzelTarihKasaDurum");
			OzelTarihKasaDurum = "'" + OzelTarihKasaDurum + "'"; // sorguda hata oluþturmasýn diye burada tek týrnak
																	// içinde güncelliyorum
			request.getSession().setAttribute("OzelTarihKasaDurum", OzelTarihKasaDurum); // detay görmek istendiðinde
																							// kullanmak için burada
																							// tarihi güncvelliyorum
			TarihSeciliHasilatList = pi.KasaHasýlatTable(OzelTarihKasaDurum);
			pw.print(TarihSeciliHasilatList);
		}

		if (islem.equals("KasaDetayListele")) {// burada sadece seçilen kasa id deðerii session'a atýyorum ki detay
												// sayfasýnda kullanabileyim.

			String KasaDetayId = request.getParameter("KasaId");
			request.getSession().setAttribute("KasaDetayId", KasaDetayId);// kasa detay için kullanlacak
			System.out.print("kasaid " + KasaDetayId);

		}

		// detay sayfasý için tanýmlamalar

		if (islem.equals("KasaDetayListeleSatis")) {

			String KasaDetayId = request.getParameter("KasaDetayId");
			String OzelTarihKasaDurum = request.getParameter("OzelTarihKasaDurum"); // durum sayfasýnda seçili tarihe //
																					// göre güncelleme yaptýðým için //
																					// burada sorgusuz kullanýyorum //
																					// tarih deðerini
			System.out.print("kasaid= " + KasaDetayId + " , tarih= " + OzelTarihKasaDurum);
			String result1 = pi.KasaDetayliHasýlatSatisTable(KasaDetayId, OzelTarihKasaDurum);
			pw.print(result1);
		}

		if (islem.equals("KasaDetayListeleIade")) {

			String KasaDetayId = request.getParameter("KasaDetayId");
			String OzelTarihKasaDurum = request.getParameter("OzelTarihKasaDurum"); // durum sayfasýnda seçili tarihe //
																					// göre güncelleme yaptýðým için //
																					// burada sorgusuz kullanýyorum //
																					// tarih deðerini
			System.out.print("kasaid= " + KasaDetayId + " , tarih= " + OzelTarihKasaDurum);
			String result2 = pi.KasaDetayliHasýlatIadeTable(KasaDetayId, OzelTarihKasaDurum);
			pw.print(result2);
		}

		
		
		
		
		
		
		
		
		
		
		
		// Kasa Oluþturmak için

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
