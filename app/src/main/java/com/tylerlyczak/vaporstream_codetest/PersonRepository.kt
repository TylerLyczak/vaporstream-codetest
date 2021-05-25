package com.tylerlyczak.vaporstream_codetest

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

/**
 *  PersonRepository
 *      Defines a repository to have access to values stored in the Room database,
 *          along with the database functions
 */
class PersonRepository(private val personDao: PersonDao) {

    var allPeople: Flow<List<Person>> = personDao.getAllPeople()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(person: Person) {
        personDao.insert(person)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(person: Person) {
        personDao.delete(person)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deletePersons()  {
        personDao.deletePersons()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getAllPeople() {
        allPeople = personDao.getAllPeople()
    }
}