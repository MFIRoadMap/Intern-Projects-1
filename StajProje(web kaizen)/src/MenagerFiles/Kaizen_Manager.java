package MenagerFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import DB_Connection.Database_Connection;

public class Kaizen_Manager {
	public static Connection con ;
	public  static String kaýzId="";
	public static String ýslemGüncelleId="";
	public static String ýslemDeleteId="";
	
	
	
	 public static String Kaizen_Organizasyon(String P_ORG_ID  ) {
		 
		     Connection con=null;
		        String sorguOrgBilg=null;
		        Statement st=null;
		        ResultSet rs=null;
                
		    	int i=0;
		    	String döndür;
		    
                //burada organizasyondaki çeþitli seviyeler için birleþtirme yapýyrum ona göre sorguyu belirliyorum
		    	if(P_ORG_ID.equals("1") || P_ORG_ID.equals("2") || P_ORG_ID.equals("3") || P_ORG_ID.equals("4") ) {
		    		   sorguOrgBilg ="SELECT *  FROM KAIZEN_ORGANIZASYON_TBL O , KAIZEN_KAIZEN_TBL K  WHERE\r\n" + 
		    		   		"(O.O_ID=K.K_ORG_ID) AND( (O.O_ID=1)OR (O.O_ID=2)OR (O.O_ID=3)OR (O.O_ID=4)) ";
		    		
		    	}
		    	else if(P_ORG_ID.equals("5") || P_ORG_ID.equals("6") || P_ORG_ID.equals("7") || P_ORG_ID.equals("8")) {
		    		   sorguOrgBilg ="SELECT *  FROM KAIZEN_ORGANIZASYON_TBL O , KAIZEN_KAIZEN_TBL K  WHERE\r\n" + 
		    		   		"(O.O_ID=K.K_ORG_ID) AND( (O.O_ID=5)OR (O.O_ID=6)OR (O.O_ID=7)OR (O.O_ID=8)) ";
		    		
		    	}
		    	
		    	
		    	döndür="<table id='ünitem'><tr><th>K ID</th><th>KAIZEN ADI</th><th>KAIZEN KONU</th>"
		         		+ "<th>K BASVR TRH</th><th>KAIZEN ACIKLAMA</th>";
		            
		      
              //1.koþul ayný org kaizenleri getirmek için
		        //2. koþul ayný organizasyondaki kiþileri getirmek için
		        //3. koþul org ýd si belirlemek için
		        //burada giriþ yapan kiþinin org numarasýný alarak yaný organizasyonaki kaizen i olan çalýþanlarýn bilgilerini aldým
		        
		 try {
			 con = Database_Connection.getConnection_Kaizen_Db();
			 st = con.createStatement();
		     rs = st.executeQuery(sorguOrgBilg);
			 
		    while (rs.next()) {

		    	
              döndür+="<tr> <td>"+rs.getString("K_ID")+"</td>"+
					       "<td>"+rs.getString("K_ADI")+"</td>"+
					       "<td>"+rs.getString("K_KONU")+"</td>"+
					       "<td>"+rs.getString("K_BASV_TARH")+"</td>"+
					       "<td>"+rs.getString("K_AÇIKLAMA")+"</td>"+
					     
					                                                            "</tr>";
                 i++;
		           
		    }
		            döndür+="</table>";
                     System.out.println(döndür);
		} catch (Exception e) {
			// TODO: handle exception
		}

			return döndür;
		}
	 
