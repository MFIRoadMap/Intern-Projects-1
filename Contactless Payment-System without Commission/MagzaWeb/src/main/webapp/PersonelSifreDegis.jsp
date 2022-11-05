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

<body style = "background-image: url('Images/storesifreguncelle.jpg');background-position: center; background-repeat: no-repeat; background-size: cover;">

    <div class="row d-flex justify-content-center align-items-center h-100" style = "padding-top:5%; padding-bottom:5%">
      <div class="col col-xl-6">
        <div style ="border-radius:15px; background-color:#EAF8E9;"  class="card">
          <div class="row g-0">
            <div class="col-md-6 col-lg-7 d-flex align-items-center">
              <div class="card-body p-4 p-lg-5 text-black">
				<form id = "form">
				
				
                  <h5>Şifre Güncelle</h5>
				
				 <div class="form-outline mb-4">
                    <label class = "col-form-label">Kullanılan Parola</label>
                    <input type="password" name="GuncelParola" id="GuncelParola" class = "form-control" required  maxlength = "25">
                  </div>
                  
                  <div class="form-outline mb-4">
                    <label class = "col-form-label">Yeni Parola</label>
                    <input type="password" name="YeniParola" id="YeniParola" class = "form-control" required maxlength = "25">
                  </div>

                  <div class="form-outline mb-4">
                    <label class = "col-form-label">Parola Doğrula</label>
                    <input type="password" name="YeniParolaDogrula" class = "form-control" id="YeniParolaDogrula"  required maxlength = "25">
                  </div>
					
					<div class="mb-4">
						<input type="submit" value="submit" class = "form-control btn btn-info" id="submit" />
					</div>
				</form>
              </div>
            </div>
            
            <div class="col-md-5 col-md-4 d-none d-md-block"">
              <img src="Images/musterisifre.jpg" style = "width : 100%; height : 100%; border-radius:15px;" class="img-fluid" />
            </div>
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

$("form").on("submit", function (e) {
    
	if($('#YeniParola').val() == $('#YeniParolaDogrula').val()){
    $.ajax({
      url: "/MagzaWeb/PersonelSifreDegisServlet?islem=PersonelParolaDegis"  
			+ "&GuncelParola=" + $('#GuncelParola').val()
	 		+ "&YeniParola=" + $('#YeniParola').val()
	 		+ "&Personel_Id=" + Personel_Id,
	 type: "POST",
	 success: function (result) {
		 if (result=="1") {
			 alert("Şifre başarıyla güncellendi");
			 window.location.href="PersonelAnasayfa.jsp";
			}
		else{
				alert("Şifre güncellenemedi");
			}
      }
    });
    }
	
	else{
		alert("Lütfen aynı parolayı girin");
	}
 
    e.preventDefault();
});

</script>
</html>