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

<body style = "background-image: url('Images/kartlarim.jpg');background-position: center; background-repeat: repeat; background-size: cover;">

 <div class="row d-flex justify-content-center align-items-center h-100" style = "padding-top:5%; padding-bottom:5%">
      <div class="col col-xl-5 ">
       	  <div class="row " style = "padding:5%">
	          <div class = "card"  style = "border-radius:30px; background-color:#D8D8D8; padding:3%">
	          <h3 class = "text-center" style = "padding:2%;"> Magaza Kartlarım </h3>
	          	<form id = "form2" class = "mx-auto w-auto col-6-md" >
					<table id="KartBilgiListele"  class="table table-hover table-white">
						
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

var Musteri_Id="<%=Musteri_Id%>";

$(document).ready(function() {//metodu bunun içinde çağırıyoruz

	MusteriKartListele();
	
});

function MusteriKartListele() {
	$.ajax({
		url:"/MagzaWeb/MusteriKartListeleServlet?islem=MusteriKartListele" 
			 + "&Musteri_Id="+ Musteri_Id,
		method: "POST",
		success:function(data){
			$('#KartBilgiListele').html(data);
			},
		error:function(error){
			alert(error);
		 }
	  });
	}
	
function MusteriKartGecmisiListele(i) {
	$.ajax({
		url:"/MagzaWeb/MusteriKartListeleServlet?islem=MusteriKartlarımDetayListele" 
			 + "&SecilenKartDetayId="+ $('#Kart_Id' + i).text(),
		method: "POST",
		success:function(){
			alert($('#Kart_Id' + i).text());
			window.location.href="MusteriKartlarımDetay.jsp";
			},
		error:function(error){
			alert(error);
				
		 }
	  });
	}



</script>
</html>