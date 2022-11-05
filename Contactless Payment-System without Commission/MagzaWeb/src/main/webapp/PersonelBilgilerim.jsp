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


String Personel__Isim = request.getSession().getAttribute("Personel__Isim") + "";
String Personel_SoyIsim = request.getSession().getAttribute("Personel_SoyIsim") + "";
String Personel_Cinsiyet = request.getSession().getAttribute("Personel_Cinsiyet") + "";
String Personel_Telefon = request.getSession().getAttribute("Personel_Telefon") + "";
String Personel_Adres = request.getSession().getAttribute("Personel_Adres") + "";
String Personel_Egitim_Duzey = request.getSession().getAttribute("Personel_Egitim_Duzey") + "";
String Personel_Mail = request.getSession().getAttribute("Personel_Mail") + "";
String Personel_Sifre_Degis_Parola = request.getSession().getAttribute("Personel_Sifre_Degis_Parola") + "";

%>

</head>




<body style = " background-image: url('Images/MusteriBilgilerim.jpg');background-position: center; background-repeat: no-repeat; background-size: cover;">


    <div class="row d-flex justify-content-center align-items-center h-100" style = "padding-top:4%; padding-bottom:4%;">
      <div class="col col-xl-7">
        <div class="card" style = "border-radius:30px; background-color:#E7F0FF;">
          <div class="row">
			<form id = "form"  class="col-6-md mx-auto" style = "padding-top:10%;">
				<table  class = "mx-auto w-auto" >
				
				<h2 class = "text-center">Genel Bilgilerim</h2>
				
				<tr>
				<td><label>Id:</label></td>
				<td><label id = "Personel_Id" name = "Personel_Id" ></label></td> 
				</tr>
				
				
				<tr>
				<td><label>İsim:</label></td>
				<td><label id = "Personel__Isim" name = "Personel__Isim" ></label></td> 
				<td><input type="text" name="Personel__Isimi" id="Personel__Isimi" required  maxlength = "30" class="form-control"></td> 
				</tr>
				
				
				<tr>
				<td><label>Soyisim:</label></td> 
				<td><label id = "Personel_SoyIsim" name = "Personel_SoyIsim" ></label></td>  
				<td><input type="text" name="Personel_SoyIsimi" id="Personel_SoyIsimi" required  maxlength = "30" class="form-control"></td> 
				</tr>
				
				<tr>
				<td><label>Cinsiyet:</label></td>
				<td><label id = "Personel_Cinsiyet" name = "Personel_Cinsiyet" ></label></td>
				<td><select id="Personel_Cinsiyeti"  class="form-control" required >
			  						<option value="E">E</option>
			  						<option value="K">K</option>
				</select></td> 
				</tr>
				
				<tr>
				<td><label>Telefon:</label></td> 
				<td><label id = "Personel_Telefon" name = "Personel_Telefon" ></label></td>  
				<td><input type="text" name="Personel_Telefoni" id="Personel_Telefoni" pattern="05[0-9]{9}" placeholder ="05*********" minlength = "11" maxlength = "11" required  class="form-control"></td>
				</tr>
				
				<tr>
				<td><label>Mail:</label></td> 
				<td><label id = "Personel_Mail" name = "Personel_Mail" ></label></td> 
				<td><input type="email" id="Personel_Maili" name="Personel_Maili" required   maxlength = "40" class="form-control"></td>
				</tr>
					
				<tr>
				<td><label>Adres:</label></td>
				<td><label id = "Personel_Adres" name = "Personel_Adres" ></label></td> 
				<td><input type="text" name="Personel_Adresi" id="Personel_Adresi" required   maxlength = "100" class="form-control"></td>
				</tr>
					
				<tr>
				<td><label>Eğitim Düzeyi:</label></td> 
				<td><label id = "Personel_Egitim_Duzey" name = "Personel_Egitim_Duzey" ></td> 
					<td><select id="Personel_Egitim_Duzeyi"  class="form-control" required >
			  						<option value="İlkokul">İlkokul</option>
			  						<option value="Ortaokul">Ortaokul</option>
			  						<option value="Lise">Lise</option>
			  						<option value="Ön Lisans">Ön Lisans</option>
			  						<option value="Lisans">Lisans</option>
			  						<option value="Doktora">Doktora</option>
			  						<option value="Master">Master</option>
				</select></td> 
				</tr>
				
				<tr>
				<td><label class = "col-form-label">Şifre Değişim Pini:</label></td> 
				<td style = "padding-left:5px" class = "col-md-5"><label id = "Personel_Sifre_Degis_Parola"></label></td>	
				<td><input type="button"  class=" btn btn-success form-control "  id="PinGetir" value = "Yeni Pin"/></td>
				</tr>
				
				</table>
				
				<div class="d-grid gap-2 col-6 mx-auto" style = "padding-top:5%;">
				<input type="submit" value="submit" class="form-control btn btn-info" id="submit"/>
				</div>
				
			</form>
		
			<div class="d-grid gap-2 col-6 mx-auto" style = "padding-top:5%; margin-bottom: 5%;">
				<input type="button" name="SifreGuncelle" id="SifreGuncelle"  class="btn btn-danger form-control"   value = "Şifre Güncelle"/> 
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

