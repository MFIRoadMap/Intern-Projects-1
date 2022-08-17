package staj.proje;

import java.io.File;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oracle.jdbc.driver.OracleDriver;

public class STAJPROJE {

    public static void main(String[] args) {

    }

    public Connection getConnection_kart_db() {
        Connection con = null;
        String url, kullanıcıAdı, şifre;
        url = "jdbc:oracle:thin:@localhost:1521:xe";
        kullanıcıAdı = "KART_DB";
        şifre = "123456789";
        try {

            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            con = DriverManager.getConnection(url, kullanıcıAdı, şifre);

            

            return con;
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Not Connected");
            return null;
        }
    }

    public Connection getConnection_sağlık_db() {
        Connection con2 = null;
        String url, kullanıcıAdı, şifre;
        url = "jdbc:oracle:thin:@localhost:1521:xe";
        kullanıcıAdı = "SAĞLIK_DB";
        şifre = "123456";

        try {

            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            con2 = DriverManager.getConnection(url, kullanıcıAdı, şifre);


            return con2;
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Not Connected");
            return null;
        }
    }
//dosya içindeki ıd numarasını okuyorum ve ındex sayfasından bu bilgiyi alıyorum

    public String dosyaIdOkuma() {

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

    public void dosyaSilOlultur() {

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
