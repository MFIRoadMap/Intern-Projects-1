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
 * Servlet implementation class MusteriBilgiGetirServlet
 */
@WebServlet("/MusteriBilgiGetirServlet")
public class MusteriBilgiGetirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusteriBilgiGetirServlet() {
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
		
		if (islem.equals("MusteriBilgiGetir")) {
			String[] dizi = new String[9];

			String MusteriId = request.getParameter("Musteri_Id");
			
			dizi = mi.MusteriBilgiGetir(MusteriId);
			System.out.print(dizi[6]);
			request.getSession().setAttribute("Musteri_Isim", dizi[1]);
			request.getSession().setAttribute("Musteri_SoyIsim", dizi[2]);
			request.getSession().setAttribute("Musteri_Cinsiyet", dizi[3]);
			request.getSession().setAttribute("Musteri_Telefon", dizi[4]);
			request.getSession().setAttribute("Musteri_Mail", dizi[5]);
			request.getSession().setAttribute("Musteri_Adres", dizi[6]);
			request.getSession().setAttribute("Musteri_Dogum_Tarih", dizi[7]);
			request.getSession().setAttribute("Musteri_Sifre_Degis_Parola", dizi[8]);
			
		}
		
		
		
		
		 if (islem.equals("MusteriBilgiGuncelle")) {
			 
			String state;
			String Musteri_Id = request.getParameter("Musteri_Id");	
			String Musteri_Isim = request.getParameter("Musteri_Isim");
			String Musteri_SoyIsim = request.getParameter("Musteri_SoyIsim");
			String Musteri_Cinsiyet = request.getParameter("Musteri_Cinsiyet");
			String Musteri_Telefon = request.getParameter("Musteri_Telefon");
			String Musteri_Mail = request.getParameter("Musteri_Mail");
			String Musteri_Adres = request.getParameter("Musteri_Adres");
			String Musteri_Sifre_Degis_Parola = request.getParameter("Musteri_Sifre_Degis_Parola");

			System.out.print("Buradan sonrasý "+ Musteri_Id);
			System.out.print(Musteri_Adres);
			System.out.print(Musteri_Mail);
			System.out.print(Musteri_SoyIsim);
			
			state = mi.MusteriBilgiGuncelle(Musteri_Id, Musteri_Isim, Musteri_SoyIsim, Musteri_Cinsiyet, Musteri_Telefon, Musteri_Mail, Musteri_Adres, Musteri_Sifre_Degis_Parola);
			
			pw.print(state);
		}
		 
		 if (islem.equals("MusteriPinGetir")) {
			 
				String Pin = mi.RandomPinUret();
				
				pw.print(Pin);
			}
	}

}
