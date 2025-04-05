package com.example.coincapapp.views


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.coincapapp.models.Asset

@Composable
fun PersonalDesignRow(asset: Asset) {
Box(
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 3.dp)
        .size(100.dp)
        .border(2.dp, Color.Gray, shape = RoundedCornerShape(12.dp))
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
//        Icon(
//            imageVector = Icons.Filled.CheckCircle,
//            contentDescription = null,
//            tint = Color.Red,
//            modifier = Modifier.padding(horizontal = 8.dp)
//        )

        AsyncImage(
            model = "https://assets.coincap.io/assets/icons/${asset.symbol.lowercase()}@2x.png",
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .size(60.dp)

        )



        Column {
            Text(
                text = asset.name,
                fontSize = 25.sp
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = asset.price,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.weight(0.5f))

                Text(
                    text = "${asset.percentage}%",
                    fontSize = 14.sp,
                    color = if (asset.percentage >= 0) Color.Green else Color.Red
                )

                Icon(
                    imageVector = if (asset.percentage >= 0) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    tint = if (asset.percentage >= 0) Color.Green else Color.Red
                )

            }


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(64.dp)
                    .background(Color.LightGray) // Opcional para ver el placeholder
            ) {
                Text(
                    text = "Aqui va el grafico"
                )
            }
        }
    }
}
}

@Preview(
    showBackground = true,
    showSystemUi = true
)

@Composable
fun PersonalDesignRowPreview() {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        PersonalDesignRow(
            Asset(
                id = "1",
                name = "Bitcoin",
                symbol = "BTC",
                percentage = 5.38,
                price = "5000"

            )
        )

        Spacer(modifier = Modifier.size(20.dp))

        PersonalDesignRow(
            Asset(
                id = "1",
                name = "ETHEREUM",
                symbol = "ETH",
                percentage = -5.38,
                price = "5000"

            )
        )
    }
}
