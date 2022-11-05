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
 * Servlet implementation class PersonelBilgilerimServlet
 */
@WebServlet("/PersonelBilgilerimServlet")
public class PersonelBilgilerimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonelBilgilerimServlet() {
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
		
		if (islem.equals("PersonelBilgiGetir")) {
			String[] dizi = new String[9];

			String Personel_Id = request.getParameter("Personel_Id");
			
			dizi = pi.PersoneliBilgiGetir(Personel_Id);
			
			request.getSession().setAttribute("Personel__Isim", dizi[1]);
			request.getSession().setAttribute("Personel_SoyIsim", dizi[2]);
			request.getSession().setAttribute("Personel_Cinsiyet", dizi[3]);
			request.getSession().setAttribute("Personel_Telefon", dizi[4]);
			request.getSession().setAttribute("Personel_Adres", dizi[5]);
			request.getSession().setAttribute("Personel_Egitim_Duzey", dizi[6]);
			request.getSession().setAttribute("Personel_Mail", dizi[7]);
			request.getSession().setAttribute("Personel_Sifre_Degis_Parola", dizi[8]);
			
		}
		
		
		
		
		 if (islem.equals("PersonelBilgiGuncelle")) {
			 
			String state;
			String Personel_Id = request.getParameter("Personel_Id");	
			String Personel__Isim = request.getParameter("Personel__Isim");
			String Personel_SoyIsim = request.getParameter("Personel_SoyIsim");
			String Personel_Cinsiyet = request.getParameter("Personel_Cinsiyet");
			String Personel_Telefon = request.getParameter("Personel_Telefon");
			String Personel_Adres = request.getParameter("Personel_Adres");
			String Personel_Egitim_Duzey = request.getParameter("Personel_Egitim_Duzey");
			String Personel_Mail = request.getParameter("Personel_Mail");
			String Personel_Sifre_Degis_Parola = request.getParameter("Personel_Sifre_Degis_Parola");

			
			state = pi.PersonelBilgiGuncelle(Personel_Id, Personel__Isim, Personel_SoyIsim, Personel_Cinsiyet, Personel_Telefon, Personel_Adres, Personel_Egitim_Duzey, Personel_Mail, Personel_Sifre_Degis_Parola);
			
			pw.print(state);
		}
	}

}
