package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ManagerFiles.MusteriIslem;
import ManagerFiles.MusteriSiparisHazirlat;

/**
 * Servlet implementation class MusteriSiparisVerServlet
 */
@WebServlet("/MusteriSiparisVerServlet")
public class MusteriSiparisVerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusteriSiparisVerServlet() {
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
		MusteriSiparisHazirlat msh = new MusteriSiparisHazirlat();
		
		String islem = request.getParameter("islem");
		PrintWriter pw = response.getWriter();
		
		if (islem.equals("MusteriUrunListele")) {

			String result1 ;
			result1 = mi.MusteriUrunListele();
			pw.print(result1);
			
		}
		
		
		if (islem.equals("MusteriKartlariiGetir")) {
			
			
            String Musteri_Id = request.getParameter("Musteri_Id");
            String result2 = mi.MusteriKartlariListele(Musteri_Id);
            pw.print(result2);

		}
		
		
		
		if (islem.equals("MusteriSiparisHazirlat")) {
			
			
            String SiparisListesi = request.getParameter("Liste");
            String MusteriKartId = request.getParameter("MusteriKartlarim");
            String TeslimTime = request.getParameter("TeslimTime");
            String Musteri_Id = request.getParameter("Musteri_Id");
            String result5 = "";
            try {
				result5 = msh.OdemeBaslat(MusteriKartId, SiparisListesi, TeslimTime, Musteri_Id);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            pw.print(result5);
            
		}
	}

}
