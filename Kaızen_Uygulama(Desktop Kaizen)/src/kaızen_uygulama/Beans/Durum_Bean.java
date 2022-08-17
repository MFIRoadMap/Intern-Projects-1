/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaızen_uygulama.Beans;

/**
 *
 * @author MFİ
 */
public class Durum_Bean {
  int oluşturulud , ilkAmirOnayı, müdürOnayı , kaizenRehberOnayı , kaizenMüdür , tamamlandı, reddedildi , kabuledildi ;  

    public Durum_Bean(int oluşturulud, int ilkAmirOnayı, int müdürOnayı, int kaizenRehberOnayı, int kaizenMüdür, int tamamlandı, int reddedildi, int kabuledildi) {
        this.oluşturulud = oluşturulud;
        this.ilkAmirOnayı = ilkAmirOnayı;
        this.müdürOnayı = müdürOnayı;
        this.kaizenRehberOnayı = kaizenRehberOnayı;
        this.kaizenMüdür = kaizenMüdür;
        this.tamamlandı = tamamlandı;
        this.reddedildi = reddedildi;
        this.kabuledildi = kabuledildi;
    }

    public int getOluşturulud() {
        return oluşturulud;
    }

    public void setOluşturulud(int oluşturulud) {
        this.oluşturulud = oluşturulud;
    }

    public int getIlkAmirOnayı() {
        return ilkAmirOnayı;
    }

    public void setIlkAmirOnayı(int ilkAmirOnayı) {
        this.ilkAmirOnayı = ilkAmirOnayı;
    }

    public int getMüdürOnayı() {
        return müdürOnayı;
    }

    public void setMüdürOnayı(int müdürOnayı) {
        this.müdürOnayı = müdürOnayı;
    }

    public int getKaizenRehberOnayı() {
        return kaizenRehberOnayı;
    }

    public void setKaizenRehberOnayı(int kaizenRehberOnayı) {
        this.kaizenRehberOnayı = kaizenRehberOnayı;
    }

    public int getKaizenMüdür() {
        return kaizenMüdür;
    }

    public void setKaizenMüdür(int kaizenMüdür) {
        this.kaizenMüdür = kaizenMüdür;
    }

    public int getTamamlandı() {
        return tamamlandı;
    }

    public void setTamamlandı(int tamamlandı) {
        this.tamamlandı = tamamlandı;
    }

    public int getReddedildi() {
        return reddedildi;
    }

    public void setReddedildi(int reddedildi) {
        this.reddedildi = reddedildi;
    }

    public int getKabuledildi() {
        return kabuledildi;
    }

    public void setKabuledildi(int kabuledildi) {
        this.kabuledildi = kabuledildi;
    }

  
   
}