	 public static String Kaizen_Personel(String P_SICIL ) {
		
		     Connection con=null;
		        String sorguKaizen=null;
		        Statement st=null;
		        ResultSet rs=null;
		        String döndür=null;
		        int i=0;

		    	
		         
		         döndür="<table id='tablo'><tr><th>ID</th><th>ADI</th><th>KONU</th><th>BASVURU TRH</th><th>TAMAMLANMA TRH</th>"
		         		+ "<th>SON HAREKET TRH</th><th>SON HAREKET ID</th><th>RED TARIHI</th>";
		            
		    	 sorguKaizen ="SELECT *  FROM  KAIZEN_KAIZEN_TBL K ,KAIZEN_PERSONEL_TBL P ,KAIZEN_ISLEM_TBL I ,KAIZEN_DURUM_TBL D WHERE "
		    	 		+ "(P.P_SICIL="+P_SICIL+") AND	(I.I_SICIL_ID=P.P_SICIL) AND (I.I_KAIZ_ID=K.K_ID)  AND (D.D_ID=I.I_DURUM_ID)";

		 try {//burada bean sayfalarýna atýyorum
			 con = Database_Connection.getConnection_Kaizen_Db();
			 st = con.createStatement();
		     rs = st.executeQuery(sorguKaizen);
			 
		    while (rs.next()) {
	    döndür+="<tr id='satýr"+i+"' onclick='yazSayfa("+i+")'>  <td id='KaizenId"+i+"'>"+rs.getString("K_ID")+"</td>"+
						       "<td id='KaizenAdý"+i+"'>"+rs.getString("K_ADI")+"</td>"+
						       "<td id='KaizenKonu"+i+"'>"+rs.getString("K_KONU")+"</td>"+
						       "<td id='KaizenBasvTarh"+i+"'>"+rs.getString("K_BASV_TARH")+"</td>"+
						       "<td id='KaizenTamamTarh"+i+"'>"+rs.getString("K_TAMAM_TARH")+"</td>"+
						       "<td id='KaizenSonHrktTarh"+i+"'>"+rs.getString("K_SON_HARK_TARH")+"</td>"+
						       "<td id='KaizenSonHrktId"+i+"'>"+rs.getString("K_SON_HARK_ID")+"</td>"+
						       "<td id='KaizenRedTarh"+i+"'>"+rs.getString("K_RED_TARH")+"</td>"+
						                                  "</tr>";
				 i++;
		           
		    }
		    döndür+="</table>";
              System.out.println(döndür);
		     
		} catch (Exception e) {
			// TODO: handle exception
		}

			return döndür;
		}


	 
	 
	 public static void Kaýzen_Insert(String P_SICIL , String K_ADI , String K_KONUSU ,String K_SON_HARK_ID , String K_ORG_ID,String K_Açýklama ) {
		 
		 
	    	PreparedStatement ps;
	    	String baslangýc,sorguKaýzen;
	    	Date d;
	        SimpleDateFormat ft2;
	    	
	   
	    	//false ile doludur boþ býrakýlýnca kayýt yapmýyor
	   if(bosMuEkle(P_SICIL, K_ADI, K_KONUSU, K_SON_HARK_ID, K_ORG_ID, K_Açýklama)==false) {
	    	 d= new Date();
	         ft2=new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
	         System.out.println(ft2.format(d)) ;
	    	
	    	baslangýc="0001.01.01 00:00:00";
	    	//DAHA SONRA DÜZELTME YAPARKEN KOLAYLIK OLSUN DÝYE BURADA TUUTUM BASLANGIÇÇ DEÐERÝNÝ
	    	
	    	con = Database_Connection.getConnection_Kaizen_Db();
	    	 sorguKaýzen="INSERT INTO  KAIZEN_KAIZEN_TBL (K_ADI, K_KONU, K_BASV_TARH, K_TAMAM_TARH, K_SON_HARK_TARH, K_SON_HARK_ID, K_ORG_ID, K_RED_TARH,K_AÇIKLAMA,K_P_SICIL) VALUES \r\n" + 
		         		"(?, ?, TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS'), \r\n" + 
		         		"TO_TIMESTAMP(?,'YYYY-MM-DD HH24:MI:SS'),\r\n" + 
		         		"TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS'),\r\n" + 
		         		"?, ?, TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS'),?,?)";
		        
	    	try {
	    		
	    		//buraya þimdiki zaman için metot kullanýcam basvuru ve son hareket tarihleri çin 
	    		//kalanlarý 01 olarak göndericem 
	    		
	    		  ps = con.prepareStatement(sorguKaýzen);
			      
	    		  System.out.println(K_ADI);
	    		    ps.setString(1, K_ADI);
	    		    System.out.println(K_KONUSU);
			        ps.setString(2, K_KONUSU);
			        System.out.println(ft2.format(d));
			        ps.setString(3, ft2.format(d));
			        System.out.println(baslangýc);
			        ps.setString(4, baslangýc);
			        System.out.println( ft2.format(d));
			        ps.setString(5, ft2.format(d));
			        System.out.println(K_SON_HARK_ID);
			        ps.setString(6, K_SON_HARK_ID);
			        System.out.println(K_ORG_ID);
			        ps.setString(7, K_ORG_ID);
			        System.out.println(baslangýc);
			        ps.setString(8, baslangýc);
			        System.out.println(K_Açýklama);
			        ps.setString(9, K_Açýklama);
			        System.out.println(P_SICIL);
	                ps.setString(10, P_SICIL);
			       
	    		ps.executeUpdate();
	    		
	    		
	    		JOptionPane.showMessageDialog(null, "kaizen tabosu oluþturuldu");
	    		
	    		
	    		//burada kaýzn ýn ýd sýný bulup ýslem table ye koyacaðým
	    		//bunu ayný metotta altýna iþlem ve durum tablolarýný doldurabilmek için yapýyorum
	    		kaýzIdBul(K_ADI,K_KONUSU,K_Açýklama,K_ORG_ID,P_SICIL);
	    		
	    		//burada ýslem ve durum tablolarý için gereken deðerler atýyorum 
	    		kaýzenIslemTablosu(P_SICIL);
	    		
	    		
			} catch (Exception ex) {
				 JOptionPane.showMessageDialog(null, ex.getMessage());
				// TODO: handle exception
			}
	    	
	   }
	   else {
		   JOptionPane.showMessageDialog(null, "lütfen bos býrakmayýnýz");
	   }
	    	
	    	
	 }
	 
