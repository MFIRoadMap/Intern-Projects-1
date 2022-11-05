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
 * Servlet implementation class PersonelSifreDegisServlet
 */
@WebServlet("/PersonelSifreDegisServlet")
public class PersonelSifreDegisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonelSifreDegisServlet() {
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
		
		PersonelIslem pi = new PersonelIslem();
		String islem = request.getParameter("islem");
		PrintWriter pw = response.getWriter();

		 if (islem.equals("PersonelParolaDegis")) {
			
			String state;

			String GuncelParola = request.getParameter("GuncelParola");
			String YeniParola = request.getParameter("YeniParola");
			String Personel_Id = request.getParameter("Personel_Id");
			
			state = pi.PersonelParolaGuncelle(GuncelParola, YeniParola, Personel_Id);
			
			pw.print(state);
			
		}
		 
		 if (islem.equals("PersonelParolaUnuttum")) {
				
			String state;

			String PersonelMail = request.getParameter("PersonelMail");
			String SifreDegisimPin = request.getParameter("SifreDegisimPin");
			String Id = request.getParameter("Id");
			System.out.println("paersonel mail: "+ PersonelMail);
			state = pi.PersonelSifremiUnuttumDogrulama(PersonelMail, SifreDegisimPin, Id);
			
			pw.print(state);
		}
		
		 if (islem.equals("PersonelParolaUnuttumGuncelle")) {
				
			String state;

			String YeniParola = request.getParameter("YeniParola");
			String Id = request.getParameter("Id");
			
			state = pi.PersonelParolaUnuttumGuncelle(Id, YeniParola);
			
			pw.print(state);
		}
		
	}

}
