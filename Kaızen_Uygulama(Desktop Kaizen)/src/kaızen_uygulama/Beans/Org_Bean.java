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
public class Org_Bean {

    String O_P_ADI, O_P_SOYADI, O_ADI, O_SEVİYE, O_K_ADI,
            O_K_KONU, O_K_BAŞV_TARH, O_K_TAMAM_TAR, O_K_SON_HARK_TAR;

    public Org_Bean(String O_P_ADI, String O_P_SOYADI, String O_ADI, String O_SEVİYE,
            String O_K_ADI, String O_K_KONU, String O_K_BAŞV_TARH, String O_K_TAMAM_TAR,
            String O_K_SON_HARK_TAR) {

        this.O_P_ADI = O_P_ADI;
        this.O_P_SOYADI = O_P_SOYADI;
        this.O_ADI = O_ADI;
        this.O_SEVİYE = O_SEVİYE;
        this.O_K_ADI = O_K_ADI;
        this.O_K_KONU = O_K_KONU;
        this.O_K_BAŞV_TARH = O_K_BAŞV_TARH;
        this.O_K_TAMAM_TAR = O_K_TAMAM_TAR;
        this.O_K_SON_HARK_TAR = O_K_SON_HARK_TAR;
    }

    public String getO_P_ADI() {
        return O_P_ADI;
    }

    public String getO_P_SOYADI() {
        return O_P_SOYADI;
    }

    public String getO_ADI() {
        return O_ADI;
    }

    public String getO_SEVİYE() {
        return O_SEVİYE;
    }

    public String getO_K_ADI() {
        return O_K_ADI;
    }

    public String getO_K_KONU() {
        return O_K_KONU;
    }

    public String getO_K_BAŞV_TARH() {
        return O_K_BAŞV_TARH;
    }

    public String getO_K_TAMAM_TAR() {
        return O_K_TAMAM_TAR;
    }

    public String getO_K_SON_HARK_TAR() {
        return O_K_SON_HARK_TAR;
    }

}
