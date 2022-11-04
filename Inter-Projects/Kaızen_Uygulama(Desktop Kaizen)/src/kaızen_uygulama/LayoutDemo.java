/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaızen_uygulama;

import java.awt.Color;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.border.TitledBorder;

public class LayoutDemo extends JFrame {

    //frame ayarlarını ypatık
    public LayoutDemo(int veri1, int veri2, int veri3, int veri4, int veri5, int veri6, int veri7, int veri8) {

        this.setTitle("LayoutDemo Test");
        this.setSize(900, 700);
        this.setLayout(null);
        BilesenleriEkle(this.getContentPane(), veri1, veri2, veri3, veri4, veri5, veri6, veri7, veri8);
        this.setVisible(true);
    }

    //burada parametre olarak aldım ve grafik biçiminde gösterdim kaizenlerinin durmunu
    public static void BilesenleriEkle(Container pencere, int oluş, int ilkAmir, int müdür, int kaizRehb,
             int kaizMüdür, int tamamlamdı, int red, int kabul) {

        
        int toplam=oluş+ilkAmir+müdür+kaizRehb+kaizMüdür+tamamlamdı+red+kabul;
        final int maxseviye=600;
        
        JPanel veri1 = new JPanel();

        JPanel veri2 = new JPanel();

        JPanel veri3 = new JPanel();

        JPanel veri4 = new JPanel();

        JPanel veri5 = new JPanel();

        JPanel veri6 = new JPanel();

        JPanel veri7 = new JPanel();

        JPanel veri8 = new JPanel();

        JLabel jl_ad = new JLabel("YENİ OLUŞTURULAN");

        JLabel j2_ad = new JLabel("İLK AMİR");

        JLabel j3_ad = new JLabel("MÜDÜR");

        JLabel j4_ad = new JLabel("KAİZEN REHBER");

        JLabel j5_ad = new JLabel("KAİZEN MÜDÜR");

        JLabel j6_ad = new JLabel("TAMAMLANDI");

        JLabel j7_ad = new JLabel("RED EDİLEN");

        JLabel j8_ad = new JLabel("KABUL EDİLEN");

        pencere.add(veri1);

        veri1.setBackground(Color.BLUE);

        veri1.setBounds(150, 100, (oluş*maxseviye)/toplam, 20);

        pencere.add(jl_ad);

        jl_ad.setBounds(15, 100, 130, 30);

        pencere.add(veri2);

        veri2.setBackground(Color.GREEN);

        veri2.setBounds(150, 150, (ilkAmir*maxseviye)/toplam, 20);

        pencere.add(j2_ad);

        j2_ad.setBounds(15, 150, 130, 30);

        pencere.add(veri3);

        veri3.setBackground(Color.RED);

        veri3.setBounds(150, 200, (müdür*maxseviye)/toplam, 20);

        pencere.add(j3_ad);

        j3_ad.setBounds(15, 200, 130, 30);

        pencere.add(veri4);

        veri4.setBackground(Color.RED);

        veri4.setBounds(150, 250,  (kaizRehb*maxseviye)/toplam, 20);

        pencere.add(j4_ad);

        j4_ad.setBounds(15, 250, 130, 30);

        pencere.add(veri5);

        veri5.setBackground(Color.YELLOW);

        veri5.setBounds(150, 300,  (kaizMüdür*maxseviye)/toplam, 20);

        pencere.add(j5_ad);

        j5_ad.setBounds(15, 300, 130, 30);

        pencere.add(veri6);

        veri6.setBackground(Color.CYAN);

        veri6.setBounds(150, 350, (tamamlamdı*maxseviye)/toplam, 20);

        pencere.add(j6_ad);

        j6_ad.setBounds(15, 350, 130, 30);

        pencere.add(veri7);

        veri7.setBackground(Color.YELLOW);

        veri7.setBounds(150, 400, (red*maxseviye)/toplam, 20);

        pencere.add(j7_ad);

        j7_ad.setBounds(15, 400, 130, 30);

        pencere.add(veri8);

        veri8.setBackground(Color.CYAN);

        veri8.setBounds(150, 450, (kabul*maxseviye)/toplam, 20);

        pencere.add(j8_ad);

        j8_ad.setBounds(15, 450, 130, 30);

    }

    public static void main(String[] args) {

        new LayoutDemo(50, 100, 25, 36, 45, 98, 74, 52);

    }

}
