package com.tylerlyczak.vaporstream_codetest.results

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultsViewModel : ViewModel() {
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

    val currentState: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }

    val currentZipCode: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }

    /*
        updateVals
            Updates the MutableLiveData to a person given
     */
    fun updateVals(person: com.tylerlyczak.vaporstream_codetest.Person)  {
        currentFirstName.value = person.firstName
        currentLastName.value = person.lastName
        currentPhoneNumber.value = person.phoneNumber
        currentAddressOne.value = person.address1
        currentAddressTwo.value = person.address2
        currentCity.value = person.cityName
        currentState.value = person.stateName
        currentZipCode.value = person.zipCode
    }
}