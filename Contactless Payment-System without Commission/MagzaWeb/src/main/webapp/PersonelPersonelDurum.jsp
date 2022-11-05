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

<body style = "background-image: url('Images/personel.jpg');background-position: center; background-repeat: repeat; background-size: cover;">
<div class="row d-flex justify-content-center align-items-center" style = "margin-top:5%;">
	<div class = "col-xl-11">
		<div class = "row" >	
			<div class = "card"  style = "border-radius:15px; background-color:#BFF6FF;">
				<form class = "mx-auto w-auto ">
				 	<h3 class = "text-center" style = "padding:2%;"> Personel Bilgi </h3>
					<table id = "content" class="table table-hover table-white ">
					
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

	$.post('/MagzaWeb/PersonelPersonelDurumServlet?islem=PersonelDurumListele', function(data) {
		$('#content').html(data);
	});

		
});




//tablodaki satırlara tıklandığında detaylı olarak satışları görüntülemek için kullanlacak. Methodu manager sayfasında tabloyu doldururken onclick methodu ile çağırıyrum



</script>
</html>