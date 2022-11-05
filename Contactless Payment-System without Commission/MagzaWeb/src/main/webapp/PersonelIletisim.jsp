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

<body style = "background-image: url('Images/iletisim.jpg');background-position: center; background-repeat: repeat; background-size: cover;">



<div class = "row">

	<div class = "row" style = "padding-top:6%; padding-bottom:6%;">
		<form id = "form" class = "mx-auto w-auto col-9-md">
			<h2 style = "margin-top:5%;margin-bottom:5%;" class = "text-center">Mağza Mesajları</h2>
			<table id="IletisimTable"  class="table table-hover table-white" style = "background-color:#EEEEEE;">
		
			</table>
		</form>	
	</div>	
</div>

	

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

</body>


<script lang="javascript">

$(document).ready(function() {//metodu bunun içinde çağırıyoruz

	HasilatListele();
			
});


function HasilatListele() {

	$.post('./PersonelIletisimServlet?islem=IletisimListele', function(data) {
		$('#IletisimTable').html(data);
	});
	
}

//tablodaki satırlara tıklandığında detaylı olarak satışları görüntülemek için kullanlacak. Methodu manager sayfasında tabloyu doldururken onclick methodu ile çağırıyrum
function IletisimDetayGoster(i) {
	$.ajax({
		url:"/MagzaWeb/PersonelIletisimServlet?islem=IletisimDetayListele" 
			 + "&Iletisim_Id="+ $('#Iletisim_Id' + i).text(),
		method: "POST",
		success:function(){
			alert($('#Iletisim_Id' + i).text());
			window.location.href="PersonelIletisimDetay.jsp";
			},
		error:function(error){
			alert(error);
				
		 }
	  });
	}

</script>
</html>