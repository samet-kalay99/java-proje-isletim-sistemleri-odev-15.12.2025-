package com.ornek.multiprocessing; // Hata loguna göre paket adınız bu

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

// DÜZELTME: Sınıf adı dosya adıyla (Multiprocessing.java) aynı yapıldı (Büyük M).
public class Multiprocessing {

    public static void main(String[] args) throws IOException, InterruptedException {
        
        // Bu program kendi kopyasını "Yavru İşlem" (Child Process) olarak başlatır.
        if (args.length > 0 && args[0].equals("calis")) {
            // --- İŞÇİ İŞLEM (WORKER PROCESS) ---
            calis(args[1]); 
        } else {
            // --- YÖNETİCİ İŞLEM (MAIN PROCESS) ---
            System.out.println("=== Paralel İşlem (Multiprocessing) Başlatılıyor ===");
            // JDK 9 ve üzeri gerektirir
            System.out.println("Yönetici İşlem PID: " + ProcessHandle.current().pid());
            System.out.println("----------------------------------------------------");

            // İki yeni işlem başlatıyoruz
            Process p1 = yeniIslemBaslat("İşlem-A");
            Process p2 = yeniIslemBaslat("İşlem-B");

            // Yavruların bitmesini bekle
            p1.waitFor();
            p2.waitFor();
            
            System.out.println("----------------------------------------------------");
            System.out.println("Tüm paralel işlemler tamamlandı.");
        }
    }

    private static Process yeniIslemBaslat(String islemAdi) throws IOException {
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");
        
        // DÜZELTME: Sınıf ismini dinamik olarak alıyoruz, böylece hata olmaz.
        String className = Multiprocessing.class.getName(); 

        ProcessBuilder builder = new ProcessBuilder(
                javaBin, "-cp", classpath, className, "calis", islemAdi);

        builder.redirectOutput(Redirect.INHERIT);
        builder.redirectError(Redirect.INHERIT);

        return builder.start();
    }

    private static void calis(String ad) {
        long pid = ProcessHandle.current().pid();
        System.out.println("BASLADI -> " + ad + " (PID: " + pid + ") çalışıyor.");

        try {
            // İşlemciyi meşgul etme simülasyonu (2 saniye)
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("BITTI   -> " + ad + " (PID: " + pid + ") görevini tamamladı.");
    }
}