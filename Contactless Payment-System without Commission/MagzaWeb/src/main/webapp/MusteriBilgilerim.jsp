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


String Musteri_Isim = request.getSession().getAttribute("Musteri_Isim") + "";
String Musteri_SoyIsim = request.getSession().getAttribute("Musteri_SoyIsim") + "";
String Musteri_Cinsiyet = request.getSession().getAttribute("Musteri_Cinsiyet") + "";
String Musteri_Telefon = request.getSession().getAttribute("Musteri_Telefon") + "";
String Musteri_Mail = request.getSession().getAttribute("Musteri_Mail") + "";
String Musteri_Adres = request.getSession().getAttribute("Musteri_Adres") + "";
String Musteri_Dogum_Tarih = request.getSession().getAttribute("Musteri_Dogum_Tarih") + "";
String Musteri_Sifre_Degis_Parola = request.getSession().getAttribute("Musteri_Sifre_Degis_Parola") + "";
%>

</head>




<body style = "background-image: url('Images/bilgilerim.jpg');background-position: center; background-repeat: repeat; background-size: cover;">


    <div class="row d-flex justify-content-center align-items-center h-100" style = "padding-top:7%; padding-bottom:7%">
      <div class="col col-xl-7">
        <div class="card" style = "border-radius: 15px; background-color:#E9C9CE;">
          <div class="row">
			<form id = "form"   class="col-6-md mx-auto" style = "padding-top:5%">
				
				<h2 class = "text-center" style = "padding-bottom:5%;"> Bilgilerim </h2>
				
				<table class = "mx-auto w-auto" >		
				<tr>
				<td><label class = "col-form-label">Id:</label></td>
				<td class = "col-md-5"><label id = "Musteri_Id"></label></td>
				</tr>
				
				
				<tr>
				<td><label class = "col-form-label">İsim:</label></td>
				<td class = "col-md-3"><label id = "Musteri_Isim"> </label></td>
				<td class = "col-md-3"><input type="button" class="btn btn-danger form-control"  id="IsimGuncelle" onclick="GuncelleIsim();" value = "Isim Güncelle"/>
					<input  type="text" id="Musteri_Isimi" required maxlength = "30" style = "display:none" class="form-control" /></td>
				</tr>
				
				
				<tr>
				<td ><label class = "col-form-label">Soyisim:</label></td> 
				<td class = "col-md-5"><label id = "Musteri_SoyIsim"></label></td>  
				<td class = "col-md-5"><input type="button" class="btn btn-danger form-control"  id="SoyIsimGuncelle" onclick="GuncelleSoyIsim();" value = "Soyisim Güncelle"/>
					<input type="text" name="Musteri_SoyIsimi" id="Musteri_SoyIsimi" style = "display:none"  class="form-control" required maxlength = "30"></td> 
				</tr>
				
				<tr >
				<td><label class = "col-form-label">Cinsiyet:</label></td>
				<td class="col-md-5"><label id = "Musteri_Cinsiyet"></label></td>  
				<td class = "col-md-5"><input type="button" class="btn btn-danger form-control"  id="CinsiyetGuncelle" onclick="GuncelleCinsiyet();" value = "Cinsiyet Güncelle"/>
					<select id="Musteri_Cinsiyeti" style = "display:none"  class="form-control" required >
  						<option value="E">E</option>
  						<option value="K">K</option>
					</select></td>
				</tr>
				
				<tr>
				<td><label class = "col-form-label">Telefon:</label></td> 
				<td class = "col-md-5"><label id = "Musteri_Telefon"></label></td>  
				<td class = "col-md-5"><input type="button" class="btn btn-danger form-control"  id="TelefonGuncelle" onclick="GuncelleTelefon();" value = "Telefon Güncelle"/>
				<input type="text" name="Musteri_Telefoni" id="Musteri_Telefoni" pattern="05[0-9]{9}"  style = "display:none"  class="form-control" placeholder ="05*********"  maxlength = "11"></td>
				</tr>
				
				<tr>
				<td><label class = "col-form-label">Mail:</label></td> 
				<td class = "col-md-5"><label id = "Musteri_Mail"></label></td> 
				<td class = "col-md-5"><input type="button" class="btn btn-danger form-control"  id="MailGuncelle" onclick="GuncelleMail();" value = "Mail Güncelle"/>
				<input type="email" id="Musteri_Maili" name="Musteri_Maili" class="form-control"  style = "display:none"  required maxlength = "40"></td>
				</tr>
					
				<tr>
				<td><label class = "col-form-label">Adres:</label></td>
				<td class = "col-md-5"><label id = "Musteri_Adres"></label></td> 
				<td class = "col-md-5"><input type="button" class="btn btn-danger form-control"  id="AdresGuncelle" onclick="GuncelleAdres();" value = "Adres Güncelle"/>
				<textarea name="Musteri_Adresi" id="Musteri_Adresi" style = "display:none"  required class="form-control" maxlength = "100"  rows = "3" ></textarea></td>
				</tr>
					
				<tr>
				<td><label class = "col-form-label">Şifre Değişim Pini:</label></td> 
				<td style = "padding-left:5px" class = "col-md-5"><label id = "Musteri_Sifre_Degis_Parola"></label></td>
				<td class = "col-md-5"><input type="button" class="btn btn-danger form-control"  id="SifreDegisimPinDegistir" onclick="PinDegis();" value = "Pin Değiştir"/>	
				<input type="button" style = "display:none" class=" col-md-2 btn btn-success form-control "  id="PinGetir" value = "Yeni Pin"/></td>
				</tr>
					
				<tr>
				<td><label class = "col-form-label">Doğum Tarihi:</label></td> 
				<td style = "padding-left:5px" class = "col-md-5"><label id = "Musteri_Dogum_Tarih"></label></td>  
				</tr>
				
				</table>
				<div class="d-grid gap-2 col-6 mx-auto" style = "padding-top:5%;">
				<input type="submit"  value="submit"  class="form-control btn btn-success" id="submit"/>
				</div>
				
			</form>
			<div class="d-grid gap-2 col-6 mx-auto" style = "padding-top:5%; padding-bottom:5%;">
			<input type="button" class="btn btn-warning" name="SifreGuncelle" id="SifreGuncelle" value = "Şifre Güncelle"/> 
			</div>	
          </div>
        </div>
      </div>
    </div>


	
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>


