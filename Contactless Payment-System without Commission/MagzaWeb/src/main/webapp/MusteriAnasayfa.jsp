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

<style>
#index {
    padding-bottom: 70px;
    padding-top: 300px;
    
    background: url('Images/store.jpg') no-repeat center center fixed;
    background-size: cover;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
}
</style>

<body>


	<section id = "index">
		<div class = "container">
			<div class = "row">
			        <jsp:include page="TEMPLATEs\NavBarMusteri.jsp" />
				</nav>
			</div>
		</div>
	</section>

	<section id = "Urunlar">
		<div ">
			<div style = " padding-top:2%; padding-bottom:2%;  background-color:#848484;">
			<h2 class = "text-center ">Mağazamızdaki Ürünler</h2>
			</div>
		
			<div class = "row"  id = "UrunTable" style = "padding-top:5%; padding-bottom:5%; background-color:#E2E5E4;">
			
			</div>
	</div>
	</section>

                <section id = "footer" style = "background-color:#C7C7C7; padding-top:2%; padding-bottom:1%;">
                    <div class = "container">
                        <div class = "row"> 
                            <div class = "col-lg-6">
                                <p>| Copyright © 2020-2021 MFIBlog.com |</p>
                            </div>
                        </div>
                    </div>
                </section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

</body>

<script lang="javascript">

var Musteri_Id="<%=Musteri_Id%>";


$(document).ready(function(){

	
	UrunListele();


	$('#MusteriBilgi').click(function(){
		MB();
	});
	$('#MusteriKartlarim').click(function(){
		window.location.href="MusteriKartlarım.jsp";
	});
	$('#MusteriAlisverisGecmisi').click(function(){
		window.location.href="MusteriAlisverisGecmisi.jsp";
	});
	$('#MusteriSiparisVer').click(function(){
		window.location.href="MusteriSiparisVer.jsp";
	});
	$('#Cikis').click(function(){
		MC();
	});
	
});


function UrunListele() {

	$.post('./MusteriSiparisVerServlet?islem=MusteriUrunListele', function(data) {
		$('#UrunTable').html(data);
	});
}


function MB() {
	
	$.ajax({
		url:"/MagzaWeb/MusteriBilgiGetirServlet?islem=MusteriBilgiGetir" 
			 + "&Musteri_Id="+ Musteri_Id,
		method: "POST",
		success:function(){
			window.location.href="MusteriBilgilerim.jsp";
			},
		error:function(error){
			alert(error);
				
		 }
	  });
	}



function MC() {
	$.ajax({
		url:"/MagzaWeb/MusteriCikisServlet?islem=MusteriCikis",
		method: "POST",
		success:function(){
			window.location.href="Index.jsp";
			},
		error:function(error){
			alert(error);
				
		 }
	  });
	}

</script>

</html>