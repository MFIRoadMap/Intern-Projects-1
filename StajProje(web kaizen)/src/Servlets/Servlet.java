package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MenagerFiles.Kaizen_Manager;
import MenagerFiles.PersonelBilgi;

@WebServlet(urlPatterns = "/Servlet", name = "Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// burada sayfaya yönledirme yapmak için belirlediðimiz bir uzantý ismi ile
		// baðlanýyoruz
		String islem = request.getParameter("islem");
		PrintWriter pw = response.getWriter();

		if (islem.equals("Giris")) {
			String[] dizi = new String[2];

			String kontrol = request.getParameter("sicil");
			dizi = PersonelBilgi.PersonelSorgu(kontrol);

			System.out.println(dizi[0]);
			System.out.println("org" + dizi[1]);
			String sonuc = dizi[0];
			String OrgId = dizi[1];

			request.getSession().setAttribute("sicil", kontrol);
			request.getSession().setAttribute("OrgId", OrgId);
			request.getSession().setAttribute("seviye", sonuc);

			// burada session ile veriyi tutuyorum
			// sicili-org-seviyesini

			pw.print(sonuc);// burada sayfaya success olduðunda veriyi gönderiyorum

		}

		else if (islem.equals("Kaizenler")) {

			String sicil = request.getParameter("sicil");
			String tablo = Kaizen_Manager.Kaizen_Personel(sicil);
			System.out.println("sicili geliyor=" + sicil);

			pw.write(tablo);

		}

		else if (islem.equals("Unitemde")) {

			String OrgId = request.getParameter("OrgId");
			String tablo = Kaizen_Manager.Kaizen_Organizasyon(OrgId);
			System.out.println(OrgId);
			pw.write(tablo);

		}

		else if (islem.equals("Istatistik")) {
			System.out.println("ýstatistik sayfasýna hosgeldiniz");
			String org = request.getParameter("OrgId");
			System.out.println(org);
			String gönder = Kaizen_Manager.Kaizen_Ýstatistik(org);
			System.out.println(gönder);
			pw.write(gönder);
		}

		else if (islem.equals("KaizenEkle")) {
			System.out.println("Kaizen ekle");
			String sicil = request.getParameter("sicil");
			String Adý = request.getParameter("KaizenAd");
			String Konu = request.getParameter("KaizenKonu");
			String OrgId = request.getParameter("KaizenOrg");
			String Açýklama = request.getParameter("KaizenAçýklama");

			
			Kaizen_Manager.Kaýzen_Insert(sicil, Adý, Konu, "1", OrgId, Açýklama);

		}

		// buraya seçilen kaizen ýd sini almak için kullanýyorum
		// ara kayýt bölümü gibi
		else if (islem.equals("KaizenDetay")) {

			System.out.println("Kaizen detay");
			String secim = request.getParameter("KaizenId");
			String sicil = request.getParameter("sicil");
			System.out.println("secimi" + secim);
			System.out.println("sicili" + sicil);
			request.getSession().setAttribute("secim", secim);

		} else if (islem.equals("Kaizenislem")) {
			String detay;
			String sicil = request.getParameter("sicil");
			String secim = request.getParameter("secim");
			detay = Kaizen_Manager.Kaýzen_Detay(sicil, secim);
			pw.write(detay);
		}

		else if (islem.equals("KaizenYazGetir")) {
			String güncelle = request.getParameter("secim");
			System.out.println(güncelle);
			request.getSession().setAttribute("yaz", güncelle);
			// baska sayfasa kullanablmek için session ile tutuyorum
			// burada deðiþecek metinleri getirmek için sayfa açýldýðýnda çaðýracaðým
		}

		else if (islem.equals("KaizenYaz")) {
			System.out.println("kaizen güncele çalþtý");
			String Adý = request.getParameter("KaizenAd");
			String Konu = request.getParameter("KaizenKonu");
			String OrgId = request.getParameter("KaizenOrg");
			String Acýklama = request.getParameter("KaizenAçýklama");
			String yaz = request.getParameter("yaz");
			String sicil = request.getParameter("sicil");
			System.out.println("güncellede" + yaz);
			System.out.println("güncellede" + sicil);
			Kaizen_Manager.KaýzenUpdate(Adý, Konu, OrgId, yaz, Acýklama);
			// kaizen ýd sini ("3") önceki sayfaya baðlarken girecek
		}

		else if (islem.equals("KaizenDelete")) {
			System.out.println("silme sayfasý");
			String silinecek = request.getParameter("secim");
			System.out.println(silinecek);
			Kaizen_Manager.Kaýzen_Delete(silinecek);
		}

		// her buton için (mevkisi) farklý deðerleri tutuð sessionlara atayarak
		// yani sayfada çaðýrýyorum
		else if (islem.equals("Buton")) {

			System.out.println("bton");
			String OrgId = request.getParameter("org");
			String seviye = request.getParameter("sev");
			System.out.println(seviye);
			System.out.println(OrgId);
			int dizi[] = new int[8];
			dizi = Kaizen_Manager.ÝstatitikOranYaz(OrgId, seviye);
			request.getSession().setAttribute("olustu", dizi[0]);
			request.getSession().setAttribute("amirOnay", dizi[1]);
			request.getSession().setAttribute("mudurOnay", dizi[2]);
			request.getSession().setAttribute("kaizRehbOnay", dizi[3]);
			request.getSession().setAttribute("kaizMudurOnay", dizi[4]);
			request.getSession().setAttribute("tamamland", dizi[5]);
			request.getSession().setAttribute("reddEdildi", dizi[6]);
			request.getSession().setAttribute("kabulEdildi", dizi[7]);

			request.getSession().setAttribute("organizasSayfa", OrgId);
			request.getSession().setAttribute("seviyeSatfa", seviye);

		}
		// AYNI HATAYI BURADA DA GÖNDERÝYORUM DÝKKAT ET

		else if (islem.equals("tabloAl")) {
			System.out.println("tabloya yaz");
			String OrgId = request.getParameter("organizasSayfa");
			String seviye = request.getParameter("seviyeSatfa");

			System.out.println("org" + OrgId);
			System.out.println("sevi" + seviye);
			// veya direkt jsp sayfasýndan gönderirken stajyer ise org ýd sine göre
			// -1organýzasyon -1 seviye diyerek
			// gönderirsem çalýþýr
			String tablo = Kaizen_Manager.IstatistikTablo(OrgId, seviye);
			pw.write(tablo);
		}

	}

}
