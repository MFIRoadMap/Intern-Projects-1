    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<%
String sicil=request.getSession().getAttribute("sicil")+"";
String secim=request.getSession().getAttribute("secim")+"";
%>
</head>
<style>


p{
padding-left:30%;
padding-right: 30%; 
text-align:center;
font-size:20px; 
margin-bottom: 20px;
margin-top: 20px;
}
.label{
font-size: 25px;
color: blue;
}
#gecis,#sil{
 background-color:#a4cf7e;
  padding: 5px 20px;
    text-decoration:none;
    color:black;
    font-size: 24px;
    box-shadow: 0 1px 2px #000;
    text-shadow: 0 -1px 1px rgba(0, 0, 0, 0.25);
    border-radius: 30px;
 
    margin-left: 28%;
    margin-top: 20px;
     margin-bottom: 20px;
}


</style>
<body background="">
<span id="yaz"></span>

<input type="button" id="gecis" value="Güncelle" >
<input type="button" id="sil" value="Sil" >
</body>
<script lang="javascript">
var sicil="<%=sicil%>";
var secim="<%=secim%>";
$(document).ready(function(){//metodu bunun içinde çağırıyoruz
	Detay();
	
	$('#gecis').click(function(){
		Gecis();
	});
	$('#sil').click(function(){
		Delete();
	});
	
});
function Detay() {
	
	$.ajax({
		url:"/StajProje/Servlet?islem=Kaizenislem"
				+"&sicil="+ sicil
				+"&secim="+ secim,
		method: "GET",
		success:function(result){
			$('#yaz').html(result);},
		error:function(error){
			alert(error);
				
		 }
	  });
	}

function Gecis() {
	
$.ajax({
	url:"/StajProje/Servlet?islem=KaizenYazGetir"
        +"&secim="+ secim,
	method: "GET",
	success:function(){
		window.location.href="KaizenYaz.jsp";
	},
	error:function(error){
		alert(error);
			
	 }
  });
}

function Delete() {
	
	$.ajax({
		url:"/StajProje/Servlet?islem=KaizenDelete"
				+"&secim="+ secim,
		method: "GET",
		success:function(){
			window.location.href="AnaSayfa.jsp";},
		error:function(error){
			alert(error);
				
		 }
	  });
	}
	

</script>
</html>