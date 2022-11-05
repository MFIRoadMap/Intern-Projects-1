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
 * Servlet implementation class MusteriAlisverisGecmisiServlet
 */
@WebServlet("/MusteriAlisverisGecmisiServlet")
public class MusteriAlisverisGecmisiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusteriAlisverisGecmisiServlet() {
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
		
		if (islem.equals("MusteriAlisverisListele")) {
			
			String result1;
			String MusteriId = request.getParameter("Musteri_Id");
			result1 = mi.MusteriAlisverisListele(MusteriId);
			pw.print(result1);
			
		}
		
		if (islem.equals("MusteriAlisverisListeleDetay")) {// burada sadece seçilen fis id deðerii session'a atýyorum ki detay
			// sayfasýnda kullanabileyim.
            String Satis_Fis_Id = request.getParameter("Satis_Fis_Id");
            request.getSession().setAttribute("Satis_Fis_Id", Satis_Fis_Id);// fis numarasý detay için kullanlacak
          
		}
		
		
		//bu kýsým detay sayfasý açýlýþýnda kullanýlacak
		if (islem.equals("MusteriAlisverisListeleDetaySayfasi")) {

			String Satis_Fis_Id = request.getParameter("Satis_Fis_Id");
			String Musteri_Id = request.getParameter("Musteri_Id");
			
			System.out.print("fis id= " + Satis_Fis_Id +"mus id= " + Musteri_Id );
			String result2 = mi.MusteriAlisverisListeleSayfasi(Musteri_Id, Satis_Fis_Id);
			pw.print(result2);
		}
		
		
	}

}
