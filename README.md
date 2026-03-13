# HyperLogLog - Büyük Veri Analitiğinde Olasılıksal Veri Yapıları

Bu proje, Algoritma Analizi ve Tasarımı ödevi kapsamında hazırlanmıştır.  
Amaç, büyük veri kümelerinde **unique (benzersiz) eleman sayısını tahmin etmek** için HyperLogLog algoritmasını sıfırdan kodlamaktır.

---

##  Kullanılan Teknolojiler

- Programlama Dili: Java 17  
- IDE: IntelliJ IDEA 2025.2  
- Algoritma: HyperLogLog (HLL)  
- Özellikler: Hashing, Bucketing, Leading Zeros, Harmonik Ortalama, Small Range Correction, Merge Fonksiyonu  

---

## Proje Özeti

HyperLogLog, çok büyük veri kümelerinde az bellek kullanarak unique eleman sayısını tahmin etmek için olasılıksal bir algoritmadır.  

Projede aşağıdaki adımlar uygulanmıştır:

1. Hash Fonksiyonu: Elemanlar sayısal değere dönüştürülür.  
2. Bucketing Mekanizması: Her eleman için hangi bucket’a kaydedileceğine karar verilir.  
3. Register ve Leading Zeros: Hash değerindeki ardışık sıfır sayısı hesaplanır ve bucket register’ına kaydedilir.  
4. Tahmin Hesaplama: Harmonik ortalama formülü ile toplam tahmin hesaplanır.  
5. Small Range Correction: Küçük veri setlerinde aşırı tahminleri düzeltir.  
6. Merge Özelliği: İki farklı HLL nesnesi kayıpsız bir şekilde birleştirilebilir.

---

## Örnek Çıktılar

Kodun çalıştırılmasıyla farklı veri setleri için tahmin ve hata yüzdesi hesaplanmaktadır:

| Real Unique | Estimated | Error % |
|------------|-----------|---------|
| 1,000      | 1,040     | 4%      |
| 10,000     | 10,250    | 2%      |
| 50,000     | 49,800    | 0.4%    |

> Not: Küçük veri kümelerinde tahmin hatası doğal olarak daha yüksek olabilir; small range correction uygulanmıştır.

---

##  Nasıl Çalıştırılır?

1. Repo’yu klonlayın:
```bash
git clone https://github.com/kullaniciadi/HyperLogLog.git
