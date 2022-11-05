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


<body style = "background-image: url('Images/alisveris2.png');background-position: center; background-repeat: repeat; background-size: cover;">

 <div class="row d-flex justify-content-center align-items-center h-100" style = "padding-top:5%; padding-bottom:5%">
      <div class="col col-xl-6 ">
       	  <div class="row " style = "padding:5%">
	          <div class = "card"  style = "border-radius:30px; background-color:#F9E79F; padding:3%">
	          <h3 class = "text-center" style = "padding:2%;"> Alışveriş Geçmişim </h3>
	          	<form id = "form2" class = "mx-auto w-auto col-6-md" >
					<table id="AlisverisGecmisiListele" class="table table-hover table-white">
						
					</table>
				</form>
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

$(document).ready(function() {//metodu bunun içinde çağırıyoruz

	MusteriAlisverisListele();
			
});

function MusteriAlisverisListele() {
	$.ajax({
		url:"/MagzaWeb/MusteriAlisverisGecmisiServlet?islem=MusteriAlisverisListele" 
			 + "&Musteri_Id="+ Musteri_Id,
		method: "POST",
		success:function(data){
			$('#AlisverisGecmisiListele').html(data);
			},
		error:function(error){
			alert(error);
		 }
	  });
	}
	
function MusteriAlisverisListeleDetay(i) {
	$.ajax({
		url:"/MagzaWeb/MusteriAlisverisGecmisiServlet?islem=MusteriAlisverisListeleDetay" 
			 + "&Satis_Fis_Id="+ $('#Satis_Fis_Id' + i).text(),
		method: "POST",
		success:function(){
			alert($('#Satis_Fis_Id' + i).text());
			window.location.href="MusteriAlisverisGecmisiDetay.jsp";
			},
		error:function(error){
			alert(error);
				
		 }
	  });
	}

</script>
</html>