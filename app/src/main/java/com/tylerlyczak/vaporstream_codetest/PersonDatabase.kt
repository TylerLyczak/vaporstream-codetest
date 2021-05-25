package com.tylerlyczak.vaporstream_codetest

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

/**
 * PersonDatabase
 *  Defines a structure to have access to the Dao, but only one instance
 */
@Database(entities = arrayOf(Person::class), version = 1)
public abstract class PersonDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: PersonDatabase? = null

        fun getInstance(context: Context) : PersonDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PersonDatabase::class.java,
                    "person_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

    abstract fun personDao() : PersonDao
}