package com.tylerlyczak.vaporstream_codetest

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


/**
 * PersonDao
 *  Defines a Dao interface to interact with the Room database
 */
@Dao
interface PersonDao {

    @Insert
    suspend fun insert(person: Person)

    @Delete
    suspend fun delete(person: Person)

    @Query("DELETE FROM person_table")
    suspend  fun deletePersons()

    @Query("SELECT * FROM person_table ORDER BY uid DESC")
    fun getAllPeople() : Flow<List<Person>>
}