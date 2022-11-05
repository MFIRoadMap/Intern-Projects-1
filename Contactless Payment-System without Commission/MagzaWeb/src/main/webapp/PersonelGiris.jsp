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

<body>


  <div class="container-fluid">
    <div class="row">
      <div class="col-md-6 text-black">

        <div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">

          <form style="width: 23rem;">

            <h3 class="fw-normal mb-3 pb-3">Log in</h3>

            <div class="form-outline mb-4">
              <label class="form-label">Email</label>
              <input type="email" id="PersonelMail" class="form-control form-control-lg" required = "true" maxlength = "40"/>
            </div>

            <div class="form-outline mb-4">
              <label class="form-label" >Password</label>
              <input type="password" id="PersonelSifre" class="form-control form-control-lg" required = "true" maxlength = 40"/>
            </div>

            <div class="pt-1 mb-4">
              <button class="btn btn-success btn-lg btn-block" id="submit" type="submit">Login</button>
            </div>

            <button class="btn btn-md btn-primary btn-block" type="button" onclick="window.location.href='PersonelSifreUnuttum.jsp'">Şifremi Unuttum</button>

          </form>

        </div>

      </div>
      <div class="col-sm-6 px-0 d-none d-sm-block">
        <img src="Images\loginopersonel.jpg" class="w-100 vh-100" style="object-fit: cover; object-position: left;">
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
      url: "/MagzaWeb/PersonelGirisServlet?islem=GirisKontrol"  
			+ "&PersonelMail=" + $('#PersonelMail').val()
	 		+ "&PersonelSifre=" + $('#PersonelSifre').val(),
      success: function (result) {
    	  if (result!="") {
				alert("Giriş Başarılı");
			window.location.href="PersonelAnasayfa.jsp";
			}
			else{
			alert("Böyle Bir Kullanıcı Bulunamadı");
			}
      }
    });
 
    e.preventDefault();
});

</script>
</html>