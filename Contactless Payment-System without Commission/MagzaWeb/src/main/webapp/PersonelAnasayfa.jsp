<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<%
String Personel_Id = request.getSession().getAttribute("Personel_Id") + "";
String Personel_Yetki = request.getSession().getAttribute("Personel_Yetki") + "";
%>	
</head>


<body style = "background-color:#C7D6FF;">
<h1 class = "text-center" style = "padding-top: 5%"> Personel Anasayfasına Hoşgeldiniz </h1>
 <div class="col-md-12 text-center " style = "padding-top: 10%">
<input type="button" id="PersonelKayit" name="PersonelKayit" value="Personel Kayıt" class="btn btn-outline-primary col-md-4">
<input type="button" id="PersonelDurum" name="PersonelDurum" value="Personel Durum" class="btn btn-outline-primary col-md-4">
<input type="button" id="UrunDurum" name="UrunDurum" value="Ürün Durum" class="btn btn-outline-primary col-md-4">
<input type="button" id="KasaDurum" name="KasaDurum" value="Kasa Durum" class="btn btn-outline-primary col-md-4">
<input type="button" id="Iletisim" name="Iletisim" value="İletişim" class="btn btn-outline-primary col-md-4">
<input type="button" id="SiteMesaj" name="SiteMesaj" value="Site Mesaj" class="btn btn-outline-primary col-md-4">
<input type="button" id="KasaIslem" name="KasaIslem" value="Kasa Islem" class="btn btn-outline-primary col-md-4">
<input type="button" id="BilgilerimiGuncelle" name="BilgilerimiGuncelle" value="Bilgilerimi Güncelle" class="btn btn-outline-primary col-md-4">
<input type="button" id="Cikis" name="Cikis" value="Guvenli Cikis" class="btn btn-outline-primary col-md-8">
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

</body>

<script lang="javascript">
var Personel_Id="<%=Personel_Id%>";
var Personel_Yetki="<%=Personel_Yetki%>";

$(document).ready(function(){//metodu bunun iÃ§inde Ã§aÄÄ±rÄ±yoruz
	
	YetkiKisit();
	
	$('#PersonelKayit').click(function(){
		window.location.href="PersonelKayit.jsp";
	});
	$('#PersonelDurum').click(function(){
		window.location.href="PersonelPersonelDurum.jsp";
	});
	$('#UrunDurum').click(function(){
		window.location.href="PersonelUrunDurum.jsp";
	});
	$('#KasaDurum').click(function(){
		window.location.href="PersonelKasaDurum.jsp";
	});
	
	$('#KasaYonetim').click(function(){
		window.location.href="PersonelKasaYonetim.jsp";
	});

	$('#Iletisim').click(function(){
		window.location.href="PersonelIletisim.jsp";
	});
	$('#SiteMesaj').click(function(){
		window.location.href="PersonelSiteMesaj.jsp";
	});
	$('#KasaIslem').click(function(){
		window.location.href="PersonelKasaIslem.jsp";
	});
	
	$('#BilgilerimiGuncelle').click(function(){
		PB();
	});
	
	$('#Cikis').click(function(){
		PC();
	});
	
});



	

function PC() {
	$.ajax({
		url:"/MagzaWeb/PersonelCikisServlet?islem=PersonelCikis",
		method: "POST",
		success:function(){
			window.location.href="Index.jsp";
			},
		error:function(error){
			alert(error);
				
		 }
	  });
	}
	
function YetkiKisit(){
	
	if(Personel_Yetki <= 3){
		document.getElementById("PersonelKayit").style.display = "none";
		document.getElementById("PersonelDurum").style.display = "none"
		document.getElementById("Iletisim").style.display = "none";
		document.getElementById("SiteMesaj").style.display = "none";
		document.getElementById("KasaIslem").style.display = "none";
	}
	
}


function PB() {
	
	$.ajax({
		url:"/MagzaWeb/PersonelBilgilerimServlet?islem=PersonelBilgiGetir" 
			 + "&Personel_Id="+ Personel_Id,
		method: "POST",
		success:function(){
			window.location.href="PersonelBilgilerim.jsp";
			},
		error:function(error){
			alert(error);
				
		 }
	  });
	}

</script>

</html>