<script lang="javascript">

var Musteri_Id="<%=Musteri_Id%>";


var Musteri_Id="<%=Musteri_Id%>";
var Musteri_Isim="<%=Musteri_Isim%>";
var Musteri_SoyIsim="<%=Musteri_SoyIsim%>";
var Musteri_Cinsiyet="<%=Musteri_Cinsiyet%>";
var Musteri_Telefon="<%=Musteri_Telefon%>";
var Musteri_Mail="<%=Musteri_Mail%>";
var Musteri_Adres="<%=Musteri_Adres%>";
var Musteri_Dogum_Tarih="<%=Musteri_Dogum_Tarih%>";
var Musteri_Sifre_Degis_Parola="<%=Musteri_Sifre_Degis_Parola%>";


$(document).ready(function() {//metodu bunun içinde çağırıyoruz

	MusteriBilgiGetir();
	
	$('#SifreGuncelle').click(function(){

		window.location.href="MusteriSifreDegis.jsp";
	});

	$('#PinGetir').click(function(){

		PinGetir();
	});

});

function MusteriBilgiGetir() {
	//buradaki verileri müşteri anasayfasından ilgili metoda gönderip session' a kaydediyorum. Dahasonra bu sayfadan çekiyorum
			document.getElementById("Musteri_Id").innerHTML = Musteri_Id;
			document.getElementById("Musteri_Isim").innerHTML = Musteri_Isim;
			document.getElementById("Musteri_SoyIsim").innerHTML = Musteri_SoyIsim;
			document.getElementById("Musteri_Cinsiyet").innerHTML = Musteri_Cinsiyet;
			document.getElementById("Musteri_Telefon").innerHTML = Musteri_Telefon;
			document.getElementById("Musteri_Mail").innerHTML = Musteri_Mail;
			document.getElementById("Musteri_Adres").innerHTML = Musteri_Adres;
			document.getElementById("Musteri_Dogum_Tarih").innerHTML = Musteri_Dogum_Tarih;
			document.getElementById("Musteri_Sifre_Degis_Parola").innerHTML = Musteri_Sifre_Degis_Parola;
			
			
			
			document.getElementById("Musteri_Isimi").value=Musteri_Isim;
			document.getElementById("Musteri_SoyIsimi").value=Musteri_SoyIsim;
			document.getElementById("Musteri_Telefoni").value=Musteri_Telefon;
			document.getElementById("Musteri_Maili").value=Musteri_Mail;
			document.getElementById("Musteri_Adresi").value=Musteri_Adres;

	}

