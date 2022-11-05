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
 * Servlet implementation class PersonelGirisServlet
 */
@WebServlet("/PersonelGirisServlet")
public class PersonelGirisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonelGirisServlet() {
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
		
		if (islem.equals("GirisKontrol")) {
			String[] dizi = new String[4];
			
			String PersonelMail = request.getParameter("PersonelMail");
			String PersonelSifre = request.getParameter("PersonelSifre");
			System.out.print(PersonelSifre);
			dizi = pi.PersonelGirisKontrol(PersonelMail, PersonelSifre);

			String Personel_Id = dizi[0];
			String Personel__Isim = dizi[1];
			String Personel_SoyIsim = dizi[2];
			String Personel_Yetki = dizi[3];
			
			request.getSession().setAttribute("Personel_Id", Personel_Id);
			request.getSession().setAttribute("Personel__Isim", Personel__Isim);
			request.getSession().setAttribute("Personel_SoyIsim", Personel_SoyIsim);
			request.getSession().setAttribute("Personel_Yetki", Personel_Yetki);

			pw.print(Personel_Id);
		}
	}

}
