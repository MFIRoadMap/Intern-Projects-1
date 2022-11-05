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
 * Servlet implementation class PersonelIletisimServlet
 */
@WebServlet("/PersonelIletisimServlet")
public class PersonelIletisimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonelIletisimServlet() {
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

		if (islem.equals("IletisimListele")) {

			String result1 = pi.PersonelIletisimListele();
			pw.print(result1);
		}
		

		
		
		if (islem.equals("IletisimDetayListele")) {
			String IletisimDetayId = request.getParameter("Iletisim_Id");
			request.getSession().setAttribute("IletisimDetayId", IletisimDetayId);// kasa detay için kullanlacak
			System.out.print("kasaid " + IletisimDetayId);

		}

		
		
		//Bu kýsýmadam sonrasý detay sayfasý için kullanýlan yapýlar
		
		if (islem.equals("IletisimDetayListele")) {

			String IletisimDetayId = request.getParameter("IletisimDetayId");
			String result2 = pi.PersonelIletisimDetayListele(IletisimDetayId);
			pw.print(result2);
		}
		
		
		if (islem.equals("IletisimDurumGuncelle")) {

			String IletisimDetayId = request.getParameter("IletisimDetayId");
			String result3 = pi.IletisimDurumGuncelle(IletisimDetayId);
			pw.print(result3);
		}
	}

}