$("form").on("submit", function (e) {
     
    $.ajax({
    	url:"/MagzaWeb/MusteriBilgiGetirServlet?islem=MusteriBilgiGuncelle"  
    		+ "&Musteri_Id=" + Musteri_Id
    		+ "&Musteri_Isim=" + $('#Musteri_Isimi').val()
	 		+ "&Musteri_SoyIsim=" + $('#Musteri_SoyIsimi').val()
	 		+ "&Musteri_Cinsiyet=" + $('#Musteri_Cinsiyeti').val()
	 		+ "&Musteri_Telefon=" + $('#Musteri_Telefoni').val()
	 		+ "&Musteri_Mail=" + $('#Musteri_Maili').val()
	 		+ "&Musteri_Adres=" + $('#Musteri_Adresi').val()
	 		+ "&Musteri_Sifre_Degis_Parola=" + $('#Musteri_Sifre_Degis_Parola').text(),
	 type: "POST",
	 success: function (result) {
		 if (result == "1") {
			 alert("Güncelleme başarılı ");
				window.location.href="MusteriAnasayfa.jsp";
			}
		else{
				alert("Günceleme yapılamadı");
			}
      }
    });
 
    e.preventDefault();
});


function PinGetir(){
	$.ajax({
		url:"/MagzaWeb/MusteriBilgiGetirServlet?islem=MusteriPinGetir",
		method: "POST",
		success:function(data){
			$('#Musteri_Sifre_Degis_Parola').html(data);
			},
		error:function(error){
			alert(error);
				
		 }
	  });
	}


function GuncelleIsim()
{
  var element = document.getElementById("Musteri_Isimi");
  if(element.style.display == 'block'){
      element.style.display = 'none';}
  else if(element.style.display = 'none'){
      element.style.display = 'block'}
}

function GuncelleSoyIsim()
{
  var element = document.getElementById("Musteri_SoyIsimi");
  if(element.style.display == 'block'){
      element.style.display = 'none';}
  else if(element.style.display = 'none'){
      element.style.display = 'block'}
}

function GuncelleCinsiyet()
{
  var element = document.getElementById("Musteri_Cinsiyeti");
  if(element.style.display == 'block'){
      element.style.display = 'none';}
  else if(element.style.display = 'none'){
      element.style.display = 'block'}
}

function GuncelleTelefon()
{
  var element = document.getElementById("Musteri_Telefoni");
  if(element.style.display == 'block'){
      element.style.display = 'none';}
  else if(element.style.display = 'none'){
      element.style.display = 'block'}
}


function GuncelleMail()
{
  var element = document.getElementById("Musteri_Maili");
  if(element.style.display == 'block'){
      element.style.display = 'none';}
  else if(element.style.display = 'none'){
      element.style.display = 'block'}
}

function GuncelleAdres()
{
  var element = document.getElementById("Musteri_Adresi");
  if(element.style.display == 'block'){
      element.style.display = 'none';}
  else if(element.style.display = 'none'){
      element.style.display = 'block'}
}

function PinDegis()
{
  var element2 = document.getElementById("PinGetir");
  
  if(element2.style.display == 'block'){
      element2.style.display = 'none';}
  else if(element2.style.display = 'none'){
      element2.style.display = 'block'}
}

</script>


</html>