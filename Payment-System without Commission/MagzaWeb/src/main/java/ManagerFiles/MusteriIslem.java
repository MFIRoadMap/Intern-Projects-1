while (rs.next()) {
  byte[] image = rs.getBytes("Urun_Gorsel");
  String base64Encoded = new String(Base64.encodeBase64(image), "UTF-8");
  icerik += "<div class = \"col-lg-4 container d-flex align-items-center justify-content-center\"   > "
      + "<div style = \" padding: 10px; \">"
      + "<div class=\"card none d-lg-block \" style=\" width: 20rem; padding:3%; \" onclick='MusteriSiparisEkle(" + i + ")' > \n"
        +"<img src=\"data:image/png;base64, " + base64Encoded + "\" class=\"card-img-top img-thumbnail card-img-top\" style = \" height:13rem; \"/>"+
        "<div class = \"card-body \">"+
            "<h6 class = \"card-title\" id='Urun_Barkod" + i + "' style = \" visibility: hidden \">"+rs.getString("Urun_Barkod")+"</h6>"+
            "<h5 class = \"card-title\" id='Urun_Marka" + i + "'>"+" Marka: "+rs.getString("Urun_Marka")+"</h5>"+
            "<h5 class = \"card-title\" id='Urun_Isim" + i + "'>"+" Isim: "+rs.getString("Urun_Isim")+"</h5>"+
            "<p class = \"card-subtitle text-muted\" id='Urun_Stok" + i + "'>"+" Stok: "+ rs.getString("Urun_Stok")+"</p>"+
            "<p class = \"card-subtitle text-muted\" id='Urun_Fiyat" + i + "'>"+" Fiyat: "+ rs.getString("Urun_Fiyat")+"</p>"+
          "</div>"
        +"</div>"
        +"</div>"
        +"</div>";
  i++;
}



