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

<body style = "background-image: url('Images/durumsayfasi.png');background-position: center; background-repeat: no-repeat; background-size: cover;">

 <div class="row d-flex justify-content-center align-items-center h-100" style = "padding-top:5%; padding-bottom:5%">
      <div class="col col-xl-6 ">
       	  <div class = "row" >
	          <div class="card"  style = "background-color:#FEEC68; border-radius:30px;  padding:3%;">
					<h3 class = "text-center" style = "padding:2%;">Kasa Durum</h3>
					<form id = "form" class = "mx-auto w-auto col-6-md">
						<table>
							<tr>
								<td>Tarih</td> 
								<td> <input type="date"  class="form-control"  name="OzelTarihKasaDurum" id="OzelTarihKasaDurum" min='2010-01-01' onload="getDate()" require = "true"></td> 
							</tr>
							<tr>
								<td><input type="submit"  class="form-control btn btn-success"  value="submit" id="submit" /></td>
							</tr>
						</table>
					</form>	
				</div>
			</div>
		</div>	
	</div>
	
	<div class="row d-flex justify-content-center align-items-center" style = "margin-bottom:10%;">
		<div class = "col-xl-9">
			<div class = "row" >	
				<div class = "card"  style = "border-radius:15px; background-color:#FEEC68;">	
					<table id="HasilatDurum"  class="table table-hover table-white">
						
					</table>
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

	HasilatListele();
		
});


function HasilatListele() {

	$.post('./PersonelKasaDurumServlet?islem=KasaHasilatListele', function(data) {
		$('#HasilatDurum').html(data);
	});
}

//tablodaki satırlara tıklandığında detaylı olarak satışları görüntülemek için kullanlacak. Methodu manager sayfasında tabloyu doldururken onclick methodu ile çağırıyrum
function KasaDetayGoster(i) {
	$.ajax({
		url:"/MagzaWeb/PersonelKasaDurumServlet?islem=KasaDetayListele" 
			 + "&KasaId="+ $('#Kasa_Id' + i).text(),
		method: "POST",
		success:function(){
			alert($('#Kasa_Id' + i).text());
			window.location.href="PersonelKasaDurumDetayli.jsp";
			},
		error:function(error){
			alert(error);
				
		 }
	  });
	}
	
	
$("form").on("submit", function (e) {
    
    $.ajax({
      url: "/MagzaWeb/PersonelKasaDurumServlet?islem=DetayTarihSecim"  
    	  + "&OzelTarihKasaDurum=" + $('#OzelTarihKasaDurum').val(),
	 type: "POST",
	 success: function (newData) {
		 if (newData != "") {
			 alert("giris basarılı");
			 $('#HasilatDurum').html(newData);
			}
		else{
			alert("Hatalı Giris");
			}
      }
    });
 
    e.preventDefault();
});


</script>
</html>