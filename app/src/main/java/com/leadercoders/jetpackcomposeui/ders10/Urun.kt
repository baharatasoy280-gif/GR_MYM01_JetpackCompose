package com.leadercoders.jetpackcomposeui.ders10

// 1. Ürün Veri Sınıfı (Data Class)
data class Urun(
    val id: Int,
    val ad: String,
    val aciklama: String,
    val fiyat: Double,
    val puan: Double,
    val kargoBedava: Boolean
)

// 2. Örnek Ürün Listesi
val tumUrunler = listOf(
    Urun(1, "Kablosuz Kulaklık X-Pro", "Aktif gürültü engelleme, 24 saat şarj", 1450.0, 4.8, true),
    Urun(2, "Akıllı Saat S3", "Nabız ölçer, su geçirmez, çelik kordon", 2100.0, 4.5, true),
    Urun(3, "Mekanik Klavye K1", "RGB aydınlatmalı, kırmızı switch", 850.0, 4.2, false),
    Urun(4, "Oyuncu Faresi M4", "10000 DPI, ergonomik tasarım", 450.0, 4.7, false),
    Urun(5, "Tablet 10 inç", "64 GB hafıza, 8 GB RAM", 3200.0, 4.9, true)
)
