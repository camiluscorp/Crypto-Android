package com.example.coincapapp.views

import androidx.compose.foundation.background
import com.example.coincapapp.ui.theme.Typography
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.coincapapp.models.Asset
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.coincapapp.viewModels.AssetListViewModel


@Composable
fun AssetList() {
//fun AssetList(viewModel: AssetListViewModel = hiltViewModel()) {
    //var assets = viewModel.assets.collectAsState()

    /*LazyColumn(
        modifier = Modifier.fillMaxHeight()
            .background(MaterialTheme.colorScheme.onBackground)
             .padding(WindowInsets.systemBars.asPaddingValues())
    ) {
//        items(assets) { asset ->
//            AssetRow(asset)
//
//        }
    }*/

    Column(
        modifier = Modifier.fillMaxHeight()
            .background(MaterialTheme.colorScheme.onBackground)
            .padding(WindowInsets.systemBars.asPaddingValues())
    ) {
        AssetRow(Asset(
            id = "bitcoin",
            name = "Bitcoin",
            symbol = "BTC",
            percentage = 5.38,
            price = "5000"

        ))

        HorizontalDivider()

        AssetRow(Asset(
            id = "ethereum",
            name = "Ethereum",
            symbol = "ETH",
            percentage = -5.38,
            price = "3000"

        ))
    }
}




@Composable
fun AssetRow(asset: Asset) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            if (LocalInspectionMode.current) {
                Icon(
                    imageVector = Icons.Filled.CheckCircle,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            } else {
                AsyncImage(
                    model = "https://assets.coincap.io/assets/icons/${asset.symbol.lowercase()}@2x.png",
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }
        }




        Column {
            Text(
                text = asset.symbol,
                fontSize = 18.sp,
                color = Color.White
            )
            Text(
                text = asset.name,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "${asset.percentage}%",
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 16.dp),
            color = if(asset.percentage >= 0) Color.Green else Color.Red,
            style = Typography.labelLarge
        )

        Text(
            text = asset.price,
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 16.dp),
            color = Color.White,
            style = Typography.labelLarge
        )

    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)

@Composable
fun AssertRowPreview() {
   // Column(
   //     verticalArrangement = Arrangement.Center,
   //     modifier = Modifier.fillMaxSize()
   // ) {
        AssetList()
//        AssetRow(Asset(
//            id = "1",
//            name = "Bitcoin",
//            symbol = "BTC",
//            percentage = 5.38,
//            price = "5000"
//
//        ))
//        Spacer(modifier = Modifier.size(16.dp))
//        AssetRow(Asset(
//            id = "2",
//            name = "Ethereum",
//            symbol = "ETH",
//            percentage = -5.38,
//            price = "2000"
//
//        ))
        //AssetRow()
        //Spacer(modifier = Modifier.size(16.dp))
        //AssetRow()

    //}
}