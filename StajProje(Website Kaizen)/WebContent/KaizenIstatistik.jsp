
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<%
	String seviye = request.getSession().getAttribute("seviye") + "";
	String OrgId = request.getSession().getAttribute("OrgId") + "";
%>
<style>
#tablo {
	margin-top: 50px;
	margin-right: 30px;
	margin-left: 30px;
	margin-bottom: 50px;
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
	font-size: 15px;
}
th, td {
	border-left: 1px solid;
	border-bottom: 2px solid;
	border-top: 2px solid;
	border-right: 1px solid;
	font: normal;
}
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #34495e;
}
li {
	display: inline-block;
}
li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}
li a:hover {
	background-color: #f39c12;
}
ul li ul {
	background-color: #2c3e50;
	display: none;
	position: absolute;
	width: 100px
}
ul li:hover ul {
	display: block;
}
li ul li {
	display: block;
}
.butonlar {
	background: #2c3e50;
	font-size: 15px;
	color: white;
	width: 100px;
	height: 20px;
}
p {
	font-size: 20px;
	color: white;
}
</style>
<body
	background="">

	<ul>
		<li><p>Detaylar</p>
			<ul>

				<li id="seviye1"><input type="button" id="buton1"
					value="Stajyer" class="butonlar"></li>

				<li id="seviye2"><input type="button" id="buton2"
					value="Mühendis" class="butonlar"></li>

				<li id="seviye3"><input type="button" id="buton3"
					value="Baş Mühendis" class="butonlar"></li>

				<li id="seviye4"><input type="button" id="buton4" value="Müdür"
					class="butonlar"></li>

			</ul></li>
	</ul>

	<table id="tablo" style="background-color: #ffffff">
		<tr>
			<td></td>
		</tr>
	</table>

</body>
<script lang="javascript">
var OrgId="<%=OrgId%>";
var seviye="<%=seviye%>";
	$(document).ready(function() {//metodu bunun içinde çağırıyoruz
		sayfaGiris();

		if (seviye == 1) {
			jQuery("#seviye2").attr("style", "display: none");
			jQuery("#seviye3").attr("style", "display: none");
			jQuery("#seviye4").attr("style", "display: none");
		} else if (seviye == 2) {
			jQuery("#seviye3").attr("style", "display: none");
			jQuery("#seviye4").attr("style", "display: none");
		} else if (seviye == 3) {
			jQuery("#seviye4").attr("style", "display: none");
		}

		OrgId = Number(OrgId);
		seviye = Number(seviye);
		$('#buton1').click(function() {
			//syajyeri hepsi görebiliyor
			if (seviye == 1) {
				Stajyer(OrgId, seviye);
			} else if (seviye == 2) {
				org = OrgId - 1;
				sev = seviye - 1;
				Stajyer(org, sev);
			} else if (seviye == 3) {//basmühendis girisi için
				org = OrgId - 2;
				sev = seviye - 2;
				Stajyer(org, sev);
			} else if (seviye == 4) {//müdür girisi için
				org = OrgId - 3;
				sev = seviye - 3;
				Stajyer(org, sev);
			}

		});
		$('#buton2').click(function() {

			//mühendisi sadece üsütü görebilir

			if (seviye == 2) {
				org = OrgId;
				sev = seviye;
				Muhendis(org, sev);
			} else if (seviye == 3) {
				org = OrgId - 1;
				sev = seviye - 1;
				Muhendis(org, sev);
			} else if (seviye == 4) {
				org = OrgId - 2;
				sev = seviye - 2;
				Muhendis(org, sev);

			}

		});
		$('#buton3').click(function() {

			if (seviye == 3) {
				org = OrgId;
				sev = seviye;
				BasMuhendis(org, sev);
			} else if (seviye == 4) {
				org = OrgId - 1;
				sev = seviye - 1;
				BasMuhendis(org, sev);
			}
		});

		$('#buton4').click(function() {

			if (seviye == 4) {
				org = OrgId;
				sev = seviye;
				Mudur(org, sev);
			}
		});

	});

	function Stajyer(org, sev) {
		$.ajax({
			url : "/StajProje/Servlet?islem=Buton" + "&org=" + org + "&sev="
					+ sev,
			method : "GET",
			success : function() {
				window.location.href = "IstatistikGrafik.jsp";
			},
			error : function(error) {
				alert(error);

			}
		});
	}

	function Muhendis(org, sev) {
		$.ajax({
			url : "/StajProje/Servlet?islem=Buton" + "&org=" + org + "&sev="
					+ sev,
			method : "GET",
			success : function() {
				window.location.href = "IstatistikGrafik.jsp";
			},
			error : function(error) {
				alert(error);

			}
		});
	}

	function BasMuhendis(org, sev) {
		$.ajax({
			url : "/StajProje/Servlet?islem=Buton" + "&org=" + org + "&sev="
					+ sev,
			method : "GET",
			success : function() {
				window.location.href = "IstatistikGrafik.jsp";
			},
			error : function(error) {
				alert(error);

			}
		});
	}
	function Mudur(org, sev) {
		$.ajax({
			url : "/StajProje/Servlet?islem=Buton" + "&org=" + org + "&sev="
					+ sev,
			method : "GET",
			success : function() {
				window.location.href = "IstatistikGrafik.jsp";
			},
			error : function(error) {
				alert(error);

			}
		});
	}

	function sayfaGiris() {

		$.ajax({
			url : "/StajProje/Servlet?islem=Istatistik" + "&OrgId=" + OrgId,
			method : "GET",
			success : function(result) {
				$('#tablo').html(result);
			},
			error : function(error) {
				alert(error);

			}
		});
	}
</script>
</html>