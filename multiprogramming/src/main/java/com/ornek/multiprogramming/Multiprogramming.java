/*
 * DİKKAT: Paket ismini (package) NetBeans dosyanızın en tepesinde
 * halihazırda ne yazıyorsa o şekilde bırakın.
 * Hata logunuza göre muhtemelen şöyledir:
 */
package com.ornek.multiprogramming; 

class SanalProgram extends Thread {
    private String programIsmi;

    public SanalProgram(String isim) {
        this.programIsmi = isim;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                System.out.println("[CPU] " + programIsmi + " çalıştırılıyor... (Adım " + i + ")");
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                System.out.println(programIsmi + " kesintiye uğradı.");
            }
        }
        System.out.println(">>> " + programIsmi + " TAMAMLANDI. <<<");
    }
}

// DÜZELTME BURADA YAPILDI: 'm' harfi 'M' oldu.
public class Multiprogramming { 

    public static void main(String[] args) {
        System.out.println("=== İşletim Sistemi Multiprogramming Simülasyonu Başladı ===\n");

        SanalProgram p1 = new SanalProgram("Program 1 (Word)");
        SanalProgram p2 = new SanalProgram("Program 2 (Medya Oynatıcı)");

        p1.start();
        p2.start();
    }
}