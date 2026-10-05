package com.leadercoders.jetpackcomposeui.ders10

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ETicaretUrunProje(){

    var bedavaKargoOnly by rememberSaveable { mutableStateOf(false) }
    var menuDurumuAcilsin by rememberSaveable() { mutableStateOf(false) }
    var sepetOnayDurum by remember { mutableStateOf(false) }
    var seciliUrun by remember { mutableStateOf<Urun?>(null) }
    var kargosuBedavaUrunler = mutableListOf<Urun>()

    tumUrunler.forEach { urun -> if (urun.kargoBedava) kargosuBedavaUrunler.add(urun)}

    Scaffold( //Scaffold arkaplanı #F3F4F6,
        topBar = {
            TopAppBar(
                title = { Text("Teknoloji Katalogu",modifier = Modifier.padding(top = 16.dp, bottom = 18.dp))},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2462E9),
                    titleContentColor = Color.White, actionIconContentColor = Color.White),
                actions = {

                    Box(){

                        IconButton(onClick = {menuDurumuAcilsin = true}) {
                            Icon(
                                Icons.Default.MoreVert,
                                contentDescription = "Menü"
                            )
                        }

                        DropdownMenu(
                            expanded = menuDurumuAcilsin,
                            onDismissRequest = {menuDurumuAcilsin = false}, // kapancak
                        ) {
                            DropdownMenuItem(
                                text = {Text("Hakkımızda")},
                                onClick = {menuDurumuAcilsin = false}
                            )

                            DropdownMenuItem(
                                text = {Text("Iletişim")},
                                onClick = {menuDurumuAcilsin = false}
                            )
                        }
                    }

                }
            )
        },
        containerColor = Color(0xFFF3F4F6)

    ) { icBosluklar ->


        Column(Modifier
            .fillMaxSize()
            .padding(icBosluklar))
        {

            Card(
                elevation = CardDefaults.cardElevation(8.dp),
                shape = RoundedCornerShape(0.dp)
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text("Sadece Kargo Bedava Ürünler")

                    Switch(
                        checked = bedavaKargoOnly,
                        onCheckedChange = {yeniBedavaKardo -> bedavaKargoOnly = yeniBedavaKardo},
                        colors = SwitchDefaults.colors(
                            uncheckedThumbColor = Color(0xFF2461E6),
                            checkedThumbColor = Color(0xFFFFEB3B)
                        )
                    )
                }
            }

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                contentPadding = PaddingValues(20.dp)
            ) {
                items(
                    if (!bedavaKargoOnly) tumUrunler else kargosuBedavaUrunler
                ){ urun ->

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(24.dp)) {
                            Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                                Text(urun.ad, fontSize = 22.sp, fontWeight = FontWeight.Bold)

                                Row() {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "Yıldız puanı",
                                        tint = if (urun.puan > 4.5) Color(0xFFF59A11) else Color(
                                            0xFFC2BEA0
                                        )
                                    )

                                    Spacer(modifier = Modifier.width(3.dp))

                                    Text("${urun.puan}")
                                }
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Text("${urun.aciklama}", fontSize = 15.sp, fontWeight = FontWeight.Medium,
                                color = Color.Gray)

                            Spacer(modifier = Modifier.height(30.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween)
                            {
                                Text("${urun.fiyat} ₺", fontSize = 25.sp, fontWeight = FontWeight.Bold,
                                    color = Color(0xFF2461E6)
                                )

                                Button(
                                    onClick = {
                                        seciliUrun = urun
                                        sepetOnayDurum = true
                                    },
                                    colors =
                                        ButtonDefaults.buttonColors(containerColor = Color(0xFF0FB881)),
                                    shape = RoundedCornerShape(12.dp),
                                    modifier = Modifier.height(50.dp)
                                )
                                {

                                    Icon(
                                        Icons.Default.ShoppingCart,
                                        contentDescription = "Sepete Ekle",
                                        tint = Color.White
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text("Sepete Ekle")
                                }
                            }
                        }
                    }
                }
            }
        }

        if (sepetOnayDurum){
            AlertDialog(
                onDismissRequest = {sepetOnayDurum == false}, // kapancak
                title = {Text("Sepete Eklensin Mi?")},
                text = {Text("${seciliUrun?.ad} adlı ürünü ${seciliUrun?.fiyat}Tl karşığında sepetinize eklemek üzeresiniz." +
                        "Onaylıyor musunuz?")},
                confirmButton = {
                    Button(
                        onClick = {sepetOnayDurum = false},
                        colors = ButtonDefaults.buttonColors(containerColor =
                            Color(0xFF2360E7))
                    ) {
                        Text("Evet, Ekle", color = Color.White)
                    }
                },
                dismissButton = {
                    TextButton (
                        onClick = {sepetOnayDurum = false}
                    ) {
                        Text("İptal", color = Color.Red)
                    }
                }
            )
        }
    }

}