	 public static boolean bosMuEkle(String P_SICIL , String K_ADI , String K_KONUSU ,String K_SON_HARK_ID , String K_ORG_ID,String K_Açýklama) {
		 boolean dolu=true;
		 if(P_SICIL!=null && !K_ADI.equals("") && !K_KONUSU.equals("") && !K_SON_HARK_ID.equals("")  && !K_ORG_ID.equals("") &&  !K_Açýklama.equals("")) {
	        	dolu=false;
	        }
		 return dolu;
	 }
	 //Burada ýslem tablosuna gereken itemleri giriyorum
	 //durum tablosuna 1 yaný oluþturuldu durumunu atýyorum
	 public static void kaýzenIslemTablosu(String I_Sýcýl) {
		 String sorguIslem;
		 PreparedStatement ps;
       Date d;
       SimpleDateFormat ft2;

		 
		 d= new Date();
       ft2=new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
       System.out.println(ft2.format(d)) ;
       String durum="1";
       System.out.println( kaýzId);
       sorguIslem="INSERT INTO KAIZEN_ISLEM_TBL (I_SICIL_ID, I_KAIZ_ID, I_DURUM_ID, I_OPER_SAAT) VALUES " + 
      	 		"(?, ?, ?, TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS'))";
	    		
     
     try {
      	 
	    		  ps = con.prepareStatement(sorguIslem);
	    		  ps.setString(1, I_Sýcýl);
	    		  ps.setString(2, kaýzId);
	    		  ps.setString(3, durum);
	    		  ps.setString(4, ft2.format(d));
	    		  
	    		ps.executeUpdate();
	    		
	    		JOptionPane.showMessageDialog(null, "iþlem tablosu oluþturuldu");
	    		
	    		
			} catch (Exception ex) {
				 JOptionPane.showMessageDialog(null, ex.getMessage());
				// TODO: handle exception
			}
		 
		 
	 }
	 //EÐER BAÞVURU TARÝHÝNÝ DE EKLERSEM TAM ANLAMIYLA OLACAK
	 public static void kaýzIdBul(String K_ADI,String K_KONU,String K_Açýklama,String K_ORG_ID,String P_SICILARA) {
		 
		 String sorguIdBulma;
		 Statement st;
	        ResultSet rs;
		 
		 //KAIZEN ADINI UNÝQUE KOYDUM KÝ ID SINE ULAÞABÝLMEK ÝÇÝN
		 sorguIdBulma="SELECT * FROM KAIZEN_KAIZEN_TBL WHERE (K_ADI='" + K_ADI + "') AND (K_KONU='" + K_KONU + "') AND "
		 		+ "(K_AÇIKLAMA='" + K_Açýklama + "') AND (K_ORG_ID='" + K_ORG_ID + "') AND (K_P_SICIL='" + P_SICILARA +"')";
	      try {
			
	    	 st = con.createStatement();
		     rs = st.executeQuery(sorguIdBulma);
		     
		     while (rs.next()) {
		    	
		    	 kaýzId=rs.getString("K_ID");
		    	
		     }

		     
		     
		} catch (Exception e) {
			// TODO: handle exception
		}
	     
	 }

	 
	 
	 
	 
	 
	 
