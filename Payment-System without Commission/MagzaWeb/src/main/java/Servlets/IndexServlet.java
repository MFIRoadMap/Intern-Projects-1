package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ManagerFiles.IndexIslem;
import ManagerFiles.MusteriIslem;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
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
		IndexIslem is = new IndexIslem();
		String islem = request.getParameter("islem");
		PrintWriter pw = response.getWriter();
		
		if (islem.equals("Contact")) {

			String ContactIsim = request.getParameter("ContactIsim");
			String ContactSoyIsim = request.getParameter("ContactSoyIsim");
			String ContactMail = request.getParameter("ContactMail");
			String ContactKonu = request.getParameter("ContactKonu");
			String ContactAciklama = request.getParameter("ContactAciklama");
			
			String result1 = is.BizeUlasinTableOlustur(ContactIsim, ContactSoyIsim, ContactMail, ContactKonu, ContactAciklama);
			
			pw.print(result1);
		}
	}

}
