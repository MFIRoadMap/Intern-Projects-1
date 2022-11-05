<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


<style>

html,
body,
#index {
    height: 90%;
}


.Intro {
    padding-bottom: 70px;
    padding-top: 265px;
    
    background: url('Images/store.jpg') no-repeat center center fixed;
    background-size: cover;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
}



#ContactUs{
	padding: 120px 0;
    background-color: 	#ffebcd;
}




#about {
    padding-top: 120px;
    padding-bottom: 70px;
    background-color: #9E9E9E;
}

.about-circle {
    width: 220px;
    height: 220px;
    border-radius: 220px;
    margin-bottom: 20px;
    border: 6px solid #f1f1f1; 
    margin: 0 auto;
}
.about-content h4 {
    font-family: 'Saira', sans-serif;
    font-size: 20px;
    font-weight: 700;
}
.about-content h5 {
    font-family: 'Saira', sans-serif;
    font-size: 15px;
    color: 777;
}
.about-content p {
    margin: 50px auto;
    font-family: 'Saira', sans-serif;
    font-size: 15px;
    color: 777;
}





#footer {
    padding: 15px 0;
}
#footer p {
    font-family: 'Saira', sans-serif;
    font-size: 15px;
    font-weight: 40;
    color: #555555;
    line-height: 40px;
}


</style>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	

</head>


<body>


<!-- buraya bootstrap ve jquery kütüphaneleri eklemesi gerekiyor. ayrıca css de eklenmeli 

onu da css dosyasından gerekli kısımları sayfaya ekleyeek tamamlarız-->


	<section id = "index">
		<div class = "container">
			<div class = "row">
			        <jsp:include page="TEMPLATEs\NavBarIndex.jsp" />
				</nav>
			</div>
		</div>
        <div class = "Intro">
			<div class ="row text-center">
				<div class = "col-lg-12">
					<h1>Web Siteme Hoşgeldiniz</h1>
				</div>
				<div class = "col-lg-12">
					<h2>Yazılarıma Gözatın</h2>
				</div>
				<div class = "col-lg-12">
					<a href = "#Giris"><button type = "button" class = "btn btn-primary btn-lg">Gezinmeye Başla</button></a>
				</div>
			</div>
		</div>
	</section>



<section id = "Giris">

	<div class = "text-center" style = "background-color:#C7C7C7; padding-top:1%; padding-bottom:1%;">
		<h2>Neden Biz?</h2>
	</div>
<div style = "padding-bottom:10%; padding-top:7%; background-color:#EFEAEA;">
 <div class="row">
  <div class="col-lg-4">
    <div class="card">
    <img class="card-img-top img-thumbnail" src="Images/uygunfiyat.jpg" style = "height:13rem;" >
      <div class="card-body">
        <h5 class="card-title text-center">Uygun Fiyat</h5>
        <p class="card-text text-center">With supporting text below as a natural lead-in to additional content.</p>
      </div>
    </div>
  </div>
  <div class="col-lg-4">
    <div class="card">
    <img class="card-img-top img-thumbnail" src="Images/memnuniyet.png" style = "height:13rem;">
      <div class="card-body">
        <h5 class="card-title text-center">Muşteri Memnuniyeti</h5>
        <p class="card-text text-center">With supporting text below as a natural lead-in to additional content.</p>
      </div>
    </div>
  </div>
    <div class="col-lg-4">
    <div class="card">
    <img class="card-img-top img-thumbnail" src="Images/kalite.jpg" style = "height:13rem;">
      <div class="card-body">
        <h5 class="card-title text-center">Kalite</h5>
        <p class="card-text text-center">With supporting text below as a natural lead-in to additional content.</p>
      </div>
    </div>
  </div>
