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


<body style = "background-image: url('Images/uruns.png');background-position: center; background-repeat: repeat; background-size: cover;">
	<section id = "Urunlar">
		<div class = "" >
			<h2 style = "padding:3%" class = "text-center "> Ürün Durumu </h2>
		</div>
		<div class = "row" class = "container"  id = "UrunTable">
			
			
		</div>
	</section>

	


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

</body>

<script lang="javascript">


$(document).ready(function() {//metodu bunun içinde çağırıyoruz

	UrunListele();

});
function UrunListele() {

	$.post('./PersonelUrunDurumServlet?islem=UrunDurumListele', function(data) {
		$('#UrunTable').html(data);
	});
}

</script>

</html>