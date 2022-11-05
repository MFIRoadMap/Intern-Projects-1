/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

/**
 *
 * @author furka
 */
public class SiparisBeans {
    
    
    String SHT_Id, SHT_MusteriId, SHT_AlimTime, SHT_Durum, SHT_Siparis_Tarih, SFT_FisId;

    public SiparisBeans(String SHT_Id, String SHT_MusteriId, String SHT_AlimTime, String SHT_Durum, String SHT_Siparis_Tarih, String SFT_FisId) {
        this.SHT_Id = SHT_Id;
        this.SHT_MusteriId = SHT_MusteriId;
        this.SHT_AlimTime = SHT_AlimTime;
        this.SHT_Durum = SHT_Durum;
        this.SHT_Siparis_Tarih = SHT_Siparis_Tarih;
        this.SFT_FisId = SFT_FisId;
    }

    public String getSHT_Id() {
        return SHT_Id;
    }

    public void setSHT_Id(String SHT_Id) {
        this.SHT_Id = SHT_Id;
    }

    public String getSHT_MusteriId() {
        return SHT_MusteriId;
    }

    public void setSHT_MusteriId(String SHT_MusteriId) {
        this.SHT_MusteriId = SHT_MusteriId;
    }

    public String getSHT_AlimTime() {
        return SHT_AlimTime;
    }

    public void setSHT_AlimTime(String SHT_AlimTime) {
        this.SHT_AlimTime = SHT_AlimTime;
    }

    public String getSHT_Durum() {
        return SHT_Durum;
    }

    public void setSHT_Durum(String SHT_Durum) {
        this.SHT_Durum = SHT_Durum;
    }

    public String getSHT_Siparis_Tarih() {
        return SHT_Siparis_Tarih;
    }

    public void setSHT_Siparis_Tarih(String SHT_Siparis_Tarih) {
        this.SHT_Siparis_Tarih = SHT_Siparis_Tarih;
    }

    public String getSFT_FisId() {
        return SFT_FisId;
    }

    public void setSFT_FisId(String SFT_FisId) {
        this.SFT_FisId = SFT_FisId;
    }
    
}
