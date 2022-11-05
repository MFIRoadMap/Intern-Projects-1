/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

/**
 *
 * @author furka
 */
public class KartUrunSatis_Beans {
    
     String Urun_Barkod, Urun_Marka, Urun_Isim, Urun_Stok, Urun_Durum, Urun_Fiyat,
             Kart_Id, Satis_Id;
     byte [] Image;

    public KartUrunSatis_Beans(String Urun_Barkod, String Urun_Marka, String Urun_Isim, String Urun_Stok, String Urun_Durum, String Urun_Fiyat, String Kart_Id, String Satis_Id, byte[] Image) {
        this.Urun_Barkod = Urun_Barkod;
        this.Urun_Marka = Urun_Marka;
        this.Urun_Isim = Urun_Isim;
        this.Urun_Stok = Urun_Stok;
        this.Urun_Durum = Urun_Durum;
        this.Urun_Fiyat = Urun_Fiyat;
        this.Kart_Id = Kart_Id;
        this.Satis_Id = Satis_Id;
        this.Image = Image;
    }

    public String getUrun_Barkod() {
        return Urun_Barkod;
    }

    public void setUrun_Barkod(String Urun_Barkod) {
        this.Urun_Barkod = Urun_Barkod;
    }

    public String getUrun_Marka() {
        return Urun_Marka;
    }

    public void setUrun_Marka(String Urun_Marka) {
        this.Urun_Marka = Urun_Marka;
    }

    public String getUrun_Isim() {
        return Urun_Isim;
    }

    public void setUrun_Isim(String Urun_Isim) {
        this.Urun_Isim = Urun_Isim;
    }

    public String getUrun_Stok() {
        return Urun_Stok;
    }

    public void setUrun_Stok(String Urun_Stok) {
        this.Urun_Stok = Urun_Stok;
    }

    public String getUrun_Durum() {
        return Urun_Durum;
    }

    public void setUrun_Durum(String Urun_Durum) {
        this.Urun_Durum = Urun_Durum;
    }

    public String getUrun_Fiyat() {
        return Urun_Fiyat;
    }

    public void setUrun_Fiyat(String Urun_Fiyat) {
        this.Urun_Fiyat = Urun_Fiyat;
    }

    public String getKart_Id() {
        return Kart_Id;
    }

    public void setKart_Id(String Kart_Id) {
        this.Kart_Id = Kart_Id;
    }

    public String getSatis_Id() {
        return Satis_Id;
    }

    public void setSatis_Id(String Satis_Id) {
        this.Satis_Id = Satis_Id;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] Image) {
        this.Image = Image;
    }
    
 
    
    
}
