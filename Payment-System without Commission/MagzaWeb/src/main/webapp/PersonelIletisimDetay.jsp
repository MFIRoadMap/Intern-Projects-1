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
String IletisimDetayId = request.getSession().getAttribute("IletisimDetayId") + "";
%>

<style type="text/css">

tr{
padding:10%;
}
</style>
</head>

<body style = "background-image: url('Images/detay.jpg');background-position: center; background-repeat: repeat; background-size: cover;">


    <div class="row d-flex justify-content-center align-items-center h-140" style = "padding-top:5%; padding-bottom:5%">
      <div class="col col-md-6">
        <div class="card" style = "background-color:#bdcebe">
          <div class="row">
          <form id = "form"  class=" d-sm-block mx-auto w-auto col-8-md" style = "padding:5%;">
          <h2 class = "text-center" style = "margin-top:4%; margin-bottom:4%;"> Magaza Iletisim Detaylari </h2>
			<table id="IletisimTable" class = "text-center">
				
			</table>
			<input type="submit" value="Giderildi" id="submit" class="btn btn-primary btn-md btn-block form-control" />
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


var IletisimDetayId="<%=IletisimDetayId%>";


$(document).ready(function() {//metodu bunun içinde çağırıyoruz
	
	IletisimDetayListele();
			

});


$("form").on("submit", function (e) {
	$.ajax({
		url:"/MagzaWeb/PersonelIletisimServlet?islem=IletisimDurumGuncelle" 
			 + "&IletisimDetayId="+ IletisimDetayId,
		method: "POST",
		success:function(data){
			if (data == "1") {
				alert("Personel mesajı uygulandı olarak işaretlendi");
				window.location.href="PersonelAnasayfa.jsp";
			}
			else{
				alert("Düzeltilemedi");
			}
	      }
    });
 
    e.preventDefault();
});

function IletisimDetayListele() {
	$.ajax({
		url:"/MagzaWeb/PersonelIletisimServlet?islem=IletisimDetayListele" 
			 + "&IletisimDetayId="+ IletisimDetayId,
		method: "POST",
		success:function(data){
			$('#IletisimTable').html(data);
			},
		error:function(error){
			alert(error);
				
		 }
	  });
	}
	
</script>
</html>