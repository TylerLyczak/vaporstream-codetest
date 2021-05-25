package com.tylerlyczak.vaporstream_codetest

import androidx.lifecycle.*
import kotlinx.coroutines.launch

/**
 *  PersonViewModel
 *      Defines a ViewModel for the program to use the functions provided by the database
 */
class PersonViewModel(private val personRepository: PersonRepository) : ViewModel() {

    var allPeople: LiveData<List<Person>> = personRepository.allPeople.asLiveData()

    fun insert(person: Person) = viewModelScope.launch {
        personRepository.insert(person)
    }

    fun delete(person: Person) = viewModelScope.launch {
        personRepository.delete(person)
    }

    fun deletePersons() = viewModelScope.launch {
        personRepository.deletePersons()
    }

    fun getAllPeople() = viewModelScope.launch {
        personRepository.getAllPeople()
    }
}

class PersonViewModelFactory(private val personRepository: PersonRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersonViewModel::class.java))   {
            return PersonViewModel(personRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}