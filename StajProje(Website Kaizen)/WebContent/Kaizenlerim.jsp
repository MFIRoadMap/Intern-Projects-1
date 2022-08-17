
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kaizen Görüntüle</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<%
	String sicil = request.getSession().getAttribute("sicil") + "";
%>
</head>

<style>
#tablo {
	margin-top: 50px;
	margin-right: 150px;
	margin-left: 150px;
	margin-bottom: 50px;
	background: white;
}

th {
	border-left: 1px solid #E0E0E0;
	border-top: 0;
	padding-left: 25px;
	font-size: 20px;
	background: gray;
}

td {
	border-bottom: 1px solid #E0E0E0;
	border-right: 1px solid #E0E0E0;
	background: #fff;
	padding: 6px;
	color: #474747;
	font: 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	font-size: 15px;
}

th, td {
	border-left: 1px solid;
	border-bottom: 2px solid;
	border-top: 2px solid;
	border-right: 1px solid;
	font: normal;
	
}


</style>
<body
	background="">

	<table id="tablo">
		<tr>
			<td></td>
		</tr>
	</table>


</body>
<script lang="javascript">
var sicil="<%=sicil%>";
	$(document).ready(function() {//metodu bunun içinde çağırıyoruz

		KaizenListele();

	});

	function yazSayfa(i) {

		$.ajax({
			url : "/StajProje/Servlet?islem=KaizenDetay" + "&KaizenId="
					+ $('#KaizenId' + i).text() + "&sicil=" + sicil,
			method : "GET",
			success : function(result) {
				window.location.href = "KaizenDetay.jsp";
			},
			error : function(error) {
				alert(error);

			}
		});
	}

	function KaizenListele() {

		$.get('./Servlet?islem=Kaizenler' + "&sicil=" + sicil, function(data) {
			$('#tablo').html(data);
		});
	}
</script>
</html>