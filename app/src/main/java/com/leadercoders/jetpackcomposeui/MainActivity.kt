package com.leadercoders.jetpackcomposeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.leadercoders.jetpackcomposeui.ders4.BizeUlasin
import com.leadercoders.jetpackcomposeui.ders4.D345_GirisYapEkrani
import com.leadercoders.jetpackcomposeui.ders4.theme.GR01_MYM_M3_JetpackComposeUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GR01_MYM_M3_JetpackComposeUITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {

//                   DERS-1
//                    SelamlamaEkrani()

//                       DERS2
                        //                       D322_TemelDizilimler()
                          //                   D326_ProfilKarti()
                        //                      UrunDetayKarti()

                        //Ders3

                     //   D332_TextBileseni()
                      //  D333_ButonCesitleri()

                       // D336_GununSozu()

                      //  D344_KullanicidanVeriAlma()

                      //  D345_GirisYapEkrani()

                       // BizeUlasin()

                       // Proje_KullaniciKayitEkrani()

                        D345_GirisYapEkrani()

                    }

                }
            }
        }
    }
}
