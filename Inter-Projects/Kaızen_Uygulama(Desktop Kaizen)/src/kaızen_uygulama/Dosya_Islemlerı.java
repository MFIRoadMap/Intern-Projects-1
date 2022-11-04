/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaızen_uygulama;

import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author MFİ
 */
public class Dosya_Islemlerı {
     public String Dosyadan_Id_Numarası_Okuma() {

        String value;
        String filename;
        Scanner in;
        File dosya;
        value = "";

        try {
            filename = "C:/Users/MFİ/Desktop/text.txt";

            dosya = new File(filename);
            in = new Scanner(dosya);
            value = in.nextLine();

            while (in.hasNext()) {
                value = in.nextLine();
            }

            in.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, "lütfen kartınızı okutunuz");
            //giriş  sayfası için dosyaya ıd girilene kadar tekrar çağırılabilir
        }
        
        return value;
    }

        public void Dosya_Silme_Oluşturma() {

        File silinecekDosya;

        try {
            silinecekDosya = new File("C:/Users/MFİ/Desktop/text.txt");

            // Dosyanin mevcut olup olmadigini kontrol et.
            if (!silinecekDosya.exists()) {
                System.out.println("dosya yolu boş");
            }

            if (silinecekDosya.delete()) {
                System.out.println("Dosya Başarı İle Silindi.");
            } else {
                System.out.println("Silme İşlemi Başarısız!");
            }

            //dosyayı yeniden oluşturdum
            silinecekDosya.createNewFile();
            System.out.println("dosya oluşturuldu");

        } catch (Exception e) {

        }

    }
}