var Personel_Id="<%=Personel_Id%>";

var Personel__Isim="<%=Personel__Isim%>";
var Personel_SoyIsim="<%=Personel_SoyIsim%>";
var Personel_Cinsiyet="<%=Personel_Cinsiyet%>";
var Personel_Telefon="<%=Personel_Telefon%>";
var Personel_Adres="<%=Personel_Adres%>";
var Personel_Egitim_Duzey="<%=Personel_Egitim_Duzey%>";
var Personel_Mail="<%=Personel_Mail%>";
var Personel_Sifre_Degis_Parola="<%=Personel_Sifre_Degis_Parola%>";


$(document).ready(function() {//metodu bunun içinde çağırıyoruz

	PersonelBilgiGetir();
	
	$('#SifreGuncelle').click(function(){

		window.location.href="PersonelSifreDegis.jsp";
	});
	
	$('#PinGetir').click(function(){

		PinGetir();
	});
			
});


function PinGetir(){
	$.ajax({
		url:"/MagzaWeb/MusteriBilgiGetirServlet?islem=MusteriPinGetir",
		method: "POST",
		success:function(data){
			$('#Personel_Sifre_Degis_Parola').html(data);
			},
		error:function(error){
			alert(error);
				
		 }
	  });
	}

function PersonelBilgiGetir() {

			document.getElementById("Personel_Id").innerHTML = Personel_Id;
			document.getElementById("Personel__Isim").innerHTML = Personel__Isim;
			document.getElementById("Personel_SoyIsim").innerHTML = Personel_SoyIsim;
			document.getElementById("Personel_Cinsiyet").innerHTML = Personel_Cinsiyet;
			document.getElementById("Personel_Telefon").innerHTML = Personel_Telefon;
			document.getElementById("Personel_Adres").innerHTML = Personel_Adres;
			document.getElementById("Personel_Egitim_Duzey").innerHTML = Personel_Egitim_Duzey;
			document.getElementById("Personel_Mail").innerHTML = Personel_Mail;
			document.getElementById("Personel_Sifre_Degis_Parola").innerHTML = Personel_Sifre_Degis_Parola;
			
			
			document.getElementById("Personel__Isimi").value=Personel__Isim;
			document.getElementById("Personel_SoyIsimi").value=Personel_SoyIsim;
			document.getElementById("Personel_Cinsiyeti").value=Personel_Cinsiyet;
			document.getElementById("Personel_Telefoni").value=Personel_Telefon;
			document.getElementById("Personel_Adresi").value=Personel_Adres;
			document.getElementById("Personel_Egitim_Duzeyi").value=Personel_Egitim_Duzey;
			document.getElementById("Personel_Maili").value=Personel_Mail;

	}

$("form").on("submit", function (e) {
     
    $.ajax({
    	url:"/MagzaWeb/PersonelBilgilerimServlet?islem=PersonelBilgiGuncelle"  
    		+ "&Personel_Id=" + Personel_Id
    		+ "&Personel__Isim=" + $('#Personel__Isimi').val()
	 		+ "&Personel_SoyIsim=" + $('#Personel_SoyIsimi').val()
	 		+ "&Personel_Cinsiyet=" + $('#Personel_Cinsiyeti').val()
	 		+ "&Personel_Telefon=" + $('#Personel_Telefoni').val()
	 		+ "&Personel_Adres=" + $('#Personel_Adresi').val()
	 		+ "&Personel_Egitim_Duzey=" + $('#Personel_Egitim_Duzeyi').val()
	 		+ "&Personel_Mail=" + $('#Personel_Maili').val()
	 		+ "&Personel_Sifre_Degis_Parola=" + $('#Personel_Sifre_Degis_Parola').text(),
	 type: "POST",
	 success: function (result) {
		 if (result == "1") {
			 alert("Güncelleme başarılı ");
				window.location.href="PersonelAnasayfa.jsp";
			}
		else{
				alert("Günceleme yapılamadı");
			}
      }
    });
 
    e.preventDefault();
});


</script>


</html>