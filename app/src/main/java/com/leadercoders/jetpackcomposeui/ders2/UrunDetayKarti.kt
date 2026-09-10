package com.leadercoders.jetpackcomposeui.ders2
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UrunDetayKarti() {

    Column(//Tüm Ekran
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFEAE1FC))
            .padding(16.dp)
    ) {

        Box(//Ürün Görseli
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .background(color = Color.White, shape = RoundedCornerShape(12.dp))
                .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(12.dp))
                .padding(24.dp)


        ) {

            Text("\uD83D\uDCF8 Ürün Görseli", color = Color.Black, fontSize = 20.sp)


        }

        Spacer(modifier = Modifier
            .height(16.dp))


        Row(//Ürün adı ve fiyat

        ) {
            Text("Ürün adı: ", color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Medium)
            Text("Akıllı Saat", color = Color.Black, fontSize = 18.sp)
            Spacer(modifier = Modifier.weight(1f))
            Text("Fiyat: ", color = Color.Black, fontSize = 18.sp,fontWeight = FontWeight.Medium)
            Text(
                "1500 TL", color = Color(
                    0xFF2E7D32
                ), fontSize = 18.sp
            )
        }

        //Sahte Buton
        Spacer(modifier = Modifier.weight(1f))
        Text(
            "Sepete Ekle ", modifier = Modifier
                .background(
                    color = Color(
                        0xFF2563EB
                    ), shape = RoundedCornerShape(8.dp)
                )
                .padding(16.dp), color = Color.White
        )
    }

}