	 //GÖNDERÝRKEN DEÐÝÞECEK OLANI DEÐÝÞTÝRÝYORUM (ID DIÞINDA)DÝÐERLERÝ NULL GÖNDERÝYORUM
	 //son olarak ýslem tablosundaki saati d deðiþtireceðim
	 public static void KaýzenUpdate( String K_ADI ,String K_KONUSU,String K_ORG_ID , String K_ID,String K_ACIKLAMA) {
		  
		  Connection con;
		  PreparedStatement ps ;
		  String sorguHepsi;
		  
		  
		  
	  
		 con=Database_Connection.getConnection_Kaizen_Db();
		  
		    //false döüyorsa girer
		 if(bosMuGüncelle( K_ADI, K_KONUSU, K_ORG_ID, K_ID, K_ACIKLAMA)==false) {
			 
			  try {

				  sorguHepsi="UPDATE KAIZEN_KAIZEN_TBL SET  K_ADI=?,K_KONU=?,K_Org_ID=?,K_AÇIKLAMA=? WHERE K_ID=?";

	  		  ps = con.prepareStatement(sorguHepsi );
	  		  
	  		  ps.setString(1, K_ADI);
	  		  ps.setString(2, K_KONUSU);
	  		  ps.setString(3, K_ORG_ID);
	  		  ps.setString(4, K_ACIKLAMA);
	  		  ps.setString(5, K_ID);
	  		  
	  		  
	  		ps.executeUpdate();
	  			 System.out.println( "tamamlandý");
	  			 
	  			 
	  			
	  			
	  		  
			} catch (Exception ex) {
				 JOptionPane.showMessageDialog(null, ex.getMessage());    		
			}
			   }
		 
		 else {
			 JOptionPane.showMessageDialog(null, "Boþ alan býraktýnýz Kayýt  Yapýlmadý");
		 }
		 islemGüncelle(K_ID);//tarihi güncelleyemiyotum daha sonra bakacam
		 
		
		  }
	
	 public static void islemGüncelle(String K_ID) {
		 
	  kaýzIdBulIslem(K_ID);//kaizen tablosundan ýd ve islem  ýd sini bulup gllobal atýyorum buluyor
		 
		 String sorguIslem;
		 PreparedStatement ps;
       Date d;
       SimpleDateFormat ft2;

		 
		 d= new Date();
       ft2=new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
       System.out.println("iþlem yapýlan saat"+ft2.format(d)) ;
      System.out.println("islem tablosu ýd si"+ýslemGüncelleId);
       //burada bulduðum ýd yi kullanýyorum
       System.out.println( "güncellenecek Id"+kaýzId);
       sorguIslem="UPDATE KAIZEN_ISLEM_TBL SET I_OPER_SAAT = TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS.FF') WHERE I_ID=?";
	    		
    
     try {
        		  ps = con.prepareStatement(sorguIslem);
			       
        		  ps.setString(1, ft2.format(d));
        		  ps.setString(2, ýslemGüncelleId);
        		 
	    		ps.executeUpdate();
	    		
	    	
	    		
	    		
			} catch (Exception ex) {
				 JOptionPane.showMessageDialog(null, ex.getMessage());
				// TODO: handle exception
			}
		 
		 System.out.println("Ýþlem saati güncelendi");
	 }
	 

	
	 public static void kaýzIdBulIslem(String K_ID ) {
		 
		 String sorguIdBulma;
		 Statement st;
	        ResultSet rs;
	        System.out.println();
	        con=Database_Connection.getConnection_Kaizen_Db();
		 //KAIZEN ADINI UNÝQUE KOYDUM KÝ ID SINE ULAÞABÝLMEK ÝÇÝN
		 sorguIdBulma="SELECT * FROM KAIZEN_KAIZEN_TBL K,KAIZEN_ISLEM_TBL I WHERE  (K.K_ID="+K_ID+") AND (K.K_ID=I.I_KAIZ_ID)";
	      try {
			
	    	 st = con.createStatement();
		     rs = st.executeQuery(sorguIdBulma);
		     while (rs.next()) {
		    	
		    	 kaýzId=rs.getString("K_ID");
		    	 ýslemGüncelleId=rs.getString("I_ID");
		     }

		} catch (Exception e) {
			// TODO: handle exception
		}
	      }

