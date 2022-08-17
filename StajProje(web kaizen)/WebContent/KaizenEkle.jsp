    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kaizen Ekle</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<%
String sicil=request.getSession().getAttribute("sicil")+"";
%>
</head>
<style>

#KaizenAçıklama{
height: 200px;
width: 400px;
 
}
#hizala{

margin-left: 35%;
margin-right: 35%;
}
p{
color:white;
font-size:20px;
margin-top: 30px;
}
#ekle{ 
    margin-top: 30px;
    height:30px;
    width:100px;

    background: #20B2AA;
    text-decoration:none;
    color:black;
    font:bold ;
    font-size :25px ;
    text-shadow: 0 -1px 1px rgba(0, 0, 0, 0.75);
    border-:5px solid #fff;
    box-shadow: 0 1px 2px rgba(0, 0, 0, 0.75);
    
    
}
#KaizenAd,#KaizenKonu,#KaizenOrg{
width: 250px;
height: 30px;
}
.ortak{

font-size: 24px;
font-style: inherit;

}
</style>
<body  background="">
<div id="hizala">
<p>ADI</p>
<input type="text" name="KaizenAd" Id="KaizenAd" class="ortak" maxlength="80">
<p>KONU</p>
<input type="text" name="KaizenKonu" Id="KaizenKonu" class="ortak" maxlength="400">
<p>UYGULANACAK ORGANİZASYON</p>
<input type="number" name="KaizenOrg" class="ortak" Id="KaizenOrg">
<p>AÇIKLAMA</p>
<textarea  name="KaizenAçıklama" Id="KaizenAçıklama" class="ortak" maxlength="2000"></textarea>
<br>
<input type="button" value="ekle" id="ekle"/>
</div>
</body>
<script lang="javascript">
var sicil="<%=sicil%>";
$(document).ready(function(){

});
$('#ekle').click(function(){
	kayit();
});
		function kayit() {
		$.ajax({
			url:"/StajProje/Servlet?islem=KaizenEkle" 
					+"&sicil="+sicil	
				+"&KaizenAd="+ $('#KaizenAd').val()
				+"&KaizenKonu="+ $('#KaizenKonu').val()
				+"&KaizenOrg="+ $('#KaizenOrg').val()
				+"&KaizenAçıklama="+ $('#KaizenAçıklama').val()
				,
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