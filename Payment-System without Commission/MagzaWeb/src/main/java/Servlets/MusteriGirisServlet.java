package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ManagerFiles.*;

/**
 * Servlet implementation class MusteriServlet
 */
@WebServlet("/MusteriGirisServlet")
public class MusteriGirisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusteriGirisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MusteriIslem mi = new MusteriIslem();
		String islem = request.getParameter("islem");
		PrintWriter pw = response.getWriter();

		if (islem.equals("GirisKontrol")) {
			String[] dizi = new String[3];

			String MusteriMail = request.getParameter("MusteriMail");
			String MusteriSifre = request.getParameter("MusteriSifre");
			
			dizi = mi.MusteriGirisKontrol(MusteriMail, MusteriSifre);

			String Musteri_Id = dizi[0];
			String Musteri_Isim = dizi[1];
			String Musteri_SoyIsim = dizi[2];
			
			request.getSession().setAttribute("Musteri_Id", Musteri_Id);
			request.getSession().setAttribute("Musteri_Isim", Musteri_Isim);
			request.getSession().setAttribute("Musteri_SoyIsim", Musteri_SoyIsim);

			pw.print(Musteri_Id);

		}

	}

}
