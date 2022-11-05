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
String SecilenKartDetayId = request.getSession().getAttribute("SecilenKartDetayId") + "";
%>

</head>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<body style = "background-image: url('Images/bakiyeyukle.jpg');background-position: center; background-repeat: repeat; background-size: cover;">

<div style = "padding:10%">
	<form id = "form" class = "text-center">
		<table class = "mx-auto w-auto text-center">
			<tr>
				<td>Kart Numarası</td> 
				<td> <input type="number" name="BankaKartNo" id="BankaKartNo"  placeholder="****************" required = "true" maxlength = "16" minlength = "16"  class="form-control"></td> 
			</tr>
			<tr>
				<td>SKT</td>  
				<td> <input type="date" name="BankaKartSkt" id="BankaKartSkt" required = "true"  class="form-control"></td> 
			</tr>
			<tr>
				<td>CVV</td>  
				<td> <input type="text" name="BankaKartCvv" id="BankaKartCvv" pattern="[0-9]*" placeholder="***" required = "true" maxlength = "3" minlength = "3"  class="form-control"></td> 
			</tr>
			<tr>
				<td>Kart Sahibi Id</td>  
				<td> <input type="number" name="BankaKartSahibiId" id="BankaKartSahibiId"  required = "true" maxlength = "25"  class="form-control"></td> 
			</tr>
			<tr>
				<td>Yüklenecek Bakiye</td>  
				<td> <input type="text" name="BankaYuklenecekBakiye" placeholder="***.***" pattern="[0-9]*.[0-9]*" id="BankaYuklenecekBakiye"  required = "true" maxlength = "10"  class="form-control" ></td> 
			</tr>
		</table>
		<div class="d-grid gap-2 col-6 mx-auto" style = "padding-top:5%;">
		<input type="submit" value="Yükle" id="submit" class="btn btn-primary form-control" />
		</div>
	</form>
</div>
</body>

<script lang="javascript">

var SecilenKartDetayId="<%=SecilenKartDetayId%>";

$("form").on("submit", function (e) {
    
    $.ajax({
      url: "/MagzaWeb/MusteriKartListeleServlet?islem=MusteriKartBakiyeYukle"  
    	  	+ "&SecilenKartDetayId=" + SecilenKartDetayId
    		+ "&BankaKartNo=" + $('#BankaKartNo').val()
			+ "&BankaKartSkt=" + $('#BankaKartSkt').val()
			+ "&BankaKartCvv=" + $('#BankaKartCvv').val()
			+ "&BankaKartSahibiId=" + $('#BankaKartSahibiId').val()
	 		+ "&BankaYuklenecekBakiye=" + $('#BankaYuklenecekBakiye').val(),
	 type: "POST",
	 success: function (result) {
		 if (result == "1") {
			 alert("Yukleme Başarılı");
				window.location.href="MusteriAnasayfa.jsp";
			}
		 else if(result == "2"){
			 alert("Kart bakiyenizi kontol edin.");
		 }
		else{
				alert("Lütfen bilgileri doğru girin.");
			}
      }
    });
 
    e.preventDefault();
});

</script>

</html>