	 public static boolean bosMuGüncelle( String K_ADI ,String K_KONUSU,String K_ORG_ID , String K_ID,String K_ACIKLAMA) {
    boolean sonuc=true;
	if( !K_ADI.equals("") && !K_KONUSU.equals("") && !K_ORG_ID.equals("") && !K_ID.equals("")&& !K_ACIKLAMA.equals("") ) {
		sonuc=false;
	}
	return sonuc;
}
	 




      
	 public static String Kaýzen_Detay(String P_SÝCÝL,String K_ID) {
		
		     
		     Connection con;
		        String sorguKaizen,detay="",kontrol="";
		        Statement st;
		        ResultSet rs;

		    	
		    	
		    	
		            
		    	 sorguKaizen ="SELECT * FROM KAIZEN_KAIZEN_TBL K, KAIZEN_PERSONEL_TBL P,KAIZEN_ISLEM_TBL I,KAIZEN_DURUM_TBL D\r\n" + 
		    	 		"WHERE (P.P_SICIL="+P_SÝCÝL+") AND (I.I_SICIL_ID=P.P_SICIL) AND (I_KAIZ_ID=K.K_ID)AND (D.D_ID=I_DURUM_ID)\r\n" + 
		    	 		"AND (K.K_ID="+K_ID+")";

		 try {
			 con = Database_Connection.getConnection_Kaizen_Db();
			 st = con.createStatement();
		     rs = st.executeQuery(sorguKaizen);
			 
		    while (rs.next()) {
		    	kontrol=rs.getString("P_ADI");
		    	
		    	detay+="<p class='label'>Personel Id</p>"
		    			 +"<p id='perId'>"+rs.getString("P_ID")+"</p>"
		    			 +"<p class='label'>Personel Sicil</p>"
		    			+"<p id='perSicil'>"+rs.getString("P_SÝCÝL")+"</p>"
		    					 +"<p class='label'>Personel Adi</p>"
		    			+"<p id='perAd'>"+rs.getString("P_ADI")+"</p>"
		    					 +"<p class='label'>Personel Soyadi</p>"
		    			+"<p id='perSoyad'>"+rs.getString("P_SOYADI")+"</p>"
		    					 +"<p class='label'>Son Islem Tarih</p>"
		    			+"<p id='islemOper'>"+rs.getString("I_OPER_SAAT")+"</p>"
		    					 +"<p class='label'>Kaizen Id</p>"
		  				+"<p id='kaizId'>"+rs.getString("K_ID")+"</p>"
		  						 +"<p class='label'>Kaizen Adi</p>"
		    			+"<p id='kaizAd'>"+rs.getString("K_ADI")+"</p>"
		    					 +"<p class='label'>Kaizen Konu</p>"
		    			+"<p id='kaizKonu'>"+rs.getString("K_KONU")+"</p>"
		    					 +"<p class='label'>Baþvuru Tarihi</p>"
		    			+"<p id='kaizBasv'>"+rs.getString("K_BASV_TARH")+"</p>"
		    					 +"<p class='label'>Tamamlanma Tarihi</p>"
		    			+"<p id='kaizTama'>"+rs.getString("K_TAMAM_TARH")+"</p>"
		    					 +"<p class='label'>Son Hareket Tarihi</p>"
		    			+"<p id='kaizSonTrh'>"+rs.getString("K_SON_HARK_TARH")+"</p>"
		    					 +"<p class='label'>Son Hareket Id</p>"
		         		+"<p id='kaizSonId'>"+rs.getString("K_SON_HARK_ID")+"</p>"
		         				 +"<p class='label'>Organizasyon Bilgisi</p>"
		    		    +"<p id='kaizOrg'>"+rs.getString("K_ORG_ID")+"</p>"
		    		    		 +"<p class='label'>Red Tarihi</p>"
		        		 +"<p id='kaizRed'>"+rs.getString("K_RED_TARH")+"</p>"
		        				 +"<p class='label'>Kaizen Son Durum</p>"
		    	    	 +"<p id='durumAd'>"+rs.getString("D_ADI")+"</p>"
		    	    			 +"<p class='label'>Kaizen Açýklama</p>"
		    	    	 +"<p id='kaizAçýklama'>"+rs.getString("K_AÇIKLAMA")+"</p>";
		    			
		           
		    }
		    if(kontrol.equals("")) {
		    	JOptionPane.showMessageDialog(null, "lütfen tabloda buluna ýd numaralarýndan giriniz");
		    	
		    }
		          
		     
		} catch (Exception e) {
			// TODO: handle exception
		}
	return detay;
	}
	
	 
	 
	 
	 
		public static void Kaýzen_Delete( String K_ID ) {
			 
			KaýzIdbULDelte(K_ID);
			   
		 	PreparedStatement ps1,ps2;
		 	String sorguKaýzen,sorguIslem;
		 	
		 	
		    
			   con=Database_Connection.getConnection_Kaizen_Db();
		 	 sorguKaýzen="DELETE FROM KAIZEN_KAIZEN_TBL WHERE K_ID=?";
		 	 sorguIslem="DELETE FROM KAIZEN_ISLEM_TBL WHERE I_ID=?";
		 	 
			        
		 	try {
		 		//önce islemi sildm ki fk ile baðlantýsý sýkýntý çýkarmýsýn diye
		 		ps1 = con.prepareStatement(sorguIslem);
		 		  ps2 = con.prepareStatement(sorguKaýzen);
				       
		 		ps1.setString(1,ýslemDeleteId );
		 		ps2.setString(1, kaýzId);
		 		ps1.executeUpdate();
		 		ps2.executeUpdate();
		 		
		 		
		 		
		 		
				} catch (Exception ex) {
					 JOptionPane.showMessageDialog(null, ex.getMessage());
					// TODO: handle exception
				}
		 	}

