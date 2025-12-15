# java-proje-isletim-sistemleri-odev-15.12.2025-
1. Proje: Zaman Paylaşımı Simülasyonu (Multithreading)
Dosya Adı: Multiprogramming.java
🕒 Tek İşlemci Zaman Paylaşımı (Time-Sharing Simulation)
Bu proje, işletim sistemlerinin tek bir işlemci çekirdeğini kullanarak birden fazla programı nasıl "aynı anda çalışıyormuş gibi" gösterdiğini simüle eder.

📌 Nasıl Çalışır?

Java'nın Thread yapısı kullanılarak iki farklı sanal program oluşturulmuştur.

Thread.sleep() fonksiyonu ile işlemci, çalışan programı kısa süre bekletip diğer programa geçiş yapar (Context Switching).

Bu sayede işlemci, milisaniyeler içinde görevler arasında geçiş yaparak Eş Zamanlılık (Concurrency) sağlar.

👀 Gözlemlenen Çıktı: İki programın çıktı satırları birbirine karışık halde ekrana gelir. Bu, işlemcinin zamanı paylaştığını kanıtlar.

2. Proje: Çoklu İşlemci Paralel Çalışma (Multiprocessing)
Dosya Adı: Multiprocessing.java

🚀 Çoklu İşlemci ve Paralel Çalışma (Multiprocessing)
Bu proje, işletim sisteminin birden fazla çekirdeğini kullanarak görevleri gerçekten aynı anda (paralel) nasıl çalıştırdığını gösterir.

📌 Nasıl Çalışır?

Java ProcessBuilder kullanılarak, ana programdan bağımsız çalışan "Yavru İşlemler" (Child Processes) oluşturulur.

Her işlemin işletim sistemi tarafından atanan benzersiz bir Process ID (PID) değeri vardır.

ProcessHandle API'si kullanılarak bu işlemlerin farklı kimliklere sahip olduğu doğrulanır.

👀 Gözlemlenen Çıktı: İşlemler aynı anda başlar ve birbirini beklemeden çalışır. Konsolda her işlemin farklı bir PID'ye sahip olduğu görülür.

Gereksinim: Bu kodun çalışması için JDK 9 veya üzeri gereklidir.

3. Proje: Thread ve Process Karşılaştırması (Concurrency vs Parallelism)
Dosya Adı: Multitogether.java

🆚 Thread ve Process Karşılaştırması (Thread vs Process)
Bu proje, İşletim Sistemleri dersindeki iki temel kavramı tek bir uygulamada karşılaştırmalı olarak gösterir: Multithreading (İş Parçacıkları) ve Multiprocessing (Çoklu İşlem).

📌 İçerik:

Bölüm 1 (Multithreading): Tek bir PID altında çalışan Thread'lerin işlemci zamanını paylaştığını gösterir. PID'ler aynıdır, sadece Thread ID'ler değişir.

Bölüm 2 (Multiprocessing): Farklı PID'lere sahip bağımsız süreçlerin, farklı çekirdeklerde paralel olarak çalıştığını gösterir.

👀 Gözlemlenen Çıktı:

İlk kısımda Aynı PID, karışık çalışma sırası.

İkinci kısımda Farklı PID'ler, gerçek paralel çalışma.

Gereksinim: Bu kodun çalışması için JDK 9 veya üzeri gereklidir.
