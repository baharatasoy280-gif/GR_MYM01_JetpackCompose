package com.leadercoders.jetpackcomposeui.ders3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp



@Composable
fun D333_ButonCesitleri() {
    Column(modifier = Modifier.padding(24.dp)) {
        //Dolu Buton
        Button(onClick = { println("Sepete ekle butonuna basıldı") }) {
            Text("Sepete Ekle ")

        }

        HorizontalDivider(
            thickness = 1.dp,
            color = Color.Blue,
            modifier = Modifier.padding(vertical = 16.dp)



        )

        OutlinedButton(onClick = { println("İptal et butonuna basıldı") }) {
            Text("İptal et")


        }

        Spacer(modifier = Modifier.padding(20.dp))


        TextButton(onClick = {}) {
            Text("Şifremi unuttum!")
        }


        //Yanyana eşit paylaşımlı button

        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedButton(
                onClick = {},
                modifier = Modifier.weight(1f)

            ) {
                Text("Vazgeç")

            }

            Button(
                onClick = {},
                modifier = Modifier.weight(2f)
            ) {
                Text("Onayla")

            }

        }

        Spacer(modifier = Modifier.weight(1f))

        //Tam genişlikte renki button
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color(0xFFE91E63))

        ) {
            Text("Tam genişlikte button ")


        }


    }
}