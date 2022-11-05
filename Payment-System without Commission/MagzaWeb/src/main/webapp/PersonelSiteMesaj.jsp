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

<body style = "background-image: url('Images/still.jpg');background-position: center; background-repeat: repeat; background-size: cover;">
 
 <div class="row d-flex justify-content-center align-items-center h-100" style = "padding-top:5%; padding-bottom:5%">
      <div class="col col-xl-6 ">
       	  <div class="row " style = "padding:10%">
	          <div class = "card"  style = "border-radius:30px; background-color:#CBFFC7; padding:3%">
	          <h3 class = "text-center" style = "padding:2%;">Site Mesaj Güncelle</h3>
	          	<form id = "form2" class = "mx-auto w-auto col-6-md" >
					<table>
						<tr>
						<td><label>Mesaj Id:</label></td>
						<td><select id="MesajId"  class="form-control" required >
						
						</select></td>
						<tr>
						<td><input class="form-control btn btn-danger" name = "Kasa Durum Güncelle" value = "Mesaj Okundu" type = "button" id="MesajDurumGuncelle" /></td>
						</tr>
						
					</table>
				</form>
			</div>
		</div>	
	</div>
</div>
<div class="row d-flex justify-content-center align-items-center" style = "margin-bottom:10%;">
	<div class = "col-xl-10">
		<div class = "row" >	
			<div class = "card"  style = "border-radius:15px; background-color:#CBFFC7;">
				<form class = "mx-auto w-auto ">
					<table id = "content" class="table table-hover table-white text-center">
								
					</table>
				</form>
			</div>
		</div>
	</div>
</div>
	
<div class="row d-flex justify-content-center align-items-center" style = "margin-bottom:10%;">
	<div class = "col-xl-10">
		<div class = "row" >	
			<div class = "card"  style = "border-radius:15px; background-color:#CBFFC7;">
				<form class = "mx-auto w-auto ">
					<table id = "okunanlar" class="table table-hover table-white text-center">
								
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


$(document).ready(function() {//metodu bunun içinde çağırıyoruz

	$.post('/MagzaWeb/PersonelSiteMesajServlet?islem=PersonelSiteMesajListele', function(data) {
		$('#content').html(data);
	});
	
	$.post('/MagzaWeb/PersonelSiteMesajServlet?islem=PersonelSiteMesajListeleOkunanlar', function(data) {
		$('#okunanlar').html(data);
	});
	
	$.post('/MagzaWeb/PersonelSiteMesajServlet?islem=SiteMesajIdListele', function(data) {
		$('#MesajId').html(data);
	});
	
	$('#MesajDurumGuncelle').click(function(){
		SiteMesajGuncelle();
	});
		
});

function SiteMesajGuncelle() {
    
    $.ajax({
    	type: "POST",
    	url:"/MagzaWeb/PersonelSiteMesajServlet?islem=SiteMesajDurumGuncelle"  
	 		+ "&MesajId=" + $('#MesajId').val(),
	 success: function (result) {
		 if (result == "1") {
				alert($('#MesajId').val()+" Okundu olarak işaretlendi");
				window.location.href="PersonelAnasayfa.jsp";
			}
		else{
				alert("Hatalı Giris");
			}
	 }
	  });
	}


//tablodaki satırlara tıklandığında detaylı olarak satışları görüntülemek için kullanlacak. Methodu manager sayfasında tabloyu doldururken onclick methodu ile çağırıyrum



</script>
</html>