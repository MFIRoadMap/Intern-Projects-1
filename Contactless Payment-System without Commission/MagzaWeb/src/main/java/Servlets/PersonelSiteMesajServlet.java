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
 * Servlet implementation class PersonelSiteMesajServlet
 */
@WebServlet("/PersonelSiteMesajServlet")
public class PersonelSiteMesajServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonelSiteMesajServlet() {
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
		
		if (islem.equals("PersonelSiteMesajListele")) {
			
			String result;
			
			result = pi.PersonelSiteMesajListele();
			System.out.print(result);
			pw.print(result);
		
		}
		
		if (islem.equals("PersonelSiteMesajListeleOkunanlar")) {
			
			String result;
			
			result = pi.PersonelSiteMesajListeleOkunanlar();
			System.out.print(result);
			pw.print(result);
		
		}
		
		if (islem.equals("SiteMesajIdListele")) {
			
			String result3;
			
			result3 = pi.SiteMesajIdListele();
			System.out.print(result3);
			pw.print(result3);
		
		}
		if (islem.equals("SiteMesajDurumGuncelle")) {
			
			String MesajId = request.getParameter("MesajId");
			String result2 = pi.SiteMesajDurumGuncelle(MesajId);
			pw.print(result2);
		}
	}

}
