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
 * Servlet implementation class MusteriKartListeleServlet
 */
@WebServlet("/MusteriKartListeleServlet")
public class MusteriKartListeleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusteriKartListeleServlet() {
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

		if (islem.equals("MusteriKartListele")) {
			
			String result1;
			String Musteri_Id = request.getParameter("Musteri_Id");
			result1 = mi.MusteriKartListele(Musteri_Id);
			pw.print(result1);

		}

		if (islem.equals("MusteriKartlarýmDetayListele")) {
			String SecilenKartDetayId = request.getParameter("SecilenKartDetayId");
			request.getSession().setAttribute("SecilenKartDetayId", SecilenKartDetayId);// kasa detay için kullanlacak
			System.out.print("kasaid " + SecilenKartDetayId);

		}

		
		
		//Bu kýsým  detay sayfasý için kullanýlan yapýlar
		
		if (islem.equals("MusteriKartDetaySayfasi")) {
			String result2;
			String Musteri_Id = request.getParameter("Musteri_Id");
			String SecilenKartDetayId = request.getParameter("SecilenKartDetayId");
			result2 = mi.MusteriKartGecmisiListeleSayfasi(Musteri_Id, SecilenKartDetayId);
			pw.print(result2);
		}
		
		
		//bu kýsým ilgili karta bakiye yüklemek yüklemek için 
		
		if (islem.equals("MusteriKartBakiyeYukle")) {

			String SecilenKartDetayId = request.getParameter("SecilenKartDetayId");
			String BankaKartNo = request.getParameter("BankaKartNo");
			String BankaKartSkt = request.getParameter("BankaKartSkt");
			String BankaKartCvv = request.getParameter("BankaKartCvv");
			String BankaKartSahibiId = request.getParameter("BankaKartSahibiId");
			String BankaYuklenecekBakiye = request.getParameter("BankaYuklenecekBakiye");
			String result3 = mi.BakiyeYüklemeYabanciKartKontrol(SecilenKartDetayId, BankaKartNo, BankaKartSkt, BankaKartCvv, BankaKartSahibiId, BankaYuklenecekBakiye);			
			
			pw.print(result3);
		}
		
		
	}

}
