package com.ornek.amdahlanaliz; 

import java.util.Scanner;

public class AmdahlAnaliz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== AMDAHL YASASI HESAPLAYICI ===");
        System.out.println("Bu program, işlemci sayısı arttıkça kazanılacak");
        System.out.println("maksimum hızlanmayı hesaplar.\n");

        System.out.print("Programın paralelleştirilebilir oranı nedir? (Örn: 0.90 veya 0,90): ");
        
        double p = 0;
        
        try {
            String giris = scanner.next();
            
            giris = giris.replace(",", ".");

            p = Double.parseDouble(giris);
            
        } catch (NumberFormatException e) {
            System.out.println("\n!!! HATA: Lütfen geçerli bir sayı giriniz (Örn: 0.90) !!!");
            return; 
        }
        
        if (p < 0 || p >= 1) {
            System.out.println("\n!!! HATA: Oran 0 ile 1 arasında olmalıdır (0.95 gibi). !!!");
            return;
        }

        double s = 1 - p;
        
        System.out.println("\n--------------------------------------------------");
        System.out.println("PROGRAM ANALİZİ:"); // Artık burayı göreceksiniz
        System.out.println(" - Paralel Kısım: %" + (int)(p * 100));
        System.out.println(" - Seri Kısım   : %" + (int)(s * 100));
        System.out.println("--------------------------------------------------");
        System.out.printf("%-15s | %-15s\n", "İşlemci Sayısı", "Hızlanma");
        System.out.println("--------------------------------------------------");

        int[] cekirdekSayilari = {1, 2, 4, 8, 16, 32, 64, 128, 1024};

        for (int n : cekirdekSayilari) {
            double speedup = 1.0 / (s + (p / n));
            System.out.printf("%-15d | %-10.2fx \n", n, speedup);
        }
    }
}