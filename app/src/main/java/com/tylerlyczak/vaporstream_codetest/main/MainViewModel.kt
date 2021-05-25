package com.tylerlyczak.vaporstream_codetest.main

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tylerlyczak.vaporstream_codetest.R
import java.util.*
import kotlin.collections.ArrayList
import kotlin.coroutines.coroutineContext

class MainViewModel : ViewModel() {
    // Stores boolean values for checking the data live
    private val boolList: ArrayList<Boolean> = ArrayList(6)

    // init the list
    init {
        for (i in 0..5) boolList.add(false)
    }

    val currentFirstName: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }

    val currentLastName: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }

    val currentPhoneNumber: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }

    val currentAddressOne: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }

    val currentAddressTwo: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }

    val currentCity: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }

    val currentZipCode: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }

    val currentSpinner: MutableLiveData<List<String>> by lazy {
        MutableLiveData<List<String>>()
    }

    // Initializes the spinner
    fun initSpinner(context: Context) : LiveData<List<String>> {
        currentSpinner.value = ArrayList(context.resources.getStringArray(R.array.states_array).toMutableList())
        return currentSpinner
    }

    // Variable checker that is tied to submit that constantly checks the edittext fields
    val valid = MediatorLiveData<Boolean>().apply {
        addSource(currentFirstName) {
            boolList[0] = (it != "")
            value = checkList()
        }
        addSource(currentLastName)  {
            boolList[1] = (it != "")
            value = checkList()
        }
        addSource(currentPhoneNumber)   {
            boolList[2] = it.matches(Regex("[0-9]+")) && it.length == 10
            value = checkList()
        }
        addSource(currentAddressOne)    {
            boolList[3] = (it != "")
            value = checkList()
        }
        addSource(currentCity)    {
            boolList[4] = (it != "")
            value = checkList()
        }
        addSource(currentZipCode)   {
            boolList[5] = it.matches(Regex("[0-9]+")) && it.length == 5
            value = checkList()
        }
    }

    private fun checkList(): Boolean {

        boolList.forEach {
            if (!it)    return false
        }
        return true
    }
}