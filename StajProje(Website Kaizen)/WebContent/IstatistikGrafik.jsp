    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<%
String OrgId=request.getSession().getAttribute("OrgId")+"";
String seviye=request.getSession().getAttribute("seviye")+"";
String olustu=request.getSession().getAttribute("olustu")+"";
String amirOnay=request.getSession().getAttribute("amirOnay")+"";
String mudurOnay=request.getSession().getAttribute("mudurOnay")+"";
String kaizRehbOnay=request.getSession().getAttribute("kaizRehbOnay")+"";
String kaizMudurOnay=request.getSession().getAttribute("kaizMudurOnay")+"";
String tamamland=request.getSession().getAttribute("tamamland")+"";
String reddEdildi=request.getSession().getAttribute("reddEdildi")+"";
String kabulEdildi=request.getSession().getAttribute("kabulEdildi")+"";
String organizasSayfa=request.getSession().getAttribute("organizasSayfa")+"";
String seviyeSatfa=request.getSession().getAttribute("seviyeSatfa")+"";
%>
<style>
#tablo{
margin-top: 50px;
margin-right: 50px;
margin-left: 50px;
margin-bottom: 50px;}
th{
 border-left: 1px solid #E0E0E0;
    border-top: 0;
    padding-left:25px;
    font-size: 20px;
    background: gray;  }
td{
 border-bottom:1px solid #E0E0E0;
    border-right:1px solid #E0E0E0;
    background: #fff;
    padding: 6px;
    color: #474747;
    font-size: 15px;}
th,td{
    border-left:1px solid ;
    border-bottom:2px solid ;
    border-top:2px solid;
    border-right: 1px solid;
    font:normal;
}
#durumlar{
margin-left: 5%;
margin-top: 10px;}


</style>
<body  background="">



<table id="durumlar" >
<tr><th>Oluşturulan</th><th>Amir Onayında</th><th> Müdür Onayında</th><th>Kaizen Rehber</th>
<th>Kaizen Müdür</th><th>Tamamlandı</th><th>Red Edildi</th><th>Kabul Edildi</th></tr>
<tr>
<td id="alan1"></td>
<td id="alan2"></td>
<td id="alan3"></td>
<td id="alan4"></td>
<td id="alan5"></td>
<td id="alan6"></td>
<td id="alan7"></td>
<td id="alan8"></td></tr>
</table>



<table id="tablo" style="background-color:#ffffff ">
<tr>
<td></td>
</tr>
</table>



<canvas id="canvas" width="1300" height="1050" style="border:1px solid;">

</canvas>


</body>
<script lang="javascript">
var OrgId="<%=OrgId%>";
var seviye="<%=seviye%>";
var olustu="<%=olustu%>";
var amirOnay="<%=amirOnay%>";
var mudurOnay="<%=mudurOnay%>";
var kaizRehbOnay="<%=kaizRehbOnay%>";
var kaizMudurOnay="<%=kaizMudurOnay%>";
var tamamland="<%=tamamland%>";
var reddEdildi="<%=reddEdildi%>";
var kabulEdildi="<%=kabulEdildi%>";
var organizasSayfa="<%=organizasSayfa%>";
var seviyeSatfa="<%=seviyeSatfa%>";
$(document).ready(function(){
	yukle();
	tablo();
	grafik();
});


function grafik(){
	var oran=0;//değerleri sayıya çeviriyorum
	k1=Number(olustu);
	k2=Number(amirOnay);
	k3=Number(mudurOnay);
	k4=Number(kaizRehbOnay);
	k5=Number(kaizMudurOnay);
	k6=Number(tamamland);
	k7=Number(reddEdildi);
	k8=Number(kabulEdildi);
	
	
	oran=k1+k2+k3+k4+k5+k6+k7+k8;//toplamlarını alıp max 
	//alabileceği değeri tutuyorum
	var hesap=850;
	
	
	var t=document.getElementById('canvas');
	var cizim=t.getContext("2d");
	cizim.beginPath();//çizimi başlattık
	
	cizim.fillText("Oluşan    ",50,220);
	cizim.fillText("İlk Amir  ",50,320);
	cizim.fillText("Müdür     ",50,420);
	cizim.fillText("Kaiz Rehb ",50,520);
	cizim.fillText("Kaiz Müdür",50,620);
	cizim.fillText("Tamamlanan",50,720);
	cizim.fillText("Red Edil  ",50,820);
	cizim.fillText("Kabul Edil",50,920);
  
	
	cizim.moveTo(1250,1000);
	cizim.lineTo(150,1000);

	cizim.moveTo(150,150);
	cizim.lineTo(150,1000);

	cizim.moveTo(30,380);//baslangıç noktaısnı gösteriyor
	cizim.fillRect(150,200,(hesap*k1)/oran,30);
	cizim.fillRect(150,300,(hesap*k2)/oran,30);
	cizim.fillRect(150,400,(hesap*k3)/oran,30);
	cizim.fillRect(150,500,(hesap*k4)/oran,30);
	cizim.fillRect(150,600,(hesap*k5)/oran,30);
	cizim.fillRect(150,700,(hesap*k6)/oran,30);
	cizim.fillRect(150,800,(hesap*k7)/oran,30);
	cizim.fillRect(150,900,(hesap*k8)/oran,30);
	
	
	  
	
	cizim.stroke();
	}
   function tablo() {
	   $.ajax({
			url:"/StajProje/Servlet?islem=tabloAl"
				+"&organizasSayfa="+organizasSayfa
				+"&seviyeSatfa="+seviyeSatfa,
			method: "GET",
			success:function(result){
				$('#tablo').html(result);},
			error:function(error){
				alert(error);
					
			 }
		  });
}
		
	function yukle(){
		$('#alan1').html(olustu);
		$('#alan2').html(amirOnay);
		$('#alan3').html(mudurOnay);
		$('#alan4').html(kaizRehbOnay);
		$('#alan5').html(kaizMudurOnay);
		$('#alan6').html(tamamland);
		$('#alan7').html(reddEdildi);
		$('#alan8').html(kabulEdildi);
		}

</script>
</html>