	 public static void KaýzIdbULDelte(String K_ID) {
	     	
		   con=Database_Connection.getConnection_Kaizen_Db();
			  
		 String sorguIdBulma;
		 Statement st;
	       ResultSet rs;
		 
		 //KAIZEN ADINI UNÝQUE KOYDUM KÝ ID SINE ULAÞABÝLMEK ÝÇÝN
		 sorguIdBulma="SELECT * FROM KAIZEN_KAIZEN_TBL K, KAIZEN_ISLEM_TBL I WHERE \r\n" + 
		 		"(K.K_ID='"+K_ID+"') AND (K.K_ID=I.I_KAIZ_ID)";
	     try {
			
	   	 st = con.createStatement();
		     rs = st.executeQuery(sorguIdBulma);
		     
		     while (rs.next()) {
		    	 //kaiz ve islem tablosundaki ýd sini alýp globale atýyorum
		    	System.out.println(rs.getString("K_ID"));
		    	System.out.println(rs.getString("I_ID"));
		    	kaýzId=rs.getString("K_ID");
		    	ýslemDeleteId=rs.getString("I_ID");
		    	
		     }

		     
		     
		} catch (Exception e) {
			// TODO: handle exception
		}
	    
	}

	 
	 

	 
	//BURADA PERSONELÝN ORG IS SÝNÝ GÝRÝS YAPTIÐINCDA ÇEKÝYORUM ZATEN
		public static String Kaizen_Ýstatistik(String P_ORG_SEV) {
			  
		    Connection con;
		       String sorguOrgBilg="";
		       Statement st;
		       ResultSet rs;
		       String döndür;
		       int i;
		       String seviye1="",seviye2="",seviye3="",seviye4="";
		       //seveiyelerine göre atýyorum

		       i=0;
		   
		   	if(P_ORG_SEV.equals("1") || P_ORG_SEV.equals("2") || P_ORG_SEV.equals("3") || P_ORG_SEV.equals("4") ) {
		   		 
		   		if(P_ORG_SEV.equals("1")) {
		   		seviye1="1"; seviye2="1";	seviye3="1"; seviye4="1";
		   	   	}
		   		else if(P_ORG_SEV.equals("2")) {
		   			seviye1="1"; seviye2="1";	seviye3="2"; seviye4="2";
		   	   		
		   		}
		   	   else if(P_ORG_SEV.equals("3")) {
		   		seviye1="1"; seviye2="1";	seviye3="2"; seviye4="3";	
		       }
		   	   else if(P_ORG_SEV.equals("4")) {
		   		seviye1="1"; seviye2="2";	seviye3="3"; seviye4="4";
			}
		   		//DURUMUNA GÖRE BÜYÜKTEN KÜÇÜÐE SIRALIYORUM
		   	 sorguOrgBilg ="SELECT *  FROM KAIZEN_KAIZEN_TBL K  ,KAIZEN_PERSONEL_TBL P,KAIZEN_ISLEM_TBL I ,KAIZEN_DURUM_TBL D  WHERE\r\n" + 
		   	 		"( (P.P_ORG_ID="+seviye1+")OR (P.P_ORG_ID="+seviye2+")OR (P.P_ORG_ID="+seviye3+")OR (P.P_ORG_ID="+seviye4+")) AND (P.P_SICIL=I.I_SICIL_ID)\r\n" + 
		   	 		"AND (I.I_KAIZ_ID=K.K_ID)  AND(D.D_ID=I.I_DURUM_ID)  ORDER BY P.P_ORG_ID DESC";
				}
		   	
		   	
		   	
		  else 	if(P_ORG_SEV.equals("5") || P_ORG_SEV.equals("6") || P_ORG_SEV.equals("7") || P_ORG_SEV.equals("8") ) {
				 
				if(P_ORG_SEV.equals("5")) {
				seviye1="5"; seviye2="5";	seviye3="5"; seviye4="5";
			   	}
				else if(P_ORG_SEV.equals("6")) {
					seviye1="5"; seviye2="5";	seviye3="6"; seviye4="6";
			   		
				}
			   else if(P_ORG_SEV.equals("7")) {
				seviye1="5"; seviye2="6";	seviye3="7"; seviye4="7";	
		    }
			   else if(P_ORG_SEV.equals("8")) {
				seviye1="5"; seviye2="6";	seviye3="7"; seviye4="8";
			}
				
			 sorguOrgBilg ="SELECT *  FROM KAIZEN_KAIZEN_TBL K  ,KAIZEN_PERSONEL_TBL P,KAIZEN_ISLEM_TBL I,KAIZEN_DURUM_TBL D  WHERE\r\n" + 
			 		"( (P.P_ORG_ID="+seviye1+")OR (P.P_ORG_ID="+seviye2+")OR (P.P_ORG_ID="+seviye3+")OR (P.P_ORG_ID="+seviye4+")) AND (P.P_SICIL=I.I_SICIL_ID)\r\n" + 
			 		"AND (I.I_KAIZ_ID=K.K_ID)  AND(D.D_ID=I.I_DURUM_ID) ORDER BY P.P_ORG_ID DESC";
				}
		       
		   	döndür="<table id='tablo'><tr><th>SICIL</th><th>ADI</th><th>SOYADI</th><th>KAIZEN ID</th><th>KAIZEN ADI</th>"
	         		+ "<th>KAIZEN KONU</th><th>BASVURU TARIHI</th><th>TAMAMLANMA TARIHI</th><th>SON HAREKET TARIHI</th>"
	         		+ "<th>ACIKLAMA</th><th>DURUM ID</th>";
	            
		     
		   	
		try {
			 con = Database_Connection.getConnection_Kaizen_Db();
			 st = con.createStatement();
		    rs = st.executeQuery(sorguOrgBilg);
			 
		   while (rs.next()) {
		  
		       
		          
		     döndür+="<tr> <td ýd='P_SICIL="+i+"'>"+rs.getString("P_SICIL")+"</td>"+
	          	     	   "<td ýd='P_ADI="+i+"'>"+rs.getString("P_ADI")+"</td>"+
					       "<td ýd='P_SOYADI="+i+"'>"+rs.getString("P_SOYADI")+"</td>"+
					       "<td ýd='K_ID="+i+"'>"+rs.getString("K_ID")+"</td>"+
					       "<td ýd='K_ADI="+i+"'>"+rs.getString("K_ADI")+"</td>"+
					       "<td ýd='K_KONU"+i+"'>"+rs.getString("K_KONU")+"</td>"+
					       "<td ýd='K_BASV_TARH"+i+"'>"+rs.getString("K_BASV_TARH")+"</td>"+
					       "<td ýd='K_TAMAM_TARH"+i+"'>"+rs.getString("K_TAMAM_TARH")+"</td>"+
					       "<td ýd='K_SON_HARK_TARH"+i+"'>"+rs.getString("K_SON_HARK_TARH")+"</td>"+
					       "<td ýd='K_AÇIKLAMA"+i+"'>"+rs.getString("K_AÇIKLAMA")+"</td>"+
					       "<td ýd='I_DURUM_ID"+i+"'>"+rs.getString("D_ADI")+"</td>"+

					                                                            "</tr>";
			     i++;
		   }
		   döndür+="</table>";
		   

		   System.out.println(döndür); 
		} catch (Exception e) {
			// TODO: handle exception
		}

		return döndür;
			
		}
	 
		
		
