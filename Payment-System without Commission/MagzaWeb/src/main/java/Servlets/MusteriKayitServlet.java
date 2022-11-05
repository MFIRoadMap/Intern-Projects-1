package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ManagerFiles.MusteriIslem;

/**
 * Servlet implementation class MusteriKayitServlet
 */
@WebServlet("/MusteriKayitServlet")
public class MusteriKayitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusteriKayitServlet() {
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
		MusteriIslem mi = new MusteriIslem();
		String islem = request.getParameter("islem");
		PrintWriter pw = response.getWriter();

		 if (islem.equals("MusteriKayitOlustur")) {
			
			String state;

			String Musteri_Isim = request.getParameter("Musteri_Isim");
			String Musteri_SoyIsim = request.getParameter("Musteri_SoyIsim");
			String Musteri_Cinsiyet = request.getParameter("Musteri_Cinsiyet");
			String Musteri_Telefon = request.getParameter("Musteri_Telefon");
			String Musteri_Mail = request.getParameter("Musteri_Mail");
			String Musteri_Adres = request.getParameter("Musteri_Adres");
			String Musteri_Dogum_Tarih = request.getParameter("Musteri_Dogum_Tarih");
			String Musteri_Sifre = request.getParameter("Musteri_Sifre");
			
			state = mi.MusteriKayitOlustur(Musteri_Isim, Musteri_SoyIsim, Musteri_Cinsiyet, Musteri_Telefon, Musteri_Mail, Musteri_Adres, Musteri_Dogum_Tarih, Musteri_Sifre);
			
			pw.print(state);
		}
	}

}
