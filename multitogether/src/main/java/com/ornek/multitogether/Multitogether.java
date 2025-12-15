package com.ornek.multitogether; 

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class Multitogether {

    public static void main(String[] args) throws IOException, InterruptedException {
        
        // --- ÇOCUK İŞLEM (WORKER PROCESS) KISMI ---
        if (args.length > 0 && args[0].equals("islem_calistir")) {
            long pid = ProcessHandle.current().pid();
            String isim = args[1];
            System.out.println("   [Process] " + isim + " Çalışıyor | PID: " + pid + " | Çekirdek: Farklı");
            Thread.sleep(2000); 
            return;
        }

        System.out.println("==================================================");
        System.out.println("PART 1: COKLU_PROGRAMLAMA (MULTITHREADING)");
        System.out.println("Açıklama: Aynı işlemci (PID aynı), zaman paylaşımı.");
        System.out.println("==================================================");
        
        coklu_programlama();
        
        Thread.sleep(3000); 

        System.out.println("\n==================================================");
        System.out.println("PART 2: COKLU_ISLEMCI (MULTIPROCESSING)");
        System.out.println("Açıklama: Farklı işlemciler (PID farklı), gerçek paralellik.");
        System.out.println("==================================================");
        
        coklu_islemci();
        
        System.out.println("\n>>> TÜM SİMÜLASYON TAMAMLANDI <<<");
    }

    
    public static void coklu_programlama() {
        Thread t1 = new Thread(new GorevParcacigi("Thread-A"));
        Thread t2 = new Thread(new GorevParcacigi("Thread-B"));

        t1.start();
        t2.start();
    }

    static class GorevParcacigi implements Runnable {
        private String ad;
        public GorevParcacigi(String ad) { this.ad = ad; }

        @Override
        public void run() {
            long pid = ProcessHandle.current().pid();
            long tid = Thread.currentThread().getId(); 
            
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println("   [Thread] " + ad + " | PID: " + pid + " (Aynı) | Thread ID: " + tid + " | Adım: " + i);
                    Thread.sleep(500); 
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    
    public static void coklu_islemci() throws IOException, InterruptedException {
        Process p1 = yeniIslemBaslat("Process-1");
        Process p2 = yeniIslemBaslat("Process-2");

        p1.waitFor();
        p2.waitFor();
    }

    private static Process yeniIslemBaslat(String islemAdi) throws IOException {
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");
        
        
        String className = Multitogether.class.getName();

        ProcessBuilder builder = new ProcessBuilder(
                javaBin, "-cp", classpath, className, "islem_calistir", islemAdi);

        builder.redirectOutput(Redirect.INHERIT);
        builder.redirectError(Redirect.INHERIT);
        return builder.start();
    }
}