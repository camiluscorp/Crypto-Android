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
                val result = apiService.getAssets()
                _assets.value = result
            } catch (e: Exception) {
                //TODO: handle error
            }
        }
    }

}