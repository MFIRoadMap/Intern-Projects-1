

#include <SPI.h>     //haberleşme 
#include <MFRC522.h> //rfid kart okumak 
int SS_PIN=10;
int RST_PIN=9;         //reset pini

//rfid kartı tanımlıyoruz ve kartımıza rfid adını verdik
MFRC522 rfid(SS_PIN, RST_PIN);
void setup() {
  Serial.begin(9600);
  SPI.begin(); //SPI haberleşmesini başlattık.
  rfid.PCD_Init(); //RFID Kart okuyucuyu başlattık.
}

 // id numaramız 4 bayttan oluşuyor ve burada da id numaramızı alıyoruz
void loop() {
  if (rfid.PICC_IsNewCardPresent()) {
    if (rfid.PICC_ReadCardSerial()) {
      Serial.print(rfid.uid.uidByte[0]);
      Serial.print(rfid.uid.uidByte[1]);
      Serial.print(rfid.uid.uidByte[2]);
      Serial.println(rfid.uid.uidByte[3]);
    }
    rfid.PICC_HaltA();
  }
}
