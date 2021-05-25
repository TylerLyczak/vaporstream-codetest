package com.tylerlyczak.vaporstream_codetest.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {

    val currentData : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}