
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Giris Sayfası</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>

<style>
#icerik {
	font-size: 13px;
	color: #000;
	text-decoration: none;
	line-height: 22px;
	margin-top: 10%;
	margin-right: 43%;
	margin-bottom: 10%;
	margin-left: 43%;
}

#giris {
	background-color: #20B2AA;
	padding: 5px 20px;
	text-decoration: none;
	color: black;
	font-size: 24px;
	box-shadow: 0 1px 2px #000;
	text-shadow: 0 -1px 1px rgba(0, 0, 0, 0.25);
	border-radius: 30px
}

#sicil {
	height: 30px;
	width: 120px;
}

h3 {
	color: black;
	font-size: 20px;
	font-style: italic;
}
</style>
<body
	background="">

	<div id="icerik">
		<table>

			<tr>
				<td><h3>Sicil</h3></td>
				<td><input type="text" name="sicil" id="sicil" /></td>
				<td><input type="button" value="Giris" id="giris" /></td>
			</tr>


		</table>
	</div>
</body>

<script lang="javascript">
	$(document).ready(function() {

	});

	$('#giris').click(function() {
		Giris();
	});

	function Giris() {

		$.ajax({
			url : "/StajProje/Servlet?islem=Giris" + "&sicil="
					+ $('#sicil').val(),
			method : "GET",
			success : function(result) {
				if (result == "1" || result == "2" || result == "3"
						|| result == "4") {
					window.location.href = "AnaSayfa.jsp";
				}
			},
			error : function(error) {
				alert(error);

			}
		});
	}
</script>
</html>