/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magza_desktop;

import com.fazecast.jSerialComm.SerialPort;
import java.io.*;
import java.util.*;

/**
 *
 * @author furka
 */
public class Detecter {

    public String kartOku() {
        String result = "";
        int sayac = 0;
        SerialPort port = SerialPort.getCommPort("COM5");
        port.setBaudRate(9600);

        if (port.openPort()) {
            System.out.println("bağlanyı kuruldu");
        } else {
            System.out.println("kurulamadı");
        }
        Scanner data = new Scanner(port.getInputStream());

        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);

        while (sayac != 1) {
            result += data.nextLine();

            if (!result.equals("")) {
                sayac = 1;
            }
        }
        port.closePort();
        //burada boş karakterleri kaldırarak gönderiyorum
        result = result.replace(" ", "");
        return result;
    }

    //ilk olarak hazırladığım barkod okuma metodu.Geçici olarak kullanıyordum artık sadece ürün kaydı için kullanıyorum
    public String barkodOku() {
        String result = "";
        int sayac = 0;
        SerialPort port = SerialPort.getCommPort("COM4");
        port.setBaudRate(9600);

        if (port.openPort()) {
        } else {
        }
        Scanner data = new Scanner(port.getInputStream());
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        while (sayac != 1) {
            result += data.nextLine();

            if (!result.equals("")) {
                sayac = 1;
            }
        }
        port.closePort();
        //burada boş karakterleri kaldırarak gönderiyorum
        result = result.replace(" ", "");
        return result;
    }

    public boolean Sayi_Mi(String Metin) {

        boolean result = true;
        for (int i = 0; i < Metin.length(); i++) {
            if (!Character.isDigit(Metin.charAt(i))) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean Ondalik_Mi(String Metin) {

        boolean result = true;
        for (int i = 0; i < Metin.length(); i++) {
            if (!Character.isDigit(Metin.charAt(i)) && Metin.charAt(i) != '.') {
                result = false;
                break;
            }
        }
        return result;
    }
    /*
    //Burası ses efekti eklemek için şimdilik iptal edildi
    public void Ses_Modul(String Path) {
        InputStream muzikal;
        try {
            InputStream yolal = new FileInputStream(new File(Path));
            AudioStream muzik = new AudioStream(yolal);
            AudioPlayer.player.start(muzik);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Kasa_Sayfasi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Kasa_Sayfasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
}
