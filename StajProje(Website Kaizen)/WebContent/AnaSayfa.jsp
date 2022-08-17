
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ana Sayfa</title>

</head>
<style>
.butonsayfa {
	height: 90px;
	width: 300px;
	margin-bottom: 5px;
	margin-top: 5px;
	background: gray;
	text-decoration: none;
	color: #fff;
	font: bold;
	font-size: 36px;
	text-shadow: 0 -1px 1px rgba(0, 0, 0, 0.75);
	border-: 5px solid #fff;
	box-shadow: 0 1px 2px rgba(0, 0, 0, 0.75);
}

#içerik {
	margin-top: 80px;
	margin-right: 350px;
	margin-bottom: 100px;
	margin-left: 550px;
	padding-top: 40px;
	padding-right: 150px;
	padding-left: 150px;
	padding-bottom: 40px;
}

body {
	background-size: 1350px;
}
</style>
<body background="">

	<div id="içerik">

		<input type="button" value="Kaizenlerim" class="butonsayfa"
			id="Kaizenler"
			onclick="window.setTimeout(function(){location.href = 'http://localhost:8081/StajProje/Kaizenlerim.jsp'});">
		<input type="button" value="İstatistik" class="butonsayfa"
			id="Istatistik"
			onclick="window.setTimeout(function(){location.href = 'http://localhost:8081/StajProje/KaizenIstatistik.jsp'});">
		<input type="button" value="Ünitem" class="butonsayfa" id="Unitem"
			onclick="window.setTimeout(function(){location.href = 'http://localhost:8081/StajProje/UnitemdekK.jsp'});">
		<input type="button" value="Kaizen Ekle" id="Ekle" class="butonsayfa"
			onclick="window.setTimeout(function(){location.href = 'http://localhost:8081/StajProje/KaizenEkle.jsp'});">


	</div>
</body>

</html>