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
String KasaDetayId = request.getSession().getAttribute("KasaDetayId") + "";
String OzelTarihKasaDurum = request.getSession().getAttribute("OzelTarihKasaDurum") + "";
%>
</head>

<body style = "background-image: url('Images/detali.jpg');background-position: center; background-repeat: repeat; background-size: cover;">

 <div class="row d-flex justify-content-center align-items-center h-100" style = "padding-top:5%; padding-bottom:5%">
      <div class="col col-xl-10 ">
       	 
			<h3 class = "text-center" style = "padding:2%;">Kasa Detaylı Durum</h3>
			<form id = "form" class = "mx-auto w-auto col-10-md">
				 <div class = "row" >	  
					  <div class="card"  style = "background-color:#E2E2E1; border-radius:15px;  margin-top:3%; margin-bottom:3%; padding-top:3%; padding-bottom:3%;">
						<table id="Satislar" class="table table-hover table-white col-10-md">
							
						</table>
					</div>
				</div>			
						
				<div>
					<div class="card"  style = "background-color:#E2E2E1; border-radius:15px;  margin-top:3%; margin-bottom:3%; padding-top:3%; padding-bottom:3%;">
						<table id="Iadeler" class="table table-hover table-white col-10-md">
							
						</table>
					</div>
				</div>
			</form>	
		</div>
	</div>	
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

</body>


<script lang="javascript">

var KasaDetayId="<%=KasaDetayId%>";
var OzelTarihKasaDurum="<%=OzelTarihKasaDurum%>";

$(document).ready(function() {//metodu bunun içinde çağırıyoruz

	KasaDetayListeleSatis();
	KasaDetayListeleIade();
			
});


function KasaDetayListeleSatis() {
	$.ajax({
		url:"/MagzaWeb/PersonelKasaDurumServlet?islem=KasaDetayListeleSatis" 
			 + "&KasaDetayId="+ KasaDetayId
			 + "&OzelTarihKasaDurum="+ OzelTarihKasaDurum,
		method: "POST",
		success:function(data){
			$('#Satislar').html(data);
			},
		error:function(error){
			alert(error);
				
		 }
	  });
	}

function KasaDetayListeleIade() {
	$.ajax({
		url:"/MagzaWeb/PersonelKasaDurumServlet?islem=KasaDetayListeleIade" 
			 + "&KasaDetayId="+ KasaDetayId
			 + "&OzelTarihKasaDurum="+ OzelTarihKasaDurum,
		method: "POST",
		success:function(data){
			$('#Iadeler').html(data);
			},
		error:function(error){
			alert(error);
				
		 }
	  });
	}

</script>
</html>