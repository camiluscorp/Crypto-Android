package com.example.coincapapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coincapapp.models.Asset
import com.example.coincapapp.services.CoinCapApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AssetListViewModel  @Inject constructor(
    private val apiService: CoinCapApiService
): ViewModel() {

    private val _assets = MutableStateFlow<List<Asset>>(emptyList())
    val assets: StateFlow<List<Asset>> = _assets

    init {
        fetchAssets()
    }

    private fun fetchAssets() {
        viewModelScope.launch {
            try {
                val result = apiService.getAssets().data
                //_assets.value = result.data
                val mappedAssets = result.map{ assetResponse ->
                    //val price = assetResponse.priceUsd.format("%.2f").toDouble()
                    //val percentage = assetResponse.changePercent24Hr.format("%.2f").toDouble()
                    val price = String.format("%.2f", assetResponse.priceUsd.toDouble())
                    val percentage = String.format("%.2f", assetResponse.changePercent24Hr.toDouble()).toDouble()

                    Asset(
                        assetResponse.id,
                        assetResponse.name,
                        assetResponse.symbol,
                        price,//assetResponse.priceUsd,
                        percentage

                    )
                }

                _assets.emit(mappedAssets)
            } catch (e: Exception) {
                //TODO: handle error
                print(e.message)
            }
        }
    }

}