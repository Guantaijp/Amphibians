package com.example.amphibians.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.network.Amphibian
import com.example.amphibians.network.AmphibianApi
import kotlinx.coroutines.launch
import java.lang.Exception

enum class AmphibianApiStatus {LOADING, ERROR, DONE}

class AmphibianViewModel :ViewModel(){

    private val _status: MutableLiveData<AmphibianApiStatus> = MutableLiveData()
    val status: LiveData<AmphibianApiStatus> = _status

    private val _amphibians:MutableLiveData<List<Amphibian>> = MutableLiveData()
    val amphibians :LiveData<List<Amphibian>> = _amphibians

    private val _amphibian: MutableLiveData<Amphibian> = MutableLiveData()
    val  amphibian: LiveData<Amphibian> =_amphibian

    fun getAmphibianList(){
        viewModelScope.launch {
            _status.value = AmphibianApiStatus.LOADING
            try {
                _amphibians.value = AmphibianApi.retrofitService.getAmphibianList()
                _status.value = AmphibianApiStatus.DONE
            }catch (e:Exception){
                _amphibians.value = emptyList()
                _status.value = AmphibianApiStatus.ERROR
            }
        }
    }

    fun onAmphibianClicked(amphibian: Amphibian){
_amphibian.value = amphibian
    }
}