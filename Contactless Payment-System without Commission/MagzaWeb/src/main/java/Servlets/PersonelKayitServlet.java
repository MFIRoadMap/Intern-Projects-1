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
 * Servlet implementation class PersonelKayitServlet
 */
@WebServlet("/PersonelKayitServlet")
public class PersonelKayitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonelKayitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonelIslem pi=new PersonelIslem();
		String islem = request.getParameter("islem");
		PrintWriter pw = response.getWriter();
		
		if (islem.equals("PersonelKayitOlustur")) {
			
			String state;

			
			String Personel__Isim = request.getParameter("Personel__Isim");
			String Personel_SoyIsim = request.getParameter("Personel_SoyIsim");
			String Personel_Cinsiyet = request.getParameter("Personel_Cinsiyet");
			String Personel_Telefon = request.getParameter("Personel_Telefon");
			String Personel_Mail = request.getParameter("Personel_Mail");
			String Personel_Adres = request.getParameter("Personel_Adres");
			String Personel_Egitim_Duzey = request.getParameter("Personel_Egitim_Duzey");
			String Personel_Sifre = request.getParameter("Personel_Sifre");
			String Personel_Sifre_Dogrula = request.getParameter("Personel_Sifre_Dogrula");
			String Personel_Yetki = request.getParameter("Personel_Yetki");
			String Personel_Dogum_Tarih = request.getParameter("Personel_Dogum_Tarih");
			String Personel_Maas = request.getParameter("Personel_Maas");
			
			state = pi.PersonelKayitOlustur(Personel__Isim, Personel_SoyIsim, Personel_Cinsiyet, Personel_Telefon, Personel_Mail, Personel_Adres, Personel_Egitim_Duzey, Personel_Sifre, Personel_Sifre_Dogrula, Personel_Yetki, Personel_Maas, Personel_Dogum_Tarih);
			
			pw.print(state);
		}
		
	}

}
