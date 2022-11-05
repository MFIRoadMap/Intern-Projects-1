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




<body style = "background-color: #A09DA5">

    <div class="row d-flex justify-content-center align-items-center h-100" style = "padding-top:5%; padding-bottom:5%">
      <div class="col col-md-6">
        <div class="card" style = "background-color: #EFEDF3">
          <div class="row">
          		<div class="px-0 d-none d-sm-block mx-auto w-auto col-8-md">
			        <img src="Images\loginmüsteri.jpg" class="card-img-top" style="object-fit: cover; object-position: Center; border-radius: 4px; ">
			      </div>
				<form id = "form"   class=" d-sm-block mx-auto w-auto col-8-md" style = "padding-top :10%; padding-bottom :10%">
					<table>
					<tr>
					<td><label >İsim:</label></td>
					<td><input type="text" name="Musteri_Isim" id="Musteri_Isim" required  maxlength = "30"  class="form-control" ></td> 
					</tr>
					<tr>
					<td><label>Soyisim:</label></td> 
					<td><input type="text" name="Musteri_SoyIsim" id="Musteri_SoyIsim" required maxlength = "30"  class="form-control" ></td> 
					</tr>
					
					<tr>
					<td><label>Cinsiyet:</label></td>
						<td><select id="Musteri_Cinsiyet" class="form-control" required >
				  						<option value="E">E</option>
				  						<option value="K">K</option>
						</select></td>
					</tr>
					
					<tr>
					<td><label>Telefon:</label></td> 
					<td><input type="text" name="Musteri_Telefon" id="Musteri_Telefon" pattern="05[0-9]{9}" placeholder ="05*********" minlength = "11" maxlength = "11" required = "true" class="form-control"></td> 
					</tr>
					
					<tr>
					<td><label>Mail:</label></td> 
					<td><input type="email" id="Musteri_Mail" name="Musteri_Mail" required = "true" maxlength = "40" class="form-control"></td>
					</tr>
						
					<tr>
					<td><label>Adres:</label></td>
					<td><input type="text" name="Musteri_Adres" id="Musteri_Adres" required = "true" maxlength = "100" class="form-control"></td>
					</tr>
						
					<tr>
					<td><label>Doğum Tarihi:</label></td> 
					<td><input type="date"  min="1900-01-02" name="Musteri_Dogum_Tarih" id="Musteri_Dogum_Tarih" required = "true" class="form-control"></td> 
					</tr>
					
					<tr>
					<td><label>Şifre:</label></td> 
					<td><input type="password" name="Musteri_Sifre" id="Musteri_Sifre" required = "true" maxlength = "25" class="form-control"></td>
					</tr>
						
					<tr>
					<td><label>Şifreni Doğrula:</label></td>  
					<td><input type="password" name="Musteri_Sifre_Dogrula" id="Musteri_Sifre_Dogrula" required = "true" maxlength = "25" class="form-control"></td> 
					</tr>
						
					<tr>
					<td><input type="submit" value="submit" id="submit" style = "margin-top:30px" class="form-control btn btn-success"/></td>
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
    	url:"/MagzaWeb/MusteriKayitServlet?islem=MusteriKayitOlustur"  
			+ "&Musteri_Isim=" + $('#Musteri_Isim').val()
	 		+ "&Musteri_SoyIsim=" + $('#Musteri_SoyIsim').val()
	 		+ "&Musteri_Cinsiyet=" + $('#Musteri_Cinsiyet').val()
	 		+ "&Musteri_Telefon=" + $('#Musteri_Telefon').val()
	 		+ "&Musteri_Mail=" + $('#Musteri_Mail').val()
	 		+ "&Musteri_Adres=" + $('#Musteri_Adres').val()
	 		+ "&Musteri_Dogum_Tarih=" + $('#Musteri_Dogum_Tarih').val()
	 		+ "&Musteri_Sifre=" + $('#Musteri_Sifre').val(),
	 type: "POST",
	 success: function (result) {
		 if (result == "1") {
			 alert("Kayıt Başarılı");
				window.location.href="Index.jsp";
			}
		else{
				alert("Mail adresi zaten kayıtlı. Yeni kayıt oluşturulamadı.");
			}
      }
    });
 
    e.preventDefault();
});


</script>


</html>