</div>
</div>
	</section>





	<section id = "ContactUs">
		<div class = "container contact">
			<div class = "row">
				<div class = "col-md-4">
				
					<div class = "contact">
					<h2>Bize Ulaşın</h2>
					</div>
				</div>
				<div class = "col-md-7">
					<div class = "">
						<form>
							<div class="mb-3">
							  <label class = "">İsim</label>
							  <div class = "col-sm-10">          
								<input type = "text" required = "true" maxlength = "40"  id = "ContactIsim" name = "ContactIsim" class="form-control" />
							  </div>
							</div>
							<div class="mb-3">
							  <label class = "">Soyisim</label>
							  <div class = "col-sm-10">          
								<input type = "text" required = "true" maxlength = "40" id = "ContactSoyIsim" name = "ContactSoyIsim" class="form-control" />
							  </div>
							</div>
							<div class="mb-3">
							  <label class = "">Mail</label>
							  <div class = "col-sm-10">
								<input type = "email" required = "true" maxlength = "40" id = "ContactMail" name = "ContactMail" class="form-control" />
							  </div>
							</div>
							<div class="mb-3">
							  <label class = "">Konu</label>
							  <div class = "col-sm-10">
								<input type = "text" required = "true" maxlength = "40"  id = "ContactKonu" name = "ContacKonu" class="form-control" />
							  </div>
							</div>
							<div class="mb-3">
							  <label class = "">Acıklama</label>
							  <div class = "col-sm-10">
								<textarea rows = "3" required = "true" maxlength = "150" id = "ContactAciklama" name = "ContacAciklama" class="form-control" /></textarea>
							  </div>
							</div>
							<div class="mb-3">      
							  <div class = "">
								<button id="submit" type="submit" class = "btn btn-info">Gönder</button>
							  </div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section> 
        
 
            <section id = "about">
                <div class = "container">
                    <div class = "about-top text-center">
                        <h3>Mağzamız Hakkında</h3>
                    </div>
                    <div class = "about-content">
                        <div class = "row">
                            <div class = "col-lg-4 text-center">
                                <div class = "about-circle">
                                    <img style="width: 208px;  height: 208px; border-radius: 208px;" src = "Images/kurucu.jpg" />
                                </div>
                                    <h4>Muhammed Furkan Ilkel</h4>
                                    <h5>Kurucu</h5>
                                </div>
                                <div class = "col-lg-8">
                                    <p>
                                       2018 yılında kurduğumuz marka şirketi, toptan üretim ile başladığı girişimcilik serüvenini mağazacılık ve e-ticaret ile güçlendirmeyi başarmış, şubeleri ile de bu serüveni en ileri boyuta taşımıştır. Sunduğumuz kullanıcı öncelikli stratejilerimiz ve ayrıcalıklı müşteri portföyü ile değerini paha biçilemez şekilde ikiye katlayarak, marka değerimizi hassasiyetle zirveye taşımayı başardık. Dünya standartlarını göz önünde bulundurarak çözüm ve güven içerikli ilkemiz ile yola çıktığımız bu serüvende; otorite rayından çıkmayarak, istikrarlı şekilde sayısız müşteriye en iyi marka sahipliğini yapmış durumdayız.
                                       
                                    </p>
                                </div>
                            </div>
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
$(document).ready(function(){//metodu bunun içinde çağırıyoruz
	$('#PersonelGiris').click(function(){
		window.location.href="PersonelGiris.jsp";
	});
	
	$('#MusteriGiris').click(function(){
		window.location.href="MusteriGiris.jsp";
	});
	
});


$("form").on("submit", function (e) {
    
    $.ajax({
      url: "/MagzaWeb/IndexServlet?islem=Contact"  
			+ "&ContactIsim=" + $('#ContactIsim').val()
			+ "&ContactSoyIsim=" + $('#ContactSoyIsim').val()
			+ "&ContactMail=" + $('#ContactMail').val()
			+ "&ContactKonu=" + $('#ContactKonu').val()
	 		+ "&ContactAciklama=" + $('#ContactAciklama').val(),
	 type: "POST",
	 success: function (result) {
		 if (result!="") {
			 alert("giris basarılı");
				window.location.href="Index.jsp";
			}
		else{
				alert("Hatalı Giris");
			}
      }
    });
 
    e.preventDefault();
});


</script>

</html>