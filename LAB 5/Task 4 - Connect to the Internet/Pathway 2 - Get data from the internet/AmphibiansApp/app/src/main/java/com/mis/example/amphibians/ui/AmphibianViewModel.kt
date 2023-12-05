package com.mis.example.amphibians.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mis.example.amphibians.network.Amphibian
import com.mis.example.amphibians.network.AmphibiansApi
import kotlinx.coroutines.launch

enum class AmphibianApiStatus {LOADING, ERROR, DONE}

class AmphibianViewModel : ViewModel() {

    // TODO: Create properties to represent MutableLiveData and LiveData for the API status
    private var _apiStatus = MutableLiveData<AmphibianApiStatus>()
    val apiStatus: LiveData<AmphibianApiStatus> get() = _apiStatus

    // TODO: Create properties to represent MutableLiveData and LiveData for a list of amphibian objects
    private var _amphibiansList = MutableLiveData<List<Amphibian>>()
    val amphibiansList: LiveData<List<Amphibian>> get() = _amphibiansList

    // TODO: Create properties to represent MutableLiveData and LiveData for a single amphibian object.
    //  This will be used to display the details of an amphibian when a list item is clicked
    private var _amphibian = MutableLiveData<Amphibian>()
    val amphibian: LiveData<Amphibian> get() = _amphibian

    // TODO: Create a function that gets a list of amphibians from the api service and sets the
    //  status via a Coroutine
    fun getAmphibians() {
        _apiStatus.value = AmphibianApiStatus.LOADING
        viewModelScope.launch {
            try {
                _amphibiansList.value = AmphibiansApi.service.getAmphibiansList()
                _apiStatus.value = AmphibianApiStatus.DONE
            } catch (e: Exception) {
                _apiStatus.value = AmphibianApiStatus.ERROR
            }
        }
    }

    fun onAmphibianClicked(amphibian: Amphibian) {
        // TODO: Set the amphibian object
        _amphibian.value = amphibian
    }
}
