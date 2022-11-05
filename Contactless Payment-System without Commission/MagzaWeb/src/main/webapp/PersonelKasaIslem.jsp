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
%>
</head>

<body style = "background-image: url('Images/MagazaKasa.jpg');background-position: center; background-repeat: repeat; background-size: cover;">

 <div class="row d-flex justify-content-center align-items-center h-100" style = "padding-top:5%; padding-bottom:5%">
      <div class="col col-xl-6 ">
       	  <div class = "row" >
	          <div class="card"  style = "background-color:#FFE8BD; border-radius:30px;  padding:3%;">
					<h3 class = "text-center" style = "padding:2%;">Kasa Olustur</h3>
					<form id = "form" class = "mx-auto w-auto col-6-md">
						<table>
						<tr>
						<td><label>Kasa Tipi:</label></td>
						<td><select id="KasaType"   class="form-control" required >
					  						<option value="AnaKasa">AnaKasa</option>
					  						<option value="JetKasa">JetKasa</option>
						</select></td>
						</tr>
						<tr>
						<td><input class="form-control btn btn-danger" name = "KasaOlustur" value = "Kasa Olustur" type="bottun" id="KasaOlustur"/></td>
						</tr>
						
						</table>
					</form>
				</div>
			</div>
          <div class="row " style = "padding:10%">
	          <div class = "card"  style = "border-radius:30px; background-color:#FFE8BD; padding:3%">
	          <h3 class = "text-center" style = "padding:2%;">Kasa Durum Guncelle</h3>
	          	<form id = "form2" class = "mx-auto w-auto col-6-md" >
						<table>
						<tr>
						<td><label>Kasa Tipi:</label></td>
						<td><select id="KasaListele"  class="form-control" required >
					  						<option id = ""></option>
						</select></td>
						<td><select id="DurumGuncelle"  class="form-control" required >
					  		<option value="Aktif">Aktif</option>
	  						<option value="Pasif">Pasif</option>
						</select></td>
						</tr>
						<tr>
						<td><input class="form-control btn btn-danger" name = "Kasa Durum Güncelle" value = "Kasa Durum Güncelle" type = "button" id="KasaDurumGuncelle" /></td>
						</tr>
						</table>
						
						<table id = "KasaDurumGetir" class="table table-hover table-white text-center" style = "margin-top:30px; margin-bottom:30px">
						
						</table>
					</form>
				</div>
			</div>
        </div>
    </div>

	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

</body>


<script lang="javascript">

var Personel_Id="<%=Personel_Id%>";

$(document).ready(function() {//metodu bunun içinde çağırıyoruz

	KasaListesiGetir();
	KasaDurumListele();
	$('#KasaDurumGuncelle').click(function(){
		KasaDurumGuncelle();
	});
	
	$('#KasaOlustur').click(function(){
		KasaOlustur();
	});
	
	
});

function KasaListesiGetir() {

	$.post('./PersonelKasaDurumServlet?islem=KasaGetir', function(data) {
		$('#KasaListele').html(data);
	});
}
function KasaDurumListele() {

	$.post('./PersonelKasaDurumServlet?islem=KasaDurumListele', function(data) {
		$('#KasaDurumGetir').html(data);
	});
}

function KasaOlustur() {
    
    $.ajax({
    	type: "POST",
    	url:"/MagzaWeb/PersonelKasaDurumServlet?islem=KasaOlustur"  
	 		+ "&KasaType=" + $('#KasaType').val()
	 		+ "&Personel_Id=" + Personel_Id,
	 success: function (result) {
		 if (result == "1") {
			 alert("Kayıt Başarılı");
				window.location.href="PersonelAnasayfa.jsp";
			}
		else{
				alert("Hatalı Giris");
			}
	 }
	  });
	}

function KasaDurumGuncelle() {
    
    $.ajax({
    	type: "POST",
    	url:"/MagzaWeb/PersonelKasaDurumServlet?islem=KasaDurumGuncelle"  
	 		+ "&KasaListele=" + $('#KasaListele').val()
	 		+ "&DurumGuncelle=" + $('#DurumGuncelle').val(),
	 success: function (result) {
		 if (result == "1") {
				alert($('#KasaListele').val()+" Kasanan Durumu "+ $('#DurumGuncelle').val() +" olarak değiştirildi");
				window.location.href="PersonelAnasayfa.jsp";
			}
		else{
				alert("Hatalı Giris");
			}
	 }
	  });
	}

</script>
</html>