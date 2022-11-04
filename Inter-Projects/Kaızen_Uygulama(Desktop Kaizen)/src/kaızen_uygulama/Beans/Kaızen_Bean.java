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
public class Kaızen_Bean {
    public String K_Id,K_Adı,K_Konu,K_Bas_Tarh;
    
    public Kaızen_Bean(String K_Id,String K_Adı,String K_Konu,String K_Bas_Tarh){
        this.K_Id=K_Id;
        this.K_Adı=K_Adı;
        this.K_Konu=K_Konu;
        this.K_Bas_Tarh=K_Bas_Tarh;
        
        
        
    }

    public String getK_Id() {
        return K_Id;
    }

    public String getK_Adı() {
        return K_Adı;
    }

    public String getK_Konu() {
        return K_Konu;
    }

    public String getK_Bas_Tarh() {
        return K_Bas_Tarh;
    }

   
}
