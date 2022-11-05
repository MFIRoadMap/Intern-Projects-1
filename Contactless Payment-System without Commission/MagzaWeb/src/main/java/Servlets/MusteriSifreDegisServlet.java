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
 * Servlet implementation class MusteriSifreDegisServlet
 */
@WebServlet("/MusteriParolaDegisServlet")
public class MusteriSifreDegisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusteriSifreDegisServlet() {
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

		 if (islem.equals("MusteriParolaDegis")) {
			
			String state;

			String GuncelParola = request.getParameter("GuncelParola");
			String YeniParola = request.getParameter("YeniParola");
			String Musteri_Id = request.getParameter("Musteri_Id");
			
			state = mi.MusteriParolaGuncelle(GuncelParola, YeniParola, Musteri_Id);
			
			pw.print(state);
		}
	
		 
		 if (islem.equals("MusteriParolaUnuttum")) {
				
			String state;

			String MusteriMail = request.getParameter("MusteriMail");
			String SifreDegisimPin = request.getParameter("SifreDegisimPin");
			String Id = request.getParameter("Id");
			
			state = mi.MusteriSifremiUnuttumDogrulama(MusteriMail, SifreDegisimPin, Id);
			
			pw.print(state);
		}
		
		 if (islem.equals("MusteriParolaUnuttumGuncelle")) {
				
			String state;

			String YeniParola = request.getParameter("YeniParola");
			String Id = request.getParameter("Id");
			
			state = mi.MusteriParolaUnuttumGuncelle(Id, YeniParola);
			
			pw.print(state);
		}
		
	}

}
