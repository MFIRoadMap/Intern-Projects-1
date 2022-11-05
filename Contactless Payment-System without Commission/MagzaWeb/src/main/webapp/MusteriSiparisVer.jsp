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
String Musteri_Id = request.getSession().getAttribute("Musteri_Id") + "";
%>
</head>


<body>


	<section id = "Urunlar">

		<div class = "" >
			<h2 style = "padding:3%" class = "text-center ">Sipariş Hazırlat</h2>
		</div>
		
		<div class = "row">
		<div class = "row col-lg-10" id = "UrunTable">
			
			
		</div>
		<div class = "col-lg-2" style = "padding-bottom:10%">
		<form id = "form">
			<input type="button" class="btn btn-info form-control col-lg-4"  id="SiparisListesiGorultule" onclick="SiparisGoster();" value = "Siparişlerim"/>
			<label id = "UrunTutar" class = "col-lg-4" style = "display:none; padding-top:10px; padding-bottom:20px " ></label>
			<label id = "UrunListele" class = "col-lg-4" style = "display:none" ></label>
			<select id="MusteriKartlarim" style = "display:none"  class="form-control" required >
				<option id = "kartListele"></option>
			</select>
			<input type="datetime-local" id="TeslimTime" class="form-control"  name="meeting-time" max="2030-06-14T00:00" style = "display:none; margin-top:10px; margin-bottom:10px" required>
			<input type="submit" value="submit"  class="btn btn-success form-control"  style = "display:none; margin-top:10px; margin-bottom:10px" id="submit"/>
			
		</form>
		<input type="button" class="btn btn-danger form-control col-lg-4"  id="SiparisTemizle" style = "display:none; margin-top:10px; margin-bottom:10px" onclick="SiparisTemizle();" value = "Temizle"/>
		</div>
		</div>
	</section>

	<section id = "SayfaSonu">

	</section>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

</body>

<script lang="javascript">

var Musteri_Id="<%=Musteri_Id%>";
var fiyat = 0;
$(document).ready(function() {//metodu bunun içinde çağırıyoruz

	UrunListele();
	KartlarimiGetir();
	
	var dt = new Date();
	document.getElementById("TeslimTime").innerHTML = dt.toLocaleString();
});

function KartlarimiGetir() {
	$.ajax({
		url:"/MagzaWeb/MusteriSiparisVerServlet?islem=MusteriKartlariiGetir" 
			 + "&Musteri_Id="+ Musteri_Id,
		method: "POST",
		success:function(data){
			
			$('#MusteriKartlarim').html(data); //kart bilgisini options olarak buraya gönderiyorum
			},
		error:function(error){
			alert(error);
				
		 }
	  });
	}


function UrunListele() {

	$.post('./MusteriSiparisVerServlet?islem=MusteriUrunListele', function(data) {
		$('#UrunTable').html(data);
	});
}


//seçilen ürünleri session'a kaydediyorum. Bunu önceki seçilen ürünleri sayfada çağırarak yeni ürünü ekliyorum
function MusteriSiparisEkle(i) {
	 var Liste = document.getElementById('UrunListele');
	 Liste.innerHTML += "-"+$('#Urun_Barkod' + i).text()+"- <br>"+$('#Urun_Marka' + i).text()+"<br>"+$('#Urun_Isim' + i).text()+"<br><br>";
	 MusterisHesapla(i);
	}

function MusterisHesapla(i) {
	 var Liste = document.getElementById('UrunTutar');
	 Liste.innerHTML = "Total:";
	 Liste.innerHTML += fiyat += Number($('#Urun_Fiyat' + i).text());
	 Liste.innerHTML += "TL<br>";
	}
	
function SiparisGoster()
{
  var elementUrunListele = document.getElementById("UrunListele");
  var elementUrunTutar = document.getElementById("UrunTutar");
  var elementUrunSiparisTemizle = document.getElementById("SiparisTemizle");
  var elementUrunSubmit = document.getElementById("submit");
  var elementMusteriKartlarim = document.getElementById("MusteriKartlarim");
  var elementMusteriTeslimTime = document.getElementById("TeslimTime");
  
  
  if(elementUrunListele.style.display == 'block'){
	  elementUrunListele.style.display = 'none';
  	  elementUrunTutar.style.display = 'none';
   	  elementUrunSiparisTemizle.style.display = 'none';
  	  elementUrunSubmit.style.display = 'none';
  	  elementMusteriKartlarim.style.display = 'none';
  	elementMusteriTeslimTime.style.display = 'none';
  	  }
  	  
  else if(elementUrunListele.style.display = 'none'){
	  elementUrunListele.style.display = 'block';
 	  elementUrunTutar.style.display = 'block';
 	  elementUrunSiparisTemizle.style.display = 'block';
 	  elementUrunSubmit.style.display = 'block';
 	  elementMusteriKartlarim.style.display = 'block';
 	 elementMusteriTeslimTime.style.display = 'block';
 	  }
}



function SiparisTemizle()
{
	  var elementUrunListele = document.getElementById("UrunListele").innerHTML = " ";
	  	fiyat = 0;
		 var Liste = document.getElementById('UrunTutar');
		 Liste.innerHTML = "Total:";
		 Liste.innerHTML += fiyat;
		 Liste.innerHTML += "TL<br>";

}

$("form").on("submit", function (e) {

    	var Liste = $('#UrunListele').text();
    	
	$.ajax({
		url:"/MagzaWeb/MusteriSiparisVerServlet?islem=MusteriSiparisHazirlat"  
	 		+ "&MusteriKartlarim=" + $('#MusteriKartlarim').val()
	 		+ "&TeslimTime=" + $('#TeslimTime').val()
	 		+ "&Musteri_Id=" + Musteri_Id
	 		+ "&Liste=" + Liste,
		method: "POST",
		success:function(data){
			if(data == "1"){
				alert("Siparişiniz Hazırlanıyor. Mağzamıza Bekliyoruz");
				window.location.href="MusteriAnasayfa.jsp";
			}
			else if(data == "2"){
				alert("Yetersiz bakiye. Lütfen bakiyenizi kontrol edin");
				window.location.href="MusteriAnasayfa.jsp";
			}
			else if(data == "3"){
				alert("Lürfen ürün seçiniz");
			}
			else{
				alert("Belirlenemeye bir hata oluştu");
			}
			},
		error:function(error){
			alert(error);
				
		 }
    });
    e.preventDefault();

});



</script>

</html>