		public static int [] ÝstatitikOranYaz(String orgId , String orgSevId) {

		    Connection con=null;
		       String sorguKaizen=null;
		       Statement st=null;
		       ResultSet rs=null;
		     
		 
		 
		   int durum[]=new int [8];
		   	int oluþturulud=0,ilkAmirOnayý=0,müdürOnayý=0,kaizenRehberOnayý=0,kaizenMüdür=0,tamamlandý=0,reddedildi=0,kabuledildi=0;
		   	 
		   	
		        
		
		   	 sorguKaizen ="SELECT *  FROM KAIZEN_KAIZEN_TBL K  ,KAIZEN_PERSONEL_TBL P,KAIZEN_ISLEM_TBL I,KAIZEN_DURUM_TBL D,KAIZEN_ORGANIZASYON_TBL O,KAIZEN_O_SEVIYE_TBL S WHERE\r\n" + 
		   	 		"(S.S_ID="+orgSevId+")AND(O.O_SEVIYE_ID=S.S_ID) AND (O.O_ID=P.P_ORG_ID) AND (P.P_SICIL=I.I_SICIL_ID)AND \r\n" + 
		   	 		"(I.I_KAIZ_ID=K.K_ID) AND (I.I_DURUM_ID=D.D_ID) AND (O.O_ID="+orgId+")";

		try {//burada bean sayfalarýna atýyorum
			 con = Database_Connection.getConnection_Kaizen_Db();
			 st = con.createStatement();
		    rs = st.executeQuery(sorguKaizen);
			String test="";
		   while (rs.next()) {
			   
		       
		        test= rs.getString("D_ID");
		        
		        
		        if(test.equals("1")) {
		        	oluþturulud++;
		        }else if(test.equals("2")) {
		        	ilkAmirOnayý++;
		        	
		        }else if(test.equals("3")) {
		        	müdürOnayý++;
		        	
		        }else if(test.equals("4")) {
		        	kaizenRehberOnayý++;
		        	
		        }else if(test.equals("5")) {
		        	kaizenMüdür++;
		        	
		        }else if(test.equals("6")) {
		        	tamamlandý++;
		        	
		        }else if(test.equals("7")) {
		        	reddedildi++;
		        	
		        }else if(test.equals("8")) {
		        	kabuledildi++;
		        
		        }
		   }
		   durum [0]=oluþturulud;
		   durum [1]=ilkAmirOnayý;
		   durum [2]=müdürOnayý;
		   durum [3]=kaizenRehberOnayý;
		   durum [4]=kaizenMüdür;
		   durum [5]=tamamlandý;
		   durum [6]=reddedildi;
		   durum [7]=kabuledildi;
		   
		    
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return durum;
		}
		
		public static String  IstatistikTablo(String orgId , String orgSevId) {
			
			  Connection con=null;
		       String sorguKaizen=null;
		       Statement st=null;
		       ResultSet rs=null;
		       int i=0;
		    	String döndür;
		    
		
		   	 sorguKaizen ="SELECT *  FROM KAIZEN_KAIZEN_TBL K  ,KAIZEN_PERSONEL_TBL P,KAIZEN_ISLEM_TBL I,KAIZEN_DURUM_TBL D,KAIZEN_ORGANIZASYON_TBL O,KAIZEN_O_SEVIYE_TBL S WHERE\r\n" + 
		   	 		"(S.S_ID="+orgSevId+")AND(O.O_SEVIYE_ID=S.S_ID) AND (O.O_ID=P.P_ORG_ID) AND (P.P_SICIL=I.I_SICIL_ID)AND \r\n" + 
		   	 		"(I.I_KAIZ_ID=K.K_ID) AND (I.I_DURUM_ID=D.D_ID) AND (O.O_ID="+orgId+")";

		   	 
		 	döndür="<table id='kaizenler'><tr><th>Personel Sicil</th><th>Personel Adi</th><th>Personel Soyadi</th>"
	         		+ "<th>Kaizen Id</th><th>Kaizen Adi</th><th>Kaizen Konu</th><th>Kaizen Baþvuru</th><th>Kaizen Tamamlanma</th>"
	         		+ "<th>Kaizen Son Hareket</th><th>Kaizen Durum</th>";
		   	 
		try {
			 con = Database_Connection.getConnection_Kaizen_Db();
			 st = con.createStatement();
		    rs = st.executeQuery(sorguKaizen);
			
		   while (rs.next()) {
			   
			   
			 	
	              döndür+="<tr> <td ýd='"+i+"'>"+rs.getString("P_SICIL")+"</td>"+
						       "<td ýd='"+i+"'>"+rs.getString("P_ADI")+"</td>"+
						       "<td ýd='"+i+"'>"+rs.getString("P_SOYADI")+"</td>"+
						       "<td ýd='"+i+"'>"+rs.getString("K_ID")+"</td>"+
						       "<td ýd='"+i+"'>"+rs.getString("K_ADI")+"</td>"+
						       "<td ýd='"+i+"'>"+rs.getString("K_KONU")+"</td>"+
						       "<td ýd='"+i+"'>"+rs.getString("K_BASV_TARH")+"</td>"+
						       "<td ýd='"+i+"'>"+rs.getString("K_TAMAM_TARH")+"</td>"+
						       "<td ýd='"+i+"'>"+rs.getString("K_SON_HARK_TARH")+"</td>"+
						       "<td ýd='"+i+"'>"+rs.getString("D_ADI")+"</td>"+
						      
						                                                            "</tr>";
	                 i++;
		       
		      
		   }
		 
		   döndür+="</table>";
		    
		} catch (Exception e) {
			// TODO: handle exception
		}
		return döndür;
	
		}
		
}



