<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>

<body style = "background-color: #D1B8FF">

    <div class="row d-flex justify-content-center align-items-center h-100" style = "padding-top:5%; padding-bottom:5%">
      <div class="col col-md-6">
        <div class="card" >
          <div class="row">
          		<div class=" d-md-block mx-auto w-auto ">
			        <img src="Images\employee.jpg" class="card-img-top" style="object-fit: cover; object-position: Center; border-radius: 4px; ">
			      </div>
			<form id = "form"  class=" d-sm-block mx-auto w-auto col-7-md" style = "padding-top :10%; padding-bottom :10%">
				
				<h2 class = "text-center" style = "padding-bottom: 6%;" > Personel Kayıt </h2>
				<table>
				<tr>
				<td><label>İsim:</label></td>
				<td><input type="text" name="Personel__Isim" id="Personel__Isim" required maxlength = "30" class="form-control"></td> 
				</tr>
				
				
				<tr>
				<td><label>Soyisim:</label></td> 
				<td><input type="text" name="Personel_SoyIsim" id="Personel_SoyIsim" required maxlength = "30" class="form-control"></td> 
				</tr>
				
				<tr>
				<td><label>Cinsiyet:</label></td>
				<td><select id="Personel_Cinsiyet"  class="form-control" required >
			  						<option value="E">E</option>
			  						<option value="K">K</option>
				</select></td> 
				</tr>
				
				<tr>
				<td><label>Telefon:</label></td> 
				<td><input type="text" name="Personel_Telefon" id="Personel_Telefon" pattern="05[0-9]{9}" placeholder ="05*********" minlength = "11" maxlength = "11" required class="form-control"></td> 
				</tr>
				
				<tr>
				<td><label>Mail:</label></td> 
				<td><input type="email" id="Personel_Mail" name="Personel_Mail" required maxlength = "40" class="form-control"></td>
				</tr>
					
				<tr>
				<td><label>Adres:</label></td>
				<td><input type="text" name="Personel_Adres" id="Personel_Adres" required maxlength = "100" class="form-control"></td>
				</tr>
					
				<tr>
				<td><label>Eğitim Düzeyi:</label></td> 
				<td><select id="Personel_Egitim_Duzey"  class="form-control" required >
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
				<td><label>Şifre:</label></td> 
				<td><input type="password" name="Personel_Sifre" id="Personel_Sifre" required maxlength = "25" class="form-control"></td>
				</tr>
					
				<tr>
				<td><label>Şifreni Doğrula:</label></td>  
				<td><input type="password" name="Personel_Sifre_Dogrula" id="Personel_Sifre_Dogrula" required maxlength = "25" class="form-control"></td> 
				</tr>
						
				<tr>
				<td><label>Yetki:</label></td>  
				<td><select id="Personel_Yetki"  class="form-control" required >
			  						<option value="1">1</option>
			  						<option value="2">2</option>
			  						<option value="3">3</option>
			  						<option value="4">4</option>
			  						<option value="5">5</option>
				</select></td>
				</tr>
							
				<tr>
				<td><label>Verilecek Maaş:</label></td>  
				<td><input type="text" name="Personel_Maas" id="Personel_Maas" pattern="[0-9]*.[0-9]*" required maxlength = "10" class="form-control"></td> 
				</tr>
							
				<tr>
				<td><label>Doğum Tarihi:</label></td>  
				<td><input type="date" min="1900-01-02" name="Personel_Dogum_Tarih" id="Personel_Dogum_Tarih" required  class="form-control"></td> 
				</tr>
					
				<tr>
				<td><input type="submit" class="form-control btn btn-success" style = "margin-top:30px" value="submit" id="submit"/></td>
				</tr>
				
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

$("form").on("submit", function (e) {
     
    $.ajax({
    	type: "POST",
    	url:"/MagzaWeb/PersonelKayitServlet?islem=PersonelKayitOlustur"  
			+ "&Personel__Isim=" + $('#Personel__Isim').val()
	 		+ "&Personel_SoyIsim=" + $('#Personel_SoyIsim').val()
	 		+ "&Personel_Cinsiyet=" + $('#Personel_Cinsiyet').val()
	 		+ "&Personel_Telefon=" + $('#Personel_Telefon').val()
	 		+ "&Personel_Mail=" + $('#Personel_Mail').val()
	 		+ "&Personel_Adres=" + $('#Personel_Adres').val()
	 		+ "&Personel_Egitim_Duzey=" + $('#Personel_Egitim_Duzey').val()
	 		+ "&Personel_Sifre=" + $('#Personel_Sifre').val()
	 		+ "&Personel_Sifre_Dogrula=" + $('#Personel_Sifre_Dogrula').val()
	 		+ "&Personel_Yetki=" + $('#Personel_Yetki').val()
	 		+ "&Personel_Dogum_Tarih=" + $('#Personel_Dogum_Tarih').val()
	 		+ "&Personel_Maas=" + $('#Personel_Maas').val(),
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
 
    e.preventDefault();
});

</script>

</html>