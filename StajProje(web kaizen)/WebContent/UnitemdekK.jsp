    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<%
String OrgId=request.getSession().getAttribute("OrgId")+"";
%>
</head>
<style>

#ünitem{
margin-top: 50px;
margin-right: 330px;
margin-left: 330px;
margin-bottom: 50px;
background: white;
}
th{
 border-left: 1px solid #E0E0E0;
    border-top: 0;
    padding-left:25px;
    font-size: 20px;
    background: gray;
   }

td{
 border-bottom:1px solid #E0E0E0;
    border-right:1px solid #E0E0E0;
    background: #fff;
    padding: 6px;
    color: #474747;
    font:11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
    font-size: 15px;
}
th,td{

 
    border-left:1px solid ;
    border-bottom:2px solid ;
    border-top:2px solid;
    border-right: 1px solid;
    font:normal;
    font 15px , Verdana, Arial, Helvetica;
    }

</style>
<body background="">
<table id='ünitem'>
<tr>
<td ></td>
</tr>
</table>


</body>
<script lang="javascript">
var OrgId="<%=OrgId%>";

$(document).ready(function(){//metodu bunun içinde çağırıyoruz
	
	KaizenUniteListele();	
	
	
	
});
function KaizenUniteListele() {
	
	$.get('./Servlet?islem=Unitemde'	
			+"&OrgId="+OrgId	,
			function(data){
		$('#ünitem').html(data);
	});
}


	



</script>
</html>